package org.curso;

import org.curso.interfaces.Contract;
import org.curso.interfaces.ImplContract;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static Room r1,r2,r3,r4,r5;
    static Guest luis, adri, alex, pepe;
    public static void main(String[] args) {

        r1 = new Room("Bogota", "suite", 4, 10);
        r2 = new Room("cali", "premier", 3, 20);
        r3 = new Room("quilla", "double", 2, 30);
        r4 = new Room("riohacha", "single", 1, 40);

        luis = new Guest("Luis", "Diaz", false);
        adri = new Guest("Adriana", "Beltran", false);
        alex = new Guest("Alex", "Sanchez", true);
        pepe = new Guest("Pepe", "Reina", true);

        System.out.println("--working with colecctions--");
        workingWithCollections();
        System.out.println("--interfaces--");
        Contract contract = new ImplContract();
        printTerms(contract);
        exampleSets();
        exampleList();
        queueExample();
        dequeExample();
        mapExample();
        sortingCollections();

    }

    private static void printTerms(Contract contract){
        contract.term1();
        contract.term2();
        contract.extendedTerm();
    }

    private static double getPotencialRevenue(Collection<Room> rooms){
        //return r1.getRate() + r2.getRate()+ r3.getRate();
        return rooms.stream()
                .mapToDouble(r -> r.getRate())
                .sum();
    }

    public static void queueExample(){
        //Queue<Guest> checkingQueue = new ArrayDeque<>();


        Comparator<Guest> programComp = Comparator
                .comparing(Guest::isLoyalityProgramMember).reversed();

        Queue<Guest> checkingQueue = new PriorityQueue<>(programComp);
        checkingQueue.offer(luis); //all element
        checkingQueue.offer(alex);
        checkingQueue.offer(adri);
        checkingQueue.offer(pepe);
        print(checkingQueue);

        Guest guest = checkingQueue.poll(); // remove the head of the queue
        print(checkingQueue);
        System.out.println(guest.getFirstName());

        Guest guest1 = checkingQueue.peek(); // remove the head of the queue
        print(checkingQueue);
        System.out.println(guest1.getFirstName());

    }

    public static void print(@NotNull Queue<Guest> queue){
        System.out.format("%n--Queue Content--%n");
        int x = 0;
        for (Guest guest:queue) {
            System.out.format("%x: %s %s %n",x++, guest.getFirstName().toString(), x==1 ?  "(head)":"");
        }
        System.out.println("");
    }

    public static void dequeExample(){
        Deque<String> messageStack= new ArrayDeque<>();
        messageStack.push("Message 1");
        /*print(messageStack);
        messageStack.push("Message 2");
        print(messageStack);
        messageStack.push("Message 3");
        print(messageStack);
        messageStack.push("Message 4");
        print(messageStack);*/
    }
    /*public static void print(Deque<String> deque){
        System.out.format("%n--Deque content--%n");

            int x = 0;
            for(String msg : deque){
                System.out.format("%x: s% s% n%", x++, msg, x == 1 ? "(Top)":"");
            }
            System.out.println("");


    }*/

    public static void mapExample(){
        Map<Room, Guest> assigment = new HashMap<>();
        assigment.put(r1, luis);
        assigment.put(r2, adri);

        System.out.println("r1: "+assigment.get(r1).getFirstName());
        System.out.println("r2: "+assigment.get(new Room("cali", "premier", 3, 20)).getFirstName());

        Guest guest = assigment.put(r1, assigment.remove(r2));
        assigment.putIfAbsent(r2, guest);

        System.out.println("r1: "+assigment.get(r1).getFirstName());
        System.out.println("r2: "+assigment.get(r2).getFirstName());

        //Set<Map.Entry<Room, Guest>> cv = assigment.entrySet();
        System.out.println("--ej map--");
        for (Map.Entry<Room, Guest> entry:assigment.entrySet()) {
            Room r = entry.getKey();
            Guest g = entry.getValue();
            System.out.format("%s: %s%n", r.getName(), g.getFirstName());
        }
        System.out.println("--ejemplo map2--");
        Map<Room, Guest> mapa = new HashMap<>();
        mapa.put(r1, luis);
        mapa.put(r2, adri);
        mapa.put(r3, alex);
        mapa.put(r4, pepe);

        Set set = mapa.entrySet();
        Iterator itr = set.iterator();
        while(itr.hasNext()){
            Map.Entry entry = (Map.Entry)itr.next();
            Room r = (Room) entry.getKey();
            Guest g = (Guest) entry.getValue();
            System.out.println(r.getName()+" "+g.getFirstName()+" "+g.getLastName());
        }
        System.out.println("set de claves");
        for (Room room:mapa.keySet()) {
            System.out.println(room.getName());
        }

        System.out.println("set de valores");
        for (Guest valores:mapa.values()) {
            System.out.println(valores.getFirstName());

        }


    }

    public static void exampleSets(){
        List<Integer> numbers = Arrays.asList(500, 1500, 2500, 1000, 3000, 2000);
        NavigableSet<Integer> numberTree = new TreeSet<>(numbers);

        numberTree.stream().forEach(System.out::println); //print in ascending order
        //numberTree.descendingSet().stream().forEach(System.out::println); print in descending order
        //numberTree.headSet(1750).stream().forEach(System.out::println); print lower number than a specified
        //numberTree.tailSet(1750).stream().forEach(System.out::println); print higher number than a specified
        //numberTree.subSet(1750, 2000).stream().forEach(System.out::println); print a range of numbers between the specifieds
        //System.out.println(numberTree.lower(750)); print the next higher number
        //System.out.println(numberTree.higher(750)); print the next lower number
    }
    public static void exampleList(){
        List<Guest> checkinList = new ArrayList<>(100);
        checkinList.add(luis);
        checkinList.add(adri);
        print(checkinList);
        checkinList.add(0,alex);
        print(checkinList);
        checkinList.get(2).setLoyalityProgramMember(true);
        checkinList.addAll(1, List.of(adri, pepe));
        print(checkinList);
        checkinList.remove(checkinList.size() -1);
        print(checkinList);
        System.out.println("position of luis: "+checkinList.indexOf(luis));
    }
    public static void print(List<Guest> list){
        System.out.format("%n--List Content--%n");
        for(int x=0; x<list.size();x++){
            Guest guest = list.get(x);
            System.out.format("%x: %s %n", x, guest.getFirstName().toString());
        }
    }

    public static void workingWithCollections(){

        Collection<Room> rooms = List.of(r1,r2,r3,r4);

        System.out.println(getPotencialRevenue(rooms));

        Collection<String> distros = new ArrayList<>();
        distros.add("linux");
        distros.add("manjaro");
        distros.add("fedora");
        distros.add("linux");
        System.out.println(distros);

        Collection<String> noRepeated = new HashSet<>(distros);
        System.out.println(noRepeated);

        System.out.println("--Iterando con iterator--");
        Iterator<Room> iterator = rooms.iterator();
        while(iterator.hasNext()){
            Room room = iterator.next();
            System.out.println(room.getName());
        }
        System.out.println("--Iterando con foreach--");
        for (Room room: rooms) {
            System.out.println(room.getName());
        }

        System.out.println("--Modifying collections while iterating--");
        Collection<Room> rooms2 = new ArrayList<>(Arrays.asList(r1,r2,r3,r4));
        // must add another field in room class
        r1.setPetFrieldly(true);
        r2.setPetFrieldly(false);
        r3.setPetFrieldly(true);

        Collection<Room> removeRooms = new ArrayList<>();

        /*System.out.println("--Modifying collections with foreach--");
        for (Room room: rooms2) {
            if(room.isPetFrieldly())
                removeRooms.add(room);
        }
        rooms2.removeAll(removeRooms);*/

        System.out.println("--Modifying collections with iterator operator--");
        Iterator<Room> iterator2 = rooms2.iterator();
        while(iterator2.hasNext()){
            Room room = iterator2.next();
            if(room.isPetFrieldly())
                iterator2.remove();
        }
        rooms2.stream()
                .forEach(room -> System.out.println(room.getName()));

        System.out.println("--accessing collection elements with streams--");
        rooms.stream().filter(room -> room.isPetFrieldly())
                .forEach(room -> System.out.println(room.getName()));
        System.out.println("--lambda expression--");
        rooms.stream().filter(Room::isPetFrieldly)
                .forEach(room -> System.out.println(room.getName()));
        System.out.println("--Streams operations--");
        Collection<Room> petFriendlyRooms = rooms.stream()
                .filter(room -> room.isPetFrieldly())
                .collect(Collectors.toList());
        petFriendlyRooms.stream().forEach(room -> System.out.println(room.getName()));
    }

    public static void sortingCollections(){
        List<Room> rooms = new ArrayList<>(List.of(r1, r2, r3, r4));

        Collections.sort(rooms);
        //old version
        //Collections.sort(rooms, Comparator.naturalOrder());
        //new version
        //rooms.sort(Comparator.naturalOrder());
        rooms.sort(Room.RATE_COMPARATOR);

        r5 = new Room("new London", "double", 2, 30);
        int result = Collections.binarySearch(rooms, r5, Room.RATE_COMPARATOR);
        rooms.add(Math.abs(++result), r5);
        System.out.println("Result: "+result);

        System.out.println("Min"+ Collections.min(rooms, Room.RATE_COMPARATOR).getName());
        System.out.println("Max"+ Collections.max(rooms, Room.RATE_COMPARATOR).getName());

        rooms.stream()
                .forEach(room ->
                        System.out.format("%-15s %-15s %-10f %n", room.getName(), room.getType(), room.getRate()));
    }
}