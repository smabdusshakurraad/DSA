package stacks;

import java.util.*;

public class Expression {
    private final List<Character> leftExpressions = Arrays.asList('(', '{', '[', '<');
    private final List<Character> rightExpressions = Arrays.asList(')', '}', ']', '>');
    public boolean balancedString(String input){
        if(Objects.isNull(input)){
            throw new IllegalArgumentException();
        }
        Stack<Character> dynamicStack = new Stack<>();
        for(char c: input.toCharArray()){
            if(isLeftExpression(c)){
                dynamicStack.push(c);
            } else if (isRightExpression(c)) {
                if(dynamicStack.empty())
                    return false;

                var top = dynamicStack.pop();
                if (!bracketsMatch(c, top)) {
                    return false;
                }
            }
        }
        return dynamicStack.empty();
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
