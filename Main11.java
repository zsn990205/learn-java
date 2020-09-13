import java.util.*;


public class Main11 {
    static class Person implements Comparable<Person> {
        private int people;
        private int money;

        public Person(int people,int money) {
        this.people = people;
        this.money = money;
        }

        @Override
        public int compareTo(Person o) {
            if (this.money > o.money) {
                return -1;
            } else if (this.money < o.money){
                return 1;
            } else {
                return 0;
            }
        }
    }

    public static void main(String[] args) {
        //本题中20的由来: 由于不能拼桌所以超过桌子可容纳的人数时就拒绝服务就行了
        //找到的顾客应该是 人数满足桌子的可容纳人数并且花费在其中还是最高的
        //3+7+10=20
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();  //桌子个数
            int m = scanner.nextInt();  //m批客人

            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();   //每张桌子可容纳的最大人数
            }

            int richMan = 0;
            //消费最大:找花钱最多的顾客开始服务
            PriorityQueue<Person> queue = new PriorityQueue<>();
            for (int i = 0; i < m; i++) {
                int people = scanner.nextInt();
                int money = scanner.nextInt();
                if (people <= arr[n - 1]) {
                    queue.add(new Person(people, money));
                }
            }
        }
    }
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
      //排序 找到最小的k个数
        ArrayList<Integer> list = new ArrayList<>();
        if (k > input.length) {
            return list;
        }
        Arrays.sort(input);
        for (int i = 0; i < k; i++) {
            list.add(input[i]);
        }

        return list;
    }

    public static void main5(String[] args) {
        //找到最长的数字串
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            int count = 0;
            int max = 0;
            int end = 0;
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (ch >= '0' && ch <= '9') {
                    count++;
                    if (max < count) {
                        max = count;
                        end = i;
                    }
                } else {
                    count = 0;
                }
            }
            System.out.println(str.substring(end-max+1,end+1));
        }
    }
    public ArrayList<Integer> clockwisePrint(int[][] mat, int n, int m) {
        // write code here
       ArrayList<Integer> list = new ArrayList<>();
       if (mat == null) {
           return null;
       }
       n = mat.length;    //行数
       m = mat[0].length; //列数
       int start = 0;
       while (n > start*2 && m > start*2) {
           printFormat(mat,n,m,start,list);
           start++;
       }
       return list;
    }

    private void printFormat(int[][] mat, int n, int m, int start, ArrayList<Integer> list) {
        int x = m-1-start;
        int y = n-1-start;
        //从左到右打印一行
        for (int i = start; i <= x; i++) {
            list.add(mat[start][i]);
        }
        //从上到下打印一列
        if (start < y) {
            for (int i = start+1; i <= y; i++) {
                list.add(mat[i][x]);
            }
        }
        //从右到左打印一行
        if (start < y && start < x) {
            for (int i = x-1; i >= 0; i--) {
                list.add(mat[y][i]);
            }
        }
        //从下到上打印一列
        if (start < x && start <y-1) {
            for (int i = y-1; i >= start +1 ; i--) {
                list.add(mat[i][start]);
            }
        }
    }

    public static int findMaxGap(int[] A, int n) {
        // write code here
        int max = A[0];
        int min = 0;
        int ret = 0;
        for (int i = 0; i < n; i++) {
            if (A[i] > max) {
                max = A[i];
            }
        }
        min = A[0] > A[n-1] ? A[n-1]:A[0];
        ret = max-min;
        return ret;

    }

    public static void main2(String[] args) {
        //合唱团的题 不会
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();   //学生人数
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();  //每个学生的能力值
            }
            int k = scanner.nextInt();  //表示每个学生中选取几个
            int d = scanner.nextInt();  //两个学生之间的位置编号不能超过这个数

            long[][] max = new long[k][n];
            long[][] min = new long[k][n];
            for (int i = 0; i < k; i++) {
                for (int j = 0; j < n; j++) {
                    max[i][j] = 1;   //给二维数组赋值
                    if (i == 0) {
                        max[i][j] = arr[j];
                        min[i][j] = arr[j];
                    }
                }
            }
            for(int i = 1; i < k; i++) {
                for (int j = 0; j < n; j++) {
                    for (int m = 1; m <= d; m++) {
                        if (j - m >= 0) {
                            if (arr[j] > 0) {
                                min[i][j] = Math.min(min[i][j], min[i - 1][j - m] * arr[j]);
                                max[i][j] = Math.max(max[i][j], max[i - 1][j - m] * arr[j]);
                            } else {
                                min[i][j] = Math.min(min[i][j], max[i - 1][j - m] * arr[j]);
                                max[i][j] = Math.max(max[i][j], min[i - 1][j - m] * arr[j]);
                            }
                        }
                    }
                }
            }
            long Max = 0;
            for(int i = 0; i < n; i++){
                Max = Math.max(Max, max[k - 1][i]);
            }
            System.out.println(Max);
        }

    }

    public static int MoreThanHalfNum_Solution(int [] array) {
      //超过数组长度一般的数字排序后一定在中间位置
        Arrays.sort(array);
        int count = 0;
        for (int i = 0; i < array.length; i++) {
        if (array[i] == array[array.length/2]) {
            count++;
        }
    }
        if (count > array.length/2) {
        return array[array.length/2];
    } else {
            return 0;
        }
}

    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            String[] ret = new String[n];
            for (int i = 0; i < n; i++) {
                ret[i] = scanner.next();
            }
            String str = scanner.next(); //就是问这个单词的兄弟单词个数
            int num = scanner.nextInt(); //这个表示兄弟单词要输出的第几个兄弟单词

            int count = 0; //表示兄弟单词的个数
            ArrayList<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (isBrother(ret[i],str)) {
                    count++;
                    list.add(ret[i]);
                }
            }
            System.out.println(count);

            //如果兄弟单词的个数比要找的第num个单词多
            //排序 找到第num个 并且第num个的序号要-1
            if (count >= num) {
                Collections.sort(list);
                System.out.println(list.get(num-1));
            }
        }
    }

    private static boolean isBrother(String str1, String str2) {
        if (str1.equals(str2) || str1.length() != str2.length()) {
            //如果第一个和第二个单词一样 或者 第一个单词的个数不等于第二个
            return false;
        }
        char[] ret1 = str1.toCharArray();
        Arrays.sort(ret1);
        char[] ret2 = str2.toCharArray();
        Arrays.sort(ret2);
        //排序后 数组ret1 ret2分别转化成字符串
        //如果这两个字符串不相等 当然不对  即使是兄弟字符串排序后的结果是一样的都只有abc...
        //其他情况都是兄弟字符串
        if (!(String.valueOf(ret1).equals(String.valueOf(ret2)))) {
            return false;
        }
        return true;
    }
}
