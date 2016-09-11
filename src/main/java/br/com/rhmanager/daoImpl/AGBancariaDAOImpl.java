/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rhmanager.daoImpl;

import br.com.rhmanager.bean.AGBancaria;
import br.com.rhmanager.dao.AGBancariaDAO;
import br.com.rhmanager.util.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author lucas
 */
public class AGBancariaDAOImpl extends HibernateDAO implements AGBancariaDAO {

    @Override
    public List<AGBancaria> listarAgencia() {
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            Criteria criteria = session.createCriteria(AGBancaria.class);

            return criteria.list();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return null;
        } finally {
            if (!session.isConnected()) {
                session.close();
            }
        }

    }

    @Override
    public AGBancaria getAGBByName(String nome) {
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            Criteria criteria = session.createCriteria(AGBancaria.class);
            criteria.add(Restrictions.eq("nomeAGBancaria", nome));
            return (AGBancaria) criteria.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return null;
        } finally {
            if (!session.isConnected()) {
                session.close();
            }
        }
    }

}
