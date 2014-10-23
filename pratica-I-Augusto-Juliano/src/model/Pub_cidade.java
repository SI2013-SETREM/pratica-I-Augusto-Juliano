package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "seq_cid_codigo", sequenceName = "seq_cid_codigo", allocationSize = 1)
public class Pub_cidade {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cid_codigo")
    private int cid_codigo;
    private String cid_descricao;
    private String cid_cep;
    @ManyToOne
    @JoinColumn(name = "est_codigo")
    private Pub_estado est_codigo;

    public Pub_cidade() {
    }

    public int getCid_codigo() {
        return cid_codigo;
    }

    public void setCid_codigo(int cid_codigo) {
        this.cid_codigo = cid_codigo;
    }

    public String getCid_descricao() {
        return cid_descricao;
    }

    public void setCid_descricao(String cid_descricao) {
        this.cid_descricao = cid_descricao;
    }

    public String getCid_cep() {
        return cid_cep;
    }

    public void setCid_cep(String cid_cep) {
        this.cid_cep = cid_cep;
    }

    public Pub_estado getEst_codigo() {
        return est_codigo;
    }

    public void setEst_codigo(Pub_estado est_codigo) {
        this.est_codigo = est_codigo;
    }

    @Override
    public String toString() {
        return cid_descricao;
    }

}
