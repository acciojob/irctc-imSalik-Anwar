package com.driver.services;


import com.driver.model.Passenger;
import com.driver.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PassengerService {

    @Autowired
    PassengerRepository passengerRepository;

    public Integer addPassenger(Passenger pas){
        //Add the passenger Object in the passengerDb and return the passengerId that has been returned
        // Create new passenger
        Passenger passenger = new Passenger();
        passenger.setName(pas.getName());
        passenger.setAge(pas.getAge());
        passenger.setBookedTickets(new ArrayList<>());
        // save passenger
        Passenger savedPassenger = passengerRepository.save(passenger);
        return savedPassenger.getPassengerId();
    }

}
