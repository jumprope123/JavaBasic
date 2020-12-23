package booksJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BooksDAO {

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;


    public static String newBook(BooksVO bv) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        conn = BooksJDBC.makeConn();
        String result = "입력 실패!!";
        try {
            pstmt = conn.prepareStatement(BooksJDBC.insertJDBC);
            pstmt.setInt(1,bv.getBookid());
            pstmt.setString(2,bv.getBookname());
            pstmt.setString(3,bv.getPublisher());
            pstmt.setInt(4,bv.getPrice());
            int cnt = pstmt.executeUpdate();
            if (cnt > 0) result ="입력 성공 !!";
        } catch (SQLException throwables) {
            System.out.println("sql 구문오류");
        }
            return result;
    }

    public static ArrayList<BooksVO> selectBook() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<BooksVO> bvs = new ArrayList<>();
        conn = BooksJDBC.makeConn();
        try {
            pstmt = conn.prepareStatement(BooksJDBC.selectJDBC);
            rs = pstmt.executeQuery();
            while (rs.next()){
                BooksVO bv = new BooksVO(
                        Integer.parseInt(rs.getString(1)),
                        rs.getString(2),
                        rs.getString(3),
                        Integer.parseInt(rs.getString(4))
                        );
                bvs.add(bv);
                }
            } catch (SQLException throwables) {
            System.out.println("sql문 오류");
        }
        BooksJDBC.destroyConn(conn,pstmt,rs);
        return bvs;
    }

    public static BooksVO selectOneBook(int bookid) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        BooksVO bv = null;

        conn = BooksJDBC.makeConn();
        try {
            pstmt = conn.prepareStatement(BooksJDBC.selectOneJDBC);
            pstmt.setInt(1,bookid);
            rs = pstmt.executeQuery();
            if (rs.next()){
                bv = new BooksVO(
                        Integer.parseInt(rs.getString(1)),
                        rs.getString(2),
                        rs.getString(3),
                        Integer.parseInt(rs.getString(4)));
            }
        } catch (SQLException throwables) {
            System.out.println("sql문 오류");
        }
        return bv;
    }

    public static String modifyBook(BooksVO bv) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String result = "실행 실패!";
        conn = BooksJDBC.makeConn();
        try {
            pstmt = conn.prepareStatement(BooksJDBC.modifyJDBC);
            pstmt.setString(1,bv.getBookname());
            pstmt.setString(2,bv.getPublisher());
            pstmt.setInt(3,bv.getPrice());
            pstmt.setInt(4,bv.getBookid());
            int cnt = pstmt.executeUpdate();
            if (cnt > 0 ) result = "실행 성공 !";
        } catch (SQLException throwables) {
            System.out.println("sql구문오류");
        }
        BooksJDBC.destroyConn(conn,pstmt);
        return result;
    }

    public static String removeBook(int inputid) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        conn = BooksJDBC.makeConn();
        String result = "실행 실패!";
        try {
            pstmt = conn.prepareStatement(BooksJDBC.romoveJDBC);
            pstmt.setInt(1,inputid);
            int cnt = pstmt.executeUpdate();
            if (cnt>0) result = "실행 성공 !";
        } catch (SQLException throwables) {
            System.out.println("SQL문 오류");
        }
        BooksJDBC.destroyConn(conn, pstmt);
        return result;
    }
}
