package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "seq_cat_codigo", sequenceName = "seq_cat_codigo", allocationSize = 1)
public class Pro_categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cat_codigo")
    private int cat_codigo;
    private String cat_descricao;

    public Pro_categoria() {
    }
    
    public int getCat_codigo() {
        return cat_codigo;
    }

    public void setCat_codigo(int cat_codigo) {
        this.cat_codigo = cat_codigo;
    }

    public String getCat_descricao() {
        return cat_descricao;
    }

    public void setCat_descricao(String cat_descricao) {
        this.cat_descricao = cat_descricao;
    }
    
    @Override
    public String toString() {
        return cat_descricao;
    }
    
}
