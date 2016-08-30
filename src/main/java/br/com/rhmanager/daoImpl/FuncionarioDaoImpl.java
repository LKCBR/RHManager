/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rhmanager.daoImpl;

import br.com.rhmanager.bean.Funcionario;
import br.com.rhmanager.dao.FuncionarioDAO;
import br.com.rhmanager.util.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author lucas
 */
public class FuncionarioDAOImpl extends HibernateDAO implements FuncionarioDAO {

    @Override
    public List<Funcionario> getAllFuncionarios() {
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            Criteria criteria = session.createCriteria(Funcionario.class);
            return criteria.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public Funcionario getFuncionarioByCpf(String cpf) {
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            Criteria criteria = session.createCriteria(Funcionario.class);
            criteria.add(Restrictions.eq("cpf", cpf));
            return (Funcionario) criteria.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public Funcionario getFuncionarioById(Long id) {
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            Criteria criteria = session.createCriteria(Funcionario.class);
            criteria.add(Restrictions.eq("idFuncionario", id));
            return (Funcionario) criteria.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

}
