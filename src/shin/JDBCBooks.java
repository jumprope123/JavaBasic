package shin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCBooks {
    // playground 데이터베이스의 Books 테이블에
    // 새로운 도서정보를 입력하는 JDBC 프로그램을 작성하세요
    // 컬럼정보 : bookid, bookname, publisher, price
    // 입력은 Scanner 이용

    public static void main(String[] args) {
        // 1. 도서정보 입력
        int bookid;
        String bookname;
        String publisher;
        int price;
        Scanner sc = new Scanner(System.in);

        System.out.print("bookid를 입력하세요");
        bookid = Integer.parseInt(sc.nextLine());
        System.out.print("bookname을 입력하세요");
        bookname = sc.nextLine();
        System.out.print("publisher를 입력하세요");
        publisher = sc.nextLine();
        System.out.print("price를 입력하세요");
        price = Integer.parseInt(sc.nextLine());

        // 2. 입력받은 도서정보를 BOOKS테이블에 저장하는 SQL문 작성
        // insert into Books values(bookid,bookname,publisher,price);

        String sql = "insert into books values(" + bookid + ",'" + bookname + "','" + publisher + "'," + price + ")";
        System.out.println(sql);

        // 3. 생성한 SQL문을 JDBC를 통해서 실행
        String DRV = "org.mariadb.jdbc.Driver";
        String URL = "jdbc:mariadb://mariadb.cpjqbyvk0luc.ap-northeast-2.rds.amazonaws.com:3306/playground";
        String USR = "playground";
        String PWD = "playground2020";

        // a) jdbc드라이버 초기화
        try {
            Class.forName(DRV);
        } catch (ClassNotFoundException cnf) {
            System.out.println("드라이버를 확인하시오");
        }
        // b) 데이터베이스 서버 접속
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USR, PWD);
        } catch (SQLException se) {
            System.out.println("디비 주소나 아이디나 비번이 틀렷습니다");
        }
        // c) SQL문 객체를 생성하고 서버로 전송해서 실행함
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            boolean isFalse = stmt.execute(sql);
            if (!isFalse) System.out.println("데이터 추가완료!");
        } catch (SQLException se) {
            System.out.println("SQL문 실행 오류");
        }

        // d) JDBC 관련 객체는 메모리에서 제거
        if(stmt != null)
        try {
            stmt.close();
        } catch (SQLException se) {}

        if(conn != null)
        try {
            conn.close();
        } catch (SQLException throwables) {}

    }
}
