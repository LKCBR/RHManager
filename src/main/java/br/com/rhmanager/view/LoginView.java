/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rhmanager.view;

import br.com.rhmanager.util.Icons;
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
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/LoginView.fxml"));

        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/loginview.css");
        stage.centerOnScreen();
        stage.getIcons().add(new Image(getClass().getResourceAsStream(Icons.ICON_PRINCIPAL)));
        stage.setTitle("RHManager - Gerênciamento de Recursos Humanos no Ensino Superior");
        stage.setScene(scene);

        stage.show();
    }

}
