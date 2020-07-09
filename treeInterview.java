import javax.swing.tree.TreeNode;
import java.util.Stack;

public class treeInterview {
    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    private TreeNode lca=null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //查找最近公共祖先
        //思想:p和q不同时出现在一棵树的左子树或右子树 它只出现在三种情况(左 右 根)的两种情况
      if(root==null) {
          return null;
      }
      findNode(root,p,q);
      return lca;
    }
    //查找是否可以找到P,Q
    private boolean findNode(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) {
            return false;
        }
        //如果能找到p或者q就返回1 p.q都能找到也返回1
        //p,q比较的是身份 只要在Left中出现在right就不会出现
        int left=findNode(root.left,p,q)? 1 : 0; //两种情况   找到vs找不到
        int right=findNode(root.right,p,q)? 1 : 0;
        int mid=(root==p || root==q)?1 : 0;
        if(left+right+mid==2) {
            lca=root;
        }
        //找到p或者q就返回true
        return (left+right+mid)>0;
    }
    public TreeNode Convert(TreeNode root) {
        //二叉搜索树
        //二叉搜索树的中序遍历可以使链表从小到大排列
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return root;
        }
        //开始中序
        //递归处理左子树 将左子树转换成双向链表
        //left一直都是链表的头节点
        TreeNode left = Convert(root.left);
        //尾节点从left开始 如果左边就一个节点的化 他就是尾
        TreeNode leftTail = left;
        //在这里 left表示双向链表的前一个节点
        //right表示next
        while (leftTail != null && leftTail.right != null) {
            leftTail = leftTail.right;
        }
        if (leftTail != null) {
            leftTail.right = root;
            root.left = leftTail;
        }
        //递归处理根节点 在左链表不为空的时候将其连接起来
        if(left!=null) {
            root.left=leftTail;
        }
        //递归处理右子树
        TreeNode right=Convert(root.right);
        if(right!=null) {
            root.right=right;
            right.left=root;
        }
        //如果left不是空就返回left 是空就return root
        return left!=null?left:root;
    }


    //为了搞清楚当前元素走到那个位置了用index记录 先序数组的下标
    private int index=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    //给定一个先序遍历的数组和中序遍历的数组
    //将这课树构建出来
    index=0; //每次从0位置开始
    return buildTreeHelp(preorder,inorder,0,inorder.length);
    }
    //inorderLeft, inorderRight表示中序区间
    private TreeNode buildTreeHelp(int[] preorder, int[] inorder,
                                   int inorderLeft, int inorderRight) {
    if(inorderLeft>=inorderRight)  {
        //空树
        return null;
    }
    if(index>preorder.length) {
        return null;
    }
    //制造根节点 index=0就是从先序的0位置找到根节点
    TreeNode newNode=new TreeNode(preorder[index]);
    //在中序中找到范围
    //左子树[inorderLeft,pos) 前闭后开区间 在这里Pos位置就是左子树的inorderRight
    //右子树[pos+1,inorderRight) 在这里pos+1就是右子树的inorderLeft
    int pos=find(inorder,inorderLeft,inorderRight,newNode.val);
    index++;//没有空节点 所以index++1次
    newNode.left=buildTreeHelp(preorder,inorder,inorderLeft,pos);
    newNode.right=buildTreeHelp(preorder,inorder,pos+1,inorderRight);
    return newNode;
    }

    private int find(int[] inorder, int inorderLeft, int inorderRight, int val) {
    for(int i=inorderLeft;i<inorderRight;i++) {
        if(inorder[i]==val) {
            return i;
        }
    }
    return -1;
    }
    private StringBuilder sb=new StringBuilder();
    public String tree2str(TreeNode t) {
    //根据二叉树创建字符串
     if(t==null) {
         return "";
     }
     helper(t);
     sb.deleteCharAt(0);
     sb.deleteCharAt(sb.length()-1);

     return sb.toString();
    }
    private void helper(TreeNode root) {
        //根据先序遍历
     if(root==null) {
         return;
     }
     sb.append("(");
     sb.append(root.val);
     helper(root.left);
     if(root.left==null && root.left!=null) {
         sb.append("()");
     }
     helper(root.right);
     sb.append(")");
    }

    public void preOrderTraversal(TreeNode root) {
        //非递归 先序
        if(root==null) {
            return;
        }
        Stack<TreeNode> stack=new Stack<>();
        //1.进栈
        stack.push(root);
        while(!stack.empty()) {
        //2.出栈并访问栈顶元素
                TreeNode cur=stack.pop();
                System.out.print(cur.val+" ");
        //3.与层序不同 右-->左
                if(cur.right!=null) {
                    stack.push(cur.right);
                }
                if(cur.left!=null) {
                    stack.push(cur.left);
                }
            }
        }

    public void inOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        //第一步:cur一直往左移 直到cur为空
        while (true) {
            while (cur != null) {
                //只要cur非空 就将其入栈
                stack.push(cur);
                cur = cur.left;
            }
           //栈为空的话 直接Break
            if (stack.empty()) {
                break;
            }
            TreeNode top = stack.pop();
            System.out.print(top.val + " ");
            //往右边找 重复上述步骤
            cur = top.right;
        }
    }
    public void postOrderTraversal(TreeNode root) {
    if(root==null) {
        return;
    }
    Stack<TreeNode> stack=new Stack<>();
    TreeNode cur=root;
    TreeNode prev=null;
    while(true) {
        while(cur!=null) {
            stack.push(cur);
            cur=cur.left;
        }
        if(stack.empty()) {
            break;
        }
        //只是取栈顶元素判断以下看有没有右子树 并不需要出栈
        TreeNode top=stack.peek();
        if(top.right==prev || top.right==null) {
            System.out.print(top.val+" ");
            stack.pop();
            prev=top;
        } else {
            cur=top.right;
        }
    }
    }
    private static TreeNode build() {
        // 通过 build 方法构建一棵树, 返回树的根节点.
        TreeNode A = new TreeNode(1);
        TreeNode B = new TreeNode(2);
        TreeNode C = new TreeNode(3);
        TreeNode D = new TreeNode(4);
        TreeNode E = new TreeNode(5);
        TreeNode F = new TreeNode(6);
        TreeNode G = new TreeNode(7);
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        E.left = G;
        C.right = F;
        return A;
    }

    public static void main(String[] args) {
        //构建一棵树
        TreeNode root=build();
        //构造一个类
        treeInterview treeInterview= new treeInterview();
        treeInterview.postOrderTraversal(root);
    }
    public static void main2(String[] args) {
        //构建一棵树
        TreeNode root=build();
        //构造一个类
        treeInterview treeInterview= new treeInterview();
        treeInterview.inOrderTraversal(root);
    }
    public static void main1(String[] args) {
    //构建一棵树
    TreeNode root=build();
    //构造一个类
    treeInterview treeInterview= new treeInterview();
    treeInterview.preOrderTraversal(root);
    }
}
