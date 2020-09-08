
import java.util.*;

public class Main6 {

 static class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        this.val = val;
    }
 }
    public ListNode plusAB(ListNode a, ListNode b) {
            // write code here
         //将链表转化成整数
         //aValue和bValue在链表中是反向存储的
         // 真正计算值的时候应该先反转过来 再加
         int aValue = ListNodeConvert(a);
         int bValue = ListNodeConvert(b);
         int sum = aValue + bValue;
         //将整数转化成链表
        return convertListNode(sum);
        }

    private ListNode convertListNode(int value) {
     //将数字value转成字符串
     //toCharArray()再将字符串转成字符数组
        char[] charArray = String.valueOf(value).toCharArray();
        ListNode node = new ListNode(Integer.parseInt(String.valueOf(charArray[charArray.length - 1])));
        ListNode cur = node;
        //整数反转存储到链表中
        //-1得到下标 因为是反向存放 最后一个数字就可以不动
        //倒数第二个往最后一个后面添加就行了
        for (int i = charArray.length - 2; i >= 0; i--) {
            ListNode newNode = new ListNode(Integer.parseInt(String.valueOf(charArray[i])));
            //这儿就相当于将新节点后插
            cur.next = newNode;
            cur = newNode;      }
        return node;
    }

    private int ListNodeConvert(ListNode node) {
     //使用字符串拼接的方式
     StringBuilder sb = new StringBuilder();
     ListNode cur = node;
     while (cur != null) {
         sb.append(cur.val);
         cur = cur.next;
     }
     //直接将字符串反转
     return Integer.parseInt(sb.reverse().toString());
    }

    public static void main(String[] args) {
    //排列组合找出火车出栈的所有可能情况 进行筛选 找出满足先进后出的
        Scanner scanner = new Scanner(System.in);
    //输入火车的个数
        int n = scanner.nextInt();
    //输入火车编号
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }
        int start = 0;
    //计算n个火车出栈的编号和排列组合
        ArrayList<int[]> result = new ArrayList<>();
        Permutation(A,start,n,result);
    //出栈的结果 一个元素一个元素的记录 1 2 3;1 3 2
        Set<String> sortResult = new TreeSet<>();
        for (int[] out : result) {
          if (isLegal(A,out,n)) {
             StringBuilder sb = new StringBuilder();
             for (int i = 0; i < n-1; i++) {
                 sb.append(out[i]+" ");
             }
              sb.append(out[n-1]);
             sortResult.add(sb.toString());
          }
        for (String s : sortResult) {
            System.out.println(s);
        }
        }
    }

    private static boolean isLegal(int[] a, int[] out, int n) {
        return true;
    }


    private static void Permutation(int[] A, int start, int n, ArrayList<int[]> result) {
        if (start == n) {
            return;
        }
        if (start == n-1) {
            int[] B = A.clone();
            result.add(B);
            return;
        }
        for (int i = 0; i < n; i++) {
            swap(A,start,i);
           Permutation(A,start+1,n,result);
            swap(A,start,i);
        }
    }

    private static void swap(int[] A, int start, int i) {
        int tmp = A[start];
        A[start] = A[i];
        A[i] = tmp;
    }

    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int ret1 = 0; //各个数位剥离
        int pow = (int)Math.pow(n,2);
        int ret2 = 0;
        while (n > 0) {
           ret1 += n%10;
           n /= 10;
        }
        while (pow > 0) {
            ret2 += pow%10;
            pow /= 10;
        }
        System.out.println(ret1+" "+ret2);
    }


    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt(); //候选人人数
            int Invalid = 0;
            //下面将使用linkedHashMap存放 候选人的姓名及分数(保证有序)
            Map<String,Integer> map = new LinkedHashMap<>();
            for (int i = 0; i < num; i++) {
                String name = scanner.next(); //候选人姓名
                //0根据后续的条件 进行增加删除
                map.put(name,0);
            }
            //将无效票也存放在map中
            map.put("Invalid",0);
            int votePeople = scanner.nextInt(); //投票人数
            //对应的votes就对应上面的候选人姓名
            for (int i = 0; i < votePeople; i++) {
                String votes = scanner.next(); //投票
                if (map.containsKey(votes)) {
                    map.put(votes,map.get(votes)+1);
                } else {
                    map.put("Invalid",map.get("Invalid")+1);
                }
            }
            for (String k : map.keySet()) {
                System.out.println(k+" : "+map.get(k));
            }
        }
    }
}
