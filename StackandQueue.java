import java.util.*;

public class StackandQueue {
    //标准库中的Stack
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        while (!stack.empty()) {
            //不这么写会抛出一个异常
            Integer cur = stack.pop();
            if (cur == null) {
                break;
            }
            System.out.println(cur);
        }
        System.out.println();
        //因为是接口 所以使用linkedlist
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);

        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            if (cur == null) {
                break;
            }
            System.out.println(cur);
        }

        Deque<Integer> deque = new LinkedList<>();
        deque.addFirst(1);
        deque.addLast(2);
        deque.contains(3);

    }
}


