package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private final int capacity;

    private Map<ParkingTicket, Car> cars = new HashMap<>();
    public ParkingLot() {
        this(10);
    }

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public int getAvailableParkingPosition() {
        return  capacity - cars.size();
    }

    public void park(ParkingTicket ticket, Car car) {
        this.cars.put(ticket, car);
    }

    public Car fetch(ParkingTicket ticket) {
        Car car = cars.get(ticket);
        cars.remove(ticket);
        return car;
    }

    public int getCapacity() {
        return capacity;
    }
}
