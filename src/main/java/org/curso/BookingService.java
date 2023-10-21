package org.curso;

import java.util.HashMap;
import java.util.Map;

public class BookingService {
    private Map<Room, Guest> booking = new HashMap<>();
    public boolean book(Room room, Guest guest){

        return booking.putIfAbsent(room, guest) == null;
    }
    public double totalRevenue(){

        return this.booking.keySet().stream()
                .mapToDouble(room -> room.getRate())
                        .sum();
    }
    public Map<Room, Guest> getBookings(){
        return booking;
    }
}
