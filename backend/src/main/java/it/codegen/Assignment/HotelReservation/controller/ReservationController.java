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

import it.codegen.Assignment.HotelReservation.dto.ReservationRequest;
import it.codegen.Assignment.HotelReservation.dto.ReservationResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import it.codegen.Assignment.HotelReservation.service.HotelReservationService;
import java.util.List;

/**
 * <b>Description Title</b>
 * Description Text.
 *
 * @author manujas
 * @since 22 Jul 2023
 */
@RestController
@RequestMapping("reservation")
public class ReservationController
{
    @Autowired
    private HotelReservationService reservationService;


    //search controller to get according to customer giving details
    @PostMapping("/reservation")
    public ResponseEntity<List<ReservationResult>> findAvailableHotels(@RequestBody ReservationRequest request) {
        List<ReservationResult> results = reservationService.findAvailableHotels(request);
        return ResponseEntity.ok(results);
    }
}
