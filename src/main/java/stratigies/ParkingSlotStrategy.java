package stratigies;

import models.Gate;
import models.ParkingSlot;
import models.VehicleType;

public interface ParkingSlotStrategy {

    public ParkingSlot assignParkingSlot(VehicleType  vehicleType, Gate gate);
}
