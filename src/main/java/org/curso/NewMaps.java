package org.curso;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Stream;

public class NewMaps
{
    // Programa para iterar el mapa en Java usando `entrySet()`
    public static void main(String[] args)
    {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "One");
        map.put(2, "Two");

        // 1. Usando un iterador
        System.out.println("1. Usando un iterador");
        Iterator<Map.Entry<Integer, String>> itr = map.entrySet().iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        // 2. Bucle for-each
        System.out.println("2. Bucle for-each");
        for (Map.Entry<Integer, String> entry: map.entrySet())
        {
            Integer key = (Integer)entry.getKey();
            String value = entry.getValue();

            System.out.println(key + "=" + value);
        }

        // 3. Java 8: uso de `Iterator.forEachRemaining()`
        System.out.println("3. Java 8: uso de `Iterator.forEachRemaining()");
        map.entrySet()
                .iterator()
                .forEachRemaining(System.out::println);

        // 4. Java 8 – Uso de `Stream.forEach()`
        System.out.println("4. Java 8 – Uso de `Stream.forEach()`");
        map.entrySet()
                .stream()
                .forEach(System.out::println);

        // Java 8 – Uso de `Stream.of()` para obtener `Stream<Object>`
        System.out.println("Java 8 – Uso de `Stream.of()` para obtener `Stream<Object>`");
        Stream.of(map.entrySet().toArray())
                .forEach(System.out::println);

        // 5. Usando `toString()`
        System.out.println("5. Usando `toString()`");
        System.out.println(map.entrySet().toString());

        // Java 8 – Uso de `Stream.of()` para obtener `Stream<String>`
        System.out.println("Java 8 – Uso de `Stream.of()` para obtener `Stream<String>`");
        Stream.of(map.entrySet().toString())  // count() = 1
                .forEach(System.out::println);
    }
}