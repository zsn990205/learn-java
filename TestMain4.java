package _TestClassCode;

import java.util.Arrays;
import java.util.Scanner;

public class TestMain4 {
    public static void main5(String[] args) {
        int[] arr = {1,5,6,3,8,9,56,54,26,31,54};
        bubbleSort(arr);
    }

    private static void bubbleSort(int[] arr) {
        //i控制数组循环的趟数
        for (int i = 0; i < arr.length-1; i++) {
        //j控制循环的上下数字比较
          for (int j = 0; j < arr.length - i -1 ; j++) {
              if (arr[j] > arr[j+1]) {
                  int tmp = arr[j];
                  arr[j] = arr[j+1];
                  arr[j+1] = tmp;
              }
          }
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void bubbleSort2(int[] arr) {
        boolean flag = false;   //没有发生交换
        for (int i = 0; i < arr.length-1; i++) {
            flag = false;  //每次交换之后需要将flag置为false

            for (int j = 0; j < arr.length - i -1 ; j++) {
                if (arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                    flag = true;  //交换 flag置为true
                }
            }

            if (flag == false) {
            //假如一轮循环下来没有发生任何交换
            //说明数组本来就是顺序的不需要进行继续遍历直接跳出循环
                break;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void main4(String[] args) {
        int[] arr = {15,25,68,9,7,65,4,2,98,6,3,20,11,45};
//        Arrays.sort(arr);
//        System.out.println(Arrays.toString(arr));
        //fromIndex--toIndex是左闭右开区间
        //System.out.println(Arrays.binarySearch(arr,2,5,6));
//        Arrays.fill(arr,5);
//        System.out.println(Arrays.toString(arr));
        //System.out.println(isUp(arr));
        int[] ret = Arrays.copyOf(arr,arr.length);
        System.out.println(Arrays.toString(ret));
        System.out.println(Arrays.equals(arr,ret));
    }

    private static boolean isUp(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
                if (arr[i] > arr[i + 1]) {
        //对于这种情况来说 只要一个不满足升序则整个数组不是升序的
        //所以我们找i>i+1的情况 当一个满足即不为升序数组
                    return false;
                }
        }
        return true;
    }

    public static void main3(String[] args) {
        double sum = 0;
        int flag = 1;
      for (int i = 1; i <= 1000; i += 2) {
          sum += 1.0 / i * flag;
          flag = -flag;
      }
        System.out.println(sum);
    }
    public static String MonthToSea(int n) {
        String ret = "";
        switch(n) {
            case 2:
            case 3:
            case 4:
                ret = "春季";
                break;
            case 5:
            case 6:
            case 7:
                ret = "夏季";
                break;
            case 8:
            case 9:
            case 10:
                ret = "秋季";
                break;
            default:
                ret = "冬季";
        }
        return ret;
    }
    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(MonthToSea(m));
    }

    public static void main1(String[] args) {
        for (int i = 0; i <= 100; i++) {
            System.out.print(i/10+" ");
        }
    }
}
