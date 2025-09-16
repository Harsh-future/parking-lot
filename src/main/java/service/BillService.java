package service;

import exceptions.TicketNotFoundException;
import models.Bill;
import models.BillStatus;
import models.Ticket;
import repositories.BillReposiitory;
import stratigies.BillCalculationStrategy;

public class BillService {

    private BillReposiitory billReposiitory;
    private TicketService ticketService;
    private BillCalculationStrategy billCalculationStrategy;

    public BillService(BillReposiitory billReposiitory, TicketService ticketService,
            BillCalculationStrategy billCalculationStrategy){
        this.billReposiitory = billReposiitory;
        this.ticketService = ticketService;
        this.billCalculationStrategy = billCalculationStrategy;
    }

    public Bill calculateBill(long ticketId) throws TicketNotFoundException {


        Ticket ticket = ticketService.getTicketByTicketId(ticketId);

        if(ticket == null){
            throw new TicketNotFoundException(" Ticket not found, Fraud Ticket Reported");
        }

        long timeCalculated = System.currentTimeMillis() - ticket.getEntryTime();

        double price = billCalculationStrategy.calculateBill(timeCalculated);

        Bill bill = new Bill();

        bill.setBillStatus(BillStatus.PAID);
        bill.setAmount(price);
        bill.setEntryTime(ticket.getEntryTime());
        bill.setGate(ticket.getEntryGate());
        bill.setExitTime(System.currentTimeMillis());
        bill.setVehicleNumber(ticket.getVehicle().getVehicleNumber());
        bill.setId(1234);

        return bill;

    }
}
