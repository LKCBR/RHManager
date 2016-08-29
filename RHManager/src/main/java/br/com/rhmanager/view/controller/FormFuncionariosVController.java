/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rhmanager.view.controller;

import br.com.rhmanager.bean.Funcionario;
import br.com.rhmanager.bean.funcionarios.Enderecos;
import br.com.rhmanager.util.CEPWebService;
import br.com.rhmanager.util.Constantes;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javax.swing.table.TableColumn;

/**
 * FXML Controller class
 *
 * @author lucas
 */
public class FormFuncionariosVController implements Initializable {

    /**
     * Initializes the controller class.
     */
    /**
     * Initializes the controller class.
     */
    List<Enderecos> enderecos = new ArrayList();

    Enderecos endereco = new Enderecos();

    ObservableList observableList;

    @FXML
    private TextField tfCPF;

    @FXML
    private TextField dtNasc;

    @FXML
    private TextField tfRG;

    @FXML
    private ComboBox cbSexo;

    @FXML
    private ComboBox cbEstados;

    @FXML
    private TextField tfCEP;

    @FXML
    private TextField tfRua;

    @FXML
    private TextField tfBairro;

    @FXML
    private TextField tfCidade;

    @FXML
    private TextField tfINSS;

    @FXML
    private TextField tfPIS;

    @FXML
    private TableView tabelaEnd;

    TableColumn columnCidade;

    private Funcionario funcionario;

    private String nome = new String();

    public FormFuncionariosVController() {
        System.out.println(nome);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        cbSexo.getItems().addAll("MASCULINO", "FEMININO");
        cbEstados.getItems().addAll(Constantes.ESTADOS);

        endereco.setBairroEnd("BAIRROS");
        endereco.setCepEnd("CEP");
        endereco.setCidadeEnd("CIDADE");
        endereco.setLogradouroEnd("LOGRA");

        enderecos.add(endereco);
        observableList = FXCollections.observableArrayList(enderecos);

        tfCidade.setText(nome);

        System.out.println(nome);

    }

    @FXML
    private void getEnd() {

        String valor = getTfCEP().getText().replaceAll(" ", "");

        if (valor.length() == 10) {

            CEPWebService.getEnderecoByCEP(valor, cbEstados, tfRua, tfBairro, tfCidade);
        }
    }

    public TextField getTfCEP() {
        return tfCEP;
    }

    public void setTfCEP(TextField tfCEP) {
        this.tfCEP = tfCEP;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
