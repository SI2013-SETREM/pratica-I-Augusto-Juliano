/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Pub_cidade;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author juliano
 */
public class Pub_cidadeDAO {

    private Session session;

    public Pub_cidadeDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public void insert(Pub_cidade _pub_cidade) {
        Transaction t = session.beginTransaction();
        session.save(_pub_cidade);
        t.commit();
    }

    public void update(Pub_cidade _pub_cidade) {
        Transaction t = session.beginTransaction();
        session.merge(_pub_cidade);
        t.commit();
    }

    public void delete(Pub_cidade _pub_cidade) {
        Transaction t = session.beginTransaction();
        session.delete(_pub_cidade);
        t.commit();
    }

    public Pub_cidade findById(int id) {
        return (Pub_cidade) session.load(Pub_cidade.class, id);
    }

    public List<Pub_cidade> findAll() {
        return session.createQuery("from Pub_cidade order by est_codigo, cid_descricao").list();
    }

    public List<Pub_cidade> findDesc(String _cid_descricao) {
        return session.createQuery("from Pub_cidade where cid_descricao like '%" + _cid_descricao + "%' order by est_codigo, cid_descricao").list();
    }
}
