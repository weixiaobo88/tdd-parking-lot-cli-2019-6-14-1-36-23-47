package com.oocl.cultivation;

public class ParkingLotManager {
    private ParkingBoy parkingBoy;

    public void assign(ParkingBoy parkingBoy) {
        this.parkingBoy = parkingBoy;
    }

    public ParkingBoy getParkingBoy() {
        return parkingBoy;
    }

    public void park(Car car) {
        parkingBoy.park(car);
    }
}
