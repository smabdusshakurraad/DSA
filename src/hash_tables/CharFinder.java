package hash_tables;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CharFinder {

    /**
     *  Find the non-repeated char in the string
     * @param string {@link String}
     * @return {@link Character}
     */
    public char firstNonRepeatedChar(String string){
        String lowerCase = string.toLowerCase();

        var chars = lowerCase.toCharArray();
        Map<Character, Integer> characterIntegerMap = new HashMap<>();
        for(char c : chars){
            var count = characterIntegerMap.getOrDefault(c, 0);
            characterIntegerMap.put(c, count+1);
        }

        for(char c : chars){
            if(characterIntegerMap.get(c) == 1){
                return c;
            }
        }
        return Character.MIN_VALUE;
    }

    /**
     *  Return first repeated char
     * @param string {@link String}
     * @return {@link Character}
     */
    public char firstRepeatedChar(String string){
        var lower = string.toLowerCase();
        Set<Character> set = new HashSet<>();
        var chars = lower.toCharArray();
        for (var c : chars){
            if(set.contains(c)){
                return c;
            }
            set.add(c);
        }

        return Character.MIN_VALUE;
    }
}
