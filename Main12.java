import java.util.Scanner;

    public class Main12 {
        public static void main2(String[] args) {
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNext()) {
                String ip = scanner.nextLine();  //输入ip地址字符串
                String ip10 = scanner.nextLine();  //输入10进制型的ip地址
                System.out.println(convertIp10(ip));
                System.out.println(convertIp(ip10));
            }
        }

        private static String convertIp(String ip10) {
            StringBuffer sb = new StringBuffer();
            //长整型转二进制字符串静态方法
            String ip2 = Long.toBinaryString(Long.parseLong(ip10));
            String as = "";
            //IP地址不够32位 前面疯狂补0
            if (ip2.length() < 32) {
                for (int i = 0; i < 32-ip2.length(); i++) {
                    as += "0";
                }
            }
            //够32位 直接不变即可
            ip2 = as + ip2;
            //ip地址每一段进行拼接 因为每一个八位二进制数代表Ip的一部分
            String[] ips = new String[4];
            ips[0] = ip2.substring(0,8);
            ips[1] = ip2.substring(8,16);
            ips[2] = ip2.substring(16,24);
            ips[3] = ip2.substring(24,32);
            for (int i = 0; i < 4; i++) {
                //括号中是二进制数的形式 转换成10进制数值
                sb.append(Integer.parseInt(ips[i],2));
                //为啥要等于三带点 是因为它是四个数所以要被三个点分开
                if (i != 3) {
                    sb.append(".");
                }
            }
            return sb.toString();
        }

        private static long convertIp10(String ip) {
            String[] ips = ip.split("\\.");
            StringBuffer sb = new StringBuffer();
            //转换的具体步骤是 先将ip地址每个数字转成二进制的形式再合并进行10进制运算
            for (int i = 0; i < ips.length; i++) {
                sb.append(binarryString(ips[i]));
            }
            //将一整串二进制的数字合并 求其10进制数值
            //比如00001010结果是10 radix位置表示的是放入到函数的sb.toString的数字是啥类型的
            return Long.parseLong(sb.toString(),2);
        }
        //十进制转换成8位2进制
        private static String binarryString(String s) {
            StringBuffer sb = new StringBuffer();
            int num = Integer.parseInt(s);
            int k = 1 << 7;  //k是1000 0000
            //比如分割后 数组是{10.0.3.193} 那么第一个num就是10&128的结果
            //与八次下来 答案是00001010
            for (int i = 0; i < 8; i++) {
                //因为是八位二进制数 所以要调整八次 十进制转二进制的方法
                int flag = (num & k) == 0?0:1;
                sb.append(flag);
                num = num << 1;
            }
            return sb.toString();
        }

    //解题思路:
    //1.解析字符串
    //2.整数部分 按照亿 万 千 百 十 个位来处理
    //3.小数部分 按照角 分处理
    static String[] map = {"壹","贰","叁","肆","伍", "陆","柒","捌","玖"};
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String number = scanner.next();
            resolve(number);
        }
    }
    private static void resolve(String str) {
        //下述操作的打印结果 Ljava.lang.String;@7ea987ac
        String[] strArr = str.split("\\.");
        //将[Ljava.lang.String;@7ea987ac 转成具体数字
        //比如输入的数字时1511.32  那么number就是1511
        int number = Integer.valueOf(str.split("\\.")[0]);
        StringBuffer res = new StringBuffer("人民币");
        int yi = (int)(number/100000000);
        if (yi != 0) {
            res.append(resolveQian(yi)).append("亿");
            number = number-yi*100000000;
        }
        int wan = (int)(number/10000);
        if (wan != 0) {
            res.append(resolveQian(wan)).append("万");
            number = number-wan*10000;
        }
        //处理千百个十位
        String beforePointString = resolveQian(number);
        if (beforePointString.length() > 1) {
            res.append(beforePointString).append("元");
        }
        //有小数点时处理小数点后位数
        if (strArr.length > 1) {
            String afterPointStr = strArr[1];
            res.append(handlePoint(afterPointStr));
        }
        //在resolveQian()方法中可能返回 0xxx但是不能有0 去掉最高位的0
        String resString = res.toString();
        System.out.println(resString);
        //下列情况 如02.3若是不加处理就是人民币零贰元叁角 但是没有这么读的一般读作人民币贰元叁角
        if (resString.length() > 4 && resString.charAt(3) == '零' && resString.charAt(4) != '元') {
            //去掉最高位的0
            //substring方法的含义: 第一个数字表示从哪个字母开始第二个数字表示截取几个长度 前面表示"人民币"
            //假如括号只有一个数字 表示从这个数字开始直到整组数字结束 后面表示从"壹"开始一直往后
            resString = resString.substring(0,3) + resString.substring(4);
        }
        System.out.println(resString);
    }
    //处理小数点后的位数
    private static String handlePoint(String str) {
        String res = "";
        if (str.equals("00") || str.equals("0")) {
            res = "整";
        } else {
            if (str.charAt(0) != '0') {
                res += map[Integer.valueOf(str.charAt(0)+"")-1] + "角";
            }
            if (str.length() > 1 && str.charAt(1) != '0') {
                res += map[Integer.valueOf(str.charAt(1)+"")-1] + "分";
            }
        }
        return res;
    }

    private static String resolveQian(double tmp) {
        StringBuffer resBuffer = new StringBuffer();
        //千位
        int qian = (int)(tmp/1000);
        if (qian != 0) {
            resBuffer.append(map[qian-1]).append("仟");
            tmp = tmp- qian * 1000;
        }
        //百位
        int bai = (int)(tmp/100);
        if (bai != 0) {
            resBuffer.append(map[bai-1]).append("佰");
            tmp = tmp- bai * 100;
        }
        //十位
        int shi = (int)(tmp/10);
        if (shi != 0) {
            if (shi != 1) {
                resBuffer.append(map[shi-1]);
            }
            resBuffer.append("拾");
            tmp = tmp - 10 * shi;
        }
        if (shi == 0 && bai != 0) {
            resBuffer.append("零");
        }
        int ge = (int)(tmp % 10);
        if (ge != 0) {
            if (qian == 0 && bai ==0 && shi == 0) {
                resBuffer.append("零");
            }
            resBuffer.append(map[ge-1]);
        }
        String res = resBuffer.toString();
        return res;
    }

    //链式A+B的解题思路 先将链表转换成整数 进行求和
    //接着把求和的结果再转成链表的形式
    class ListNode {
        int val;
        ListNode next = null;
        public ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode plusAB(ListNode a,ListNode b) {
        int aValue = ListNodeConvert(a);
        int bValue = ListNodeConvert(b);
        int sumValue = aValue + bValue;
        return intValueConvertList(sumValue);
    }

    private ListNode intValueConvertList(int value) {
        char[] arr = String.valueOf(value).toCharArray();  //字符串转成数组
        //使新链表的头节点是数组的最后一个数字
        ListNode node = new ListNode(Integer.parseInt(String.valueOf(arr[arr.length-1])));
        ListNode cur = node;
        for (int i = arr.length-2; i >= 0; i--) {
            ListNode newNode = new ListNode(Integer.parseInt(String.valueOf(arr[i])));
            cur.next = newNode;
            cur = newNode;
        }
        //返回头节点
        return node;
    }

    private int ListNodeConvert(ListNode node) {
        StringBuilder sb = new StringBuilder();
        //从链表第一个节点开始计算 只要不为空就将值记录在sb中
        //指针后移
        ListNode cur = node;
        while (cur != null) {
            sb.append(cur.val);
            cur = cur.next;
        }
        //parseInt返回十进制保存的整数值
        //reverse是将链表中的数字进行翻转 题意:反向存储
        return Integer.parseInt(sb.reverse().toString());
    }
}
