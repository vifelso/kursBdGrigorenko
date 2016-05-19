package com.controller;

import com.MainApp;
import com.model.Insurance;
import com.service.InsuranceService;
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
public class ActionInsuranceController implements Initializable,ControlledScreen{
    public TextField idOfTouristVoucher;
    public TextField insuranceDate;
    public TextField cost;
    public Button add;
    public Button cancel;
    public Button editInsurance;
    @Autowired
    private  MainController mainController;
    @Autowired
    private InsuranceService insuranceService;
    ScreensController screensController;

    @Override
    public void setScreenParent(ScreensController screenPage) {
        screensController=screenPage;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void add(ActionEvent actionEvent) throws ParseException {
        Insurance insurance=new Insurance();
        insurance.setIdTouristVoucher(Integer.parseInt(idOfTouristVoucher.getText()));
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = formatter.parse(insuranceDate.getText());
        insurance.setInsuranceDate(date);
        insurance.setCost(Integer.parseInt(cost.getText()));
        insuranceService.add(insurance);
        screensController.setScreen(MainApp.screen1ID);

    }

    public void cancel(ActionEvent actionEvent) {
        screensController.setScreen(MainApp.screen1ID);

    }

    public void editInsurance(ActionEvent actionEvent) throws ParseException {
      Insurance insurance = (Insurance) mainController.myTable.getSelectionModel().getSelectedItem();
        insurance=insuranceService.getById(insurance.getId());
        insurance.setIdTouristVoucher(Integer.parseInt(idOfTouristVoucher.getText()));
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = formatter.parse(insuranceDate.getText());
        insurance.setInsuranceDate(date);
        insurance.setCost(Integer.parseInt(cost.getText()));
        insuranceService.edit(insurance);
        screensController.setScreen(MainApp.screen1ID);

    }
}
