/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Fin_caixa;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author juliano
 */
public class Fin_caixaDAO {

    private Session session;

    public Fin_caixaDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public void insert(Fin_caixa _fin_caixa) {
        Transaction t = session.beginTransaction();
        session.save(_fin_caixa);
        t.commit();
    }

    public void update(Fin_caixa _fin_caixa) {
        Transaction t = session.beginTransaction();
        session.merge(_fin_caixa);
        t.commit();
    }

    public void delete(Fin_caixa _fin_caixa) {
        Transaction t = session.beginTransaction();
        session.delete(_fin_caixa);
        t.commit();
    }

    public Fin_caixa findById(int id) {
        return (Fin_caixa) session.load(Fin_caixa.class, id);
    }

    public List<Fin_caixa> findAll() {
        return session.createQuery("from Fin_caixa order by cai_descricao asc").list();
    }

    public List<Fin_caixa> findDesc(String _cai_descricao) {
        return session.createQuery("from Fin_caixa where cai_descricao like '%" + _cai_descricao + "%' order by cai_descricao asc").list();
    }

    public Boolean verifyOutflows(Integer _cai_codigo) {
        Integer _registros = session.createQuery("from Fin_afcaixa where cai_codigo.cai_codigo = " + _cai_codigo).list().size();
        return _registros > 0;
    }
}
