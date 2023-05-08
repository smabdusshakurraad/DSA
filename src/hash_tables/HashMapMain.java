package hash_tables;

import java.util.HashMap;
import java.util.Map;

public class HashMapMain {
    public static void main(String[] args) {
        System.out.println("Hash Map");
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Raad");
        map.put(2, "RK");
        map.put(3, "Tareq");
        map.put(null, null);
        System.out.println(map);
        map.remove(null);
        var value = map.get(1);
        System.out.println(map);
        System.out.println(value);

        System.out.println(map.containsKey(2)); // O(1) by using hash function
        System.out.println(map.containsValue("R")); // O(n) have to check all the values

        for (var item : map.keySet()){
            System.out.println(item);
        }

        for (var item : map.entrySet()){
            System.out.println(item);
        }

        for(var item : map.values()){
            System.out.println(item);
        }

        CharFinder charFinder = new CharFinder();
        var firstNonRepeatedChar = charFinder.firstNonRepeatedChar("A Green apple");
        var firstRepeatedChar = charFinder.firstRepeatedChar("A Green apple");

        System.out.println(firstNonRepeatedChar);
        System.out.println(firstRepeatedChar);
    }
}
