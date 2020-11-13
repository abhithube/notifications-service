# Notifications Service [![Build Status](https://travis-ci.com/abhithube/notifications-service.svg?branch=master)](https://travis-ci.com/abhithube/notifications-service)


This is the notifications microservice of the AT Insurance web application. It contains the Kafka listeners that receive messages the other services have written to Kafka topics regarding changes to the member's profile, such as enrolling in a plan or completing the monthly payment. These listeners create notifications and add them to the member's account, and can be seen on the dashboard page.

The [README](https://github.com/abhithube/insurance-portal-angular) in the front end repo has more details about the whole project.

## Technologies
- **Programming Language**: Java
- **Framework**: Spring Boot
- **Messaging**: Kafka
- **Testing**: JUnit, Mockito
- **Build**: Maven
- **CI/CD**: Travis CI, Docker, AWS
