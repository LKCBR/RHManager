package br.com.rhmanager.bean.funcionarios;

import br.com.rhmanager.bean.Funcionario;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author lucas
 */
@Entity
public class Telefone implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTelefone")
    private Long idTelefone;

    @Column(name = "numTelefone")
    private String numTelefone;

    @ManyToOne
    @JoinColumn(name = "funcionarioTel")
    private Funcionario telefone_funcionario;

    public Long getIdTelefone() {
        return idTelefone;
    }

    public void setIdTelefone(Long idTelefone) {
        this.idTelefone = idTelefone;
    }

    public String getNumTelefone() {
        return numTelefone;
    }

    public void setNumTelefone(String numTelefone) {
        this.numTelefone = numTelefone;
    }

    public Funcionario getTelefone_funcionario() {
        return telefone_funcionario;
    }

    public void setTelefone_funcionario(Funcionario telefone_funcionario) {
        this.telefone_funcionario = telefone_funcionario;
    }

}
