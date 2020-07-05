import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TestDemo {
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
    public static int leaf=0;
    public static void leaf(Node root) {
        if(root==null) {
            return;
        }
        if(root.left==null && root.right==null) {
            leaf++;
            return;
        }
        leaf(root.left);
        leaf(root.right);
    }
    public static int leafSize2(Node root) {
        if(root==null) {
            return 0;
        }
        if(root.left==null && root.right==null) {
            return 1;
        }
        return leafSize2(root.left)+leafSize2(root.right);
    }
    public static int kLevelSize(Node root, int k) {
        //求第K层的节点
        if(k<=0 || root==null) {
            return 0;
        }
        if(k==1) {
            return 1;
        }
        //A的第3=B的第2+C的第2
        return kLevelSize(root.left,k-1)+kLevelSize(root.right,k-1);

    }
    public static Node ret=null;
    public static void findValue(Node root, char toFind) {
        //在一个二叉树中 查找是否含有某个值
   if(root==null) {
       return;
   }
   if(root.val==toFind) {
       ret=root;
       return;
   }
        findValue(root.left,toFind);
        findValue(root.right,toFind);

    }
    public static Node find(Node root, char toFind) {
        if(root==null) {
            return null;
        }
        if(root.val==toFind) {
            return root;
        }
        Node cur=find(root.left,toFind);
        if(cur!=null) {
            return cur;
        }
        return find(root.right,toFind);
    }
    public void levelOrder(Node root) {
        //层序遍历
        if(root==null) {
            return;
        }
       Queue<Node> t=new LinkedList<>();
        t.offer(root);
        while(!t.isEmpty()) {
            //加入首元素
            //打印
            //加入当前元素的左右子树并返回到第一步
            Node cur=t.poll();
            System.out.print(cur.val+" ");
            if(cur.left!=null) {
                levelOrder(cur.left);
            }
            if(cur.right!=null) {
                levelOrder(cur.right);
            }
        }
    }
    public boolean isCompleteTree(Node root) {
        //层序遍历
        //第一阶段:节点必须有左右两棵子树 && 节点如果有右子树直接判false
        //如果有左子树但是右子树为空直接进入第二阶段 空节点进入第二阶段
        //第二阶段:节点必须没有子树
        //满足以上两个条件 true
        if(root==null) {
            return true;
        }
        //这个标志是判定当前处于第几阶段
        boolean isFirstStep=true;
            Queue<Node> queue=new LinkedList<>();
            queue.offer(root);
            while(!queue.isEmpty()) {
                Node cur=queue.poll();
                if(isFirstStep) {
                    //第一阶段,左右节点不能为空 并将其左右节点入队列
                    if (cur.left != null && cur.right != null) {
                        queue.offer(cur.left);
                        queue.offer(cur.right);
                    } else if (cur.left == null && cur.right != null) {
                        return false;
                    } else if (cur.left != null && cur.right == null) {
                        isFirstStep = false;
                        queue.offer(cur.left);
                    }
                    else {
                        //当前这个节点左右子树均为空
                        isFirstStep=false;
                    }
                }
                else {
                    if(cur.left!=null || cur.right!=null) {
                        return false;
                    }
            }
        } //end
            return true;
    }
    private List<List<Character>> result=new ArrayList<>();
    public List<List<Character>> levelOrder2(Node root) {
     if(root==null) {
         return result;
     }
     levelOrderHelp(root,0);
     return result;
    }
    private void levelOrderHelp(Node root,int level) {
        if(level==result.size()) {
            result.add(new ArrayList<>());
        }
        //防止下标越界
        List<Character> curLine=result.get(level);
        curLine.add(root.val);
        if(root.left!=null) {
            levelOrderHelp(root.left,level+1);
        }
       if(root.right!=null) {
           levelOrderHelp(root.right,level+1);
       }

    }


    public static void main(String[] args) {
        Node root=buildTree();
        TestDemo tree=new TestDemo();
        boolean flg= tree.isCompleteTree(root);
        System.out.println(flg);
    }
    public static void main4(String[] args) {
        Node root=buildTree();
        TestDemo tree=new TestDemo();
        tree.levelOrder(root);
    }
    public static void main3(String[] args) {
        Node root=buildTree();
        System.out.println(kLevelSize(root,3));
    }
    public static void main2(String[] args) {
        Node root=buildTree();
        System.out.println(leafSize2(root));
    }
    public static void main1(String[] args) {
        Node root=buildTree();
        leaf(root);
        System.out.println(leaf);
    }
}
