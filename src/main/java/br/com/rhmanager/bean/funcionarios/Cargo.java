package br.com.rhmanager.bean.funcionarios;

import br.com.rhmanager.bean.Funcionario;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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

    @ManyToMany(mappedBy = "cargos")
    private List<Funcionario> funcionarios_cargos;

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

    public List<Funcionario> getFuncionarios_cargos() {
        return funcionarios_cargos;
    }

    public void setFuncionarios_cargos(List<Funcionario> funcionarios_cargos) {
        this.funcionarios_cargos = funcionarios_cargos;
    }

}
