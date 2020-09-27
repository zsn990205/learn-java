import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeMap;

public class Main14 {
    public static void main(String[] args) {
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
             // 先获取要删除的数字的下标
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

    //上楼梯问题
    public int countWays(int n) {
        long[] ret = {1,2,4};
        if (n <= 0) {
            return 0;
        } else if (n <= 3) {
            return (int) ret[n-1];
        } else {
            //找规律可寻 当n=4时 结果7种(数组1+2+4)
            //n=5时 结果13种(2+4+7) 总是ret数组的三个值的和也就是ret[2]
            for (int i = 4; i <= n; i++) {
                long tmp = ((ret[0] + ret[1]) % 1000000007 + ret[2]) % 1000000007;
                ret[0] = ret[1];
                ret[1] = ret[2];
                ret[2] = tmp;
            }
         }
        return (int) ret[2];
    }
    /*
    石头剪刀布问题
     */
    private static class Record {
        public int win;
        public int lose;
        public int tie;
        TreeMap<String,Integer> winCount;  //需要排序时使用
        Record() {
        //构造方法
            this.win = 0;
            this.tie = 0;
            this.lose = 0;
            //winCount用来存放赢取比赛的手势
            this.winCount = new TreeMap<>();
            this.winCount.put("B",0);
            this.winCount.put("C",0);
            this.winCount.put("J",0);
        }
    }
    public static void main2(String[] args) {
        //records中存放的是两个玩家
         Record[] records = new Record[2];
         records[0] = new Record();
         records[1] = new Record();
         Scanner scanner = new Scanner(System.in);
         while (scanner.hasNext()) {
             int n = scanner.nextInt();
             for (int i = 0; i < n; i++) {
                 String a = scanner.next();
                 String b = scanner.next();
                 judge(a,b,records);
             }
             System.out.format("%d %d %d\n",
                     records[0].win,records[0].tie,records[0].lose);
             System.out.format("%d %d %d\n",
                     records[1].win,records[1].tie,records[1].lose);
             System.out.format(mostWinGesture(records[0].winCount)+
                     " "+mostWinGesture(records[1].winCount));
         }
    }

    private static String mostWinGesture(TreeMap<String, Integer> winCount) {
        //表示甲乙获取次数最多的手势
        if (winCount.get("C") >= winCount.get("J")) {
            if (winCount.get("B") >= winCount.get("C")) {
                return "B";
            } else {
                return "C";
            }
        } else {
            if (winCount.get("B") >= winCount.get("J")) {
                return "B";
            } else {
                return "J";
            }
        }
    }

    private static void judge(String a, String b, Record[] records) {
        //这个函数描述的是集中赢得操作 比如将玩家a出的手势和b进行比较
        //看谁赢谁输[简单]
        if (a.equals("B")) {
            if (b.equals("B")) {
                records[0].tie++;
                records[1].tie++;
            } else if (b.equals("C")) {
                //表示A用布赢了B
                win(records,0,"B");
            } else {
                win(records,1,"J");
            }
        } else if (a.equals("C")) {
            if (b.equals("B")) {
                win(records,1,"B");
            } else if (b.equals("C")) {
                records[0].tie++;
                records[1].tie++;
            } else {
                win(records,0,"C");
            }
        } else {
            if (b.equals("B")) {
                win(records,0,"J");
            } else if (b.equals("C")) {
                win(records,1,"J");
            } else {
                records[0].tie++;
                records[1].tie++;
            }
        }
    }

    private static void win(Record[] records, int win, String gesture) {
        //此函数用来存放 哪个玩家谁赢了 出的什么手势赢得
        int lose = 1 - win; //玩游戏的结果就是两种 输和赢
        records[win].win++;
        records[lose].lose++;
        int winCount = records[win].winCount.get(gesture);
        //将玩家赢得手势和赢得的次数放进records表中
        records[win].winCount.put(gesture,winCount+1); //赢了之后赢得次数+1
    }
}
