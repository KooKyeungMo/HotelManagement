import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Date;

/**
 * Created by java on 2016-09-19.
 */
public class HotelMain extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader login = new FXMLLoader(getClass().getResource("/fxml/LoginFrame.fxml"));
        Parent root_login = login.load();

        primaryStage.setTitle("호텔 관리 프로그램 - L O G I N");
        primaryStage.setScene(new Scene(root_login));
        primaryStage.setResizable(false);

        primaryStage.show();
    }

    public static void main(String args[]){
        launch(args);
    }
}
