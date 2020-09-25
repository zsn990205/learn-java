import java.util.*;

public class Main13 {
    public static long toKnut(long galleon,long sickle,long knut) {
        //最后钱的结果均用Knut表示
        return galleon * 29 * 17 + sickle * 29 + knut;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        while (scanner.hasNext()) {
            String[] strP = scanner.next().split("\\.");
            String[] strA = scanner.next().split("\\.");
            //将字符串转化成数值类型 因为数字可能会非常大所以使用long类型计算
            // 最后再将结果倒回
            long[] longP = {
                    Long.parseLong(strP[0]),
                    Long.parseLong(strP[1]),
                    Long.parseLong(strP[2])
            };
            long[] longA = {
                    Long.parseLong(strA[0]),
                    Long.parseLong(strA[1]),
                    Long.parseLong(strA[2])
            };
            //将单位全部转成knut
            long pInKnut = toKnut(longP[0],longP[1],longP[2]); //应该支付的钱
            long aInKnut = toKnut(longA[0],longA[1],longA[2]); //实际支付的钱
            long ret = aInKnut - pInKnut;
            if (ret < 0) {
                System.out.print("-"); //钱没带够的情况
                //当输出结果未负数的时候 只在零钱最前面显示"-" 后面的结果均为正
                //所以打印出"-" 将结果转成正数进行计算
                ret = -ret;
            }
            //将结果转成galleon sickle knut形式
            //knut = 17*29*galleon+29*s+k
            //galleon=ret/17*29
            //s=(ret-g*27*19)/29
            //k=(ret-s*29)
            System.out.printf("%d.%d.%d\n",ret / (17 * 29),
                    ret % (17 * 29) / 29,ret % (17 * 29) % 29);

        }
    }
    public static int countNumberOf2s(int n) {
        int count = 0;  //计算最终2的个数 计算12209百位2的个数
        int flag = 1;   //标记位  flag在个位时是1十位是10百位是100
        int low = 0;    //低位   09
        int cur = 0;    //当前位  2
        int high = 0;   //高位   12
        while (n / flag != 0) {
            low = n - (n / flag) * flag; //low=12209-(12209/100)*100=09
            cur = (n / flag) % 10;       //当前位置是(12209/100)%10=2
            high = (n / flag) / 10;      //高位就是 (12209/100)/10=12
            if (cur == 1 || cur == 0) { //当前位<2的情况 100以内2的个数
                count += high * flag;
            } else if (cur == 2) { //当前位=2的情况 200的情况
                count += (high * flag) + low +1;
            } else {
                count += (high + 1) * flag;
            }
            flag *= 10;
        }
        return count;
    }
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //此处必须使用LinkedHashMap(有顺序) 按插入顺序排序随后会按照出错次数再排序
        //但如果出错次数一样 还是按照插入的顺序来
        Map<String, Integer> map = new LinkedHashMap<String, Integer>();
        while (scanner.hasNext()) {
            //一:输入
            String path = scanner.next();
            //E:\V1R2\product\fpgadrive.c 1325 输入的Windows路径如此
            //即 1325
            int line = scanner.nextInt();
            //因此 数字就是最后一个\所在之后
            int id = path.lastIndexOf("\\");
            //文件名就是最后一个\所处位置之后
            //假如id=-1 说明此路径本身就是文件名 反之从id位置+1起是文件名
            //文件名比如:fpgadrive.c
            String fileName = id == -1 ? path : path.substring(id + 1);
            //二:统计出现的频率
            //key 就是要输出的一部分 后面还得加上key出现的次数
            String key = fileName + " " + line;
            //map是有序的 查看其中是否包含key 包含就+1 反之不变
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }
        //三.对记录进行排序 Java中的排序用的是归并排序 是稳定的
        //出错次数一样多时 仍然保持插入排序
        List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                //由高到低进行排序
                return o2.getValue() - o1.getValue();
            }
        });
        //四:处理输出
        int m = 0; //m表示记录的次数
        //对排序好的数据遍历
        for (Map.Entry<String, Integer> mapping : list) {
            //超过八条记录输出前八条
            if (m >= 8) {
            //对相同的错误 记录一条只是错误计数增加
            //当超过八条记录的时候 前面都输出过了在这里直接break掉
                break;
            }
            //将结果用空格分开
            String[] str = mapping.getKey().split(" ");
            String filename = str[0];
            if (filename.length() > 16) {
                filename = filename.substring(filename.length()-16);
            }
            String n = str[1];
            //count就是这个文件名在路径中出现的次数
            Integer count = mapping.getValue();
            System.out.printf("%s %s %d%n",filename,n,count);
            m++;
        }
    }
}
