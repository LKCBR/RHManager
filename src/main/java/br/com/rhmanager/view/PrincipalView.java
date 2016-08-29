package br.com.rhmanager.view;

import br.com.rhmanager.util.Icons;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.BoxBlur;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author lucas
 */
public class PrincipalView extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/HomeView.fxml"));

        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/home.css");
        stage.setMaximized(true);
        stage.getIcons().add(new Image(getClass().getResourceAsStream(Icons.ICON_PRINCIPAL)));
        stage.setTitle("RHManager - Gerênciamento de Recursos Humanos no Ensino Superior");
        stage.setScene(scene);

        stage.show();

    }

}
