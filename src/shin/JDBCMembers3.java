package shin;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCMembers3 {
    public static void main(String[] args) {


        // members테이블의 저장된 모든 내용을 출력함

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select * from member";
        StringBuilder sb = new StringBuilder();
        String fmt = "%s %s %s %s %s %s\n";


        conn = JDBCUtil.makeConn();
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()){
                String user = rs.getString(1);
                String passwd = rs.getString(2);
                String name = rs.getString(3);
                String grade = rs.getString(4);
                String points = rs.getString(5);
                String regdate = rs.getString(6);
                String result = String.format(fmt,user,passwd,name,grade,points,regdate);
                sb.append(result);
            }
        } catch (SQLException throwables) {
            System.out.println("sql구문 오류");
        }
        System.out.println(sb.toString());
        JDBCUtil.destroyConn(conn,pstmt,rs);

    }
}