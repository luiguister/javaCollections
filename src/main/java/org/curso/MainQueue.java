package org.curso;

import java.util.ArrayDeque;
import java.util.Queue;

public class MainQueue {
    public static void main(String[] args) {
        Guest luis = new Guest("Luis", "Diaz", false);
        Guest alex = new Guest("Alex", "Sanchez", false);
        Guest adri = new Guest("Adriana", "Beltran", true);
        Guest pepe = new Guest("Pepe", "Reina", true);

        Queue<Guest> checkingQueue = new ArrayDeque<>();
        checkingQueue.offer(luis);
        checkingQueue.offer(alex);
        print(checkingQueue);

        Guest guest = checkingQueue.poll();
        print(checkingQueue);
        System.out.println(guest);
    }

    public static void print(Queue<Guest> queue){
        System.out.format("%n--Queue Content--%n");
        int x = 0;
        for (Guest guest:queue) {
            System.out.format("%x: %s %s %n",x++, guest.getFirstName().toString(), x==1 ?  "(head)":"");
            //System.out.println(x++ +  guest.toString());
        }
        System.out.println("");
    }
}
