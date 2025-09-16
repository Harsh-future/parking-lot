package factory;

import models.VehicleType;
import stratigies.*;

public class BillCalculationFactory {


    public BillCalculationStrategy billCalculationStrategy(VehicleType vehicleType, long timeCalculated){

        if(vehicleType.equals(VehicleType.TWO_WHEELER)){
            return new TwoWheelerBillCalcStrategy();
        }
        else if(vehicleType.equals(VehicleType.HATCHBACK)){
            return new HatchbackBillCalcStrategy();
        }
        else if(vehicleType.equals(VehicleType.SEDAN)){
            return new SedanBillCalcStrategy();
        }
        else if(vehicleType.equals(VehicleType.TRUCK)){
            return new TruckBillCalcStrategy();
        }

        return null;
    }
}
