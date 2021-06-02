package com.softray.internship.controllers;

import com.softray.internship.controllers.dtos.PassengerDto;
import com.softray.internship.services.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
    A REST controller defining API paths and endpoints
    Passenger service injected
    Endpoints defined:
        - GET on /passengers/all to retrieve all passengers stored in the database
        - GET on /passengers/id/{id} to retrieve a passenger by his database id
        - GET on /passengers/passport/{passportID} to retrieve a passenger by his passport id
        - POST on /passengers to add a new passenger to the database
        - DELETE on /passengers/id/{id} to delete a passenger from the database by his database id
        - DELETE on /passengers/passport/{passportID} to delete a passenger from the database by his passport id
 */

@RestController
@RequestMapping("passengers")
public class PassengerController {

    @Autowired
    private PassengerService passengerService;

    /*
        An endpoint to retrieve all passengers stored in the database
        Pre-condition: the service didn't return a null object when an appropriate method in the service was called
        @Returns a HTTP response 200 OK, with a list of all passengers in the response body
     */
    @GetMapping("all")
    public ResponseEntity<List<PassengerDto>> getAllPassengers(){
        List<PassengerDto> passengers = passengerService.findAllUsers();
        if(!passengers.isEmpty()){
            return new ResponseEntity<>(passengers, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /*
        An endpoint to retrieve a single passenger from the database given his database id
        Pre-condition: The service didn't return a null object when an appropriate method in the service was called
        @Param Path variable of type long representing the desired id
        @Returns a HTTP response 200 OK, with the desired passenger in the response body
     */
    @GetMapping("id/{id}")
    public ResponseEntity<PassengerDto> getPassengerByID(@PathVariable Long id){
        PassengerDto passengerDto = passengerService.getPassengerByID(id);
        if (passengerDto!=null){
            return new ResponseEntity<>(passengerDto,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /*
        An endpoint to retrieve a single passenger from the database given his passport id
        Pre-condition: The service didn't return a null object when an appropriate method in the service was called
        @Param Path variable of type int representing the desired passport id
        @Returns a HTTP response 200 OK, with the desired passenger in the response body
     */
    @GetMapping("passport/{passportID}")
    public ResponseEntity<PassengerDto> getPassengerByPassportID(@PathVariable int passportID){
        PassengerDto passengerDto = passengerService.getPassengerByPassportID(passportID);
        if (passengerDto!=null){
            return new ResponseEntity<>(passengerDto,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /*
        An endpoint to add a new  passenger to the database
        Pre-condition: The service didn't return a null object when an appropriate method in the service was called
        @Param passenger in form of an object in the Request body
        @Returns a HTTP response 200 OK, with the newly added passenger in the response body
     */
    @PostMapping
    public ResponseEntity<PassengerDto> addPassenger(@RequestBody PassengerDto passenger){
        PassengerDto savedPassenger = passengerService.createNewUser(passenger);
        if (savedPassenger!=null){
            return new ResponseEntity<>(savedPassenger, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    /*
        An endpoint to delete a single passenger from the database given his database id
        Pre-condition: The service didn't return a null object when an appropriate method in the service was called
        @Param Path variable of type long representing the desired id
        @Returns a HTTP response 200 OK, with the deleted passenger in the response body
     */
    @DeleteMapping("id/{id}")
    public ResponseEntity<PassengerDto> deleteUserByID (@PathVariable Long id){
        PassengerDto deletedPassenger = passengerService.deletePassengerByID(id);
        if (deletedPassenger!=null){
            return new ResponseEntity<>(deletedPassenger,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /*
        An endpoint to retrieve a single passenger from the database given his passport id
        Pre-condition: The service didn't return a null object when an appropriate method in the service was called
        @Param Path variable of type int representing the desired passport id
        @Returns a HTTP response 200 OK, with the deleted passenger in the response body
     */
    @DeleteMapping("passport/{id}")
    public ResponseEntity<PassengerDto> deleteUserByPassportID (@PathVariable int id){
        PassengerDto deletedPassenger = passengerService.deletePassengerByPassportID(id);
        if (deletedPassenger!=null){
            return new ResponseEntity<>(deletedPassenger,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
