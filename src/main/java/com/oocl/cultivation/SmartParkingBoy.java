package com.oocl.cultivation;

public class SmartParkingBoy extends ParkingBoy {
    public SmartParkingBoy(ParkingLot[] parkingLots) {
        super(parkingLots);
    }

    @Override
    public ParkingTicket park(Car car) {
        ParkingLot[] parkingLots = this.getParkingLots();
        int maxAvailable = 0;
        int maxAvailableIndex = 0;
        for (int index = 0; index < parkingLots.length; index++) {
            int available = parkingLots[index].getAvailableParkingPosition();
            if (available > maxAvailable) {
                maxAvailable = available;
                maxAvailableIndex = index;
            }
        }
        return super.parkingInSingleParkingLot(parkingLots[maxAvailableIndex], car);
    }
}
