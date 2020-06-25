
/*

实现一个最小栈
用两个栈的方式 B中存取最小值栈
AB进行同步操作(出栈 入栈)


 */


import java.util.Stack;

public class meetTest3 {
    private Stack<Integer> A=new Stack<>();
    private Stack<Integer> B=new Stack<>();

        /** initialize your data structure here. */
        public meetTest3() {

        }

        public void push(int x) {
            A.push(x);
            if (B.empty()) {
                B.push(x);
                return;
            }
            int min = B.peek(); //B不为空 将B的栈顶元素当为最开始的最小值
            if (x < min) {
                //新插的元素
                min = x;
            }
            //min一定是元素中的最小值
            B.push(min);
        }
        public void pop() {
            //AB同时出栈
            if(A.empty()) {
                //如果A为空
                return;
            }
          A.pop();
          B.pop();

        }

        public int top() {
            if (A.empty()) {
                return 0;
            }
            return A.peek();
        }
        public int getMin() {
        if(B.empty()) {
            return 0;
        }
        return B.peek();
    }
}
