package com.controller;

import com.MainApp;
import com.model.*;
import com.service.*;
import com.sun.javafx.binding.SelectBinding;
import com.util.MadeAndrei;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableObjectValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;


import javafx.scene.control.cell.PropertyValueFactory;
import javazoom.jl.decoder.JavaLayerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.*;


@Component
public class MainController implements Initializable,ControlledScreen {
    public MenuItem editBtnContext;
    @Autowired
    private MadeAndrei madeAndrei;
    ScreensController screensController;
    public MenuItem deleteBtnContext;
    public MenuItem addBtnContext;
    @Autowired
    private AdvancedQueryService advancedQueryService;
    @Autowired
    private InsuranceService insuranceService;
    @Autowired
    private TouristVoucherService touristVoucherService;
    @Autowired
    private HotelsService hotelsService;
    @Autowired
    private EmployersService employersService;
    @Autowired
    private TransportService transportService;
    @Autowired
    private DriversService driversService;
    @Autowired
    private ClientsService clientsService;
    @Autowired
    private CountriesService countriesService;
    public  ListView<String> advancedQuery;
    public ListView<String> showTable;
    public TableView myTable;
    private ObservableList<String> items =FXCollections.observableArrayList (
            "clients", "countries", "drivers", "employers","hotels","insurance","touristvauchers","transport");
    private ObservableList<String> itemsForAdvancedQuery =FXCollections.observableArrayList (
            "between","like","selectOrderBy","groupBy","storedProcedure","subWhere","innerJoin","storedProcedureWithParameters");

    @FXML
    public void addBtnContext(){
        if(myTable.isFocused()){
            switch (showTable.getSelectionModel().getSelectedIndex()){
                case 0: screensController.setScreen(MainApp.screen2ID);
                    break;
                case 1: screensController.setScreen(MainApp.screen3ID);
                    break;
                case 2: screensController.setScreen(MainApp.screen4ID);
                    break;
                case 3: screensController.setScreen(MainApp.screen6ID);
                    break;
                case 4: screensController.setScreen(MainApp.screen7ID);
                    break;
                case 5: screensController.setScreen(MainApp.screen8ID);
                    break;
                case 6: screensController.setScreen(MainApp.screen9ID);
                    break;
                case 7: screensController.setScreen(MainApp.screen5ID);
                    break;
            }
        }
    }
    @FXML
    public void select(){
        showTable.setItems(items);
    }

    @FXML
    public void deleteBtnContext() throws NoSuchFieldException {
        if(myTable.isFocused()) {
            switch (showTable.getSelectionModel().getSelectedIndex()) {
                case 0:  Clients clients = (Clients) myTable.getSelectionModel().getSelectedItem();
                clientsService.delete(clients.getId());
                    break;
                case 1: Countries countries = (Countries) myTable.getSelectionModel().getSelectedItem();
                    countriesService.delete(countries.getId());
                    break;
                case 2: Drivers drivers = (Drivers) myTable.getSelectionModel().getSelectedItem();
                    driversService.delete(drivers.getId());
                    break;
                case 3: Employers employers = (Employers) myTable.getSelectionModel().getSelectedItem();
                    employersService.delete(employers.getId());
                    break;
                case 4: Hotels hotels = (Hotels) myTable.getSelectionModel().getSelectedItem();
                    hotelsService.delete(hotels.getId());
                    break;
                case 5: Insurance insurance = (Insurance) myTable.getSelectionModel().getSelectedItem();
                    insuranceService.delete(insurance.getId());
                    break;
                case 6:  TouristVauchers touristVauchers = (TouristVauchers) myTable.getSelectionModel().getSelectedItem();
                    touristVoucherService.deleteTouristVoucher(touristVauchers.getId());
                    break;
                case 7:  Transport transport = (Transport) myTable.getSelectionModel().getSelectedItem();
                    transportService.delete(transport.getId());
                    break;
            }

        }

        }



