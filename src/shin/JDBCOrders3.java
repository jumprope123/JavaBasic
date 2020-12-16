package shin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCOrders3 {
    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String SQL = "select * from bookorders";
        String fmt = "%s %s %s %s %s\n";
        StringBuilder sb = new StringBuilder();

        conn = JDBCUtil.makeConn();
        try {
            pstmt = conn.prepareStatement(SQL);
            rs = pstmt.executeQuery();
            while (rs.next()){
                String ordid = rs.getString(1);
                String cusid = rs.getString(2);
                String bookid = rs.getString(3);
                String sprice = rs.getString(4);
                String odate = rs.getString(5);
                String result = String.format(fmt,ordid,cusid,bookid,sprice,odate);
                sb.append(result);
            }
        } catch (SQLException throwables) {
            System.out.println("sql구문오류");
        }
        JDBCUtil.destroyConn(conn,pstmt,rs);
        System.out.println(sb);
    }
}
