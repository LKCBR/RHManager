package br.com.rhmanager.controller;

import br.com.rhmanager.TableView.TituloTableView;
import br.com.rhmanager.bean.funcionarios.Titulo;
import br.com.rhmanager.util.ValidarUtil;
import br.com.rhmanager.vo.TituloVOTable;
import java.util.List;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 *
 * @author lucas
 */
public class TituloController {

    public static String VAZIO = "-fx-effect: dropshadow(three-pass-box, rgba(0, 0, 0,0.8), 0,0,0, 0);";

    Thread threadTitulos;
    Runnable carregarTabela;

    public void listarTitulos(TituloTableView tituloTableView, List<Titulo> titulos) {
        carregarTabela = new Runnable() {
            @Override
            public void run() {
                tituloTableView.addAllDados(titulos);
                tituloTableView.start();
            }
        };
        threadTitulos = new Thread(carregarTabela);
        threadTitulos.start();

    }

    public void limparCampos(TextField tfTitulo, TextField tfEspecificacao) {
        tfEspecificacao.setText("");
        tfTitulo.setText("");

        tfEspecificacao.setStyle(VAZIO);
        tfTitulo.setStyle(VAZIO);
    }

    public void inserirTitulo(List<Titulo> titulos, TextField tfTitulo, TextField tfEspecificacao) {
        if (ValidarUtil.validarTextField(tfTitulo, 5) && ValidarUtil.validarTextField(tfEspecificacao, 5)) {
            Titulo titulo = new Titulo();
            titulo.setTitulo(tfTitulo.getText());
            titulo.setTituloem(tfEspecificacao.getText());
            titulos.add(titulo);

            limparCampos(tfTitulo, tfEspecificacao);

            Notifications.create().title("Sucesso!").text("Título Inserido Com Sucesso!").hideAfter(Duration.seconds(20)).showConfirm();
        }

    }

    public void removerTitulo(List<Titulo> titulos, TableView<TituloVOTable> tvTitulos) {
        TituloVOTable tituloVOTable = tvTitulos.getSelectionModel().getSelectedItem();
        if (tituloVOTable != null) {
            for (Titulo titulo : titulos) {
                if (titulo.getTitulo().equals(tituloVOTable.getTitulo()) && titulo.getTituloem().equals(tituloVOTable.getEspecificacao())) {
                    titulos.remove(titulo);

                    Notifications.create().title("Sucesso!").text("Título Removido Com Sucesso!").hideAfter(Duration.seconds(20)).showConfirm();

                    break;
                }
            }
        }
    }

}
