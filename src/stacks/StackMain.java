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

        DynamicStack dynamicStack1 = new DynamicStack(1);
        dynamicStack1.push(10);
        System.out.println(dynamicStack1.pop());
        dynamicStack1.push(20);
        dynamicStack1.push(30);
        dynamicStack1.push(40);
        System.out.println(dynamicStack1.pop());
        System.out.println(dynamicStack1.pop());
        System.out.println(dynamicStack1.peek());
        System.out.println(dynamicStack1.pop());
        System.out.println(stack);


        System.out.println("two stack 1");
        TwoStack twoStack1 = new TwoStack();
        twoStack1.push1(10);
        twoStack1.push1(20);
        twoStack1.push1(30);
        twoStack1.push1(40);
        twoStack1.push1(50);
        twoStack1.push1(60);
        twoStack1.push1(70);
        twoStack1.push1(80);
        twoStack1.push1(90);
        twoStack1.push1(100);

        System.out.println(twoStack1.toString1());

        twoStack1.pop1();
        twoStack1.pop1();
        twoStack1.pop1();
        twoStack1.pop1();
        twoStack1.pop1();
        System.out.println(twoStack1.peek1());
        System.out.println(twoStack1.toString1());

        twoStack1.push2(60);
        twoStack1.push2(70);
        twoStack1.push2(80);
        twoStack1.push2(90);
        twoStack1.push2(100);
        System.out.println(twoStack1.toString2());

    }
}
