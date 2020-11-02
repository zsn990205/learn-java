package _TestClassCode;

import sun.rmi.transport.proxy.RMISocketInfo;

import java.util.Random;
import java.util.Scanner;

public class TestMain7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int d = scanner.nextInt();
        sum(a,b,c,d);
    }

    private static int sum(int a, int b, int c, int d) {
        return a+b+c+d;
    }
    private static double sum(double a, double b, double c, double d) {
        return a+b+c+d;
    }
    private static double sum(double a,double b) {
        return a+b;
    }
    private static double sum(double a) {
        return a;
    }
    public static void main7(String[] args) {
        int a = 10;
        int b = 20;
        int c = 2;
        System.out.println(compareMax(a, b, c));
    }

    private static int compareMax(int a, int b, int c) {
        int max = a;
        if (c > a) {
            max = c;
        }
        return max > b ? max : b;
    }

    public static void main6(String[] args) {
        //获取二进制数的奇数位和偶数位
        /*
        结果为1才能表示之前那位为1 否则为0
         */
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 31; i >= 1; i -= 2) {
            System.out.print((n >> i) & 1);
        }
        System.out.println();
        for (int i = 30; i >= 0; i -= 2) {
            System.out.print((n >> i) & 1);
        }
    }
    public static void main5(String[] args) {
        //二进制中1的个数(1)
        /*
        解题思路: 将数字和它的前一位相与 每相与一次二进制就少个1
        当最终结果为1的时候 说明所有的1都被找到
         */
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n-1);
        }
        System.out.println(count);
    }

    public static void main4(String[] args) {
        //二进制中1的个数(1)
        /*
        解题思路: 如何求得每一位1的个数呢?我们知道1 & 1 = 1 所以求得1的个数
        也就是让原数的每一位都和1相与 如果结果为1则count++ 否则count不变
          15 = 0000 1111
         & 1=  0000 0001
               0000 0001   但是这种算法很浪费时间 因为假如只有1个1但是程序还是得走32次就很多此一举
         */
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((a & (1 << i)) != 0) {
                count++;
            }
        }
        System.out.println(count);
    }
    public static void main3(String[] args) {
        int[] arr = new int[10];
        Random random = new Random();
        int i = 0;
        for (; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
            if (i % 10 == 0 && i != 0) {
                System.out.println();
            }
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        //findMax(arr);
        System.out.println(findMax2(arr,0,arr.length-1));
    }

    private static int findMax2(int[] arr,int begin,int end) {
//        if (begin > end) {
//            return -1;
//        } else {
//            if (arr[end] < findMax2(arr,begin,end-1)) {
//                return findMax2(arr,begin,end-1);
//            }
//        }
//        return arr[end];

//        if (begin > end) {
//            return -1;
//        } else {
//            int max = arr[end];
//            if (max < findMax2(arr,0,end-1)) {
//                //这里不需要外加判断语句(begin=end=0时)
//                //因为当两者都为0时只有一个数字arr[0] 一个数字就无须比大小了
//                return findMax2(arr,0,end-1);
//            }
//        }
//        return arr[end];
        if (begin > end) {
            return -1;
        }
        else {
            int max = arr[end];
            return max > findMax2(arr,0,end-1) ? max : findMax2(arr,0,end-1);
        }

    }

    private static void findMax(int[] arr) {
        int max = arr[0];
        int i = 1;
        for (; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println(max);
    }

    public static void main2(String[] args) {
        int[] arr = new int[10];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(10);
            if (i % 5 == 0 && i != 0) {
                System.out.println();
            }
            System.out.print(arr[i]);
        }
    }

    public static void main1(String[] args) {
        int[][] arr = {{1,2,3},{4,5},{5,6},{7,5},{8}};
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]+"\t");
            }
            System.out.println();
        }

    }
}
