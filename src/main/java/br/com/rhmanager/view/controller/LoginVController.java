package br.com.rhmanager.view.controller;

import br.com.rhmanager.util.Constantes;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author lucas
 */
public class LoginVController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Label version;

    @FXML
    private TextField tfUsuario;

    @FXML
    private PasswordField pwSenha;

    @FXML
    private AnchorPane apJanela;

    @FXML
    private ImageView logo;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        version.setText(Constantes.VERSION);
      logo.setImage(Constantes.LOGO);
    }

}
