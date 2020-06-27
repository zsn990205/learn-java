

/*

用链表实现队列
头部作为队首(方便删除元素)
尾部作为队尾(方便插入元素)

 */


public class Myqueue {
  static class Node {
      public int val;
      public Node next;

      public Node(int val) {
          this.val = val;
      }
  }
  private Node head=new Node(1);
  private Node tail=head;

   //刚开始两者均指向头部

    public void offer(int val) {
        //入队列
     Node node=new Node(val);
     tail.next=node;
     //插入完成得更新tail指向
     tail=tail.next;
    }
    public Integer poll() {
        //链表头删
        if (head.next == null) {
            return null;
        }
        Node del = head.next;
        head.next = del.next;
        //如果删除后 head后没有元素了 就要更新tail的位置
        if (head.next == null) {
            tail = head;
        }
        return del.val;
    }
    public Integer peek() {
        //取队首元素
   if(head.next==null) {
       return null;
   }
   return head.next.val;
    }

    public static void main(String[] args) {
        Myqueue myqueue=new Myqueue();
        myqueue.offer(1);
        myqueue.offer(2);
        myqueue.offer(3);
        myqueue.offer(4);

        while(true) {
            Integer cur=myqueue.poll();
            if(cur==null) {
                break;
            }
            System.out.println(cur);
        }
    }
}
