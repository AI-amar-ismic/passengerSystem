# Basic passenger system

Task for this mini project was to create a Basic Passenger system, which would communicate with a database and receive HTTP calls. 

## Endpoints

### POST on /passengers
Receives data in JSON format, and stores the new passenger in the database
### GET on /passengers/all
Retrieves all passengers stored in the database in a JSON format
### GET on /passengers/id/{id}
Retrieves data on a passenger given his database id
### GET on /passengers/passport/{passportID}
Retrieves data on a passenger given his passport id
### PUT on /passengers/id/{id}
Receives updated data in JSON format in the request body, updates a single passenger by his database id with the updated info 
### PUT on /passengers/passport/{passportID}
Receives updated data in JSON format in the request body, updates a single passenger by his passport id with the updated info 
### DELETE on /passengers/id/{id}
Deletes a single passenger from the database given his database id
### DELETE on /passengers/passport/{passportID}
Deletes a single passenger from the database given his passport id

Included in the repository is a Postman collection of all the endpoints, for ease of use.

## Database
Database used for this project was a PostgreSQL database run locally using Docker containers. Hibernate ddl is set to update, so no additional database setup is needed, apart from changing the database url, username and password, which will be set locally. 

## About 
This project is built using Spring Boot with Spring Web, Spring Data JPA, Postgresql driver and lombok dependencies. 
The code is divided into 4 packages with the PassengerApplication class being the 5th, and the place where the application is started. For additional information on specific methods and operations please refer to the comments in the code.
Packages:
### controllers
Contains two additional packages and a controller class. Controller class is responsible for the handling HTTP requests described in the Endpoints section, and comminicating those requests to the service. No business logic is contained here, and this layer only operates with DTOs (Data Transfer Objects). Two packages contained are:
  -dtos : containing the PassengerDto class, used for data transfer only, never stored in the database.
  -mapper: contains the stateless PassengerMapper class, used only to convert Entities into DTOs and vice versa.
### entities
Contains the PassengerEntity class. This is an database entitiy, and contains all the attributes of the passenger. It also contains one method, using which the state of the entity is updated without changing its database or passport id.
### repositories
Contains the PassengerRepo interface which extends Spring's CrudRepository, gaining access to some included methods when dealing with databases. One additional method in the interface is the getFirstByPassportID method, which retrieves the first occurance of that passport id in the database. This method is automatically implemented by Spring.
### services
This package contains the PassengerService interface and its implementation. This layer contains all the business logic and is responsible for retrieving and forwarding entities from and to the repository, converting DTOs and entities between each other, as well as receiving and forwarding DTOs from and to the controller. It supports all the methods required by the controller, for adding, updating, retrieving and deleting passengers. 




