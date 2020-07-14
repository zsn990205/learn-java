
/*

堆的代码复习
 */


import java.util.Arrays;
import java.util.Comparator;

public class Test {
    //调用Idea中给定的堆
    static class myComp implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    }
    private int[]arr=new int[100];
    private int size=0;
    public void offer(int x) {
        arr[size]=x;
        size++;
        shiftUp(arr,size,size-1);
    }
    //size没有--
    public Integer poll() {
      if(size<0) {
          return null;
      }
      int ret=arr[0];
      arr[0]=arr[size-1];
      size--;
      shiftDown(arr,size,0);
      return ret;
    }
    public Integer peek() {
        if(size==0) {
            return null;
        }
        return arr[0];
    }
    public boolean isEmpty() {
        return size==0;
    }
    //向下调整
    public static void shiftDown(int []arr,int size,int index) {
        int parent=index;
        int child=2*parent+1;
        while(child<size) {
            if(child+1<size && arr[child+1]>arr[child]) {
                child=child+1;
            }
            if(arr[parent]<arr[child]) {
                int tmp=arr[parent];
                arr[parent]=arr[child];
                arr[child]=tmp;
            }
            else {
                break;
            }
            parent=child;
            child=2*parent+1;
        }
    }
    //建堆的循环条件不够清晰 没有调用shiftDowm
    public static void createHeap(int []arr,int size) {
        //建堆是从后向前建
        //建堆需要并且必须调用向下调整
        for(int i=(size-1-1)/2;i>=0;i--) {
            shiftDown(arr,size,i);
        }
    }
    //向上调整 循环条件判断的不够清晰
    public static void shiftUp(int []arr,int size,int index) {
        int child=index;
        int parent=(child-1)/2;
        while(child>0) {
            if(arr[child]>arr[parent]) {
                int tmp=arr[child];
                arr[child]=arr[parent];
                arr[parent]=tmp;
            }
            else {
                break;
            }
            child=parent;
            parent=(child-1)/2;
        }
    }

    public static void main2(String[] args) {
        Test queue=new Test();
        queue.offer(9);
        queue.offer(8);
        queue.offer(5);
        queue.offer(1);
        queue.offer(3);
        queue.offer(2);
        queue.offer(6);
        while(!queue.isEmpty()) {
            Integer cur=queue.poll();
            System.out.print(cur+" ");
        }

    }
    public static void main1(String[] args) {
        int []arr={9,5,2,4,8,7,9,5,3,1};
        createHeap(arr,arr.length);
        System.out.print(Arrays.toString(arr));
    }
}
