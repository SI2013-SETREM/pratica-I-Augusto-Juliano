/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package charts;

import dao.Fin_parcelaDAO;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.util.List;
import javax.swing.JOptionPane;
import model.Fin_caixa;
import model.Fin_parcela;
import org.exolab.castor.types.Date;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author juliano
 */
public class ChartParcelasMesEntrada extends javax.swing.JFrame {

    Boolean all = true;
    Fin_caixa caixa = new Fin_caixa();
    Fin_parcela parcela = new Fin_parcela();
    Fin_parcelaDAO daoParcela = new Fin_parcelaDAO();
    String dataInicio = "";
    String dataFim = "";

    public ChartParcelasMesEntrada(Boolean _all, Fin_caixa _caixa) { //se all for true traz as pagas e não pagas, se for false, traz apenas as pagas
        all = _all;
        caixa = _caixa;
        initComponents();
        dataInicio = "01/";
        dataFim = "01/";
        if ((new Date(System.currentTimeMillis()).getMonth() - 3) > 9) {
            dataInicio += (new Date(System.currentTimeMillis()).getMonth() - 3);
        } else {
            dataInicio += "0" + (new Date(System.currentTimeMillis()).getMonth() - 3);
        }
        dataInicio += "/" + (new Date(System.currentTimeMillis()).getYear());

        if ((new Date(System.currentTimeMillis()).getMonth() + 3) > 12) {
            dataFim += "03/" + (new Date(System.currentTimeMillis()).getYear() + 1);
        }
        txtInicio.setText(dataInicio);
        txtFim.setText(dataFim);
        setLocationRelativeTo(null);
        URL url = this.getClass().getResource("../images/chart.png");
        Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(imagemTitulo);
    }

    public CategoryDataset getList() {
        String dataInicio = txtInicio.getText();
        String[] lsDataIni = dataInicio.split("/");
        lsDataIni[2] = "00" + lsDataIni[2];
        dataInicio = lsDataIni[0] + "/" + lsDataIni[1] + "/" + lsDataIni[2];
        String dataFim = txtFim.getText();
        String[] lsDataFim = dataFim.split("/");
        lsDataFim[2] = "00" + lsDataFim[2];
        dataFim = lsDataFim[0] + "/" + lsDataFim[1] + "/" + lsDataFim[2];
        List<Object[]> lsParcela = daoParcela.getParcelasChartEntrada(dataInicio, dataFim, checkEfetivadas.isSelected());
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 0; i < lsParcela.size(); i++) {
            String mes = "";
            if ((Double) lsParcela.get(i)[1] > 9) {
                mes = lsParcela.get(i)[1].toString().replaceAll(".0", "");
            } else {
                mes = "0" + lsParcela.get(i)[1].toString().replaceAll(".0", "");
            }

            String ano = lsParcela.get(i)[2].toString().replaceAll(".0", "");
            dataset.addValue(Double.parseDouble(lsParcela.get(i)[0].toString()), mes + "/" + ano, "Mês/Ano");
        }
        return dataset;
    }

    public void criaGrafico() {
        CategoryDataset cds = getList();
        String titulo = "Previsão de Entradas (Mês/Ano)";
        String eixoy = "Valores (R$)";
        String txt_legenda = "Ledenda:";
        boolean legenda = true;
        boolean tooltips = true;
        boolean urls = true;
        JFreeChart graf = ChartFactory.createBarChart3D(titulo, txt_legenda, eixoy, cds, PlotOrientation.VERTICAL, legenda, tooltips, urls);
        ChartPanel myChartPanel = new ChartPanel(graf, true);
        myChartPanel.setSize(jPanel1.getWidth(), jPanel1.getHeight());
        myChartPanel.setVisible(true);
        jPanel1.removeAll();
        jPanel1.add(myChartPanel);
        jPanel1.revalidate();
        jPanel1.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtInicio = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        txtFim = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        checkEfetivadas = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gráfico");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 454, Short.MAX_VALUE)
        );

        txtInicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));

        jLabel1.setText("DATA INICIO");

        txtFim.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));

        jLabel2.setText("DATA FIM");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/chart.png"))); // NOI18N
        jButton1.setText("Gerar Gráfico");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        checkEfetivadas.setText("Efetivadas?");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFim, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkEfetivadas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(121, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(txtFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jButton1)
                    .addComponent(checkEfetivadas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            criaGrafico();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "O gráfico não pode ser gerado, tente novamente!", "Alerta", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ChartParcelasMesEntrada.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChartParcelasMesEntrada.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChartParcelasMesEntrada.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChartParcelasMesEntrada.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChartParcelasMesEntrada(null, null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox checkEfetivadas;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JFormattedTextField txtFim;
    private javax.swing.JFormattedTextField txtInicio;
    // End of variables declaration//GEN-END:variables
}
