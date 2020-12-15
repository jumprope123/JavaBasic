package shin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCMembers {
    // playground 데이터베이스의 bookmembers 테이블에
    // 새로운 도서정보를 입력하는 JDBC 프로그램을 작성하세요
    // 컬럼정보 : custid,name,address,phone
    // 입력은 Scanner 이용
    public static void main(String[] args) {
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

        String sql = "insert into bookmembers values("+custid+",'"+name+"','"+address+"','"+phone+"')";

        //JDBC연결 정보
        String DRV = "org.mariadb.jdbc.Driver";
        String URL = "jdbc:mariadb://mariadb.cpjqbyvk0luc.ap-northeast-2.rds.amazonaws.com:3306/playground";
        String USER = "playground";
        String PWD = "playground2020";

        // JDBC 메모리 적재
        try {
            Class.forName(DRV);
        } catch (ClassNotFoundException ce) {
            System.out.println("드라이브 오류");
        }
        // 데이터베이스 서버접속 Connection 과 DriverManager
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL,USER,PWD);
        } catch (SQLException se) {
            System.out.println("데이터베이스 주소나 아디 비번 오류");
        }
        // Statement로 conn을 Create 후 sql문 excute하기
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            int cnt = stmt.executeUpdate(sql);
            if (cnt>0) System.out.println("성공!");
        } catch (SQLException sqle) {
            System.out.println("SQL문 실행오류");
        }
        // 닫아주기
        if (stmt != null) try {stmt.close();} catch (SQLException sqe) {}
        if (conn != null) try {conn.close();} catch (SQLException sqe) {}

    }
}
