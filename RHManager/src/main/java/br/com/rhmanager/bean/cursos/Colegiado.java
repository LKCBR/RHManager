package br.com.rhmanager.bean.cursos;

import br.com.rhmanager.bean.Curso;
import br.com.rhmanager.bean.Funcionario;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author lucas
 */
@Entity
public class Colegiado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idColegiado", nullable = false, unique = true)
    private Long idColegiado;

    @OneToOne
    @JoinColumn(name = "curso", unique = true)
    private Curso colegiado_do_curso;

    @ManyToMany
    @JoinTable(name = "colegiado_has_professores", joinColumns
            = {
                @JoinColumn(name = "idColegiado")}, inverseJoinColumns
            = {
                @JoinColumn(name = "idFuncionario")})
    private List<Funcionario> funcionarios_do_colegiado;

}
