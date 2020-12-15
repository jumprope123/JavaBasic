package shin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCOrders {
    // playground 데이터베이스의 bookorders 테이블에
    // 새로운 도서정보를 입력하는 JDBC 프로그램을 작성하세요
    // 컬럼정보 : orderid,cusid,bookid,saleprice,orderdate
    // 입력은 Scanner 이용

    public static void main(String[] args) {
        int orderid;
        int cusid;
        int bookid;
        int saleprice;
        String orderdate;

        Scanner scan = new Scanner(System.in);
        System.out.print("주문번호를 입력하세요: ");
        orderid = Integer.parseInt(scan.nextLine());
        System.out.print("고객번호를 입력하세요: ");
        cusid = Integer.parseInt(scan.nextLine());
        System.out.print("책 번호를 입력하세요: ");
        bookid = Integer.parseInt(scan.nextLine());
        System.out.print("가격을 입력하세요: ");
        saleprice = Integer.parseInt(scan.nextLine());
        System.out.print("주문날짜를 입력하세요: ");
        orderdate = scan.nextLine();


        // jdbc에서 사용할 변수 생성
        String USER = "playground";
        String PWD = "playground2020";
        String URL = "jdbc:mariadb://mariadb.cpjqbyvk0luc.ap-northeast-2.rds.amazonaws.com:3306/playground";
        String DRV = "org.mariadb.jdbc.Driver";
        String SQL = "insert into bookorders values("+orderid+","+cusid+","+bookid+","+saleprice+",'"+orderdate+"')";
        // jdbc 메모리 적재
        try {
            Class.forName(DRV);
        } catch (ClassNotFoundException ce) {
            System.out.println("드라이브 오류");
        }

        // Connection
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL,USER,PWD);
        } catch (SQLException sqle) {
            System.out.println("주소,아이디,비번중 하나가 오류남");
        }

        // conn 을 statement 해서 excute하기
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            boolean isfalse = stmt.execute(SQL);
            if (!isfalse) System.out.println("성공 !");
        } catch (SQLException throwables) {
            System.out.println("SQL구문 오류");
        }

        // 닫아주기
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException throwables) {}
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException throwables) {}
        }

    }

}
