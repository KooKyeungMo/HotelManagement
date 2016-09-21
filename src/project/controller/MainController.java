package project.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import project.model.*;

import java.net.URL;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

/**
 * Created by java on 2016-09-19.
 */
public class MainController implements Initializable {
    @FXML
    TabPane customer,room,reservation,board,stats;
    @FXML
    Pane welcome;

    @FXML DatePicker first;
    @FXML DatePicker second;
    private int day;
    private int month;
    private int year;


    @FXML private TableView reserv;
    @FXML private TableColumn resno,resname,resroom,checkIn,checkOut,payMent,damDang,howPerson;
    private ObservableList<dPdir> reslist = FXCollections.observableArrayList();


    @FXML private TableView remainder;
    @FXML private TableColumn remname,remroom,person,Acreage,roomPay,damDang2;
    private ObservableList<dPdir2> remlist = FXCollections.observableArrayList();

    @FXML private TableView rortlf;
    @FXML private TableColumn remno1,remname1,Acreage1,floor1,person1,lowson1,highson1,regdate1;
    private ObservableList<Rortlf> rortlf1 = FXCollections.observableArrayList();

    @FXML private TableView rortlfwhghl;
    @FXML private TableColumn remno2,remname2,Acreage2,floor2,person2,lowson2,highson2,regdate2;
    private ObservableList<rortlfWhghl> rortlf2 = FXCollections.observableArrayList();

    @FXML private TableView ctable;
    @FXML private TableColumn no, name, cid, birthday, phoneno, email, cregdate;
    private ObservableList<rhror> rhror = FXCollections.observableArrayList();

    @FXML private TableView mtable;
    @FXML private TableColumn cno1, name1, level, mileage, available, expire, expiredate;
    private ObservableList<akdlfflwl> akdlfflwl = FXCollections.observableArrayList();

    @FXML private TableView utable;
    @FXML private TableColumn cno2, name2, resno1, room1, howPerson2, payMent2;
    private ObservableList<dldydgusghkd> dldydgusghkd = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Calendar c = Calendar.getInstance();
        c.setTime( new Date() );
        year =  c.get(Calendar.YEAR) ;
        month =  c.get(Calendar.MONTH) + 1 ;
        day =  c.get(Calendar.DAY_OF_MONTH) ;

        {
            resno.setCellValueFactory(new PropertyValueFactory<dPdir, String>("resno"));
            resname.setCellValueFactory(new PropertyValueFactory<dPdir, String>("resname"));
            resroom.setCellValueFactory(new PropertyValueFactory<dPdir, String>("resroom"));
            checkIn.setCellValueFactory(new PropertyValueFactory<dPdir, String>("checkIn"));
            checkOut.setCellValueFactory(new PropertyValueFactory<dPdir, String>("checkOut"));
            payMent.setCellValueFactory(new PropertyValueFactory<dPdir, String>("payMent"));
            damDang.setCellValueFactory(new PropertyValueFactory<dPdir, String>("damDang"));
            howPerson.setCellValueFactory(new PropertyValueFactory<dPdir, String>("howPerson"));
        }

        {
            remname.setCellValueFactory(new PropertyValueFactory<dPdir, String>("remname"));
            remroom.setCellValueFactory(new PropertyValueFactory<dPdir, String>("remroom"));
            person.setCellValueFactory(new PropertyValueFactory<dPdir, String>("person"));
            Acreage.setCellValueFactory(new PropertyValueFactory<dPdir, String>("Acreage"));
            roomPay.setCellValueFactory(new PropertyValueFactory<dPdir, String>("roomPay"));
            damDang2.setCellValueFactory(new PropertyValueFactory<dPdir, String>("damDang2"));
        }

        reslist.add(new dPdir("1", "예약 고객", "예약된 방", "2016-09-21", "2016-09-25", "결제 진행중...", "최두현", "3명"));

        remlist.add(new dPdir2("남은 객실 이름", "20", "2~3명", "30평", "170,000원", "최두현"));

        reserv.setItems(reslist);
        remainder.setItems(remlist);

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

        rortlf1.add(new Rortlf("1", "객실 이름", "객실 면적", "3층", "2~3명", "120,000원", "170,000원", "2016-09-21"));

