/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import org.hibernate.Session;
import model.Pub_pessoacontatos;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author juliano
 */
public class Pub_pessoacontatosDAO {

    private Session session;

    public Pub_pessoacontatosDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public void insert(Pub_pessoacontatos _pub_pessoacontatos) {
        Transaction t = session.beginTransaction();
        session.save(_pub_pessoacontatos);
        t.commit();
    }

    public void update(Pub_pessoacontatos _pub_pessoacontatos) {
        Transaction t = session.beginTransaction();
        session.merge(_pub_pessoacontatos);
        t.commit();
    }

    public void delete(Pub_pessoacontatos _pub_pessoacontatos) {
        Transaction t = session.beginTransaction();
        session.delete(_pub_pessoacontatos);
        t.commit();
    }

    public Pub_pessoacontatos findById(int id) {
        return (Pub_pessoacontatos) session.load(Pub_pessoacontatos.class, id);
    }

    public List<Pub_pessoacontatos> findAll() {
        return session.createQuery("from Pub_pessoacontatos").list();
    }
}
