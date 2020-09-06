
import java.util.Arrays;

import java.util.LinkedList;
import java.util.Scanner;

public class Main4 {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            if (root.left == null && root.right == null) {
                return 1;
            }
            int leftDepth = maxDepth(root.left);
            int rightDepth = maxDepth(root.right);
            return 1 + (leftDepth < rightDepth ? rightDepth : leftDepth);
        }

        public boolean isBalance(TreeNode root) {
            // write code here
            //先搞一个方法计算最大深度
            if (root == null) {
                return true;
            }
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return (left - right <= 1 && left - right >= -1) && isBalance(root.left) && isBalance(root.right);
        }

        public ListNode plusAB(ListNode a, ListNode b) {
            //没看懂
            // write code here
            if (a == null) {
                return b;
            }
            if (b == null) {
                return a;
            }
            ListNode p = a;
            ListNode t = b;
            ListNode head = new ListNode(0);
            ListNode cur = head;
            //表示进位
            int sum = 0;
            while (p != null || t != null || sum != 0) {
                if (p != null) {
                    sum += p.val;
                    p = p.next;
                }
                if (t != null) {
                    sum += t.val;
                    t = t.next;
                }
                cur.next = new ListNode(sum % 10);
                sum /= 10;
                cur = cur.next;
            }
            return head.next;
        }

        public static void main3(String[] args) {
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNext()) {
                String str = scanner.nextLine();
                String ret = scanner.nextLine();
                LinkedList<Character> list = new LinkedList<Character>();
                //将长字符串加入链表中
                for (int i = 0; i < str.length(); i++) {
                    char ch = str.charAt(i);
                    list.add(ch);
                }
                int count = 0;
                for (int i = 0; i < ret.length(); i++) {
                    char c = ret.charAt(i);
                    for (int j = 0; j < list.size(); j++) {
                        if (c == list.get(j)) {
                            //如果所得的数字存在 那么将这个删除接下来得到的值不管全不全都可以
                            //全的时候 剩下的数字刚好是剩余没用到的
                            //不全 剩下的就是缺的
                            list.remove(j);
                            count++;
                            break;
                        }
                    }
                }
                if (count == ret.length()) {
                    //在所有的珠子中减去数到的珠子就是剩下的个数
                    System.out.println("Yes" + " " + (str.length() - count));
                } else {
                    //在子串的珠子中减去数到的就是没有的
                    System.out.println("No" + " " + (ret.length() - count));
                }
            }
        }


        public static void main2(String[] args) {
            //每一个密码均为明文后的第五个字符(按照字典序的序列)
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNext()) {
                String s = scanner.nextLine();
                for (int i = 0; i < s.length(); i++) {
                    //ch指输入的密文
                    char ch = s.charAt(i);
             //原文字母的对应形式如下:
             //A B C D E  F G H I J K L M N O P Q R S T U V W X Y Z(密码)
             //V W X Y Z  A B C D E F G H I J K L M N O P Q R S T U(原文)
                //指 A-E部分 将字符转成数字+21 再转成字符输出
                //为什么要加21呢?
                //是因为 从A->V刚好错21个 A的数加上21就是V
                    if (ch >= 'A' && ch < 'F') {
                        System.out.print((char) ((int) ch + 21));
                    } else if (ch > 'E' && ch < 'Z') {
                //指 E-Z部分
                //从F开始 F->A只差5个 向前-5即可
                        System.out.print((char) ((int) ch - 5));
                    } else {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        }

        public static void main1(String[] args) {
            //显然 递归
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNext()) {
                int month = scanner.nextInt();
                int ret = birthRabbit(month);
                System.out.println(ret);
            }
        }

        private static int birthRabbit(int month) {
            if (month < 3) {
                return 1;
            }
            return birthRabbit(month - 1) + birthRabbit(month - 2);
        }

        public ListNode partition(ListNode pHead, int x) {
            //链表分割 小于x的排在大于或等于x的前面
            //返回头节点 链表顺序不能变
            //链表分别分成两个部分 >x和 <x的
            // bs表示大于x的头部
            // be表示尾部 以此类推
            ListNode bs = null;
            ListNode be = null;
            ListNode as = null;
            ListNode ae = null;
            ListNode cur = pHead;
            while (cur != null) {
                if (cur.val < x) {
                    if (bs == null) {
                        bs = cur;
                        //此时尾部也就是头部 因为只有一个数字
                        be = bs;
                    } else {
                        //此时bs链表已有数据 所以让cur指向be的next 并且be指针后移
                        be.next = cur;
                        be = be.next;
                    }
                }
                if (cur.val >= x) {
                    if (as == null) {
                        as = cur;
                        ae = as;
                    } else {
                        ae.next = cur;
                        ae = ae.next;
                    }
                }
                //cur后移保证链表一直在循环
                cur = cur.next;
            }
            if (bs == null) {
                return as;
            }
            //bs不为空 be的next是as
            be.next = as;
            //存在 >= x的数据
            if (as != null) {
                //这儿必须得处理 要不然链表会一直循环下去
                ae.next = null;
            }
            return bs;
        }

        public int getValue(int[] gifts, int n) {
            // write code here
            int count = 0;
            //排序后大于n/2的一定在中间位置
            Arrays.sort(gifts);
            for (int i = 0; i < gifts.length; i++) {
                if (gifts[i] == gifts[n / 2]) {
                    //如果这个红包的金额超过个数一半的数字
                    count++;
                }
                if (count > n / 2) {
                    return gifts[n / 2];
                }
            }
            return 0;
        }

}
