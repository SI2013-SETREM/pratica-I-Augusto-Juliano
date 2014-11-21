/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author juliano
 */
@Entity
@SequenceGenerator(name = "seq_pes_codigo", sequenceName = "seq_pes_codigo", allocationSize = 1)
public class Pub_pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pes_codigo")
    private int pes_codigo;
    @ManyToOne
    @JoinColumn(name = "cid_codigo")
    private Pub_cidade cid_codigo;
    private String pes_razaosocial;
    private String pes_nomefantasia;
    private String pes_cnpjcpf;
    private Date pes_datacadastro;
    private String pes_tipo;
    private String pes_login;
    private String pes_senha;
    private boolean pes_status;
    private String pes_observacoes;
    private String pes_complemento;
    private int pes_numero;
    private String pes_logradouro;
    private String pes_bairro;
    private String pes_tipopessoa;
    private String pes_nivelacesso;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "pes_codigo")
    private List<Pub_pessoacontatos> psc_codigo;

    public List<Pub_pessoacontatos> getPsc_codigo() {
        return psc_codigo;
    }

    public void setPsc_codigo(List<Pub_pessoacontatos> psc_codigo) {
        this.psc_codigo = psc_codigo;
    }

    public Pub_pessoa() {
    }

    public int getPes_codigo() {
        return pes_codigo;
    }

    public void setPes_codigo(int pes_codigo) {
        this.pes_codigo = pes_codigo;
    }

    public Pub_cidade getCid_codigo() {
        return cid_codigo;
    }

    public void setCid_codigo(Pub_cidade cid_codigo) {
        this.cid_codigo = cid_codigo;
    }

    public String getPes_razaosocial() {
        return pes_razaosocial;
    }

    public void setPes_razaosocial(String pes_razaosocial) {
        this.pes_razaosocial = pes_razaosocial;
    }

    public String getPes_nomefantasia() {
        return pes_nomefantasia;
    }

    public void setPes_nomefantasia(String pes_nomefantasia) {
        this.pes_nomefantasia = pes_nomefantasia;
    }

    public String getPes_cnpjcpf() {
        return pes_cnpjcpf;
    }

    public void setPes_cnpjcpf(String pes_cnpjcpf) {
        this.pes_cnpjcpf = pes_cnpjcpf;
    }

    public Date getPes_datacadastro() {
        return pes_datacadastro;
    }

    public void setPes_datacadastro(Date pes_datacadastro) {
        this.pes_datacadastro = pes_datacadastro;
    }

    public String getPes_tipo() {
        return pes_tipo;
    }

    public void setPes_tipo(String pes_tipo) {
        this.pes_tipo = pes_tipo;
    }

    public String getPes_login() {
        return pes_login;
    }

    public void setPes_login(String pes_login) {
        this.pes_login = pes_login;
    }

    public String getPes_senha() {
        return pes_senha;
    }

    public void setPes_senha(String pes_senha) {
        this.pes_senha = Encrypt.convertStringToMd5(pes_senha.toUpperCase());
    }

    public boolean isPes_status() {
        return pes_status;
    }

    public void setPes_status(boolean pes_status) {
        this.pes_status = pes_status;
    }

    public String getPes_observacoes() {
        return pes_observacoes;
    }

    public void setPes_observacoes(String pes_observacoes) {
        this.pes_observacoes = pes_observacoes;
    }

    public String getPes_complemento() {
        return pes_complemento;
    }

    public void setPes_complemento(String pes_complemento) {
        this.pes_complemento = pes_complemento;
    }

    public int getPes_numero() {
        return pes_numero;
    }

    public void setPes_numero(int pes_numero) {
        this.pes_numero = pes_numero;
    }

    public String getPes_logradouro() {
        return pes_logradouro;
    }

    public void setPes_logradouro(String pes_logradouro) {
        this.pes_logradouro = pes_logradouro;
    }

    public String getPes_bairro() {
        return pes_bairro;
    }

    public void setPes_bairro(String pes_bairro) {
        this.pes_bairro = pes_bairro;
    }

    public String getPes_tipopessoa() {
        return pes_tipopessoa;
    }

    public void setPes_tipopessoa(String pes_tipopessoa) {
        this.pes_tipopessoa = pes_tipopessoa;
    }

    public String getPes_nivelacesso() {
        return pes_nivelacesso;
    }

    public void setPes_nivelacesso(String pes_nivelacesso) {
        this.pes_nivelacesso = pes_nivelacesso;
    }

    @Override
    public String toString() {
        return pes_razaosocial;
    }
}
