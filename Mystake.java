
/*

使用链表来实现栈的一系列操作

 */
public class Mystake {
 //用链表头表示栈顶
   static class Node {
       public int val;
        //傀儡节点(头节点) 用头节点表示链表从而表示整体
       //傀儡节点的Head永远不会是Null 傀儡节点内部存的值没有意义
       public Node next;

     public Node(int val) {
         this.val = val;
     }
 }
    Node head=new Node(2);
    public void push(int val) {
        //头插法
      Node node=new Node(val);
        //注意 你传进来的新的Node节点的val不能是具体数字 否则打印出来将会是一系列相同的数字
       node.next=head.next;
       head.next=node;
     }
    public Integer pop() {
        //头删法
        Node del=head.next;
     if(head.next==null) {
         return null;
     }
         head.next=del.next;
        return del.val;
    }
    public Integer peek() {
        //取栈顶元素
      if(head.next==null) {
          return null;
      }
      return head.next.val;
    }

    public static void main(String[] args) {
        Mystake mystake=new Mystake();
        mystake.push(1);
        mystake.push(2);
        mystake.push(3);
        mystake.push(4);

        while(true) {
            Integer cur=mystake.pop();
            if(cur==null) {
                break;
            }
            System.out.println(cur);
        }

    }
}
