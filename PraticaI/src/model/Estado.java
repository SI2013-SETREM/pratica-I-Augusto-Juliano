
package model;

import util.field.FilterField;
import util.field.FilterFieldDynamicCombo;
import util.field.FilterFieldText;

/**
 *
 * @author Dinei A. Rockenbach
 * @author Nadine Anderle
 */
public class Estado extends ModelTemplate {
    private Pais pais;
    private String EstSigla;
    private String EstNome;
    
    /**
     * @see model.ModelTemplate#sngTitle
     */
    public static String sngTitle = "Estado";
    /**
     * @see model.ModelTemplate#prlTitle
     */
    public static String prlTitle = "Estados";
    /**
     * @see model.ModelTemplate#idColumn
     */
    public static String[] idColumn = {"Pais.PaiCodigo", "EstSigla"};
    /**
     * @see model.ModelTemplate#listTableFields
     */
    public static String[][] listTableFields = {
        {"País", "Pais.PaiNome"},
        {"Sigla","EstSigla"},
        {"Nome", "EstNome"}
    };
    /**
     * @see model.ModelTemplate#listFilterFields
     */
    public static FilterField[] listFilterFields = {
        new FilterFieldText("EstNome", "Nome", 200),
        new FilterFieldDynamicCombo("Pais.PaiCodigo", "País", 200, Pais.class, "PaiNome", null, null, "")
    };
    
    public Estado() {
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public String getEstSigla() {
        return EstSigla;
    }

    public void setEstSigla(String EstSigla) {
        this.EstSigla = EstSigla;
    }

    public String getEstNome() {
        return EstNome;
    }

    public void setEstNome(String EstNome) {
        this.EstNome = EstNome;
    }

}
