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

import it.codegen.Assignment.HotelReservation.models.Contract;
import it.codegen.Assignment.HotelReservation.models.Hotel;
import it.codegen.Assignment.HotelReservation.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * <b>Description Title</b>
 * Description Text.
 *
 * @author manujas
 * @since 13 Jul 2023
 */
@Service
public class HotelService
{
    @Autowired
    public HotelRepository hotelRepository;

    public Hotel saveHotel(Hotel hotel){
        return hotelRepository.save(hotel);
    }
    public Optional<Hotel> getById( Long id )
    {
        return hotelRepository.findById( id );
    }

    public void deleteById( Long id )
    {
        hotelRepository.deleteById( id );
    }

}
