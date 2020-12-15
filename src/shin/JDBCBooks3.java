package shin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCBooks3 {
    public static void main(String[] args) {
        // Books테이블의 저장된 모든 내용을 출력함
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String SQL = "select * from books";
        StringBuilder sb = new StringBuilder();
        String fmt = "%s %s %s %s\n";

        conn = JDBCUtil.makeConn();
        try {
            pstmt = conn.prepareStatement(SQL);
            rs = pstmt.executeQuery();
            System.out.print(rs);
            while (rs.next()){
                String bookid = rs.getString(1);
                String bookname = rs.getString(2);
                String publiser = rs.getString(3);
                String price = rs.getString(4);
                String result = String.format(fmt,bookid,bookname,publiser,price);
                sb.append(result);
            }
        } catch (SQLException ex) {
            System.out.println("SQL오류");
        }
        System.out.println(sb.toString());

        JDBCUtil.destroyConn(conn,pstmt,rs);

    }
}
