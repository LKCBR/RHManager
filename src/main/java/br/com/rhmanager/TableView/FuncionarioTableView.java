package br.com.rhmanager.TableView;

import br.com.rhmanager.bean.Funcionario;
import br.com.rhmanager.vo.FuncionarioVOTable;
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
public class FuncionarioTableView {

    private List<Funcionario> dados;
    private final ObservableList<FuncionarioVOTable> oDados;
    private TableView<FuncionarioVOTable> tabela;

    public FuncionarioTableView(TableView tabela, TableColumn tcNome, TableColumn tcCPF, TableColumn tcCargos, TableColumn tcStatus) {
        dados = new ArrayList<>();
        oDados = FXCollections.observableArrayList();
        this.tabela = tabela;

        tcNome.setCellValueFactory(new PropertyValueFactory<FuncionarioVOTable, String>("nome"));
        tcCPF.setCellValueFactory(new PropertyValueFactory<FuncionarioVOTable, String>("cpf"));
        tcCargos.setCellValueFactory(new PropertyValueFactory<FuncionarioVOTable, String>("cargos"));
        tcStatus.setCellValueFactory(new PropertyValueFactory<FuncionarioVOTable, String>("status"));

    }

    public void addAllDados(List<Funcionario> dados) {
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
        for (Funcionario funcionario : dados) {
            FuncionarioVOTable fvot = new FuncionarioVOTable(
                    funcionario.getIdFuncionario(),
                    funcionario.getNome(),
                    funcionario.getCpf(),
                    funcionario.getCargo().getTitulo(),
                    funcionario.getStatus());
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
