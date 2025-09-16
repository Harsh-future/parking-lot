package controllers;

import dtos.BillRequestDto;
import dtos.GenerateBillResponseDto;
import exceptions.TicketNotFoundException;
import models.Bill;
import models.Ticket;
import service.BillService;

public class BillController {

    private BillService billService;

    public BillController(BillService billService){
        this.billService = billService;
    }

    public GenerateBillResponseDto getBill(BillRequestDto billRequestDto) throws TicketNotFoundException {

        GenerateBillResponseDto billResponseDto = new GenerateBillResponseDto();

        Bill bill = billService.calculateBill(billRequestDto.getTicketId());

        billResponseDto.setBill(bill);

        // add logic for status handling
        return billResponseDto;
    }
}
