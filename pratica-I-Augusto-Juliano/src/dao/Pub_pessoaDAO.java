package dao;

import java.util.List;
import model.Pub_pessoa;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author juliano
 */
public class Pub_pessoaDAO {
    private Session session;

    public Pub_pessoaDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public void insert(Pub_pessoa _pub_pessoa) {
        Transaction t = session.beginTransaction();
        session.save(_pub_pessoa);
        t.commit();
    }

    public void update(Pub_pessoa _pub_pessoa) {
        Transaction t = session.beginTransaction();
        session.merge(_pub_pessoa);
        t.commit();
    }

    public void delete(Pub_pessoa _pub_pessoa) {
        Transaction t = session.beginTransaction();
        session.delete(_pub_pessoa);
        t.commit();
    }

    public Pub_pessoa findById(int id) {
        return (Pub_pessoa) session.load(Pub_pessoa.class, id);
    }

    public List<Pub_pessoa> findAll() {
        return session.createQuery("from Pub_pessoa").list();
    }
}
