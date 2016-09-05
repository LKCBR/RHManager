package br.com.rhmanager.bean.funcionarios;

import br.com.rhmanager.bean.Funcionario;
import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author lucas
 */
@Entity
public class Endereco implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEndereco", nullable = false, unique = true)
    private Long idEndereco;
    @Column(name = "logradouroEnd", nullable = false, length = 130, columnDefinition = "VARCHAR(130)")
    private String logradouroEnd;
    @Column(name = "numeroEnd", nullable = false, columnDefinition = "VARCHAR(10)")
    private int numeroEnd;
    @Column(name = "estadoEnd", length = 40, columnDefinition = "CHAR(2)")
    private String estadoEnd;
    @Column(name = "cidadeEnd", length = 40, columnDefinition = "VARCHAR(40)")
    private String cidadeEnd;
    @Column(name = "cepEnd", nullable = false, length = 8, columnDefinition = "VARCHAR(8)")
    private String cepEnd;
    @Column(name = "bairroEnd", length = 50, columnDefinition = "VARCHAR(50)")
    private String bairroEnd;
    @Column(name = "complementoEnd", columnDefinition = "TEXT")
    private String complementoEnd;
    @Column(name = "endPrincipal")
    private int endPrincipal;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dtCadastro")
    private Calendar dtCadastro;

    @ManyToOne
    @JoinColumn(name = "funcionario")
    private Funcionario enderecos_funcionario;

    public Long getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Long idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getLogradouroEnd() {
        return logradouroEnd;
    }

    public void setLogradouroEnd(String logradouroEnd) {
        this.logradouroEnd = logradouroEnd;
    }

    public int getNumeroEnd() {
        return numeroEnd;
    }

    public void setNumeroEnd(int numeroEnd) {
        this.numeroEnd = numeroEnd;
    }

    public String getEstadoEnd() {
        return estadoEnd;
    }

    public void setEstadoEnd(String estadoEnd) {
        this.estadoEnd = estadoEnd;
    }

    public String getCidadeEnd() {
        return cidadeEnd;
    }

    public void setCidadeEnd(String cidadeEnd) {
        this.cidadeEnd = cidadeEnd;
    }

    public String getCepEnd() {
        return cepEnd;
    }

    public void setCepEnd(String cepEnd) {
        this.cepEnd = cepEnd;
    }

    public String getBairroEnd() {
        return bairroEnd;
    }

    public void setBairroEnd(String bairroEnd) {
        this.bairroEnd = bairroEnd;
    }

    public String getComplementoEnd() {
        return complementoEnd;
    }

    public void setComplementoEnd(String complementoEnd) {
        this.complementoEnd = complementoEnd;
    }

    public int getEndPrincipal() {
        return endPrincipal;
    }

    public void setEndPrincipal(int endPrincipal) {
        this.endPrincipal = endPrincipal;
    }

    public Calendar getDtCadastro() {
        return dtCadastro;
    }

    public void setDtCadastro(Calendar dtCadastro) {
        this.dtCadastro = dtCadastro;
    }

    public Funcionario getEnderecos_funcionario() {
        return enderecos_funcionario;
    }

    public void setEnderecos_funcionario(Funcionario enderecos_funcionario) {
        this.enderecos_funcionario = enderecos_funcionario;
    }

}
