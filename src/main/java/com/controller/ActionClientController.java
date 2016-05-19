package com.controller;

import com.MainApp;
import com.model.Clients;
import com.service.ClientsService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
public class ActionClientController implements Initializable,ControlledScreen{
    public Button cancel;
    public Button editClient;
    ScreensController screensController;
    @Autowired
    private  MainController mainController;
    @Autowired
    private ClientsService clientsService;
    @FXML
    private TextField passportClient;
    public Button addClient;
    @FXML
    private TextField nameClient;

    @FXML
    public void addClient(){
        Clients client=new Clients();
        client.setName(nameClient.getText());
        client.setPassport(passportClient.getText());
        clientsService.add(client);
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

    public void editClient(ActionEvent actionEvent) {
        Clients clients = (Clients) mainController.myTable.getSelectionModel().getSelectedItem();
        clients=clientsService.getClientById(clients.getId());
        clients.setName(nameClient.getText());
        clients.setPassport(passportClient.getText());
        clientsService.edit(clients);
        screensController.setScreen(MainApp.screen1ID);

    }
}
