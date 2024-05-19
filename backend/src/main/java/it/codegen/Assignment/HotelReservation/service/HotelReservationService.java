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

import it.codegen.Assignment.HotelReservation.dto.ReservationRequest;
import it.codegen.Assignment.HotelReservation.dto.ReservationResult;
import it.codegen.Assignment.HotelReservation.dto.RoomDetails;
import it.codegen.Assignment.HotelReservation.models.Contract;
import it.codegen.Assignment.HotelReservation.models.Hotel;
import it.codegen.Assignment.HotelReservation.models.RoomType;
import it.codegen.Assignment.HotelReservation.repository.ContractRepository;
import it.codegen.Assignment.HotelReservation.repository.HotelRepository;
import it.codegen.Assignment.HotelReservation.repository.RoomTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.text.DecimalFormat;

/**
 * <b>Description Title</b>
 * Description Text.
 *
 * @author manujas
 * @since 22 Jul 2023
 */
@Service
public class HotelReservationService
{

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private ContractRepository contractRepository;

    @Autowired
    private RoomTypeRepository roomTypeRepository;

    //service class to get search details according to customer given details
    public List<ReservationResult> findAvailableHotels(ReservationRequest request) {
        Date endDate = calculateEndDate(request.getCheckinDate(), request.getNumberOfNights());
        List<Contract> relevantContracts = contractRepository.findContractsBetweenDates(request.getCheckinDate(), endDate);

        List<ReservationResult> results = new ArrayList<>();
        for (Contract contract : relevantContracts) {
            Hotel hotel = contract.getHotels();
            RoomType roomType = contract.getRoomTypes().get(0);
            int numberOfRoomsRequested = request.getRoom().size();
            int availableRooms = roomType.getNo_of_rooms();
            double finalPrice = calculateFinalPrice(roomType, request.getNumberOfNights(), request.getRoom());

            // Check if numberOfAdults in each room is less than relevant maxadults in room_type table
            boolean validNumberOfAdults = checkValidNumberOfAdults(roomType, request.getRoom());

            // Check room availability for each room
            boolean isAvailable = (numberOfRoomsRequested <= availableRooms);


            if (validNumberOfAdults) {
                ReservationResult result = new ReservationResult(hotel.getHotel_name(), roomType.getType_name(), finalPrice);
                result.setAvailability(isAvailable);
                results.add(result);
            }
        }

        return results;
    }
    private Date calculateEndDate(Date checkinDate, int numberOfNights) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(checkinDate);
        calendar.add(Calendar.DAY_OF_MONTH, numberOfNights);
        return calendar.getTime();
    }

    private boolean checkAvailability(RoomType roomType, int requestedRooms) {
        return requestedRooms <= roomType.getNo_of_rooms();
    }

    /**
     *
     * @param roomType
     * @param numberOfNights
     * @param rooms
     * @return
     */
    public double calculateFinalPrice(RoomType roomType, int numberOfNights, List<RoomDetails> rooms) {
        double totalPrice = 0;

        for (RoomDetails room : rooms) {
            int numberOfAdultsInRoom = room.getNumberOfAdults();
            totalPrice += roomType.getPrice() * (1 + (roomType.getMarkupPercentage() / 100)) * numberOfNights * numberOfAdultsInRoom;
        }

        return roundToTwoDecimalPlaces(totalPrice);
    }


    private double roundToTwoDecimalPlaces(double value) {
        DecimalFormat df = new DecimalFormat("#.##");
        return Double.parseDouble(df.format(value));
    }

    private boolean checkValidNumberOfAdults(RoomType roomType, List<RoomDetails> rooms) {
        for (RoomDetails room : rooms) {
            if (room.getNumberOfAdults() > roomType.getMax_adults()) {
                return false; // Invalid numberOfAdults for a room
            }
        }
        return true;
    }




}
