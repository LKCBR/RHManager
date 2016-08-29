/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rhmanager.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author lucas
 */
public class FuncionariosView extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Funcionarios.fxml"));

        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/funcionarios.css");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Formulário de Funcionários");
        stage.setScene(scene);
        stage.show();
    }

}
