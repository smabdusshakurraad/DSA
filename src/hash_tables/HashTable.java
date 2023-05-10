package hash_tables;

import java.util.LinkedList;

public class HashTable {
    private class Entry{
        private int key;
        private String value;

        Entry(int key, String value){
            this.key = key;
            this.value = value;
        }
    }
    private LinkedList<Entry>[] entries = new LinkedList[5];

    private LinkedList<Entry> getBucket(int key){
        return entries[hash(key)];
    }

    private LinkedList<Entry> getOrCreateBucket(int key){
        var index = hash(key);

        if(entries[index] == null){
            entries[index] = new LinkedList<>();
        }

        return entries[index];
    }
    private Entry getEntry(int key){
        var bucket = getBucket(key);
        if(bucket != null){
            for(var entry : bucket){
                if(entry.key == key){
                    return entry;
                }
            }
        }

        return null;
    }
    public void put(int key, String value){
        var entry = getEntry(key);
        if(entry != null){
            entry.value = value;
            return;
        }

        getOrCreateBucket(key).add(new Entry(key, value));
    }

    public String get(int key){
        var entry = getEntry(key);
        return entry == null ? null : entry.value;
    }

    public void remove(int key){
        var entry = getEntry(key);
        if(entry != null){
            getBucket(key).remove(entry);
            return;
        }

        throw new IllegalStateException();
    }
    private int hash(int key){
        return Math.abs(key) % entries.length;
    }
}
