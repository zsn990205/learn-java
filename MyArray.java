package _prepareAgo;

import java.util.Arrays;

public class MyArray {
    //数组的底层存放的是 数组数字以及数组有效数字的个数
    public int[] elem;   //数组
    public int usdSize;  //有效元素个数
    public static final int a = 10;  //数组中存放的总容量
    public MyArray(){
        this.elem = new int[a];
        this.usdSize = 0;
    }

    //打印顺序表
    public void display() {
       for (int i = 0; i < usdSize; i++) {
           System.out.print(elem[i]+" ");
       }
    }

    //在pos位置新增元素
    public void add(int pos,int data) {
        //在pos位置新增元素的条件
        //判断是否数组已经满了 当数组满的时候对数组进行二倍扩容
        if (isFull()) {
            this.elem = Arrays.copyOf(this.elem,2 * this.elem.length);
        }
        //1.判断pos位置是否合法
        if (pos < 0 || pos > this.usdSize) {
           return;
        }
        //2.找到pos位置从最后一个有效元素开始后移
        for (int i = usdSize - 1; i >= pos; i--) {
            this.elem[i + 1] = this.elem[i];
        }
        //移到pos位置 并把数据存放进去
        this.elem[pos] = data;
        this.usdSize++;
    }

    private boolean isFull() {
        if (this.elem.length == this.usdSize) {
            return true;
        }
        return false;
    }

    //判定是否包含某个元素
    public boolean contains(int toFind) {
        for (int i = 0; i < this.usdSize; i++) {
            if (this.elem[i] == toFind) {
                return true;
            }
        }
        return false;
    }

    //查找某个元素对应的位置
    public int search(int toFind) {
        for (int i = 0; i < this.usdSize; i++) {
            if (this.elem[i] == toFind) {
                return i;
            }
        }
        return -1;
    }

    //获取pos位置的元素
    public int getPos(int pos) {
        //判断数组是否为空
        if (isEmpty()) {
            throw new RuntimeException("数组为空");
        }
        //此处当数组下标pos==总长的话 就会造成数组下标越界异常
        if (pos < 0 || pos >= this.usdSize) {
            throw new RuntimeException("pos位置不合法");
        }

        return this.elem[pos];
    }

    private boolean isEmpty() {
        return this.usdSize == 0;
    }

    //给pos位置的元素设为val

    //始终记住pos表示的是数组下标 数组下标是从0号元素开始的千万切记不能越界
    public void setPos(int pos,int val) {
        //当pos == this.usedSize时 如果还把val赋值给pos会数组下标越界
        if (pos < 0 || pos >= this.usdSize) {
            return;
        }
        this.elem[pos] = val;
    }

    //获取顺序表的长度
    public int size() {
      if (this.usdSize != 0) {
          return this.usdSize;
      }
        return 0;
    }

    //删除第一次出现的关键字key
    public void remove(int key) {
        //删除的步骤
        //1.先找到关键字的位置
        int pos = search(key);
        if (pos == -1) {
            System.out.println("没有要删除的下标");
        }
        //2.将关键字后面的数字前移
        //i最多走到有效数字长度减一位置 因为当this.usdSize==elem.length时
        //elem[i+1]就会数组下标越界
        for (int i = pos; i < this.usdSize-1; i++) {
           this.elem[i] = this.elem[i+1];
       }
        this.usdSize--;
    }

    //数组清零
    //清零操作直接让数组中有效长度为0即可
    public void clear() {
        this.usdSize = 0;
    }

    public static void main(String[] args) {
        MyArray myArray = new MyArray();
        for (int i = 0; i < 10; i++) {
            myArray.add(i,i);
        }
        System.out.println("已测试新增顺序表");
        myArray.display();
        System.out.println();
        System.out.println("已测试打印顺序表");
        System.out.println(myArray.contains(5));
        System.out.println(myArray.search(5));
        System.out.println("已测试两个查找");
        System.out.println(myArray.getPos(1));
        System.out.println(myArray.size());
        System.out.println("已测试pos下标对应的元素和数组长度");
        myArray.remove(0);
        myArray.remove(9);
        myArray.display();
        System.out.println();
        System.out.println("已测试删除数组操作");
        myArray.setPos(2,100);
        myArray.display();
        myArray.clear();
        myArray.display();
        System.out.println();
        System.out.println("已测试数组清零操作");


    }
}
