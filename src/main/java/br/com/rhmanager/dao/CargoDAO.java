package br.com.rhmanager.dao;

import br.com.rhmanager.bean.funcionarios.Cargo;
import java.util.List;

/**
 *
 * @author lucas
 */
public interface CargoDAO {
    
    public List<Cargo> listarCargos();
    
    public Cargo getCargoByName(String nome);
}
