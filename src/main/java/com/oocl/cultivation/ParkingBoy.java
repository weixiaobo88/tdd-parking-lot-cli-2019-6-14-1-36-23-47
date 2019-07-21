package com.oocl.cultivation;

public class ParkingBoy {

    private final ParkingLot parkingLot;
    private String lastErrorMessage;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingTicket park(Car car) {
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
}
