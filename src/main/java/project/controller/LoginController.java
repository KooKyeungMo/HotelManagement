package project.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import project.DAO.LoginDAO;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by java on 2016-09-19.
 */
public class LoginController implements Initializable {
    @FXML
    Button login;
    @FXML
    TextField aid,apwd;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void clickBtn(ActionEvent actionEvent) {
        try {
            String id = aid.getText().trim();
            String pwd = apwd.getText().trim();
            if(LoginDAO.confirmLogin(id,pwd)) {
                FXMLLoader main = new FXMLLoader(getClass().getResource("/fxml/MainFrame.fxml"));
                Parent root_main = main.load();

                Stage stage = new Stage();
                stage.setTitle("호텔 관리 프로그램");
                stage.setScene(new Scene(root_main));

                stage.setResizable(false);
                stage.show();

                Stage prev = (Stage) login.getScene().getWindow();
                prev.close();
            }
            else{
                apwd.setText("");
                aid.requestFocus();
                Alert err = new Alert(Alert.AlertType.ERROR);
                err.setTitle("ERROR");
                err.setHeaderText("로그인 정보 확인");
                err.setContentText("ID와 비밀번호를 확인해주세요.");
                err.showAndWait();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
