package stacks;

import java.util.*;

public class Expression {
    private final List<Character> leftExpressions = Arrays.asList('(', '{', '[', '<');
    private final List<Character> rightExpressions = Arrays.asList(')', '}', ']', '>');
    public boolean balancedString(String input){
        if(Objects.isNull(input)){
            throw new IllegalArgumentException();
        }
        Stack<Character> stack = new Stack<>();
        for(char c: input.toCharArray()){
            if(isLeftExpression(c)){
                stack.push(c);
            } else if (isRightExpression(c)) {
                if(stack.empty())
                    return false;

                var top = stack.pop();
                if (!bracketsMatch(c, top)) {
                    return false;
                }
            }
        }
        return stack.empty();
    }

    private boolean bracketsMatch(char right, char left) {
       return rightExpressions.indexOf(right) == leftExpressions.indexOf(left);
    }

    private boolean isRightExpression(char c) {
        return rightExpressions.contains(c);
    }

    private boolean isLeftExpression(char c) {
        return leftExpressions.contains(c);
    }
}
