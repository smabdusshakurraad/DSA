package stacks;

import java.util.Stack;

public class StackMain {
    public static void main(String[] args){
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println(stack);
        var pop = stack.pop();
        System.out.println(pop);
        System.out.println(stack);
        var peek = stack.peek();
        System.out.println(peek);
        System.out.println(stack);

        // Reverse a string
        String str = "abcd";
        StringReverser stringReverser = new StringReverser();
        String reversed = stringReverser.reverse(str);
        System.out.println(reversed);

        String balanced = "<1+2>";
        Expression expression = new Expression();
        var b = expression.balancedString(balanced);
        System.out.println(b);
    }
}
