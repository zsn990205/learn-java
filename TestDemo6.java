import java.util.Scanner;
  public class TestDemo {
  	public static int swapInt(int a, int b) {
        int max=a>b?a:b;
        return max;
  	}
  	public static double swapDouble(double c, double d) {
  		double max=c>d?c:d;
  		return max;
  	}
  	public static void main2(String[] args) {
  		Scanner scan=new Scanner(System.in);
  		int a=scan.nextInt();
  		int b=scan.nextInt();
  		int max=swapInt(a,b);
  		System.out.println(max);
  		double c=scan.nextDouble();
  		double d=scan.nextDouble();
  		double max2=swapDouble(c,d);
  		System.out.println(max2);
  	}


  	
  	public static int addInt(int a , int b) {
  		return a+b;
  	}
  public static double addDouble(double c , double d) {
  	return c+d;
  }
  public static void main1(String[] args) {
  	Scanner scan=new Scanner(System.in);
  	int a=scan.nextInt();
  	int b=scan.nextInt();
  	int ret=addInt(a,b);
  	System.out.println(ret);
  	double c=scan.nextDouble();
  	double d=scan.nextDouble();
  	double ret2=addDouble(c,d);
  	System.out.println(ret2);
  }
}
