package shin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCMembers2 {
    public static void main(String[] args) {
        //변수 생성
        int custid;
        String name;
        String address;
        String phone;
        Scanner sc = new Scanner(System.in);
        System.out.println("고객 번호를 입력하세요");
        custid = Integer.parseInt(sc.nextLine());
        System.out.println("고객 이름을 입력하세요");
        name = sc.nextLine();
        System.out.println("고객 주소를 입력하세요");
        address = sc.nextLine();
        System.out.println("고객 핸드폰 번호를 입력하세요");
        phone = sc.nextLine();

        String SQL = "insert into bookmembers values(?,?,?,?)";

        // JDBC에서 사용할 변수 생성
        Connection conn = null;
        PreparedStatement pstmt = null;

        //Connection 생성
        conn = JDBCUtil.makeConn();

        //pstmt 에 conn 대입해서 sql구문 실행
        try {
            pstmt = conn.prepareStatement(SQL);
            pstmt.setInt(1,custid);
            pstmt.setString(2,name);
            pstmt.setString(3,address);
            pstmt.setString(4,phone);
            int cnt = pstmt.executeUpdate();
            if (cnt>0) System.out.println("sql구문 동작 성공");
        } catch (SQLException sqle) {
            System.out.println("sql구문오류");
        }
        JDBCUtil.destroyConn(conn, null);
    }
}
