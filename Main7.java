import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Main7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            BigInteger[] bigInteger = new BigInteger[n];
            for (int i = 0; i < n; i++) {
                bigInteger[i] = scanner.nextBigInteger();
            }
            Arrays.sort(bigInteger);
            for (int i = 0; i < n; i++) {
                //不能输出数组 得输出一行一个数字 所以得拆开输出
                System.out.println(bigInteger[i]);
            }
        }
    }
    public static void main6(String[] args) {
        //对于这种情况我们使用递归来解 无人抽奖就是没一个人能拿到
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
        //计算所有人都得不到自己名字的可能情况
            double sum = countNum(n);
        //全排结果
            double sumNum = fib(n);
            double ret = (sum/sumNum) * 100;
            System.out.println(String.format("%.2f",ret)+"%");
        }
    }

    private static double countNum(int n) {
        if (n == 1) {
        //如果就只有1个人 那么他一定不会拿错
            return 0;
        }else if (n == 2) {
            return 1;
        }
        //意思是:当A没拿到自己的名字时 如果是B拿了A的名字 剩下的情况就是n-2(因为2个已经确定了)
        //当B没拿A的名字 剩下的情况就是n-1
        return (n-1)*(countNum(n-1)+countNum(n-2));
    }

    private static double fib(int n) {
        if (n == 1) {
            return 1;
        }
        return fib(n-1)*n;
    }

    public static void main5(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            //输入有几个正整数
            int n = scanner.nextInt();
            //要求的和
            int sum = scanner.nextInt();
            //数组
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            int count = 0; //计数的
            for (int i = 0; i < arr.length; i++) {
                for (int j = i ; j < arr.length; j++) {
                    if (arr[j]+arr[i] == sum) {
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
    public static void main4(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String password = scanner.nextLine();
            if (isLength(password) && isLetter(password) && isStr(password)) {
                   System.out.println("OK");
            } else {
                System.out.println("NG");
            }
        }
    }

    private static boolean isStr(String password) {
        //是否包含长度超过2的字符串
        //如果相同长度>=3 则失败
        for (int i = 0; i < password.length()-3; i++) {
            String s = password.substring(i,i+3);
            String str = password.substring(i+3,password.length());
            if (str.contains(s)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isLetter(String password) {
        //包括大小写字母 数字 其他符号任意3种
        int a = 0; //小写
        int A = 0; //大写
        int n = 0; //数字
        int e = 0; //其他
        //将字符串转成字符数组
        char[] ret = password.toCharArray();
        for (Character s : ret) {
            if (s >= 'a' && s <= 'z') {
                a = 1;
            } else if (s >= 'A' && s <= 'Z') {
                A = 1;
            } else if (s >= '0' && s <= '9'){
                n = 1;
            } else {
                e = 1;
            }
            if ((a+A+n+e) >= 3) {
            //循环只要满足包含三种就可以立刻停止 提高效率
                return true;
            }
        }
        return false;
    }

    private static boolean isLength(String password) {
        if (password.length() > 8) {
            return true;
        }
        return false;
    }

    public static void main3(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            //将n^2转成字符串 将n转成字符串
            // 判断是否^2的末尾带n 25^2=6(25)  6^2=3(6)
            if (String.valueOf(n*n).endsWith(String.valueOf(n))) {
                System.out.println("Yes!");
            } else {
                System.out.println("No!");
            }
        }
    }
    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
        //先输入一个IP地址
        String ip = scanner.nextLine();
        //输入十进制的ip地址
        long decimalIp = scanner.nextInt();
            System.out.println(IPnum(ip));
            System.out.println(decIP(decimalIp));
        }
    }

    private static String decIP(long number) {
       //十进制转成ip
        String ip = "";
        for (int i = 3; i >= 0; i--) {
            ip  += String.valueOf((number & 0xff));
            if(i != 0){
                ip += ".";
            }
            number = number >> 8;
        }

        return ip;

    }

    private static long IPnum(String s) {
      //ip转成十进制
      String[] ipArray = s.split("\\.");
      //这儿注意和示例对应 看例子就明白了
      long ip = (Long.parseLong(ipArray[0]) << 24) + (Long.parseLong(ipArray[1]) << 16) +
                (Long.parseLong(ipArray[2]) << 8) +(Long.parseLong(ipArray[3]));
      return ip;
    }

    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            //在输入这些数字都是啥
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            int ret = scanner.nextInt();
            int i;
          for (i = 0; i < arr.length; i++) {
            if (arr[i] == ret) {
                System.out.println(i);
                break;
            }
        }   if (i == arr.length) {
            //i都是最后一个还没找到
            System.out.println(-1);
        }
        }
    }
}
