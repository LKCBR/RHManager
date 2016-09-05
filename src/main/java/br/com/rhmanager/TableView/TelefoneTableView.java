/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rhmanager.TableView;

import br.com.rhmanager.bean.funcionarios.Telefone;
import br.com.rhmanager.util.MaskUtil;
import br.com.rhmanager.util.RegexUtil;
import br.com.rhmanager.vo.TelefoneVOTable;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author lucas
 */
public class TelefoneTableView {

    private List<Telefone> dados;
    private final ObservableList<TelefoneVOTable> oDados;
    private TableView<TelefoneVOTable> tabela;

    public TelefoneTableView(TableView<TelefoneVOTable> tabela, TableColumn tcNumero) {
        dados = new ArrayList<>();
        oDados = FXCollections.observableArrayList();
        this.tabela = tabela;

        tcNumero.setCellValueFactory(new PropertyValueFactory<>("numero"));

    }

    public void addAllDados(List<Telefone> dados) {
        this.dados = dados;
    }

    public void refreshODados() {

    }

    public void setTableView(TableView tabela) {
        this.tabela = tabela;
    }

    public void onRemoveAll() {
        oDados.clear();
    }

    public void preencherTable() {

        for (Telefone telefone : dados) {
            TelefoneVOTable telefoneVOTable = new TelefoneVOTable(telefone.getIdTelefone(), MaskUtil.MaskAply(RegexUtil.MASK_TEL, telefone.getNumTelefone()));

            oDados.add(telefoneVOTable);
        }

        tabela.setItems(oDados);
    }

    public void start() {
        if (!oDados.isEmpty()) {
            onRemoveAll();
        }
        preencherTable();

    }

}
