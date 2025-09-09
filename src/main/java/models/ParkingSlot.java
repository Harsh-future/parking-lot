package models;

import base.BaseEntity;

public class ParkingSlot extends BaseEntity {

    public VehicleType vehicleType;

    public BaseStatus baseStatus;

    public int slotNumber;

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public BaseStatus getParkingSlotStatus() {
        return baseStatus;
    }

    public void setParkingSlotStatus(BaseStatus baseStatus) {
        this.baseStatus = baseStatus;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(int slotNumber) {
        this.slotNumber = slotNumber;
    }
}
