package com.oocl.cultivation;

public class SuperSmartParkingBoy extends ParkingBoy {
    public SuperSmartParkingBoy(ParkingLot[] parkingLots) {
        super(parkingLots);
    }

    @Override
    public ParkingTicket park(Car car) {
        ParkingLot[] parkingLots = this.getParkingLots();
        int maxAvailableRate = 0;
        int maxAvailableRateIndex = 0;
        for (int index = 0; index < parkingLots.length; index++) {
            int available = parkingLots[index].getAvailableParkingPosition();
            int capacity = parkingLots[index].getCapacity();
            if (available / capacity > maxAvailableRate) {
                maxAvailableRate = available;
                maxAvailableRateIndex = index;
            }
        }
        return super.parkingInSingleParkingLot(parkingLots[maxAvailableRateIndex], car);
    }
}
