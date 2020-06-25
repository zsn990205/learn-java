
/*

用栈演示队列的一系列操作
A入队列
B出队列和取队首元素

 */


import java.util.Stack;

public class meetTest2 {
    private Stack<Integer> A =new Stack<>();
    private Stack<Integer> B =new Stack<>();

    /** Initialize your data structure here. */
    public meetTest2() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        //先保证所有元素都在A中 再把X插入A中
        while(!B.isEmpty()) {
            //B非空
            Integer top=B.pop();
            A.push(top);
        }
            A.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
    //先把A中的元素都倒腾在B中 在出栈
        if(empty()) {
            return 0;
        }
        while(!A.isEmpty()) {
            //A非空的情况下 把A中的元素全部倒腾在B中
            Integer top=A.pop();
            B.push(top);
        }
        //现在所有的元素均在B中 删除即可
        return B.pop();
    }

    /** Get the front element. */
    public int peek() {
    if(empty()) {
        return 0;
    }
    while(!A.isEmpty()) {
        Integer top=A.pop();
        B.push(top);
    }
    return B.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
     return A.isEmpty() && B.isEmpty();
    }
}

