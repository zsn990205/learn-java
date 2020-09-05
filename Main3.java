import java.util.*;

public class Main3 {

        public boolean[] chkSubStr(String[] p, int n, String s) {
            // write code here
            boolean[] b = new boolean[n];
            for (int i = 0; i < n; i++) {
                if (s.contains(p[i])) {
                    b[i] = true;
                } else {
                    b[i] = false;
                }
            }
            return b;
        }



    static class Student {
        public String name;
        public int score;

        public Student(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }

    public static void main7(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt(); //输入的人数
            int order = scanner.nextInt(); //排序的方式 为0的时候降序
            //用链表来装学生的姓名和成绩
            List<Student> list = new ArrayList<Student>();
            //将输入的学生的姓名成绩加入链表
            for (int i = 0; i < n; i++) {
                //输入了几个人 就对应几个人的姓名 成绩
                //必须是next不能是nextLine
                String name = scanner.next();
                int score = scanner.nextInt();
                list.add(new Student(name,score));
            }
            //对学生的成绩进行排序
            if (order == 0) {
            //降序
                Collections.sort(list, new Comparator<Student>() {
                    @Override
                    public int compare(Student o1, Student o2) {
                        return o2.score-o1.score;
                    }
                });
            } else if(order == 1){
                Collections.sort(list, new Comparator<Student>() {
                    @Override
                    public int compare(Student o1, Student o2) {
                        return o1.score - o2.score;
                    }
                });
            }
                //排序完后直接输出
                //链表中几个数据输出几次
                for (int i = 0; i < list.size(); i++) {
                    System.out.println(list.get(i).name+" "+list.get(i).score);
                }
            }
        }

