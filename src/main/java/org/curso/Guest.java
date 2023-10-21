package org.curso;

import java.util.ArrayList;
import java.util.List;

public class Guest {
    private String firstName;
    private String lastName;
    private boolean loyalityProgramMember;
    private List<Room> preferredRooms = new ArrayList<>();

    public Guest(String firstName, String lastName, boolean loyalityProgramMember) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.loyalityProgramMember = loyalityProgramMember;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isLoyalityProgramMember() {
        return loyalityProgramMember;
    }

    public void setLoyalityProgramMember(boolean loyalityProgramMember) {
        this.loyalityProgramMember = loyalityProgramMember;
    }

    public List<Room> getPreferredRooms() {
        return preferredRooms;
    }

    public void setPreferredRooms(List<Room> preferredRooms) {
        this.preferredRooms = preferredRooms;
    }
}
