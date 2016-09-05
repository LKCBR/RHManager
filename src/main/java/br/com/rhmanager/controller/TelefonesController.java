/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rhmanager.controller;

import br.com.rhmanager.TableView.TelefoneTableView;
import br.com.rhmanager.bean.funcionarios.Telefone;
import br.com.rhmanager.util.ValidarUtil;
import br.com.rhmanager.vo.TelefoneVOTable;
import java.util.List;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 *
 * @author lucas
 */
public class TelefonesController {

    public static String VAZIO = "-fx-effect: dropshadow(three-pass-box, rgba(0, 0, 0,0.8), 0,0,0, 0);";

    Runnable carregarTabelaTelefones;
    Thread threadTelefones;

    public void listarTelefones(TelefoneTableView telefoneTableView, List<Telefone> telefones) {
        carregarTabelaTelefones = new Runnable() {
            @Override
            public void run() {
                telefoneTableView.addAllDados(telefones);
                telefoneTableView.start();
            }
        };

        threadTelefones = new Thread(carregarTabelaTelefones);
        threadTelefones.start();

    }

    public void limparCampo(TextField tfTelefone) {
        tfTelefone.setText("");
        tfTelefone.setStyle(VAZIO);
    }

    public void inserirTelefone(TableView tvTelefones, TextField tfTelefone, List<Telefone> telefones) {
        if (ValidarUtil.validarTextField(tfTelefone, 11)) {
            Telefone telefone = new Telefone();
            telefone.setNumTelefone(tfTelefone.getText().replaceAll("\\(", "").replaceAll("\\)", "").replaceAll("-", "").replaceAll(" ", ""));

            telefones.add(telefone);
            limparCampo(tfTelefone);

        }

    }

    public void removerTelefone(TableView<TelefoneVOTable> tvTelefones, List<Telefone> telefones) {
        if (tvTelefones.getSelectionModel().getSelectedItem() != null) {
            for (Telefone telefone : telefones) {
                if (telefone.getNumTelefone().equals(tvTelefones.getSelectionModel().getSelectedItem().getNumero().replaceAll("\\(", "").replaceAll("\\)", "").replaceAll("-", "").replaceAll(" ", ""))) {
                    telefones.remove(telefone);
                }
            }
        }
    }

}
