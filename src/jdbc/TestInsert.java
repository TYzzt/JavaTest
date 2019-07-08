package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: ZhaoTao
 * \* Date: 2019/1/7
 * \* Time: 9:54
 * \* Description:
 * \
 */
public class TestInsert {

    private final static String URL = "jdbc:mysql://127.0.0.1:3306/demo";
    private final static String USER = "root";
    private final static String PASSWORD = "admin";


    public static void main(String[] args) throws Exception {
        long beign = System.currentTimeMillis();
        batchInsert();
        long end = System.currentTimeMillis();
        System.out.println("耗费时间:" + (end - beign) / 1000 + "秒");
    }

    public static void query(int n) throws Exception {
        //1.加载驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        //2.获得数据库链接
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        //3.通过数据库的连接操作数据库，实现增删改查（使用Statement类）
        PreparedStatement ps = null;
        for (int i = 0; i < n; i++) {
            String sql = "insert into db_info values (0,?)";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, i);
            ps.execute();
            ps.close();
        }
        conn.close();
    }

    private static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        //2.获得数据库链接
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        return conn;
    }


    public static void batchInsert() throws SQLException, ClassNotFoundException {
        long start = System.currentTimeMillis();
        Connection conn = getConnection();
        conn.setAutoCommit(false);
        PreparedStatement ps = null;
        String sql = "insert into db_info values (0,?)";
        ps = conn.prepareStatement(sql); // 批量插入时ps对象必须放到for循环外面
        for (int i = 0; i < 100000; i++) {
            ps.setInt(1, i);
            ps.addBatch();
            // 每1000条记录插入一次
            if (i % 1000 == 0) {
                ps.executeBatch();
                conn.commit();
                ps.clearBatch();
            }
        }
        ps.executeBatch();
        conn.commit();
        ps.clearBatch();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }


}
