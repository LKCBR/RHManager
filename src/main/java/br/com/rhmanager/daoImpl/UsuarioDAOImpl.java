/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rhmanager.daoImpl;

import br.com.rhmanager.bean.Usuario;
import br.com.rhmanager.dao.UsuarioDAO;
import br.com.rhmanager.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author lucas
 */
public class UsuarioDAOImpl extends HibernateDAO implements UsuarioDAO {

    @Override
    public Usuario verificarLogin(String email, String senha) {
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            Criteria criteria = session.createCriteria(Usuario.class);
            criteria.add(Restrictions.eq("email", email)).add(Restrictions.eq("password", senha));
            return (Usuario) criteria.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (!session.isConnected()) {
                session.close();
            }
        }
    }

}
