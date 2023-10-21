package org.curso;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.Objects;

public class Room implements Comparable<Room>{

    public static Comparator<Room> RATE_COMPARATOR = Comparator.comparing(Room::getRate)
            .thenComparing(Room::getName).thenComparing(Room::getType);
    private String name;
    private String type;
    private int capacity;
    private double rate;
    private boolean isPetFrieldly;

    public boolean isPetFrieldly() {
        return isPetFrieldly;
    }

    public void setPetFrieldly(boolean petFrieldly) {
        isPetFrieldly = petFrieldly;
    }

    public Room(String name, String type, int capacity, double rate) {
        this.name = name;
        this.type = type;
        this.capacity = capacity;
        this.rate = rate;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public double getRate() {
        return rate;
    }
    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Room room)) return false;
        return Objects.equals(name, room.name) && Objects.equals(type, room.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type);
    }

    @Override
    public int compareTo(@NotNull Room o) {
        int result = this.getName().compareTo(o.getName());
        return result !=0 ? result : this.getType().compareTo(o.getType());
    }
}
