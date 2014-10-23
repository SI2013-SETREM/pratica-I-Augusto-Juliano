/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.util.List;
import model.Pro_produto;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author juliano
 */
public class Pro_produtoDAO {
    private Session session;

    public Pro_produtoDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public void insert(Pro_produto _pro_produto) {
        Transaction t = session.beginTransaction();
        session.save(_pro_produto);
        t.commit();
    }

    public void update(Pro_produto _pro_produto) {
        Transaction t = session.beginTransaction();
        session.merge(_pro_produto);
        t.commit();
    }

    public void delete(Pro_produto _pro_produto) {
        Transaction t = session.beginTransaction();
        session.delete(_pro_produto);
        t.commit();
    }

    public Pro_produto findById(int id) {
        return (Pro_produto) session.load(Pro_produto.class, id);
    }

    public List<Pro_produto> findAll() {
        return session.createQuery("from Pro_produto").list();
    }
}
