package br.com.rhmanager.bean.cursos;

import br.com.rhmanager.bean.Funcionario;
import br.com.rhmanager.bean.instituicao.SalasAndLabs;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
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
public class Horario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idHorario", nullable = false, unique = true)
    private Long idHorario;

    @ManyToOne
    @JoinColumn(name = "turma", nullable = false)
    private Turma horario_turma;

    @ManyToOne
    @JoinColumn(name = "professor", nullable = false)
    private Funcionario professor_horario;

    @ManyToOne
    @JoinColumn(name = "sala", nullable = false)
    private SalasAndLabs sala_horario;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dt_cadastro", nullable = false)
    private Calendar dt_cadastro;

    @ManyToOne
    @JoinColumn(name = "disciplina", nullable = false)
    private Disciplina disciplina_horario;

    @Temporal(TemporalType.TIME)
    @Column(name = "de_hora", nullable = false)
    private Date de_hora;

    @Temporal(TemporalType.TIME)
    @Column(name = "ate_hora", nullable = false)
    private Date ate_hora;

}
