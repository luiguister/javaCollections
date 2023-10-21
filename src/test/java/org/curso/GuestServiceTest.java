package org.curso;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GuestServiceTest {
    private GuestService service;
    Guest luis, adri, alex, pepe, bob;

    Room westminster = new Room("westminster", "premier", 4, 175);
    Room oxford = new Room("oxford", "suite", 5, 250);
    Room manchester = new Room("manchester", "guest room", 3, 125);
    Room victoria = new Room("victoria", "suite", 5, 225);
    Room liverpool = new Room("liverpool", "suite", 5, 225);
    Room mains = new Room("mains", "premier", 6, 200);
    Room boro = new Room("boro", "premier", 6, 200);

    @BeforeEach
    void setUp() {
        this.service = new GuestService();

        luis = new Guest("Luis", "Diaz", false);
        luis.getPreferredRooms().addAll(List.of(oxford, victoria, manchester));

        adri = new Guest("Adriana", "Beltran", false);
        adri.getPreferredRooms().addAll(List.of(oxford, liverpool));

        alex = new Guest("Alex", "Sanchez", true);
        alex.getPreferredRooms().addAll(List.of(liverpool));

        pepe = new Guest("Pepe", "Reina", true);
        bob = new Guest("bob", "Reina", false);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void filterByFavoriteRoom() {
        List<Guest> invitados = new ArrayList<>();
        invitados.add(luis);
        invitados.add(alex);
        assertEquals(1, service.filterByFavoriteRoom(invitados, oxford).size());
    }

    @Test
    void checkIn() {
    }

    @Test
    void swapPosition() {
    }
}