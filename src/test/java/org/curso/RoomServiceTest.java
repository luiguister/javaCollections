package org.curso;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class RoomServiceTest {
    private RoomService service;
    private RoomService service2;
    private RoomService service3;
    Room westminster, oxford, manchester, victoria, liverpool, mains, boro;
    Room[] rooms;


    @BeforeEach
    void setUp(){
        //this.inventory = new ArrayList<>();
        this.westminster = new Room("westminster", "premier", 4, 175);
        this.oxford = new Room("oxford", "suite", 5, 250);
        this.manchester = new Room("manchester", "guest room", 3, 125);
        this.victoria = new Room("victoria", "suite", 5, 225);
        this.liverpool = new Room("liverpool", "suite", 5, 225);
        this.mains = new Room("mains", "premier", 6, 200);
        this.boro = new Room("boro", "premier", 6, 200);

        this.rooms = new Room[] {this.westminster, this.oxford, this.manchester, this.mains, this.liverpool, this.victoria};
        this.service= new RoomService();
        this.service.createRooms(rooms);

        this.service.createRoom(westminster.getName(), westminster.getType(), westminster.getCapacity(), westminster.getRate());
        this.service.createRoom(oxford.getName(), oxford.getType(), oxford.getCapacity(), oxford.getRate());
        this.service.createRoom(manchester.getName(), manchester.getType(), manchester.getCapacity(), manchester.getRate());
    }

    @Test
    void getInventory() {
        assertNotNull(this.service.getInventory());
    }

    @Test
    void createRoom() {
        this.service.createRoom(victoria.getName(), victoria.getType(), victoria.getCapacity(), victoria.getRate());
        assertEquals(6, this.service.getInventory().size());
    }

    @Test
    void createRooms() {
        assertEquals(6, this.service.getInventory().size());
    }

    @Test
    void removeRoom() {
        this.service.createRoom(victoria.getName(), victoria.getType(), victoria.getCapacity(), victoria.getRate());
        this.service.removeRoom(victoria);
        assertEquals(5, this.service.getInventory().size());
        assertFalse(this.service.getInventory().contains(victoria));
    }

    @Test
    void hasRoom() {
        assertFalse(this.service.hasRoom(boro));
        assertTrue(this.service.hasRoom(manchester));
    }

    @Test
    void asArray() {
        Room[] rooms = this.service.asArray();
        assertEquals(6, rooms.length);
        assertEquals(this.manchester, rooms[2]);
        assertEquals(this.oxford, rooms[1]);
        assertEquals(this.westminster, rooms[0]);
    }

    @Test
    void getByType() {

        Collection<Room> guessRooms = this.service.getByType("premier");
        assertEquals(2, guessRooms.size());
        assertTrue(guessRooms.stream()
                .allMatch(r -> r.getType().equals("premier")));
        assertEquals(6, this.service.getInventory().size());
    }

    @Test
    void applyDiscount() {
        service.applyDiscount(10);
        assertEquals(25, rooms[1].getRate());

    }

    @Test
    void getRoomsByCapacity() {
        this.service2= new RoomService();
        Room[] rooms2 = {mains};
        this.service2.createRooms(rooms2);
        assertEquals(this.service2.getInventory().size(), this.service.getRoomsByCapacity(6).size());
    }

    @Test
    void getRoomByRateAndType() {
        this.service3= new RoomService();
        Room[] rooms1 = {victoria, liverpool};
        this.service3.createRooms(rooms1);
        assertEquals(this.service3.getInventory().size(), this.service.getRoomByRateAndType(225, "suite").size());
    }
}