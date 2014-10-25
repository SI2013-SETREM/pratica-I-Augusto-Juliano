package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author juliano
 */
@Entity
public class Fin_movimentacaoprodutos implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "pro_codigo")
    private Pro_produto pro_codigo;
    @Id
    @ManyToOne
    @JoinColumn(name = "rcd_codigo")
    private Fin_receitadespesa rcd_codigo;
    private double pro_quantidade;
    private double pro_valorunitario;
    private double pro_valorbruto;
    private double pro_valorliquido;
    private double pro_desconto;

    public Fin_movimentacaoprodutos() {
    }

    public Pro_produto getPro_codigo() {
        return pro_codigo;
    }

    public void setPro_codigo(Pro_produto pro_codigo) {
        this.pro_codigo = pro_codigo;
    }

    public Fin_receitadespesa getRcd_codigo() {
        return rcd_codigo;
    }

    public void setRcd_codigo(Fin_receitadespesa rcd_codigo) {
        this.rcd_codigo = rcd_codigo;
    }

    public double getPro_quantidade() {
        return pro_quantidade;
    }

    public void setPro_quantidade(double pro_quantidade) {
        this.pro_quantidade = pro_quantidade;
    }

    public double getPro_valorunitario() {
        return pro_valorunitario;
    }

    public void setPro_valorunitario(double pro_valorunitario) {
        this.pro_valorunitario = pro_valorunitario;
    }

    public double getPro_valorbruto() {
        return pro_valorbruto;
    }

    public void setPro_valorbruto(double pro_valorbruto) {
        this.pro_valorbruto = pro_valorbruto;
    }

    public double getPro_valorliquido() {
        return pro_valorliquido;
    }

    public void setPro_valorliquido(double pro_valorliquido) {
        this.pro_valorliquido = pro_valorliquido;
    }

    public double getPro_desconto() {
        return pro_desconto;
    }

    public void setPro_desconto(double pro_desconto) {
        this.pro_desconto = pro_desconto;
    }
}
