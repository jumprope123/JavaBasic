package shin;

import java.sql.*;
import java.util.Scanner;

public class JDBCBooks2 {
    // statement vs preparedStatment
    // 정적 쿼리문과 동적 쿼리문

    // 정적 쿼리문은 사용하기 전에 변수들을 이용해서 온전한 형태의 문장을 미리 만들어둬야함
    // 또한, 쿼리문이 실행될 때 매번 1)쿼리 문장 분석 2)컴파일 3) 실행의 과정을 거쳐야 함 -> 성능저하

    // 반면, 동적쿼리문은 불완전한 형태의 문장을 먼저 만들어두고 실행전에 매개변수에 실제로 전달할 값을 지정할 수 있음
    // 또한, 캐쉬기능을 지원하기 때문에 반복적으로 실행하는 문장의 경우 1),2) 과정을 건너뛰고 3)으로 바로 갈 수 있음.

    // PreparedStatement의 IN/OUT 매개변수
    // placeholder 매개변수, binding 매개변수라고도 함
    // sql 질의문 객체 생성시 사용하는 매개변수는 ?로 표기
    // IN 매개변수는 질의문 생성시 입력값 대용으로 사용
    // OUT 매개변수는 질의문을 실행하고 넘겨주는 결과값을 받을 때 사용
    // python => %s, %d
    // c# => @name, @passwd
    // oracle => :1, :2
    // java => ?, ?

    // JDBC 드라이버 초기화 및 Connection 객체 생성
    public static Connection makeConn(){
        String USER = "playground";
        String PWD = "playground2020";
        String URL = "jdbc:mariadb://mariadb.cpjqbyvk0luc.ap-northeast-2.rds.amazonaws.com:3306/playground";
        String DRV = "org.mariadb.jdbc.Driver";
        Connection conn = null;
        try {
            Class.forName(DRV);
            conn = DriverManager.getConnection(URL,USER,PWD);
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC 드라이버가 없습니다");
        } catch (SQLException throwables) {
            System.out.println("JDBC 연결 실패");
        }
        return conn;
    }

    public static void destroyConn(Connection conn, PreparedStatement pstmt){
        if (pstmt != null) try {pstmt.close();} catch (SQLException throwables) {}
        if (conn != null) try {conn.close();} catch (SQLException sqle) {}
    }

    public static void main(String[] args) {
        // 데이터베이스 관련 변수
        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = "insert into books values(?,?,?,?)";

        //도서 정보 입력받음
        Scanner sc = new Scanner(System.in);

        System.out.print("bookid를 입력하세요");
        int bookid = Integer.parseInt(sc.nextLine());
        System.out.print("bookname을 입력하세요");
        String bookname = sc.nextLine();
        System.out.print("publisher를 입력하세요");
        String publisher = sc.nextLine();
        System.out.print("price를 입력하세요");
        int price = Integer.parseInt(sc.nextLine());

        // 입력받은 도서정보를 테이블에 저장
        conn = makeConn();
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,bookid);
            pstmt.setString(2,bookname);
            pstmt.setString(3,publisher);
            pstmt.setInt(4,price);

            int cnt = pstmt.executeUpdate();
            if (cnt > 0 ) System.out.println("도서정보 추가 완료");
        } catch (SQLException throwables) {
            System.out.println("JDBC 질의문 생성 오류");
        }
        destroyConn(conn,pstmt);

    }
}
