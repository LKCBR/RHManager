package br.com.rhmanager.vo;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author lucas
 */
public class CargoVOTable {

    private SimpleStringProperty id;
    private SimpleStringProperty cargo;

    public CargoVOTable(Long id, String cargo) {
        if (id != null) {
            this.id = new SimpleStringProperty(id.toString());
        }

        this.cargo = new SimpleStringProperty(cargo);
    }

    public String getId() {
        return id.get();
    }

    public void setId(SimpleStringProperty id) {
        this.id = id;
    }

    public String getCargo() {
        return cargo.get();
    }

    public void setCargo(SimpleStringProperty cargo) {
        this.cargo = cargo;
    }

}