    @FXML
    @SuppressWarnings("unchecked")
    public void selectShowListTable(){
        showTable.setItems(items);
        switch (showTable.getSelectionModel().getSelectedIndex()){
            case 0:
                myTable.getColumns().clear();
                ObservableList<Clients> clientses = FXCollections.observableArrayList();
                clientses.addAll(clientsService.findAllClients());
                List<String> columns = new ArrayList<>();
                columns.add("id");
                columns.add("name");
                columns.add("passport");

                for (String column : columns) {
                    TableColumn<Clients, String> tableColumn = new TableColumn<>(column);
                    tableColumn.setCellValueFactory(new PropertyValueFactory<>(column));
                    myTable.getColumns().addAll(tableColumn);
                }


                myTable.setItems(clientses);


                break;


            case 1:
                myTable.getColumns().clear();
                ObservableList<Countries> countries = FXCollections.observableArrayList();
                countries.addAll(countriesService.findAllCountries());
                List<String> columns1 = new ArrayList<>();
                columns1.add("id");
                columns1.add("countryName");
                columns1.add("lvlSecurity");
                    for (String column1 : columns1) {
                        TableColumn<Countries, String> tableColumn = new TableColumn<>(column1);
                        tableColumn.setCellValueFactory(new PropertyValueFactory<>(column1));
                        myTable.getColumns().addAll(tableColumn);
                    }
              myTable.setItems(countries);


                     break;
            case 2:
                myTable.getColumns().clear();
                ObservableList<Drivers> driverses = FXCollections.observableArrayList();
                driverses.addAll(driversService.findAllDrivers());
                List<String> columns2 = new ArrayList<>();
                columns2.add("id");
                columns2.add("fullName");
                columns2.add("address");
                columns2.add("phone");
                columns2.add("idOfTransport");
                for (String column2 : columns2) {
                    TableColumn<Drivers, String> tableColumn = new TableColumn<>(column2);
                    tableColumn.setCellValueFactory(new PropertyValueFactory<>(column2));
                    myTable.getColumns().addAll(tableColumn);
                }
                myTable.setItems(driverses);


                break;
            case 3:
                myTable.getColumns().clear();
                ObservableList<Employers> employerses = FXCollections.observableArrayList();
                employerses.addAll(employersService.findAllEmployers());
                List<String> columns3 = new ArrayList<>();
                columns3.add("id");
                columns3.add("fullName");
                columns3.add("position");
                columns3.add("phone");
                for (String column3 : columns3) {
                    TableColumn<Employers, String> tableColumn = new TableColumn<>(column3);
                    tableColumn.setCellValueFactory(new PropertyValueFactory<>(column3));
                    myTable.getColumns().addAll(tableColumn);
                }
                myTable.setItems(employerses);


                break;
            case 4:
                myTable.getColumns().clear();
                ObservableList<Hotels> hotelses= FXCollections.observableArrayList();
                hotelses.addAll(hotelsService.findAllHotels());
                List<String> columns4 = new ArrayList<>();
                columns4.add("id");
                columns4.add("idCountry");
                columns4.add("hotelName");
                columns4.add("address");
                columns4.add("phone");
                for (String column4 : columns4) {
                    TableColumn<Hotels, String> tableColumn = new TableColumn<>(column4);
                    tableColumn.setCellValueFactory(new PropertyValueFactory<>(column4));
                    myTable.getColumns().addAll(tableColumn);
                }
                myTable.setItems(hotelses);


                break;
            case 5:
                myTable.getColumns().clear();
                ObservableList<Insurance> insurances= FXCollections.observableArrayList();
                insurances.addAll(insuranceService.findAllInsurance());
                List<String> columns5 = new ArrayList<>();
                columns5.add("id");
                columns5.add("idTouristVoucher");
                columns5.add("insuranceDate");
                columns5.add("cost");
                for (String column5 : columns5) {
                    TableColumn<Insurance, String> tableColumn = new TableColumn<>(column5);
                    tableColumn.setCellValueFactory(new PropertyValueFactory<>(column5));
                    myTable.getColumns().addAll(tableColumn);
                }
                myTable.setItems(insurances);


                break;
            case 6:
                myTable.getColumns().clear();
                ObservableList<TouristVauchers> touristVaucherses= FXCollections.observableArrayList();
                touristVaucherses.addAll(touristVoucherService.findAllTouristVauchers());
                List<String> columns6 = new ArrayList<>();
                columns6.add("id");
                columns6.add("idEmployer");
                columns6.add("idClient");
                columns6.add("idDriver");
                columns6.add("idHotel");
                columns6.add("departureDate");
                columns6.add("arrivalDate");
                columns6.add("saleDate");
                columns6.add("cost");
                for (String column6 : columns6) {
                    TableColumn<TouristVauchers, String> tableColumn = new TableColumn<>(column6);
                    tableColumn.setCellValueFactory(new PropertyValueFactory<>(column6));
                    myTable.getColumns().addAll(tableColumn);
                }
                myTable.setItems(touristVaucherses);


                break;
            case 7:
                myTable.getColumns().clear();
                ObservableList<Transport> transports = FXCollections.observableArrayList();
                transports.addAll(transportService.findAllTransport());
                List<String> columns7 = new ArrayList<>();
                columns7.add("id");
                columns7.add("name");
                for (String column7 : columns7) {
                    TableColumn<Transport, String> tableColumn = new TableColumn<>(column7);
                    tableColumn.setCellValueFactory(new PropertyValueFactory<>(column7));
                    myTable.getColumns().addAll(tableColumn);
                }
                myTable.setItems(transports);


                break;


        }

    }



