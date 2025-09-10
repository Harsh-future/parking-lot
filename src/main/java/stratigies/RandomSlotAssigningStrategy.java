package stratigies;

import models.*;
import service.ParkingLotService;
import service.ParkingSlotService;

import java.util.List;

public class RandomSlotAssigningStrategy implements ParkingSlotStrategy{

    private ParkingSlotService parkingSlotService;
    private ParkingLotService parkingLotService;

    public RandomSlotAssigningStrategy(ParkingSlotService parkingSlotService, ParkingLotService parkingLotService){
        this.parkingSlotService = parkingSlotService;
        this.parkingLotService = parkingLotService;
    }
    @Override
    public ParkingSlot assignParkingSlot(VehicleType vehicleType, Gate gate) {

        ParkingLot parkingLot = parkingLotService.getParkingLotByGate(gate);

        List<ParkingSlot> parkingSlotList = parkingSlotService.getAllParkingSlotByParkingLot(parkingLot);

        for(ParkingSlot parkingSlot : parkingSlotList){
            if(parkingSlot.parkingSlotStatus.equals(ParkingSlotStatus.AVAILABLE)
                && parkingSlot.getSupportedVehicleTypes().contains(vehicleType)){
                return parkingSlot;
            }
        }

        return null;
    }
}
