import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class TestJDBCUpdate {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入您要修改的学生id: ");
        int id = scanner.nextInt();
        System.out.println("请输入您要修改的学生的姓名: ");
        String name = scanner.next();
    //1.创建DataSource new对象
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource) dataSource).setURL("jdbc:mysql://127.0.0.1:3306/java20200526?characterEncoding=utf-8&useSSL=true");
        ((MysqlDataSource) dataSource).setUser("root");
        ((MysqlDataSource) dataSource).setPassword("rootroot");

    //2.建立connection
        Connection connection = dataSource.getConnection();

    //3.借助prepareStatement进行拼装
        String sql = "update student2 set name = ? where id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,name);
        statement.setInt(2,id);

    //4.执行sql语句
        int ret = statement.executeUpdate();
        if (ret == 1) {
            System.out.println("修改成功");
        } else {
            System.out.println("修改失败");
        }
    //5.释放资源
        statement.close();
        connection.close();
    }
}
