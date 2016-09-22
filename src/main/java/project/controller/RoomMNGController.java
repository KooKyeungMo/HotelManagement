package project.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import project.DAO.RoomDAO;
import project.model.Rortlf;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

/**
 * Created by java on 2016-09-21.
 */
public class RoomMNGController implements Initializable{
    @FXML
    private TextField roomno,roomname,roomarea,stair,ningen,minrate,maxrate,regdate,photoadd;
    @FXML
    private Label title;
    @FXML
    private Button regist;

    private boolean mod = false;
    ObservableList<Rortlf> list;
    int idx;

    Rortlf sel = null;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String format = "YYYY-MM-dd";
        Date today = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        regdate.setText(sdf.format((today)));
        regdate.setEditable(false);
    }

    public void clickOKBtn(ActionEvent actionEvent) {
        if(mod){
            Rortlf tmp = new Rortlf(roomno.getText(),roomname.getText(),roomarea.getText(),stair.getText(),ningen.getText(),minrate.getText(),maxrate.getText(),sel.getRegdate1());
            list.set(idx,tmp);
            if(RoomDAO.updateRoomInfo(tmp)) {
                Stage thisOne = (Stage) regist.getScene().getWindow();
                thisOne.close();
            }
        }
        else{
            Rortlf tmp = new Rortlf(roomno.getText(),roomname.getText(),roomarea.getText(),stair.getText(),ningen.getText(),minrate.getText(),maxrate.getText(),regdate.getText());
            list.add(tmp);
            if(RoomDAO.insertRoomInfo(tmp)){
                Stage thisOne = (Stage) regist.getScene().getWindow();
                thisOne.close();
            }
        }
    }

    public void clickCancelBtn(ActionEvent actionEvent) {
        Stage thisOne = (Stage) regist.getScene().getWindow();
        thisOne.close();
    }

    public void sendData(ObservableList<Rortlf> list ,int idx) {
        mod = true;
        title.setText("*  객실수정  *");
        this.list = list;
        this.idx = idx;
        sel = list.get(idx);

        roomarea.setText(sel.getAcreage1());
        roomno.setText(sel.getRemno1());
        roomname.setText(sel.getRemname1());
        stair.setText(sel.getFloor1());
        ningen.setText(sel.getPerson1());
        minrate.setText(sel.getLowson1());
        maxrate.setText(sel.getHighson1());
        /*photoadd.setText(sel.get);*/

        roomno.setEditable(false);
    }
    public void sendData(ObservableList<Rortlf> list) {
        this.list = list;
    }

}
