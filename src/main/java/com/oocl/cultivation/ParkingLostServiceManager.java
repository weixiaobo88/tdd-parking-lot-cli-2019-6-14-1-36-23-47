package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.Arrays;

public class ParkingLostServiceManager extends ParkingBoy {
    private ParkingBoy[] parkingBoys = new ParkingBoy[]{};

    public ParkingLostServiceManager(ParkingLot[] parkingLots) {
        super(parkingLots);
        add(this);
    }


    public void add(ParkingBoy parkingBoy) {
        parkingBoys = addTo(parkingBoys, parkingBoy);
    }

    private ParkingBoy[] addTo(ParkingBoy[] parkingBoys, ParkingBoy parkingBoy) {
        ArrayList<ParkingBoy> temp = new ArrayList<>(Arrays.asList(parkingBoys));
        temp.add(parkingBoy);
        return temp.toArray(new ParkingBoy[0]);
    }

    public ParkingBoy[] getParkingBoys() {
        return parkingBoys;
    }

    @Override
    public ParkingTicket park(ParkingBoy parkingBoy, Car car) {
        return parkingBoy.park(car);
    }

    public Car fetch(ParkingBoy parkingBoy, ParkingTicket parkingTicket) {
        return parkingBoy.fetch(parkingTicket);
    }
}
