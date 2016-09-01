package br.com.rhmanager.view.controller;

import br.com.rhmanager.controller.UsuarioController;
import br.com.rhmanager.util.Constantes;
import br.com.rhmanager.util.Icons;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author lucas
 */
public class LoginViewController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField tfEmail;
    
    @FXML
    private PasswordField pwSenha;
    
    @FXML
    private Button btEntrar;
    
    @FXML
    private ImageView logoRh;
    
    @FXML
    private Label lbVersion;
    
    private Stage stage;
    
    UsuarioController usuarioController = new UsuarioController();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        logoRh.setImage(new Image(Icons.ICON_LOGO));
        
        logoRh.setFitHeight(45);
        
        lbVersion.setText(Constantes.VERSION);
        
        tfEmail.setOnKeyPressed((KeyEvent kv)
                -> {
            final KeyCombination ENTER = new KeyCodeCombination(KeyCode.ENTER);
            if (ENTER.match(kv)) {
                //TODO HERE
                usuarioController.login(tfEmail, pwSenha, stage);
            }
        });
        
        pwSenha.setOnKeyPressed((KeyEvent kv)
                -> {
            final KeyCombination ENTER = new KeyCodeCombination(KeyCode.ENTER);
            if (ENTER.match(kv)) {
                //TODO HERE
                usuarioController.login(tfEmail, pwSenha, stage);
            }
        });
        
    }
    
    @FXML
    public void entrar() {
        usuarioController.login(tfEmail, pwSenha, stage);
    }
    
    public Stage getStage() {
        return stage;
    }
    
    public void setStage(Stage stage) {
        this.stage = stage;
    }
    
}
