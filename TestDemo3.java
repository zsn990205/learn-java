import java.util.Scanner
    public class TestDemo {
  	public static int maxCompare(int a,int b,int c) {
       int max = a > b ? a : b;
       int max2=max>c? max:c;
       return max2;
   }
    public static void main3(String[] args) {
	Scanner scan=new Scanner(System.in);
       int a=scan.nextInt();
       int b=scan.nextInt();
       int c=scan.nextInt();
       /*int ret=maxCompare(a,b);*/
       System.out.println(maxCompare(a,b,c));
   }

	public static void main2(String[] args) {
       Scanner scan=new Scanner(System.in);
       int n=scan.nextInt();
       for(int i=31;i>=1;i-=2) {
        System.out.print(((n>>>i) & 1) +" ");
    }   System.out.println();
       for(int i=30;i>=0;i-=2) {
       	System.out.print(((n>>>i) & 1) +" ");
       }
   }


	public static void main1(String[] args) {
		Scanner scan=new Scanner(System.in);
		int count=3;
		System.out.println("请输入您要输入的数字,您只有三次机会");
		while(count!=0) {
			System.out.println("请输入您的密码");
			String password=scan.next();
			if(password.equals("123456")) {
				System.out.println("您的输入成功");
				break;
			} else {
				System.out.println("请重新输入");
				count--;
				System.out.println("登陆失败你还有"+count+"次机会");
			}
		
		}
	}
}