package queue;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class QueueReverser {
    public static void reverse(Queue<Integer> queue, int k){
        if(queue.isEmpty() || k < 0 || k > queue.size()){
            return;
        }

        Stack<Integer> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();

        for(int i=0; i<k; i++){
            stack.push(queue.poll());
        }

        while (!queue.isEmpty()){
            list.add(queue.poll());
        }


        while(!stack.isEmpty()){
            queue.offer(stack.pop());
        }

        queue.addAll(list);
    }

    public static void reverseRecursion(Queue<Integer> queue, int k){
        reverseKth(queue, k);
        int s = queue.size() - k;
        while (s-- > 0){
            int x = queue.poll();
            queue.add(x);
        }
    }

    private static void reverseKth(Queue<Integer> queue, int k) {
        if(k==0) return;
        int e = queue.poll();

        reverseKth(queue, k-1);
        queue.add(e);
    }
}
