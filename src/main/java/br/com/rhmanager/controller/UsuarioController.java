/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rhmanager.controller;

import br.com.rhmanager.bean.Usuario;
import br.com.rhmanager.daoImpl.UsuarioDAOImpl;
import br.com.rhmanager.util.AlertUtil;
import br.com.rhmanager.util.MD5Util;
import br.com.rhmanager.view.HomeView;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author lucas
 */
public class UsuarioController {

    public static Usuario usuariologado;

    public void login(TextField tfEmail, PasswordField pwSenha, Stage stage) {
        String erro = null;
        if (tfEmail.getText().length() > 0 && pwSenha.getText().length() > 0) {
            String senha = MD5Util.converToMD5(pwSenha.getText());
            String email = tfEmail.getText();

            UsuarioDAOImpl usuarioDAOImpl = new UsuarioDAOImpl();

            Usuario usuario = usuarioDAOImpl.verificarLogin(email, senha);

            if (usuario != null) {
                usuariologado = usuario;

                try {
                    new HomeView().start(new Stage());
                    stage.close();
                } catch (Exception ex) {
                    Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                AlertUtil.erro("Erro", "Usuário Inválido!", "Certifique-se de que digitou o E-mail e a Senha corretamente!");
            }
        } else {

            if (tfEmail.getText().length() == 0 && pwSenha.getText().length() == 0) {
                erro = "Os campos E-mail e Senha devem ser preenchidos!";
            } else if (tfEmail.getText().length() == 0) {
                erro = "O campo E-mail deve ser preenchido!";
            } else if (tfEmail.getText().length() == 0) {
                erro = "O campo Senha deve ser preenchido!";
            }

            AlertUtil.erro("Erro", "Campo(s) inválido(s)", erro);
        }
    }

}
