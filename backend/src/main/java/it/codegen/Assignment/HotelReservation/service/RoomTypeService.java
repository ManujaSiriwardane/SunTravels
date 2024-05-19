/*
 * Copyright (c) 2023. CodeGen International (Pvt) Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of CodeGen
 * International (Pvt) Ltd. ("Confidential Information"). You shall not disclose
 * such Confidential Information and shall use it only in accordance with the
 * terms of the license agreement you entered into with CodeGen International.
 *
 */
package it.codegen.Assignment.HotelReservation.service;

import it.codegen.Assignment.HotelReservation.models.RoomType;
import it.codegen.Assignment.HotelReservation.repository.RoomTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * <b>Description Title</b>
 * Description Text.
 *
 * @author manujas
 * @since 14 Jul 2023
 */
@Service
public class RoomTypeService
{
    @Autowired
    public RoomTypeRepository roomTypeRepository;

    public RoomType saveRoomType( RoomType roomType){
        return roomTypeRepository.save(roomType);
    }
    public Optional<RoomType> getRoomTypeById( Long id )
    {
        return roomTypeRepository.findById( id );
    }

    public void deleteRoomTypeById( Long id )
    {
        roomTypeRepository.deleteById( id );
    }

}