/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rhmanager.dao;

import br.com.rhmanager.bean.Funcionario;
import br.com.rhmanager.bean.funcionarios.Cargo;
import java.util.List;

/**
 *
 * @author lucas
 */
public interface FuncionarioDAO {

    public List<Funcionario> getAllFuncionarios();

    public Funcionario getFuncionarioByCpf(String cpf);

    public Funcionario getFuncionarioById(Long id);

    public List<Funcionario> getFuncionariosBusca(String nome, String cpf, Cargo cargo);

}
