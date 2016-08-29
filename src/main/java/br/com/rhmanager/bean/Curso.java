package br.com.rhmanager.bean;

import br.com.rhmanager.bean.cursos.Colegiado;
import br.com.rhmanager.bean.cursos.Disciplina;
import br.com.rhmanager.bean.cursos.Turma;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author lucas
 */
@Entity
public class Curso implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCurso", unique = true, nullable = false)
    private Long idCurso;

    @Column(name = "nome", unique = true, nullable = false)
    private String nome;

    @Column(name = "periodos", nullable = false)
    private int periodos;

    @ManyToOne
    @JoinColumn(name = "coordinator", unique = true, nullable = false)
    private Funcionario coordinator;

    @OneToMany(mappedBy = "curso")
    private List<Disciplina> disciplinas;

    @OneToOne(mappedBy = "colegiado_do_curso")
    @JoinColumn(name = "colegiado_do_curso")
    private Colegiado colegiado;
    
    @OneToMany(mappedBy = "curso_turma")
    private List<Turma> turmas;
    
}
