/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rhmanager.TableView;

import br.com.rhmanager.bean.funcionarios.Endereco;
import br.com.rhmanager.vo.EnderecoVOTable;
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
public class EnderecoTableView {
    
    private List<Endereco> dados;
    private final ObservableList<EnderecoVOTable> oDados;
    private TableView<EnderecoVOTable> tabela;
    
    public EnderecoTableView(TableView tabela, TableColumn tcCidade, TableColumn tcBairro, TableColumn tcRua, TableColumn tcNumero) {
        dados = new ArrayList<>();
        oDados = FXCollections.observableArrayList();
        this.tabela = tabela;
        
        tcCidade.setCellValueFactory(new PropertyValueFactory<EnderecoVOTable, String>("cidade"));
        tcBairro.setCellValueFactory(new PropertyValueFactory<EnderecoVOTable, String>("bairro"));
        tcRua.setCellValueFactory(new PropertyValueFactory<EnderecoVOTable, String>("rua"));
        tcNumero.setCellValueFactory(new PropertyValueFactory<EnderecoVOTable, String>("numero"));
        
    }
    
    public void addAllDados(List<Endereco> dados) {
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
        for (Endereco endereco : dados) {
            EnderecoVOTable fvot = new EnderecoVOTable(
                    endereco.getIdEndereco(),
                    endereco.getCidadeEnd(),
                    endereco.getBairroEnd(),
                    endereco.getLogradouroEnd(),
                    String.valueOf(endereco.getNumeroEnd()));
            
            oDados.add(fvot);
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
