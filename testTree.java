import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*

打印树的先序 中序 后序操作

 */
public class testTree {
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
     public static void preOrder(Node root) {
     if(root==null) {
         return;
     }
         System.out.print(root.val+" ");
         preOrder(root.left);
         preOrder(root.right);
        }
     public static void norOrder(Node root) {
        if(root==null) {
            return;
        }
        norOrder(root.left);
         System.out.print(root.val+" ");
         norOrder(root.right);
     }
     public static void laterOrder(Node root) {
        if(root==null) {
            return;
        }
        laterOrder(root.left);
        laterOrder(root.right);
         System.out.print(root.val+" ");
     }
      public static int size=0;
      public static void size(Node root) {
          if(root==null) {
              return;
          }
          size++;
          size(root.left);
          size(root.right);
      }
      public static int sizeTree(Node root) {
          if(root==null) {
              return 0;
          }
          //根节点的个数+左子树节点的个数+右子树节点的个数
          return 1+sizeTree(root.left)+sizeTree(root.right);
      }
      public static int leaf=0;
      public static void leaf(Node root) {
          if(root==null) {
              return;
          }
          if(root.right==null && root.right==null) {
              leaf++;
              return;
          }
          leaf(root.left);
          leaf(root.right);
      }
    public static int leafSize(Node root) {
          if(root==null) {
              return 0;
          }
         if(root.left==null && root.right==null) {
             return 1;
         }
         return leafSize(root.left)+leafSize(root.right);
    }
    public static int kLevelSize(Node root,int k) {
          //求第k层节点的个数
          if(root==null || k<1 ) {
              return 0;
          }
          if(k==1) {
              return 1;
          }
          //A的第三层=B的第二层+E的第二层
          return kLevelSize(root.left,k-1)+kLevelSize(root.right,k-1);
    }
    public static Node ret=null;
    public static void findValue(Node root,char toFind) {
          //在一个二叉树中 查找是否含有某个值
          if(root==null) {
              return;
          }
          if(root.val==toFind) {
              ret=root;
              return;
          }
          findValue(root.left,toFind);
          findValue(root.left,toFind);

    }
    public static Node find(Node root,char toFind) {
        if(root==null) {
            return null;
        }
        if(root.val==toFind) {
            return root;
        }
        Node res=find(root.left,toFind);
        if(res!=null) {
            return res;
        }
        return find(root.right,toFind);
    }
    public boolean isCompleteTree(Node root) {
        if(root==null) {
            return true;
        }
        boolean isFirst=true;
        Queue<Node> queue=new LinkedList<>();
        //先将根节点入队操作
        queue.offer(root);
        while(!queue.isEmpty()) {
         //将队列中的元素加入cur中
         Node cur=queue.poll();
         if(isFirst) {
         //第一阶段
             if(cur.left!=null && cur.right!=null) {
               queue.offer(cur.left);
               queue.offer(cur.right);
             } else if(cur.left!=null && cur.right==null) {
                 queue.offer(cur.left);
                 isFirst=false;
             } else if(cur.left==null && cur.right!=null) {
                 return false;
             } else {
                 isFirst=false;
             }
         } else {
             if(cur.left!=null || cur.right!=null) {
                 return false;
             }
         }
        } return true;
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
    //从根出发
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

        cur=top.right;
    }

    }
    public void postOrderTraversal(Node root) {
    if(root==null) {
        return;
    }
    Stack<Node> stack=new Stack<>();
    Node cur=root;
    Node pre=null;
    while(true) {
        while(cur!=null) {
           stack.push(cur);
           cur=cur.left;
        }
        if(stack.empty()) {
            break;
        }
        //取栈顶元素 判断可不可以取
        Node top=stack.peek();
        if(top.right==null || top.right==pre) {
            System.out.print(top.val+" ");
            stack.pop();
            pre=top;
        }
        else {
            cur=top.right;
        }
    }
    }

    public static void  main(String[] args) {
        Node node=buildTree();
        testTree tree=new testTree();
        tree.postOrderTraversal(node);
    }
    public static void main11(String[] args) {
        Node node=buildTree();
        testTree tree=new testTree();
        tree.inOrderTraversal(node);
    }
    public static void main10(String[] args) {
        Node node=buildTree();
        testTree tree=new testTree();
        tree.preOrderTraversal(node);
    }
    public static void main9(String[] args) {
        Node root=buildTree();
        testTree tree=new testTree();
        boolean flg= tree.isCompleteTree(root);
        System.out.println(flg);
    }
    public static void main8(String[] args) {
        //找给定元素的第二种方法
        Node root=buildTree();
        Node ret=find(root,'G');
        System.out.println(ret);
    }
    public static void main7(String[] args) {
        //找给定元素的第一种方法
        Node root=buildTree();
        findValue(root,'H');
        System.out.println(ret);
    }
    public static void main6(String[] args) {
        Node root=buildTree();
        System.out.println(kLevelSize(root,2));
    }
    public static void main5(String[] args) {
        //求树的叶子节点的第二种方法
        Node root=buildTree();
        System.out.println(leafSize(root));
    }
    public static void main4(String[] args) {
        //求树的叶子节点的第一种方法
        Node root=buildTree();
        leaf(root);
        System.out.println(leaf);
    }

    public static void main3(String[] args) {
        //求树的节点的第二种方法
        Node root=buildTree();
        System.out.println(sizeTree(root));
    }
      public static void main2(String[] args) {
          //求数的节点个数第一种方法
        Node root=buildTree();
        size(root);
          System.out.println(size);
    }
    public static void main1(String[] args) {
        Node root=buildTree();
        preOrder(root);
        System.out.println();
        norOrder(root);
        System.out.println();
        laterOrder(root);
    }
}
