import java.util.Arrays;
import java.util.Scanner;

public class Main16 {
    public static void main3(String[] args) {
        //调整奇数的位置 使得奇数在偶数之前
        //这个题和之前的冒泡排序代码很像
        int[] arr = {1,2,3,4,5,6,7,8,9};
        int[]ret = adjust(arr);
        System.out.println(Arrays.toString(ret));
    }
    private static int[] adjust2(int[] arr) {
        int left = 0;
        int right = arr.length-1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = right; j > i; j--) {
                if (arr[i] % 2 != 0) {
                    i++;
                } else if (arr[j] % 2 == 0) {
                    j--;
                } if (i < j) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        return arr;
    }
    private static int[] adjust(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            //比如[1,6,4,9]
            //arr[0] = 1 left指向6
            //6%2=0 6和9交换
            if (left < right && arr[left] % 2 != 0) {
                left++;
            }
            //arr[3] = 9 right不变
            else if (left < right && arr[right] % 2 == 0) {
                right--;
            }
            if (left < right) {
                int tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
            }
        }
        return arr;
    }

    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [][] arr = {{1,2,8,9},
                       {2,4,9,12},
                       {4,7,10,13},
                       {6,8,11,15} };
        int amid = scanner.nextInt();
        System.out.println(isFind(arr, amid));
    }

    private static boolean isFind(int[][] arr,int a) {
        int row = arr.length;    //4(4列) 注意!这个不知道
        int col = arr[0].length; //4
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (arr[i][j] == a) {
                    return true;
                }
            }
        }
        return false;
    }

    /*
    只出现了一次的数字(两个)
     */
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = scanner.nextInt();
            }
            int flag = 0;
            for (int x : arr) {
                flag = (flag ^ x);
            }
            flag = ((~flag + 1) & flag);
            int[] ret = new int[2];
            for (int y : arr) {
                if ((flag & y) == flag) {
                    ret[0] = ret[0] ^ y;
                } else {
                    ret[1] = ret[1] ^ y;
                }
            }
            //排好序进行输出
            if (ret[0] < ret[1]) {
                System.out.printf("%d %d%n",ret[0],ret[1]);
            } else {
                System.out.printf("%d %d%n",ret[1],ret[0]);
            }
        }
    }
}
