
/*

java标准库中给出的queue

 */

import java.util.Comparator;
import java.util.PriorityQueue;

public class TestPriorityQueue {
    /*static class myComp implements Comparator<Integer> {
        //用这个类去实现大根堆
        //需要重写compare方法
        @Override
        public int compare(Integer o1, Integer o2) {
        //O1优先级高的话 返回<0的数
        //O2优先级高的话 返回>0的数
            return o2-o1;
        }
    }*/
    public static void main(String[] args) {
        PriorityQueue<Integer> queue=new PriorityQueue<>((Integer o1,Integer o2)->{
            return 02-o1;
        });
    }
    public static void main3(String[] args) {
        //第三种
        PriorityQueue<Integer> queue=new PriorityQueue<>((Integer o1,Integer o2)->o2-o1);
        queue.offer(5);
        queue.offer(3);
        queue.offer(2);
        queue.offer(8);
        queue.offer(6);
        queue.offer(4);
        while(!queue.isEmpty()) {
            //标准库中默认  最小堆(优先级最高)
            Integer cur=queue.poll();
            System.out.print(cur+" ");
        }
    }
    public static void main2(String[] args) {
        //这是匿名内部类(定义在方法中)
        //第二种
        PriorityQueue<Integer> queue=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        queue.offer(5);
        queue.offer(3);
        queue.offer(2);
        queue.offer(8);
        queue.offer(6);
        queue.offer(4);
        while(!queue.isEmpty()) {
            //标准库中默认  最小堆(优先级最高)
            Integer cur=queue.poll();
            System.out.print(cur+" ");
        }
    }
    /*public static void main1(String[] args) {
        PriorityQueue<Integer> queue=new PriorityQueue<>(new myComp());
        queue.offer(5);
        queue.offer(3);
        queue.offer(2);
        queue.offer(8);
        queue.offer(6);
        queue.offer(4);
        while(!queue.isEmpty()) {
        //标准库中默认  最小堆(优先级最高)
            Integer cur=queue.poll();
            System.out.print(cur+" ");
        }

    }*/
}
