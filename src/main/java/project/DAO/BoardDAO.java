package project.DAO;

import project.model.dPdir;
import project.model.rortlfWhghl;
import project.model.rptlvks;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by java on 2016-09-23.
 */
public class BoardDAO extends config {
    private static final String listBoard = "SELECT * FROM board";
    private static final String showBoard = "SELECT * FROM board where bno =?";
    private static final String updateBdread = "UPDATE board SET bread = bread+1 where bno =?";
    private static final String viewsearchBd1 = "SELECT * FROM board where bwriter=?";
    private static final String viewsearchBd2 = "SELECT * FROM board where btitle=?";
    private static final String updateCom = "UPDATE board SET commet = ? where bno =?";

    public static List<rptlvks> viewBoard() {
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
                        rs.getString("regdate").substring(0,10),
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


    public static ArrayList<String> showBoard(String bdno) {

        ArrayList<String> result = new ArrayList<>();
        try {
            makeConn();
            psmt = conn.prepareStatement(updateBdread);
            psmt.setString(1, bdno);
            psmt.executeUpdate();
            closeConn();

            makeConn();
            psmt = conn.prepareStatement(showBoard);
            psmt.setString(1, bdno);

            rs = psmt.executeQuery();
            rs.next();

            result.add(rs.getString("btitle"));
            result.add(rs.getString("bwriter"));
            result.add(rs.getString("regdate").substring(0,10));
            result.add(rs.getString("BREAD"));
            result.add(rs.getString("contet"));
            result.add(rs.getString("commet"));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConn();
        }
        return result;
    }

    public static List<rptlvks> viewsearchBd(String c, String i) {
        makeConn();
        List<rptlvks> result = new ArrayList<rptlvks>();

        try {

            if(c.equals("작성자"))
                psmt = conn.prepareStatement(viewsearchBd1);
            else if(c.equals("제목"))
                psmt = conn.prepareStatement(viewsearchBd2);

            psmt.setString(1,i);

            rs = psmt.executeQuery();

            while (rs.next()) {
                rptlvks m = new rptlvks(
                        rs.getString("bno"),
                        rs.getString("btitle"),
                        rs.getString("bwriter"),
                        rs.getString("regdate").substring(0,10),
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

    public static boolean updateComment(String bno,String text) {
        makeConn();
        boolean result = false;

        if(text.trim().equals(""))
            text = "등록된 댓글이 없습니다.";

        try {
            psmt = conn.prepareStatement(updateCom);
            psmt.setString(1,text);
            psmt.setString(2,bno);

            if(psmt.executeUpdate()>0)
                result = true;
            else
                result = false;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConn();
        }

        return result;
    }
}

