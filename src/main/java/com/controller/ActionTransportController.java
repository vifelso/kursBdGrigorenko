package com.controller;

import com.MainApp;
import com.model.Transport;
import com.service.TransportService;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Andrei on 14.05.2016.
 */
@Component
public class ActionTransportController implements Initializable,ControlledScreen{
    public Button editTransport;
    @Autowired
    private  MainController mainController;
    public Button addTransport;
    public Button cancel;
    public TextField nameOfTransport;
    @Autowired
    private TransportService transportService;
    ScreensController screensController;



    @Override
    public void setScreenParent(ScreensController screenPage) {
        screensController=screenPage;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void add(ActionEvent actionEvent) {
        Transport transport=new Transport();
        transport.setName(nameOfTransport.getText());
        transportService.add(transport);
        screensController.setScreen(MainApp.screen1ID);

    }

    public void cancel(ActionEvent actionEvent) {
        screensController.setScreen(MainApp.screen1ID);


    }



    public void editTransport(ActionEvent actionEvent) {
        Transport transport= (Transport)mainController.myTable.getSelectionModel().getSelectedItem();
        transport=transportService.getById(transport.getId());
        transport.setName(nameOfTransport.getText());
        transportService.edit(transport);
        screensController.setScreen(MainApp.screen1ID);

    }
}
