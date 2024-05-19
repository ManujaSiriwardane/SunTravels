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

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

/**
 * <b>Description Title</b>
 * Description Text.
 *
 * @author manujas
 * @since 13 Jul 2023
 */
@Entity
@Table(name = "room_type")
public class RoomType

    {
        @Id
        @GeneratedValue(strategy =  GenerationType.IDENTITY)
        private Long type_id;

        @Column
        private String type_name;
        @Column
        private double price;

        @Column
        private int no_of_rooms;

        @Column
        private int max_adults;

        @JsonBackReference
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "contract_id", referencedColumnName = "id")
        private Contract contract;

        @Column
        private double markupPercentage;



        public long getType_id()
        {
            return type_id;
        }

        public void setType_id( long type_id )
        {
            this.type_id = type_id;
        }

        public String getType_name()
        {
            return type_name;
        }

        public void setType_name( String type_name )
        {
            this.type_name = type_name;
        }

        public double getPrice()
        {
            return price;
        }

        public void setPrice( double price )
        {
;
            this.price = price;
        }

        public int getNo_of_rooms()
        {
            return no_of_rooms;
        }

        public void setNo_of_rooms( int no_of_rooms )
        {
            this.no_of_rooms = no_of_rooms;
        }

        public int getMax_adults()
        {
            return max_adults;
        }

        public void setMax_adults( int max_adults )
        {
            this.max_adults = max_adults;
        }

        public void setType_id( Long type_id )
        {
            this.type_id = type_id;
        }



        public Contract getContract()
        {
            return contract;
        }

        public void setContract( Contract contract )
        {
            this.contract = contract;
        }

        public boolean areRoomsAvailable(int requestedRooms) {
            return requestedRooms <= no_of_rooms;
        }
        public double getMarkupPercentage()
        {
            return markupPercentage;
        }

        public void setMarkupPercentage( double markupPercentage )
        {
            this.markupPercentage = markupPercentage;
        }


    }