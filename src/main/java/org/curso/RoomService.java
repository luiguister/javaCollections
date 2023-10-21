package org.curso;

import java.util.*;
import java.util.stream.Collectors;

public class RoomService {
//declare a collection to store room inventory
    private Collection<Room> inventory;

    public RoomService() {
        //initialize a collection and assign it to the room inventory
        inventory = new LinkedHashSet<>();
    }

    public Collection<Room> getInventory(){
        //return the room inventory
        return new HashSet<>(this.inventory);
    }

    public boolean hasRoom(Room room){
        return inventory.contains(room);
    }

    public Room[] asArray(){
        return this.inventory.toArray(new Room[0]);
    }

    public Collection<Room> getByType(String type){
        Collection<Room> copy = new HashSet<>(this.inventory);
        copy.removeIf(r -> !r.getType().equals(type));
        return copy;
    }

    public void createRoom(String name, String type, int capacity, double rate){
    //add a new room to the room inventory using the providers parameters
        inventory.add(new Room(name, type, capacity, rate));
    }

    public void createRooms(Room[] rooms){
        this.inventory.addAll(Arrays.asList(rooms));
    }

    public void removeRoom(Room room){
        this.inventory.remove(room);
    }

    public void applyDiscount(final double discount){
        this.inventory.forEach(room -> room.setRate(room.getRate() * discount / 100));
    }

    public Collection<Room> getRoomsByCapacity(final int requiredCapacity){
        Collection<Room> matches = inventory.stream()
                .filter(room -> room.getCapacity() >= requiredCapacity)
                .collect(Collectors.toList());
        return matches;
    }

    public Collection<Room> getRoomByRateAndType(final double rate, final String type){

        Collection<Room> matches = inventory.stream()
                .filter(room -> room.getType().equals(type))
                .filter(room -> room.getRate() <= rate)
                .collect(Collectors.toList());
        return matches;
    }
}
