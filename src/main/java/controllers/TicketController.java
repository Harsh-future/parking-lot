package controllers;

import dtos.GenerateTicketRequestDto;
import dtos.GenerateTicketResponseDto;
import models.Ticket;
import service.TicketService;

public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }

    public GenerateTicketResponseDto generateTicket(GenerateTicketRequestDto requestDto){


        //we can not use models directly to interact with client, because :

        // 1. to avoid exposing the private data of models. we can customise the dto according to our need.
        // 2. Client can modify the data which can crash the system.

        //Flow:
        /*
            1. Controller should be as light as possible
            2. It should only do the work as the name suggests, rest of the things should be done by service.
         */

        Ticket ticket = ticketService.getTicket(requestDto.getVehicleNumber(), requestDto.getVehicleType(), requestDto.getGateId());

        GenerateTicketResponseDto responseDto = new GenerateTicketResponseDto();
        responseDto.setTicket(ticket);

        return null;
    }





}
