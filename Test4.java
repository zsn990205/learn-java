import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        //将这个矩阵的列排成一行 不难发现 隔一个空一个蛋糕
        if (row % 4 ==0 || col %4 ==0) {
            System.out.print((row*col)/2);
        } else {
            System.out.print((row*col)/2+1);
        }
    }
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int ret = minNum(a,b);
        System.out.println(ret);
    }

    private static int minNum(int a, int b) {
        int ret = maxNum(a,b);
        return (a*b) /ret;
    }

    private static int maxNum(int t1, int t2) {
        //求最大公因数的方法要牢记!!!
        //两个数的乘积 : 最大公约数*最小公倍数
        if (t1 < t2) {
            swap (t1,t2);
        }
        int c = t1 % t2;
        while (c != 0) {
            t1 = t2;
            t2 = c;
            c = t1 % t2;
        }
        //System.out.println(t2);
        return t2;
    }

    private static void swap(int t1, int t2) {
        int tmp = t1;
        t1 = t2;
        t2 = tmp;
    }
}
