package br.com.rhmanager.vo;

import impl.org.controlsfx.i18n.SimpleLocalizedStringProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author lucas
 */
public class TituloVOTable {

    private SimpleStringProperty id;
    private SimpleStringProperty titulo;
    private SimpleStringProperty especificacao;

    public TituloVOTable(Long id, String titulo, String especificacao) {
        if (id != null) {
            this.id = new SimpleStringProperty(id.toString());
        }
        this.titulo = new SimpleStringProperty(titulo);
        this.especificacao = new SimpleLocalizedStringProperty(especificacao);

    }

    public String getId() {
        return id.get();
    }

    public void setId(SimpleStringProperty id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo.get();
    }

    public void setTitulo(SimpleStringProperty titulo) {
        this.titulo = titulo;
    }

    public String getEspecificacao() {
        return especificacao.get();
    }

    public void setEspecificacao(SimpleStringProperty especificacao) {
        this.especificacao = especificacao;
    }

}
