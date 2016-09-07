
package br.com.rhmanager.TableView;

import br.com.rhmanager.bean.funcionarios.Titulo;
import br.com.rhmanager.vo.TituloVOTable;
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
public class TituloTableView {
      private List<Titulo> dados;
    private final ObservableList<TituloVOTable> oDados;
    private TableView<TituloVOTable> tabela;

    public TituloTableView(TableView tabela, TableColumn tcTitulo, TableColumn tcEspecificacao) {
        dados = new ArrayList<>();
        oDados = FXCollections.observableArrayList();
        this.tabela = tabela;

        tcTitulo.setCellValueFactory(new PropertyValueFactory<TituloVOTable, String>("titulo"));
        tcEspecificacao.setCellValueFactory(new PropertyValueFactory<TituloVOTable, String>("especificacao"));
       

    }

    public void addAllDados(List<Titulo> dados) {
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
        for (Titulo titulo : dados) {
            TituloVOTable fvot = new TituloVOTable(titulo.getIdTitulo(), titulo.getTitulo(), titulo.getTituloem());
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
