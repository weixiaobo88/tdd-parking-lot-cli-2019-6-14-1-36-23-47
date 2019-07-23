package com.oocl.cultivation;

public class ParkingLotManagerWithSmart {
    private SmartParkingBoy parkingBoy;

    public void assign(SmartParkingBoy parkingBoy) {
        this.parkingBoy = parkingBoy;
    }

    public void park(Car car) {
        parkingBoy.park(car);
    }
}
