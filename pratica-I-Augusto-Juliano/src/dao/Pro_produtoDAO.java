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
        return session.createQuery("from Pro_produto order by pro_descricao asc").list();
    }

    public List<Pro_produto> findDesc(String _pro_descricao) {
        return session.createQuery("from Pro_produto where pro_descricao like '%" + _pro_descricao + "%' order by pro_descricao asc").list();
    }

    public List<Pro_produto> findValorCompra(String _pro_valorcompra) {
        return session.createQuery("from Pro_produto where pro_valorcompra = " + _pro_valorcompra + " order by pro_descricao asc").list();
    }

    public List<Pro_produto> findValorVenda(String _pro_valorvenda) {
        return session.createQuery("from Pro_produto where pro_valorvenda = " + _pro_valorvenda + " order by pro_descricao asc").list();
    }

    public List<Pro_produto> findMarca(String _mar_descricao) {
        return session.createQuery("from Pro_produto pro where mar_codigo.mar_descricao like '%" + _mar_descricao + "%' order by pro_descricao asc").list();
    }

    public List<Pro_produto> findCategoria(String _cat_descricao) {
        return session.createQuery("from Pro_produto pro inner join Pro_categoria cat on cat.cat_codigo = pro.cat_codigo"
                + "where cat.cat_descricao like '%" + _cat_descricao + "%' order by pro.pro_descricao asc").list();
    }

    public List<Pro_produto> findTipoproduto(String _cat_descricao) {
        return session.createQuery("from Pro_produto pro inner join Pro_categoria cat on cat.cat_codigo = pro.cat_codigo"
                + "where cat.cat_descricao like '%" + _cat_descricao + "%' order by pro.pro_descricao asc").list();
    }
}
