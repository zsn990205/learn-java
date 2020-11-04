package _TestClassCode;

import java.util.Arrays;

public class TestMain9 {
    public static void main4(String[] args) {
        //一个数组中只有一个数字出现了一次 其他均为两次找出他
        int[] arr = {1,2,2,4,1,5,6,6,7,4,5};
        int ret = 0;
        for (int i = 0; i < arr.length; i++) {
            ret ^= arr[i];
        }
        System.out.println(ret);
    }

    public static void main3(String[] args) {
        int[][] arr = new int[2][];
        arr[0] = new int[]{1,2,3};
        arr[1] = new int[2];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main2(String[] args) {
        int[][] arr = {{1,2,3},{4,5,6}};
        System.out.println(Arrays.deepToString(arr));
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr[i].length; j++) {
//                System.out.print(arr[i][j]+" ");
//            }
//            System.out.println();
//        }
//        for (int[] tmp : arr) {
//            for (int ret : tmp) {
//                System.out.print(ret+" ");
//            }
//            System.out.println();
//        }
    }

    public static void main1(String[] args) {
    //将数组偶数放在前面部分 奇数放在后面
        int[] arr = {1,56,2,45,12,36,98,7};
        swapJO(arr);
    }

    private static void swapJO2(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length-1; j >= 0; j--) {
                while (arr[i] % 2 == 0 && i < j) {
                    i++;
                }
                while (arr[j] % 2 != 0 && i < j) {
                    j--;
                }
                if (i < j) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void swapJO(int[] arr) {
        int left = 0;
        int right = arr.length-1;
        while (left < right) {
            while (left < right && arr[left] % 2 == 0) {
                //偶数情况 遇到偶数一直向后移动 遇到奇数停止因为奇数放在后面
                //当不满足条件的时候跳出循环
                left++;
            }
            while (left < right && arr[right] % 2 != 0) {
                //后面遇到偶数停下 因为偶数需要放在前面
                right--;
            }
            //left遇到奇数了
            if (left < right) {
                int tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
