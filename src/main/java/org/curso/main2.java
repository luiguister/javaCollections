package org.curso;

import java.util.*;

public class main2 {
    public static void main(String[] args) {
        final List<String> friends = Arrays.asList("Brian", "Scott", "Brian", "Scott", "Sara", "Scott");
        //ingresar lista en hashset
        Set<String> set =new HashSet<>(friends);
        Map<String, Double> mapa = new HashMap<>();
        for (String nameSet: set) {
            int i=0;
            for(String nameArray: friends){
                if (nameSet.equals(nameArray)) {
                    i++;
                }
            }
            mapa.put(nameSet, (double) (i*100/friends.size()));
        }


        for (Map.Entry<String, Double> entry:mapa.entrySet()) {
            String s = entry.getKey();
            Double i = entry.getValue();
            System.out.println("clave: "+s+" valor: "+i);
        }
    }
}
