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
import it.codegen.Assignment.HotelReservation.models.Hotel;
import it.codegen.Assignment.HotelReservation.service.ContractService;
import it.codegen.Assignment.HotelReservation.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

/**
 * <b>Description Title</b>
 * Description Text.
 *
 * @author manujas
 * @since 13 Jul 2023
 */
@RestController
@RequestMapping("hotels")
public class HotelController
{
    private final ContractService contractService;
    @Autowired
    private HotelService hotelService;

    @Autowired
    public HotelController( ContractService contractService) {
        this.contractService = contractService;
    }
    @PostMapping()
    public Hotel saveHotel( @RequestBody Hotel hotel ){
        return hotelService.saveHotel(hotel);
    }

    @GetMapping("{id}")
    public Optional<Hotel> getById ( @PathVariable("id") Long id)
    {
        return hotelService.getById(id);
    }

    @DeleteMapping("{id}")
    public void deleteById( @PathVariable("id") Long id)
    {
        hotelService.deleteById(id);
    }


}
