# cmsimpel - Simple Content Management System

A simple and lightweight Content Management System built with Spring Boot, designed for easy content management and administration.

## Technology Stack

- **Framework**: Spring Boot 4.0.0
- **Language**: Java 21
- **Database**: PostgreSQL
- **Build Tool**: Apache Maven
- **Other**: Lombok, Spring Boot DevTools

## Features

- MVC Web Architecture
- PostgreSQL database integration
- Spring Boot auto-configuration
- Lombok for reducing boilerplate code
- Maven wrapper for easy build management

## Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── website/garapan/cmsimpel/
│   │       └── CmsimpelApplication.java
│   └── resources/
│       ├── application.properties
│       ├── static/          # Static assets (CSS, JS, Images)
│       └── templates/       # HTML templates
└── test/
    └── java/
        └── website/garapan/cmsimpel/
            └── CmsimpelApplicationTests.java
```

## Prerequisites

- Java 21 or higher
- Maven 3.6+ (or use the provided Maven wrapper)
- PostgreSQL database server

## Getting Started

### 1. Clone the repository
```bash
git clone <repository-url>
cd cmsimpel
```

### 2. Setup Database
Create a PostgreSQL database for the application:
```sql
CREATE DATABASE cmsimpel;
-- Create a user with appropriate permissions
CREATE USER cms_user WITH PASSWORD 'your_password';
GRANT ALL PRIVILEGES ON DATABASE cmsimpel TO cms_user;
```

### 3. Configuration
Update `src/main/resources/application.properties` with your database configuration:
```properties
spring.application.name=cmsimpel
spring.datasource.url=jdbc:postgresql://localhost:5432/cmsimpel
spring.datasource.username=cms_user
spring.datasource.password=your_password
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```

### 4. Running the Application

#### Using Maven Wrapper (recommended):
```bash
# On Windows
mvnw.cmd spring-boot:run

# On Unix/Linux/Mac
./mvnw spring-boot:run
```

#### Using Installed Maven:
```bash
mvn spring-boot:run
```

### 5. Running Tests
```bash
mvnw.cmd test  # Windows
# or
./mvnw test    # Unix/Linux/Mac
```

## Build Executable JAR

To build the application:
```bash
mvnw.cmd clean package  # Windows
# or
./mvnw clean package    # Unix/Linux/Mac
```

To run the packaged JAR:
```bash
java -jar target/cmsimpel-0.0.1-SNAPSHOT.jar
```

## Development

- The application runs on `http://localhost:8080` by default
- Hot reload is enabled through Spring Boot DevTools
- Use your favorite IDE with Spring Boot plugin support

## Project Status

This is a basic skeleton application with:
- Spring Boot application configured
- PostgreSQL connectivity
- Lombok integration
- Test framework in place

## Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Contact

Project Link: https://github.com/hendrapaiton/cmsimpel.git

---
Built with ❤️ using Spring Boot