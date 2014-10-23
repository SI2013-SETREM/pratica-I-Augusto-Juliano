/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Pub_estado;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author juliano
 */
public class Pub_estadoDAO {

    private Session session;

    public Pub_estadoDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public void insert(Pub_estado _pub_estado) {
        Transaction t = session.beginTransaction();
        session.save(_pub_estado);
        t.commit();
    }

    public void update(Pub_estado _pub_estado) {
        Transaction t = session.beginTransaction();
        session.merge(_pub_estado);
        t.commit();
    }

    public void delete(Pub_estado _pub_estado) {
        Transaction t = session.beginTransaction();
        session.delete(_pub_estado);
        t.commit();
    }

    public Pub_estado findById(int id) {
        return (Pub_estado) session.load(Pub_estado.class, id);
    }

    public List<Pub_estado> findAll() {
        return session.createQuery("from Pub_estado").list();
    }
}
