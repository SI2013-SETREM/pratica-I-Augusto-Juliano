/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testesjunit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author juliano
 */
public class metodosTest {

    public metodosTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testVerificaValorNotaFiscalEntrada() {
        System.out.println("verificaValorNotaFiscalEntrada");
        float valorBrutoNotaFiscal = 10000;
        float valorLiquidoNotaFiscal = 9200;
        float desconto = 8;
        float[] lsParcelasNF = new float[5];
        lsParcelasNF[0] = 1840;
        lsParcelasNF[1] = 1840;
        lsParcelasNF[2] = 1840;
        lsParcelasNF[3] = 1820;
        lsParcelasNF[4] = 1860;
        Boolean retornoEsperado = true;
        Boolean result = metodos.verificaValorNotaFiscalEntrada(lsParcelasNF, valorBrutoNotaFiscal, desconto, valorLiquidoNotaFiscal);
        assertEquals(retornoEsperado, result);
    }

    public void testpagamentoParcial() {
        System.out.println("testpagamentoParcial");
        float valorDivida = 830;
        float pago = 400;
        float resultadoEsperado = 430;
        float resultado = metodos.pagamentoParcial(valorDivida, pago);
        assertEquals(resultadoEsperado, resultado);
    }

}
