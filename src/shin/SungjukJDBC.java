package shin;

import shin.JDBCUtil;

public class SungjukJDBC extends JDBCUtil {
    public static String insertSungjuk =
            "insert into sungjuk (name, kor, eng, mat, tot, mean, grd) values (?,?,?,?,?,?,?)";
    public static String selectSungjuk =
            "select sjno,name,kor,eng,mat,regdate from sungjuk";
    public static String selectOneSungjuk =
            "select * from sungjuk where sjno = ?";
    static String updateSungJuk = "update sungjuk set kor = ?, eng = ?, mat =?, tot = ?, mean = ?, grd = ? , regdate = current_timestamp() where sjno = ?";
    public static String deleteSungjuk =
            "delete from sungjuk where sjno = ?";
}
