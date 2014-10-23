/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.util.List;
import model.Pub_log;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author juliano
 */
public class Pub_logDAO {
    private Session session;

    public Pub_logDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public void insert(Pub_log _pub_log) {
        Transaction t = session.beginTransaction();
        session.save(_pub_log);
        t.commit();
    }

    public Pub_log findById(int id) {
        return (Pub_log) session.load(Pub_log.class, id);
    }

    public List<Pub_log> findAll() {
        return session.createQuery("from Pub_log").list();
    }
}
