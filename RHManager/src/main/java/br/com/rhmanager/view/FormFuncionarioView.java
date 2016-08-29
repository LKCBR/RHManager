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
public class FormFuncionarioView extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/FormFuncionarios.fxml"));

        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/formfuncionarios.css");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Formulário de Funcionários");
        stage.setScene(scene);
        stage.show();
    }

}
