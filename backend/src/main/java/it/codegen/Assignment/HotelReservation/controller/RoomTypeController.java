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

import it.codegen.Assignment.HotelReservation.models.RoomType;

import it.codegen.Assignment.HotelReservation.repository.RoomTypeRepository;
import it.codegen.Assignment.HotelReservation.service.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * <b>Description Title</b>
 * Description Text.
 *
 * @author manujas
 * @since 14 Jul 2023
 */
@RestController
@RequestMapping("roomTypes")

public class RoomTypeController
{

        @Autowired
        private RoomTypeService roomTypeService;

        @Autowired
        private RoomTypeRepository roomTypeRepository;

        @PostMapping()
        public RoomType save( @RequestBody RoomType roomType ){ return roomTypeService.saveRoomType( roomType );}

        @GetMapping("{id}")
        public Optional<RoomType> getRoomTypeById ( @PathVariable("id") Long id)
        {
                return roomTypeService.getRoomTypeById( id );
        }

        @DeleteMapping("{id}")
        public void deleteRoomTypeById( @PathVariable("id") Long id)
        {
                roomTypeService.deleteRoomTypeById( id );
        }


}