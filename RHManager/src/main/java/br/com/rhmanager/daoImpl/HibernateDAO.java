/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rhmanager.daoImpl;

import br.com.rhmanager.util.HibernateUtil;
import java.sql.Timestamp;
import javax.transaction.Transactional;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author lucas
 */
public abstract class HibernateDAO {

    public void insert(Object obj) throws Exception {
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateUtil.getSession();
            transaction = session.beginTransaction();
            session.save(obj);
            session.flush();
            transaction.commit();

        } finally {

            session.close();

        }
    }

    @Transactional
    public void update(Object obj) throws Exception {
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateUtil.getSession();
            transaction = session.beginTransaction();
            session.update(obj);
            session.flush();
            transaction.commit();

        } finally {
            session.close();

        }
    }

    public void excluir(Object obj) throws Exception {
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateUtil.getSession();
            transaction = session.beginTransaction();
            session.delete(obj);
            session.flush();
            transaction.commit();

        } finally {
            session.close();
        }
    }

    public Timestamp getHoraServer() {
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            session.beginTransaction();
            SQLQuery query = session.createSQLQuery("SELECT NOW()");
            Timestamp time = (Timestamp) query.uniqueResult();
            return time;
        } catch (HibernateException e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }

    }
}
