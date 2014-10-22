package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "seq_mar_codigo", sequenceName = "seq_mar_codigo", allocationSize = 1)
public class Pro_marcas implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_mar_codigo")
    private int mar_codigo;
    private String mar_descricao;

    public Pro_marcas() {
    }
    
    public int getMar_codigo() {
        return mar_codigo;
    }

    public void setMar_codigo(int mar_codigo) {
        this.mar_codigo = mar_codigo;
    }

    public String getMar_descricao() {
        return mar_descricao;
    }

    public void setMar_descricao(String mar_descricao) {
        this.mar_descricao = mar_descricao;
    }
    
    @Override
    public String toString() {
        return mar_descricao;
    }
}
