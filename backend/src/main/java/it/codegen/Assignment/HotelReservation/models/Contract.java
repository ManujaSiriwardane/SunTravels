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


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

/**
 * <b>Description Title</b>
 * Description Text.
 *
 * @author manujas
 * @since 12 Jul 2023
 */
@Entity
public class Contract
{
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn( name = "hotel_id" )

    private Hotel hotels;


    @JsonManagedReference
    @OneToMany( cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn( name = "contract_id" )
    private List<RoomType> roomTypes;

    @Column
    private Date start_date;

    @Column
    private Date end_date;


    public Long getId()
    {
        return id;
    }

    public void setId( Long id )
    {
        this.id = id;
    }


    public Date getStart_date()
    {
        return start_date;
    }

    public void setStart_date( Date start_date )
    {
        this.start_date = start_date;
    }

    public Date getEnd_date()
    {
        return end_date;
    }

    public void setEnd_date( Date end_date )
    {
        this.end_date = end_date;
    }

    public Hotel getHotels()
    {
        return hotels;
    }

    public void setHotels( Hotel hotels )
    {
        this.hotels = hotels;
    }

    public List<RoomType> getRoomTypes()
    {
        return roomTypes;
    }

    public void setRoomTypes( List<RoomType> roomTypes )
    {
        this.roomTypes = roomTypes;
    }


}