package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author juliano
 */
@Entity
@SequenceGenerator(name = "seq_log_codigo", sequenceName = "seq_log_codigo", allocationSize = 1)
public class Pub_log {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_log_codigo")
    private int log_codigo;
    @ManyToOne
    @JoinColumn(name = "pes_codigo")
    private Pub_pessoa pes_codigo;
    private String log_acao;
    private String log_tabela;
    private String log_oldvalue;
    private String log_newvalue;
    private String log_data;

    public Pub_log() {
    }

    public int getLog_codigo() {
        return log_codigo;
    }

    public void setLog_codigo(int log_codigo) {
        this.log_codigo = log_codigo;
    }

    public Pub_pessoa getPes_codigo() {
        return pes_codigo;
    }

    public void setPes_codigo(Pub_pessoa pes_codigo) {
        this.pes_codigo = pes_codigo;
    }

    public String getLog_acao() {
        return log_acao;
    }

    public void setLog_acao(String log_acao) {
        this.log_acao = log_acao;
    }

    public String getLog_tabela() {
        return log_tabela;
    }

    public void setLog_tabela(String log_tabela) {
        this.log_tabela = log_tabela;
    }

    public String getLog_oldvalue() {
        return log_oldvalue;
    }

    public void setLog_oldvalue(String log_oldvalue) {
        this.log_oldvalue = log_oldvalue;
    }

    public String getLog_newvalue() {
        return log_newvalue;
    }

    public void setLog_newvalue(String log_newvalue) {
        this.log_newvalue = log_newvalue;
    }

    public String getLog_data() {
        return log_data;
    }

    public void setLog_data(String log_data) {
        this.log_data = log_data;
    }
}
