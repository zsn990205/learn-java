import com.bit.BookList;
import com.bit.src.user.AdminUser;
import com.bit.src.user.NormalUser;
import com.bit.src.user.User;

import java.util.Scanner;
/*
user的函数名称书写有问题
main函数中 while循环内部有问题
 */
public class Main {

    public static User login () {
        Scanner scanner =new Scanner(System.in);
        System.out.println("请输入您的姓名");
        String name=scanner.nextLine();
        System.out.println("请输入您的身份: 1>管理员 2>普通用户");
        int num=scanner.nextInt();
        if(num==1) {
            return new AdminUser(name);
        } else {
            return new NormalUser(name);
        }
    }

    public static void main(String[] args) {
        BookList bookList=new BookList();
        User user=login();
        while(true) {
            int choice=user.menu();
            user.doOperation(choice,bookList);
        }
    }
}
