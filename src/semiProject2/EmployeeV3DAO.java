package semiProject2;

import jdk.nashorn.internal.runtime.OptimisticReturnFilters;
import shin.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeV3DAO {

    public static String insertEmp(EmployeeVO empvo) {
        String result = "실행 실패!";
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

    public static EmployeeVO readOneEMP(int inputid) {
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

    public static String deleteSQL(int empid) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        conn = EmployeeJDBC.makeConn();
        String result = "실패!";
        try {
            pstmt = conn.prepareStatement(EmployeeJDBC.deleteSQL);
            pstmt.setInt(1, empid);
            int cnt = pstmt.executeUpdate();
            if (cnt > 0) result = "실행 성공 !";

        } catch (SQLException throwables) {
            System.out.println("sql구문오류");
        }
        EmployeeJDBC.destroyConn(conn,pstmt);
        return result;
    }

    public static String modifySQL(EmployeeVO ev) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String result = "실패!";
        conn = EmployeeJDBC.makeConn();
        try {
            pstmt = conn.prepareStatement(EmployeeJDBC.modifySQL);
            pstmt.setString(1,ev.getfName());
            pstmt.setString(2,ev.getlName());
            pstmt.setString(3,ev.geteMail());
            pstmt.setString(4,ev.getPhone());
            pstmt.setString(5,ev.gethDate());
            pstmt.setInt(6,ev.getEmpNo());
            int cnt = pstmt.executeUpdate();
            if (cnt > 0) result = "실행 성공 !";
        } catch (SQLException throwables) {
            System.out.println("sql구문오류");
        }
        EmployeeJDBC.destroyConn(conn,pstmt);
        return result;
    }
}
