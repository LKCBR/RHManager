package br.com.rhmanager.bean.funcionarios;

import br.com.rhmanager.bean.Funcionario;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author lucas
 */
@Entity
public class Titulo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTitulo")
    private Long idTitulo;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "tituloem")
    private String tituloem;

    @ManyToOne
    @JoinColumn(name = "funcionario")
    private Funcionario titulos;

    public Long getIdTitulo() {
        return idTitulo;
    }

    public void setIdTitulo(Long idTitulo) {
        this.idTitulo = idTitulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTituloem() {
        return tituloem;
    }

    public void setTituloem(String tituloem) {
        this.tituloem = tituloem;
    }

    public Funcionario getTitulos() {
        return titulos;
    }

    public void setTitulos(Funcionario titulos) {
        this.titulos = titulos;
    }
    
    
    

}
