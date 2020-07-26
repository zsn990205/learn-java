import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TestSet {
    public static void main(String[] args) {
        Set<String> set=new HashSet<>();
        //1.插入元素(不能重复插入元素)
        set.add("高数");
        set.add("线代");
        set.add("概论");
        set.add("大物");

        //2.判断某个元素是否在set中存在
        System.out.println(set.contains("模电"));

        //3.删除元素
        System.out.println(set.contains("大物"));
        set.remove("大物");
        System.out.println(set.contains("大物"));

        //4.打印所有元素(多个数据只输出一个) 元素顺序是乱的
        //法一:
        System.out.println(set);
        //法二:迭代器的简化版本
        for (String s:set) {
            System.out.println(s);
        }

        System.out.println();
        //5.遍历迭代器来遍历 iterator接口中得有一个iterator方法 这个方法返回了一个iterator对象
        Iterator<String> iterator=set.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
