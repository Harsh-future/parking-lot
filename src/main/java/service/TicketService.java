package service;

import exceptions.ParkingSlotNotFoundException;
import models.*;
import stratigies.ParkingSlotStrategy;

public class TicketService {

    private final VehicleService vehicleService;
    private final GateService gateService;
    private final ParkingSlotStrategy parkingSlotStrategy;

    public TicketService(VehicleService vehicleService, GateService gateService, ParkingSlotStrategy parkingSlotStrategy){
        this.vehicleService = vehicleService;
        this.gateService = gateService;
        this.parkingSlotStrategy = parkingSlotStrategy;
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
}
