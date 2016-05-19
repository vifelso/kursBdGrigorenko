package com.controller;

import com.MainApp;
import com.model.Employers;
import com.service.EmployersService;
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
public class ActionEmployerController implements Initializable,ControlledScreen{
    public TextField fullName;
    public TextField position;
    public TextField phone;
    public Button addEmployer;
    public Button cancel;
    public Button editEmployer;
    ScreensController screensController;
    @Autowired
    private  MainController mainController;
    @Autowired
    private EmployersService employersService;

    @Override
    public void setScreenParent(ScreensController screenPage) {
        screensController=screenPage;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void addEmployer(ActionEvent actionEvent) {
        Employers employer=new Employers();
        employer.setFullName(fullName.getText());
        employer.setPosition(position.getText());
        employer.setPhone(phone.getText());
        employersService.add(employer);
        screensController.setScreen(MainApp.screen1ID);

    }

    public void cancel(ActionEvent actionEvent) {
        screensController.setScreen(MainApp.screen1ID);
    }

    public void editEmployer(ActionEvent actionEvent) {
        Employers employer= (Employers)mainController.myTable.getSelectionModel().getSelectedItem();
        employer=employersService.getById(employer.getId());
        employer.setFullName(fullName.getText());
        employer.setPosition(position.getText());
        employer.setPhone(phone.getText());
        employersService.edit(employer);
        screensController.setScreen(MainApp.screen1ID);

    }
}
