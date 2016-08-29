package br.com.rhmanager.bean.cursos;

import br.com.rhmanager.bean.Curso;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author lucas
 */
@Entity
public class PeriodoCurso implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPeriodoCurso", nullable = false, unique = true)
    private Long idPeriodoCurso;

    @Column(name = "periodo", nullable = false)
    private String periodo;

    @Temporal(TemporalType.TIME)
    @Column(name = "de_hora", nullable = false)
    private Date de_hora;

    @Temporal(TemporalType.TIME)
    @Column(name = "ate_hora", nullable = false)
    private Date ate_hora;

    @ManyToMany
    @JoinTable(name = "periodos_cursos", joinColumns
            = {
                @JoinColumn(name = "idPeriodoCurso")}, inverseJoinColumns
            = {
                @JoinColumn(name = "idCurso")})
    private List<Curso> cursos;
    
    
    

}
