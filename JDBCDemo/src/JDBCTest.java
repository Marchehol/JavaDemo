import java.sql.*;

public class JDBCTest {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //连接数据库
        Class.forName("com.mysql.jdbc.Driver");   //加载驱动
        String url = "jdbc:mysql://127.0.0.1:3306/test";
        String user = "root";
        String password = "159156";
        
        //建立数据库连接
        Connection conn = DriverManager.getConnection(url, user, password);


        String sql = "select * from users";
        Statement stmt = conn.createStatement();    //创建一个statement对象
        ResultSet rs = stmt.executeQuery(sql);        //执行查询

        int id, sex;
        String username, address;
        System.out.println("id\t姓名\t性别\t地址\t");
        
        while(rs.next()) {        //遍历结果集
            id = rs.getInt("id");
            username = rs.getString("username");
            sex = rs.getInt("sex");
            address = rs.getString("address");
            System.out.println(id + "\t" + username + "\t" + sex + "\t" + address);
        }

        /*
        String sql = "insert into users(username, sex, address) values('Mike',1,'shanghai')";
        Statement stmt = conn.createStatement();    //创建一个Statement对象
        stmt.executeUpdate(sql);    //执行SQL语句
        conn.close();    //关闭数据库连接对象


        String sql = "insert into users(username, sex, address) values(?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, "Lucy");    //为第一个问号赋值
        ps.setInt(2, 2);    //为第二个问号赋值
        ps.setString(3, "USA");    //为第三个问号赋值
        ps.executeUpdate();
        conn.close();
        */
    }
    
}