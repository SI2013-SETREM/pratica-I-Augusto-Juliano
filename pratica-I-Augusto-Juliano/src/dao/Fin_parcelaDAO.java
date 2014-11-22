package dao;

import java.util.List;
import model.Fin_categoriamovimentacao;
import model.Fin_parcela;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author juliano
 */
public class Fin_parcelaDAO {

    private Session session;

    public Fin_parcelaDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public void insert(Fin_parcela _fin_parcela) {
        Transaction t = session.beginTransaction();
        session.save(_fin_parcela);
        t.commit();
    }

    public void update(Fin_parcela _fin_parcela) {
        Transaction t = session.beginTransaction();
        session.merge(_fin_parcela);
        t.commit();
    }

    public void delete(Fin_parcela _fin_parcela) {
        Transaction t = session.beginTransaction();
        session.delete(_fin_parcela);
        t.commit();
    }

    public Fin_parcela findById(int id) {
        return (Fin_parcela) session.load(Fin_parcela.class, id);
    }

    public List<Fin_parcela> findAll() {
        return session.createQuery("from Fin_parcela order by par_datavencimento asc").list();
    }

    public List<Fin_parcela> findFiltered(Integer _pes_codigo, Integer _cai_codigo, String dataInicio, String dataFim, Boolean _pagas, String _tpp_codigo) {
        String sql = "from Fin_parcela where par_codigo > 0";
        if (_pes_codigo > 0) {
            sql += " and rcd_codigo.pes_codigo =" + _pes_codigo;
        }
        if (_cai_codigo > 0) {
            sql += " and afc_codigo.cai_codigo =" + _cai_codigo;
        }
        if (!dataInicio.isEmpty() && !dataFim.isEmpty()) {
            sql += " and par_datavencimento between '" + dataInicio + "' and '" + dataFim + "'";
        }
        if (_pagas) {
            sql += " and par_valorpago > 0";
        }
        if (!_tpp_codigo.isEmpty() && !"T".equals(_tpp_codigo)) {
            sql += " and rcd_codigo.pes_codigo.pes_tipo = '" + _tpp_codigo + "'";
        }
        sql += " order by par_datavencimento asc";
        return session.createQuery(sql).list();
    }

    public List<Object[]> getParcelasChartEntrada(String dataInicio, String dataFim, Boolean _pagas) {
        String sqlApeend = "";
        if (_pagas) {
            sqlApeend = " and par_status = true ";
        }
        return session.createSQLQuery("select sum(par.par_valortotal), EXTRACT(month from par.par_datavencimento) as mes, EXTRACT(year from par.par_datavencimento) as ano \n"
                + "from fin_parcela par\n"
                + "inner join fin_receitadespesa rcd on rcd.rcd_codigo = par.rcd_codigo\n"
                + "inner join fin_categoriamovimentacao ctm on ctm.ctm_codigo = rcd.ctm_codigo\n"
                + "where ctm.ctm_entradasaida = 'E' and par.par_datavencimento between '" + dataInicio + "' and '" + dataFim + "'\n"
                + sqlApeend
                + "group by mes, ano order by ano, mes").list();
    }

    public List<Object[]> getParcelasChartSaida(String dataInicio, String dataFim, Boolean _pagas) {
        String sqlApeend = "";
        if (_pagas) {
            sqlApeend = " and par_status = true ";
        }
        return session.createSQLQuery("select sum(par.par_valortotal), EXTRACT(month from par.par_datavencimento) as mes, EXTRACT(year from par.par_datavencimento) as ano \n"
                + "from fin_parcela par\n"
                + "inner join fin_receitadespesa rcd on rcd.rcd_codigo = par.rcd_codigo\n"
                + "inner join fin_categoriamovimentacao ctm on ctm.ctm_codigo = rcd.ctm_codigo\n"
                + "where ctm.ctm_entradasaida = 'S' and par.par_datavencimento between '" + dataInicio + "' and '" + dataFim + "'\n"
                + sqlApeend
                + "group by mes, ano order by ano, mes").list();
    }

    public List<Fin_parcela> findCPagarByPes(Integer _pes_codigo) {
        return session.createQuery("from Fin_parcela where rcd_codigo.pes_codigo =" + _pes_codigo + " and rcd_codigo.ctm_codigo.ctm_entradasaida = 'S' order by par_datavencimento asc").list();
    }

    public List<Fin_parcela> findCReceberByPes(Integer _pes_codigo) {
        return session.createQuery("from Fin_parcela where rcd_codigo.pes_codigo =" + _pes_codigo + " and rcd_codigo.ctm_codigo.ctm_entradasaida = 'E' order by par_datavencimento asc").list();
    }

    public List<Fin_parcela> findContasByPes(Integer _pes_codigo) {
        return session.createQuery("from Fin_parcela where rcd_codigo.pes_codigo =" + _pes_codigo + " order by rcd_codigo.ctm_codigo.ctm_entradasaida, par_datavencimento desc").list();
    }
}
