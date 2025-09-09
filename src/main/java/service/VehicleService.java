package service;

import models.Vehicle;
import models.VehicleType;
import repositories.VehicleRepository;

public class VehicleService {

    private VehicleRepository vehicleRepo;

    public VehicleService(VehicleRepository vehicleRepo){
        this.vehicleRepo = vehicleRepo;
    }

    public Vehicle getVehicle(String vehicleNumber){

        return  vehicleRepo.getVehicleByVehicleNumber(vehicleNumber);
    }

    public Vehicle register(String vehicleNumber, VehicleType vehicleType){

        return vehicleRepo.registerVehicle(vehicleNumber,vehicleType);
    }
}
