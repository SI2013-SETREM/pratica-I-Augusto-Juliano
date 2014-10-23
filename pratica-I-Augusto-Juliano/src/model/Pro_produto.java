package model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "seq_pro_codigo", sequenceName = "seq_pro_codigo", allocationSize = 1)
public class Pro_produto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pro_codigo")
    private int pro_codigo;
    @ManyToOne
    @JoinColumn(name = "mar_codigo")
    private Pro_marcas mar_codigo;
    @ManyToOne
    @JoinColumn(name = "cat_codigo")
    private Pro_categoria cat_codigo;
    @ManyToOne
    @JoinColumn(name = "tpp_codigo")
    private Pro_tipoproduto tpp_codigo;
    private String pro_descricao;
    private Date pro_datacadastro;
    private double pro_valorvenda;
    private double pro_valorcompra;

    public Pro_produto() {
    }

    public int getPro_codigo() {
        return pro_codigo;
    }

    public void setPro_codigo(int pro_codigo) {
        this.pro_codigo = pro_codigo;
    }

    public Pro_marcas getMar_codigo() {
        return mar_codigo;
    }

    public void setMar_codigo(Pro_marcas mar_codigo) {
        this.mar_codigo = mar_codigo;
    }

    public Pro_categoria getCat_codigo() {
        return cat_codigo;
    }

    public void setCat_codigo(Pro_categoria cat_codigo) {
        this.cat_codigo = cat_codigo;
    }

    public Pro_tipoproduto getTpp_codigo() {
        return tpp_codigo;
    }

    public void setTpp_codigo(Pro_tipoproduto tpp_codigo) {
        this.tpp_codigo = tpp_codigo;
    }

    public String getPro_descricao() {
        return pro_descricao;
    }

    public void setPro_descricao(String pro_descricao) {
        this.pro_descricao = pro_descricao;
    }

    public Date getPro_datacadastro() {
        return pro_datacadastro;
    }

    public void setPro_datacadastro(Date pro_datacadastro) {
        this.pro_datacadastro = pro_datacadastro;
    }

    public double getPro_valorvenda() {
        return pro_valorvenda;
    }

    public void setPro_valorvenda(double pro_valorvenda) {
        this.pro_valorvenda = pro_valorvenda;
    }

    public double getPro_valorcompra() {
        return pro_valorcompra;
    }

    public void setPro_valorcompra(double pro_valorcompra) {
        this.pro_valorcompra = pro_valorcompra;
    }

    @Override
    public String toString() {
        return pro_descricao;
    }
}
