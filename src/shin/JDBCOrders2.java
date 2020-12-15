package shin;

import jdk.nashorn.internal.scripts.JD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCOrders2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("주문번호 입력");
        int orderid = Integer.parseInt(scan.nextLine());
        System.out.println("손님아이디 입력");
        int cusid = Integer.parseInt(scan.nextLine());
        System.out.println("책 번호 입력");
        int bookid = Integer.parseInt(scan.nextLine());
        System.out.println("가격 입력");
        int saleprice = Integer.parseInt(scan.nextLine());
        System.out.println("주문 날짜 입력");
        String orderdate = scan.nextLine();

        // jdbc변수 생성
        Connection conn = null;
        PreparedStatement pstmt = null;

        //SQL문 생성
        String SQL = "insert into bookorders values(?,?,?,?,?)";

        // 커넥션 생성
        conn = JDBCUtil.makeConn();
        // pstm생성
        try {
            pstmt = conn.prepareStatement(SQL);
            pstmt.setInt(1,orderid);
            pstmt.setInt(2,cusid);
            pstmt.setInt(3,bookid);
            pstmt.setInt(4,saleprice);
            pstmt.setString(5,orderdate);
            int cnt = pstmt.executeUpdate();
            if (cnt>0) System.out.println("sql구문 실행 성공!");
        } catch (SQLException throwables) {
            System.out.println("sql구문오류");
        }
            JDBCUtil.destroyConn(conn,pstmt);
    }
}
