

public class myPriorityQueue {
  //大堆
  //优先队列
  private int[]arr=new int[100];
  private int size=0; //有效区间[0,100) 有效元素的个数
  public void offer(int x) {
  //入队列操作:x放到数组的尾部 进行向上调整
  //1.x放在末尾
      arr[size]=x;
      size++;
  //进行向上调整
  //index表示从哪个位置进行向上调整
  shiftUp(arr,size,size-1);
  }

  public static void shiftUp(int []arr,int size,int index) {
  int child=index;
  int parent=(child-1)/2;
  //child=0就是根节点 就到顶了
  while(child>0) {
  //比较child和parent关系 看是否符合大堆
      if(arr[parent]<arr[child]) {
          int tmp=arr[parent];
          arr[parent]=arr[child];
          arr[child]=tmp;
      }
      else {
          break;
      }
      child=parent;
      parent=(child-1)/2;
  }
  }
  public Integer poll() {
   //出队列操作(从堆顶开始出队列&&进行向下调整)
    if(size<0) {
       return null;
   }
    //专门设置堆顶元素是为了出队列
    int ret=arr[0];
   //最后一个元素的值调入到0位置上
   arr[0]=arr[size-1];
   size--;
  shiftDown(arr,size,0);
  return ret;
  }
  private void shiftDown(int []arr,int size,int index) {
  int parent=index;
  int child=2*parent+1;
  while(child<size) {
      if(child+1<size && arr[child+1]>arr[child]) {
          child=child+1;
      }
      if(arr[child]>arr[parent]) {
          int tmp=arr[child];
          arr[child]=arr[parent];
          arr[parent]=tmp;
      } else {
          break;
      }
      parent=child;
      child=2*parent+1;
  }
  }
  public Integer peek() {
  //取队首元素
  if(size==0) {
      return null;
  }
  return arr[0];
  }
  public boolean isEmpty() {
  //是否出队列完毕
      return size==0;
  }

    public static void main(String[] args) {
        myPriorityQueue queue=new myPriorityQueue();
        queue.offer(9);
        queue.offer(1);
        queue.offer(2);
        queue.offer(10);
        queue.offer(3);
        queue.offer(6);
        while(!queue.isEmpty()) {
            Integer cur=queue.poll();
            System.out.print(cur+" ");
        }
    }
}
