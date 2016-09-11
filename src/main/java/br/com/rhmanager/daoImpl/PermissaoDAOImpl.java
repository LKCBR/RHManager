package br.com.rhmanager.daoImpl;

import br.com.rhmanager.bean.Permissao;
import br.com.rhmanager.dao.PermissaoDAO;
import br.com.rhmanager.util.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author lucas
 */
public class PermissaoDAOImpl extends HibernateDAO implements PermissaoDAO {

    @Override
    public List<Permissao> getPermissoes() {
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            Criteria criteria = session.createCriteria(Permissao.class);

            return criteria.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (!session.isConnected()) {
                session.close();
            }
        }
    }

    @Override
    public Permissao getPermissaoByName(String permissao) {
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            Criteria criteria = session.createCriteria(Permissao.class);
            criteria.add(Restrictions.eq("titulo", permissao));

            return (Permissao) criteria.uniqueResult();
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
