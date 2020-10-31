package _TestClassCode;

import java.util.Arrays;

public class TestMain5 {
    public static void main(String[] args) {
      int[] arr = new int[10000];
      for (int i = 0; i < arr.length; i++) {
          arr[i] = i;
      }
      int ret = binarySearch(arr, 9999);
      System.out.println("数组下标为: "+ret+" "+"找到数字次数为: "+count);
      int ret2 = toFindNum(arr,9999);
      System.out.println("数组下标为: "+ret2+" "+"找到数字次数为: "+count);
      System.out.println(Arrays.binarySearch(arr,9999));  //库函数中的方法
    }

    public static int toFindNum(int[] arr,int key) {
        for (int i = 0; i < arr.length; i++) {
            count++;
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static int count = 0;
    private static int binarySearch(int[] arr, int k) {
        int left = 0;
        int right = arr.length-1;
        while (left <= right) {
            count++;
            //int mid = (right + left) / 2;
            //无符号右移也相当于/2 (更快)
            int mid = (right + left) >>> 2;
            if (arr[mid] < k) {
                left = mid + 1;
            } else if (arr[mid] > k){
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main7(String[] args) {
        //数组的第四种copy形式
        int[] arr = {1,2,3,4,5,6,7};
        System.out.println(Arrays.toString(arr));
        System.out.println("=======copy后========");
        int[] ret = arr.clone();
        System.out.println(Arrays.toString(ret));
    }

    public static void main6(String[] args) {
        //数组的第三种copy形式
        int[] arr = {1,2,3,4,5,6,7};
        System.out.println(Arrays.toString(arr));
        System.out.println("=======copy后========");
        int[] ret = new int[arr.length];
        System.arraycopy(arr,0,ret,0,arr.length);
        System.out.println(Arrays.toString(ret));
    }

    public static void main5(String[] args) {
        //数组的第二种copy形式
        int[] arr = {1,2,3,4,5,6,7};
        System.out.println(Arrays.toString(arr));
        System.out.println("=======copy后========");
        int[] ret = Arrays.copyOf(arr,arr.length);
        System.out.println(Arrays.toString(ret));
    }

    public static void main4(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        System.out.println(Arrays.toString(arr));
        System.out.println("=======copy后========");
        copyArray(arr);
    }

    private static void copyArray(int[] arr) {
        int[] ret = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ret[i] = arr[i];
        }
        System.out.println(Arrays.toString(ret));
    }

    public static void main3(String[] args) {
        int i = 2;
        int j = ++i * 3;
        System.out.println(j);
    }
    public static void main2(String[] args) {
//        System.out.println(Integer.MAX_VALUE);
//        final int MAX = 100;
//        System.out.println(MAX);
        String str1 = 10+"";
        String str2 = String.valueOf(10);
        System.out.println(str1+" "+str2);
        int a = Integer.parseInt("10");
    }

    public static void main1(String[] args) {
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }
        System.out.println("hahaha");
    }
}
