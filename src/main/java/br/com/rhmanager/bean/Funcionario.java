package br.com.rhmanager.bean;

import br.com.rhmanager.bean.cursos.Colegiado;
import br.com.rhmanager.bean.cursos.Horario;
import br.com.rhmanager.bean.funcionarios.Cargo;
import br.com.rhmanager.bean.funcionarios.Endereco;
import br.com.rhmanager.bean.funcionarios.Telefone;
import br.com.rhmanager.bean.funcionarios.Titulo;
import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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

    @Temporal(TemporalType.DATE)
    @Column(name = "dt_nascimento")
    private Calendar dt_nascimento;

    @Column(name = "email")
    private String email;

    @Column(name = "status")
    private String status;

    @Column(name = "agencia")
    private String agencia;

    @Column(name = "conta")
    private String conta;

    @Column(name = "sexo")
    private String sexo;

    @Column(name = "pis", unique = true)
    private String pis;

    @Column(name = "inss", unique = true)
    private String inss;

    @Column(name = "ativo")
    private int ativo;

    @OneToMany(mappedBy = "coordinator")
    private List<Curso> cursos_coordenados;

    @ManyToMany(mappedBy = "funcionarios_do_colegiado")
    private List<Colegiado> colegiados;

    @OneToMany(mappedBy = "professor_horario")
    private List<Horario> horarios;

    @ManyToMany()
    @JoinColumn(name = "cargos")
    @JoinTable(name = "funcionario_has_cargos", joinColumns
            = {
                @JoinColumn(name = "idFuncionario")}, inverseJoinColumns
            = {
                @JoinColumn(name = "idCargos")})

    private List<Cargo> cargos;

    @OneToMany(mappedBy = "telefone_funcionario", cascade = CascadeType.ALL)
    private List<Telefone> telefones;

    @OneToMany(mappedBy = "titulos", cascade = CascadeType.ALL)
    private List<Titulo> titulos;

    @OneToMany(mappedBy = "enderecos_funcionario", cascade = CascadeType.ALL)
    private List<Endereco> enderecos;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "agenciaBancaria")
    private AGBancaria aGBancaria;

    @OneToOne(mappedBy = "usuario_funcionario", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Usuario usuario;

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

    public Calendar getDt_nascimento() {
        return dt_nascimento;
    }

    public void setDt_nascimento(Calendar dt_nascimento) {
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

    public List<Cargo> getCargos() {
        return cargos;
    }

    public void setCargos(List<Cargo> cargos) {
        this.cargos = cargos;
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

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public AGBancaria getaGBancaria() {
        return aGBancaria;
    }

    public void setaGBancaria(AGBancaria aGBancaria) {
        this.aGBancaria = aGBancaria;
    }

    public String getSexo() {
        if (sexo.equals("M")) {
            return "MASCULINO";
        } else if (sexo.equals("F")) {
            return "FEMININO";
        } else {
            return null;
        }

    }

    public void setSexo(String sexo) {
        if (sexo.equals("MASCULINO")) {
            this.sexo = "M";
        } else if (sexo.equals("FEMININO")) {
            this.sexo = "F";
        }

    }

    public String getPis() {
        return pis;
    }

    public void setPis(String pis) {
        this.pis = pis;
    }

    public String getInss() {
        return inss;
    }

    public void setInss(String inss) {
        this.inss = inss;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getAtivo() {
        return ativo;
    }

    public void setAtivo(int ativo) {
        this.ativo = ativo;
    }

}
