import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class TestJDBC {
    public static void main(String[] args) throws SQLException {
        //1.创建DataSource对象(生命周期跟随整个程序)
        DataSource dataSource = new MysqlDataSource();

        //针对DataSource进行一些配置(向下转型)
        //针对URL User Password
        ((MysqlDataSource) dataSource).setURL("jdbc:mysql://127.0.0.1:3306/java20200526?characterEncoding=utf-8&useSSL=true");
        ((MysqlDataSource) dataSource).setUser("root");
        ((MysqlDataSource) dataSource).setPassword("rootroot");

        //2.创建连接,创建连接好了就可以进行后续的数据传输操作了
        //connection的生命周期较短 每个请求创建一个新的connection
        Connection connection = dataSource.getConnection();

        //3.拼装sql语句
        //先以一个插入数据为例
        int id = 4;
        String name = "关羽";
        double score = 63.3;
        //使用 ? 进行自动替换
        String sql = "insert into student2 values (?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1,id);
        statement.setString(2,name);
        statement.setDouble(3,score);
        System.out.println("statement: " + statement);

        //4.拼装完毕,执行sql
        //insert delete update 都使用update
        //select使用query
        int ret = statement.executeUpdate();
        System.out.println("ret: "+ ret);

        //5.释放 后创建的先释放
        statement.close();
        connection.close();

    }
}
