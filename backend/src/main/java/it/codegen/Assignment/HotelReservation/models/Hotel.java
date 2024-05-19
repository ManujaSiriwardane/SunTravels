/*
 * Copyright (c) 2023. CodeGen International (Pvt) Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of CodeGen
 * International (Pvt) Ltd. ("Confidential Information"). You shall not disclose
 * such Confidential Information and shall use it only in accordance with the
 * terms of the license agreement you entered into with CodeGen International.
 *
 */
package it.codegen.Assignment.HotelReservation.models;

import jakarta.persistence.*;


/**
 * <b>Description Title</b>
 * Description Text.
 *
 * @author manujas
 * @since 12 Jul 2023
 */
@Entity
public class Hotel
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hotel_id;



    private String hotel_name;
    private String address;
    private String city;

    public long getHotel_id()
    {
        return hotel_id;
    }

    public void setHotel_id( long hotel_id )
    {
        this.hotel_id = hotel_id;
    }

    public String getHotel_name()
    {
        return hotel_name;
    }

    public void setHotel_name( String hotel_name )
    {
        this.hotel_name = hotel_name;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress( String address )
    {
        this.address = address;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity( String city )
    {
        this.city = city;
    }
}
