package service;

import models.Gate;
import repositories.GateRepository;

public class GateService {

    private GateRepository gateRepository;

    public GateService(GateRepository gateRepository){
        this.gateRepository = gateRepository;
    }

    public Gate getGate(long gateId){
        return gateRepository.getGate(gateId);
    }
}
