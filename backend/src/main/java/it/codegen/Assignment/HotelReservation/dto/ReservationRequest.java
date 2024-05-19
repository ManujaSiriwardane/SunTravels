/*
 * Copyright (c) 2023. CodeGen International (Pvt) Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of CodeGen
 * International (Pvt) Ltd. ("Confidential Information"). You shall not disclose
 * such Confidential Information and shall use it only in accordance with the
 * terms of the license agreement you entered into with CodeGen International.
 *
 */
package it.codegen.Assignment.HotelReservation.dto;

import it.codegen.Assignment.HotelReservation.models.RoomType;

import java.util.Date;
import java.util.List;

/**
 * <b>Description Title</b>
 * Description Text.
 *
 * @author manujas
 * @since 22 Jul 2023
 */

public class ReservationRequest
{

    private Date checkinDate;
    private int numberOfNights;
    private List<RoomDetails> room;




    public Date getCheckinDate()
    {
        return checkinDate;
    }

    public void setCheckinDate( Date checkinDate )
    {
        this.checkinDate = checkinDate;
    }

    public int getNumberOfNights()
    {
        return numberOfNights;
    }

    public void setNumberOfNights( int numberOfNights )
    {
        this.numberOfNights = numberOfNights;
    }

    public List<RoomDetails> getRoom()
    {
        return room;
    }

    public void setRoom( List<RoomDetails> room )
    {
        this.room = room;
    }
}
