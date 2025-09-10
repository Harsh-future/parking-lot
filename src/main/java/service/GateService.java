package service;

import models.Gate;
import models.ParkingLot;
import repositories.GateRepository;

public class GateService {

    private GateRepository gateRepository;

    public GateService(GateRepository gateRepository){
        this.gateRepository = gateRepository;
    }

    public Gate getGateUsingGateId(long gateId){
        return gateRepository.getGateUsingGateId(gateId);
    }

    public ParkingLot getParkingLotByGate(Gate gate){

        return null;
    }
}
