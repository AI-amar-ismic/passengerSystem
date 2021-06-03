package com.softray.internship.services;

import com.softray.internship.controllers.dtos.PassengerDto;
import java.util.List;
/*
    An interface defining methods contained in the passenger service
    Methods:
        -findAllUsers
        -createNewUser
        -getPassengerByID
        -getPassengerByPassportID
        -deletePassengerByID
        -deletePassengerByPassportID
 */
public interface PassengerService {
    /*
        A method to retrieve all users from the database
        @Returns a list of PassengerDtos
     */
    public List<PassengerDto> findAllUsers();

    /*
        A method to add a new passenger to the database
        @Param passenger in form of a PassengerDto object
        @Returns the created user in form of a PassengerDto object
     */
    public PassengerDto createNewUser (PassengerDto passengerDto);

    /*
        A method to retrieve a passenger from the database given his database id
        @Param Long id representing the desired id
        @Returns the desired passenger in a form of a PassengerDto object
     */
    public PassengerDto getPassengerByID(Long id);

    /*
       A method to retrieve a passenger from the database given his passport id
       @Param int id representing the desired passport id
       @Returns the desired passenger in a form of a PassengerDto object
    */
    public PassengerDto getPassengerByPassportID (int passportID);

    /*
       A method to delete a passenger from the database given his database id
       @Param Long id representing the desired id
       @Returns the deleted passenger in a form of a PassengerDto object
    */
    public PassengerDto deletePassengerByID (Long id);

    /*
       A method to delete a passenger from the database given his passport id
       @Param int id representing the desired passport id
       @Returns the deleted passenger in a form of a PassengerDto object
    */
    public PassengerDto deletePassengerByPassportID (int id);

    /*
        A method to update a passenger in the database given his database id
        @Param long id representing the database id and passengerDto containing the updated info
        @Returns the updated passenger in form of a PassengerDto object
     */
    public PassengerDto updatePassengerByID (Long id, PassengerDto passengerDto);

    /*
        A method to update a passenger in the database given his passport id
        @Param int id representing the passport id and passengerDto containing the updated info
        @Returns the updated passenger in form of a PassengerDto object
     */
    public PassengerDto updatePassengerByPassportID (int id, PassengerDto passengerDto);
}
