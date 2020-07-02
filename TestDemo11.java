
/*

写一个自己的栈(顺序表)

 */


public class TestDemo {
   private int []arr=new int[100];
   private int size;

    public void push(int value) {
     //进栈操作  0是栈底 size-1为栈顶
     arr[size]=value;
     size++;
  }
    public Integer pop() {
     //出栈操作
     if(size<=0) {
         return null;
     }
     int ret=arr[size-1];
     size--;
     return ret;
    }
    public Integer peek() {
     //取栈顶元素
       if(size<=0) {
           return null;
       }
       int ret=arr[size-1];
       return ret;
  }

    public static void main(String[] args) {
         TestDemo testDemo=new TestDemo();

        testDemo.push(1);
        testDemo.push(2);
        testDemo.push(3);
        testDemo.push(4);

        while(true) {
            Integer cur=testDemo.pop();
            if(cur==null) {
              break;
            }
            System.out.println(cur);
        }
   }
}
