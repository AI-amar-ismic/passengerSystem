package com.softray.internship.repositories;

import com.softray.internship.entities.PassengerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/*
    A class representing the repository.
    Extends the provided CrudRepository in order to gain access to boilerplate methods used in standard repositories
    getFirstByPassportID method added
 */
@Repository
public interface PassengerRepo extends CrudRepository<PassengerEntity, Long> {

    /*
        A method which returns a single PassengerEntity object from the database given the desired passport id
        Automatically implemented by Spring
        @Param passportID of type int representing the desired passport id
        @Returns PassengerEntity wrapped in Optional object
     */
    Optional<PassengerEntity> getFirstByPassportID (int passportID);
}
