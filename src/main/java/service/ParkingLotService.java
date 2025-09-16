package service;

import exceptions.ParkingLotNotFoundException;
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

    public void addParkingLot(ParkingLot parkingLot){
        parkingLotRepository.addParkingLot(parkingLot);
    }

    public ParkingLot getParkingLotById(long parkingLotId) throws ParkingLotNotFoundException {
        ParkingLot parkingLot = parkingLotRepository.getParkingLotById(parkingLotId);

        if(parkingLot == null){
            throw new ParkingLotNotFoundException("Parking Lot not found!");
        }
        return parkingLot;
    }

}
