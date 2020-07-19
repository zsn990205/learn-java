
public class BinarrySearchTree {
    static class Node {
    //<key val>是键值对
        public int key;
        public int val;
        public Node left;
        public Node right;

        public Node(int key,int val) {
            this.key = key;
            this.val=val;
        }
    }
    private Node root=null;

    public Node find(int key) {
        Node cur = root;
        while (cur != null) {
            if (cur.key < key) {
                cur = cur.right;
            } else if (cur.key > key) {
                cur = cur.left;
            } else {
                return cur;
            }
        }
        return null;
    }

    public Node insert(int key,int val) {
    //1.是空树
    if (root == null) {
        root = new Node(key,val);
        return root;
    }
    Node pre = null;
    Node cur = root;
    //2.不是空树
    while (cur != null) {
        if (cur.key < key) {
            pre = cur;
            cur = cur.right;
        } else if (cur.key > key) {
            pre = cur;
            cur = cur.left;
        } else {
    //cur.key=key 此时有两种方法:1.操作直接失败
     //2.不创建新节点 把刚才的val改成现在的
          cur.key = key;
          return cur;
        }
    }
    //此时cur==null 可以开始插入了
    Node newNode = new Node(key,val);
    if (pre.key > newNode.key) {
        pre.left = newNode;
    } else {
        pre.right = newNode;
    }
      return newNode;
    }

    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.key+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.key+" ");
        inOrder(root.right);
    }

    public void remove(int key) {
    //先找到要删除的节点的位置 并记录他的父节点的位置
    Node cur = root;
    Node parent = null;
    while (cur != null) {
        if (cur.key > key) {
            parent = cur;
            cur = cur.left;
        } else if (cur.key < key) {
            parent = cur;
            cur = cur.right;
        } else {
        //找到了要找的节点
            removeNode(cur,parent);
            return;
        }
    }
    //cur==null 没找到 删除失败
          return;
    }

    private void removeNode(Node cur, Node parent) {
    //一.cur.left=null
     if (cur.left == null) {
         if (cur == root) {
             root = cur.right;
         } else if(cur == parent.right) {
             parent.right = cur.right;
         } else if(cur == parent.left) {
             parent.left = cur.right;
         }
        }
     //二.cur.right=null
        else if(cur.right == null) {
         if (cur == root) {
             root = cur.left;
         } else if (cur == parent.left) {
             parent.left = cur.left;
         } else if (cur == parent.right) {
             parent.right = cur.left;
         }
     }
        else {
     //三.cur.right!=null && cur.left!=null
        Node scapeGoat = cur.right;
        Node scapeGoatParent = cur;
        while (scapeGoat != null) {
            scapeGoatParent = scapeGoat;
            scapeGoat = scapeGoat.left;
        }
     //scapeGoat找到了
        cur.key = scapeGoat.key;
        cur.val = scapeGoat.val;
     //如果替罪羊节点是父亲节点的left
         if (scapeGoatParent.left == scapeGoat) {
             scapeGoatParent.left = scapeGoat.right;
         }  else {
             //如果替罪羊节点是父亲节点的right
             scapeGoatParent.right = scapeGoat.right;
         }
         }
    }

    public static void main(String[] args) {
        BinarrySearchTree tree = new BinarrySearchTree();
        tree.insert(9,90);
        tree.insert(5,50);
        tree.insert(2,20);
        tree.insert(7,70);
        tree.insert(3,30);
        tree.insert(6,60);
        tree.insert(8,80);

        BinarrySearchTree.preOrder(tree.root);
        System.out.println();
        BinarrySearchTree.inOrder(tree.root);
    }
}
