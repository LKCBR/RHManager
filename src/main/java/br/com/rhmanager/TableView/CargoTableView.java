package br.com.rhmanager.TableView;

import br.com.rhmanager.bean.funcionarios.Cargo;
import br.com.rhmanager.vo.CargoVOTable;
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
public class CargoTableView {

    private List<Cargo> dados;
    private final ObservableList<CargoVOTable> oDados;
    private TableView<CargoVOTable> tabela;

    public CargoTableView(TableView tabela, TableColumn tcCargo) {
        dados = new ArrayList<>();
        oDados = FXCollections.observableArrayList();
        this.tabela = tabela;

        tcCargo.setCellValueFactory(new PropertyValueFactory<CargoVOTable, String>("cargo"));

    }

    public void addAllDados(List<Cargo> dados) {
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
        for (Cargo cargo : dados) {
            CargoVOTable cvot = new CargoVOTable(cargo.getIdCargos(), cargo.getTitulo());

            oDados.add(cvot);
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
