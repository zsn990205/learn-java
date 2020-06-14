

/*

认识String类

 */



public class TestDemo {

    public static void main(String[] args) {
        String str = " hello world " ;
        System.out.println("["+str+"]");
        System.out.println("["+str.trim()+"]");
    }
    public static void main13(String[] args) {
        String str = "helloworld" ;
        System.out.println(str.substring(5));
        System.out.println(str.substring(0, 5));
    }

    public static void main12(String[] args) {
        String str="name=曹操&age=18";
        String[] result=str.split("&");
        for (int i=0;i<result.length;i++) {
            //用第一次分开的结果去分开第二次的=
            String[] tmp=result[i].split("=");
            System.out.println(tmp[0]+"="+tmp[1]);
        }

    }
    public static void main11(String[] args) {
        String str = "192.168.1.1" ;
        String[] result = str.split("\\.") ;
        for(String s: result) {
            System.out.println(s);
        }
    }
    public static void main10(String[] args) {
        String str="hello friends welcome to china";
        String[] res=str.split("");
        for (String s: res) {
            System.out.print(s);
        }
        System.out.println();
        String[] res2=str.split(" ",5);
        for (String s:res2) {
            System.out.println(s);
        }
    }
    public static void main9(String[] args) {
        String str="hello how are you!";
        System.out.println(str.contains("how"));
        System.out.println(str.indexOf("you"));
        System.out.println(str.contains("bit"));
        System.out.println(str.indexOf("l",5));
        System.out.println(str.startsWith("hello"));
        System.out.println(str.endsWith("are"));
    }
    public static void main8(String[] args) {
        String str="hehe";
        String str2="Hehe";
        System.out.println(str.equals(str2));
        System.out.println(str.equalsIgnoreCase(str2));
        System.out.println("hehe".compareTo(str));
        System.out.println("A".compareTo("h"));
        System.out.println("z".compareTo("Z"));
    }
    public static void main7(String[] args) {
        String str="hello";
        byte[] data=str.getBytes();
        for (int i = 0; i <data.length ; i++) {
            System.out.println(data[i]+" ");
        }
        System.out.println(new String(data));
    }
    public static void main6(String[] args) {
        String str="hello welcome to you";
        char[] data=str.toCharArray();
        for (int i = 0; i <data.length; i++) {
            System.out.print(data[i]+" ");
        }
        System.out.println();
        System.out.println(new String(data,5,8));
        System.out.println(new String(data));
    }
    public static void main5(String[] args) {
        String str="hello";
        System.out.println(str.charAt(0));
        System.out.println(str.toCharArray());

    }
    public static void main4(String[] args) {
        String str="hello";
        System.out.println(str);

        str='H'+str.substring(1);
        System.out.println(str);
    }
    public static void main3(String[] args) {
        String str="hehe";
        String str1="hehe";
        System.out.println(str==str1);
        String str2 ="hehe";
         String str3 = new String("hehe").intern();
        System.out.println(str2==str3);
    }
    public static void main2(String[] args) {
        String str1=new String("hehe");
        String str2=new String("hehe");
        System.out.println(str1.equals(str2));
        System.out.println("hello".equals(str2));
    }
    public static void main1(String[] args) {
        String str="hello";
        String str1=new String("hehe");
        char[] arr={'a','b','c'};
        String str3=new String(arr);
        System.out.println(str1);
        System.out.println(str3);
        System.out.println(str);
    }
}
