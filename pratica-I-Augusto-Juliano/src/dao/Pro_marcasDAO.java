package dao;

import java.util.List;
import model.Pro_marcas;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author juliano
 */
public class Pro_marcasDAO {

    private Session session;

    public Pro_marcasDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public void insert(Pro_marcas _pro_marcas) {
        Transaction t = session.beginTransaction();
        session.save(_pro_marcas);
        t.commit();
    }

    public void update(Pro_marcas _pro_marcas) {
        Transaction t = session.beginTransaction();
        session.merge(_pro_marcas);
        t.commit();
    }

    public void delete(Pro_marcas _pro_marcas) {
        Transaction t = session.beginTransaction();
        session.delete(_pro_marcas);
        t.commit();
    }

    public Pro_marcas findById(int id) {
        return (Pro_marcas) session.load(Pro_marcas.class, id);
    }

    public List<Pro_marcas> findAll() {
        return session.createQuery("from Pro_marcas order by mar_descricao").list();
    }
    
    public List<Pro_marcas> findDesc(String _mar_descricao) {
        return session.createQuery("from Pro_marcas where mar_descricao like '%" + _mar_descricao + "%' order by mar_descricao").list();
    }
}
