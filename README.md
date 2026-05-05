# CCP Management System

A comprehensive REST API built with Spring Boot for managing Critical Control Points (CCPs) and monitoring quality parameters in production environments. This application enables organizations to define, track, and validate critical control points with configurable parameters, measurement limits, and real-time recording capabilities.

## Features

### Core Functionality
- **CCP Management**: Create, read, update, and delete Critical Control Points with parameters like name, description, unit, and min/max limits
- **Record Tracking**: Log measurements against CCPs with operator IDs, timestamps, and parameter values
- **User Management**: Role-based user system with authentication and authorization
- **Advanced Search**: Filter records by parameter, date ranges, and operators with pagination support
- **Validation**: Automatic validation of measurements against defined CCP thresholds

### Security & Authentication
- JWT-based authentication with configurable token expiration
- Role-based access control (Admin, User roles)
- Secure password handling with Spring Security
- OAuth2 resource server integration

### Technical Features
- RESTful API design with OpenAPI/Swagger documentation
- Pagination and sorting for large datasets
- Environment-based configuration (dev/prod profiles)
- Database sequence synchronization for ID generation
- Comprehensive error handling and validation

## Tech Stack

- **Backend**: Spring Boot 4.0.5
- **Language**: Java 17
- **Database**: PostgreSQL (with H2 for development)
- **ORM**: Spring Data JPA with Hibernate
- **Security**: Spring Security + OAuth2 Resource Server
- **Build Tool**: Maven
- **Documentation**: SpringDoc OpenAPI
- **Containerization**: Docker
- **Deployment**: Render (with Neon PostgreSQL)

## Prerequisites

- Java 17 or higher
- Maven 3.6+
- PostgreSQL (for production) or H2 (for development)
- Docker (optional, for containerized deployment)


## Project Structure

<pre>
src/
├── main/
│   ├── java/se/jensen/charitha/ccp/
│   │   ├── CcpApplication.java
│   │   ├── businesslayer/
│   │   │   ├── entity/          # JPA entities
│   │   │   ├── mapper/          # DTO mappers
│   │   │   └── service/         # Business logic
│   │   ├── config/              # Configuration classes
│   │   ├── dataaccesslayer/
│   │   │   └── repository/      # JPA repositories
│   │   └── presentationlayer/
│   │       ├── controller/      # REST controllers
│   │       ├── dto/             # Data transfer objects
│   │       └── exception/       # Exception handlers
│   └── resources/
│       ├── application.properties
│       └── application-dev.properties
└── test/
    └── java/se/jensen/charitha/ccp/
        └── CcpApplicationTests.java
</pre>

```
