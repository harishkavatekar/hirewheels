package com.upgrad.hirewheels.controller;

import com.upgrad.hirewheels.dto.VehicleDTO;
import com.upgrad.hirewheels.entities.Vehicle;
import com.upgrad.hirewheels.services.AdminService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/hirewheels/v1")
public class VehicleController {

    @Autowired
    private AdminService adminService;

    @Autowired
    ModelMapper modelMapper;

    @PostMapping(value = "/vehicles", consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addVehicle(@RequestBody VehicleDTO vehicleDTO) throws Exception {
        Vehicle vehicle = modelMapper.map(vehicleDTO, Vehicle.class);
        Vehicle savedVehicle = adminService.registerVehicle(vehicle);

        VehicleDTO savedVehicleDTO = modelMapper.map(savedVehicle, VehicleDTO.class);
        return new ResponseEntity(savedVehicleDTO, HttpStatus.CREATED);

    }

    @GetMapping(value = "/vehicles")
    public ResponseEntity getVehicles(VehicleDTO vehicleDTO) throws Exception {
        Vehicle vehicle = modelMapper.map(vehicleDTO, Vehicle.class);
        Vehicle vehicleList = adminService.registerVehicle(vehicle);

        VehicleDTO vehicleDTOList = modelMapper.map(vehicleList, VehicleDTO.class);
        return new ResponseEntity(vehicleDTOList, HttpStatus.OK);
    }
}
