

public class Hash {
    static class Node {
      public int val;
      public int key;
      Node next;

        public Node(int val, int key) {
            this.val = val;
            this.key = key;
        }
    }
    private Node[] arr = new Node[101];
    private int size = 0;

    public int hashFun(int key) {
        return key % arr.length;
    }
    public void put(int key,int val) {
       int index = hashFun(key);
       Node head = arr[index];
       for (Node cur = head; cur != null; cur = cur.next) {
           if (cur.key == key) {
               cur.val = val;
               return;
           }
           Node newNode = new Node(key,val);
           newNode.next = head;
           arr[index] = newNode;
           size++;
       }
    }

    public Integer get(int key) {
        int index = hashFun(key);
        Node head= arr[index];
        for (Node cur = head; cur != null; cur = cur.next) {
            if (cur.key == key) {
                return cur.val;
            }
        }
        return null;
    }
}
