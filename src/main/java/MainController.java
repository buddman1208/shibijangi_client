import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

/**
 * Created by Junseok on 2016. 11. 22..
 * layout_splash
 */
public class MainController implements Initializable {

    double currentUSDFinance = 0.0;
    @FXML
    Spinner<String> spinner;
    @FXML
    javafx.scene.control.Label text;
    @FXML
    TextField textfield;
    @FXML
    javafx.scene.control.Label result;
    @FXML
    TextField retextfield;
    @FXML
    javafx.scene.control.Label reresult;

    public void initialize(URL location, ResourceBundle resources) {
        DatabaseUtils utils = new DatabaseUtils();
        ArrayList<String> getTitle = utils.getFinanceArray(true);
        ArrayList<String> getFinance = utils.getFinanceArray(false);

        currentUSDFinance = Double.parseDouble(getTitle.get(0).replace(",", ""));
        text.setText("현재 USD 달러 환율 : " + getTitle.get(0));
        result.setText("원 -> 달러 환전");
        reresult.setText("달러 -> 원 환전");
        textfield.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent ke) {
                if (ke.getCode().equals(KeyCode.ENTER)) {
                    String text = textfield.getText().toString();
                    try {
                        String resultdouble = String.format("%.5f", Double.parseDouble(text) / currentUSDFinance);
                        result.setText(text + " 원을 USD 달러로 환전하면 " + resultdouble + " 달러 입니다");
                    } catch (Exception e) {
                        result.setText("실수 범위의 수를 입력해주세요!");
                    }
                }
            }
        });
        retextfield.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent ke) {
                if (ke.getCode().equals(KeyCode.ENTER)) {
                    String text = retextfield.getText().toString();
                    try {
                        String resultdouble = String.format("%.5f", Double.parseDouble(text) * currentUSDFinance);
                        reresult.setText(text + " 달러를 원화로 환전하면 " + resultdouble + " 원 입니다");
                    } catch (Exception e) {
                        reresult.setText("실수 범위의 수를 입력해주세요!");
                    }
                }
            }
        });
    }
}
