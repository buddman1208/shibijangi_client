import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * Created by Junseok on 2016. 11. 18..
 */
public class Launcher extends Application {

    ArrayList<String> arrayList = new ArrayList<String>();

    public static int HEIGHT = 800;
    public static int WIDTH = 480;
    public static Launcher launcher;
    public static Stage primaryStage;
    public static int SPLASH = 0;
    public static int LOGIN = 1;
    public static int REGISTER = 2;
    public static int INGAME = 3;
    public static int GAME_OVER = 4;
    public static String[] type = {"main.fxml", "login.fxml", "register.fxml", "ingame.fxml", "gameover.fxml"};

    public void start(Stage primaryStage) throws Exception {
        this.launcher = this;
        this.primaryStage = primaryStage;
        Parent parent = FXMLLoader.load(getClass().getResource("main.fxml"));
        Scene scene = new Scene(parent, 480, 800);
        primaryStage.setTitle("안녕");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void changeScene(int sceneType) {
        if (sceneType > type.length) return;
        Parent newParent = null;
        try {
            newParent = FXMLLoader.load(launcher.getClass().getResource(type[sceneType]));
            Scene newScene = new Scene(newParent, WIDTH, HEIGHT);
            primaryStage.setScene(newScene);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public static void main(String args[]) {
        launch(args);
    }
}