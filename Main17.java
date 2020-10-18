import java.util.*;

public class Main17 {
    public static void main8(String[] args) {
      //字符串逆置
        //将字符串以空格分开 然后倒着输出即可
        String s = "i am a student";
        String[] ret = s.split(" ");
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < ret.length; i++) {
            sb.append(ret[ret.length-1-i]+" ");
        }
        System.out.println(sb.toString());
    }

    public static void main7(String[] args) {
        //将"abcdef"当k等于2时，进行旋转，得到结果为："cdefab
        Scanner scanner = new Scanner(System.in);
        String arr = "abcdef";
        while (scanner.hasNext()) {
            int k = scanner.nextInt();
            overturn(arr,k);
        }
    }

    private static void overturn(String arr, int k) {
        //字符串的一些操作
        StringBuffer sb = new StringBuffer();
        String str1 = arr.substring(0,k);
        String str2 = arr.substring(k,arr.length());
        sb.append(str2).append(str1);
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        //找出两个只出现一次的数字
        int[] arr = {1,3,5,7,1,3,5,9};
        int[] num1 = {0};
        int[] num2 = {0};
        findTwoToOne(arr,num1,num2);
    }

    private static void findTwoToOne(int[] arr,int[] num1,int[] num2) {
       //1.将所有的数字进行异或
        int ret = 0;
        int flg = 1;
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            ret ^= arr[i];
        }
        //最终ret就是那两个不相等数字异或的结果
        //2.求这个ret的二进制 取第一个为1的位置记作标记位求这个标记位
        while ((ret & flg) == 0) {
            flg <<= 1;
        }
        //flg的值就是标记位的位置
        //3.用flg的值将数组划分 划分的结果是每组只出现一次的数字就是要找的数字
        for (int i = 0; i < arr.length; i++) {
            if ((flg & arr[i]) == 0) {
        //代码到这个位置的时候 两个不相同的数字已经被分到两个链表中 那么我们仅需要异或即可得值
        //题就变成了在数组中找只出现一次的数字了
                num1[0] ^= arr[i];
            } else {
                //用0进行异或
                num2[0] ^= arr[i];
            }
        }

        System.out.println(num1[0]+" "+num2[0]);
   }

    public static void main5(String[] args) {
        //求所有子数组的和的最大值
        int[] arr = {1,-2,3,10,-4,7,2,-5};
        int max = Integer.MIN_VALUE;  //因为有负数的存在 所以设置为MIN_VALUE而不能为0
        int tmpMax = 0;               //一直用来计算数组各位数字的和的
        for (int i = 0; i < arr.length; i++) {
            if (tmpMax <= 0) {
            //当加的数字<=0时 越向下加越小 此时应该让tmpMax指向新的>0的值 因为求得是最大值
                tmpMax = arr[i];
            } else {
                tmpMax += arr[i];
            }
            if (max < tmpMax) {
                max = tmpMax;  //max的值也应该在循环内更新
            }
        }

        System.out.println(max);
    }

    public static void main4(String[] args) {
        //找出无序数组当中，出现次数超过数组长度一半的数字
        int[] arr = {1,2,3,2,2,2,5,4,2};
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == arr[arr.length/2]) {
                System.out.println(arr[i]);
                break;
            }
        }
    }

    public static void main3(String[] args) {
        //求一个数组中前k个最小的数字
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);
        int k = scanner.nextInt();
        for (int i = 0; i < k; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    public static void main2(String[] args) {
        //key = 8 找到下标为：(0,6) 返回这两个值
        Scanner scanner = new Scanner(System.in);
        int[] arr = {1,2,3,4,5,7,7,8};
        int key = scanner.nextInt();
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length-1; j > i; j--) {
                if (arr[i] + arr[j] == key) {
                    System.out.println(i+" "+j);
                }
            }
        }
    }

    public static void main1(String[] args) {
        //求10进制数转换成2进制数中1的个数
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int count = 0;
        String ret = Integer.toBinaryString(num);
        for (int i = 0; i < ret.length(); i++) {
            char ch = ret.charAt(i);
            if (ch == '1') {
                count++;
            }
        }
        System.out.println(count);
    }
}
