import java.util.Arrays;

public class Heap {
    //堆用数组来表示
    //[0,size)表示堆中有哪些元素
    //index表示从那个元素出发进行调整
    public static void shiftDown(int []arr,int size,int index) {
    //向下调整
    int parent=index;
    //根据父节点的下标去找左右子树下标
    int child=2*parent+1;
    //先找左子树下标
    while(child<size) {
    //查找当时的child是否存在(是否会发生下标越界)
    if(child+1<size && arr[child+1]>arr[child]) {
     //child永远是最大的孩子
        child=child+1;
    }
    if(arr[child]>arr[parent]) {
        int tmp=arr[child];
        arr[child]=arr[parent];
        arr[parent]=tmp;
    } else {
    //关系已经符合
    break;
    }
    //下次循环需要继续更新
    parent=child;
    child=parent*2+1;
    }
    }

    public static void createHeap(int []arr,int size) {
    //从后向前遍历 从最后一个非叶子结点出发
    //向下调整必须从后向前遍历
    //size-1得到的是最后一个下标 size-1-1就相当于(child-1)/2也就是parent
        for(int i=(size-1-1)/2;i>=0;i--) {
        shiftDown(arr,size,i);
        }
    }

    public static void main(String[] args) {
        int []arr={9,5,3,6,2,1,8};
        createHeap(arr,arr.length);
        shiftDown(arr,arr.length,0);
        System.out.print(Arrays.toString(arr));
    }
}
