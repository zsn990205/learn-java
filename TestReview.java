import java.util.*;

/*

面试代码复习
 */
public class TestReview {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums) {
            Integer count = map.get(x);
            if (count == null) {
                map.put(x, 1);
            } else {
                map.put(x, count + 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue().equals(1)) {
                System.out.println(entry.getKey());
            }
        }
        return 1;
    }

    public int[] singleNumber2(int[] nums) {
        //找出现一次的两个数字
        //思路:整个数组进行异或 最后得到两个只出现一次数字的异或
        //将上述异或的结果随便找一个不为0的数字进行划分 分为不是1和是1的两个部分
        //将上一步两个数组进行异或最后就会分别得到两个只出现一次的数字
        int ret = 0;
        for (int x : nums) {
            ret ^= x;
        }
        int bit = 0;
        for (; bit < 32; bit++) {
            if ((ret & (1 << bit)) > 0) {
                break;
            }
        }
        int a = 0;
        int b = 0;
        for (int x : nums) {
            if ((x & (1 << bit)) > 0) {
                a ^= x;
            } else {
                b ^= x;
            }
        }
        return new int[]{a, b};
    }

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String x : words) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        List<String> ret = new ArrayList<>(map.keySet());
        Collections.sort(ret, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int count1 = map.get(o1);
                int count2 = map.get(o2);
                if (count1 == count2) {
                    return o1.compareTo(o2);
                }
                return count2 - count1;
            }
        });
        return ret.subList(0, k);
    }
}
