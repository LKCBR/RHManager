/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rhmanager.bean.instituicao;

import br.com.rhmanager.bean.cursos.Horario;
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
public class SalasAndLabs implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSalasAndLabs", nullable = false, unique = true)
    private Long idSalasAndLabs;

    @Column(name = "numero", nullable = false, unique = true)
    private int numero;

    @Column(name = "andar", nullable = false)
    private int andar;

    @Column(name = "complemento")
    private String complemento;

    @ManyToOne
    @JoinColumn(name = "tipo")
    private TiposSalasAndLabs tipo_sala;
    
    @OneToMany(mappedBy = "sala_horario")
    private List<Horario> horarios;
    

}
