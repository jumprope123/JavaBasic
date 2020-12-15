package shin.jdbcTest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DepartmentSelect {
    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String SQL = "select * from departments where department_name like ?";
        Scanner sc = new Scanner(System.in);
        System.out.println("찾고자 하는 department name의 일부를 입력하시오");
        String dname = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        String fmt = "%s %s %s %s";

        conn = JDBCUtil1.makeConn();
        try {
            pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1,"%"+dname+"%");
            rs = pstmt.executeQuery();
            while (rs.next()){
                String did = rs.getString(1);
                String name = rs.getString(2);
                String mid = rs.getString(3);
                String lid = rs.getString(4);
                String result = String.format(fmt,did,name,mid,lid);
                sb.append(result);
            }
        } catch (SQLException throwables) {
            System.out.println("sql구문오류");
        }
        JDBCUtil1.destroyConn(conn,pstmt,rs);
        System.out.println(sb.toString());
    }
}
