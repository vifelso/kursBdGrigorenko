package com.controller;

import com.MainApp;
import com.util.MadeAndrei;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;

/**
 * Created by Andrei on 14.05.2016.
 */
@Component
public class MadeAndreiController implements Initializable,ControlledScreen{
    ScreensController screensController;
@Autowired
    MadeAndrei madeAndrei;
    public void home(ActionEvent actionEvent) {
        madeAndrei.stop();
        screensController.setScreen(MainApp.screen1ID);

    }

    @Override
    public void setScreenParent(ScreensController screenPage) {
        screensController=screenPage;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
