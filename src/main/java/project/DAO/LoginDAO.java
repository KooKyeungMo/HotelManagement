package project.DAO;

import project.model.dPdir;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by java on 2016-09-22.
 */
public class LoginDAO extends config{
    private static final String confLogin ="SELECT aid FROM admini WHERE aid = ? and apwd =?";
    public static boolean confirmLogin(String id, String pwd) {
        boolean result = false;

        makeConn();
        try {
            psmt = conn.prepareStatement(confLogin);
            psmt.setString(1,id);
            psmt.setString(2,pwd);

            rs = psmt.executeQuery();

            int x=0;
            while(rs.next())
                x++;

            if(x == 1)
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
