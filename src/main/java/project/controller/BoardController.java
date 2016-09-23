package project.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import project.DAO.BoardDAO;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by java on 2016-09-23.
 */
public class BoardController implements Initializable {
    @FXML
    TextField tit,rea,wri,date;
    @FXML
    TextArea con,com;
    @FXML
    Button modd,clo;
    boolean first = true;
    private String bdno;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void closeBoard(ActionEvent actionEvent) {
        ((Stage)clo.getScene().getWindow()).close();
    }

    public void clickComment(ActionEvent actionEvent) {
        if(first) {
            com.setEditable(true);
            com.requestFocus();
            first = false;
        }
        else{
            BoardDAO.updateComment(bdno,com.getText());
        }
    }

    public void sendBdno(String bdno){
        this.bdno = bdno;
        ArrayList<String> tmp = BoardDAO.showBoard(bdno);

        tit.setText(tmp.get(0));
        wri.setText(tmp.get(1));
        date.setText(tmp.get(2));
        rea.setText(tmp.get(3));
        con.setText(tmp.get(4));
        com.setText(tmp.get(5));

        tit.setEditable(false);
        wri.setEditable(false);
        date.setEditable(false);
        rea.setEditable(false);
        con.setEditable(false);
        com.setEditable(false);
    }
}
