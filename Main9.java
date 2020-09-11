import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main9 {
    public static void main(String[] args) {
        //整理时再看看
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String begin = scanner.nextLine();
            String delete = scanner.nextLine();
            for (int j = 0; j < delete.length(); j++) {
               begin = begin.replaceAll(delete.substring(j,j+1),"");

            }
            System.out.print(begin);
        }

    }

    public static void main4(String[] args) {
        //句子逆序
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String prime = scanner.nextLine();
            //先将数组用空格分割开来
            String[] s = prime.split(" ");
            for (int i =s.length-1; i > 0; i--) {
                System.out.print(s[i]+" ");
            }
            System.out.println(s[0]);
        }
    }
    public static String replaceSpace(String iniString, int length) {
        // write code here
        //把空格替换成%20
        //遍历字符串 找到空格位置将其改成%20
       StringBuilder sb = new StringBuilder();
       for (int i = 0; i < length; i++) {
           char ch = iniString.charAt(i);
           //将char变量转换成字符串 只有字符串才能和空(字符串)比较
           if (String.valueOf(ch).equals(" ")) {
               sb.append("%20");
           } else {
               sb.append(ch);
           }
       }
       return sb.toString();
    }


    public int[] arrayPrint(int[][] arr, int n) {
        // write code here
        int [] out=new int[n*n];
        int index=0;
        for(int j=n-1;j>=0;j--){
            int k=j;
            for(int i=0;i<n-j;i++){
                out[index++]=arr[i][k++];
            }
        }
        for(int i=1;i<n;i++){
            int k=i;
            for(int j=0;j<n-i;j++){
                out[index++]=arr[k++][j];
            }
        }
        return out;
    }
    public static void main3(String[] args) {
        //题意:是否可以组成三角形
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        while (scanner.hasNext()) {
            //输入几次数据
            int num = scanner.nextInt();
            for (int i = 0; i < num; i++) {
                int n = scanner.nextInt();
                int length = scanner.nextInt();
                if (n == 1) {
                    //将其中的长度加入链表
                    list.add(length);
                } else {
                    //删除
                    //先获取要删除的数字的下标
                    int delete = list.indexOf(length);
                    list.remove(delete);
                }
                if (list.size() < 3) {
                    System.out.println("No");
                } else {
                    //按照自然顺序进行排序
                    Collections.sort(list,Collections.reverseOrder());
                    int max = list.get(0);
                    int sum = 0;
                    //0号下标已经取做最大的数字了 接下来从1号下标开始比较
                    for (int j = 1; j < list.size(); j++) {
                        sum += list.get(j);
                    }
                    if (max < sum) {
                        System.out.println("Yes");
                    } else {
                        System.out.println("No");
                    }
                }
            }
        }
    }

    public static void main2(String[] args) {
        //写一个程序 将十六进制转换成10进制
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
        //输入一组字符串
            String num = scanner.next();
        //记住这个方法 ! ! !
            Integer ret = Integer.decode(num);
            System.out.println(ret);
        }
    }
    public static void main1(String[] args) {
       //以后遇到类似的需要统计的数组的时候 尽量使用双数组
       //一个将字符串中的字母全部放入数组中
       //一个统计字母出现的次数
       //这个方法挺常见的 ! ! !
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            //将输出的字母全部放在数组中
            char[] str = scanner.next().toCharArray();
            //这个数组用来计数 用来计入每个字母有几个
            int[] count = new int[256];
            for (char s : str) {
                //遍历字母数组 遇到就++
                count[s]++;
            }
            for (int i = 'A'; i <= 'Z'; i++) {
                System.out.println((char)i +":"+count[i]);
            }
        }
    }

    public int calculateMax(int[] prices) {
      //题意:要找数组中相差数的和中的 最大的
        int sum = 0;
        int tmp = 0;
        for (int i = 0; i < prices.length; i++) {
            tmp = getMax(prices, 0, i) + getMax(prices, i, prices.length - 1);
            if (tmp > sum) {
        //时刻记住 找最大
                sum = tmp;
            }
        }
        return sum;
    }

    private int getMax(int[] prices, int start, int end) {
        int max = 0;
        int min = prices[start];
        for (int i = start+1; i <= end; i++) {
            if (prices[i] < min) {
                min = prices[i] ;
            } if (prices[i]-min > max) {
                max = prices[i]-min;
            }
        }
        return max;
    }
}

