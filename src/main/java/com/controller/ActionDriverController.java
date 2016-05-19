package com.controller;

import com.MainApp;
import com.model.Drivers;
import com.service.DriversService;
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
public class ActionDriverController implements Initializable,ControlledScreen{
    public TextField idOfTransport;
    public Button editDriver;
    @Autowired
    private  MainController mainController;
    @Autowired
    private DriversService driversService;
    public TextField fullName;
    public TextField address;
    public TextField phone;
    public Button addDriver;
    public Button cancel;
    ScreensController screensController;


    @Override
    public void setScreenParent(ScreensController screenPage) {
        screensController=screenPage;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void addDriver(ActionEvent actionEvent) {
        Drivers driver=new Drivers();
        driver.setFullName(fullName.getText());
        driver.setAddress(address.getText());
        driver.setPhone(phone.getText());
        driver.setIdOfTransport(Integer.parseInt(idOfTransport.getText()));
        driversService.addDriver(driver);
        screensController.setScreen(MainApp.screen1ID);

    }

    public void cancel(ActionEvent actionEvent) {
        screensController.setScreen(MainApp.screen1ID);

    }


    public void editDriver(ActionEvent actionEvent) {
        Drivers driver= (Drivers)mainController.myTable.getSelectionModel().getSelectedItem();
        driver=driversService.getById(driver.getId());
        driver.setFullName(fullName.getText());
        driver.setAddress(address.getText());
        driver.setPhone(phone.getText());
        driver.setIdOfTransport(Integer.parseInt(idOfTransport.getText()));
        driversService.edit(driver);
        screensController.setScreen(MainApp.screen1ID);

    }
}
