package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "seq_est_codigo", sequenceName = "seq_est_codigo", allocationSize = 1)
public class Pub_estado {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_est_codigo")
    private int est_codigo;
    private String est_descricao;
    private String est_sigla;

    public Pub_estado() {
    }

    public int getEst_codigo() {
        return est_codigo;
    }

    public void setEst_codigo(int est_codigo) {
        this.est_codigo = est_codigo;
    }

    public String getEst_descricao() {
        return est_descricao;
    }

    public void setEst_descricao(String est_descricao) {
        this.est_descricao = est_descricao;
    }

    public String getEst_sigla() {
        return est_sigla;
    }

    public void setEst_sigla(String est_sigla) {
        this.est_sigla = est_sigla;
    }

    @Override
    public String toString() {
        return est_descricao;
    }

}
