package br.com.rhmanager.bean.cursos;

import br.com.rhmanager.bean.Curso;
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

/**
 *
 * @author lucas
 */
@Entity
public class Turma implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTurma", nullable = false, unique = true)
    private Long idTurma;

    @Column(name = "letra", nullable = false, length = 1)
    private char letra;

    @Column(name = "periodo", nullable = false, length = 2)
    private String periodo;

    @ManyToOne
    @JoinColumn(name = "curso", nullable = false)
    private Curso curso_turma;
    
    @OneToMany(mappedBy = "horario_turma")
    private List<Horario> horarios; 

    

}
