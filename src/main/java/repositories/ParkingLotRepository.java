package repositories;

import models.Gate;
import models.ParkingLot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotRepository {


    // local db to store less amount of data\
    // do not need dbConnection

    List<ParkingLot> parkingLotList = new ArrayList<>();

    public ParkingLot getParkingLotByGate(Gate gate){

        for(ParkingLot parkingLot : parkingLotList){
            for(Gate gate1 : parkingLot.getGates()){
                if(gate1.getId() == gate.getId()){
                    return parkingLot;
                }
            }
        }
        return null;
    }
}
