package br.com.rhmanager.bean;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author lucas
 */
@Entity
public class Permissao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPermissao", nullable = false, unique = true)
    private Long idPermissao;

    @Column(name = "titulo", nullable = false, unique = true)
    private String titulo;

    @Column(name = "codigo")
    private String codigo;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dt_cadastro")
    private Calendar dt_cadastro;

    @OneToMany(mappedBy = "permissao_usuario", fetch = FetchType.LAZY)
    private List<Usuario> usuarios;

}
