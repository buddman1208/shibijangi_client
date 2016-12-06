import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Junseok on 2016. 11. 22..
 * layout_splash
 */
public class MainController implements Initializable {

    @FXML
    Spinner<String> spinner;
    public void initialize(URL location, ResourceBundle resources) {

        SpinnerListModel spinAdapter = new SpinnerListModel(parseType);
        spinner.(spinAdapter);
        panel.add(typeSelecter);
        Dimension selectorSize = new Dimension(120, 30);
        typeSelecter.setPreferredSize(selectorSize);
        typeSelecter.setMinimumSize(selectorSize);
    }
}
