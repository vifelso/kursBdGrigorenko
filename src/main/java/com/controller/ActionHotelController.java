package com.controller;

import com.MainApp;
import com.model.Hotels;
import com.service.HotelsService;
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
public class ActionHotelController implements Initializable,ControlledScreen{
    @Autowired
    private  MainController mainController;
    public TextField idCountry;
    public TextField hotelName;
    public TextField address;
    public TextField phone;
    public Button add;
    public Button cancel;
    public Button editHotel;
    @Autowired
    private HotelsService hotelsService;
    ScreensController screensController;


    @Override
    public void setScreenParent(ScreensController screenPage) {
        screensController=screenPage;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void add(ActionEvent actionEvent) {
        Hotels hotel=new Hotels();
        hotel.setHotelName(hotelName.getText());
        hotel.setAddress(address.getText());
        hotel.setPhone(phone.getText());
        hotel.setIdCountry(Integer.parseInt(idCountry.getText()));
        hotelsService.add(hotel);
        screensController.setScreen(MainApp.screen1ID);

    }

    public void cancel(ActionEvent actionEvent) {
        screensController.setScreen(MainApp.screen1ID);
    }

    public void editHotel(ActionEvent actionEvent) {
        Hotels hotel= (Hotels)mainController.myTable.getSelectionModel().getSelectedItem();
        hotel=hotelsService.getById(hotel.getId());
        hotel.setHotelName(hotelName.getText());
        hotel.setAddress(address.getText());
        hotel.setPhone(phone.getText());
        hotel.setIdCountry(Integer.parseInt(idCountry.getText()));
        hotelsService.edit(hotel);
        screensController.setScreen(MainApp.screen1ID);

    }
}
