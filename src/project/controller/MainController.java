package project.controller;

import javafx.application.Platform;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

/**
 * Created by java on 2016-09-19.
 */
public class MainController implements Initializable {
    @FXML
    TabPane customer, room, reservation, board, stats;
    @FXML
    Pane welcome;
    @FXML
    Label timebar;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Thread task = new Thread(() -> {
            SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd a hh:mm:ss");

            while (true) {
                String strTime = sdf.format(new Date());
                Platform.runLater(() ->
                {
                    timebar.setText(strTime);
                });

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        task.setDaemon(true);
        task.start();
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
}
