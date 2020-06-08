import com.bit.book.BookList;
import com.bit.src1.user.AdminUser;
import com.bit.src1.user.NormalUser;
import com.bit.src1.user.User;


import java.util.Scanner;
/*
main函数中
1.准备书籍
2.登陆(需要写一个登陆的方法)
因为不管是管理员还是普通用户都是 使用者 我们没必要写两个方法 因此我们的返回值是User就行了
1.输入自己的名字
2.输入自己的身份 管理员or普通用户 怎么区分? 根据用户输入对应的数字 如果是1那就是管理员系统 我们切入管理员系统
3.在Main函数里调用User的menu方法
 */

public class Main {
    public static User login() {
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入您的姓名: ");
        String name=scanner.nextLine();
        System.out.println("请输入您的身份: 1>-管理员,2>-普通用户");
        int num=scanner.nextInt();
        if(num==1) {
            return new AdminUser(name);
        } else {
            return new NormalUser(name);
        }
    }

    public static void main(String[] args) {
        //准备书籍
        BookList bookList=new BookList();
        //登陆
        User user=login(); //先new一个user对象 给这个对象传入登录方法
        while(true) { //循环保证可以连续操作
            int choice=user.menu();
           user.doOperation(choice,bookList);
        }

    }
}
