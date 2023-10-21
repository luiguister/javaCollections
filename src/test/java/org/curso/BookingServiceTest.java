package org.curso;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookingServiceTest {
    Room r1, r2, r3, r4;
    Guest luis, adri, alex, pepe;
    BookingService service = new BookingService();

    @BeforeEach
    void setUp() {

        r1 = new Room("Bogota", "suite", 4, 10);
        r2 = new Room("cali", "premier", 3, 20);
        r3 = new Room("quilla", "double", 2, 30);
        r4 = new Room("riohacha", "single", 1, 40);

        luis = new Guest("Luis", "Diaz", false);
        adri = new Guest("Adriana", "Beltran", false);
        alex = new Guest("Alex", "Sanchez", true);
        pepe = new Guest("Pepe", "Reina", true);

    }

    @Test
    void book() {
        assertTrue(this.service.book(r1, luis));
        assertTrue(this.service.book(r2, adri));
        assertFalse(this.service.book(r1, alex));
        assertFalse(this.service.book(r2, pepe));
    }

    @Test
    void totalRevenue() {
        this.service.book(r1, luis);
        this.service.book(r2, adri);
        this.service.book(r3, alex);
        this.service.book(r4, pepe);

        assertEquals(100, this.service.totalRevenue());
    }
}