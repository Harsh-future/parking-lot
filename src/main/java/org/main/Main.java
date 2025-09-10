package org.main;

import ObjectContainer.ObjectContainer;
import controllers.TicketController;
import dtos.GenerateTicketRequestDto;
import dtos.GenerateTicketResponseDto;
import models.Ticket;
import models.VehicleType;
import repositories.GateRepository;
import repositories.ParkingLotRepository;
import repositories.ParkingSlotRepository;
import repositories.VehicleRepository;
import service.*;
import stratigies.ParkingSlotStrategy;
import stratigies.RandomSlotAssigningStrategy;

public class Main {
    public static void main(String[] args) {

        ObjectContainer objectContainer = new ObjectContainer();

        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        ParkingLotService parkingLotService = new ParkingLotService(parkingLotRepository);

        GateRepository gateRepository = new GateRepository();
        GateService gateService = new GateService(gateRepository);

        ParkingSlotRepository parkingSlotRepository = new ParkingSlotRepository();

        ParkingSlotService parkingSlotService = new ParkingSlotService(parkingSlotRepository,parkingLotService);

        VehicleRepository vehicleRepository = new VehicleRepository();
        VehicleService vehicleService = new VehicleService(vehicleRepository);

        ParkingSlotStrategy parkingSlotStrategy = new RandomSlotAssigningStrategy(parkingSlotService,parkingLotService);
        TicketService ticketService = new TicketService(vehicleService,gateService,parkingSlotStrategy);

        objectContainer.register("ticketService",ticketService);
        objectContainer.register("vehicleService",vehicleService);
        objectContainer.register("vehicleRepository",vehicleRepository);
        // and so on.....
        /*
            We can store all the services and repos and whatever object we need, and
            then fetch it from object container.
         */

        GenerateTicketRequestDto requestDto = new GenerateTicketRequestDto();
        requestDto.setGateId(1245L);
        requestDto.setVehicleNumber("HR98M5876");
        requestDto.setVehicleType(VehicleType.TWO_WHEELER);

        TicketController ticketController = new TicketController(ticketService);
        GenerateTicketResponseDto responseDto = ticketController.generateTicket(requestDto);

        Ticket ticket = responseDto.getTicket();

        System.out.println("Ticket");
        System.out.println("Entry time - " + ticket.getEntryTime() );
        System.out.println("Entry Gate - " + ticket.getEntryGate());

    }
}