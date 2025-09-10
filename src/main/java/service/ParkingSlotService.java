package service;

import models.*;
import repositories.ParkingSlotRepository;

import java.util.List;

public class ParkingSlotService {

    private ParkingSlotRepository parkingSlotRepository;
    private ParkingLotService parkingLotService;

    public ParkingSlotService(ParkingSlotRepository parkingSlotRepository, ParkingLotService parkingLotService){
        this.parkingSlotRepository = parkingSlotRepository;
        this.parkingLotService = parkingLotService;

    }

    public List<ParkingSlot> getAllParkingSlotByParkingLot(ParkingLot parkingLot){

        return null;
    }
}
