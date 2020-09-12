import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main10 {
    public static void main10(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            char[] A = scanner.next().toCharArray();
            char[] B = scanner.next().toCharArray();
            if (isSameType(A,B)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

    private static boolean isSameType(char[] a, char[] b) {
        //必须得保证B中的字母A中都有
        //并且B中每个相同字母的个数<A中的
        int count = 0;
        int flg = b.length;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
        //解释:让指针指向a[0] 让a[0]和b[]中的所有数字比较 如果有count++
        //     接着让相同的哪个字母为0(避免下次比较的时候在把这个字母算一次)
        //     比如ABCDEFG  CDECDE
        //     如果不让前面比较过的数字为0 那么再次循环的时候会有2个D
        //     count=b.length判断就有误了
        //     如果没有  a[0]中的数字在也不参与比较
                if (b[j] == a[i]) {
                    count++;
        //这个标志位没有别的意思 可以设置成任意非字母的东西
        //作用就是为了和字母区分
                    b[j] = 3;
                    break;
                }
            }
        }
        if (count == flg) {
            return true;
        } else {
            return false;
        }
    }

    public static void main9(String[] args) {
        //C++程序猿转java
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String C = scanner.nextLine();
            //C转java的规则 :
            // 去除下划线 将第二个单词后的首字母均变成大写
            char[] arr = C.toCharArray();
            int i = 0;
            StringBuilder sb = new StringBuilder();
            while (i < arr.length) {
                if (arr[i] != '_') {
                    sb.append(arr[i]);
                    i++;
                } else {
                    //遇到下划线 先往后走
                    i++;
                    //遇到下划线之后 下划线后的第一个字母得转成大写
                    sb.append((arr[i] + "").toUpperCase());
                    i++;
                }
            }
            System.out.println(sb.toString());
        }
    }

    public static void main8(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String prime = scanner.nextLine();
            //[^a-zA-Z]是去匹配目标字符串中非a—z也非A—Z的字符
            //因为题目要求 除26字母其他均当成空字符串
            //^[a-zA-Z]是去匹配目标字符串中以中括号中的a—z或者A—Z开头的字符
            String[] arr = prime.split("[^a-zA-Z]+");
            StringBuilder sb = new StringBuilder();
            for (int i = arr.length-1; i >= 0; i--) {
                sb.append(arr[i]+" ");
            }
            System.out.println(sb.toString().trim());
        }
    }

    public static void main7(String[] args) {
        String symbol = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        String number = "222333444555666777788899991234567890";
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            ArrayList<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String str = scanner.next();
                str = str.replace("-", "");
                String ret = "";
                for (int j = 0; j < 7; j++) {
                    //先找到输入的字符串每一位(从1开始) 因为美国电话号码是7位
                    //然后在对应的symbol位置找到下标
                    //symbol的下标和number(转换的位置的下标是对应的)
                    //找到symbol的下标也就是找到了对应的转换成的电话号码
                    //ret是拼装的结果(电话号码是一个一个找到的)
                    ret += number.charAt(symbol.indexOf(str.charAt(j) + ""));
                }
                //电话号码要使用-分隔
                ret = ret.substring(0,3)+"-"+ret.substring(3,7);
                    if (!list.contains(ret)) {
                        list.add(ret);
                    }
                }
                //将找到的所有的ret进行排序 输出的结果是字典序输出的
                Collections.sort(list);
                for (int i = 0; i < list.size(); i++) {
                    System.out.println(list.get(i));
                }
            System.out.println();
            }
    }


    public static void main6(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = i+1;

            }

            for (int i = 0; i < n; i++) {
                for (int j = i; j < n; j++) {
                    if (arr[i] + arr[j] == m ) {
                        System.out.println(arr[i]+" "+arr[j]);
                    }
                }
                if (arr[i] == m) {
                    System.out.println(arr[i]);
                }
            }
        }
    }


    public static void main5(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String noPassword = scanner.nextLine();
            String password = scanner.nextLine();
            //加密的规则是: 将大写转成小写并将字母换成下一个
            //解密的规则是: 将小写换成大写并将字母换成前一个
            jiaMi(noPassword);
            jieMi(password);
        }
    }

    private static void jieMi(String noPassword) {
       String str1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
       String str2 = "bcdefghijklmnopqrstuvwxyzaBCDEFGHIJKLMNOPQRSTUVWXYZA1234567890";
       StringBuffer sb = new StringBuffer();
       for (char c : noPassword.toCharArray()) {
           if (str2.indexOf(c) >= 0) {
               //indexOf 查找这个字符出现的位置
               //因为是加密 要将小写转换成大写
               //所以也就是在str2中找到字符下标 然后再去str1找对应位置字符
               sb.append(str1.charAt(str2.indexOf(c)));
                   continue;
               }
               sb.append(c);
           }
        System.out.println(sb);
       }


    private static void jiaMi(String Password) {
        String str1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        String str2 = "bcdefghijklmnopqrstuvwxyzaBCDEFGHIJKLMNOPQRSTUVWXYZA1234567890";
        StringBuffer sb = new StringBuffer();
        for (char c : Password.toCharArray()) {
            if (str2.indexOf(c) >= 0) {
                sb.append(str2.charAt(str1.indexOf(c)));
                continue;
            }
            sb.append(c);
        }
        System.out.println(sb);
    }

    public static void main4(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
           int year = scanner.nextInt();
           int month = scanner.nextInt();
           int day = scanner.nextInt();
           System.out.println(countDay(year,month,day));
        }
    }

    private static int countDay(int year, int month, int day) {
        int[] dayCount = {31,28,31,30,31,30,31,31,30,31,30,31};
        if (year <= 0 && month <= 0 && month > 12 && day <= 0 && day > dayCount[month-1]) {
            //month-1的由来:因为数组下标是从0开始的
            //所以如果是1月的话 那么就应该是数组的0号下标
            return -1;
        }
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            //闰年的情况下2月是29天
            dayCount[1] = 29;
        }
        int sum = 0;
        for (int i = 0; i < month-1; i++) {
         //这里必须是月份 因为你是根据年月日计算时间的
         //这里必须是month-1 因为算的时候算到上个月末+这个月的day即可
            sum += dayCount[i];
        }
        return sum+day;
    }

    public static void main3(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int max = Integer.MIN_VALUE;
            int tmp = 0;
            for (int i = 0; i < n; i++) {
                tmp += scanner.nextInt();
                if (tmp > max) {
                    max = tmp;
                }
                //清零重新开始 因为此时数据比较小
                if (tmp <= 0) {
                    tmp = 0;
                }
            }
            System.out.println(max);
        }
    }
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            Find(arr,n);
        }
    }

    private static void Find(int[] arr, int count) {
        int[] ret= new int[2];
        for(int i = 0;i < count;i++){
            if(i == 0){
                ret[0] = -1;
            }
            if(i == count - 1){
                ret[1] = -1;
            }
            int j = i;
            while(j >= 0 && j <= count - 1){
                j -= 1;
                if(j >= 0) {
                    if (arr[i] > arr[j]) {
                        ret[0] = j;
                        break;
                    }
                }
                //注意判断没有的情况
                else {
                    ret[0] = -1;
                }
            }
            //注意上面的j变化的问题
            j = i;
            while(j >= 0 && j <= count - 1){
                j += 1;
                if(j <= count - 1) {
                    if (arr[i] > arr[j]) {
                        ret[1] = j;
                        break;
                    }
                }else {
                    ret[1] = -1;
                }
            }
            System.out.println(ret[0] + " " + ret[1]);
        }
    }

    public static void main2(String[] args) {
        //残缺代码
        //输出出现基奇数次的两个数 并排序
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            //数组中总共的个数
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            int count = 0;
            for (int i = 0; i < arr.length; i++) {
                count ^= arr[i];
            }
            int i = 0;
            for (; i < 32; i++) {

            }
        }
    }

}
