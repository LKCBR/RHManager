package br.com.rhmanager.bean.instituicao;

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
public class TiposSalasAndLabs implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTipoSalasAndLabs")
    private Long idTipoSalasAndLabs;

    @Column(name = "Tipo", unique = true, nullable = false)
    private String tipo;
    
    @OneToMany(mappedBy = "tipo_sala")
    private List<SalasAndLabs> salasAndLabs;
    
    
    

}
