package shin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCMember3c {
    public static void main(String[] args) {


        // member테이블에서 name에 홍이 포함된 유저의 데이터를 모두 뽑아라

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select * from member where name like ?";
        Scanner scan = new Scanner(System.in);
        System.out.println("홍을 입력하쇼");
        String input = scan.nextLine();
        StringBuilder sb = new StringBuilder();
        String fmt = "%s %s %s %s %s %s";

        conn = JDBCUtil.makeConn();
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,"%"+input+"%");
            rs = pstmt.executeQuery();
            while (rs.next()){
                String user = rs.getString(1);
                String pw = rs.getString(2);
                String name = rs.getString(3);
                String gd = rs.getString(4);
                String pt = rs.getString(5);
                String rd = rs.getString(6);
                String result = String.format(fmt,user,pw,name,gd,pt,rd);
                sb.append(result);
            }
        } catch (SQLException throwables) {
            System.out.println("sql구문오류");
        }
        JDBCUtil.destroyConn(conn,pstmt,rs);
        System.out.println(sb.toString());
    }
}