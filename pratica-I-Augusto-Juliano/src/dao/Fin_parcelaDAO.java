package dao;

import java.util.List;
import model.Fin_categoriamovimentacao;
import model.Fin_parcela;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author juliano
 */
public class Fin_parcelaDAO {
    private Session session;

    public Fin_parcelaDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public void insert(Fin_parcela _fin_parcela) {
        Transaction t = session.beginTransaction();
        session.save(_fin_parcela);
        t.commit();
    }

    public void update(Fin_parcela _fin_parcela) {
        Transaction t = session.beginTransaction();
        session.merge(_fin_parcela);
        t.commit();
    }
    
    public void delete(Fin_parcela _fin_parcela) {
        Transaction t = session.beginTransaction();
        session.delete(_fin_parcela);
        t.commit();
    }

    public Fin_parcela findById(int id) {
        return (Fin_parcela) session.load(Fin_parcela.class, id);
    }

    public List<Fin_parcela> findAll() {
        return session.createQuery("from Fin_parcela").list();
    }
}