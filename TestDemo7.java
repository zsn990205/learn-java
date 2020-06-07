import java.util.Scanner;
  public class TestDemo {
  	public static int jump(int n) {
      if(n<3) {
        return n;
      }
  		return jump(n-1)+jump(n-2);
  	}

  	public static void main(String[] args) {
    Scanner scan=new Scanner(System.in);
    int n=scan.nextInt();
    System.out.println(jump(n));
  	}
  }