


public class myHashMap {
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
    //负载因子=size/arr.length
    public int hashFun(int key) {
        return key % arr.length;
    }
    public void put(int key,int val) {
    //插入键值对
    //根据key代入Hash函数计算下标
    int index = hashFun(key);
    //每个节点相当于链表的头节点
    Node head = arr[index];
    for (Node cur = head; cur != null; cur = cur.next) {
    //key如果存在就不插入新节点 修改val的值就行了
       if (cur.key == key) {
           cur.val = val;
           return;
       }
    }
    //不存在就插入(头插法)
        Node newNode = new Node(key,val);
        newNode.next = head;
    //arr[index]=head
        arr[index] = newNode;
        size++;
    }

    public Integer get(int key) {
    //搜索元素
    //1.根据hash函数得到key
    int index = hashFun(key);
    Node head = arr[index];
    for (Node cur = head; cur != null; cur = cur.next) {
        if (cur.key == key) {
            return cur.val;
        }
    }
    return null;
    }
}
