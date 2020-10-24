import java.util.Scanner;

public class Prepare3 {
    public static void main6(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(sum(n));
        System.out.println(fab(n));
    }

    private static int fab(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return  n * fab(n-1);
    }

    private static int sum(int n) {
        if (n == 1) {
            return 1;
        }
        return n + sum(n-1);
    }

    public static void main5(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            //int ret = fib(n);
            int ret = fib2(n);
            System.out.println(ret);
        }
    }

    private static int fib2(int n) {
        int f1 = 1;
        int f2 = 1;
        int f3 = 1;
//        for (int i = 3; i <= n; i++) {
//            f1 = f2;
//            f2 = f3;
//            f3 = f1 + f2;
//        }
        while (n > 2) {
            f1 = f2;
            f2 = f3;
            f3 = f1 + f2;
            // 5 > 2成立 但是循环无法输出值的大小
            //所以得找到循环终止条件 终止条件是找到这个n的大小
            n--;
            if (n == 2) {
                break;
            }
        }
        return f3;
    }

    private static int fib(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
            return fib(n-1) + fib(n-2);
    }

    public static void main4(String[] args) {
        for (int k = 0; k < 100; k += 3) {
            int j = (600 - 7*k) / 3;
            int i = (100 - 4*j) / 7;
            if (i + j + k == 100 && (5 * i + 3 * j + k / 3) == 100 && i >= 0 && j >= 0 && k >= 0) {
                System.out.println(i+" "+j+" "+k);
            }
        }
        }

    public static void main3(String[] args) {
        for (int i = 0; i < 12; i++) {
            int j = 12 - i;
            if ((i * 2 + j * 4) == 26) {
                System.out.println(i+" "+j);
            }
        }
    }

    public static void main2(String[] args) {
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                if (i + j == 12 && (i * 2 + j * 4) == 26) {
                    System.out.println(i+" "+j);
                }
            }
        }
    }

    public static void main1(String[] args) {
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                for (int k = 0; k < 100; k++) {
                    int num = i + j + k;
                    int money = 5 * i + 3 * j + k / 3;
                    if (num == 100 && money == 100 && k % 3 == 0) {
                        System.out.println(i+" "+j+" "+k);
                    }
                }
            }
        }
    }
}
