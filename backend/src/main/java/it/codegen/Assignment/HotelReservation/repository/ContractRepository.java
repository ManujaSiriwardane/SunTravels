/*
 * Copyright (c) 2023. CodeGen International (Pvt) Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of CodeGen
 * International (Pvt) Ltd. ("Confidential Information"). You shall not disclose
 * such Confidential Information and shall use it only in accordance with the
 * terms of the license agreement you entered into with CodeGen International.
 *
 */
package it.codegen.Assignment.HotelReservation.repository;

import it.codegen.Assignment.HotelReservation.models.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

/**
 * <b>Description Title</b>
 * Description Text.
 *
 * @author manujas
 * @since 13 Jul 2023
 */
public interface ContractRepository extends JpaRepository<Contract, Long>
{
    @Query("SELECT c FROM Contract c WHERE c.start_date < :endDate AND c.end_date > :startDate")
    List<Contract> findContractsBetweenDates(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

    @Query("SELECT c FROM Contract c JOIN FETCH c.hotels h JOIN FETCH c.roomTypes rt WHERE h.hotel_name = :hotelName")
    List<Contract> findContractsByHotelName(@Param("hotelName") String hotelName);

}

