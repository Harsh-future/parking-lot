package repositories;

import models.Gate;
import models.ParkingLot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLotRepository {


    // local db to store less amount of data\
    // do not need dbConnection

    Map<Long,ParkingLot> parkingLotList = new HashMap<>();

    public ParkingLot getParkingLotByGate(Gate gate){

        for(ParkingLot parkingLot : parkingLotList.values()){
            for(Gate gate1 : parkingLot.getGates()){
                if(gate1.getId() == gate.getId()){
                    return parkingLot;
                }
            }
        }
        return null;
    }
}
