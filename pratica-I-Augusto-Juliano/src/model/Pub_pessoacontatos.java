package model;

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
@SequenceGenerator(name = "seq_psc_codigo", sequenceName = "seq_psc_codigo", allocationSize = 1)
public class Pub_pessoacontatos {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_psc_codigo")
    private int psc_codigo;
    @ManyToOne
    @JoinColumn(name = "tpc_codigo")
    private Pub_tipocontato tpc_codigo;
    @ManyToOne
    @JoinColumn(name = "pes_codigo")
    private Pub_pessoa pes_codigo;
    private String psc_contato;

    public Pub_pessoacontatos() {
    }

    public int getPsc_codigo() {
        return psc_codigo;
    }

    public void setPsc_codigo(int psc_codigo) {
        this.psc_codigo = psc_codigo;
    }

    public Pub_tipocontato getTpc_codigo() {
        return tpc_codigo;
    }

    public void setTpc_codigo(Pub_tipocontato tpc_codigo) {
        this.tpc_codigo = tpc_codigo;
    }

    public Pub_pessoa getPes_codigo() {
        return pes_codigo;
    }

    public void setPes_codigo(Pub_pessoa pes_codigo) {
        this.pes_codigo = pes_codigo;
    }

    public String getPsc_contato() {
        return psc_contato;
    }

    public void setPsc_contato(String psc_contato) {
        this.psc_contato = psc_contato;
    }

    @Override
    public String toString() {
        return psc_contato;
    }

}
