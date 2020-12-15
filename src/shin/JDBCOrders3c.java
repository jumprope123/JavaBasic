package shin;

import jdk.nashorn.internal.scripts.JD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCOrders3c {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("최소가격을 넣어주세요");
        int input1 = Integer.parseInt(scan.nextLine());
        System.out.println("최대가격을 넣어주세요");
        int input2 = Integer.parseInt(scan.nextLine());
        String sql = "select * from bookorders where saleprice between ? and ? order by saleprice";
        StringBuilder sb = new StringBuilder();
        String fmt = "%s %s %s %s %s\n";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        conn = JDBCUtil.makeConn();
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,input1);
            pstmt.setInt(2,input2);
            rs = pstmt.executeQuery();
            if (rs!=null) System.out.println("쿼리문 실행성공");
            while (rs.next()){
                String oi = rs.getString(1);
                String ci = rs.getString(2);
                String bi = rs.getString(3);
                String sp = rs.getString(4);
                String od = rs.getString(5);
                String result = String.format(fmt,oi,ci,bi,sp,od);
                sb.append(result);
            }
        } catch (SQLException throwables) {
            System.out.println("sql구문오류");
        }
        JDBCUtil.destroyConn(conn,pstmt,rs);
        System.out.println(sb.toString());


    }
}
