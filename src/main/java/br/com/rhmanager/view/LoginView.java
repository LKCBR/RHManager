/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rhmanager.view;

import br.com.rhmanager.util.Icons;
import br.com.rhmanager.view.controller.HomeVController;
import br.com.rhmanager.view.controller.LoginViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author lucas
 */
public class LoginView extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(getClass().getResource("/fxml/Login.fxml").openStream());
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/loginview.css");

        LoginViewController controller = loader.getController();
        controller.setStage(stage);
        stage.centerOnScreen();
        stage.resizableProperty().setValue(Boolean.FALSE);
        stage.getIcons().add(new Image(getClass().getResourceAsStream(Icons.ICON_PRINCIPAL)));
        stage.setTitle("RHManager - Gerênciamento de Recursos Humanos no Ensino Superior");
        stage.setScene(scene);

        stage.show();
    }

}
