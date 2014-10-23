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
@SequenceGenerator(name = "seq_par_codigo", sequenceName = "seq_par_codigo", allocationSize = 1)
public class Fin_parcela {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_par_codigo")
    private int par_codigo;
    @ManyToOne
    @JoinColumn(name = "cai_codigo")
    private Fin_caixa cai_codigo;
    @ManyToOne
    @JoinColumn(name = "rcd_codigo")
    private Fin_receitadespesa rcd_codigo;
    private Fin_parcela par_pai;
    private Date par_datacadastro;
    private Date par_datavencimento;
    private double par_valortotal;
    private double par_valorpago;
    private boolean par_status;
    private Date par_datapagamento;
    private String par_numerodocumento;

    public Fin_parcela() {
    }

    public int getPar_codigo() {
        return par_codigo;
    }

    public void setPar_codigo(int par_codigo) {
        this.par_codigo = par_codigo;
    }

    public Fin_caixa getCai_codigo() {
        return cai_codigo;
    }

    public void setCai_codigo(Fin_caixa cai_codigo) {
        this.cai_codigo = cai_codigo;
    }

    public Fin_receitadespesa getRcd_codigo() {
        return rcd_codigo;
    }

    public void setRcd_codigo(Fin_receitadespesa rcd_codigo) {
        this.rcd_codigo = rcd_codigo;
    }

    public Fin_parcela getPar_pai() {
        return par_pai;
    }

    public void setPar_pai(Fin_parcela par_pai) {
        this.par_pai = par_pai;
    }

    public Date getPar_datacadastro() {
        return par_datacadastro;
    }

    public void setPar_datacadastro(Date par_datacadastro) {
        this.par_datacadastro = par_datacadastro;
    }

    public Date getPar_datavencimento() {
        return par_datavencimento;
    }

    public void setPar_datavencimento(Date par_datavencimento) {
        this.par_datavencimento = par_datavencimento;
    }

    public double getPar_valortotal() {
        return par_valortotal;
    }

    public void setPar_valortotal(double par_valortotal) {
        this.par_valortotal = par_valortotal;
    }

    public double getPar_valorpago() {
        return par_valorpago;
    }

    public void setPar_valorpago(double par_valorpago) {
        this.par_valorpago = par_valorpago;
    }

    public boolean isPar_status() {
        return par_status;
    }

    public void setPar_status(boolean par_status) {
        this.par_status = par_status;
    }

    public Date getPar_datapagamento() {
        return par_datapagamento;
    }

    public void setPar_datapagamento(Date par_datapagamento) {
        this.par_datapagamento = par_datapagamento;
    }

    public String getPar_numerodocumento() {
        return par_numerodocumento;
    }

    public void setPar_numerodocumento(String par_numerodocumento) {
        this.par_numerodocumento = par_numerodocumento;
    }
}
