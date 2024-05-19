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

/**
 * <b>Description Title</b>
 * Description Text.
 *
 * @author manujas
 * @since 23 Jul 2023
 */
public class ReservationResult
{
    private String hotelName;
    private String roomTypeName;
    private double finalPrice;

    private boolean availability;

    // No-argument constructor
    public ReservationResult() {
    }

    // Constructor with arguments
    public ReservationResult(String hotelName, String roomTypeName, double finalPrice) {
        this.hotelName = hotelName;
        this.roomTypeName = roomTypeName;
        this.finalPrice = finalPrice;
    }

    // Getters and setters for each field
    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getRoomTypeName() {
        return roomTypeName;
    }

    public void setRoomTypeName(String roomTypeName) {
        this.roomTypeName = roomTypeName;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }

    public boolean isAvailability()
    {
        return availability;
    }

    public void setAvailability( boolean availability )
    {
        this.availability = availability;
    }
}
