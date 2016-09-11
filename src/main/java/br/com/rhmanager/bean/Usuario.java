/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rhmanager.bean;

import br.com.rhmanager.util.DateUtil;
import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author lucas
 */
@Entity
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUsuario", nullable = false, unique = true)
    private Long idUsuario;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "password", nullable = false, length = 32)
    private String password;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dt_cadastro", nullable = false)
    private Calendar dt_cadastro;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dt_ultima_alteracao", nullable = true)
    private Calendar dt_ultima_alteracao;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "permissao")
    private Permissao permissao_usuario;

    @OneToOne(fetch = FetchType.EAGER)
    private Funcionario usuario_funcionario;

    @PrePersist
    void setTimeStampCadastro() {
        this.dt_cadastro = DateUtil.getDataHoraAtual();
    }

    @PreUpdate
    void setTimeStampUpdate() {
        this.dt_ultima_alteracao = DateUtil.getDataHoraAtual();
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Calendar getDt_cadastro() {
        return dt_cadastro;
    }

    public void setDt_cadastro(Calendar dt_cadastro) {
        this.dt_cadastro = dt_cadastro;
    }

    public Permissao getPermissao_usuario() {
        return permissao_usuario;
    }

    public void setPermissao_usuario(Permissao permissao_usuario) {
        this.permissao_usuario = permissao_usuario;
    }

    public Funcionario getUsuario_funcionario() {
        return usuario_funcionario;
    }

    public void setUsuario_funcionario(Funcionario usuario_funcionario) {
        this.usuario_funcionario = usuario_funcionario;
    }

    public Calendar getDt_ultima_alteracao() {
        return dt_ultima_alteracao;
    }

    public void setDt_ultima_alteracao(Calendar dt_ultima_alteracao) {
        this.dt_ultima_alteracao = dt_ultima_alteracao;
    }

}
