package service;

import exceptions.TicketNotFoundException;
import models.Bill;
import models.Ticket;
import repositories.BillReposiitory;

public class BillService {

    private BillReposiitory billReposiitory;
    private TicketService ticketService;

    public BillService(BillReposiitory billReposiitory, TicketService ticketService){
        this.billReposiitory = billReposiitory;
        this.ticketService = ticketService;
    }

    public Bill calculateBill(long ticketId) throws TicketNotFoundException {

        Ticket ticket = ticketService.getTicketByTicketId(ticketId);
        
        return null;

    }
}
