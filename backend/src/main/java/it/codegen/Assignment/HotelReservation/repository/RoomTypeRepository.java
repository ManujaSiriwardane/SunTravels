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

import it.codegen.Assignment.HotelReservation.models.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <b>Description Title</b>
 * Description Text.
 *
 * @author manujas
 * @since 14 Jul 2023
 */
public interface RoomTypeRepository extends JpaRepository<RoomType, Long>
{
}
