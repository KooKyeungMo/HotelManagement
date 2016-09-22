package project.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by java on 2016-09-21.
 */
public class config {
    protected static String DRV = "oracle.jdbc.OracleDriver";
    protected static String URL = "jdbc:oracle:thin:@//192.168.0.35/xe";
    protected static String USR = "YEAAAH";
    protected static String PWD = "YEAAAH";

    protected static Connection conn;
    protected static PreparedStatement psmt;
    protected static ResultSet rs;

    public static void makeConn() {
        try {
            Class.forName(DRV);
            conn = DriverManager.getConnection(URL, USR, PWD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void closeConn() {
        try {
            if (conn != null)
                conn.close();
            if (psmt != null)
                psmt.close();
            if (rs != null)
                rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
