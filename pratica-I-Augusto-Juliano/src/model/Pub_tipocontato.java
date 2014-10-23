package model;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "seq_tpc_codigo", sequenceName = "seq_tpc_codigo", allocationSize = 1)
public class Pub_tipocontato {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_tpc_codigo")
    private int tpc_codigo;
    private String tpc_descricao;
    private boolean tpc_status;

    public Pub_tipocontato() {
    }

    public int getTpc_codigo() {
        return tpc_codigo;
    }

    public void setTpc_codigo(int tpc_codigo) {
        this.tpc_codigo = tpc_codigo;
    }

    public String getTpc_descricao() {
        return tpc_descricao;
    }

    public void setTpc_descricao(String tpc_descricao) {
        this.tpc_descricao = tpc_descricao;
    }

    public boolean isTpc_status() {
        return tpc_status;
    }

    public void setTpc_status(boolean tpc_status) {
        this.tpc_status = tpc_status;
    }

    @Override
    public String toString() {
        return tpc_descricao;
    }
}
