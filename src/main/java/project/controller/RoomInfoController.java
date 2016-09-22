package project.controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import project.DAO.RoomDAO;
import project.model.Rortlf;
import project.model.rortlfWhghl;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by java on 2016-09-22.
 */
public class RoomInfoController implements Initializable {
    String no;
    @FXML
    TextField rno,rname,stair,size,person,max,min,regdate;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        rno.setEditable(false);
        rname.setEditable(false);
        stair.setEditable(false);
        size.setEditable(false);
        max.setEditable(false);
        min.setEditable(false);
        regdate.setEditable(false);
    }

    public void sendData(String rno) {
        this.no = rno;

        rortlfWhghl tmp = RoomDAO.selectInfo(rno);

        this.rno.setText(tmp.getRemno2());
        rname.setText(tmp.getRemname2());
        stair.setText(tmp.getFloor2());
        size.setText(tmp.getAcreage2());
        person.setText(tmp.getPerson2());
        max.setText(tmp.getHighson2());
        min.setText(tmp.getLowson2());
        regdate.setText(tmp.getRegdate2().substring(0,10));
    }
}
