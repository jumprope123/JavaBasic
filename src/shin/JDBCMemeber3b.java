package shin;

import java.sql.*;
import java.util.Scanner;

public class JDBCMemeber3b {
    public static void main(String[] args) {


        // 특정 유저를 입력하면 해당 유저의 정보를 뽑아줌
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select * from member where user = ?";
        Scanner scan = new Scanner(System.in);
        System.out.println("username을 입력하시오");
        String user = scan.nextLine();
        StringBuilder sb = new StringBuilder();
        String fmt = "%s %s %s %s %s %s\n";

        conn = JDBCUtil.makeConn();
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,user);
            rs = pstmt.executeQuery();
            while (rs.next()){
                String username = rs.getString(1);
                String pw = rs.getString(2);
                String name = rs.getString(3);
                String grd = rs.getString(4);
                String pt = rs.getString(5);
                String rd = rs.getString(6);
                String result = String.format(fmt,username,pw,name,grd,pt,rd);
                sb.append(result);

            }
        } catch (SQLException throwables) {
            System.out.println("sql 문법 오류");
        }
        JDBCUtil.destroyConn(conn,pstmt,rs);
        System.out.println(sb.toString());
    }
}