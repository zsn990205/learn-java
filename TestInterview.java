import java.util.*;

public class TestInterview {
    static class Test {
        public ArrayList<Integer> data;

        @Override
        public String toString() {
            return "Test{" +
                    "data=" + data +
                    '}';
        }

        public Test() {
            data = new ArrayList<>();


        }
    }
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public int singleNumber(int[] nums) {
    //统计每个数字出现的次数
    //k表示出现的数字 v表示出现的次数
        Map<Integer,Integer> map=new HashMap<>();
        for (int x:nums) {
            Integer count=map.get(x);
            if (count==null) {
    //x没出现过
                map.put(x,1);
            }
            else {
                map.put(x,count+1);
            }
        }
    //遍历map找到只出现一次的数字并输出
        for (Map.Entry<Integer,Integer> entry:map.entrySet()) {
    //equals最好用equals写
    //只出现一次的数
            if (entry.getValue().equals(1)) {
                return entry.getKey();
            }
        }
        return 0;
    }

    public int singleNumber2(int[] nums) {
    //a^b^b=a;
    //a^0=a
    //使用按位异或
    int ret=0;
    for (int x:nums) {
        ret^=x;
    }
    return ret;
    }

    public int[] singleNumber3(int[] nums) {
    //大体思路:1. 将这个数组按位异或得到的数字就是两个只出现一次的数字的异或
    //2.将这两个数字进行异或 取不为0的任意一个比特位进行分组
    // 将数组的元素全部变成二进制位 根据上述比特位将 0/1分成两组
    //3.发现这个只出现一次的数字会被分到两个不同的组中 继续对这两个不同的组进行异或得到具体的值
    int ret=0;
    for (int x:nums) {
        ret^=x;
    }
    //第二部操作 找不为0的一位
        int bit=0;
        for (; bit<32; bit++) {
         if ((ret & (1 << bit)) > 0) {
    //这一步为1
             break;
         }
     }
    //此时bit的对应位是1
    //a,b是最终结果
         int a = 0;
         int b = 0;
    //根据比特位分组循环
    for (int x:nums) {
        if ((x & (1 << bit)) > 0) {
    //以1分组
            a^=x;
        } else {
    //以0分组
            b^=x;
        }
    }
    return new int[]{a,b};
    }
    public static Test copy(Test t) {
    //浅拷贝
       Test t1=new Test();
       t1.data=t.data;
       return t1;
    }

    private static Test deepCopy(Test t) {
    //深拷贝
    Test t2=new Test();
    t2.data.addAll(t.data);
    return t2;
    }

    public Node copyRandomList(Node head) {
    //使用Map 维护新节点和旧节点之间的关系
    //map.put(旧,新)
     Map<Node, Node> map = new HashMap<>();
     for (Node cur = head; cur != null; cur=cur.next) {
         map.put(cur, new Node(cur.val));
     }
     //维护next和random之间的指向关系
     for (Node cur=head; cur != null; cur=cur.next) {
     //此处cur表示的是旧节点 newCur表示的是新节点
         Node newCur = map.get(cur);
         newCur.next=map.get(cur.next);
         newCur.random=map.get(cur.random);
     }
     return map.get(head);
    }

    public int numJewelsInStones(String J, String S) {
    //简单粗暴的方法
    //O(N^2)

    //J是宝石 S是石头
    //遍历s看s的字符是否在j出现 计算次数
    int count=0;
    for (int i = 0; i<S.length(); i++) {
        char c = S.charAt(i);
    //这个的类型是charsequence类型 得转化成字符类型+""就可
            if (J.contains(c+"")) {
                count++;
        }
    }
    return count;
    }

    public int numJewelsInStones2(String J, String S) {
    //使用效率较高的set.contains
    //TreeSet O(lonN)
    //HashSet O(1)
        int count = 0;
    //先把J中的元素倒腾到set中
       Set<Character> set=new HashSet<>();
        for (int i = 0; i < J.length(); i++) {
            set.add(J.charAt(i));
        }
    //再去遍历S 判断S中的字符是否在set中存在
        for (int i = 0; i < S.length(); i++) {
           if (set.contains(S.charAt(i))) {
               count++;
           }
        }
        return count;
    }

    public List<String> topKFrequent(String[] words, int k) {
    //1.统计每个单词出现的次数
        Map<String,Integer> map=new HashMap<>();
        for (String x: words) {
            //拿着x去map里查找 如果找到了就+1 没找到就是0
            //getOrDefault的意思是:拿着x去map里找keyset 如果找到了就是keyset
            //找不到就返回getOrDefault中的值
            //在这里说的是:拿着x去map查找 如果找到的话keyvalue+1 找不到的话执行getOrDefault的值是0
            // 此时因为找到了一个keyset 整体keyvalue+1
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
    //把map中所有的k倒腾到一个ArrayList 这一步要去重
           List<String> ret = new ArrayList<>(map.keySet());
    //根据单词出现的次数 对ret进行降序排序
    //如果两个单词出现的次数一样多 针对字典序排序
            Collections.sort(ret, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    //在这个匿名内部类中会访问到map变量
                    int count1 = map.get(o1);
                    int count2 = map.get(o2);
                    if (count1 == count2) {
                        return o1.compareTo(o2);
                    }
                    return count2 - count1;
                }
            });
    //sublist就是返回 从0到k部分的字母
            return ret.subList(0,k);
        }



    //坏键盘问题
    public static void main(String[] args) {
    //思路: 1.将预期字符串和实际字符串全部转成大写
    //2.实际输出放到一个set中
    //3.遍历预期字符串,看那个字符没有在实际输出的内容中 没出现即为坏键盘
    //4.针对另外一个set去重
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()) {
    //处理输入 读取字符串
            String expected=scanner.next();
            String actual=scanner.next();
    //把两个字符串转成大写
            expected=expected.toUpperCase();
            actual=actual.toUpperCase();
    //设置一个set 放入实际输出
          Set<Character> set = new HashSet<>();
          for (int i = 0; i < actual.length(); i++) {
              set.add(actual.charAt(i));
          }
    //遍历预期字符串
            //去重
            Set<Character> setDelete=new HashSet<>();
            for (int i = 0; i < expected.length(); i++) {
                char c = expected.charAt(i);
                if (set.contains(c)) {
                    continue;
                }
    //对重复的进行删除
                if(setDelete.contains(c)) {
    //有的话就继续循环字符串 不操作
                    continue;
                }
                System.out.print(c);
                setDelete.add(c);
            }
            System.out.println();
        }
    }
    public static void main2(String[] args) {
    //必须保证对t的修改不影响t2
    //此处的实现方法是将t中的data全部加入t2中(在建立t2的时候又开辟了一个空间)
    //因此t和t2的地址不同
        Test t=new Test();
        t.data.add(1);
        t.data.add(2);
        t.data.add(3);

        Test t2=deepCopy(t);
        t.data.add(5);
        System.out.println(t);
        System.out.println();
        System.out.println(t2);
    }
    public static void main1(String[] args) {
    //浅拷贝 修改t相应的t1也会改变(因为t t1的地址相同) 进行直接赋值操作
        Test t=new Test();
        t.data.add(1);
        t.data.add(2);
        t.data.add(3);

        Test t1=copy(t);
        t.data.add(5);
        System.out.println(t);
        System.out.println();
        System.out.println(t1);
    }
}
