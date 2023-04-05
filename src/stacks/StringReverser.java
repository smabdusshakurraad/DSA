package stacks;

import java.util.Objects;
import java.util.Stack;

public class StringReverser {
    public String reverse(String input){
        if(Objects.isNull(input)){
            throw new IllegalArgumentException();
        }
        Stack<Character> stack = new Stack<>();
        for(char c: input.toCharArray()){
            stack.push(c);
        }
        StringBuffer reversed = new StringBuffer();
        while (!stack.empty()){
            reversed.append(stack.pop());
        }
        return reversed.toString();
    }
}
