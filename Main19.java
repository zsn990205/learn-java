import java.util.Scanner;


public class Main19 {
    public static void main5(String[] args) {
        System.out.println(Integer.MAX_VALUE); //2147483647
        System.out.println(Integer.MIN_VALUE); //-2147483648
    }
    public static void main(String[] args) {
        //写一个函数 StrToInt实现把字符串转换成整数(int)这个功能
      /*
      1.数值为0或者字符串不是一个合法的数值则返回0
      2.如果转换后的数超过了整形的最大值或者最小值，那么函数只需 返回最大值或者最小值
      */
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            System.out.println(StrToInt(str));
        }
    }

    private static int StrToInt(String str) {
        if (str.equals("") || str.length() == 0) {
            return 0;
        }
        char[] a = str.toCharArray();
        int sign = 0;
        if (a[0] == '-') {
            sign = 1;
        }
        int sum = 0;
        for (int i = sign; i < a.length; i++) {
            //如果负数从1开始 正数从0开始
            if (a[i] == '+') {
                continue;
            }
            if (a[i] < 48 || a[i] > 57) {
                return 0;
            }
            //arr[i]-48将字符转成数字 就相当于-'0'
            sum = sum * 10 + a[i] - 48;
        }
        if (sum >= Integer.MIN_VALUE) {
            sum = Integer.MAX_VALUE;
        }
        else if (sum > Integer.MIN_VALUE) {
            sum = Integer.MIN_VALUE;
        }
        return sign == 0 ? sum : sum * (-1);
    }

    public static void main4(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        System.out.println(sumCount(num1,num2));

    }

    private static int sumCount(int num1, int num2) {
        //方法 1.将两个数进行异或 2.计算进位(两个数的&左移1位)
        //3.上述两个计算结果的^ (^) 进位制为上述两个值的&左移一位
        int ret1 = num1 ^ num2;
        int inc = (num1 & num2) << 1;
        int ret = (ret1 ^ inc) ^ ((ret1 & inc) << 1);
        return ret;
    }

    public static void main3(String[] args) {
        //任何一个整数m的立方都可以写成m个连续奇数之和
        Scanner scanner = new Scanner(System.in);
        long k = scanner.nextInt();
        long a = (k * k) - k +1;  //就是加和开始的第一个数字
        //这个数字在下面的循环中不好表示 但是使用规律可以计算出大小
        //因此我们找到k和a的关系 然后在表达式中直接定义即可
        ApartNum(k,a);
    }

    private static void ApartNum(long k,long a) {
        //1 ^ 3 = 1
        //2 ^ 3 = 3+5
        if (k == 1) {
            System.out.print(1+"^"+"3"+"="+1);
        }
        System.out.print("k^3"+"="+a);
        for (int i = 1; i < k ; i++) {
            System.out.print("+"+(a+=2));
        }
    }

    public static void main2(String[] args) {
    //java中取对数的方法
        double ret = 0;
        for (int i = 1000; i > 0; i--) {
            ret += Math.log10(i);
        }
        System.out.println((int)ret);
    }

    public static void main1(String[] args) {
        //"aabbccdaa" -> "a2b2c2d1a2"
        String str = "aabbccdaa";
        Count(str);
    }

    private static void Count(String str) {
        char[] arr = str.toCharArray();
        int count = 1;
        StringBuffer sb = new StringBuffer();
        sb.append(arr[0]);
        char tmp = arr[0];
        for (int i = 1; i < arr.length; i++) {
          if (tmp == arr[i]) {
              count++;
          } else {
              sb.append(count); //当不和tmp相等时将上次的count加入sb中并重新计入
              sb.append(arr[i]);
              tmp = arr[i];
              count = 1;
          }
        }
        sb.append(count);  //加的为最后一个字母的count
        System.out.println(sb.toString());
    }
}
