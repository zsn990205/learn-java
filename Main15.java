import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main15{
    static class People {
        int height;
        int weight;

        public People(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            People[] arr = new People[n];
            for (int i = 0; i < arr.length; i++) {
                int index = scanner.nextInt();
                arr[index-1] = new People(scanner.nextInt(),scanner.nextInt());
            }
            //对所有人员进行排序
            Arrays.sort(arr, new Comparator<People>() {
                @Override
                public int compare(People p1, People p2) {
                //身高相同时 体重不同就可以叠
                //但是体重相同时 身高必须相同才可以
                    int ret = Integer.compare(p1.height,p2.height);
                    if (ret != 0) {
                        return ret;
                    } else {
                        return Integer.compare(p1.weight,p2.weight);
                    }
                }
            });
            int[] dp = new int[n];
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < dp.length; i++) {
                dp[i] = 1;
                for (int j = i - 1; j >= 0; j--) {
                    if (arr[i].weight > arr[j].weight || arr[i].weight == arr[j].weight
                    &&  arr[i].height == arr[j].height) {
                        dp[i] = Math.max(dp[i],dp[j]+1);
                    }
                }
                max = Math.max(dp[i],max);
            }
            System.out.println(max);
        }

    }
    /*
    求和
     */
    static ArrayList<ArrayList<Integer>> res = new ArrayList<>(); //用来存放最后的结果
    static ArrayList<Integer> list = new ArrayList<>();
    public static void main3(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            //dfs(1,m,n);
            for (ArrayList<Integer> l : res) {
                int i = 0;
                
            }

        }
    }
    /*
    坐标移动 将每组数据分开根据规定的值进行运算并得出最后的结果
    注重str.subString().matches() 比如matches([0-9]{1,2})
    就是说 1-2连续位置的值的范围是0-9 A10 A是0号位置 1是1位置 0是2位置
     */
    public static void main2(String[] args) {
       Scanner scanner = new Scanner(System.in);
       while (scanner.hasNext()) {
           String str = scanner.nextLine();
           //将每组数据用;分开
           String[] A = str.split(";");
           int x = 0;
           int y = 0;
           for (String string : A) {
               //因为值是以A10这种形式存储的 所以第一个字母为类型(x/y相加减)
               //判断从1位置起是否是存在连续的1-2位数字 数字范围[0-9]
               if (string.charAt(0) == 'D' && string.substring(1).matches("[0-9]{1,2}")) {
                   x += Integer.parseInt(string.substring(1));
               }
               if (string.charAt(0) == 'W' && string.substring(1).matches("[0-9]{1,2}")) {
                   y += Integer.parseInt(string.substring(1));
               }
               if (string.charAt(0) == 'S' && string.substring(1).matches("[0-9]{1,2}")) {
                   x -= Integer.parseInt(string.substring(1));
               }
               if (string.charAt(0) == 'A' && string.substring(1).matches("[0-9]{1,2}")) {
                   y -= Integer.parseInt(string.substring(1));
               }
           }
           System.out.println(x+","+y);
       }
    }
    /*
    回文字符串:解题思路
    假如添加一个字符是回文 那么删除一个字符串还是回文
    假如删除字母在中间的话 那么这个字符串本身就是回文
    若删除的是两边的字符串 那么长度为n-1的两个子串必定有一个是回文
     */
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            if (isHuiwen(s.substring(0,s.length()-1)) || isHuiwen(s.substring(1,s.length()))
                || isHuiwen(s)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static boolean isHuiwen(String s) {
        return new StringBuilder(s).reverse().toString().equals(s);
    }
}

