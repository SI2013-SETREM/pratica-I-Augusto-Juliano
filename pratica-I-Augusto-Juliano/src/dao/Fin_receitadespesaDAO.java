/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Fin_receitadespesa;
import model.Pro_produto;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author juliano
 */
public class Fin_receitadespesaDAO {

    private Session session;

    public Fin_receitadespesaDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public void insert(Fin_receitadespesa _fin_receitadespesa) {
        Transaction t = session.beginTransaction();
        session.save(_fin_receitadespesa);
        t.commit();
    }

    public void update(Fin_receitadespesa _fin_receitadespesa) {
        Transaction t = session.beginTransaction();
        session.merge(_fin_receitadespesa);
        t.commit();
    }

    public void delete(Fin_receitadespesa _fin_receitadespesa) {
        Transaction t = session.beginTransaction();
        session.delete(_fin_receitadespesa);
        t.commit();
    }

    public Fin_receitadespesa findById(int id) {
        return (Fin_receitadespesa) session.load(Fin_receitadespesa.class, id);
    }

    public List<Fin_receitadespesa> findAll() {
        return session.createQuery("from Fin_receitadespesa").list();
    }
}
