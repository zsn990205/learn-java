import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main8 {
    public static void main(String[] args) {
        int first = 0;
        for (int i = 0; i < 30; i++) {
            first += Math.pow(2,i);
        }
        System.out.println(30*10+" "+first);
    }
    public static void main6(String[] args) {
     //球的体积问题
     //半径为(x0-x1)^2+(y0-y1)^2+(z0-z1)^2 开根号
     //体积就是4/3*PI*r^3
     Scanner scanner = new Scanner(System.in);
     while (scanner.hasNext()) {
         int x0 = scanner.nextInt();
         int y0 = scanner.nextInt();
         int z0 = scanner.nextInt();

         int x1 = scanner.nextInt();
         int y1 = scanner.nextInt();
         int z1 = scanner.nextInt();
         //计算半径r
         //sqrt是在开根号
         double r = Math.sqrt(Math.pow(x0-x1,2)+Math.pow(y0-y1,2)+Math.pow(z0-z1,2));
         //计算体积
         //因为是要保留小数 必须得4/3.0
         double v = 4/3.0 * Math.acos(-1) * Math.pow(r,3);
         DecimalFormat decimalFormat = new DecimalFormat("0.000");
         System.out.println(decimalFormat.format(r)+" "+decimalFormat.format(v));
     }
    }

    public static void main5(String[] args) {
        //处理坏键盘问题 输出为大写
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String firstLine = scanner.nextLine();
            String secondLine = scanner.nextLine();
            //先全部转成大写 再用set去重
            firstLine = firstLine.toUpperCase();
            secondLine = secondLine.toUpperCase();
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < secondLine.length(); i++) {
                set.add(secondLine.charAt(i));
            }
            //删除一个加入delete中
            Set<Character>  delete = new HashSet<>();
            for (int i = 0; i < firstLine.length(); i++) {
                char c = firstLine.charAt(i);
                if (set.contains(c)) {
                    continue;
                }
                if (delete.contains(c)) {
                    //这个是为了判断 在输出的坏键盘中有没有重复输出的键
                    continue;
                }
                System.out.print(c);
                delete.add(c);
            }
        }
    }

    public static void main4(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            String jia = scanner.next();
            String yi = scanner.next();
            int countJia = 0;
            int countYi = 0;
            if (jia.equals("B") && yi.equals("C")) {
                countJia++;
            } else if (jia.equals("C") && yi.equals("J")) {
                countJia++;
            } else if (jia.equals("J") && yi.equals("B")) {
                countJia++;
            } else if (yi.equals("B") && jia.equals("C")) {
                countYi++;
            } else if (yi.equals("C") && jia.equals("J")) {
                countYi++;
            } else if (yi.equals("J") && jia.equals("B")) {
                countYi++;
            }
            System.out.println(countJia+" "+countYi);
        }
    }
    public static int countWays(int n) {
        // write code here
        long[] ret = {1,2,4};
        if (n <= 0) {
            return 0;
        } else if(n <= 3) {
            return (int)ret[n-1];
        } else {
            for (int i = 4; i <= n; i++) {
                long tmp = ((ret[0]+ret[1]) % 1000000007 + ret[2]) % 1000000007;
                ret[0] = ret[1];
                ret[1] = ret[2];
                ret[2] = tmp;
            }
        }
        return (int)ret[2];
    }


    public static int countNumberOf2s(int n) {
        // write code here
        //2出现的个数
        int count = 0;
        for (int i = 1; i <= n; i *= 10) {
            int a = n / i,b = n % i;
            //之所以补8，是因为当百位为0，则a/10==(a+8)/10，
            //当百位>=2，补8会产生进位位，效果等同于(a/10+1)
            count += (a + 7) / 10 * i + ((a % 10 == 2) ? b + 1 : 0);
        }
        return count;
    }

    public static void main3(String[] args) {
        int ret = countNumberOf2s(22);
        System.out.println(ret);
    }
    public static void main2(String[] args) {
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNext()) {
                String first = scanner.nextLine();
                //将字符串以空格隔开
                String[] ret = first.split(" ");
                //从后向前输入即可
                for (int i = ret.length-1; i >= 0; i--) {
                    System.out.print(ret[i]+" ");
                }
            }
    }
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
        //这里是把数字也当成字符处理
        //奇偶校验的方法:将字符串转成asc ii 然后转成二进制
        //数二进制中几个1 如果是奇数个首位为0 反之为1
            String s = scanner.nextLine();
        //输入一个字符串 循环遍历这个字符串(若为1个就是1)
        //找到一位就校验一位
            for (int i = 0; i < s.length(); i++) {
               char ch = s.charAt(i);
             jiaoYan(ch);
            }
            }
        }

    private static void jiaoYan(char ch) {
    //先将这个字符转成整数 再转成二进制数
        String str = Integer.toBinaryString((int)ch);
    //长度一般是8位  不够前面补0即可
        while (str.length() < 7) {
            str = "0"+str;
        }
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
         //这里必须是字符'1'
            if (str.charAt(i) == '1') {
                count++;
            }
        }
        if (count % 2 == 0) {
            str = "1"+str;
        } else {
            str = "0"+str;
        }
        System.out.println(str);
    }
}

