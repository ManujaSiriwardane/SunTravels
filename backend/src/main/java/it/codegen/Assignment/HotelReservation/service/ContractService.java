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
import it.codegen.Assignment.HotelReservation.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


/**
 * <b>Description Title</b>
 * Description Text.
 *
 * @author manujas
 * @since 12 Jul 2023
 */
@Service
public class ContractService

{
//    @Autowired
//    public ContractRepository contractRepository;

    private final ContractRepository contractRepository;

    @Autowired
    public ContractService(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }


    public Contract save( Contract contract )
    {

        return contractRepository.save( contract );

    }

    public Optional<Contract> getById( Long id )
    {
        return contractRepository.findById( id );
    }

    //to get contracts by hotel name

    public List<Contract> getContractsByHotelName(String hotelName) {
        return contractRepository.findContractsByHotelName(hotelName);
    }




    public void deleteById( Long id )
    {
        contractRepository.deleteById( id );
    }

    public List<Contract> getAllContracts()
    {
        return  contractRepository.findAll();
    }


}