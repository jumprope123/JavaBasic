package sungjukTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SungJukUtil {
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    String URL = "jdbc:mariadb://mariadb.cpjqbyvk0luc.ap-northeast-2.rds.amazonaws.com:3306/playground";
    String USER = "playground";
    String PWD = "playground2020";
    String DRV = "org.mariadb.jdbc.Drive";

    public static void makeConn(){

    }
}
