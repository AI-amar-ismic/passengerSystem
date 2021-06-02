package com.softray.internship.services;

import com.softray.internship.controllers.dtos.PassengerDto;
import com.softray.internship.controllers.mapper.PassengerMapper;
import com.softray.internship.entities.PassengerEntity;
import com.softray.internship.repositories.PassengerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/*
    Implementation of the passenger service interface
    Passenger repository injected
    Passenger mapper injected
    @inheritDoc
 */

@Service
public class PassengerServiceImpl implements PassengerService {

    @Autowired
    private PassengerRepo passengerRepo;
    @Autowired
    private PassengerMapper passengerMapper;

    /*
        Method calls the findAll method in the passenger repository, and the returned PassengerEntity object
        is mapped onto a PassengerDto object and returned
     */
    @Override
    public List<PassengerDto> findAllUsers() {
        Iterable<PassengerEntity> passengers = passengerRepo.findAll();
        return passengerMapper.toDto(passengers);
    }

    /*
        Method receives a PassengerDto object, maps it to PassengerEntity object, and passes it to the save method
        in the passenger repository. Save method returns the saved object which is mapped from PassengerEntity to
        PassengerDto and returned. In case the saved passenger is null, the method returns null as well, which is then
        handled by the controller
     */
    @Override
    public PassengerDto createNewUser(PassengerDto passengerDto) {

            PassengerEntity passengerEntity = passengerMapper.toEntity(passengerDto);
            PassengerEntity savedPassenger = passengerRepo.save(passengerEntity);
            if (savedPassenger!=null) {
                return passengerMapper.toDto(savedPassenger);
            }
        return null;
    }

    /*
        Method takes id as a parameter, and passes it to the findById method in the repository. The returned PassengerEntity wrapped in and Optional object
        is mapped to PassengerDto and returned. If the returned PassengerEntity is null, then the method returns null as well,
        which is then handled by the controller.
     */
    @Override
    public PassengerDto getPassengerByID(Long id) {
        if (id > 0) {
            Optional<PassengerEntity> optional = passengerRepo.findById(id);
            if (optional.isPresent()){
                return passengerMapper.toDto(optional.get());
            }

        }
        return null;
    }

    /*
        Method takes passport id as a parameter, and passes it to the getFirstByPassportID method in the repository.
        The returned PassengerEntity wrapped in Optional object is mapped to PassengerDto and returned. If the returned PassengerEntity is null,
        then the method returns null as well, which is then handled by the controller.
     */
    @Override
    public PassengerDto getPassengerByPassportID(int passportID) {
        Optional<PassengerEntity> optional = passengerRepo.getFirstByPassportID(passportID);
        if (optional.isPresent()) {
            return passengerMapper.toDto(optional.get());
        }
        return null;
    }

    /*
        Method takes id as a parameter, and passes it to findById method in the repository. The returned PassengerEntity
        wrapped in an Optional object is then mapped to a PassengerDto and returned. If the Optional object is empty,
        the method returns null
     */
    @Override
    public PassengerDto deletePassengerByID(Long id) {
        Optional<PassengerEntity> optional = passengerRepo.findById(id);
        if (optional.isPresent()){
            passengerRepo.deleteById(id);
            return passengerMapper.toDto(optional.get());
        }
        return null;
    }

    /*
        Method takes passport id as a parameter, and passes it to getFirstByPassportID method in the repository. The returned PassengerEntity
        wrapped in an Optional object is then mapped to a PassengerDto and returned. If the Optional object is empty,
        the method returns null
     */
    @Override
    public PassengerDto deletePassengerByPassportID(int id) {
        if (id>0){
            Optional<PassengerEntity> optional = passengerRepo.getFirstByPassportID(id);
            if (optional.isPresent()){
                PassengerEntity passengerEntity = optional.get();
                passengerRepo.deleteById(passengerEntity.getId());
                return passengerMapper.toDto(passengerEntity);
            }
        }
        return null;
    }


}
