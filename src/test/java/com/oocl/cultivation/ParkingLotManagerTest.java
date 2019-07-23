package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotManagerTest {
    @Test
    void should_have_parking_boy() {
        ParkingLotManager parkingLotManager = new ParkingLotManager();
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        parkingLotManager.assign(parkingBoy);

        assertNotNull(parkingLotManager.getParkingBoy());
    }

    @Test
    void should_have_multiple_parking_lots() {
        ParkingLot firstParkingLot = new ParkingLot();
        ParkingLot secondParkingLot = new ParkingLot();
        ParkingLot[] parkingLots = new ParkingLot[]{
            firstParkingLot,
            secondParkingLot
        };
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);

        assertEquals(2, parkingBoy.getParkingLots().length);
    }

    @Test
    void should_park_cars_sequentially() {
        ParkingLotManager parkingLotManager = new ParkingLotManager();
        ParkingLot firstParkingLot = new ParkingLot(2);
        ParkingLot secondParkingLot = new ParkingLot(2);
        ParkingLot[] parkingLots = new ParkingLot[]{
                firstParkingLot,
                secondParkingLot
        };
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        parkingLotManager.assign(parkingBoy);
        parkingLotManager.park(new Car());
        parkingLotManager.park(new Car());

        assertEquals(0, firstParkingLot.getAvailableParkingPosition());
        assertEquals(2, secondParkingLot.getAvailableParkingPosition());
    }
}