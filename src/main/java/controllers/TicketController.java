package controllers;

import models.Ticket;

public class TicketController {

    public Ticket generateTicket(GenerateTicketRequestDto generateTicketRequestDto){

        return null;
    }



    //we can not use models directly to interact with client, because :

    // 1. to avoid exposing the private data of models. we can customise the dto according to our need.
    // 2. Client can modify the data which can crash the system.


}
