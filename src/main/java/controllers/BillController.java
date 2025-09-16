package controllers;

import Utils.ResponseStatus;
import dtos.BillRequestDto;
import dtos.GenerateBillResponseDto;
import exceptions.TicketNotFoundException;
import models.Bill;
import service.BillService;

public class BillController {

    private BillService billService;

    public BillController(BillService billService){
        this.billService = billService;
    }

    public GenerateBillResponseDto getBill(BillRequestDto billRequestDto) {

        GenerateBillResponseDto billResponseDto = new GenerateBillResponseDto();

        try{

            Bill bill = billService.calculateBill(billRequestDto.getTicketId());
            billResponseDto.setBill(bill);

        } catch (TicketNotFoundException ticketNotFoundException) {
            billResponseDto.setResponseStatus(ResponseStatus.FAILURE);
            System.out.println("Bill not generated cause ticket not found. May be ticket is fraudulent");
        }

        // add logic for status handling
        return billResponseDto;
    }
}
