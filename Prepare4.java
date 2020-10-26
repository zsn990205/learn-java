import java.util.Scanner;

public class Prepare4 {
    public static void main(String[] args) {
        int[] arr = {1,5,6,8,9,4};
        myToStr(arr);
    }

    private static void myToStr(int[] arr) {
        //自己实现将数组以字符串打印
        String str = "[";
        for (int i = 0; i < arr.length; i++) {
            str += arr[i];
            if (i < arr.length - 1) {
                str += ",";
            }
        }
        str += "]";
        System.out.print(str);
    }

    public static void main6(String[] args) {
        int[] arr = new int[2];
        arr[0] = 10;
        arr[1] = 20;
        System.out.println(arr[0]+" "+arr[1]);
        swap(arr);
    }

    private static void swap(int[] arr) {
        int tmp = arr[0];
        arr[0] = arr[1];
        arr[1] = tmp;
        System.out.println(arr[0]+" "+arr[1]);
    }

    public static void main5(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            fibnaci2(n);
        }
    }

    private static void fibnaci2(int n) {
        int f1 = 1;
        int f2 = 1;
        int f3 = 0;
        for (int i = 3; i <= n; i++) {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        System.out.print(f2);
    }

    private static int fibnaci(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return fibnaci(n-1)+fibnaci(n-2);
    }

    public static void main4(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            System.out.println(frogJump(n));
        }
    }

    private static int frogJump(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        return frogJump(n-2)+frogJump(n-1);
    }

    public static void move (char pos1,char pos2) {
        //模拟鼠标的移动过程因为一次只需要从一个位置到另一个位置所以只需要两个指标
        System.out.print(pos1+"-->"+pos2+" ");
    }
    /*
    n代表盘子个数 pos1表示起始位置 pos2表示中间位置 pos3表示终止位置
     */
    public static void hanoi(int n,char pos1,char pos2,char pos3) {
        if (n == 1) {
            move(pos1,pos3);
        } else {
            hanoi(n-1,pos1,pos3,pos2);
            move(pos1,pos3);
            hanoi(n-1,pos2,pos1,pos3);
        }
    }
    public static void main3(String[] args) {
       Scanner scanner = new Scanner(System.in);
       while (scanner.hasNext()) {
           int n = scanner.nextInt();
           hanoi(n,'A','B','C');
       }
           }

    public static void main2(String[] args) {
        //打印123各个数位
        //使用非递归的方式就是%10 /10 此时打印出来的数字是倒着的
        //现使用递归的方式求解 因为我们的任务是打印出各个数位的和所以不能找到一个就立即返回
        //这里是分别打印出各个数位的数字 使用sout
        //当数字>9的时候 ÷10直到为个位数然后求模即可
        //否则直接求模得到值  打印出的数字应该先是个位数
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        NumApart(n);
        //System.out.println(NumApart2(n));
    }

    private static int NumApart2(int n) {
        //求各个数位的和
        if (n < 9) {
            return n;
        }
        return NumApart2(n/10) + n % 10;
    }

    private static void NumApart(int n) {
        //当>9时 一直/10直到找到个位数字
        if (n > 9) {
            NumApart(n / 10);
        }
        //找到个位数字之后一直求模 找到各个数字位数
        //n=123时 分别输出1%10 12%10 123%10
        System.out.print(n % 10+" ");
    }

    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(func(n));
    }

    private static int func(int n) {
        if (n == 1) {
            return 1;
        }
        return n * func(n-1);
    }
}
