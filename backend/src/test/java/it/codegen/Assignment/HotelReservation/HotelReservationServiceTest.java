/*
 * Copyright (c) 2023. CodeGen International (Pvt) Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of CodeGen
 * International (Pvt) Ltd. ("Confidential Information"). You shall not disclose
 * such Confidential Information and shall use it only in accordance with the
 * terms of the license agreement you entered into with CodeGen International.
 *
 */
package it.codegen.Assignment.HotelReservation;

import it.codegen.Assignment.HotelReservation.dto.ReservationRequest;
import it.codegen.Assignment.HotelReservation.dto.ReservationResult;
import it.codegen.Assignment.HotelReservation.models.Contract;
import it.codegen.Assignment.HotelReservation.models.Hotel;
import it.codegen.Assignment.HotelReservation.models.RoomType;
import it.codegen.Assignment.HotelReservation.repository.ContractRepository;
import it.codegen.Assignment.HotelReservation.service.HotelReservationService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * <b>Description Title</b>
 * Description Text.
 *
 * @author manujas
 * @since 23 Jul 2023
 */
@RunWith( MockitoJUnitRunner.class)
public class HotelReservationServiceTest
{
    @InjectMocks
    private HotelReservationService hotelReservationService;

    @Mock
    private ContractRepository contractRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindAvailableHotels() {
        // Create a sample reservation request
        ReservationRequest request = new ReservationRequest();
        request.setCheckinDate(new Date());
        request.setNumberOfNights(3);
        request.setNumberOfRooms(2);
        request.setNumberOfAdults(2);

        // Create a sample hotel, contract, and room type
        Hotel hotel = new Hotel();
        hotel.setHotel_id(1L);
        hotel.setHotel_name("Sample Hotel");
        hotel.setAddress("123 Main St");
        hotel.setCity("Sample City");

        Contract contract = new Contract();
        contract.setId(1L);
        contract.setHotels(hotel);
        contract.setStart_date(Date.from( Instant.now().minus(2, ChronoUnit.DAYS))); // Contract start date 2 days ago
        contract.setEnd_date(Date.from(Instant.now().plus(5, ChronoUnit.DAYS)));   // Contract end date 5 days from now

        RoomType roomType = new RoomType();
        roomType.setType_id(1L);
        roomType.setType_name("Standard Room");
        roomType.setPrice(100.0);
        roomType.setMarkupPercentage(2);
        contract.setRoomTypes( Collections.singletonList(roomType));

        // Mock the behavior of the contractRepository
        when(contractRepository.findContractsBetweenDates(any(),any()))
                .thenReturn(Collections.singletonList(contract));

        // Call the service method
        List<ReservationResult> results = hotelReservationService.findAvailableHotels(request);

        // Verify the results
        assertNotNull(results);
        assertEquals(1, results.size());

        ReservationResult result = results.get(0);
        assertEquals("Sample Hotel", result.getHotelName());
        assertEquals("Standard Room", result.getRoomTypeName());
        assertEquals(480.0, result.getFinalPrice(), 0.001);
    }
}
