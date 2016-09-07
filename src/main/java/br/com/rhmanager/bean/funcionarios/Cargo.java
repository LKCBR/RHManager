package br.com.rhmanager.bean.funcionarios;

import br.com.rhmanager.bean.Funcionario;
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
public class Cargo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCargos", nullable = false, unique = true)
    private Long idCargos;

    @Column(name = "titulo", nullable = false, unique = true)
    private String titulo;

    @OneToMany(mappedBy = "cargo")
    private List<Funcionario> funcionarios;

    public Long getIdCargos() {
        return idCargos;
    }

    public void setIdCargos(Long idCargos) {
        this.idCargos = idCargos;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

}
