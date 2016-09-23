package project.DAO;

import project.model.akdlfflwl;
import project.model.dldydgusghkd;
import project.model.rhror;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by java on 2016-09-20.
 */
public class CustomDAO {
    //데이터 접속정보
    private static String DRV = "oracle.jdbc.OracleDriver";
    private static String URL = "jdbc:oracle:thin:@//192.168.0.35:1521/xe";
    private static String USR = "YEAAAH";
    private static String PWD = "YEAAAH";
    private static String uviewCustom = " select c.cno, c.cname, r.resid, o.rname, r.howperson, r.payment from customer c join reservation r on (c.cno=r.cno) join room o on (r.roomid=o.roomid) AND c.cno=? ";


    // SQL 질의문
    private static String newCustom=" insert into CUSTOMER (cno,cname,CUSID,birthday,pnum,email) values(?,?,?,?,?) ";
    private static String listCustom = " select cno,cname,CUSID,birthday,pnum,email,regdate from CUSTOMER ORDER by cname ASC ";
    private static String viewCustom = " select * from CUSTOMER where cno = ? ORDER by cname ASC" ;
    private static String deleteCustom = " delete from CUSTOMER where cno = ? ";
    private static String updateCustom = " update CUSTOMER set cname = ?, birthday = to_date(?,'YYYY-MM-DD HH24:MI:SS'), pnum = ?, email = ?, regdate = sysdate where cno=?";
    private final static String searchCustom1 = "select * from CUSTOMER where cname = ? ";
    private final static String searchCustom2 = "select * from CUSTOMER where cusid = ? ";
    private final static String searchCustom3 = "select * from CUSTOMER where pnum = ? ";
    private static String mviewCustom = " select cno, cname, grade, mileage, mileage, dis_mileage, dis_date from CUSTOMER where cno = ? " ;
    private static String schCNO = "select * from customer where cname = ? ORDER by cname ASC" ;
    //private static String lastOne =" select cno,cname,CUSID,birthday,pnum,email,regdate from CUSTOMER" +
    //        " where cno =(select max(cno) from CUSTOMER) ";




