package project.DAO;

import project.model.*;
import project.model.rortlfWhghl;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by java on 2016-09-21.
 */
public class RoomDAO extends config{
    private final static String listReslist = "select * from room order by rname desc";
    private final static String listOneReslist = "select * from room where roomid = ?";
    private final static String updateInfo= "update room set rname = ?,rsize = ?,rstair = ?, rmax = ?, maxfee =?, minfee =? where roomid = ?";
    private final static String insertInfo= "insert into  room values (?,?,?,?,?,?,?,?)";
    private final static String deleteRM= "delete from room where roomid = ?";


    public static List<Rortlf> viewRoomInfo(){
        makeConn();
        List<Rortlf> result = new ArrayList<Rortlf>();

        try {
            psmt = conn.prepareStatement(listReslist);
            rs = psmt.executeQuery();
            while (rs.next()) {
                Rortlf ro = new Rortlf(
                        rs.getString("roomid"),
                        rs.getString("rname"),
                        rs.getString("rsize"),
                        rs.getString("rstair"),
                        rs.getString("rmax"),
                        rs.getString("maxfee"),
                        rs.getString("minfee"),
                        rs.getString("regdate")
                );
                result.add(ro);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConn();
        }

        return result;
    }

    public static List<rortlfWhghl> viewRoomReg(){
        makeConn();
        List<rortlfWhghl> result = new ArrayList<rortlfWhghl>();

        try {
            psmt = conn.prepareStatement(listReslist);
            rs = psmt.executeQuery();
            while (rs.next()) {
                rortlfWhghl ro = new rortlfWhghl(
                        rs.getString("roomid"),
                        rs.getString("rname"),
                        rs.getString("rsize"),
                        rs.getString("rstair"),
                        rs.getString("rmax"),
                        rs.getString("maxfee"),
                        rs.getString("minfee"),
                        rs.getString("regdate")
                );
                result.add(ro);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConn();
        }

        return result;
    }

    public static boolean updateRoomInfo(Rortlf sel){
        boolean result = false;
        try {
            makeConn();
            psmt = conn.prepareStatement(updateInfo);

            psmt.setString(1, sel.getRemname1());
            psmt.setString(2, sel.getAcreage1());
            psmt.setString(3, sel.getFloor1());
            psmt.setString(4, sel.getPerson1());
            psmt.setString(5, sel.getHighson1());
            psmt.setString(6, sel.getLowson1());
            psmt.setString(7, sel.getRemno1());

            if (psmt.executeUpdate() > 0)
                result = true;
            else
                result = false;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConn();
        }
        return result;
    }
    public static boolean insertRoomInfo(Rortlf sel){
        boolean result = false;
        try {
            makeConn();
            psmt = conn.prepareStatement(insertInfo);

            psmt.setString(1, sel.getRemno1());
            psmt.setString(2, sel.getRemname1());
            psmt.setString(3, sel.getAcreage1());
            psmt.setString(4, sel.getFloor1());
            psmt.setString(5, sel.getPerson1());
            psmt.setString(6, sel.getRegdate1());
            psmt.setString(7, sel.getHighson1());
            psmt.setString(8, sel.getLowson1());


            if (psmt.executeUpdate() > 0)
                result = true;
            else
                result = false;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConn();
        }
        return result;
    }

    public static rortlfWhghl selectInfo(String rno) {
        makeConn();
        rortlfWhghl result=null;
        try {
            psmt = conn.prepareStatement(listOneReslist);
            psmt.setString(1, rno);

            rs = psmt.executeQuery();
            rs.next();

            result = new rortlfWhghl(
                        rs.getString("roomid"),
                        rs.getString("rname"),
                        rs.getString("rsize"),
                        rs.getString("rstair"),
                        rs.getString("rmax"),
                        rs.getString("maxfee"),
                        rs.getString("minfee"),
                        rs.getString("regdate")
                );

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConn();
        }
        return result;
    }

    public static void deleteRoom(String remno2) {
        makeConn();
        try {
            psmt = conn.prepareStatement(deleteRM);
            psmt.setString(1, remno2);

            psmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConn();
        }
    }
}

