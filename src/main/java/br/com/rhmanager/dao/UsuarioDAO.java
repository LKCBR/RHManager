/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rhmanager.dao;

import br.com.rhmanager.bean.Usuario;

/**
 *
 * @author lucas
 */
public interface UsuarioDAO {

    public Usuario verificarLogin(String email, String senha);
}
