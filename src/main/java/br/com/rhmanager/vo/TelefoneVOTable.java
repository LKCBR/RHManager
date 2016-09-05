package br.com.rhmanager.vo;

import impl.org.controlsfx.i18n.SimpleLocalizedStringProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author lucas
 */
public class TelefoneVOTable {

    private SimpleStringProperty id;
    private SimpleStringProperty numero;

    public TelefoneVOTable(Long id, String numero) {
        if (id != null) {
            this.id = new SimpleStringProperty(id.toString());
        }
        this.numero = new SimpleLocalizedStringProperty(numero);

    }

    public String getId() {
        return id.get();
    }

    public void setId(SimpleStringProperty id) {
        this.id = id;
    }

    public String getNumero() {
        return numero.get();
    }

    public void setNumero(SimpleStringProperty numero) {
        this.numero = numero;
    }

}
