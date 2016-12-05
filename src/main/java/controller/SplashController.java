package controller;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Junseok on 2016. 11. 22..
 * layout_splash
 */
public class SplashController implements Initializable {

    public void initialize(URL location, ResourceBundle resources) {
        new DatabaseUtils();
    }
}
