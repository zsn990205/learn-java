import java.util.Scanner;

public class Prepare2 {
    public static void main8(String[] args) {
        for (int i = 3; i > 0; i--) {
            for (int j = 2; j > 0; j--) {
                if (j == 1) {
                    break;
                } else {
                    System.out.print("i= "+i+"j= "+j+"\t");
                    System.out.println();
                }
            }
        }
    }

    public static void main7(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.print(i+" ");
            if (i == 7) {
                continue;
            }
            System.out.println("game over");
        }
    }

    public static void main6(String[] args) {
        int i = 0;
        do {
            System.out.print(i+" ");
            i++;
        } while (i <= 9);
    }

    public static void main5(String[] args) {
       int i = 1;
       while (i < 10) {
           int j = 1;
           while (j <= i) {
               System.out.print(i+"*"+j+"="+i*j+" ");
               j++;
           }
           System.out.println();
           i++;
       }
    }

    public static void main4(String[] args) {
        //求出0～999999 之间的所有“一位-6位自幂数”并输出
        //1.先求出数字的位数
        //2.求出每一位并进行运算
        //3.拿值和原数字进行比较 符合条件即为X位自幂数
        for (int n = 1; n <= 999999; n++) {
            int count = 0;
            int tmp = n;
        //第一步
            while (tmp != 0) {
                count++;
                tmp /= 10;
          }
        //第二步 count = 3 但是 n = 0
            tmp = n;
            int sum = 0;
            while (tmp != 0) {
                sum += Math.pow((tmp % 10),count);
                tmp /= 10;
            }
        //第三步 比较大小
             if (sum == n) {
                 System.out.println(n);
             }
        }
    }

    public static void main3(String[] args) {
    //1-100出现几个9 %和/分开计算
        int count = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 10 == 9) {
                count ++;
            }
            if (i / 10 == 9) {
                count++;
            }
        }
        System.out.println(count);
    }

    public static void main2(String[] args) {
    //计算1/1-1/2+1/3-1/4+1/5 …… + 1/99 - 1/100 的值
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt(); //100
        double ret = 0;
        int flag = 1;
        for (int i = 1; i <= a; i++) {
            ret += (1.0)/i * flag;
            flag = -flag;
        }
        System.out.println(ret);
    }

    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt(); //24
        int b = scanner.nextInt(); //14
        int c = a % b;
        while (c != 0) {
            a = b;
            b = c;
            c = a % b;
        }
        if (a % b == 0) {
            c = a > b ? b : a;
        }
        System.out.println(c);
    }

}
