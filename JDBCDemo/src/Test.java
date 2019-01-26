import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Test {

    Connection conn = null;

    // 初始化
    private void init() {
        // 不同的数据库有不同的驱动
        String driverName = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://127.0.0.1:3306/test";
        String user = "root";
        String password = "159156";

        try {
            // 加载驱动
            Class.forName(driverName);
            // 设置 配置数据
            // 1.url(数据看服务器的ip地址 数据库服务端口号 数据库实例)
            // 2.user
            // 3.password
            conn = DriverManager.getConnection(url, user, password);
            // 开始连接数据库
            System.out.println("数据库连接成功..");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //1.简单的查询
    public List<Student> select() throws SQLException {

        List<Student> list = new ArrayList<Student>();
        // *查询
        // 创建sql语句
        String sqlString = "select * from students";
        // 编译sql语句
        // 执行查询
        PreparedStatement pst = conn.prepareStatement(sqlString);
        ResultSet rSet = pst.executeQuery();
        // 遍历结果
        Student student = null;
        while (rSet.next()) {
            // System.out.print(rSet.getInt(1) + "\t");
            // System.out.print(rSet.getString(2) + "\t");
            // System.out.print(rSet.getInt(3) + "\t");
            // System.out.print("\n");
            student = new Student();
            student.setId(rSet.getInt(1));
            student.setName(rSet.getString(2));
            student.setAge(rSet.getInt(3));
            list.add(student);
        }

        return list;
    }

    //2.条件查询
    public List<Student> selectByStu(int age) throws SQLException {
        List<Student> students = new ArrayList<Student>();
        String sql = "select * from students where age=? ";

        PreparedStatement pst = conn.prepareStatement(sql);
        // 设置条件(相对于条件查询)
        pst.setInt(1, age);
        ResultSet rSet = pst.executeQuery();
        Student student = null;
        while (rSet.next()) {
            student = new Student();
            student.setId(rSet.getInt(1));
            student.setName(rSet.getString(2));
            student.setAge(rSet.getInt(3));
            students.add(student);
        }

        return students;
    }

    //3.多个条件查询
    public List<Student> selectByCondition(Student e) throws SQLException {
        List<Student> students = new ArrayList<Student>();
        String sql = "select * from students where age>=? and age<=? ";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1, e.getAgestart());
        pst.setInt(2, e.getAgeend());
        ResultSet rSet = pst.executeQuery();
        Student student = null;
        while (rSet.next()) {
            student = new Student();
            student.setId(rSet.getInt(1));
            student.setName(rSet.getString(2));
            student.setAge(rSet.getInt(3));
            students.add(student);
        }
        return students;
    }

    //4.添加数据
    public void save(Student student) throws SQLException {
        String sql = "insert into students values (?,?,?)";

        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1, student.getId());
        pst.setString(2, student.getName());
        pst.setInt(3, student.getAge());
        pst.executeUpdate();
        System.out.println("添加成功");
    }

    //5.更新数据
    public void update(Student student) throws SQLException {
        String sql = "update students set age=? where id=?";

        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1, student.getAge());
        pst.setInt(2, student.getId());
        pst.executeUpdate();
        System.out.println("更新成功");
    }

    //6.删除数据
    public void delete(Integer id) throws SQLException {
        String sql = "delete students where id=?";

        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1, id);
        pst.executeUpdate();
        System.out.println("删除成功");
    }

    //7.分页
    public List<Student> findByPage(int start, int end) throws SQLException {
        List<Student> students = new ArrayList<Student>();
        String sql = "select s_.* from(select  s.*,rownum rn from " +
                "(select * from students order by sid) s where rownum<=?) s_  where rn>?";

        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1, end);
        pst.setInt(2, start);
        ResultSet rSet = pst.executeQuery();
        Student student = null;
        while (rSet.next()) {
            student = new Student();
            student.setId(rSet.getInt(1));
            student.setName(rSet.getString(2));
            student.setAge(rSet.getInt(3));
            students.add(student);
        }
        return students;
    }



    public static void main(String[] args) throws SQLException {
        Test test = new Test();
        test.init();

        //1.简单的查询
        System.out.println("\n1.简单的查询");
        List<Student> students = null;
        students = test.select();
        for (int i = 0; i < students.size(); i++) {
            System.out.print(students.get(i).getId() + "\t");
            System.out.print(students.get(i).getName() + "\t\t");
            System.out.print(students.get(i).getAge());
            System.out.println();
        }

        //2.条件查询
        System.out.println("\n2.条件查询");
        students = test.selectByStu(21);
        for (int i = 0; i < students.size(); i++) {
            System.out.print(students.get(i).getId() + "\t");
            System.out.print(students.get(i).getName() + "\t\t");
            System.out.print(students.get(i).getAge());
            System.out.println();
        }

        //3.多个条件查询
        System.out.println("\n3.多个条件查询");
        Student stu = new Student();
        stu.setAgestart(20);
        stu.setAgeend(22);
        students = test.selectByCondition(stu);
        for (int i = 0; i < students.size(); i++) {
            System.out.print(students.get(i).getId() + "\t");
            System.out.print(students.get(i).getName() + "\t\t");
            System.out.print(students.get(i).getAge());
            System.out.println();
        }

        //4.
    }
}

