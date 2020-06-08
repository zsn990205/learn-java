import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import sun.java2d.pipe.hw.ExtendedBufferCapabilities;

import java.util.Scanner;

public class TestDemo {
    public static int fab(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
            return fab(n - 1) + fab(n - 2);
    }

    public static void main5(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        int ret=fab(n);
        System.out.println(ret);
    }

    /* 汉诺塔问题 */
    public static void move(char pos1, char pos3) {
        System.out.println(pos1 + "-->" +pos3+ " ");
    }

    public static void hanoi(int n, char pos1, char pos2, char pos3) {
        if (n == 1) {
            move(pos1, pos3);
            return;
        }
        hanoi(n - 1, pos1, pos3, pos2);  /*开始位置 中转位置 目的位置    将A上的最大的盘子上的
        一摞盘子经过C移动到B  一摞盘子是一个整体 */
        move(pos1,pos3);  /* 将最大的盘子移动到C */
        hanoi(n - 1, pos2, pos1, pos3);  /*移动剩下的一摞盘子*/
    }

    public static void main4(String[] args) {
        hanoi(1, 'A', 'B', 'C');
        System.out.println();
        hanoi(2, 'A', 'B', 'C');
        System.out.println();
        hanoi(3, 'A', 'B', 'C');
        System.out.println();
    }


    //非递归解决斐波那契数
    public static int fib(int n) {
        int q1=1;
        int q2=1;
        int q3=1;
        for(int i=3;i<=n;i++) {
            q1=q2;
            q2=q3;
            q3=q1+q2;
        }
         return q3;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int ret=fib(n);
        System.out.println(ret);
    }


    //递归打印各个数字位数的和

   public static int sum(int n) {
        if (n < 10) {
            return n;
        }
        return n % 10 + sum(n / 10);
    }


    public static void main2(String[] args) {
       Scanner scan=new Scanner(System.in);
        int n = scan.nextInt();
        System.out.println(sum(n));
    }



     //递归正向打印各个位数字


    public static void print(int n) {
        if(n > 9) {
            print(n/10);
        }
        System.out.println(n%10);
    }
    public static void main1(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n = scan.nextInt();
        print(n);
        }
    }
