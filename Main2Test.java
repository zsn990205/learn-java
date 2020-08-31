import java.math.BigInteger;
import java.util.*;

public class Main2 {

    public static void main7(String[] args) {
       Scanner scanner = new Scanner(System.in);
       while (scanner.hasNext()) {
           String[] s = scanner.nextLine().split(" ");
           //Integer.parseInt将字符串转化成数值类型
           int k = Integer.parseInt(s[s.length-1]);
           int[] arr = new int[s.length-1];
           for (int i = 0; i < s.length-1; i++) {
               arr[i] = Integer.parseInt(s[i]);
           }
           Arrays.sort(arr);
           for (int i = 0; i < k; i++) {
               if (i == (k-1)) {
                   System.out.println(arr[i]);
               } else {
                   System.out.print(arr[i]+" ");
               }
           }
       }
    }
    public static void main6(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int[] arr = new int[10];
            //循环输出 分别表示从0-9数字出现的次数2 2 0 0 0 3 0 0 1 0
            for (int i = 0; i < 10; i++) {
                arr[i] = scanner.nextInt();
            }

            //从1-9选出最小的数字输出一次 并且个数--
            //因为arr数组的数字是按照0-9的个数排列下来的 本来就是有序的
            //首位不能是0 所以从i=1开始
            for (int i = 1; i < 10; i++) {
                if (arr[i] > 0) {
                    System.out.print(i);
                    arr[i]--;
                    break;
                }
            }
            //从0开始输出数组
            for (int i = 0; i < 10; i++) {
                if (arr[i] > 0) {
                    for (int j = 0; j < arr[i]; j++) {
            // 控制位数上输出几次的
            // 比如有2个0 arr[j=0]=2 此时就要将这两个0全部输出
                        System.out.print(i);
                    }
                }
            }
        }
    }
    public static void main5(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            String[] str = new String[n];

            if (n == 1) {
                System.out.println(1);
            } else {
                int base = n*n-(n-1);
                StringBuffer sb = new StringBuffer();
                sb.append(base);
                for (int i = 1; i < n; i++) {
                    sb.append("+").append(base+2*i);
                }
                System.out.print(sb.toString());
            }
        }
    }
    public static void main4(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            //将所有的数字用空格隔开放进数组中
            String[] strs = str.split(" ");

            int[] arr = new int[strs.length];
            for (int i = 0; i < arr.length; i++) {
                //将字符数组中的字符换成值的形式存放在int数组中
                arr[i] = Integer.valueOf(strs[i]);
            }
            Arrays.sort(arr);
            //何为出现次数大于数组一般的数
            //排序后一定在中间出现的数
            if (arr.length % 2 == 0) {
                System.out.println(arr[(arr.length / 2)-1]);
            } else {
                System.out.println(arr[(arr.length ) / 2]);
            }
        }
    }

    public static void main3(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            //charAt(0)是指这行字符串的第一个字符 赋值到c中
            char c = scanner.next().charAt(0);
            //或者用低级做法
            //String c = scanner.next();

            //总列数
            int col = n;
            //总行数
            int row;
            if (col % 2 == 0) {
                row = n / 2;
            } else {
                row = (n+1) / 2 ;
            }
            for (int i = 0; i < row; i++) {
            //i必须先控制行 不然打印出来的结果正好相反
            //大循环在内 小循环在外效率更高!!!
                for (int j = 0; j < col; j++) {
                    if (i == 0 || i == row-1 || j == 0 || j == col-1) {
                        System.out.print(c);
                    } else {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        }
    }
    public static void main2(String[] args) {
        //超长正整数的加法:
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String addend = scanner.nextLine();
            String augend = scanner.nextLine();
            //大数字可以使用BigInteger存放
            BigInteger a = new BigInteger(addend);
            BigInteger b = new BigInteger(augend);
            //这是一个新方法 注意以后学会使用这个新方法
            //求和是x.add(y)的方式 不是单纯的加
            BigInteger ret = a.add(b);
            System.out.println(ret);
        }
    }


    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //本题关键:去重
        //使用set去重
        Set<String> set = new HashSet<>();
        while (scanner.hasNext()) {
            //要用空格分开各个材料 将其放入数组
            String[] str = scanner.nextLine().split(" ");
            //遍历数组 将所有材料放入set中
            for (int i = 0; i < str.length; i++){
                set.add(str[i]);
            }
        }
        //最后输出的set长度大小就是所得到的不同的材料的种类
        //在这里全部的结果输入完才能求set长度
        System.out.println(set.size());
    }

    public String[] getGary(int n) {
    //求格雷码问题 输出的n是位数
    //比如1 ["0","1"]
    //2 ["00","01","10","11"]
    //3 ["000","001","010","011","100","101","110","111"]
    //在这个题中 定义的ret就是n=1的情况 n不为1找个str继续递归
    //此时ret中n的长度肯定是2*(n-1)
    //在ret中加入str数组 因为格雷码满足前一般是数字的第一个数字是0 后一半是1
    //并且前一半和后一半的数字对应位置高度对称 比如n=2时 0和3下标最后一个对应
    //也就是第一个和倒数第二个 第二个和倒数第一个对应 以此类推
     String[] ret = null;
        if (n == 1) {
            ret = new String[]{"0", "1"};
        } else {
            String[] str = getGary(n - 1);
            ret = new String[str.length*2];
            for (int i = 0; i < str.length; i++) {
                //前一半 第一个数字是0的情况
                ret[i] = "0"+str[i];
                //后一半 第一个数字是1的情况
                ret[str.length-1-i] = "1"+str[i];
            }
        }
        return ret;
    }

}
