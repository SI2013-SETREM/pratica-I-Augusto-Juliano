/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Pro_tipoproduto;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author juliano
 */
public class Pro_tipoprodutoDAO {

    private Session session;

    public Pro_tipoprodutoDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public void insert(Pro_tipoproduto _pro_tipoproduto) {
        Transaction t = session.beginTransaction();
        session.save(_pro_tipoproduto);
        t.commit();
    }

    public void update(Pro_tipoproduto _pro_tipoproduto) {
        Transaction t = session.beginTransaction();
        session.merge(_pro_tipoproduto);
        t.commit();
    }

    public void delete(Pro_tipoproduto _pro_tipoproduto) {
        Transaction t = session.beginTransaction();
        session.delete(_pro_tipoproduto);
        t.commit();
    }

    public Pro_tipoproduto findById(int id) {
        return (Pro_tipoproduto) session.load(Pro_tipoproduto.class, id);
    }

    public List<Pro_tipoproduto> findAll() {
        return session.createQuery("from Pro_tipoproduto order by tpp_descricao").list();
    }

    public List<Pro_tipoproduto> findDesc(String _tpp_descricao) {
        return session.createQuery("from Pro_tipoproduto where tpp_descricao like '%" + _tpp_descricao + "%' order by tpp_descricao").list();
    }
}
