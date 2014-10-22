/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
@SequenceGenerator(name = "seq_tpp_codigo", sequenceName = "seq_tpp_codigo", allocationSize = 1)
public class Pro_tipoproduto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_tpp_codigo")
    private int tpp_codigo;
    private String tpp_descricao;

    public Pro_tipoproduto() {
    }
   
    public int getTpp_codigo() {
        return tpp_codigo;
    }

    public void setTpp_codigo(int tpp_codigo) {
        this.tpp_codigo = tpp_codigo;
    }

    public String getTpp_descricao() {
        return tpp_descricao;
    }

    public void setTpp_descricao(String tpp_descricao) {
        this.tpp_descricao = tpp_descricao;
    }
    
    @Override
    public String toString() {
        return tpp_descricao;
    }
}
