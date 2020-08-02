import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestJDBCSelect {
    public static void main(String[] args) throws SQLException {
        //1.创建DataSource对象
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource) dataSource).setURL("jdbc:mysql://127.0.0.1:3306/java20200526?characterEncoding=utf-8&useSSL=true");
        ((MysqlDataSource) dataSource).setUser("root");
        ((MysqlDataSource) dataSource).setPassword("rootroot");

        //2.创建connection对象 建立连接
        Connection connection = dataSource.getConnection();

        //3.借助PrepareStatement 拼装sql语句
        String sql = "select * from student2";
        PreparedStatement statement = connection.prepareStatement(sql);

        //4.执行sql语句
        //ResultSet表示select查找的结果集
        ResultSet resultSet = statement.executeQuery();

        //5.遍历结果集
        while(resultSet.next()) {
         //next是判断是否有下一行 如果存在就获取这一行
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            double score = resultSet.getDouble("score");
            System.out.println("id: "+ id + "name: " + name + "score" + score);
        }

        //6.释放资源
        resultSet.close();
        statement.close();
        connection.close();
    }
}
