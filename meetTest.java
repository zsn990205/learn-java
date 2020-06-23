import java.util.LinkedList;
import java.util.Queue;
/*

用队列实现栈
在队列中删除是poll 加元素是offer
 */
public class meetTest {
    Queue<Integer> A =new LinkedList<>();
    Queue<Integer> B =new LinkedList<>();

    /** Push element x onto stack. */
    public void push(int x) {
        A.offer(x);
    }
    /** Get the top element. */
    public int top() {
        if(empty()) {
            return 0;
        }
        while(A.size()>1) {
            Integer cur=A.poll();
            B.offer(cur);
        }
        int top=A.poll();
        //取栈顶元素但是不删除top

        B.offer(top);
        swap(); //!!!先把top的值给b在交换
        return top;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        //如果栈为空
        if(empty()) {
            return 0;
        }
        //将A中的size-1个元素加入B中
        while(A.size()>1) {
            Integer cur=A.poll();
            B.offer(cur);
        }
        int top=A.poll();
        swap();
        return top;
    }

    //交换三联
    private void swap() {
        Queue<Integer> tmp=A;
        A=B;
        B=tmp;
    }



    /** Returns whether the stack is empty. */
    public boolean empty() {
        return A.isEmpty() && B.isEmpty();
    }
}