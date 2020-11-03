package _TestClassCode;

import java.util.*;

public class TestMain8 {
    public static void main(String[] args) {
        //数组的逆序
        int[] arr = {1,5,4,6,1000,5,89};
        System.out.println("逆序前"+" "+Arrays.toString(arr));
        System.out.println("==========逆序后==========");
        reverse(arr);
    }

    private static void reverse(int[] arr) {
        int[] ret = new int[arr.length];
        for (int i = arr.length-1; i >= 0; i--) {
                 ret[arr.length-i-1] = arr[i];
        }
        System.out.println(Arrays.toString(ret));
    }

    private static void reverse2(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left ++;
            right --;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main3(String[] args) {
        int first = 1;
        int second = 5;
        int last = 10;
        System.out.println(howMoneyIGet(first, second, last));
    }

    private static int howMoneyIGet(int first, int second, int last) {
        Set<Double> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i <= 5; i++) {
            for (int j = 0; j <= 4; j++) {
                for (int k = 0; k <= 8; k++) {
                    if (i + k + j > 0) {
                        set.add((double)i * first + j * second + k * last);
                    }
                }
            }
        }
        count = set.size();
        return count;
    }

    public static void main2(String[] args) {
        System.out.println("请输入学生成绩的个数");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] ret = distinctGrade2(n);
            System.out.println(Arrays.toString(ret));
        }
    }

    private static int[] distinctGrade2(int n) {
        int[] arr = new int[5];
        int count = 0;
        Random random = new Random();
        int[] grade = new int[n];
        for (int i = 0; i < grade.length; i++) {
            grade[i] = random.nextInt(100);
        }
        System.out.print(Arrays.toString(grade));
        System.out.println();
        for (int j = 0; j < n; j++) {
            if (grade[j] < 60) {
                arr[0]++;

            }
            else if (grade[j] >= 60 && grade[j] < 70) {
                arr[1]++;
            }
            else if (grade[j] >= 70 && grade[j] < 80) {
                arr[2]++;
            }
            else if (grade[j] >= 80 && grade[j] < 90) {
                arr[3]++;
            }
            else {
                arr[4]++;
            }
        }
        return arr;
    }

    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            System.out.println(getDynamaicCode2(n));
        }
    }

    private static String getDynamaicCode2(int n) {
        Random random = new Random();
        //因为产生的是数字和字母 所以不能单纯的只使用传统方法求解 先产生一串字符
        String code = "0123456789abcdefghijklmnopqrstuvwxyz" +
                      "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] ch = new char[n];
        for (int i = 0; i < n; i++) {
            //pos即为产生的随机数的下标
            int pos = random.nextInt(code.length());
            //数组中保存的每一位 是从字符串特定下标取到的字符
            ch[i] = code.charAt(pos);
        }
        String str = new String(ch);
        return str;
    }
}
