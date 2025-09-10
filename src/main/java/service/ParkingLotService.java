package service;

import models.Gate;
import models.ParkingLot;
import models.ParkingSlot;
import repositories.ParkingLotRepository;

import java.util.List;

public class ParkingLotService {

    private ParkingLotRepository parkingLotRepository;

    public ParkingLotService (ParkingLotRepository parkingLotRepository){
        this.parkingLotRepository = parkingLotRepository;
    }

    public ParkingLot getParkingLotByGate(Gate gate){
        return parkingLotRepository.getParkingLotByGate(gate);
    }

}
