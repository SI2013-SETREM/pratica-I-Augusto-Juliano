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
@SequenceGenerator(name = "seq_ctm_codigo", sequenceName = "seq_ctm_codigo", allocationSize = 1)
public class Fin_categoriamovimentacao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_ctm_codigo")
    private int ctm_codigo;
    private String ctm_descricao;
    private String ctm_entradasaida;

    public Fin_categoriamovimentacao() {
    }

    public int getCtm_codigo() {
        return ctm_codigo;
    }

    public void setCtm_codigo(int ctm_codigo) {
        this.ctm_codigo = ctm_codigo;
    }

    public String getCtm_descricao() {
        return ctm_descricao;
    }

    public void setCtm_descricao(String ctm_descricao) {
        this.ctm_descricao = ctm_descricao;
    }

    public String getCtm_entradasaida() {
        return ctm_entradasaida;
    }

    public void setCtm_entradasaida(String ctm_entradasaida) {
        this.ctm_entradasaida = ctm_entradasaida;
    }

    @Override
    public String toString() {
        return ctm_descricao;
    }
}
