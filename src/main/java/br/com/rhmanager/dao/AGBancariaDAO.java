/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rhmanager.dao;

import br.com.rhmanager.bean.AGBancaria;
import java.util.List;

/**
 *
 * @author lucas
 */
public interface AGBancariaDAO {

    public List<AGBancaria> listarAgencia();

    public AGBancaria getAGBByName(String nome);

}
