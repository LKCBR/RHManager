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
public class Cargos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCargos", nullable = false, unique = true)
    private Long idCargos;

    @Column(name = "titulo", nullable = false, unique = true)
    private String titulo;
    
    @OneToMany(mappedBy = "cargo")
    private List<Funcionario> funcionarios;
    

}
