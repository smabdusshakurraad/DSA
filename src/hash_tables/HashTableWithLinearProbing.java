package hash_tables;

public class HashTableWithLinearProbing {
    String[] items = new String[5];
    int[] keys = new int[5];
    int count = 0;

    public void put(int key, String value){
        int index = hash(key);
        if(keys[index] != 0 && keys[index] != key){
            for(int i = index + 1; i< items.length; i = (i+1) % items.length){
                if(keys[i] == 0){
                    keys[i] = key;
                    items[i] = value;
                    count++;
                    return;
                }
            }
        }

        keys[index] = key;
        items[index] = value;
    }

    public String get(int key){
        int index = hash(key);
        if(keys[index] == key){
            return items[index];
        }

        for(int i = index + 1; i < keys.length; i = (i+1)){
            if(keys[i] == key){
                return items[i];
            }
        }

        throw new IllegalStateException();
    }

    public void remove(int key){
        int index = hash(key);
        if(keys[index] == key){
            keys[index] = 0;
            count--;
            return;
        }

        for(int i = index + 1; i < keys.length; i = (i+1)){
            if(keys[i] == key){
                 keys[i] = 0;
                 count--;
                 return;
            }
        }

        throw new IllegalStateException();
    }
    private int hash(int key){
        return key % items.length;
    }

    private int hash2(int key){
         int prime = 3; // less than the length
         return prime - (key % prime);
    }

    public int size(){
        return count;
    }

}
