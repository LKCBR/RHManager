package br.com.rhmanager.controller;

import br.com.rhmanager.TableView.EnderecoTableView;
import br.com.rhmanager.bean.funcionarios.Endereco;
import br.com.rhmanager.util.AlertUtil;
import br.com.rhmanager.util.ValidarUtil;
import br.com.rhmanager.vo.EnderecoVOTable;
import java.util.List;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 *
 * @author lucas
 */
public class EnderecoController {

    public static String VAZIO = "-fx-effect: dropshadow(three-pass-box, rgba(0, 0, 0,0.8), 0,0,0, 0);";

    Thread threadEnderecos;
    Runnable carregarTabela;

    public void limparCampos(TextField tfCEP, TextField tfRua, ComboBox cbEstado, TextField tfCidade,
            TextField tfNumero, TextField tfComplemento, TextField tfBairro) {
        tfCEP.setText("");
        tfRua.setText("");
        cbEstado.setValue("");
        tfCidade.setText("");
        tfNumero.setText("");
        tfComplemento.setText("");
        tfBairro.setText("");

        tfCEP.setStyle(VAZIO);
        tfRua.setStyle(VAZIO);
        cbEstado.setStyle(VAZIO);
        tfCidade.setStyle(VAZIO);
        tfNumero.setStyle(VAZIO);
        tfComplemento.setStyle(VAZIO);
        tfBairro.setStyle(VAZIO);
    }

    public void listarEnderecos(EnderecoTableView enderecoTableView, List<Endereco> enderecos) {
        carregarTabela = new Runnable() {
            @Override
            public void run() {
                enderecoTableView.addAllDados(enderecos);
                enderecoTableView.start();
            }
        };

        threadEnderecos = new Thread(carregarTabela);
        threadEnderecos.start();

    }

    public boolean verificarCampos(TextField tfCEP, TextField tfRua, ComboBox cbEstado, TextField tfNumero, TextField tfCidade, TextField tfBairro) {
        boolean cep, cidade, rua, estado, numero, bairro;

        cep = ValidarUtil.validarTextField(tfCEP, 8);
        rua = ValidarUtil.validarTextField(tfRua, 5);
        estado = ValidarUtil.validarComboBox(cbEstado);
        numero = ValidarUtil.validarTextField(tfNumero, 1);
        cidade = ValidarUtil.validarTextField(tfCidade, 4);
        bairro = ValidarUtil.validarTextField(tfBairro, 5);

        return cep && rua && estado && numero && cidade && bairro;
    }

    public void addEndereco(List<Endereco> enderecos, TextField tfCEP, TextField tfRua, ComboBox cbEstado, TextField tfCidade,
            TextField tfNumero, TextField tfComplemento, TextField tfBairro) {
        if (verificarCampos(tfCEP, tfRua, cbEstado, tfNumero, tfCidade, tfBairro)) {
            Endereco endereco = new Endereco();
            endereco.setCepEnd(tfCEP.getText().replaceAll("\\.", "").replaceAll("-", ""));
            endereco.setCidadeEnd(tfCidade.getText());
            endereco.setBairroEnd(tfBairro.getText());
            endereco.setLogradouroEnd(tfRua.getText());
            endereco.setNumeroEnd(Integer.parseInt(tfNumero.getText()));
            endereco.setComplementoEnd(tfComplemento.getText());

            enderecos.add(endereco);

            limparCampos(tfCEP, tfRua, cbEstado, tfCidade, tfNumero, tfComplemento, tfBairro);

            Notifications.create().title("Sucesso!").text("Endereço Inserido Com Sucesso!").hideAfter(Duration.seconds(20)).showConfirm();

        }
    }

    public void removerEndereco(List<Endereco> enderecos, TableView<EnderecoVOTable> tvEnderecos) {
        EnderecoVOTable enderecoVOTable = tvEnderecos.getSelectionModel().getSelectedItem();
        if (tvEnderecos.getSelectionModel().getSelectedItem() != null) {
            for (Endereco end : enderecos) {

                if ((String.valueOf(end.getNumeroEnd()) == null ? enderecoVOTable.getNumero() == null : String.valueOf(end.getNumeroEnd()).equals(enderecoVOTable.getNumero())) && enderecoVOTable.getBairro().equals(end.getBairroEnd())
                        && enderecoVOTable.getCidade().equals(end.getCidadeEnd()) && enderecoVOTable.getRua().equals(end.getLogradouroEnd())) {

                    enderecos.remove(end);

                    Notifications.create().title("Sucesso!").text("Endereço Removido Com Sucesso!").hideAfter(Duration.seconds(20)).showConfirm();
                    break;
                }

            }
        } else {
            AlertUtil.alertAtencao("Atenção", "Não foi selecionado nenhum endereço na tabela!", "Selecione na tabela o endereço que deseja remover!");
        }

    }

}
