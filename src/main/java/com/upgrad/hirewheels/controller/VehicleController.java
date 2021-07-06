package com.upgrad.hirewheels.controller;

import com.upgrad.hirewheels.dto.VehicleDTO;
import com.upgrad.hirewheels.entities.Vehicle;
import com.upgrad.hirewheels.services.AdminService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/hirewheels/v1")
public class VehicleController {

    @Autowired
    private AdminService adminService;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping(value = "/vehicles")
    public ResponseEntity getVehicles(VehicleDTO vehicleDTO) throws Exception {
        Vehicle vehicle = modelMapper.map(vehicleDTO, Vehicle.class);
        Vehicle vehicleList = adminService.registerVehicle(vehicle);

        VehicleDTO vehicleDTOList = modelMapper.map(vehicleList, VehicleDTO.class);
        return new ResponseEntity(vehicleDTOList, HttpStatus.OK);
    }
}
