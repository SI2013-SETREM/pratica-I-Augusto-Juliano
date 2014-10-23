/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Fin_categoriamovimentacao;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author juliano
 */
public class Fin_categoriamovimentacaoDAO {

    private Session session;

    public Fin_categoriamovimentacaoDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public void insert(Fin_categoriamovimentacao _fin_categoriamovimentacao) {
        Transaction t = session.beginTransaction();
        session.save(_fin_categoriamovimentacao);
        t.commit();
    }

    public void update(Fin_categoriamovimentacao _fin_categoriamovimentacao) {
        Transaction t = session.beginTransaction();
        session.merge(_fin_categoriamovimentacao);
        t.commit();
    }

    public Fin_categoriamovimentacao findById(int id) {
        return (Fin_categoriamovimentacao) session.load(Fin_categoriamovimentacao.class, id);
    }

    public List<Fin_categoriamovimentacao> findAll() {
        return session.createQuery("from Fin_categoriamovimentacao").list();
    }
}
