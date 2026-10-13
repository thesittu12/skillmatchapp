package com.skillmatchapp;

import com.skillmatchapp.entity.Job;
import com.skillmatchapp.entity.User;
import com.skillmatchapp.Repository.JobRepository;
import com.skillmatchapp.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
public class MatchController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JobRepository jobRepository;

    // DTO class match percentage ke sath data bhejne ke liye
    public static class JobMatchDTO {
        public Job job;
        public int matchPercentage;
        public List<String> matchedSkills;

        public JobMatchDTO(Job job, int matchPercentage, List<String> matchedSkills) {
            this.job = job;
            this.matchPercentage = matchPercentage;
            this.matchedSkills = matchedSkills;
        }
    }

    @GetMapping("/match/{userId}")
    public List<JobMatchDTO> matchJobsForUser(@PathVariable Long userId) {
        Optional<User> userOpt = userRepository.findById(userId);
        if (userOpt.isEmpty()) {
            return Collections.emptyList();
        }

        User user = userOpt.get();
        if (user.getSkills() == null || user.getSkills().isEmpty()) {
            return Collections.emptyList();
        }

        // User skills ko Set mein convert karo (lowercase karke taaki mismatch na ho)
        Set<String> userSkills = new HashSet<>(Arrays.asList(user.getSkills().toLowerCase().split("\\s*,\\s*")));
        List<Job> allJobs = jobRepository.findAll();
        List<JobMatchDTO> matchedResults = new ArrayList<>();

        for (Job job : allJobs) {
            if (job.getRequiredSkills() == null || job.getRequiredSkills().isEmpty()) {
                continue;
            }

            Set<String> requiredSkills = new HashSet<>(Arrays.asList(job.getRequiredSkills().toLowerCase().split("\\s*,\\s*")));
            
            // Common skills find karo
            List<String> commonSkills = new ArrayList<>();
            for (String skill : requiredSkills) {
                if (userSkills.contains(skill)) {
                    commonSkills.add(skill);
                }
            }

            if (!commonSkills.isEmpty()) {
                // Match Percentage Calculate karo: (Matched / Total Required) * 100
                int percentage = (commonSkills.size() * 100) / requiredSkills.size();
                matchedResults.add(new JobMatchDTO(job, percentage, commonSkills));
            }
        }

        // High percentage wale jobs ko upar rakhne ke liye sort karo
        matchedResults.sort((a, b) -> Integer.compare(b.matchPercentage, a.matchPercentage));
        return matchedResults;
    }
}