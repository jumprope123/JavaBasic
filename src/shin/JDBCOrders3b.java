package shin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCOrders3b {
    // 주문 번호로 회원정보 조회
    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String SQL = "select * from bookorders where orderdate like ?";
        String fmt = "%s %s %s %s %s\n";
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        System.out.print("주문날짜는? : ");
        String input = sc.nextLine();

        conn = JDBCUtil.makeConn();
        try {
            pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1,"%"+input+"%");
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
