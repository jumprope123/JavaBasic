package shin.jdbcTest;

import shin.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DepartmentsInsert {
    public static void main(String[] args) {
        //입력변수 생성
        Scanner scan = new Scanner(System.in);
        System.out.print("부서번호를 입력하시오 : ");
        int dpid = Integer.parseInt(scan.nextLine());
        System.out.print("부서이름을 입력하시오 :");
        String dname = scan.nextLine();
        System.out.print("매니저번호를 입력하시오 :");
        int mid = Integer.parseInt(scan.nextLine());
        System.out.print("지역번호를 입력하시오");
        int loid = Integer.parseInt(scan.nextLine());
        String SQL = "insert into departments values(?,?,?,?)";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        conn = JDBCUtil1.makeConn();
        try {
            pstmt = conn.prepareStatement(SQL);
            pstmt.setInt(1,dpid);
            pstmt.setString(2,dname);
            pstmt.setInt(3,mid);
            pstmt.setInt(4,loid);
            int cnt = pstmt.executeUpdate();
            if (cnt>0) System.out.println("실행완료");
        } catch (SQLException throwables) {
            System.out.println("sql구문오류");
        }
        JDBCUtil1.destroyConn(conn,pstmt);

    }
}