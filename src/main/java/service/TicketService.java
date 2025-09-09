package service;

import models.Gate;
import models.Ticket;
import models.Vehicle;
import models.VehicleType;

public class TicketService {

    private final VehicleService vehicleService;
    private final GateService gateService;

    public TicketService(VehicleService vehicleService, GateService gateService){
        this.vehicleService = vehicleService;
        this.gateService = gateService;
    }

    public Ticket getTicket(String vehicleNumber, VehicleType vehicleType, Long gateId){

        Vehicle vehicle = vehicleService.getVehicle(vehicleNumber);

        if(vehicle == null){
            vehicle = vehicleService.register(vehicleNumber,vehicleType);
        }

        Gate gate = gateService.getGate(gateId);

        Ticket ticket = new Ticket();
        ticket.setVehicleNumber(vehicleNumber);
        ticket.setEntryGate(gate);

        return null;
    }
}
