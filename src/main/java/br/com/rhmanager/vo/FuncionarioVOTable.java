package br.com.rhmanager.vo;

import impl.org.controlsfx.i18n.SimpleLocalizedStringProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author lucas
 */
public class FuncionarioVOTable {

    private SimpleStringProperty nome;
    private SimpleStringProperty cpf;
    private SimpleStringProperty cargo;
    private SimpleStringProperty status;

    public FuncionarioVOTable(String nome, String cpf, String cargo, String status) {
        this.nome = new SimpleStringProperty(nome);
        this.cpf = new SimpleLocalizedStringProperty(cpf);
        this.cargo = new SimpleStringProperty(cargo);
        this.status = new SimpleStringProperty(status);
    }

    public String getNome() {
        return nome.get();
    }

    public void setNome(SimpleStringProperty nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf.get();
    }

    public void setCpf(SimpleStringProperty cpf) {
        this.cpf = cpf;
    }

    public String getCargo() {
        return cargo.get();
    }

    public void setCargo(SimpleStringProperty cargo) {
        this.cargo = cargo;
    }

    public String getStatus() {
        return status.get();
    }

    public void setStatus(SimpleStringProperty status) {
        this.status = status;
    }

}
