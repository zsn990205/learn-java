import java.util.*;

public class Main {

    public static void main6(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String n = scanner.next();
        int[] arr = new int[10];
        for (int i = 0; i < n.length(); i++) {
           char ch = n.charAt(i);
           arr[ch-'0']++;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                System.out.println(i+":"+arr[i]);
            }
        }
    }
    public static void main5(String[] args) {
        //思路:这个题就是找到输入的n的大概范围 求取左右两数之差
        //哪个小取哪个 要注意变换f1 f2 f3大小
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int f1 = 0;
        int f2 = 0;
        int f3 = 1;
        while (f3 < n) {
            f1 = f2;
            f2 = f3;
            f3 = f1+f2;
        }
        int a = n-f2;
        int b = f3-n;
        int ret = a>b?b:a;
        System.out.println(ret);
    }
    public static void main4(String[] args) {
        //将数组转换成字符的形式逆序输出
        //思路:进行反转
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(reserve(n));
    }

    private static String reserve(int n) {
        //将数字转换成字符串的方法valueOf()
        //StringBuffer可以在原对象上进行加长或缩短等修改操作
        // 适用于需要大量连接字串或拼接处理字串的情况，
        //因为逆序输出 此时需要数组从最后一个字母开始 将其加入到StringBuffer中
        String str = String.valueOf(n);
        StringBuffer sb = new StringBuffer();
        for (int i = str.length()-1; i >= 0; i--) {
            char ch = str.charAt(i);
            sb.append(ch);
        }
        return sb.toString();
    }

    public static void main3(String[] args) {
        //本题思路:被5整除的数据末尾1个0
        //        被25整除的末尾2个0
        //        以此类推......
        //太妙了 我真是个弟弟!
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int ret = 0;
         for (int i = 5; i <= n; i *= 5) {
             ret = ret + n/i;
        }
        System.out.println(ret);
    }
    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] arr =new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = i;
            }
            System.out.println(deleteNum(arr));
        }
        scanner.close();
    }

    private static int deleteNum(int[] arr) {
        //【删数】有一个数组a[N]顺序存放0~N-1，要求每隔两个数删掉一个数，到末尾时循环至开头继续进行，
        // 求最后一个被删掉的数的原始下标位置。以8个数(N=7)为例: ｛0，1，2，3，4，5，6，7｝，
        // 0->1->2(删除)->3->4->5(删除)->6->7->0(删除),如此循环直到最后一个数被删除。
        //用一个队列保存arr的数字 循环将没删除的元素放入另一个队列 删除的元素直接在原队列中删除
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            queue.add(arr[i]);
        }
        while (queue.size() != 1) {
            int count = 0;
            while (count != 2) {
                queue.add(queue.peek());
                queue.poll();
                count++;
            }
            //如果等于2直接删除
            queue.poll();
        }
        return queue.element();
    }

    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            //用空格分隔开数字 并将他们放入同一个数组
            String[] s = scanner.nextLine().split(" ");
            //K应该是数组的最后一个数字
            int k = Integer.parseInt(s[s.length - 1]);
            int[] arr = new int[s.length - 1];
            for (int i = 0; i < s.length - 1; i++) {
                arr[i] = Integer.parseInt(s[i]);
            }
            //排序
            Arrays.toString(arr);
            //循环输出第k个
            for (int i = 0; i < k; i++) {
                if (i == (k - 1)) {
                    System.out.println(arr[i]);
                } else {
                    System.out.print(arr[i] + " ");
                }
            }
        }
    }

}