package model;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;

/**
 *
 * @author juliano
 */
@Entity
@SequenceGenerator(name = "seq_rcd_codigo", sequenceName = "seq_rcd_codigo", allocationSize = 1)
public class Fin_receitadespesa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_rcd_codigo")
    private int rcd_codigo;
    @ManyToOne
    @JoinColumn(name = "ctm_codigo")
    private Fin_categoriamovimentacao ctm_codigo;
    @ManyToOne
    @JoinColumn(name = "pes_codigo")
    private Pub_pessoa pes_codigo;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date rcd_datacadastro;
    private double rcd_desconto;
    private double rcd_valorbruto;
    private double rcd_valorliquido;
    private String rcd_numeronota;
    private String rcd_observacao;
    private boolean rcd_fixa;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date rcd_datainicio;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "rcd_codigo")
    private List<Fin_parcela> par_codigo;

    public Fin_receitadespesa() {
    }

    public List<Fin_parcela> getPar_codigo() {
        return par_codigo;
    }

    public void setPar_codigo(List<Fin_parcela> par_codigo) {
        this.par_codigo = par_codigo;
    }
    
    public int getRcd_codigo() {
        return rcd_codigo;
    }

    public void setRcd_codigo(int rcd_codigo) {
        this.rcd_codigo = rcd_codigo;
    }

    public Fin_categoriamovimentacao getCtm_codigo() {
        return ctm_codigo;
    }

    public void setCtm_codigo(Fin_categoriamovimentacao ctm_codigo) {
        this.ctm_codigo = ctm_codigo;
    }

    public Pub_pessoa getPes_codigo() {
        return pes_codigo;
    }

    public void setPes_codigo(Pub_pessoa pes_codigo) {
        this.pes_codigo = pes_codigo;
    }

    public Date getRcd_datacadastro() {
        return rcd_datacadastro;
    }

    public void setRcd_datacadastro(Date rcd_datacadastro) {
        this.rcd_datacadastro = rcd_datacadastro;
    }

    public double getRcd_desconto() {
        return rcd_desconto;
    }

    public void setRcd_desconto(double rcd_desconto) {
        this.rcd_desconto = rcd_desconto;
    }

    public double getRcd_valorbruto() {
        return rcd_valorbruto;
    }

    public void setRcd_valorbruto(double rcd_valorbruto) {
        this.rcd_valorbruto = rcd_valorbruto;
    }

    public double getRcd_valorliquido() {
        return rcd_valorliquido;
    }

    public void setRcd_valorliquido(double rcd_valorliquido) {
        this.rcd_valorliquido = rcd_valorliquido;
    }

    public String getRcd_numeronota() {
        return rcd_numeronota;
    }

    public void setRcd_numeronota(String rcd_numeronota) {
        this.rcd_numeronota = rcd_numeronota;
    }

    public String getRcd_observacao() {
        return rcd_observacao;
    }

    public void setRcd_observacao(String rcd_observacao) {
        this.rcd_observacao = rcd_observacao;
    }

    public boolean isRcd_fixa() {
        return rcd_fixa;
    }

    public void setRcd_fixa(boolean rcd_fixa) {
        this.rcd_fixa = rcd_fixa;
    }

    public Date getRcd_datainicio() {
        return rcd_datainicio;
    }

    public void setRcd_datainicio(Date rcd_datainicio) {
        this.rcd_datainicio = rcd_datainicio;
    }
}
