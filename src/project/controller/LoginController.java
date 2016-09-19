package project.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by java on 2016-09-19.
 */
public class LoginController implements Initializable {
    @FXML
    Button login;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void clickBtn(ActionEvent actionEvent) {
        try {
            FXMLLoader main = new FXMLLoader(getClass().getResource("../view/MainFrame.fxml"));
            Parent root_main = main.load();

            Stage stage = new Stage();
            stage.setTitle("호텔 관리 프로그램");
            stage.setScene(new Scene(root_main));

            stage.setResizable(false);
            stage.show();

            Stage prev = (Stage)login.getScene().getWindow();
            prev.close();

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
