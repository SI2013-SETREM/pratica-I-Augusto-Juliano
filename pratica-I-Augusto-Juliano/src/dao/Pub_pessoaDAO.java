package dao;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import model.Pub_pessoa;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author juliano
 */
public class Pub_pessoaDAO {

    private Session session;

    public Pub_pessoaDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public void insert(Pub_pessoa _pub_pessoa) {
        Transaction t = session.beginTransaction();
        session.save(_pub_pessoa);
        t.commit();
    }

    public void update(Pub_pessoa _pub_pessoa) {
        Transaction t = session.beginTransaction();
        session.merge(_pub_pessoa);
        t.commit();
    }

    public void delete(Pub_pessoa _pub_pessoa) {
        Transaction t = session.beginTransaction();
        session.delete(_pub_pessoa);
        t.commit();
    }

    public Pub_pessoa findById(int id) {
        return (Pub_pessoa) session.load(Pub_pessoa.class, id);
    }

    public List<Pub_pessoa> findAllByCat(String _pes_tipo) {
        if ("T".equals(_pes_tipo)) {
            return session.createQuery("from Pub_pessoa where pes_login is null order by pes_razaosocial asc").list();
        } else {
            return session.createQuery("from Pub_pessoa where pes_login is null and pes_tipo = '" + _pes_tipo + "' order by pes_razaosocial asc").list();
        }
    }

    public List<Pub_pessoa> findAllCFG() {
        return session.createQuery("from Pub_pessoa where pes_login is null and pes_tipo in ('C', 'F', 'G') order by pes_razaosocial asc").list();
    }

    public Integer findCountByCPFCNPJ(Integer _pes_codigo, String _param) {
        return session.createQuery("from Pub_pessoa where pes_login is null and pes_cnpjcpf = '" + _param + "' and pes_codigo !=" + _pes_codigo).list().size();
    }
    
    public Integer findCountByLogin(Integer _pes_codigo, String _pes_login) {
        return session.createQuery("from Pub_pessoa where upper(pes_login) like upper(:pes_login) and pes_codigo != :pes_codigo").setParameter("pes_login", _pes_login).setParameter("pes_codigo", _pes_codigo).list().size();
    }
    
    public Integer findByLoginPassword(String _pes_login, String _pes_senha) {
        return session.createQuery("from Pub_pessoa where upper(pes_login) = upper(:pes_login) and upper(pes_senha) = upper(:pes_senha)").setParameter("pes_login", _pes_login).setParameter("pes_senha", _pes_senha).list().size();
    }

    public List<Pub_pessoa> filterParam(String _parametro, Integer _index) {
        if (_index == 0) {
            return session.createQuery("from Pub_pessoa where pes_login is null and pes_razaosocial like '%" + _parametro + "%' order by pes_razaosocial asc").list();
        } else if (_index == 1) {
            return session.createQuery("from Pub_pessoa where pes_login is null and pes_nomefantasia like '%" + _parametro + "%' order by pes_razaosocial asc").list();
        } else if (_index == 2) {
            return session.createQuery("from Pub_pessoa where pes_login is null and pes_cnpjcpf = '" + _parametro + "' order by pes_razaosocial asc").list();
        } else if (_index == 3) {
            return session.createQuery("from Pub_pessoa where pes_login is null and pes_logradouro like '%" + _parametro + "%' order by pes_razaosocial asc").list();
        } else if (_index == 4) {
            return session.createQuery("from Pub_pessoa where pes_login is null and pes_bairro like '%" + _parametro + "%' order by pes_razaosocial asc").list();
        } else if (_index == 5) {
            return session.createQuery("from Pub_pessoa where pes_login is null and cid_codigo.cid_descricao like '%" + _parametro + "%' order by pes_razaosocial asc").list();
        } else if (_index == 6) {
            return session.createQuery("from Pub_pessoa where pes_login is null and cid_codigo.est_codigo.est_sigla = '" + _parametro + "s' order by pes_razaosocial asc").list();
        } else if (_index == 7) {
            return session.createQuery("from Pub_pessoa where pes_login is null and cid_codigo.cid_cep = '" + _parametro + "s' order by pes_razaosocial asc").list();
        } else {
            return session.createQuery("from Pub_pessoa pes_login is null order by pes_razaosocial asc").list();
        }
    }

    public List<Pub_pessoa> findAllUsuarios() {
        return session.createQuery("from Pub_pessoa where pes_login is not null order by pes_razaosocial asc").list();
    }

    public List<Pub_pessoa> findUsuariosByLogin(String _pes_login) {
        return session.createQuery("from Pub_pessoa where upper(pes_login) like upper(:pes_login) order by pes_razaosocial asc").setParameter("pes_login", "%" + _pes_login + "%").list();
    }

}
