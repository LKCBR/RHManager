package br.com.rhmanager.view.controller;

import br.com.rhmanager.TableView.CargoTableView;
import br.com.rhmanager.TableView.EnderecoTableView;
import br.com.rhmanager.TableView.TelefoneTableView;
import br.com.rhmanager.TableView.TituloTableView;
import br.com.rhmanager.bean.AGBancaria;
import br.com.rhmanager.bean.Funcionario;
import br.com.rhmanager.bean.funcionarios.Cargo;
import br.com.rhmanager.bean.funcionarios.Endereco;
import br.com.rhmanager.bean.funcionarios.Telefone;
import br.com.rhmanager.bean.funcionarios.Titulo;
import br.com.rhmanager.controller.AGBancariaController;

import br.com.rhmanager.controller.CargoController;
import br.com.rhmanager.controller.EnderecoController;
import br.com.rhmanager.controller.FuncionarioController;
import br.com.rhmanager.controller.PermissaoController;
import br.com.rhmanager.controller.TelefonesController;
import br.com.rhmanager.controller.TituloController;
import br.com.rhmanager.util.CEPWebService;
import br.com.rhmanager.util.Constantes;
import br.com.rhmanager.util.Icons;
import br.com.rhmanager.util.LetrasTextField;
import br.com.rhmanager.vo.CargoVOTable;
import br.com.rhmanager.vo.EnderecoVOTable;
import br.com.rhmanager.vo.TelefoneVOTable;
import br.com.rhmanager.vo.TituloVOTable;
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
    //TABLE VIEWS
    EnderecoTableView enderecoTableView;
    TelefoneTableView telefoneTableView;
    TituloTableView tituloTableView;
    CargoTableView cargoTableView;

    //CONTROLLERS
    EnderecoController enderecoController;
    FuncionarioController funcionarioController;
    TelefonesController telefoneController;
    TituloController tituloController;
    CargoController cargoController;
    AGBancariaController aGBancariaController;
    PermissaoController permissaoController;

    //LISTS    
    List<Endereco> enderecos = new ArrayList();
    List<Telefone> telefones = new ArrayList();
    List<Titulo> titulos = new ArrayList<>();
    List<Cargo> lCargos = new ArrayList<>();

    //OBSERVABLE LIST
    ObservableList<String> cargos;
    ObservableList<String> agencias;
    ObservableList<String> permissoes;

    //OBJETOS
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
    private TextField tfComplemento;

    @FXML
    private TableView<EnderecoVOTable> tvEnderecos = new TableView();

    @FXML
    private TableColumn<EnderecoVOTable, String> tcCidade;

    @FXML
    private TableColumn<EnderecoVOTable, String> tcBairro = new TableColumn();

    @FXML
    private TableColumn<EnderecoVOTable, String> tcRua = new TableColumn();

    @FXML
    private TableColumn<EnderecoVOTable, String> tcNumero = new TableColumn();

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
    private TableView<TelefoneVOTable> tvTelefones;

    @FXML
    private TableColumn<TelefoneVOTable, String> tcTelefone;

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
    private TableView<TituloVOTable> tvTitulos = new TableView<>();

    @FXML
    private TableColumn<TituloVOTable, String> tcTitulo = new TableColumn<>();

    @FXML
    private TableColumn<TituloVOTable, String> tcEspecificacao = new TableColumn<>();


    /*
    Cargo
     */
    @FXML
    private ComboBox<String> cbCargo;

    @FXML
    private Button btNovoCargo;

    @FXML
    private Button btInserirCargo;

    @FXML
    private Button btRemoverCargo;

    @FXML
    private TableView<CargoVOTable> tvCargo = new TableView<>();

    @FXML
    private TableColumn tcCargo = new TableColumn();


    /*
    ACESSO
     */
    @FXML
    private TextField tfEmailAcesso;

    @FXML
    private PasswordField pwSenha;

    @FXML
    private ComboBox<String> cbPermissaoAcesso;

    /*
    CONTA BANCARIA
     */
    @FXML
    private ComboBox<String> cbAgenciaBancaria;

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

        btAddEndereco.setGraphic(Icons.getIcon(Icons.ICON_DOWNLOAD, 22));
        btInserirTitulo.setGraphic(Icons.getIcon(Icons.ICON_DOWNLOAD, 22));
        btInserirTelefone.setGraphic(Icons.getIcon(Icons.ICON_DOWNLOAD, 22));
        btInserirCargo.setGraphic(Icons.getIcon(Icons.ICON_DOWNLOAD, 22));
        btRemoverCargo.setGraphic(Icons.getIcon(Icons.ICON_UPLOAD, 22));
        btRemoverEndereco.setGraphic(Icons.getIcon(Icons.ICON_UPLOAD, 22));
        btRemoverTelefone.setGraphic(Icons.getIcon(Icons.ICON_UPLOAD, 22));
        btRemoverTitulo.setGraphic(Icons.getIcon(Icons.ICON_UPLOAD, 22));
        btNovoCargo.setGraphic(Icons.getIcon(Icons.ICON_ADD_, 22));

        // CONTROLLER
        funcionarioController = new FuncionarioController();
        enderecoController = new EnderecoController();
        telefoneController = new TelefonesController();
        tituloController = new TituloController();
        cargoController = new CargoController();
        aGBancariaController = new AGBancariaController();
        permissaoController = new PermissaoController();

        //TABLE VIEW & COMBOBOX
        enderecoTableView = new EnderecoTableView(tvEnderecos, tcCidade, tcBairro, tcRua, tcNumero);
        telefoneTableView = new TelefoneTableView(tvTelefones, tcTelefone);
        tituloTableView = new TituloTableView(tvTitulos, tcTitulo, tcEspecificacao);
        cargoTableView = new CargoTableView(tvCargo, tcCargo);

        //OBSERVABLE LIST
        cargos = FXCollections.observableArrayList();
        agencias = FXCollections.observableArrayList();
        permissoes = FXCollections.observableArrayList();

        //MÉTODOS
        enderecoController.listarEnderecos(enderecoTableView, enderecos);
        telefoneController.listarTelefones(telefoneTableView, telefones);
        tituloController.listarTitulos(tituloTableView, titulos);
        cargoController.preencherComboBoxDB(cargos, cbCargo);
        cargoController.preencherTable(cargoTableView, lCargos);
        aGBancariaController.preencherComboBox(cbAgenciaBancaria, agencias);
        permissaoController.preencherComboBoxDB(permissoes, cbPermissaoAcesso);

        //PREDEFINICOES
        cbSexo.getItems().addAll("MASCULINO", "FEMININO");
        cbEstados.getItems().addAll(Constantes.ESTADOS);

        tfNome.setMaxlength(120);
        tfCidade.setMaxlength(31);

    }

    /*
    
    MÉTODOS
    
     */
    @FXML
    private void getEnd() {

        String valor = getTfCEP().getText().replaceAll(" ", "");

        if (valor.length() == 10) {

            CEPWebService.getEnderecoByCEP(valor, cbEstados, tfRua, tfBairro, tfCidade);
        }
    }

    @FXML
    private void salvarFuncionario() {
        funcionarioController.salvarFuncionario(funcionario, enderecos, telefones, lCargos, tfNome, tfCPF,
                tfRG, cbSexo, dtNasc, tfPIS, tfINSS, tvEnderecos, tvCargo, tvTelefones, tvTitulos,
                tfEmail, tfConta, tfAgencia, cbAgenciaBancaria, tbAcesso, tfEmailAcesso, pwSenha, cbPermissaoAcesso, tbAtivo);
    }

    @FXML
    private void botaoAcesso() {
        funcionarioController.acessoToggleButton(tbAcesso);
    }

    @FXML
    private void botaoAtivo() {
        funcionarioController.acessoToggleButton(tbAtivo);
    }

    @FXML
    private void inserirEndereco() {
        enderecoController.addEndereco(enderecos, tfCEP, tfRua, cbEstados, tfCidade,
                tfNumero, tfComplemento, tfBairro);
        enderecoController.listarEnderecos(enderecoTableView, enderecos);
    }

    @FXML
    private void removerEndereco() {
        enderecoController.removerEndereco(enderecos, tvEnderecos);
        enderecoController.listarEnderecos(enderecoTableView, enderecos);
    }

    @FXML
    private void inserirTelefone() {
        telefoneController.inserirTelefone(tvTelefones, tfTelefone, telefones);
        telefoneController.listarTelefones(telefoneTableView, telefones);
    }

    @FXML
    private void removerTelefone() {
        telefoneController.removerTelefone(tvTelefones, telefones, telefoneTableView);
        telefoneController.listarTelefones(telefoneTableView, telefones);

    }

    @FXML
    private void inserirTitulo() {
        tituloController.inserirTitulo(titulos, tfTitulo, tfEspecificacao);
        tituloController.listarTitulos(tituloTableView, titulos);
    }

    @FXML
    private void removerTitulo() {
        tituloController.removerTitulo(titulos, tvTitulos);
        tituloController.listarTitulos(tituloTableView, titulos);
    }

    @FXML
    private void adicionarCargo() {
        cargoController.inserirCargo(lCargos, cbCargo);
        cargoController.preencherTable(cargoTableView, lCargos);
    }

    @FXML
    private void removerCargo() {
        cargoController.removerCargo(tvCargo, lCargos);
        cargoController.preencherTable(cargoTableView, lCargos);
    }

    /*
    
    GET AND SET
    
     */
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