    @Override
    public void setScreenParent(ScreensController screenPage) {
        screensController= screenPage;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void madeAndrei(ActionEvent actionEvent) throws IOException, JavaLayerException {
        madeAndrei.play();
        screensController.setScreen(MainApp.screen10ID);
    }

    public void editBtnContex(ActionEvent actionEvent) {
        if(myTable.isFocused()){
            switch (showTable.getSelectionModel().getSelectedIndex()) {
                case 0: screensController.setScreen(MainApp.screen2ID);
                    break;
                case 1: screensController.setScreen(MainApp.screen3ID);
                    break;
                case 2: screensController.setScreen(MainApp.screen4ID);
                    break;
                case 3: screensController.setScreen(MainApp.screen6ID);
                    break;
                case 4: screensController.setScreen(MainApp.screen7ID);
                    break;
                case 5: screensController.setScreen(MainApp.screen8ID);
                    break;
                case 6: screensController.setScreen(MainApp.screen9ID);
                    break;
                case 7: screensController.setScreen(MainApp.screen5ID);
                    break;
               }
            }
    }
    @FXML
    @SuppressWarnings("unchecked")
    public void advancedQuery(Event event) {
        advancedQuery.setItems(itemsForAdvancedQuery);
        switch (advancedQuery.getSelectionModel().getSelectedIndex()){
            case 0:
                myTable.getColumns().clear();
                ObservableList<TouristVauchers> betweenTouristVoucher = FXCollections.observableArrayList();
                betweenTouristVoucher.addAll(advancedQueryService.between());
                List<String> columns = new ArrayList<>();
                columns.add("id");
                columns.add("idEmployer");
                columns.add("idClient");
                columns.add("idDriver");
                columns.add("idHotel");
                columns.add("departureDate");
                columns.add("arrivalDate");
                columns.add("saleDate");
                columns.add("cost");
                for (String column : columns) {
                    TableColumn<TouristVauchers, String> tableColumn = new TableColumn<>(column);
                    tableColumn.setCellValueFactory(new PropertyValueFactory<>(column));
                    myTable.getColumns().addAll(tableColumn);
                }
                myTable.setItems(betweenTouristVoucher);
                break;
            case 1:
                myTable.getColumns().clear();
                ObservableList<Drivers> likeDriver = FXCollections.observableArrayList();
                likeDriver.addAll(advancedQueryService.like());
                List<String> columns1 = new ArrayList<>();
                columns1.add("id");
                columns1.add("fullName");
                columns1.add("address");
                columns1.add("phone");
                columns1.add("idOfTransport");
                for (String column1 : columns1) {
                    TableColumn<Drivers, String> tableColumn = new TableColumn<>(column1);
                    tableColumn.setCellValueFactory(new PropertyValueFactory<>(column1));
                    myTable.getColumns().addAll(tableColumn);
                }
                myTable.setItems(likeDriver);
                break;
            case 2:
                myTable.getColumns().clear();
                ObservableList  selectOrderBy =  FXCollections.observableArrayList();
                selectOrderBy.addAll(advancedQueryService.selectOrderBy());
                List<String> columns2 = new ArrayList<>();
                columns2.add("fullName");
                columns2.add("name");
                for (String column2 : columns2) {
                    TableColumn<String, String> tableColumn = new TableColumn<>(column2);
                    tableColumn.setCellValueFactory(new PropertyValueFactory<>(column2));
                    myTable.getColumns().addAll(tableColumn);
                }
                myTable.setItems(selectOrderBy);


                break;
            case 3:
                myTable.getColumns().clear();
                ObservableList  groupByDriver = FXCollections.observableArrayList();
                groupByDriver.addAll(advancedQueryService.grouBy());
                List<String> columns3 = new ArrayList<>();
                columns3.add("fullName");
                columns3.add("count");

                for (String column3 : columns3) {
                    TableColumn<String, String> tableColumn = new TableColumn<>(column3);
                    tableColumn.setCellValueFactory(new PropertyValueFactory<>(column3));
                    myTable.getColumns().addAll(tableColumn);
                }
                myTable.setItems(groupByDriver);
                break;
            case 4:
                myTable.getColumns().clear();
                ObservableList  storedProcedure = FXCollections.observableArrayList();
                storedProcedure.addAll(advancedQueryService.storedProcedure());
                List<String> columns4 = new ArrayList<>();
                columns4.add("id");
                columns4.add("idEmployer");
                columns4.add("idClient");
                columns4.add("idDriver");
                columns4.add("idHotel");
                columns4.add("departureDate");
                columns4.add("arrivalDate");
                columns4.add("saleDate");
                columns4.add("cost");
                for (String column4 : columns4) {
                    TableColumn<String, String> tableColumn = new TableColumn<>(column4);
                    tableColumn.setCellValueFactory(new PropertyValueFactory<>(column4));
                    myTable.getColumns().addAll(tableColumn);
                }
                myTable.setItems(storedProcedure);
                break;
            case 5:
                myTable.getColumns().clear();
                ObservableList  subWhere = FXCollections.observableArrayList();
                subWhere.addAll(advancedQueryService.subWhere());
                List<String> columns5 = new ArrayList<>();
                columns5.add("id");
                columns5.add("idEmployer");
                columns5.add("idClient");
                columns5.add("departureDate");
                columns5.add("cost");
                for (String column5 : columns5) {
                    TableColumn<String, String> tableColumn = new TableColumn<>(column5);
                    tableColumn.setCellValueFactory(new PropertyValueFactory<>(column5));
                    myTable.getColumns().addAll(tableColumn);
                }
                myTable.setItems(subWhere);
                break;
            case 6:
                myTable.getColumns().clear();
                ObservableList  innerJoin = FXCollections.observableArrayList();
                innerJoin.addAll(advancedQueryService.innerJoin());
                List<String> columns6 = new ArrayList<>();
                columns6.add("fullName");
                columns6.add("cost");
                for (String column6 : columns6) {
                    TableColumn<String, String> tableColumn = new TableColumn<>(column6);
                    tableColumn.setCellValueFactory(new PropertyValueFactory<>(column6));
                    myTable.getColumns().addAll(tableColumn);
                }
                myTable.setItems(innerJoin);
                break;
            case 7:
                myTable.getColumns().clear();
                ObservableList  storedProcedureWithParameters = FXCollections.observableArrayList();
                storedProcedureWithParameters.addAll(advancedQueryService.storedProcedureWithParameters());
                List<String> columns7 = new ArrayList<>();
                columns7.add("id");
                columns7.add("idTouristVoucher");
                columns7.add("insuranceDate");
                columns7.add("cost");
                for (String column7 : columns7) {
                    TableColumn<String, String> tableColumn = new TableColumn<>(column7);
                    tableColumn.setCellValueFactory(new PropertyValueFactory<>(column7));
                    myTable.getColumns().addAll(tableColumn);
                }
                myTable.setItems(storedProcedureWithParameters);
                break;
        }
    }
}




