/*
 * Copyright (c) 2023. CodeGen International (Pvt) Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of CodeGen
 * International (Pvt) Ltd. ("Confidential Information"). You shall not disclose
 * such Confidential Information and shall use it only in accordance with the
 * terms of the license agreement you entered into with CodeGen International.
 *
 */
package it.codegen.Assignment.HotelReservation.controller;

import it.codegen.Assignment.HotelReservation.criteria.ContractSearchCriteria;
import it.codegen.Assignment.HotelReservation.models.Contract;
import it.codegen.Assignment.HotelReservation.models.Hotel;
import it.codegen.Assignment.HotelReservation.models.RoomType;
import it.codegen.Assignment.HotelReservation.repository.ContractRepository;
import it.codegen.Assignment.HotelReservation.repository.HotelRepository;
import it.codegen.Assignment.HotelReservation.repository.RoomTypeRepository;
import it.codegen.Assignment.HotelReservation.service.ContractService;
import org.aspectj.apache.bcel.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * <b>Description Title</b>
 * Description Text.
 *
 * @author manujas
 * @since 12 Jul 2023
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/contracts")
public class ContractController
{
    @Autowired
    private ContractService contractService;

    @Autowired
    private ContractRepository contractRepository;

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private RoomTypeRepository roomTypeRepository;

    //create contract controller
    @PostMapping()
    public ResponseEntity<Contract> createContract(@RequestBody Contract contract){
        try{
            Hotel hotel = contract.getHotels();
            hotelRepository.save(hotel);
            List<RoomType> roomTypes = contract.getRoomTypes();

            for (RoomType roomType : roomTypes) {
                roomType.setContract(contract);

            }

            contractRepository.save(contract);

            for (RoomType roomType : roomTypes) {
                roomType.getContract().setId(contract.getId());
            }


            roomTypeRepository.saveAll(roomTypes);


            contract.setHotels( hotel );
            contract.setRoomTypes( roomTypes );


            return ResponseEntity.ok(contract);
        } catch (Exception e) {
            return ResponseEntity.status( HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    //search contract by hotel name
    @PostMapping("/search")
    public ResponseEntity<List<Contract>> searchContractsByHotelName(@RequestBody Map<String, String> requestBody) {
        String hotelName = requestBody.get("hotel_name");
        List<Contract> contracts = contractService.getContractsByHotelName(hotelName);
        return new ResponseEntity<>(contracts, HttpStatus.OK);
    }

    //delete contract controller after getting them by hotel name
    @DeleteMapping("{id}")
    public ResponseEntity<Map<String, String>> deleteContract(@PathVariable("id") Long id) {
        try {
            contractService.deleteById(id);
            // Create a success message JSON object
            Map<String, String> response = new HashMap<>();
            response.put("message", "Contract and associated details deleted successfully!");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            // Create an error message JSON object
            Map<String, String> response = new HashMap<>();
            response.put("error", "Failed to delete contract");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }


    //get all contracts to the front(in front it will filter the last 10)
    @GetMapping("/all")
    public ResponseEntity<List<Contract>> getAllContracts(){
        List<Contract> contracts = contractService.getAllContracts();
        return new ResponseEntity<>( contracts, HttpStatus.OK );
    }


}