    //오라클 데이터베이스 접속용 메서드
    public static Connection openConn(){
        Connection conn = null;
        try {
            Class.forName(DRV);
            conn = DriverManager.getConnection(URL, USR, PWD);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return conn;
    }

    //오라클 데이터베이스 접속 해제용 메서드
    public static void closeConn(Connection c, PreparedStatement p, ResultSet r){
        if(r!=null)try{r.close(); r=null;}catch (Exception e){}
        if(p!=null)try{p.close(); p=null;}catch (Exception e){}
        if(c!=null)try{c.close(); r=null;}catch (Exception e){}
    }

    //고객등록
   public static void newCustom(rhror cs){
        //데이터베이스 관련 변수
        Connection conn = null;
        PreparedStatement pstmt = null;

        try{
            Class.forName(DRV);
            conn = CustomDAO.openConn();
            pstmt = conn.prepareStatement(newCustom);

            pstmt.setString(1,cs.getName());
            pstmt.setString(2,cs.getCid());
            pstmt.setString(3,cs.getBirthday());
            pstmt.setString(4,cs.getPhoneno());
            pstmt.setString(5,cs.getEmail());

            pstmt.executeUpdate();

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            closeConn(conn,pstmt,null);
        }

    }

    public static List<dldydgusghkd> uviewCustome(String cno) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<dldydgusghkd> result = new ArrayList<>();

        try{
            conn = openConn();

            pstmt = conn.prepareStatement(uviewCustom);
            pstmt.setString(1,cno);
            rs=pstmt.executeQuery();

            while(rs.next()){
                dldydgusghkd tmp = new dldydgusghkd(rs.getString("cno"),rs.getString("cname"),
                        rs.getString("resid"),rs.getString("rname"),rs.getString("howperson"),
                        rs.getString("payment"));

                result.add(tmp);
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            closeConn(conn,pstmt,rs);
        }

        return result;
    }

    //고객 목록 보기
    public  static List<rhror> listCustom(){
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;

        List<rhror> result = new ArrayList<>();

        try{
            conn = openConn();
            pstmt =conn.prepareStatement(listCustom);
            rs=pstmt.executeQuery();

            while (rs.next()){
                rhror m =new rhror(rs.getString("cno"),rs.getString("cname"),
                        rs.getString("cusid"),rs.getString("birthday").substring(0,10),rs.getString("pnum"),
                        rs.getString("email"),rs.getString("regdate").substring(0,10));

                result.add(m);
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            closeConn(conn,pstmt,rs);
        }
        return result;
    }


    public static rhror viewCustom(String cno){
        //데이터베이스 관련 변수
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        rhror result = null;

        try{
            conn = openConn();

            pstmt = conn.prepareStatement(viewCustom);
            pstmt.setString(1,cno);
            rs=pstmt.executeQuery();

            while(rs.next()){
                result = new rhror(rs.getString("cno"),rs.getString("cname"),
                        rs.getString("cusid"),rs.getString("birthday").substring(0,10),rs.getString("pnum"),
                        rs.getString("email"),rs.getString("regdate").substring(0,10));

            }

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            closeConn(conn,pstmt,rs);
        }

        return result;
    }


    //고객 수정하기
    public  static void updateCustom(rhror cs){
        //데이터베이스 관련 변수
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = openConn();
            pstmt=conn.prepareStatement(updateCustom);


            pstmt.setString(1,cs.getName());
            pstmt.setString(2,cs.getBirthday());
            pstmt.setString(3,cs.getPhoneno());
            pstmt.setString(4,cs.getEmail());
            pstmt.setString(5,cs.getNo());

            pstmt.executeUpdate();

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            closeConn(conn,pstmt,null);
        }

    }



    //고객 삭제
    public  static void  deleteCustom (String cno){
        //데이터베이스 관련 변수
        Connection conn = null;
        PreparedStatement pstmt = null;

        try{
            conn = openConn();
            pstmt = conn.prepareStatement(deleteCustom);
            pstmt.setString(1,cno);
            pstmt.executeUpdate();

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            closeConn(conn,pstmt,null);
        }


    }

    public static List<rhror> viewsearchCustom(String c, String i) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<rhror> result = new ArrayList<rhror>();

        try{
            conn = openConn();

            if(c.equals("이름"))
                pstmt = conn.prepareStatement(searchCustom1);
            else if(c.equals("아이디"))
                pstmt = conn.prepareStatement(searchCustom2);
            else if(c.equals("전화번호"))
                pstmt = conn.prepareStatement(searchCustom3);

            pstmt.setString(1,i);

            rs=pstmt.executeQuery();

            while(rs.next()){
                rhror m = new rhror(rs.getString("cno"),rs.getString("cname"),
                        rs.getString("cusid"),rs.getString("birthday"),rs.getString("pnum"),
                        rs.getString("email"),rs.getString("regdate").substring(0,10));
                result.add(m);
            }



        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            closeConn(conn,pstmt,rs);
        }

        return result;
    }

    public static String searchCno(String cname){
        //데이터베이스 관련 변수
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String result = "";

        try{
            conn = openConn();

            pstmt = conn.prepareStatement(schCNO);
            pstmt.setString(1,cname);
            rs=pstmt.executeQuery();

            rs.next();
            result = rs.getString("CNO");
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            closeConn(conn,pstmt,rs);
        }

        return result;
    }

    public static List<akdlfflwl> mviewCustom(String cno){
        //데이터베이스 관련 변수
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<akdlfflwl> result = new ArrayList<akdlfflwl>();

        try{
            conn = openConn();

            pstmt = conn.prepareStatement(mviewCustom);
            pstmt.setString(1,cno);
            rs=pstmt.executeQuery();

            while(rs.next()){
                akdlfflwl tmp = new akdlfflwl(rs.getString("cno"),rs.getString("cname"),
                        rs.getString("grade"),rs.getString("mileage"),rs.getString("mileage"),
                        rs.getString("dis_mileage"),rs.getString("dis_date").substring(0,10));

                result.add(tmp);
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            closeConn(conn,pstmt,rs);
        }

        return result;
    }

   /* //방금 입력한 데이터를 불러와서
    //rhror 객체에 저장
    public static rhror getLastOne() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        rhror model = null;
        try{
            conn = openConn();
            pstmt =conn.prepareStatement(lastOne);
            rs=pstmt.executeQuery();

            while (rs.next()){
                model =new rhror(rs.getString("cno"),rs.getString("cname"),
                        rs.getString("cusid"),rs.getString("birthday"),rs.getString("pnum"),
                        rs.getString("email"),rs.getString("regdate").substring(0,10));
                //조회한 결과들을 rhror 객체로 생성

            }

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            closeConn(conn,pstmt,rs);
        }
        return model;
    }*/
}



