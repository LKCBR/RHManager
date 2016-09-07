package br.com.rhmanager.daoImpl;

import br.com.rhmanager.bean.funcionarios.Cargo;
import br.com.rhmanager.dao.CargoDAO;
import br.com.rhmanager.util.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author lucas
 */
public class CargoDAOImpl extends HibernateDAO implements CargoDAO {

    @Override
    public List<Cargo> listarCargos() {
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            Criteria criteria = session.createCriteria(Cargo.class);

            return criteria.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public Cargo getCargoByName(String nome) {
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            Criteria criteria = session.createCriteria(Cargo.class);
            criteria.add(Restrictions.eq("titulo", nome));
            return (Cargo) criteria.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

}
