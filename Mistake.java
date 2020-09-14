import java.util.Scanner;

public class Mistake {
    //n个物品 体积逐一放在weight数组中
    //递归函数 s表示剩余物品数量 n表示剩余可选的物品个数
    //步骤:
    //1.从后向前装装入weight[n]有解 count(s-weight[n],n-1)
    //装入weight[n]无解  删除后尝试count(s,n-1)
    static int[] weight;
    static int n;
    static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
             n = scanner.nextInt();
             weight = new int[n+1];

             for (int i = 1; i <= n; i++) {
                 weight[i] = scanner.nextInt();
             }
             //Count(40,n);
            //System.out.println(count);
            System.out.println(fun(40,n));
        }
    }

    private static int fun(int s, int n) {
        //剩余物品是0
        if (s == 0) {
            return 1;
        }
        //剩余可挑选物品是0
        if (n <= 0) {
            return 0;
        }

        // 1.此时剩余的物品中可以放得下我输入的数据 剩下的物品数就是40-我输入的 同时物品数-1
        // 2.剩余的物品放不下我输入的数据(比如我现在要放20个
        // 但是剩余就只有10个物品了 说明此时我输入的这个物品不能放进去 所以剩下的数据仍然是s)
        // 但是刚才的n放不了 得继续找下一个n 所以此时是n-1
        return fun(s-weight[n],n-1)+fun(s,n-1);
    }

    private static void Count(int s, int n) {
        //恰好装满
        if (s == 0) {
            ++count;
            return ;
        }
        //没剩 或者剩了但是可选的物品数没了
        if (s < 0 || (s > 0 && n < 1)) {
            return ;
        }
         Count(s-weight[n],n-1);
         Count(s,n-1);

    }

    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            //输入最长的哪个字符串 they are students
            //toCharArray是将字符转换成字符数组
            //必须得有一个数组:因为最后的结果是针对长字符串的下标和要删除的字符串的对比实现的
            char[] ch = scanner.nextLine().toCharArray();
            String str = scanner.nextLine();
            for (int i = 0; i < ch.length; i++) {
                //将ch数组每一项转换成字符串
                //必须是str和ch的每一项比对
                //输出 不包含在要删除字符串中的字符即可
                if (!str.contains(String.valueOf(ch[i]))) {
                    System.out.print(ch[i]);
                }
            }
        }
    }
    public static void main1(String[] args) {
    //将用户输入的字符串变为char
    // 一个指针从前往后一个从后往前 相等即是回文串
    Scanner scanner = new Scanner(System.in);
    String str1 = scanner.nextLine();
    String str2 = scanner.nextLine();
    int count = 0;
    for (int i = 0; i <= str1.length(); i++) {
        StringBuffer sb = new StringBuffer(str1);
        //将s1的0号下标插入str2 1号下标插入srr2...以此类推
        sb.insert(i,str2);
        if (isHuiWen(sb.toString())) {
            count++;
        }
    }
        System.out.println(count);
    }

    private static boolean isHuiWen(String s) {
        int i = 0;
        int j = s.length()-1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

}
