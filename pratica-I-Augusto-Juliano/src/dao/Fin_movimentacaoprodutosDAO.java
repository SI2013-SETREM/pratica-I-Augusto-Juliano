package dao;

import java.util.List;
import model.Fin_movimentacaoprodutos;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author juliano
 */
public class Fin_movimentacaoprodutosDAO {
    private Session session;

    public Fin_movimentacaoprodutosDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public void insert(Fin_movimentacaoprodutos _fin_receitadespesa) {
        Transaction t = session.beginTransaction();
        session.save(_fin_receitadespesa);
        t.commit();
    }

    public void update(Fin_movimentacaoprodutos _fin_receitadespesa) {
        Transaction t = session.beginTransaction();
        session.merge(_fin_receitadespesa);
        t.commit();
    }

    public void delete(Fin_movimentacaoprodutos _fin_receitadespesa) {
        Transaction t = session.beginTransaction();
        session.delete(_fin_receitadespesa);
        t.commit();
    }

    public Fin_movimentacaoprodutos findById(int id) {
        return (Fin_movimentacaoprodutos) session.load(Fin_movimentacaoprodutos.class, id);
    }

    public List<Fin_movimentacaoprodutos> findAll() {
        return session.createQuery("from Fin_movimentacaoprodutos").list();
    }
}
