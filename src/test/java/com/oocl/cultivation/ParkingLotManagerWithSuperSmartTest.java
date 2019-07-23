package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotManagerWithSuperSmartTest {
    @Test
    void should_park_cars_super_smart() {
        ParkingLotManagerWithSuperSmart parkingLotManager = new ParkingLotManagerWithSuperSmart();
        ParkingLot firstParkingLot = new ParkingLot(2);
        ParkingLot secondParkingLot = new ParkingLot(3);
        ParkingLot[] parkingLots = new ParkingLot[]{
                firstParkingLot,
                secondParkingLot
        };
        SuperSmartParkingBoy parkingBoy = new SuperSmartParkingBoy(parkingLots);
        parkingLotManager.assign(parkingBoy);
        parkingLotManager.park(new Car());
        parkingLotManager.park(new Car());

        assertEquals(1, firstParkingLot.getAvailableParkingPosition());
        assertEquals(2, secondParkingLot.getAvailableParkingPosition());
        parkingLotManager.park(new Car());
        assertEquals(0, firstParkingLot.getAvailableParkingPosition());
    }
}
