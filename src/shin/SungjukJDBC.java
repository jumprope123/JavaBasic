package shin;

import shin.JDBCUtil;

public class SungjukJDBC extends JDBCUtil {
    public static String insertSungjuk =
            "insert into sungjuk (name, kor, eng, mat, tot, mean, grd) values (?,?,?,?,?,?,?)";
    public static String selectSungjuk =
            "select sjno,name,kor,eng,mat,regdate from sungjuk order by sjno desc";
    public static String selectOneSungjuk =
            "select * from sungjuk where sjno = ?";
    public static String updateSungjuk =
            "update sungjuk set kor = ?, eng = ?, mat = ?, tot = ?, mean = ?, grd = ? where sjno = ?";
    public static String deleteSungjuk =
            "delete from sungjuk where sjno = ?";
}
