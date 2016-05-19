package com.controller;

import com.MainApp;
import com.model.TouristVauchers;
import com.service.TouristVoucherService;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

/**
 * Created by Andrei on 14.05.2016.
 */
@Component
public class ActionTouristVoucherController implements Initializable,ControlledScreen{
    public Button add;
    public Button cancel;
    public TextField idOfEmployer;
    public TextField idOfClient;
    public TextField idOfDriver;
    public TextField idOfHotel;
    public TextField departureDate;
    public TextField arrivalDate;
    public TextField salesDate;
    public TextField cost;
    public Button editTouristvoucher;
    @Autowired
    private TouristVoucherService touristVoucherService;
    ScreensController screensController;
    @Autowired
    private  MainController mainController;
    @Override
    public void setScreenParent(ScreensController screenPage) {
        screensController=screenPage;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void add(ActionEvent actionEvent) throws ParseException {
        TouristVauchers touristVauchers=new TouristVauchers();
        touristVauchers.setIdClient(Integer.parseInt(idOfClient.getText()));
        touristVauchers.setIdEmployer(Integer.parseInt(idOfEmployer.getText()));
        touristVauchers.setIdDriver(Integer.parseInt(idOfDriver.getText()));
        touristVauchers.setIdHotel(Integer.parseInt(idOfHotel.getText()));
        touristVauchers.setCost(Integer.parseInt(cost.getText()));
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = formatter.parse(arrivalDate.getText());
        touristVauchers.setArrivalDate(date);
        Date date1 = formatter.parse(departureDate.getText());
        touristVauchers.setDepartureDate(date1);
        Date date2 = formatter.parse(arrivalDate.getText());
        touristVauchers.setSaleDate(date2);
        touristVoucherService.add(touristVauchers);
        screensController.setScreen(MainApp.screen1ID);

    }

    public void cancel(ActionEvent actionEvent) {
        screensController.setScreen(MainApp.screen1ID);


    }

    public void editTouristvoucher(ActionEvent actionEvent) throws ParseException {
       TouristVauchers touristVauchers= (TouristVauchers)mainController.myTable.getSelectionModel().getSelectedItem();
        touristVauchers=touristVoucherService.getById(touristVauchers.getId());
        touristVauchers.setIdClient(Integer.parseInt(idOfClient.getText()));
        touristVauchers.setIdEmployer(Integer.parseInt(idOfEmployer.getText()));
        touristVauchers.setIdDriver(Integer.parseInt(idOfDriver.getText()));
        touristVauchers.setIdHotel(Integer.parseInt(idOfHotel.getText()));
        touristVauchers.setCost(Integer.parseInt(cost.getText()));
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = formatter.parse(arrivalDate.getText());
        touristVauchers.setArrivalDate(date);
        Date date1 = formatter.parse(departureDate.getText());
        touristVauchers.setDepartureDate(date1);
        Date date2 = formatter.parse(arrivalDate.getText());
        touristVauchers.setSaleDate(date2);
        touristVoucherService.edit(touristVauchers);
        screensController.setScreen(MainApp.screen1ID);

    }
}
