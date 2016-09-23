package project.controller;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import project.DAO.*;
import project.model.*;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by java on 2016-09-19.
 */
public class MainController implements Initializable {
    @FXML
    ComboBox combo,combo2,combo3;
    @FXML
    TextField input,input2;
    @FXML
    TabPane customer,room,reservation,board;
    @FXML
    Pane welcome;
    @FXML
    Button change;
    @FXML
    DatePicker first,second;
    @FXML
    Label timebar;

    private int day,month,year;

    @FXML
    TableView utable,ctable,mtable;
    @FXML
    TableColumn cno1,name1,level,mileage,available,expire,expiredate;
    @FXML
    TableColumn cno2,name2,resno1,room1,howPerson2,PayMent2;
    private ObservableList<akdlfflwl> mlist = FXCollections.observableArrayList();

    private ObservableList<dldydgusghkd> ulist = FXCollections.observableArrayList();

    @FXML
    TableColumn no,cname,cid,birthday,email,phoneno,cregdate;
    private ObservableList<rhror> clist = FXCollections.observableArrayList();

    //예약약
   @FXML private TableView reserv;
    @FXML private TableColumn resno,resname,resroom,checkIn,checkOut,payMent,damDang;
    private ObservableList<dPdir> reslist = FXCollections.observableArrayList();

    //남으방
    @FXML private TableView remainder;
    @FXML private TableColumn remname,remroom,person,Acreage,roomPay,damDang2;
    private ObservableList<dPdir2> remlist = FXCollections.observableArrayList();

    //객실
    @FXML private TableView rortlf;
    @FXML private TableColumn remno1,remname1,Acreage1,floor1,person1,lowson1,highson1,regdate1;
    private ObservableList<Rortlf> rortlf1 = FXCollections.observableArrayList();

    //객실조회
    @FXML private TableView rortlfwhghl;
    @FXML private TableColumn remno2,remname2,Acreage2,floor2,person2,lowson2,highson2,regdate2;
    private ObservableList<rortlfWhghl> rortlf2 = FXCollections.observableArrayList();

    //게시판
    @FXML private TableView rptlvks;  //bdtv
    @FXML private TableColumn bdno, bdtitle, bdname, bddate, bdread;
    private ObservableList<rptlvks> rptlvka1 = FXCollections.observableArrayList();
    //bdlist

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Calendar c = Calendar.getInstance();
        c.setTime( new Date() );
        year =  c.get(Calendar.YEAR) ;
        month =  c.get(Calendar.MONTH) + 1 ;
        day =  c.get(Calendar.DAY_OF_MONTH) ;

