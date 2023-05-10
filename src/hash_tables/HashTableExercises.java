package hash_tables;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HashTableExercises {
    public int mostFrequent(int[] array){
        Map<Integer, Integer> map = new HashMap<>();
        int maxIndex = 0;
        for(int item : array){
            int count = map.getOrDefault(item, 0);
            map.put(item, count+1);

            if(count+1 > map.getOrDefault(maxIndex, 0)){
                maxIndex = item;
            }
        }

        return maxIndex;
    }

    public int countPairsWithDiff(int[] array, int k){
        int count = 0;
         var set = convertToSet(array);

        for(int item : array){
            if(set.contains(item - k)){
                count++;
            }
        }

        return count;
    }

    private Set<Integer> convertToSet(int[] array){
        Set<Integer> set = new HashSet<>();
        for (int item : array){
            set.add(item);
        }

        return set;
    }
    public void twoSum(int[] array, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < array.length; i++){
            map.put(array[i], i);
        }
        for(int item : array){
            if(map.containsKey(target - item)){
                System.out.println(map.get(item));
                System.out.println(map.get(target - item));
                break;
            }
        }
    }

}
