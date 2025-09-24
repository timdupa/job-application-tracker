Job Application Tracker

A full-stack web application for tracking job applications, built with Java servlets, PostgreSQL, and Docker.
Features

    ✅ Add new job applications with company, date, status, and notes
    📊 View all applications in an organized, color-coded interface
    🎯 Status tracking (Applied, Interview, Offer, Rejected, Withdrawn)
    📱 Responsive design works on desktop and mobile
    🐳 Fully containerized with Docker

Technology Stack

Backend:

    Java 17 with Jakarta Servlets
    PostgreSQL database
    Apache Tomcat web server
    Maven for build management
    JDBC for database connectivity
    Gson for JSON serialization

Frontend:

    HTML5, CSS3, JavaScript (Vanilla)
    Responsive design with mobile-first approach
    AJAX for dynamic content loading

Infrastructure:

    Docker & Docker Compose
    Multi-stage Dockerfile for optimized builds

Getting Started
Prerequisites

    Docker and Docker Compose installed
    Git (for cloning)

Quick Start

    Clone the repository:

bash

   git clone https://github.com/YOUR_USERNAME/job-application-tracker.git
   cd job-application-tracker

    Start the application:

bash

   docker-compose up --build

    Access the app: Open your browser to http://localhost:8080
    Stop the application:

bash

   docker-compose down

Project Structure

job-tracker/
├── docker-compose.yml          # Multi-service configuration
├── Dockerfile                  # Application container build
├── pom.xml                    # Maven dependencies and build config
└── src/
    └── main/
        ├── java/com/jobtracker/
        │   ├── model/
        │   │   └── JobApplication.java      # Data model
        │   ├── dao/
        │   │   └── JobApplicationDAO.java   # Database operations
        │   ├── servlet/
        │   │   ├── JobApplicationServlet.java    # Form handling
        │   │   └── ViewApplicationsServlet.java  # Data API
        │   └── util/
        │       └── DatabaseConnection.java      # DB connection
        ├── webapp/
        │   ├── WEB-INF/
        │   │   └── web.xml              # Servlet configuration
        │   ├── index.html               # Main UI
        │   └── style.css               # Styling
        └── resources/
            └── init.sql                # Database schema

Database Schema
sql

CREATE TABLE job_applications (
    id SERIAL PRIMARY KEY,
    company_name VARCHAR(255) NOT NULL,
    date_applied DATE NOT NULL,
    status VARCHAR(50) CHECK (status IN ('Applied', 'Interview', 'Offer', 'Rejected', 'Withdrawn')),
    notes TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

API Endpoints

    POST /applications - Create new job application
    GET /view-applications - Retrieve all applications as JSON

Development
Making Changes

    Modify source code in src/ directory
    Rebuild and restart:

bash

   docker-compose down
   docker-compose up --build

Adding Features

The application follows a clean 3-tier architecture:

    Presentation Layer: HTML, CSS, JavaScript
    Application Layer: Java servlets and business logic
    Data Layer: PostgreSQL with DAO pattern

Database Access

The PostgreSQL database is accessible at localhost:5432:

    Database: jobtracker
    Username: postgres
    Password: password

Contributing

    Fork the repository
    Create a feature branch (git checkout -b feature/amazing-feature)
    Commit your changes (git commit -m 'Add amazing feature')
    Push to the branch (git push origin feature/amazing-feature)
    Open a Pull Request

License

This project is open source and available under the MIT License.
Screenshots
Add Application Form

Clean, intuitive form for entering job application details.
Application Dashboard

Color-coded status tracking with all your applications at a glance.

Built with ❤️ using Java, PostgreSQL, and Docker
