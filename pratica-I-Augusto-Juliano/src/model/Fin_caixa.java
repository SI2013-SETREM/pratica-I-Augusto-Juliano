package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author juliano
 */
@Entity
@SequenceGenerator(name = "seq_cai_codigo", sequenceName = "seq_cai_codigo", allocationSize = 1)
public class Fin_caixa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cai_codigo")
    private int cai_codigo;
    private double cai_valorinicial;
    private String cai_descricao;

    public Fin_caixa() {
    }

    public int getCai_codigo() {
        return cai_codigo;
    }

    public void setCai_codigo(int cai_codigo) {
        this.cai_codigo = cai_codigo;
    }

    public double getCai_valorinicial() {
        return cai_valorinicial;
    }

    public void setCai_valorinicial(double cai_valorinicial) {
        this.cai_valorinicial = cai_valorinicial;
    }

    public String getCai_descricao() {
        return cai_descricao;
    }

    public void setCai_descricao(String cai_descricao) {
        this.cai_descricao = cai_descricao;
    }

    @Override
    public String toString() {
        return cai_descricao;
    }
}
