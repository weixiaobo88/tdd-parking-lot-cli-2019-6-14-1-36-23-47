package com.oocl.cultivation;

public class ParkingLotManagerWithSuperSmart {
    private SuperSmartParkingBoy parkingBoy;

    public void assign(SuperSmartParkingBoy parkingBoy) {
        this.parkingBoy = parkingBoy;
    }

    public void park(Car car) {
        parkingBoy.park(car);
    }
}
