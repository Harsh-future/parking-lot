package service;

import exceptions.ParkingSlotNotFoundException;
import exceptions.TicketNotFoundException;
import models.*;
import repositories.TicketRepository;
import stratigies.ParkingSlotStrategy;

public class TicketService {

    private final VehicleService vehicleService;
    private final GateService gateService;
    private final ParkingSlotStrategy parkingSlotStrategy;
    private final TicketRepository ticketRepository;

    public TicketService(VehicleService vehicleService, GateService gateService
            , ParkingSlotStrategy parkingSlotStrategy, TicketRepository  ticketRepository){
        this.vehicleService = vehicleService;
        this.gateService = gateService;
        this.parkingSlotStrategy = parkingSlotStrategy;
        this.ticketRepository = ticketRepository;
    }

    public Ticket getTicket(String vehicleNumber, VehicleType vehicleType, Long gateId) throws ParkingSlotNotFoundException{

        Vehicle vehicle = vehicleService.getVehicle(vehicleNumber);

        if(vehicle == null){
            vehicle = vehicleService.register(vehicleNumber,vehicleType);
        }

        Gate gate = gateService.getGateUsingGateId(gateId);

        Ticket ticket = new Ticket();
        ticket.setVehicleNumber(vehicle);
        ticket.setEntryGate(gate);
        ticket.setEntryTime(System.currentTimeMillis());

        ParkingSlot parkingSlot = parkingSlotStrategy.assignParkingSlot(vehicleType,gate);

        if(parkingSlot == null) {
            //no parking spot is available
            // throw exception
            throw new ParkingSlotNotFoundException("ParkingSlot Not Available");
        }

        ticket.setParkingSlot(parkingSlot);
        return null;
    }

    public Ticket getTicketByTicketId(long ticketId) throws TicketNotFoundException {

        Ticket  ticket = ticketRepository.getTicketByTicketId(ticketId);

        if(ticket == null){
            throw new TicketNotFoundException(" Ticket not found, Fraud Ticket Reported");
        }
        return ticket;
    }
}
