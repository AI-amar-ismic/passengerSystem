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
