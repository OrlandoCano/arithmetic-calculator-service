# Arithmetic Calculator Service

This project was build from scratch using [Spring Initializer](https://start.spring.io/).\
This is a backend running by default in http://localhost:8080.

### Some of the used modules and libs are
- spring-boot-starter-web
- spring-boot-starter-data-jpa
- spring-boot-starter-security
- JWT for secure API
- H2 in memory DB
- Lombok for boilerplate
- Junit and Mockito
- And some design patterns (Builder, facade, strategy)

## How to running locally
The application is using the latest version of SpringBoot and Spring Framework. 

To running it a version of Java 17 should be properly installed.

### Java Installation

- [Windows Installation](https://learn.microsoft.com/en-us/java/openjdk/install)
- [Mac Intallation Brew](https://formulae.brew.sh/formula/openjdk@17)

### Gradle

This application uses a gradle wrapper, no need to install additional building tools such as maven or gradle

### Building and Running
If Intellij Idea is available, the easiest way is open the root folder.\
Intellij will build the project and just will be needed run the ArithmeticCalculatorApplication class

To building and running from console: \
Note: Make sure the console location is the root of this project.

- Build the project with `./gradlew clean build` this also will run the automated tests.
- Running the service using `./gradlew bootRun`