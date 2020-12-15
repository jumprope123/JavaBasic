package shin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCBooks3c {
    public static void main(String[] args) {
        // 도서 제목으로 도서정보 조회
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "select * from books where bookname like ?";
        StringBuilder sb = new StringBuilder();
        String fmt = "%s %s %s %s\n";

        // 조회할 책 제목 입력
        System.out.print("조회할 책 제목을 입력하세요: ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();

        conn = JDBCUtil.makeConn();
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, '%'+name+'%');
            rs = pstmt.executeQuery();
            while (rs.next()){
                String bookid = rs.getString(1);
                String bookname = rs.getString(2);
                String ps = rs.getString(3);
                String price = rs.getString(4);
                String result = String.format(fmt,bookid,bookname,ps,price);
                sb.append(result);
            }
        } catch (SQLException throwables) {
            System.out.println("sql 구문오류");
        }
        System.out.print(sb.toString());
        JDBCUtil.destroyConn(conn,pstmt,rs);

    }
}
