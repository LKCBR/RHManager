/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rhmanager.dao;

import br.com.rhmanager.bean.Funcionario;
import java.util.List;

/**
 *
 * @author lucas
 */
public interface FuncionarioDAO {

    public List<Funcionario> getAllFuncionarios();

    public Funcionario getFuncionarioByCpf(String cpf);

}
