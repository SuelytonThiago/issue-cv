# issue-cv

# About this project

I created this project with the purpose of creating a REST API that is capable of generating resumes based on data provided by users. As part of this project, I implemented a mechanism that controls the generation of CVs, limiting it to three simultaneous users at each five-minute interval. This functionality was made possible through the "ScheduledExecutorService", which proved to be highly effective for this purpose and can be applied to a variety of other projects that require the automated execution of tasks, without manual intervention.

# Technologies used

- Java
- Spring boot
- Maven
- Jpa/Hibernate
- Spring Security
- Json Web Token
- PostgreSQL Database
- ScheduledExecutorService
- Swagger

# How to run the project

### clone repository
git clone `https://github.com/SuelytonThiago/issue-cv`

### run the project
./mvnw spring-boot:run

Before starting the project, **configure the environment variables in the application.properties** file.

To test the endpoints, just use postman or access the swagger documentation with the url: localhost:(your port)/swagger-ui/index.html

As the project needs authentication to access an endpoint, use the following user for testing:

### user
* email: `joe@example.com`
* password: senha123

# Author
- Suelyton Thiago de Lima souza

https://www.linkedin.com/in/suelyton-souza-0baaa127a/
