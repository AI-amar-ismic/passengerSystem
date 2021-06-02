package com.softray.internship.controllers.mapper;

import com.softray.internship.controllers.dtos.PassengerDto;
import com.softray.internship.entities.PassengerEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
/*
    This class is used to convert objects from PassengerEntity type to PassengerDto type.
    It has no attributes, just 3 methods to convert a single object from Dto to Entity, and in reverse, as well as
    a method to convert a list of Dtos to a list of Entities
 */
@Component
public class PassengerMapper {

    /*
        A method to convert a single object of type PassengerDto into PassengerEntity
        @Param passenger in form of a PassengerDto
        @Returns passenger in form of a PassengerEntity
     */
    public PassengerEntity toEntity (PassengerDto passenger){
        PassengerEntity entity = new PassengerEntity();
        BeanUtils.copyProperties(passenger, entity);
        return entity;
    }


    /*
        A method to convert a single object of type PassengerEntity into PassengerDto
        @Param passenger in form of a PassengerEntity
        @Returns passenger in form of a PassengerDto
     */
    public PassengerDto toDto (PassengerEntity passenger){
        PassengerDto dto = new PassengerDto();
        BeanUtils.copyProperties(passenger, dto);
        return dto;
    }

    /*
        A method to convert a list of passengers in a form of PassengerEntity objects into a list
        of PassengerDto objects.
        In the same time converts an Iterable list into a regular list
        @Param Iterable list of PassengerEntity objects
        @Returns List of PassengerDto objects
     */
    public List<PassengerDto> toDto (Iterable<PassengerEntity> passengers){
        return StreamSupport.stream(passengers.spliterator(), false)
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
