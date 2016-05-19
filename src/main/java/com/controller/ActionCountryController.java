package com.controller;

import com.MainApp;
import com.model.Countries;
import com.service.CountriesService;
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
public class ActionCountryController  implements Initializable,ControlledScreen{
    public Button editCountry;
    @Autowired
    private CountriesService countriesService;
    @Autowired
    private  MainController mainController;
    public TextField countryName;
    public TextField lvlSecurity;
    public Button addCountry;
    public Button cancel;
    ScreensController screensController;


    public void addCountry(){
        Countries country =new Countries();
        country.setCountryName(countryName.getText());
        country.setLvlSecurity(Integer.parseInt(lvlSecurity.getText()));
        countriesService.add(country);
        screensController.setScreen(MainApp.screen1ID);
    }
    public void cancel(){
        screensController.setScreen(MainApp.screen1ID);

    }
    @Override
    public void setScreenParent(ScreensController screenPage) {
        screensController=screenPage;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void editCountry(ActionEvent actionEvent) {
        Countries country = (Countries)mainController.myTable.getSelectionModel().getSelectedItem();
        country=countriesService.getById(country.getId());
        country.setCountryName(countryName.getText());
        country.setLvlSecurity(Integer.parseInt(lvlSecurity.getText()));
        countriesService.edit(country);
        screensController.setScreen(MainApp.screen1ID);
    }
}
