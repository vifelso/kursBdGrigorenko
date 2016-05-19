package com;


import com.controller.ScreensController;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;

@Component
public class MainApp extends Application {
    public static String screen1ID = "main";
    public static String screen1File = "/fxml/hello.fxml";
    public static String screen2ID = "actionClient";
    public static String screen2File = "/fxml/actionClient.fxml";
    public static String screen3ID = "actionCountry";
    public static String screen3File = "/fxml/actionCountry.fxml";
    public static String screen4ID = "actionDriver";
    public static String screen4File = "/fxml/actionDriver.fxml";
    public static String screen5ID = "actionTransport";
    public static String screen5File = "/fxml/actionTransport.fxml";
    public static String screen6ID = "actionEmployer";
    public static String screen6File = "/fxml/actionEmployer.fxml";
    public static String screen7ID = "actionHotel";
    public static String screen7File = "/fxml/actionHotel.fxml";
    public static String screen8ID = "actionInsurance";
    public static String screen8File = "/fxml/actionInsurance.fxml";
    public static String screen9ID = "actionTouristVoucher";
    public static String screen9File = "/fxml/actionTouristVoucher.fxml";
    public static String screen10ID = "madeAndrei";
    public static String screen10File = "/fxml/madeAndrei.fxml";

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {


        ScreensController mainContainer = new ScreensController();
        mainContainer.loadScreen(MainApp.screen1ID, MainApp.screen1File);
        mainContainer.loadScreen(MainApp.screen2ID, MainApp.screen2File);
        mainContainer.loadScreen(MainApp.screen3ID, MainApp.screen3File);
        mainContainer.loadScreen(MainApp.screen4ID, MainApp.screen4File);
        mainContainer.loadScreen(MainApp.screen5ID, MainApp.screen5File);
        mainContainer.loadScreen(MainApp.screen6ID, MainApp.screen6File);
        mainContainer.loadScreen(MainApp.screen7ID, MainApp.screen7File);
        mainContainer.loadScreen(MainApp.screen8ID, MainApp.screen8File);
        mainContainer.loadScreen(MainApp.screen9ID, MainApp.screen9File);
        mainContainer.loadScreen(MainApp.screen10ID, MainApp.screen10File);
        mainContainer.setScreen(MainApp.screen1ID);
        Group root = new Group();
        root.getChildren().addAll(mainContainer);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
