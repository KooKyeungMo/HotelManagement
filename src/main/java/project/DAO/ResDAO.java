package project.DAO;

import project.model.dPdir;
import project.model.dPdir2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by java on 2016-09-21.
 */
public class ResDAO extends config {
    private final static String listReslist = "select * from reslist";
    private final static String listCondionallist = "select * from reslist where (chkin between to_date(?,'YYYY-MM-DD-HH') and to_date(?,'YYYY-MM-DD-HH') + 0.99999)" +
            "or (chkouit between to_date(?,'YYYY-MM-DD-HH') and to_date(?,'YYYY-MM-DD-HH') + 0.99999)";
    private final static String listExtrallist = "select * from reservation right outer join room using(roomid) MINUS select * from reservation right outer join room using (roomid) where (chkin between to_date(?,'YYYY-MM-DD-HH') and to_date(?,'YYYY-MM-DD-HH') + 0.99999)" +
            "or (chkouit between to_date(?,'YYYY-MM-DD-HH') and to_date(?,'YYYY-MM-DD-HH') + 0.99999)";


    public static List<dPdir> viewReslist(){
        makeConn();
        List<dPdir> result = new ArrayList<dPdir>();

        try {
            psmt = conn.prepareStatement(listReslist);
            rs = psmt.executeQuery();
            while (rs.next()) {
                dPdir m = new dPdir(
                        rs.getString("RESID"),
                        rs.getString("CNAME"),
                        rs.getString("RNAME"),
                        rs.getString("CHKIN").substring(0, 10),
                        rs.getString("CHKOUIT").substring(0, 10),
                        rs.getString("PAYMENT"),
                        rs.getString("SNAME"),
                        rs.getString("HOWPERSON")
                );
                result.add(m);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConn();
        }

        return result;
    }

    public static List<dPdir> viewConditionalReslist(String s, String e) {
        makeConn();

        List<dPdir> result = new ArrayList<dPdir>();

        try {
            psmt = conn.prepareStatement(listCondionallist);

            psmt.setString(1,s);
            psmt.setString(2,e);
            psmt.setString(3,s);
            psmt.setString(4,e);

            rs = psmt.executeQuery();
            while (rs.next()) {
                dPdir m = new dPdir(
                        rs.getString("RESID"),
                        rs.getString("CNAME"),
                        rs.getString("RNAME"),
                        rs.getString("CHKIN").substring(0, 10),
                        rs.getString("CHKOUIT").substring(0, 10),
                        rs.getString("PAYMENT"),
                        rs.getString("SNAME"),
                        rs.getString("HOWPERSON")
                );
                result.add(m);
            }


        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {

            closeConn();
        }

        return result;
    }

    public static List<dPdir2> viewExtraReslist(String s, String e) {
        makeConn();

        List<dPdir2> result = new ArrayList<dPdir2>();

        try {
            psmt = conn.prepareStatement(listExtrallist);

            psmt.setString(1,s);
            psmt.setString(2,e);
            psmt.setString(3,s);
            psmt.setString(4,e);

            rs = psmt.executeQuery();
            while (rs.next()) {
                dPdir2 m = new dPdir2(
                        rs.getString("RNAME"),
                        "남은객실X",
                        rs.getString("RMAX"),
                        rs.getString("RSIZE"),
                        rs.getString("maxfee"),
                        "담당자X"
                );
                result.add(m);
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            closeConn();
        }

        return result;
    }
}
