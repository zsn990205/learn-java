import java.util.Scanner;

public class Main18 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
        public ListNode insertionSortList (ListNode head) {
            if (head == null || head.next == null) {
                return null;
            }
            ListNode newNode = new ListNode(0);
            ListNode cur = head;
            while (cur != null) {
                ListNode pre = newNode;
                ListNode next = cur.next;
                while (pre.next != null && pre.next.val < cur.val) {
                    pre = pre.next;
                }
                cur.next = pre.next;
                pre.next = cur;
                cur = next;
            }
            return newNode.next;
        }

        public static ListNode removeKthNode(ListNode head, int k) {
            //1->2->3->4->5  ->  1->2->3->5删除倒数第二个
            ListNode pre = head;
            ListNode cur = head;
            if (head == null && k <= 0) {
                return null;
            }
            for (int i = 0; i < k; i++) {
                cur = cur.next;
            }
            //此时cur走到了k-1位置
            if (cur.next == null) {
                return head.next; //仅剩一个元素
            }
            while (cur.next != null) {
                cur = cur.next;
                pre = pre.next;
            }
//            pre.next = cur;
        //此处不能写成上述表示  如果{1.2.1}k=1时 则会变成{1.2}
            pre.next = pre.next.next;
            return head;
        }

        public static void main4(String[] args) {
            //给定一个整型数组和一个整数n找到该数组中和为n的 连续 的子数组的个数
            Scanner scanner = new Scanner(System.in);
            int k = scanner.nextInt();
            int[] arr = {1, 1, 1};
            int count = 0;
            for (int i = 0; i < arr.length; i++) {
                int sum = 0;   //因为是连续子串所以要求每次sum的值从0开始
                for (int j = i; j < arr.length; j++) {
                    sum += arr[j];
                    if (sum == k) {
                        count++;
                    }
                }
            }
            System.out.println(count);
        }

        public static void main3(String[] args) {
            //如何判断一个数是否是2的k次方
            Scanner scanner = new Scanner(System.in);
            int k = scanner.nextInt();
            System.out.println(isRet(k));
        }

        private static boolean isRet(int k) {
            //思想:一直左移(*2)当值和k相等时 即为2的k次方
            if (k % 2 != 0) {
                return false;
            }
            int i = 1;
            while (i <= k) {
                if (i == k) {
                    return true;
                }
                i <<= 1;
            }
            return false;
        }

        public static void main2(String[] args) {
            //找出数组中只出现一次的数字 和0异或
            int[] arr = {3, 2, 6, 3, 1, 9, 2, 6, 1};
            int ret = 0;
            for (int i = 0; i < arr.length; i++) {
                ret ^= arr[i];
            }
            System.out.println(ret);
        }

        public static void main1(String[] args) {
            //统计字符串中数字个数
            String ret = "bit666keji123";
            int count = 0;
            for (int i = 0; i < ret.length(); i++) {
                char ch = ret.charAt(i);
                if (ch >= '0' && ch <= '9') {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
