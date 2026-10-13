# 🎯 SkillMatch App

SkillMatch is a Spring Boot & MySQL-based web application designed to connect students with relevant job and placement opportunities based on their skill sets.

---

## 🚀 Key Features

* **Student Profile Management:** Create and update student profiles with relevant skills and email details.
* **Job Opportunity Listings:** Recruiters/Admins can post job openings with specific required skills.
* **Smart Skill Matching:** Calculates match percentage between student skill sets and job requirements.
* **Application Tracking:** Allows students to view and apply for matching opportunities effortlessly.

---

## 🛠️ Tech Stack

* **Backend:** Java, Spring Boot, Spring Data JPA
* **Database:** MySQL
* **Frontend:** HTML5, CSS3, JavaScript
* **Tools & Environment:** VS Code , Git, GitHub, Maven

---

## 📂 Project Structure

skillmatchapp/
├── src/
│   ├── main/
│   │   ├── java/com/skillmatchapp/
│   │   │   ├── entity/          # JPA Entities (User, Job, Application)
│   │   │   ├── Repository/      # Spring Data JPA Repositories
│   │   │   ├── controller/      # REST API Controllers
│   │   │   └── SkillmatchApplication.java
│   │   └── resources/
│   │       ├── static/          # Frontend assets (index.html, CSS, JS)
│   │       └── application.properties # Database & App Configurations
└── pom.xml                      # Maven Dependencies

---

## ⚙️ How to Run Locally

1. **Clone the Repository:**
   ```bash
   git clone [https://github.com/thesittu12/skillmatchapp.git](https://github.com/thesittu12/skillmatchapp.git)

2. Configure Database:
   Update src/main/resources/application.properties with your MySQL database credentials:

   PROPERTIIES
   spring.datasource.url=jdbc:mysql://localhost:3306/skillmatch_db
   spring.datasource.username=YOUR_MYSQL_USERNAME
   spring.datasource.password=YOUR_MYSQL_PASSWORD

3. Build and Run:
   Execute the Spring Boot application using Maven or directly run SkillmatchApplication.java from your IDE.

4. Access in Browser:
Open http://localhost:8080 in your web browser.

---


   
