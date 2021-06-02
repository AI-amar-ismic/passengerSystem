package com.softray.internship.controllers.dtos;

import lombok.Data;

/*
    Class representing a DTO (Data Transfer Object) of the passenger entity.
    It is returned instead of the PassengerEntity in the service and the controller, and contains the same attributes.
    Automatic getters and setters using Lombok
 */
@Data
public class PassengerDto {


    private Long id;
    private String firstName;
    private String lastName;
    private int passportID;
    private String email;
}
