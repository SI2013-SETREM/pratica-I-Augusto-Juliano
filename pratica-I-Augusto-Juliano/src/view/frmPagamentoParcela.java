/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.Fin_afcaixaDAO;
import dao.Fin_caixaDAO;
import dao.Fin_parcelaDAO;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import model.Fin_afcaixa;
import model.Fin_caixa;
import model.Fin_parcela;
import model.Fin_receitadespesa;
import org.exolab.castor.types.Date;

/**
 *
 * @author juliano
 */
public class frmPagamentoParcela extends javax.swing.JDialog {

    public Fin_parcela _par_codigo;
    private Fin_parcelaDAO daoParcela = new Fin_parcelaDAO();
    private Fin_caixaDAO daoCaixa = new Fin_caixaDAO();
    private Fin_afcaixaDAO daoAf_caixa = new Fin_afcaixaDAO();

    public frmPagamentoParcela(java.awt.Frame parent, boolean modal, Integer _par) {
        super(parent, modal);
        initComponents();
        _par_codigo = daoParcela.findById(_par);
        refreshForm();
        setLocationRelativeTo(null);
    }

    private void refreshForm() {
        txtValor.setText(String.valueOf(_par_codigo.getPar_valortotal()));
    }

    private Date getDate(String data) {
        String[] lsData = data.split("/");
        Date dataF = new Date();
        dataF.setDay(Short.parseShort(lsData[0]));
        dataF.setMonth(Short.parseShort(lsData[1]));
        dataF.setYear(Short.parseShort(lsData[2]));
        return dataF;
    }

    private Boolean formValidation() {
        String finalMessage = "Preencha corretamente os campos obrigatórios: \n";
        String message = "";
        if ("".equals(txtValor.getText())) {
            message += " * Valor da Parcela \n";
        } else {
            try {
                Double hue = Double.parseDouble(txtValor.getText().replaceAll(",", "."));
            } catch (Exception ex) {
                message += " * Valor da Parcela Inválida \n";
            }
        }
        if ("".equals(txtDataPagamento.getText())) {
            message += " * Data de Pagamento \n";
        } else {
            try {
                Date pagamento = getDate(txtDataPagamento.getText());
                Date hue = new Date(System.currentTimeMillis());
                Short dia = hue.getDay();
                Short mes = hue.getMonth();
                Short ano = hue.getYear();
                Date hoje = getDate(dia + "/" + mes + "/" + ano);
                if (pagamento.toDate().after(hoje.toDate())) {
                    message += " * Data de Pagamento não pode ser maior que data atual! \n";
                }
            } catch (Exception ex) {
                message += " * Data de Pagamento Inválida \n";
            }
        }
        if (!"".equals(message)) {
            finalMessage += message;
            JOptionPane.showMessageDialog(null, finalMessage, "Alerta", JOptionPane.WARNING_MESSAGE);
            return false;
        } else {
            return true;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        txtValor = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtDataPagamento = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Manutenção de Parcelas");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/save.png"))); // NOI18N
        jButton2.setText("SALVAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cancel.png"))); // NOI18N
        jButton1.setText("CANCELAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtValor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        jLabel5.setText("VALOR PAGO");

        jLabel6.setText("DATA PAGAMENTO");

        txtDataPagamento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDataPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addGap(0, 14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtDataPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (formValidation()) {
            try {
                Double valor = Double.parseDouble(txtValor.getText().replace(",", "."));
                if (_par_codigo.getPar_valortotal() == valor) {
                    Date data = getDate(txtDataPagamento.getText());
                    _par_codigo.setPar_datapagamento(data.toDate());
                    _par_codigo.setPar_valorpago(valor);
                    daoParcela.update(_par_codigo);
                } else if (valor >= _par_codigo.getPar_valortotal()) {
                    JOptionPane.showMessageDialog(null, "O valor informado não pode ser maior que o valor da parcela!", "Alerta", JOptionPane.WARNING_MESSAGE);
                } else {
                    if ("E".equals(_par_codigo.getRcd_codigo().getCtm_codigo().getCtm_entradasaida())) {
                        Double novaParcela = (_par_codigo.getPar_valortotal() - valor);
                        Double antigaParcela = _par_codigo.getPar_valortotal();
                        Fin_parcela nova = new Fin_parcela();
                        _par_codigo.setPar_valortotal(valor);
                        _par_codigo.setPar_valorpago(valor);
                        _par_codigo.setPar_status(true);
                        Date data = getDate(txtDataPagamento.getText());
                        _par_codigo.setPar_datapagamento(data.toDate());
                        daoParcela.update(_par_codigo);
                        nova = _par_codigo;
                        nova.setPar_pai(_par_codigo);
                        nova.setPar_valortotal(novaParcela);
                        nova.setPar_status(false);
                        nova.setPar_valorpago(0.00);
                        nova.setPar_datapagamento(null);
                        nova.setPar_codigo(0);
                        daoParcela.insert(nova);
                    } else {
                        JOptionPane.showMessageDialog(null, "O valor informado não pode ser menor que o valor da parcela!");
                    }
                }
                this.dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro e o registro não foi salvo!", "Alerta", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        _par_codigo = null;
        this.dispose();
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
            java.util.logging.Logger.getLogger(frmPagamentoParcela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPagamentoParcela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPagamentoParcela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPagamentoParcela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPagamentoParcela(null, false, null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JFormattedTextField txtDataPagamento;
    private javax.swing.JFormattedTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
