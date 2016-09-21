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
import project.Model.dPdir;

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

    @FXML private TableColumn resno;
    @FXML private TableColumn resname;
    @FXML private TableColumn resroom;
    @FXML private TableColumn checkIn;
    @FXML private TableColumn checkOut;
    @FXML private TableColumn payMent;
    @FXML private TableColumn damDang;
    @FXML private TableColumn remname;
    @FXML private TableColumn remroom;
    @FXML private TableColumn person;
    @FXML private TableColumn Acreage;
    @FXML private TableColumn roomPay;
    @FXML private TableColumn damDang2;

    @FXML private TableView reserv;

    private ObservableList<dPdir> reslist = null;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Calendar c = Calendar.getInstance();
        c.setTime( new Date() );
        year =  c.get(Calendar.YEAR) ;
        month =  c.get(Calendar.MONTH) + 1 ;
        day =  c.get(Calendar.DAY_OF_MONTH) ;

        resno.setCellValueFactory(new PropertyValueFactory<dPdir, String>("resno"));
        resname.setCellValueFactory(new PropertyValueFactory<dPdir, String>("resname"));
        resroom.setCellValueFactory(new PropertyValueFactory<dPdir, String>("resroom"));
        checkIn.setCellValueFactory(new PropertyValueFactory<dPdir, String>("checkIn"));
        checkOut.setCellValueFactory(new PropertyValueFactory<dPdir, String>("checkOut"));
        payMent.setCellValueFactory(new PropertyValueFactory<dPdir, String>("payMent"));
        damDang.setCellValueFactory(new PropertyValueFactory<dPdir, String>("damDang"));

        remname.setCellValueFactory(new PropertyValueFactory<dPdir, String>("remname"));
        remroom.setCellValueFactory(new PropertyValueFactory<dPdir, String>("remroom"));
        person.setCellValueFactory(new PropertyValueFactory<dPdir, String>("person"));
        Acreage.setCellValueFactory(new PropertyValueFactory<dPdir, String>("Acreage"));
        roomPay.setCellValueFactory(new PropertyValueFactory<dPdir, String>("roomPay"));
        damDang2.setCellValueFactory(new PropertyValueFactory<dPdir, String>("damDang2"));

        reslist = FXCollections.observableArrayList();
        reslist.add(new dPdir("1", "예약 고객", "예약된 방", "2016-09-21", "2016-09-25", "결제 진행중...", "최두현"
                , "남은 객실 이름", "20", "2~3명", "30평", "170,000원", "최두현"));

        reserv.setItems( reslist );
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
