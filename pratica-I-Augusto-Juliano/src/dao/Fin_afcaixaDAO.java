/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.util.List;
import model.Fin_afcaixa;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author juliano
 */
public class Fin_afcaixaDAO {
    private Session session;

    public Fin_afcaixaDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public void insert(Fin_afcaixa _fin_caixa) {
        Transaction t = session.beginTransaction();
        session.save(_fin_caixa);
        t.commit();
    }

    public void update(Fin_afcaixa _fin_caixa) {
        Transaction t = session.beginTransaction();
        session.merge(_fin_caixa);
        t.commit();
    }

    public Fin_afcaixa findById(int id) {
        return (Fin_afcaixa) session.load(Fin_afcaixa.class, id);
    }

    public List<Fin_afcaixa> findAll() {
        return session.createQuery("from Fin_afcaixa").list();
    }
}
