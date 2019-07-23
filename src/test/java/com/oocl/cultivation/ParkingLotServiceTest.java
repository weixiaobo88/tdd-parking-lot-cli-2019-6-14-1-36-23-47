package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotServiceTest {

    @Test
    void should_add_parkingBoy() {
        ParkingLostServiceManager parkingLostServiceManager = new ParkingLostServiceManager(getTwoParkingLots(1, 1));
        ParkingBoy parkingBoy = new ParkingBoy(getTwoParkingLots(1, 1));
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(getTwoParkingLots(1, 1));
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(getTwoParkingLots(1, 1));
        parkingLostServiceManager.add(parkingBoy);
        parkingLostServiceManager.add(smartParkingBoy);
        parkingLostServiceManager.add(superSmartParkingBoy);

        assertEquals(4, parkingLostServiceManager.getParkingBoys().length);
    }

    @Test
    void should_assign_parkingBoy_to_park_car() {
        ParkingLot[] firstParkingLots = getTwoParkingLots(1, 1);
        ParkingLostServiceManager parkingLostServiceManager = new ParkingLostServiceManager(firstParkingLots);
        ParkingLot[] secondParkingLots = getTwoParkingLots(2, 2);
        ParkingBoy parkingBoy = new ParkingBoy(secondParkingLots);
        ParkingLot[] thirdParkingLots = getTwoParkingLots(2, 2);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(thirdParkingLots);
        ParkingLot[] fourthParkingLots = getTwoParkingLots(2, 3);
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(fourthParkingLots);
        parkingLostServiceManager.add(parkingBoy);
        parkingLostServiceManager.add(smartParkingBoy);
        parkingLostServiceManager.add(superSmartParkingBoy);

        parkingLostServiceManager.park(new Car());
        assertEquals(0, firstParkingLots[0].getAvailableParkingPosition());
        assertEquals(1, firstParkingLots[1].getAvailableParkingPosition());

        parkingLostServiceManager.park(parkingBoy, new Car());
        parkingLostServiceManager.park(parkingBoy, new Car());
        assertEquals(0, secondParkingLots[0].getAvailableParkingPosition());
        assertEquals(2, secondParkingLots[1].getAvailableParkingPosition());

        parkingLostServiceManager.park(smartParkingBoy, new Car());
        parkingLostServiceManager.park(smartParkingBoy, new Car());
        assertEquals(1, thirdParkingLots[0].getAvailableParkingPosition());
        assertEquals(1, thirdParkingLots[1].getAvailableParkingPosition());

        parkingLostServiceManager.park(superSmartParkingBoy, new Car());
        parkingLostServiceManager.park(superSmartParkingBoy, new Car());
        parkingLostServiceManager.park(superSmartParkingBoy, new Car());
        assertEquals(0, fourthParkingLots[0].getAvailableParkingPosition());
        assertEquals(2, fourthParkingLots[1].getAvailableParkingPosition());
    }


    @Test
    void should_assign_parkingBoy_to_fetch_car() {
        ParkingLot[] firstParkingLots = getTwoParkingLots(1, 1);
        ParkingLostServiceManager parkingLostServiceManager = new ParkingLostServiceManager(firstParkingLots);
        ParkingLot[] secondParkingLots = getTwoParkingLots(2, 2);
        ParkingBoy parkingBoy = new ParkingBoy(secondParkingLots);
        parkingLostServiceManager.add(parkingBoy);

        Car car = new Car();
        ParkingTicket parkingTicket = parkingLostServiceManager.park(parkingBoy, car);
        assertEquals(car, parkingLostServiceManager.fetch(parkingBoy, parkingTicket));
    }


    @Test
    void should_query_error_message_for_used_ticket() {
        ParkingLot[] firstParkingLots = getTwoParkingLots(1, 1);
        ParkingLostServiceManager parkingLostServiceManager = new ParkingLostServiceManager(firstParkingLots);
        ParkingLot[] secondParkingLots = getTwoParkingLots(2, 2);
        ParkingBoy parkingBoy = new ParkingBoy(secondParkingLots);
        parkingLostServiceManager.add(parkingBoy);

        Car car = new Car();
        ParkingTicket parkingTicket = parkingLostServiceManager.park(parkingBoy, car);
        parkingLostServiceManager.fetch(parkingBoy, parkingTicket);
        parkingLostServiceManager.fetch(parkingBoy, parkingTicket);

        assertEquals(
                "Unrecognized parking ticket.",
                parkingBoy.getLastErrorMessage()
        );
    }

    private ParkingLot[] getTwoParkingLots(int firstCapacity, int secondCapacity) {
        ParkingLot firstParkingLot = new ParkingLot(firstCapacity);
        ParkingLot secondParkingLot = new ParkingLot(secondCapacity);
        return new ParkingLot[]{
                firstParkingLot,
                secondParkingLot
        };
    }
}