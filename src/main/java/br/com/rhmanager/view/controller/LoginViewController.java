/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rhmanager.view.controller;

import br.com.rhmanager.controller.UsuarioController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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
    
    UsuarioController usuarioController = new UsuarioController();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    @FXML
    public void entrar(){
        usuarioController.login(tfEmail, pwSenha);
    }
    
}
