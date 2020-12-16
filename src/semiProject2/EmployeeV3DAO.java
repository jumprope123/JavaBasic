package semiProject2;

import shin.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeV3DAO {

    public static String insertEmp(EmployeeVO empvo) {
        String result = "";
        Connection conn = null;
        PreparedStatement pstmt = null;
        conn = EmployeeJDBC.makeConn();
        try {
            pstmt = conn.prepareStatement(EmployeeJDBC.insertSQL);
        } catch (SQLException throwables) {
            System.out.println("sql문 오류");
        }
        try {
            pstmt.setInt(1,empvo.getEmpNo());
            pstmt.setString(2,empvo.getfName());
            pstmt.setString(3, empvo.getlName());
            pstmt.setString(4,empvo.geteMail());
            pstmt.setString(5,empvo.getPhone());
            pstmt.setString(6,empvo.gethDate());
            pstmt.setString(7,empvo.getJobId());
            pstmt.setInt(8,empvo.getSal());
            pstmt.setDouble(9,empvo.getComm());
            pstmt.setInt(10,empvo.getMgrId());
            pstmt.setInt(11,empvo.getDeptId());

            int cnt = pstmt.executeUpdate();
            if (cnt>0) result = "실행 성공 !";

        } catch (SQLException sqle) {
            sqle.printStackTrace();
            System.out.println("무슨오류지?");
        }
        EmployeeJDBC.destroyConn(conn,pstmt);
        return  result;
    }

    public static ArrayList<EmployeeVO> readEMP() {
        ArrayList<EmployeeVO> evo = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        conn = EmployeeJDBC.makeConn();
        try {
            pstmt = conn.prepareStatement(EmployeeJDBC.readSQL);
            rs = pstmt.executeQuery();
            while (rs.next()){
                EmployeeVO ev = new EmployeeVO();
                 ev.setEmpNo(Integer.parseInt(rs.getString(1)));
                 ev.setfName(rs.getString(2));
                 ev.setlName(rs.getString(3));
                 ev.seteMail(rs.getString(4));
                 ev.setPhone(rs.getString(5));
                 ev.sethDate(rs.getString(6).substring(0,10));
                 ev.setJobId(rs.getString(7));
                 ev.setSal(rs.getInt(8));
                 ev.setComm(rs.getDouble(9));
                 ev.setMgrId(rs.getInt(10));
                 ev.setDeptId(rs.getInt(11));
             evo.add(ev);
            }
        } catch (SQLException throwables) {
            System.out.println("SQL 구문 오류");
        }
        EmployeeJDBC.destroyConn(conn,pstmt,rs);
        return evo;
    }

    public static EmployeeVO readOneEMP() {
        Scanner scan = new Scanner(System.in);
        System.out.println("검색하실 사원번호를 입력하세요");
        int inputid = Integer.parseInt(scan.nextLine());
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        EmployeeVO ev = new EmployeeVO();
        conn = EmployeeJDBC.makeConn();
        try {
            pstmt = conn.prepareStatement(EmployeeJDBC.readOneSQL);
            pstmt.setInt(1,inputid);
            rs = pstmt.executeQuery();
            if (rs.next()){
                ev = new EmployeeVO(
                        Integer.parseInt(rs.getString(1)),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6).substring(0,10),
                        rs.getString(7),
                        rs.getInt(8),
                        rs.getDouble(9),
                        rs.getInt(10),
                        rs.getInt(11)
                );
            }
        } catch (SQLException throwables) {
            System.out.println("SQL구문오류");
        }
        EmployeeJDBC.destroyConn(conn,pstmt,rs);
        return ev;
    }
}
