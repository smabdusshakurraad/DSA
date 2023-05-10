package hash_tables;

public class HashTableMain {
    public static void main(String[] args) {
        HashTable table = new HashTable();
        table.put(6, "A"); // 1
        table.put(8, "B"); // 3
        table.put(11, "C"); // 1
        table.put(6, "A+");
        System.out.println(table.get(6));
        System.out.println(table.get(11));
        table.remove(11);
        System.out.println("Done");

        System.out.println("Hash Table Exercises");
        HashTableExercises hashTableExercises = new HashTableExercises();

        System.out.println("Exercise one - most frequent element of array");
        var excOneResult = hashTableExercises.mostFrequent(new int[]{1, 2, 2, 3, 3, 3, 4});
        System.out.println(excOneResult);

        System.out.println("Exercise Two - count pair with diff");
        var excTwoResult = hashTableExercises.countPairsWithDiff(new int[]{1, 7, 5, 9, 2, 12,3}, 2);
        System.out.println(excTwoResult);

        System.out.println("Exercise Three - two sum");
        hashTableExercises.twoSum(new int[]{2, 7, 11, 15}, 9);

        System.out.println("Exercise Four - hashMap with linear probing");
        HashTableWithLinearProbing hashTableWithLinearProbing = new HashTableWithLinearProbing();

        hashTableWithLinearProbing.put(6, "A"); // 1
        hashTableWithLinearProbing.put(8, "B"); // 3
        hashTableWithLinearProbing.put(11, "C"); // 1

        System.out.println(hashTableWithLinearProbing.get(6));
        System.out.println(hashTableWithLinearProbing.get(11));
        System.out.println();

        hashTableWithLinearProbing.put(6, "A+"); // 1
        System.out.println(hashTableWithLinearProbing.get(6));
        System.out.println();

        hashTableWithLinearProbing.remove(6);
        System.out.println(hashTableWithLinearProbing.get(6));



    }
}
