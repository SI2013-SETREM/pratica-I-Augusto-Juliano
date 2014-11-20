/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testesjunit;

import javax.swing.JOptionPane;

/**
 *
 * @author juliano
 */
public class metodos {

    public static Boolean verificaValorNotaFiscalEntrada(float[] lsValoresParcelas, float valorBrutoNota, float desconto, float valorLiquido) {
        float valorTotalParcelas = 0;
        for (int i = 0; i < lsValoresParcelas.length; i++) {
            valorTotalParcelas += lsValoresParcelas[i];
        }
        float valorLiquidoNota = valorBrutoNota - ((desconto / 100) * valorBrutoNota);
        if (valorLiquidoNota == valorLiquido && valorLiquidoNota == valorTotalParcelas) {
            return true;
        } else {
            return false;
        }
    }

    public static float pagamentoParcial(float totalParcela, float pago) {
        float novaParcelaF = totalParcela - pago;
        return novaParcelaF;
    }
}
