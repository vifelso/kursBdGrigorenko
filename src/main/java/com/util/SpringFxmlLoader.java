package com.util;

import com.configuration.AppConfig;
import com.controller.ControlledScreen;
import javafx.fxml.FXMLLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.net.URL;

public class SpringFxmlLoader {

    public static final AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
    public  ControlledScreen myScreenControler;
    public <T> T load(URL url) {
        try {
            FXMLLoader loader = new FXMLLoader(url);
            loader.setControllerFactory(applicationContext::getBean);
            T my=loader.load();
            myScreenControler=loader.getController();
            return my;
        } catch (IOException ioException) {
            throw new RuntimeException(ioException);
        }
    }

}