package model;

import java.util.Date;
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
@SequenceGenerator(name = "seq_afc_codigo", sequenceName = "seq_afc_codigo", allocationSize = 1)
public class Fin_afcaixa {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_afc_codigo")
    private int afc_codigo;
    @ManyToOne
    @JoinColumn(name = "cai_codigo")
    private Fin_caixa cai_codigo;
    private double afc_valorabertura;
    private Date afc_dataabertura;
    private Date afc_datafechamento;
    private double afc_valorfechamento;

    public Fin_afcaixa() {
    }

    public int getAfc_codigo() {
        return afc_codigo;
    }

    public void setAfc_codigo(int afc_codigo) {
        this.afc_codigo = afc_codigo;
    }

    public Fin_caixa getCai_codigo() {
        return cai_codigo;
    }

    public void setCai_codigo(Fin_caixa cai_codigo) {
        this.cai_codigo = cai_codigo;
    }

    public double getAfc_valorabertura() {
        return afc_valorabertura;
    }

    public void setAfc_valorabertura(double afc_valorabertura) {
        this.afc_valorabertura = afc_valorabertura;
    }

    public Date getAfc_dataabertura() {
        return afc_dataabertura;
    }

    public void setAfc_dataabertura(Date afc_dataabertura) {
        this.afc_dataabertura = afc_dataabertura;
    }

    public Date getAfc_datafechamento() {
        return afc_datafechamento;
    }

    public void setAfc_datafechamento(Date afc_datafechamento) {
        this.afc_datafechamento = afc_datafechamento;
    }

    public double getAfc_valorfechamento() {
        return afc_valorfechamento;
    }

    public void setAfc_valorfechamento(double afc_valorfechamento) {
        this.afc_valorfechamento = afc_valorfechamento;
    }
}
