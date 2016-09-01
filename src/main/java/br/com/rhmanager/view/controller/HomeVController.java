/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rhmanager.view.controller;

import br.com.rhmanager.util.Constantes;
import br.com.rhmanager.util.Icons;
import br.com.rhmanager.view.FuncionariosView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
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
    private Menu mColegiado;

    @FXML
    private Menu mFinanceiro;

    @FXML
    private Menu mCadastros;

    @FXML
    private Menu mTools;

    @FXML
    private Menu mAbout;

    @FXML
    private Label lbVersion;

    @FXML
    private Label lbUser;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        miSair.setGraphic(Icons.getIcon(Icons.ICON_EXCLUIR, 22));
        mColegiado.setGraphic(Icons.getIcon(Icons.ICON_COLEGIADO, 30));
        mFinanceiro.setGraphic(Icons.getIcon(Icons.ICON_FINANCEIRO, 30));
        mAbout.setGraphic(Icons.getIcon(Icons.ICON_ABOUT, 30));
        mTools.setGraphic(Icons.getIcon(Icons.ICON_TOOLS, 30));
        mCadastros.setGraphic(Icons.getIcon(Icons.ICON_REGISTER, 30));

        lbVersion.setText(Constantes.VERSION);

    }

    @FXML
    private void abrirFormFuncionario() throws Exception {
        new FuncionariosView().start(null);

    }
}
