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
    }
}
