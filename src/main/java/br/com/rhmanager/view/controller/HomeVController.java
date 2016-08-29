/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rhmanager.view.controller;

import br.com.rhmanager.util.Icons;
import br.com.rhmanager.view.FormFuncionarioView;
import br.com.rhmanager.view.FuncionariosView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;

/**
 * FXML Controller class
 *
 * @author lucas
 */
public class HomeVController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private MenuItem miSair;

    @FXML
    private MenuItem miFuncionarios;

    @FXML
    private Menu mCadastros;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        miSair.setGraphic(Icons.getIcon(Icons.ICON_EXCLUIR, 22));
        mCadastros.setGraphic(Icons.getIcon(Icons.ICON_REGISTER, 30));

    }

    @FXML
    private void abrirFormFuncionario() throws Exception {

        new FuncionariosView().start(null);

    }

}
