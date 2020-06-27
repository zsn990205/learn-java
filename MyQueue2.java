

/*

用顺序表来创建一个队列

 */
public class MyQueue2 {

    private int[]arr=new int[100];
    //初始的数组是一个前闭后开的区间 初始情况下队列为空
    private int size;
    private int head=0;
    private int tail=0;

    public  boolean offer(int val) {
     //给表中增添元素(这里的插入可能会失败 因为顺序表可能是满的) 失败返回false
       if(size==arr.length) {
           return false;
       }
       arr[tail]=val;
       tail++;
            //超出下标从头开始
       if(tail>=arr.length) {
           tail=0;
       }
        //或者 tail=tail%arr.length;
       size++;
       return true;

    }
    public Integer poll() {
        //删除表中的元素
       if(size==0) {
           return null;
       }
       int ret=arr[head];
       head++;
       if(head>=arr.length) {
           head=0;
       }
       size--;
       return ret;
    }
    public Integer peek() {
    //获取栈顶元素
   if(size==0) {
       return null;
   }
   int ret=arr[head];
   return ret;
    }

    public static void main(String[] args) {
        MyQueue2 myQueue2=new MyQueue2();
        myQueue2.offer(1);
        myQueue2.offer(2);
        myQueue2.offer(3);
        myQueue2.offer(4);

        while(true) {
            Integer cur=myQueue2.poll();
            if(cur==null) {
                break;
            }
            System.out.println(cur);
        }

    }
}
