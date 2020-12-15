package shin;

import java.sql.*;

public class JDBCUtil {

    // JDBC 드라이버 초기화 및 Connection 객체 생성
    public static Connection makeConn(){
        String USER = "playground";
        String PWD = "playground2020";
        String URL = "jdbc:mariadb://mariadb.cpjqbyvk0luc.ap-northeast-2.rds.amazonaws.com:3306/playground";
        String DRV = "org.mariadb.jdbc.Driver";
        Connection conn = null;
        try {
            Class.forName(DRV);
            conn = DriverManager.getConnection(URL,USER,PWD);
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC 드라이버가 없습니다");
        } catch (SQLException throwables) {
            System.out.println("JDBC 연결 실패");
        }
        return conn;
    }

    public static void destroyConn(Connection conn, PreparedStatement pstmt){
        if (pstmt != null) try {pstmt.close();} catch (SQLException throwables) {}
        if (conn != null) try {conn.close();} catch (SQLException sqle) {}
    }

    public static void destroyConn(Connection conn, PreparedStatement pstmt, ResultSet rs) {
        if (rs != null) try {rs.close();} catch (SQLException throwables) {}
        destroyConn(conn,pstmt);
    }
}