        rortlf2.add(new rortlfWhghl("1", "객실 이름", "객실 면적", "3층", "2~3명", "120,000원", "170,000원", "2016-09-21"));

        rortlf.setItems(rortlf1);
        rortlfwhghl.setItems(rortlf2);

        {
            no.setCellValueFactory(new PropertyValueFactory<rhror, String>("no"));
            name.setCellValueFactory(new PropertyValueFactory<rhror, String>("name"));
            cid.setCellValueFactory(new PropertyValueFactory<rhror, String>("cid"));
            birthday.setCellValueFactory(new PropertyValueFactory<rhror, String>("birthday"));
            phoneno.setCellValueFactory(new PropertyValueFactory<rhror, String>("phoneno"));
            email.setCellValueFactory(new PropertyValueFactory<rhror, String>("email"));
            cregdate.setCellValueFactory(new PropertyValueFactory<rhror, String>("cregdate"));
        }

        {
            cno1.setCellValueFactory(new PropertyValueFactory<akdlfflwl, String>("cno1"));
            name1.setCellValueFactory(new PropertyValueFactory<akdlfflwl, String>("name1"));
            level.setCellValueFactory(new PropertyValueFactory<akdlfflwl, String>("level"));
            mileage.setCellValueFactory(new PropertyValueFactory<akdlfflwl, String>("mileage"));
            available.setCellValueFactory(new PropertyValueFactory<akdlfflwl, String>("available"));
            expire.setCellValueFactory(new PropertyValueFactory<akdlfflwl, String>("expire"));
            expiredate.setCellValueFactory(new PropertyValueFactory<akdlfflwl, String>("expiredate"));
        }

        {
            cno2.setCellValueFactory(new PropertyValueFactory<dldydgusghkd, String>("cno2"));
            name2.setCellValueFactory(new PropertyValueFactory<dldydgusghkd, String>("name2"));
            resno1.setCellValueFactory(new PropertyValueFactory<dldydgusghkd, String>("resno1"));
            room1.setCellValueFactory(new PropertyValueFactory<dldydgusghkd, String>("room1"));
            howPerson2.setCellValueFactory(new PropertyValueFactory<dldydgusghkd, String>("howPerson2"));
            payMent2.setCellValueFactory(new PropertyValueFactory<dldydgusghkd, String>("payMent2"));
        }

        rhror.add(new rhror("1", "이름", "아이디", "생년월일", "전화번호", "이메일", "가입일"));

        akdlfflwl.add(new akdlfflwl("1", "이름", "등급", "적립금", "사용가능 적립금", "소멸예정 적립금", "소멸예정일"));

        dldydgusghkd.add(new dldydgusghkd("1", "이름", "예약번호", "객실명", "이용객수", "결제현황"));

        ctable.setItems(rhror);
        mtable.setItems(akdlfflwl);
        utable.setItems(dldydgusghkd);

    }


    public void setOnCustomer(Event event) {
        System.out.println("고객");
        customer.setVisible(true);
        room.setVisible(false);
        reservation.setVisible(false);
        board.setVisible(false);
        stats.setVisible(false);
        welcome.setVisible(false);
    }

    public void setOnRoom(Event event) {
        System.out.println("객실");
        customer.setVisible(false);
        room.setVisible(true);
        reservation.setVisible(false);
        board.setVisible(false);
        stats.setVisible(false);
        welcome.setVisible(false);
    }

    public void setOnReservation(Event event) {
        System.out.println("예약");
        customer.setVisible(false);
        room.setVisible(false);
        reservation.setVisible(true);
        board.setVisible(false);
        stats.setVisible(false);
        welcome.setVisible(false);
    }

    public void setOnBoard(Event event) {
        System.out.println("게시판");
        customer.setVisible(false);
        room.setVisible(false);
        reservation.setVisible(false);
        board.setVisible(true);
        stats.setVisible(false);
        welcome.setVisible(false);
    }

    public void setOnStats(Event event) {
        System.out.println("통계");
        customer.setVisible(false);
        room.setVisible(false);
        reservation.setVisible(false);
        board.setVisible(false);
        stats.setVisible(true);
        welcome.setVisible(false);
    }

    public void clickHome(Event event) {
        customer.setVisible(false);
        room.setVisible(false);
        reservation.setVisible(false);
        board.setVisible(false);
        stats.setVisible(false);
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

}
