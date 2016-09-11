package br.com.rhmanager.controller;

import br.com.rhmanager.bean.Funcionario;
import br.com.rhmanager.bean.Permissao;
import br.com.rhmanager.bean.Usuario;
import br.com.rhmanager.bean.funcionarios.Cargo;
import br.com.rhmanager.bean.funcionarios.Endereco;
import br.com.rhmanager.bean.funcionarios.Telefone;
import br.com.rhmanager.daoImpl.FuncionarioDAOImpl;
import br.com.rhmanager.util.AlertUtil;
import br.com.rhmanager.util.DateUtil;
import br.com.rhmanager.util.MD5Util;
import br.com.rhmanager.util.NotificationsUtil;
import br.com.rhmanager.util.RegexUtil;
import br.com.rhmanager.util.ValidarUtil;
import br.com.rhmanager.view.controller.FormFuncionariosVController;
import br.com.rhmanager.vo.FuncionarioVOTable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.stage.Stage;

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

    public void salvarFuncionario(Funcionario funcionario, List<Endereco> Enderecos, List<Telefone> Telefones, List<Cargo> Cargos, TextField tfNome, TextField tfCPF, TextField tfRG, ComboBox cbSexo, TextField tfDtNasc,
            TextField tfPis, TextField tfINSS,
            TableView tvEnderecos, TableView tvCargo, TableView tvTelefone, TableView tvTitulos, TextField tfEmail, TextField tfConta,
            TextField tfAgencia, ComboBox cbAgencia, ToggleButton tbAcesso, TextField tfEmailAcesso, PasswordField pfSenha, ComboBox cbPermissao, ToggleButton tbAtivo) {
        AGBancariaController agbc = new AGBancariaController();
        if (validar(tfNome, tfCPF, tfRG, cbSexo, tfDtNasc, tfPis, tfINSS, tvEnderecos, tvCargo, tvTelefone, tvTitulos, tfEmail, tfConta, tfAgencia, cbAgencia, tbAcesso, tfEmailAcesso, pfSenha, cbPermissao)) {
            FuncionarioDAOImpl funcionarioDAOImpl = new FuncionarioDAOImpl();
            Usuario usuario;
            PermissaoController permissaoController = new PermissaoController();
            AGBancariaController aGBancariaController = new AGBancariaController();

            if (funcionario == null) {
                funcionario = new Funcionario();
            }

            funcionario.setNome(tfNome.getText());
            funcionario.setCpf(RegexUtil.removerCaracteresCPF_RG_TELEFONE(tfCPF.getText()));
            funcionario.setRg(RegexUtil.removerCaracteresCPF_RG_TELEFONE(tfRG.getText()));
            funcionario.setSexo(cbSexo.getSelectionModel().getSelectedItem().toString());
            funcionario.setDt_nascimento(DateUtil.convertStringCalendar(tfDtNasc.getText()));
            funcionario.setPis(RegexUtil.removerCaracteresCPF_RG_TELEFONE(tfPis.getText()));
            funcionario.setInss(RegexUtil.removerCaracteresCPF_RG_TELEFONE(tfINSS.getText()));
            funcionario.setEmail(tfEmail.getText());
            funcionario.setAtivo(verificarStatus(tbAtivo));

            if (cbAgencia.getSelectionModel().getSelectedItem() != null) {
                funcionario.setAgencia(tfAgencia.getText());
                funcionario.setConta(tfConta.getText());
                funcionario.setaGBancaria(aGBancariaController.getAgenciaBancariaByName(cbAgencia.getSelectionModel().getSelectedItem().toString()));
            }

            if (funcionario.getUsuario() == null && tfEmailAcesso.getText().length() > 0 && pfSenha.getText().length() > 0) {
                Permissao permissao = permissaoController.getPermissaoByName(cbPermissao.getSelectionModel().getSelectedItem().toString());
                if (funcionario.getUsuario() == null) {
                    usuario = new Usuario();

                } else {
                    usuario = funcionario.getUsuario();
                }
                usuario.setEmail(tfEmailAcesso.getText());

                usuario.setPassword(MD5Util.converToMD5(pfSenha.getText()));

                usuario.setPermissao_usuario(permissao);

                usuario.setUsuario_funcionario(funcionario);

                if (usuario.getIdUsuario() == null) {
                    usuario.setDt_cadastro(DateUtil.getDataHoraAtual());
                    usuario.setDt_ultima_alteracao(DateUtil.getDataHoraAtual());
                } else {
                    usuario.setDt_ultima_alteracao(DateUtil.getDataHoraAtual());
                }

                funcionario.setUsuario(usuario);
            } else if (tfEmailAcesso.getText().length() > 0 && pfSenha.getText().length() > 0) {
                usuario = funcionario.getUsuario();
                if (!usuario.getEmail().equals(tfEmailAcesso.getText())) {
                    usuario.setEmail(tfEmailAcesso.getText());
                }

                if (!usuario.getPassword().equals(MD5Util.converToMD5(pfSenha.getText()))) {
                    usuario.setPassword(MD5Util.converToMD5(pfSenha.getText()));
                }

                funcionario.setUsuario(usuario);
            } else {
                funcionario.setUsuario(null);
            }

            if (tfEmailAcesso.getText().length() > 0 && pfSenha.getText().length() > 0) {
                Permissao permissao = permissaoController.getPermissaoByName(cbPermissao.getSelectionModel().getSelectedItem().toString());
                if (funcionario.getUsuario() == null) {
                    usuario = new Usuario();
                    System.out.println("OK");
                } else {
                    usuario = funcionario.getUsuario();
                }
                usuario.setEmail(tfEmailAcesso.getText());

                usuario.setPassword(MD5Util.converToMD5(pfSenha.getText()));

                usuario.setPermissao_usuario(permissao);

                usuario.setUsuario_funcionario(funcionario);

                if (usuario.getIdUsuario() == null) {
                    usuario.setDt_cadastro(DateUtil.getDataHoraAtual());
                    usuario.setDt_ultima_alteracao(DateUtil.getDataHoraAtual());
                } else {
                    usuario.setDt_ultima_alteracao(DateUtil.getDataHoraAtual());
                }

                funcionario.setUsuario(usuario);
            }

            Enderecos = setFuncionarioEndereco(Enderecos, funcionario);
            Telefones = setFuncionarioTelefone(Telefones, funcionario);

            funcionario.setTelefones(Telefones);
            funcionario.setEnderecos(Enderecos);
            funcionario.setCargos(Cargos);

            try {
                funcionarioDAOImpl.insert(funcionario);
                NotificationsUtil.gerarNotificationSucess("Sucesso", "Funcionário Cadastrado com Sucesso!");
            } catch (Exception ex) {
                Logger.getLogger(FuncionarioController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
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

    public boolean validar(TextField tfNome, TextField tfCPF, TextField tfRG, ComboBox cbSexo, TextField tfDtNasc, TextField tfPis, TextField tfINSS,
            TableView tvEnderecos, TableView tvCargo, TableView tvTelefone, TableView tvTitulos, TextField tfEmail, TextField tfConta,
            TextField tfAgencia, ComboBox cbAgencia, ToggleButton tbAcesso, TextField tfEmailAcesso, PasswordField pfSenha, ComboBox cbPermissao) {

        boolean nome, cpf, rg, sexo, dtnasc, pis, inss, enderecos, telefone, cargos, email, contaBancaria, acesso;

        nome = ValidarUtil.validarTextField(tfNome, 5);
        cpf = ValidarUtil.validarTextField(tfCPF, 8);
        rg = ValidarUtil.validarTextField(tfRG, 8);
        sexo = ValidarUtil.validarComboBox(cbSexo);
        dtnasc = ValidarUtil.validarDataNascimento(tfDtNasc);
        pis = ValidarUtil.validarTextField(tfPis, 11);
        inss = ValidarUtil.validarTextField(tfINSS, 11);
        enderecos = ValidarUtil.validarTableView(tvEnderecos);
        telefone = ValidarUtil.validarTableView(tvTelefone);

        cargos = ValidarUtil.validarTableView(tvCargo);
        email = ValidarUtil.validarEmail(tfEmail);
        contaBancaria = ValidarUtil.verificarAGB(tfConta, tfAgencia, cbAgencia);
        acesso = ValidarUtil.acessoEmailSenha(tfEmailAcesso, pfSenha, tbAcesso, cbPermissao);

        return nome && cpf && rg && sexo && dtnasc && pis && inss && enderecos && telefone && cargos && email && contaBancaria && acesso;

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

    public List<Telefone> setFuncionarioTelefone(List<Telefone> telefones, Funcionario funcionario) {

        for (Telefone telefone : telefones) {
            telefone.setTelefone_funcionario(funcionario);
        }

        return telefones;
    }

    public List<Endereco> setFuncionarioEndereco(List<Endereco> enderecos, Funcionario funcionario) {
        for (Endereco endereco : enderecos) {
            endereco.setEnderecos_funcionario(funcionario);
        }

        return enderecos;
    }

    public int verificarStatus(ToggleButton tb) {
        if (tb.isArmed()) {
            return 1;
        } else {
            return 0;
        }
    }

    public List<Funcionario> buscarFuncionarios(TextField tfNome, TextField tfCPF, ComboBox cbCargo, List<Funcionario> funcionarios) {
        Cargo cargo = null;
        FuncionarioDAOImpl funcionarioDAOImpl = new FuncionarioDAOImpl();
        CargoController cargoController = new CargoController();
        /*        if (cbCargo.getSelectionModel().getSelectedItem() != null) {
            cargo = cargoController.getCargoByName(cbCargo.getSelectionModel().getSelectedItem().toString());
        }
         */
        funcionarios = new ArrayList<>();

        funcionarios.addAll(funcionarioDAOImpl.getFuncionariosBusca(tfNome.getText(), RegexUtil.removerCaracteresCPF_RG_TELEFONE(tfCPF.getText()), cargo));

        return funcionarios;

    }
}