        Thread task = new Thread(() -> {
            SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd a HH:mm:ss");

            while (true) {
                String strTime = sdf.format(new Date());
                Platform.runLater(() -> {
                    timebar.setText(strTime);
                });

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        task.setDaemon(true);
        task.start();

        {
            no.setCellValueFactory(new PropertyValueFactory<rhror, String>("no"));
            cname.setCellValueFactory(new PropertyValueFactory<rhror, String>("name"));
            cid.setCellValueFactory(new PropertyValueFactory<rhror, String>("cid"));
            birthday.setCellValueFactory(new PropertyValueFactory<rhror, String>("birthday"));
            email.setCellValueFactory(new PropertyValueFactory<rhror, String>("email"));
            phoneno.setCellValueFactory(new PropertyValueFactory<rhror, String>("phoneno"));
            cregdate.setCellValueFactory(new PropertyValueFactory<rhror, String>("cregdate"));
        }

        {
            cno1.setCellValueFactory(new PropertyValueFactory<akdlfflwl, String>("con1"));
            name1.setCellValueFactory(new PropertyValueFactory<akdlfflwl, String>("name1"));
            level.setCellValueFactory(new PropertyValueFactory<akdlfflwl, String>("level"));
            mileage.setCellValueFactory(new PropertyValueFactory<akdlfflwl, String>("mileage"));
            available.setCellValueFactory(new PropertyValueFactory<akdlfflwl, String>("available"));
            expire.setCellValueFactory(new PropertyValueFactory<akdlfflwl, String>("expire"));
            expiredate.setCellValueFactory(new PropertyValueFactory<akdlfflwl, String>("expiredate"));
        }
        {
            resno.setCellValueFactory(new PropertyValueFactory<dPdir, String>("resno"));
            resname.setCellValueFactory(new PropertyValueFactory<dPdir, String>("resname"));
            resroom.setCellValueFactory(new PropertyValueFactory<dPdir, String>("resroom"));
            checkIn.setCellValueFactory(new PropertyValueFactory<dPdir, String>("checkIn"));
            checkOut.setCellValueFactory(new PropertyValueFactory<dPdir, String>("checkOut"));
            payMent.setCellValueFactory(new PropertyValueFactory<dPdir, String>("payMent"));
            damDang.setCellValueFactory(new PropertyValueFactory<dPdir, String>("damDang"));
        }

        {
            remname.setCellValueFactory(new PropertyValueFactory<dPdir2, String>("remname"));
            remroom.setCellValueFactory(new PropertyValueFactory<dPdir2, String>("remroom"));
            person.setCellValueFactory(new PropertyValueFactory<dPdir2, String>("person"));
            Acreage.setCellValueFactory(new PropertyValueFactory<dPdir2, String>("Acreage"));
            roomPay.setCellValueFactory(new PropertyValueFactory<dPdir2, String>("roomPay"));
            damDang2.setCellValueFactory(new PropertyValueFactory<dPdir2, String>("damDang2"));
        }

        {
            remno1.setCellValueFactory(new PropertyValueFactory<Rortlf, String>("remno1"));
            remname1.setCellValueFactory(new PropertyValueFactory<Rortlf, String>("remname1"));
            Acreage1.setCellValueFactory(new PropertyValueFactory<Rortlf, String>("Acreage1"));
            floor1.setCellValueFactory(new PropertyValueFactory<Rortlf, String>("floor1"));
            person1.setCellValueFactory(new PropertyValueFactory<Rortlf, String>("person1"));
            lowson1.setCellValueFactory(new PropertyValueFactory<Rortlf, String>("lowson1"));
            highson1.setCellValueFactory(new PropertyValueFactory<Rortlf, String>("highson1"));
            regdate1.setCellValueFactory(new PropertyValueFactory<Rortlf, String>("regdate1"));
        }

        {
            remno2.setCellValueFactory(new PropertyValueFactory<Rortlf, String>("remno2"));
            remname2.setCellValueFactory(new PropertyValueFactory<Rortlf, String>("remname2"));
            Acreage2.setCellValueFactory(new PropertyValueFactory<Rortlf, String>("Acreage2"));
            floor2.setCellValueFactory(new PropertyValueFactory<Rortlf, String>("floor2"));
            person2.setCellValueFactory(new PropertyValueFactory<Rortlf, String>("person2"));
            lowson2.setCellValueFactory(new PropertyValueFactory<Rortlf, String>("lowson2"));
            highson2.setCellValueFactory(new PropertyValueFactory<Rortlf, String>("highson2"));
            regdate2.setCellValueFactory(new PropertyValueFactory<Rortlf, String>("regdate2"));
        }

        {
            bdno.setCellValueFactory(new PropertyValueFactory<rptlvks, String>("bdno"));
            bdtitle.setCellValueFactory(new PropertyValueFactory<rptlvks, String>("bdtitle"));
            bdname.setCellValueFactory(new PropertyValueFactory<rptlvks, String>("bdname"));
            bddate.setCellValueFactory(new PropertyValueFactory<rptlvks, String>("bddate"));
            bdread.setCellValueFactory(new PropertyValueFactory<rptlvks, String>("bdread"));
        }
        {
            cno2.setCellValueFactory(new PropertyValueFactory<dldydgusghkd, String>("cno2"));
            name2.setCellValueFactory(new PropertyValueFactory<dldydgusghkd, String>("name2"));
            resno1.setCellValueFactory(new PropertyValueFactory<dldydgusghkd, String>("resno1"));
            room1.setCellValueFactory(new PropertyValueFactory<dldydgusghkd, String>("room1"));
            howPerson2.setCellValueFactory(new PropertyValueFactory<dldydgusghkd, String>("howPerson2"));
            PayMent2.setCellValueFactory(new PropertyValueFactory<dldydgusghkd, String>("payMent2"));

        }

        ObservableList<String> comboList = FXCollections.observableArrayList("이름","아이디","전화번호");
        combo.setItems(comboList);


        ObservableList<String> combo2List = FXCollections.observableArrayList("이름","층수","최대인원");
        combo2.setItems(combo2List);

        ObservableList<String> combo3List = FXCollections.observableArrayList("작성자","제목");
        combo3.setItems(combo3List);
    }

    public void setOnCustomer(Event event) {
        customer.setVisible(true);
        room.setVisible(false);
        reservation.setVisible(false);
        board.setVisible(false);
        welcome.setVisible(false);

        List<rhror> cs = CustomDAO.listCustom();

        clist.clear();
        for(rhror m:cs){
            clist.add(m);
        }

        ctable.setItems(clist);
    }

    public void setOnCustomer(String cname) {
        List<rhror> cs = CustomDAO.viewsearchCustom("이름", cname);
        clist.clear();
        for(rhror m:cs){
            clist.add(m);
        }

        String cno = CustomDAO.searchCno(cname);

        ctable.setItems(clist);
        List<akdlfflwl> bds = (List<akdlfflwl>) CustomDAO.mviewCustom(cno);
        mlist.clear();
        for (akdlfflwl mc : bds)
            mlist.add(mc);
        mtable.setItems(mlist);

        List<dldydgusghkd> bd =(List<dldydgusghkd>)CustomDAO.uviewCustome(cno);
        ulist.clear();
        for(dldydgusghkd uc : bd)
            ulist.add(uc);
        utable.setItems(ulist);


        customer.setVisible(true);
        room.setVisible(false);
        reservation.setVisible(false);
        board.setVisible(false);
        welcome.setVisible(false);
    }

    public void setOnRoom(Event event) {
        customer.setVisible(false);
        room.setVisible(true);
        reservation.setVisible(false);
        board.setVisible(false);
        welcome.setVisible(false);

        List<Rortlf> bds = RoomDAO.viewRoomInfo();

        rortlf1.clear();
        for(Rortlf tmp : bds)
            rortlf1.add(tmp);

        rortlf.setItems(rortlf1);

        List<rortlfWhghl> bds2 = RoomDAO.viewRoomReg();

        rortlf2.clear();
        for(rortlfWhghl tmp : bds2)
            rortlf2.add(tmp);

        rortlfwhghl.setItems(rortlf2);
    }

    public void setOnReservation(Event event) {
        customer.setVisible(false);
        room.setVisible(false);
        reservation.setVisible(true);
        board.setVisible(false);
        welcome.setVisible(false);

        List<dPdir> bds = ResDAO.viewReslist();

        reslist.clear();
        for(dPdir tmp : bds)
            reslist.add(tmp);
        reserv.setItems(reslist);
    }

    public void setOnBoard(Event event) {
        customer.setVisible(false);
        room.setVisible(false);
        reservation.setVisible(false);
        board.setVisible(true);
        welcome.setVisible(false);

        List<rptlvks> bds = BoardDAO.viewBoard();

        rptlvks.setItems(rptlvka1);

        rptlvka1.clear();
        for(rptlvks tmp : bds)
            rptlvka1.add(tmp);

        rptlvks.setItems(rptlvka1);
    }

        public void clickHome(Event event) {
        customer.setVisible(false);
        room.setVisible(false);
        reservation.setVisible(false);
        board.setVisible(false);
        welcome.setVisible(true);
    }

    public void oneDay(ActionEvent event) {

        first.setValue(LocalDate.of(year, month, day));
        second.setValue(LocalDate.of(year, month, day));
    }

    public void week(ActionEvent event) {
        int day7 = day + 7;
        first.setValue(LocalDate.of(year, month, day));
        second.setValue(LocalDate.of(year, month, day7));
    }

    public void month(ActionEvent event) {
        int month1 = month + 1;
        first.setValue(LocalDate.of(year, month, day));
        second.setValue(LocalDate.of(year, month1, day));
    }



    public void clickResBtn(ActionEvent actionEvent) {
        if(first.getValue() == null || second.getValue() == null){
            Alert err = new Alert(Alert.AlertType.ERROR);
            err.setTitle("ERROR");
            err.setHeaderText("날짜입력 확인");
            err.setContentText("확인하고 싶은 일자를 지정해 주십시오.");
            err.showAndWait();
        }
        else {
            String sdate = first.getValue().toString();
            String edate = second.getValue().toString();


            List<dPdir> bds = ResDAO.viewConditionalReslist(sdate, edate);

            reslist.clear();
            for (dPdir tmp : bds)
                reslist.add(tmp);
            reserv.setItems(reslist);

            List<dPdir2> bds2 = ResDAO.viewExtraReslist(sdate, edate);

            remlist.clear();
            for(dPdir2 tmp : bds2)
                remlist.add(tmp);
            remainder.setItems(remlist);
        }
    }

    public void selectTableRow(MouseEvent event) {
        if(event.getClickCount()==2) {
            dPdir tmp = (dPdir)reserv.getSelectionModel().getSelectedItem();
            setOnCustomer(tmp.getResname());
        }
    }

    public void clickModify(ActionEvent actionEvent) throws Exception{
        int index = rortlf.getSelectionModel().getSelectedIndex();
        // 현재 선택한 행의 데이터를 BoardModel 객체로 받음

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/registration.fxml"));
        Parent root = loader.load();
        RoomMNGController roomctl = loader.getController();
        roomctl.sendData( rortlf1,index);

        Stage prev = (Stage)change.getScene().getWindow();

        Stage stage = new Stage();
        stage.setTitle("방정보 수정하기");
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(prev);
        stage.show();
    }

    public void clickRegister(ActionEvent actionEvent) throws  Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/registration.fxml"));
        Parent root = loader.load();
        RoomMNGController roomctl = loader.getController();
        roomctl.sendData( rortlf1);

        Stage prev = (Stage)change.getScene().getWindow();

        Stage stage = new Stage();
        stage.setTitle("새로운 방 정보 등록하기");
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(prev);
        stage.show();

    }

    public void search(ActionEvent event) {
        TextField searchText = new TextField();
        searchText.getText();

        if (combo.getValue() == null || input.getText() == null) {
            Alert confirm = new Alert(Alert.AlertType.INFORMATION);
            confirm.setTitle("고객 검색");
            confirm.setHeaderText(null);
            confirm.setContentText("검색어를 입력하세요");
            ButtonType nobtn = new ButtonType("확 인", ButtonBar.ButtonData.CANCEL_CLOSE);
            confirm.getButtonTypes().setAll(nobtn);

            String text = confirm.showAndWait().get().getText();

            if (text.equals("확 인"))
                nobtn = ButtonType.CANCEL;
        } else {
            String cb = combo.getValue().toString();
            String ip = input.getText().toString();

            List<rhror> bds = CustomDAO.viewsearchCustom(cb, ip);

            clist.clear();
            for (rhror tmp : bds)
                clist.add(tmp);
            ctable.setItems(clist);

            mlist.clear();
            mtable.setItems(mlist);

            ulist.clear();
            utable.setItems(ulist);
        }
    }

    public void totview(ActionEvent event) {

        List<rhror> bds = CustomDAO.listCustom();

        clist.clear();
        for (rhror tmp : bds)
            clist.add(tmp);
        ctable.setItems(clist);

    }

    public void delete(ActionEvent event) {

        Alert confirm = new Alert(Alert.AlertType.WARNING);
        confirm.setTitle("고객정보 삭제하기");
        confirm.setHeaderText("");
        confirm.setContentText("정말로 삭제하시겠습니까?");

        ButtonType okbtn = new ButtonType("삭제",ButtonBar.ButtonData.OK_DONE);
        ButtonType nobtn = new ButtonType("취소",ButtonBar.ButtonData.CANCEL_CLOSE);
        confirm.getButtonTypes().setAll(okbtn,nobtn);

        String text = confirm.showAndWait().get().getText();
        //클릭한 버튼에 씌여진 문자열을 알아냄
        if(text.equals("삭제")){
            int num = ctable.getSelectionModel().getSelectedIndex();
            //선택한 행번호 알아냄
            String cno = clist.get(num).getNo();
            //선택한 행의 글번호 알아냄

            clist.remove(num);
            //테이블뷰에서 선택한 행 제거

            CustomDAO.deleteCustom(cno);
            //테이블에서 선택한 행 삭제
        }

    }

    public void modify(ActionEvent event) throws Exception{


        /*if (ctable.) {
            Alert confirm = new Alert(Alert.AlertType.INFORMATION);
            confirm.setTitle("고객 수정");
            confirm.setHeaderText(null);
            confirm.setContentText("수정할 내역을 선택하세요!!!");
            ButtonType nobtn = new ButtonType("확 인", ButtonBar.ButtonData.CANCEL_CLOSE);
            confirm.getButtonTypes().setAll(nobtn);

            String text = confirm.showAndWait().get().getText();

            if (text.equals("확 인"))
                nobtn = ButtonType.CANCEL;
        } else {
            int num = ctable.getSelectionModel().getSelectedIndex();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Cmodify.fxml"));
            Parent root = loader.load();

            CmodifyController c = loader.getController();
            c.sendData(clist, num);

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("고객정보 수정하기");

            stage.show();

        }
*/

        int num = ctable.getSelectionModel().getSelectedIndex();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Cmodify.fxml"));
        Parent root = loader.load();

        CmodifyController c = loader.getController();
        c.sendData(clist, num);

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("고객정보 수정하기");

        stage.show();


    }


    public void click(MouseEvent event) {
        int tmp = ctable.getSelectionModel().getSelectedIndex();
        String cno = clist.get(tmp).getNo();

        List<akdlfflwl> bds = (List<akdlfflwl>) CustomDAO.mviewCustom(cno);
        mlist.clear();
        for (akdlfflwl mc : bds)
            mlist.add(mc);
        mtable.setItems(mlist);

        List<dldydgusghkd> bd =(List<dldydgusghkd>)CustomDAO.uviewCustome(cno);
        ulist.clear();
        for(dldydgusghkd uc : bd)
            ulist.add(uc);
        utable.setItems(ulist);

    }


    public void showRoomInfo(MouseEvent event) throws Exception{
        if(event.getClickCount()==2) {
            rortlfWhghl tmp = (rortlfWhghl)rortlfwhghl.getSelectionModel().getSelectedItem();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/roominfo.fxml"));
            Parent root = loader.load();

            RoomInfoController roomctl = loader.getController();
            roomctl.sendData(tmp.getRemno2());

            Stage prev = (Stage)rortlfwhghl.getScene().getWindow();

            Stage stage = new Stage();
            stage.setTitle("방정보 상세보기");
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.centerOnScreen();
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(prev);
            stage.show();

        }
    }

    public void search2(ActionEvent event) {
        TextField searchText = new TextField();
        searchText.getText();

        if (combo2.getValue() == null || input2.getText() == null) {
            Alert confirm = new Alert(Alert.AlertType.ERROR);
            confirm.setTitle("객실 검색");
            confirm.setHeaderText(null);
            confirm.setContentText("검색어를 입력하세요");
            ButtonType nobtn = new ButtonType("확 인", ButtonBar.ButtonData.CANCEL_CLOSE);
            confirm.getButtonTypes().setAll(nobtn);

            String text = confirm.showAndWait().get().getText();

            if (text.equals("확 인"))
                nobtn = ButtonType.CANCEL;
        } else {
            String cb2 = combo2.getValue().toString();
            String ip2 = input2.getText().toString();

            List<rortlfWhghl> bds = RoomscDAO.viewsearchCustom(cb2, ip2);

            rortlf2.clear();
            for (rortlfWhghl ror : bds)
                rortlf2.add(ror);
            rortlfwhghl.setItems(rortlf2);
       }
    }

    public void clickBoard(MouseEvent event) {
        if(event.getClickCount()==2) {
            rptlvks tmp = (rptlvks)rptlvks.getSelectionModel().getSelectedItem();
            System.out.println(tmp.getBdtitle());
        }
    }
}
