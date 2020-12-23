package sungjukTest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class SungJukDAO {

        public static String insertSQL(SungJukVO sjv) {
                Connection conn = null;
                PreparedStatement pstmt = null;
                conn = SungJukJDBC.makeConn();
                String result ="실패!";
                try {
                        pstmt = conn.prepareStatement(SungJukJDBC.insertSQL);
                        pstmt.setString(1,sjv.getName());
                        pstmt.setInt(2,sjv.getKor());
                        pstmt.setInt(3,sjv.getEng());
                        pstmt.setInt(4,sjv.getMat());
                        pstmt.setInt(5,sjv.getSum());
                        pstmt.setDouble(6,sjv.getMean());
                        pstmt.setString(7,String.valueOf(sjv.getGrd()));
                        int cnt = pstmt.executeUpdate();
                        if (cnt>0) result="성공!";

                } catch (SQLException throwables) {
                        System.out.println("sql문 오류");

                }

                SungJukJDBC.destroyConn(conn,pstmt);

                return result;



        }

        public static ArrayList<SungJukVO> selectSQL() {
                Connection conn = null;
                PreparedStatement pstmt = null;
                ResultSet rs = null;
                ArrayList<SungJukVO> sjvs = new ArrayList<>();

                conn = SungJukJDBC.makeConn();
                try {
                        pstmt = conn.prepareStatement(SungJukJDBC.selectSQL); //"select sjno, name, mean, grd from sungjuk";
                        rs = pstmt.executeQuery();
                        while (rs.next()){
                                SungJukVO sj = new SungJukVO(
                                        Integer.parseInt(rs.getString(1)),
                                        rs.getString(2),
                                        Double.parseDouble(rs.getString(3)),
                                        rs.getString(4).charAt(0)
                                        );
                                sjvs.add(sj);
                                }
                } catch (SQLException throwables) {
                        System.out.println("sql문 오류");
                }
                SungJukJDBC.destroyConn(conn,pstmt,rs);
                return sjvs;
        }

        public static SungJukVO selectOneSQL() {
                Scanner scan = new Scanner(System.in);
                System.out.print("검색할 학생번호를 입력해주세요 : ");
                int inputNo = Integer.parseInt(scan.nextLine());
                Connection conn = null;
                PreparedStatement pstmt = null;
                ResultSet rs = null;
                SungJukVO sv = new SungJukVO();
                conn = SungJukJDBC.makeConn();
                try {
                        pstmt = conn.prepareStatement(SungJukJDBC.selectOneSQL);
                        pstmt.setInt(1,inputNo);
                        rs = pstmt.executeQuery();
                        if (rs.next()){
                              sv = new SungJukVO(
                                      Integer.parseInt(rs.getString(1)),
                                      rs.getString(2),
                                      Integer.parseInt(rs.getString(3)),
                                      Integer.parseInt(rs.getString(4)),
                                      Integer.parseInt(rs.getString(5)),
                                      Integer.parseInt(rs.getString(6)),
                                      Double.parseDouble(rs.getString(7)),
                                      rs.getString(8).charAt(0),
                                      rs.getString(9).substring(0,10)
                              );
                        }
                } catch (SQLException throwables) {
                        System.out.println("sql구문오류");
                }
                SungJukJDBC.destroyConn(conn,pstmt,rs);
                return sv;
        }


        public static String updateSungJuk(SungJukVO sj) {
                Connection conn = null;
                PreparedStatement pstmt = null;
                String result = "데이터 수정 실패!";

                conn = SungJukJDBC.makeConn();
                try {
                        pstmt = conn.prepareStatement(SungJukJDBC.updateSungJuk);
                        pstmt.setInt(7,sj.getSjno());
                        pstmt.setInt(1,sj.getKor());
                        pstmt.setInt(2,sj.getEng());
                        pstmt.setInt(3,sj.getMat());
                        pstmt.setInt(4,sj.getSum());
                        pstmt.setDouble(5,sj.getMean());
                        pstmt.setString(6,String.valueOf(sj.getGrd()));

                        int cnt = pstmt.executeUpdate();
                        if (cnt > 0) result = "수정 완료 !";
                } catch (SQLException throwables) {
                        System.out.println("sql구문오류");
                }
                SungJukJDBC.destroyConn(conn,pstmt);
                return result;
        }

        //삭제할 성적 번호를 매개변수로 넘겨주면, 해당 데이터를 삭제함
        public static String deleteSungJuk(int sjno) {
                Connection conn = null;
                PreparedStatement pstmt = null;
                String result = "데이터 삭제 실패";

                conn = SungJukJDBC.makeConn();
                try {
                        pstmt = conn.prepareStatement(SungJukJDBC.deleteSungJuk);
                        pstmt.setInt(1,sjno);
                        int cnt = pstmt.executeUpdate();
                        if (cnt > 0) result = "데이터 삭제 성공";
                } catch (SQLException throwables) {
                        System.out.println("sql구문오류");
                }
                SungJukJDBC.destroyConn(conn,pstmt);
                return result;
        }
}
