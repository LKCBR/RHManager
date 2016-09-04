/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rhmanager.view.controller;

import br.com.rhmanager.bean.Funcionario;
import br.com.rhmanager.bean.funcionarios.Enderecos;
import br.com.rhmanager.controller.FuncionarioController;
import br.com.rhmanager.util.CEPWebService;
import br.com.rhmanager.util.Constantes;
import br.com.rhmanager.util.LetrasTextField;
import br.com.rhmanager.vo.EnderecoVOTable;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;


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
    FuncionarioController funcionarioController;

    List<Enderecos> enderecos = new ArrayList();

    Enderecos endereco = new Enderecos();

    ObservableList observableList;

    TableColumn columnCidade;

    private Funcionario funcionario;

    /*
    Informações Pessoais
     */
    @FXML
    private LetrasTextField tfNome;

    @FXML
    private TextField tfCPF;

    @FXML
    private TextField dtNasc;

    @FXML
    private TextField tfRG;

    @FXML
    private ComboBox cbSexo;

    @FXML
    private TextField tfPIS;

    @FXML
    private TextField tfINSS;

    /*
        Endereço
     */
    @FXML
    private ComboBox cbEstados;

    @FXML
    private TextField tfCEP;

    @FXML
    private TextField tfRua;

    @FXML
    private TextField tfBairro;

    @FXML
    private TextField tfNumero;

    @FXML
    private LetrasTextField tfCidade;

    @FXML
    private TableView<EnderecoVOTable> tvEnderecos = new TableView();

    @FXML
    private TableColumn tcCidade;

    @FXML
    private TableColumn tcBairro = new TableColumn();

    @FXML
    private TableColumn tcRua = new TableColumn();

    @FXML
    private TableColumn tcNumero = new TableColumn();

    @FXML
    private Button btAddEndereco;

    @FXML
    private Button btRemoverEndereco;

    /*
    Contatos
     */
    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfTelefone;

    @FXML
    private TableView tvTelefones = new TableView();

    @FXML
    private TableColumn tcTelefone = new TableColumn();

    @FXML
    private Button btInserirTelefone;

    @FXML
    private Button btRemoverTelefone;

    /*
    Títulos
     */
    @FXML
    private TextField tfTitulo;

    @FXML
    private TextField tfEspecificacao;

    @FXML
    private Button btInserirTitulo;

    @FXML
    private Button btRemoverTitulo;

    @FXML
    private TableView tvTitulos;

    @FXML
    private TableColumn tcTitulo;

    @FXML
    private TableColumn tcEspecificacao;


    /*
    Cargo
     */
    @FXML
    private ComboBox cbCargo;

    @FXML
    private Button btNovoCargo;

    @FXML
    private Button btInserirCargo;

    @FXML
    private Button btRemoverCargo;

    @FXML
    private TableView tvCargo;

    @FXML
    private TableColumn tcCargo = new TableColumn();


    /*
    ACESSO
     */
    @FXML
    private TextField tfEmailAcesso;

    @FXML
    private PasswordField pwSenha;

    /*
    CONTA BANCARIA
     */
    @FXML
    private ComboBox cbAgenciaBancaria;

    @FXML
    private Button btAdicionarAgencia;

    @FXML
    private TextField tfAgencia;

    @FXML
    private TextField tfConta;

    /*
    GERAL
     */
    @FXML
    private Button btSalvarFuncionario;

    @FXML
    private Button btCancelar;

    @FXML
    private ToggleButton tbAtivo;

    @FXML
    private ToggleButton tbAcesso;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        funcionarioController = new FuncionarioController();

        cbSexo.getItems().addAll("MASCULINO", "FEMININO");
        cbEstados.getItems().addAll(Constantes.ESTADOS);

        endereco.setBairroEnd("BAIRROS");
        endereco.setCepEnd("CEP");
        endereco.setCidadeEnd("CIDADE");
        endereco.setLogradouroEnd("LOGRA");

        enderecos.add(endereco);
        observableList = FXCollections.observableArrayList(enderecos);

        tfNome.setMaxlength(120);
        tfCidade.setMaxlength(31);

    }

    @FXML
    private void getEnd() {

        String valor = getTfCEP().getText().replaceAll(" ", "");

        if (valor.length() == 10) {

            CEPWebService.getEnderecoByCEP(valor, cbEstados, tfRua, tfBairro, tfCidade);
        }
    }

    @FXML
    private void salvarFuncionario() {
        funcionarioController.validar(tfNome, tfCPF, tfRG, cbSexo, dtNasc, tfPIS, tfINSS);
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

}
