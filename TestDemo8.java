
/*

处理异常

 */

public class TestDemo {
    public static void main(String[] args) {
        try {
            int []arr=null;
            System.out.println(arr.length);
            System.out.println(arr[100]);

        } catch(NullPointerException | ArrayIndexOutOfBoundsException e) {
      e.printStackTrace();
            System.out.println("捕获了NullPointerException异常");
        } finally {
            System.out.println("这是一个finally");
            throw new ArrayIndexOutOfBoundsException();
            
        }
    }

}
