package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotManagerWithSmartTest {
    @Test
    void should_park_cars_smart() {
        ParkingLotManagerWithSmart parkingLotManager = new ParkingLotManagerWithSmart();
        ParkingLot firstParkingLot = new ParkingLot(2);
        ParkingLot secondParkingLot = new ParkingLot(2);
        ParkingLot[] parkingLots = new ParkingLot[]{
                firstParkingLot,
                secondParkingLot
        };
        SmartParkingBoy parkingBoy = new SmartParkingBoy(parkingLots);
        parkingLotManager.assign(parkingBoy);
        parkingLotManager.park(new Car());
        parkingLotManager.park(new Car());

        assertEquals(1, firstParkingLot.getAvailableParkingPosition());
        assertEquals(1, secondParkingLot.getAvailableParkingPosition());
    }
}