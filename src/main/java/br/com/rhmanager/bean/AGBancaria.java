package br.com.rhmanager.bean;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author lucas
 */
@Entity
public class AGBancaria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAGBancaria", nullable = false, unique = true)
    private Long idAGBancaria;

    @Column(name = "nomeAGBancaria", nullable = false, unique = true)
    private String nomeAGBancaria;

    @OneToMany(mappedBy = "aGBancaria")
    private List<Funcionario> funcionarios;

    public Long getIdAGBancaria() {
        return idAGBancaria;
    }

    public void setIdAGBancaria(Long idAGBancaria) {
        this.idAGBancaria = idAGBancaria;
    }

    public String getNomeAGBancaria() {
        return nomeAGBancaria;
    }

    public void setNomeAGBancaria(String nomeAGBancaria) {
        this.nomeAGBancaria = nomeAGBancaria;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

}
