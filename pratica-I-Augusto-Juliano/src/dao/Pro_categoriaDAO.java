/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.util.List;
import model.Pro_categoria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author juliano
 */
public class Pro_categoriaDAO {
    private Session session;

    public Pro_categoriaDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public void insert(Pro_categoria _pro_categoria) {
        Transaction t = session.beginTransaction();
        session.save(_pro_categoria);
        t.commit();
    }

    public void update(Pro_categoria _pro_categoria) {
        Transaction t = session.beginTransaction();
        session.merge(_pro_categoria);
        t.commit();
    }

    public void delete(Pro_categoria _pro_categoria) {
        Transaction t = session.beginTransaction();
        session.delete(_pro_categoria);
        t.commit();
    }

    public Pro_categoria findById(int id) {
        return (Pro_categoria) session.load(Pro_categoria.class, id);
    }

    public List<Pro_categoria> findAll() {
        return session.createQuery("from Pro_categoria order by cat_descricao").list();
    }
}
