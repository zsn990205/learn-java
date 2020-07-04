import java.util.Scanner;

public class BuildTree {
    static class Node {
        public char val;
        public Node left;
        public Node right;

        public Node(char val) {
            this.val = val;
        }
    }

        // 需要手动处理输入输出的格式
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNext()) {
                String s = scanner.next();
                index = 0;
                Node root = createTreePreOrder(s);//先序
                inOrder(root);  // 打印的每个结果之间都要用空格分割开.
                // 每个输出结果占一行
                System.out.println();
            }
        }

        private static void inOrder(Node root) {
            if (root == null) {
                return;
            }
            inOrder(root.left);
            System.out.print(root.val + " ");
            inOrder(root.right);
        }

        private static int index = 0;  // 帮我们在递归中记住当前处理到哪个字符了.

        // 辅助递归的方法
        // 每递归一次, 就处理一个节点. (从字符串中取出一个指定字符)
        private static Node createTreePreOrder(String s) {
            char ch = s.charAt(index);
            if (ch == '#') {
                // 当前节点是个空树
                return null;
            }
            // 如果节点非空, 就可以访问这个节点. 访问操作就是 "创建节点"
            Node node = new Node(ch);
            index++; // 为了处理下一个节点.
            node.left = createTreePreOrder(s);
            index++; // 再去处理下一个节点.
            node.right = createTreePreOrder(s);
            return node;
        }
    }
