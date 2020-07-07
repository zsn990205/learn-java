import java.util.*;

public class treeAgain {
    static class Node {
        public char val;
        public Node left;
        public Node right;

        public Node(char val) {
            this.val = val;
        }

         @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    '}';
        }
    }
    static Node buildTree() {
        Node A = new Node('A');
        Node B = new Node('B');
        Node C = new Node('C');
        Node D = new Node('D');
        Node E = new Node('E');
        Node F = new Node('F');
        Node G = new Node('G');
        Node H = new Node('H');

        A.left = B;
        B.left = C;
        C.left = D;
        A.right = E;
        E.right = F;
        F.left = G;
        F.right = H;
        return A;
    }
    public static int getSize(Node root) {
        //求节点个数
        if(root==null) {
            return 0;
        }
        return 1+getSize(root.left)+getSize(root.right);
    }
    public static int getLeafSize(Node root) {
        //求叶子节点个数
        if(root==null) {
            return 0;
        }
        if(root.left==null && root.right==null) {
            return 1;
        }
        return getLeafSize(root.left)+getLeafSize(root.right);
    }
    public static int getKLevelSize(Node root,int k) {
        if(root==null && k<1) {
            return 0;
        }
        if(k==1) {
            return 1;
        }
        return getKLevelSize(root.left,k-1)+getKLevelSize(root.right,k-1);
    }
    public static Node find(Node root, char toFind) {
        if(root==null) {
            return null;
        }
        if(root.val==toFind) {
            return root;
        }
        Node ret=find(root.left,toFind);
        if(ret!=null) {
            return ret;
        }
        return find(root.right,toFind);
    }
    public static void levelOrderTraversal(Node root) {
        //层序遍历
        if(root==null) {
            return;
        }
        Queue<Node> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            Node cur=queue.poll();
            System.out.print(cur+" ");
            if(cur.left!=null) {
                levelOrderTraversal(cur.left);
            }
            if(cur.right!=null) {
                levelOrderTraversal(cur.right);
            }
        }
    }
    public boolean isCompleteTree(Node root) {
        if(root==null) {
            return false;
        }
        //整体思路 根据层序遍历查找是否完全二叉树
        //用来标记现在到第几阶段
        boolean flg=true;
        Queue<Node> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            Node cur=queue.poll();
            if(flg) {
                if(cur.left!=null && cur.right!=null) {
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                    flg=false;
                }
                else if(cur.left==null && cur.right!=null) {
                    return false;
                }
                else if(cur.left!=null && cur.right==null) {
                    queue.offer(cur.left);
                    flg=false;
                }
                else {
                    flg=false;
                }
            } else {
                if(cur.left!=null || cur.right!=null) {
                    return false;
                }
            }

        }
        return true;
    }
    public void preOrderTraversal(Node root) {
        if(root==null) {
            return;
        }
        Stack<Node> stack=new Stack<>();
        stack.push(root);

        while(!stack.empty()) {
        Node cur=stack.pop();
        System.out.print(cur.val+" ");
            if(cur.right!=null) {
                stack.push(cur.right);
            }
            if(cur.left!=null) {
                stack.push(cur.left);
            }
        }
    }
    public void inOrderTraversal(Node root) {
        if(root==null) {
            return;
        }
        Stack<Node> stack=new Stack<>();
        Node cur=root;
        while(true) {
        while(cur!=null) {
            stack.push(cur);
            cur=cur.left;
        }
        if(stack.empty()) {
          break;
        }
        Node top=stack.pop();
        System.out.print(top.val+" ");
        //这个top指的是上一个被访问的节点的右子树
        cur=top.right;
        }
    }
    public void postOrderTraversal(Node root) {
        if(root==null) {
            return;
        }
        Stack<Node> stack=new Stack<>();
        Node cur=root;
        Node prev=null;
        while(true) {
            while(cur!=null) {
                stack.push(cur);
                cur=cur.left;
            }
            if(stack.empty()) {
                break;
            }
            Node top=stack.peek();
            if(top.right==prev || top.right==null) {
                System.out.print(top.val+" ");
                stack.pop();
                prev=top;
            } else {
                cur=top.right;
            }
        }
    }
    public static void main(String[] args) {
        Node node=buildTree();
        treeAgain tree=new treeAgain();
        tree.preOrderTraversal(node);
    }
    public static void main6(String[] args) {
        Node node=buildTree();
        treeAgain tree=new treeAgain();
        boolean t=tree.isCompleteTree(node);
        System.out.println(t);
    }
    public static void main5(String[] args) {
        Node node=buildTree();
        levelOrderTraversal(node);
    }
    public static void main4(String[] args) {
        Node node=buildTree();
        System.out.println(find(node,'Q'));
    }
    public static void main3(String[] args) {
        Node node=buildTree();
        System.out.println(getKLevelSize(node,3));
    }
    public static void main2(String[] args) {
        Node node=buildTree();
        System.out.println(getLeafSize(node));
    }
    public static void main1(String[] args) {
        Node node=buildTree();
        System.out.println(getSize(node));
    }

}