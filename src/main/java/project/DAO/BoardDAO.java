package project.DAO;

import project.model.dPdir;
import project.model.rptlvks;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by java on 2016-09-23.
 */
public class BoardDAO extends config{
    private static final String listBoard="SELECT * FROM board";

    public static List<rptlvks> viewBoard(){
        makeConn();
        List<rptlvks> result = new ArrayList<rptlvks>();

        try {
            psmt = conn.prepareStatement(listBoard);
            rs = psmt.executeQuery();
            while (rs.next()) {
                rptlvks m = new rptlvks(
                        rs.getString("bno"),
                        rs.getString("btitle"),
                        rs.getString("bwriter"),
                        rs.getString("regdate"),
                        rs.getString("BREAD")
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
}
