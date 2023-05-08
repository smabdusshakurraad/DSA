package hash_tables;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HashSetMain {
    public static void main(String[] args) {
        System.out.println("Hash Set");
        Set<Integer> set = new HashSet<>();
        int[] numbers = {1, 2, 3, 3, 2, 1, 4};
        for (var number : numbers){
            set.add(number);
        }
        System.out.println(set);
        set.remove(1);
        System.out.println(set);
        System.out.println(set.contains(4));
        System.out.println(set.size());
        set.removeAll(List.of(2, 3));
        System.out.println(set);
        set.clear();
        System.out.println(set);
    }
}
