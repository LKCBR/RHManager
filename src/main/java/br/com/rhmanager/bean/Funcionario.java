package br.com.rhmanager.bean;


import br.com.rhmanager.bean.cursos.Colegiado;
import br.com.rhmanager.bean.cursos.Horario;
import br.com.rhmanager.bean.funcionarios.Cargo;
import br.com.rhmanager.bean.funcionarios.Endereco;
import br.com.rhmanager.bean.funcionarios.Telefone;
import br.com.rhmanager.bean.funcionarios.Titulo;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author lucas
 */
@Entity
public class Funcionario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFuncionario", nullable = false, unique = true)
    private Long idFuncionario;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "cpf", nullable = false)
    private String cpf;

    @Column(name = "rg")
    private String rg;

    @Column(name = "dt_nascimento")
    private String dt_nascimento;

    @Column(name = "email")
    private String email;

    @Column(name = "status")
    private String status;

    @OneToMany(mappedBy = "coordinator")
    private List<Curso> cursos_coordenados;

    @ManyToMany(mappedBy = "funcionarios_do_colegiado")
    private List<Colegiado> colegiados;

    @OneToMany(mappedBy = "professor_horario")
    private List<Horario> horarios;

    @ManyToOne
    @JoinColumn(name = "cargo")
    private Cargo cargo;

    @OneToMany(mappedBy = "telefone_funcionario", cascade = CascadeType.ALL)
    private List<Telefone> telefones;

    @OneToMany(mappedBy = "titulos", cascade = CascadeType.ALL)
    private List<Titulo> titulos;

    @OneToMany(mappedBy = "enderecos_funcionario", cascade = CascadeType.ALL)
    private List<Endereco> enderecos;

    public Long getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Long idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getDt_nascimento() {
        return dt_nascimento;
    }

    public void setDt_nascimento(String dt_nascimento) {
        this.dt_nascimento = dt_nascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Curso> getCursos_coordenados() {
        return cursos_coordenados;
    }

    public void setCursos_coordenados(List<Curso> cursos_coordenados) {
        this.cursos_coordenados = cursos_coordenados;
    }

    public List<Colegiado> getColegiados() {
        return colegiados;
    }

    public void setColegiados(List<Colegiado> colegiados) {
        this.colegiados = colegiados;
    }

    public List<Horario> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<Horario> horarios) {
        this.horarios = horarios;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public List<Titulo> getTitulos() {
        return titulos;
    }

    public void setTitulos(List<Titulo> titulos) {
        this.titulos = titulos;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }
    
    

}
