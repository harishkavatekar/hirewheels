package com.upgrad.hirewheels.services;

import com.upgrad.hirewheels.entities.Vehicle;

import java.util.List;

public interface AdminService {
    /* TODO Write code here */
    Vehicle registerVehicle(Vehicle vehicle) throws Exception;
    Vehicle changeAvailability(int vehicleId, int availabilityStatus);
    List<Vehicle> getVehicles();
}
