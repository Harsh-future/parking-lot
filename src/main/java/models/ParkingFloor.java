package models;

import base.BaseEntity;

import java.util.List;

public class ParkingFloor extends BaseEntity {

    private int floorNumber;

    private List<ParkingSlot> parkingSlotList;

    private BaseStatus parkingFloorStatus;

    public int getFloorNumber() {

        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public List<ParkingSlot> getParkingSlotList() {
        return parkingSlotList;
    }

    public void setParkingSlotList(List<ParkingSlot> parkingSlotList) {
        this.parkingSlotList = parkingSlotList;
    }

    public BaseStatus getParkingFloorStatus() {
        return parkingFloorStatus;
    }

    public void setParkingFloorStatus(BaseStatus parkingFloorStatus) {
        this.parkingFloorStatus = parkingFloorStatus;
    }
}
