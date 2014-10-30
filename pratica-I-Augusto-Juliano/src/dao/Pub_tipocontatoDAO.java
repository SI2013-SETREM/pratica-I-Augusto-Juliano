/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Pub_tipocontato;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author juliano
 */
public class Pub_tipocontatoDAO {

    private Session session;

    public Pub_tipocontatoDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public void insert(Pub_tipocontato _pub_tipocontato) {
        Transaction t = session.beginTransaction();
        session.save(_pub_tipocontato);
        t.commit();
    }

    public void update(Pub_tipocontato _pub_tipocontato) {
        Transaction t = session.beginTransaction();
        session.merge(_pub_tipocontato);
        t.commit();
    }

    public void delete(Pub_tipocontato _pub_tipocontato) {
        Transaction t = session.beginTransaction();
        session.delete(_pub_tipocontato);
        t.commit();
    }

    public Pub_tipocontato findById(int id) {
        return (Pub_tipocontato) session.load(Pub_tipocontato.class, id);
    }

    public List<Pub_tipocontato> findAll() {
        return session.createQuery("from Pub_tipocontato order by tpc_descricao").list();
    }

    public List<Pub_tipocontato> findDesc(String _tpc_descricao) {
        return session.createQuery("from Pub_tipocontato where tpc_descricao like '%" + _tpc_descricao + "%' order by tpc_descricao").list();
    }
}
