import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*

那个面试题

 */
public class practiceTest {
    static class pair {
        public int num1;
        public int num2;
        public int sum;

        public pair(int num1, int num2) {
            this.num1 = num1;
            this.num2 = num2;
            this.sum = num1+num2;
        }
    }
    //给定两个以升序排列的数组numS1 numS2以及k 定义一组数据(u,v) u来自numS1 v来自numS2
    //排列组合 找到和最小的k对数字
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ret=new ArrayList<>();
        if(k<=0) {
            return ret;
        }
        PriorityQueue<pair> queue=new PriorityQueue<>((pair o1,pair o2)->o1.sum-o2.sum);
        for(int i=0;i<nums1.length;i++) {
            for(int j=0;j<nums2.length;j++) {
                queue.offer(new pair(nums1[i],nums2[j]));
            }
        } for(int i=0;i<k && !queue.isEmpty();i++) {
            pair cur=queue.poll();
            List<Integer> tmp=new ArrayList<>();
            tmp.add(cur.num1);
            tmp.add(cur.num2);
            ret.add(tmp);
        }
        return ret;
    }
}
