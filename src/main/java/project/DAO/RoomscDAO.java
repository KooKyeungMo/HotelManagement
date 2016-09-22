package project.DAO;

import project.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import static project.DAO.CustomDAO.openConn;

/**
 * Created by java on 2016-09-22.
 */
public class RoomscDAO {
    private final static String searchRoom1 = "select * from ROOM where rname = ? ";
    private final static String searchRoom2 = "select * from ROOM where rstair = ? ";
    private final static String searchRoom3 = "select * from ROOM where rmax = ? ";

    public static List<rortlfWhghl> viewsearchCustom(String c, String e) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<rortlfWhghl> result = new ArrayList<>();

        try{
            conn = openConn();

            if(c.trim().equals("이름")) {
                pstmt = conn.prepareStatement(searchRoom1);
            }else if(c.equals("층수"))
                pstmt = conn.prepareStatement(searchRoom2);
            else if(c.equals("최대인원"))
                pstmt = conn.prepareStatement(searchRoom3);

            pstmt.setString(1, e);

            rs=pstmt.executeQuery();

            while(rs.next()){
                rortlfWhghl r = new rortlfWhghl(rs.getString("roomid"),rs.getString("rname"),
                        rs.getString("rsize"),rs.getString("rstair"),rs.getString("rmax"),
                        rs.getString("minfee"),rs.getString("maxfee"),rs.getString("regdate").substring(0, 10));
                result.add(r);
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            closeConn(conn, pstmt, null);
        }

        return result;
    }

    public static void closeConn(Connection c, PreparedStatement p, ResultSet r){
        if(r!=null)try{r.close(); r=null;}catch (Exception e){}
        if(p!=null)try{p.close(); p=null;}catch (Exception e){}
        if(c!=null)try{c.close(); r=null;}catch (Exception e){}
    }
}