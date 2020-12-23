package sungjukTest;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class SungJukJDBC extends SungJukUtil {
    static String insertSQL = "insert into sungjuk (name,kor,eng,mat,tot,mean,grd) values (?,?,?,?,?,?,?)";
    static String selectSQL = "select sjno, name, mean, grd from sungjuk";
    static String selectOneSQL = "select * from sungjuk where sjno = ?";
    static String updateSungJuk = "update sungjuk set kor = ?, eng = ?, mat =?, tot = ?, mean = ?, grd = ? , regdate = current_timestamp() where sjno = ?";
    static String deleteSungJuk = "delete from sungjuk where sjno = ?";
}
