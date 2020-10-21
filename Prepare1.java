import java.util.Random;
import java.util.Scanner;

public class Prepare1 {
    private static int i = 1;
    public int getNext() {
        return i++;
    }

    public static void main(String[] args) {
        //打印乘法口诀表
        Scanner scanner  = new Scanner(System.in);
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i+"*"+j+"="+i*j+"\t");
            }
            System.out.println();
        }
    }
    public static void main10(String[] args) {
        //找出1-n之间所有的素数
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            int j = 2;
            for (; j <= (int)Math.sqrt(i); j++) {
                if (i % j == 0) {
                    break;
                }
            }
            if (j > (int)Math.sqrt(i)) {
                System.out.print(i+"是素数"+" ");
            }
        }
    }

    public static void main9(String[] args) {
        //判断一个数是素数吗?
        //素数:除了1和本身之外没有其他约束
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 2; i <= (int)Math.sqrt(n); i++) {
            // 16=1*16=2*8=4*4
            // n的大小一定是小于根号n的
            if (n % i == 0) {
                System.out.println(n+"不是素数");
                break;
            } else {
                System.out.println("是素数啊");
            }
        }
    }

    public static void main8(String[] args) {
        Random random = new Random();
        //生成一个随机数 括号里面表示的是生成随机数的范围
        int num = random.nextInt(100);
        //生成随机数的范围是 100-200
        //int num = random.nextInt(100)+100;
        System.out.println(num);
    }

    public static void main7(String[] args) {
        int ret = 1;
        int sum = 0;
        for (int i = 1; i <= 5; i++) {
            ret *= i;
            sum += ret;
        }
        System.out.println(sum);
    }

    public static void main6(String[] args) {
        int a = 10;
        switch(a) {
            case 1:
                System.out.println("1");
                break;
            case 2:
                System.out.println("2");
                break;
            default:
                System.out.println("请输入正确的值");
                break;
        }
    }

    public static void main5(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        String a = scanner.next();
//        System.out.println(a);
        String b = scanner.nextLine();
        System.out.println(b);
    }

    public static void main4(String[] args) {
        int a = 10;
        int b = ++a; //a = 11(前置++) b=a=11
        int c = a++; //后置++ c = a = 11 a = a++=12
        System.out.println(a+" "+b+" "+c);
    }

    public static void main3(String[] args) {
        System.out.println((float)(5/2));
    }

    public static void main2(String[] args) {
        int i = 10;
        i = i++;
        System.out.println(i);
    }

    public static void main1(String [] args){
        Prepare1 test=new Prepare1();
        Prepare1 testObject=new Prepare1();
        System.out.println(test.getNext());
        System.out.println(testObject.getNext());
        System.out.println(testObject.getNext());
    }
}