    public static void main6(String[] args) {
        //找出String序列中GC出现次数最多的组合
        //思路:GC比列最高的组合实质上就是GC最多的序列
        //从下标为0的位置开始遍历 统计GC的数
        //用max记录输出字串的起始下标 一旦结果子串的下标超过i 交换i和max
        // max永远指向最后结果下标的起始位置 最后输出的是从max位置到max+n位置下标
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            int n = scanner.nextInt();
            fun(str,n);
        }
    }

    private static void fun(String str, int n) {
        //举个栗子: 现有一个字符串序列AGCTAGGCC 输入n=5
        //第一次 i = 0; i < 9-5; i++
        //j = 1;(i的下一个) j < i+n(长度永远是5);j++
        //第一次count=2 max=2 begin=0(起始下标)
        //第二次 i = 1 j =2
        //count = 3, max比刚才的count大(所以一定得有判断条件 max的值是变化的) 现在的max = 3
        //第三次 i = 2 j = 3
        //count = 3 max 还是3
        //第四次 i = 3 j =4
        //count = 3 max 还是3
        //第五次 i = 4 j = 5
        //count = 4 max = 4 全部输入比较完毕 再往下没任何意义了
        //此时 i已经将所有字符串序列遍历完毕 因为i每次增加一次 j就要遍历5次 当i下标=str.length-5的时候
        //j刚好遍历完5组数据 count的值也记录完毕 再往下就会数组下标越界
        // max中永远保存GC的个数(最多的)
        int max = 0;
        //用来存放子序列起始位置下标
        int begin = 0;
        for (int i = 0; i <= str.length(); i++) {
            //用来计算G C有几个的
            int count = 0;
            //这个循环的总长的是n 也就是我们输入的哪个n n个n个分成一组
            //从i的下一个元素开始比较
            for (int j = i; j < i + n; j++) {
                char ch = str.charAt(j);
                if (ch == 'C' || ch == 'G') {
                    count++;
                }
                if (count > max) {
                    max = count;
                    begin = i;
                }
            }
         }
        System.out.println(str.substring(begin,begin+n));
    }

    public static void main(String[] args) {
        //百万富翁给穷人的钱 30*10万
        //穷人给百万富翁的钱 1分+2分+4分+...+2^n-1分
        //穷人的钱
        System.out.println(30*10);
        int begin = 0;
        for (int i = 1; i < 31; i++) {
            double sum = Math.pow(2,i-1);
            begin += sum;
        }
        System.out.println(begin);
    }
    public static void main4(String[] args) {
        //仔细观察输出的几个案例 均为出栈的情况
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
    }

    public static void main3(String[] args) {
        //个别操作不是很懂 还得看看
        //洗牌
        //对于下标< n/2的数字来说 洗牌后的下标=2*之前的下标
        //对于下标> n/2的数字来说 洗牌后的下标=2*(原来的下标-n/2)+1
        Scanner scanner = new Scanner (System.in);
        while (scanner.hasNext()) {
        //数字可以分成几组
            int n = scanner.nextInt();
            //分的数组是0得时候 无法洗牌
            while (n != 0) {
                //前一半数字
                int n1 = scanner.nextInt();
                int n2 = scanner.nextInt();
                int[] arr = new int[2*n1];
                //这一系列操作只涉及下标调换 与下标对应得值没有任何关联关系
                for (int i = 0; i < arr.length; i++) {
                //计算下标
                    int tmp = i;
                    for (int j = 0; j < n2; j++) {
                        if (tmp < n1) {
                            tmp = 2*tmp;
                        } else {
                            tmp = 2*(tmp-n1)+1;
                        }
                    }
                    //元素经过n2次的下标
                    //相当于给 刚刚洗好牌的新的下标 赋值
                    arr[tmp]= scanner.nextInt();
                }
                //遍历数组 输出对应得数字
                for (int i = 0; i < arr.length;i++) {
                    if (i == arr.length-1) {
                        //最后一个数字不能带空格
                        System.out.print(arr[i]);
                    } else {
                        System.out.print(arr[i]+" ");
                    }
                }
                //换行
                System.out.println();
                //整理一组数据 数据个数-1
                n--;
            }
        }
    }
    public static void main2(String[] args) {
        //本题是要输出成绩相同的同学
        //1.给定同学的人数
        //2.给定每个同学成绩
        //3.给定我要找的成绩的数字
        //4.若是有成绩相同的count+1 若是没有直接让n=0退出程序
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            if (n == 0) {
                return;
            }
            int[] arr = new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = scanner.nextInt();
            }
            int score = scanner.nextInt();
            int count = 0;

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == score) {
                  count++;
                }
            }
            System.out.print(count);
         }
    }
    public static void main1(String[] args) {
    //设f(x)=4x+3,g(x)=8x+7。
    //计算可以得到以下两个规律：
    //  g(f(x))=f(g(x))   即f和g的执行顺序没有影响。
    //  f(f(f(x)))=g(g(x))    即做3次f变换等价于做2次g变换
    //f的执行次数只能为 0 1 2(因为2次g变换是3次f变换) 要最少最好是3次f变换
    //题目要我们找最小值 因此我们只需要求x(初始位置) 4x+3 4(4x+3)+3
    Scanner scanner = new Scanner(System.in);
    //输入一个长数据
    long x0 = scanner.nextInt();
    long m = 1000000007; //取模的值
    long s = 100000; //神秘力量的使用次数
    //f(x) = 4x+3执行了3次
    long[] begin = new long[3];
    //输入的值
    begin[0] = x0;
    //第一次f(x)变化
    begin[1] = (4*begin[0]+3) % m;
    //第二次
    begin[2] = (4*begin[1]+3) % m;
    long min = s; //因为s不可能全部使用完 所以定义最小的步数
    //记录f(x)取模变换后的值
    long cur = 0;
    int step = 0; //执行的步数
        for (int i = 0; i < 3; i++) {
            cur = begin[i];
            step = i;
            //当求模之后不为0  还得继续g(x)变换
            while (cur != 0 && step < min) {
                cur = (8*cur+7) % m; //g(x)执行
                step++;
            }
            min = min < step? min:step;
        }
        if (min < s) {
            System.out.println(min);
        } else {
            //使用次数使用完还没找到贝壳输出-1
            System.out.println(-1);
        }
    }
    public static int addAB(int A, int B) {
        // 另类加法 不用加减乘除实现加法运算
        if (B != 0) {
        //表示两数相加
            int a = A ^ B;
        //表示进位
            int b = (A & B) << 1;
            return a+b;
        } else {
            return A;
        }
    }
}
