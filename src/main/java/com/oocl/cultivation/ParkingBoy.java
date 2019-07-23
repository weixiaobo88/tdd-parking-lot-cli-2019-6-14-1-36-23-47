package com.oocl.cultivation;

public class ParkingBoy {

    private ParkingLot parkingLot = null;
    private String lastErrorMessage;
    private ParkingLot[] parkingLots;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingBoy(ParkingLot[] parkingLots) {
        this.parkingLots = parkingLots;
    }

    public ParkingTicket park(Car car) {
        if (null != parkingLots && parkingLots.length > 0) {
            return parkingInMultipleParkingLots(parkingLots, car);
        }

        return this.parkingInSingleParkingLot(parkingLot, car);
    }

    private ParkingTicket parkingInMultipleParkingLots(ParkingLot[] parkingLots, Car car) {
        for (int i = 0; i < parkingLots.length; i++) {
            ParkingTicket parkingTicket = this.parkingInSingleParkingLot(parkingLots[i], car);
            if (null != parkingTicket) {
                return parkingTicket;
            }
        }

        return null;
    }

    public ParkingTicket parkingInSingleParkingLot(ParkingLot parkingLot, Car car) {
        if (parkingLot.getAvailableParkingPosition() > 0) {
            ParkingTicket ticket = new ParkingTicket();
            parkingLot.park(ticket, car);
            this.lastErrorMessage = null;
            return ticket;
        }
        this.lastErrorMessage = "The parking lot is full.";
        return null;
    }

    public Car fetch(ParkingTicket ticket) {
        if (null == ticket) {
            this.lastErrorMessage = "Please provide your parking ticket.";
            return null;
        }
        Car car = parkingLot.fetch(ticket);
        if (null == car) {
            this.lastErrorMessage = "Unrecognized parking ticket.";
        }
        return car;
    }

    public String getLastErrorMessage() {
        return lastErrorMessage;
    }

    public ParkingLot[] getParkingLots() {
        return parkingLots;
    }
}
