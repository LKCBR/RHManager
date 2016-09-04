package br.com.rhmanager.vo;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author lucas
 */
public class EnderecoVOTable {

    private SimpleStringProperty id;
    private SimpleStringProperty cidade;
    private SimpleStringProperty bairro;
    private SimpleStringProperty rua;
    private SimpleStringProperty numero;

    public EnderecoVOTable(Long id, String cidade, String bairro, String rua, String numero) {
        this.id = new SimpleStringProperty(id.toString());
        this.cidade = new SimpleStringProperty(cidade);
        this.bairro = new SimpleStringProperty(bairro);
        this.rua = new SimpleStringProperty(rua);
        this.numero = new SimpleStringProperty(numero);
    }

    public String getId() {
        return id.toString();
    }

    public void setId(SimpleStringProperty id) {
        this.id = id;
    }

    public String getCidade() {
        return cidade.get();
    }

    public void setCidade(SimpleStringProperty cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro.get();
    }

    public void setBairro(SimpleStringProperty bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua.get();
    }

    public void setRua(SimpleStringProperty rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero.get();
    }

    public void setNumero(SimpleStringProperty numero) {
        this.numero = numero;
    }

}
