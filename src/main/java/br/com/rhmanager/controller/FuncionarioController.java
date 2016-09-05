package br.com.rhmanager.controller;

import br.com.rhmanager.bean.Funcionario;
import br.com.rhmanager.daoImpl.FuncionarioDAOImpl;
import br.com.rhmanager.util.AlertUtil;
import br.com.rhmanager.util.ValidarUtil;
import br.com.rhmanager.view.controller.FormFuncionariosVController;
import br.com.rhmanager.vo.FuncionarioVOTable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;

/**
 *
 * @author lucas
 */
public class FuncionarioController {

    public List<Funcionario> listarFuncionarios() {
        FuncionarioDAOImpl funcionarioDaoImpl = new FuncionarioDAOImpl();

        return funcionarioDaoImpl.getAllFuncionarios();
    }

    public Funcionario getFuncionarioById(String idS) {
        Long id = Long.parseLong(idS);
        FuncionarioDAOImpl funcionarioDaoImpl = new FuncionarioDAOImpl();

        return funcionarioDaoImpl.getFuncionarioById(id);
    }

    public void editarFuncionario(TableView<FuncionarioVOTable> tvFuncionarios, Stage stage) {
        if (tvFuncionarios.getSelectionModel().getSelectedItem() != null) {

            FXMLLoader loader = new FXMLLoader();
            Funcionario funcionario = getFuncionarioById(tvFuncionarios.getSelectionModel().getSelectedItem().getId());
            Parent root;
            try {
                root = loader.load(FormFuncionariosVController.class.getResource("/fxml/FormFuncionarios.fxml").openStream());
                FormFuncionariosVController controller = loader.getController();
                controller.setFuncionario(funcionario);

                Scene scene = new Scene(root);

                stage.setTitle("Formulário do Funcionário " + funcionario.getNome());
                stage.setScene(scene);

                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(FuncionarioController.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            AlertUtil.alertAtencao("Atenção", "Nenhum Funcionário Selecionado!", "Selecione o Funcionário que deseja editar na tabela.");
        }
    }

    public void validar(TextField tfNome, TextField tfCPF, TextField tfRG, ComboBox cbSexo, TextField tfDtNasc, TextField tfPis, TextField tfINSS,
            TableView tvEnderecos, TableView tvCargo, TableView tvTelefone, TableView tvTitulos, TextField tfEmail, TextField tfConta,
            TextField tfAgencia, ComboBox cbAgencia, ToggleButton tbAcesso, TextField tfEmailAcesso, PasswordField pfSenha) {

        boolean nome, cpf, rg, sexo, dtnasc, pis, inss, enderecos, telefone, titulos, cargos, email, contaBancaria, acesso;

        nome = ValidarUtil.validarTextField(tfNome, 5);
        cpf = ValidarUtil.validarTextField(tfCPF, 8);
        rg = ValidarUtil.validarTextField(tfRG, 8);
        sexo = ValidarUtil.validarComboBox(cbSexo);
        dtnasc = ValidarUtil.validarDataNascimento(tfDtNasc);
        pis = ValidarUtil.validarTextField(tfPis, 11);
        inss = ValidarUtil.validarTextField(tfINSS, 11);
        enderecos = ValidarUtil.validarTableView(tvEnderecos);
        telefone = ValidarUtil.validarTableView(tvTelefone);
        titulos = ValidarUtil.validarTableView(tvTitulos);
        cargos = ValidarUtil.validarTableView(tvCargo);
        email = ValidarUtil.validarEmail(tfEmail);
        contaBancaria = ValidarUtil.validarContaBancaria(tfConta, tfAgencia, cbAgencia);
        acesso = ValidarUtil.acessoEmailSenha(tfEmailAcesso, pfSenha, tbAcesso);

        Notifications.create().title("TESTE").text("Bem Vindo Lucas Kulik Chropacz!").darkStyle().position(Pos.BOTTOM_RIGHT).showInformation();

    }

    public void acessoToggleButton(ToggleButton tbAcesso) {
        if (tbAcesso.isSelected()) {
            tbAcesso.setText("Acesso Autorizado");
        } else {
            tbAcesso.setText("Acesso não Autorizado");
        }
    }

    public void botaoAtivo(ToggleButton tbAtivo) {
        if (tbAtivo.isSelected()) {
            tbAtivo.setText("Ativo");
        } else {
            tbAtivo.setText("Desativado");
        }
    }

}
