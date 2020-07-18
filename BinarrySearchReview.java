
public class BinarrySearchReview {
    static class Node {
        public int key;
        public int val;
        public Node left;
        public Node right;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private Node root = null;

    public Node find(int key) {
        Node cur = root;
        while (cur != null) {
            if (cur.key < key) {
                cur = cur.right;
            } else if (cur.key > key) {
                cur = cur.right;
            } else {
                return cur;
            }
        }
        return null;
    }

    public Node insert(int key, int val) {
        if (root == null) {
            root = new Node(key, val);
            return root;
        }
        Node pre = null;
        Node cur = root;
        while (cur != null) {
            if (key > cur.key) {
                pre = cur;
                cur = cur.right;
            } else if (key < cur.key) {
                pre = cur;
                cur = cur.left;
            } else {
                cur.val = val;
                return cur;
            }
        }
        //cur == null
        Node newNode = new Node(key, val);
        if (pre.key < newNode.key) {
            pre.right = newNode;
        } else {
            pre.left = newNode;
        }
        return newNode;
    }

    public void remove(int key) {
     //先找到cur的位置
        Node pre = null;
        Node cur =root;
        while (cur != null) {
            if (key > cur.key) {
                pre = cur;
                cur = cur.right;
            } else if(key < cur.key) {
                pre = cur;
                cur = cur.left;
            } else {
                removeNode(cur,pre);
                return;
            }
        }
        return;
    }

    private void removeNode(Node cur, Node pre) {
        if (cur.left == null) {
            if (cur == root) {
                root = cur.right;
            } else if (pre.right == cur) {
                pre.right = cur.right;
            } else if (cur == pre.left) {
                pre.left = cur.right;
            }
        } else if (cur.right == null) {
            if (cur == root) {
                root = cur.left;
            } else if (cur == pre.left) {
                pre.left = cur.left;
            } else if (cur == pre.right) {
                pre.right = cur.left;
            }
        }
        Node scapeGoatParent = cur;
        Node scapeGoat = cur.right;
        while (scapeGoat != null) {
            scapeGoatParent = scapeGoat;
            scapeGoat = scapeGoat.left;
        }
        scapeGoat.val = cur.val;
        scapeGoat.key = cur.key;
        if (scapeGoatParent.left == scapeGoat) {
            scapeGoatParent.left = scapeGoat.right;
        } else {
            scapeGoatParent.right = scapeGoat.right;
        }
    }
}
