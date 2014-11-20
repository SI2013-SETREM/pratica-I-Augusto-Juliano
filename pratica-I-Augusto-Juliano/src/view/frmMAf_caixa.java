/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.Fin_afcaixaDAO;
import dao.Fin_caixaDAO;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import model.Fin_afcaixa;
import model.Fin_caixa;

/**
 *
 * @author juliano
 */
public class frmMAf_caixa extends javax.swing.JFrame {

    Fin_afcaixaDAO daoAf_caixa = new Fin_afcaixaDAO();
    Fin_afcaixa fin_afcaixa = new Fin_afcaixa();
    Fin_caixa fin_caixa = new Fin_caixa();
    Fin_caixaDAO daoCaixas = new Fin_caixaDAO();

    public frmMAf_caixa() {
        initComponents();
        refreshCombo();
        setLocationRelativeTo(null);
    }

    private void refreshCombo() {
        List<Fin_caixa> lsCaixas = daoCaixas.findAll();
        DefaultComboBoxModel cboM = new DefaultComboBoxModel(new Vector(lsCaixas));
        cboCaixas.setModel(cboM);
        cboCaixas.setSelectedIndex(-1);
    }

    private void refreshValues(Integer _cai_codigo) {
        try {
            fin_afcaixa = daoAf_caixa.findLastValue(_cai_codigo);
            if (fin_afcaixa != null) {
                txtValor.setText(String.valueOf(fin_afcaixa.getAfc_valorfechamento()));
            } else {
                fin_caixa = daoCaixas.findById(_cai_codigo);
                txtValor.setText(String.valueOf(fin_caixa.getCai_valorinicial()));
            }
        } catch (Exception e) {
            txtValor.setText("");
        }
    }

    private Boolean formValidation() {
        String finalMessage = "Preencha corretamente os campos: \n";
        String message = "";
        if (cboCaixas.getSelectedIndex() == -1) {
            message += " * Caixa \n";
        }
        if (!txtValor.getText().isEmpty()) {
            try {
                Double.parseDouble(txtValor.getText().replaceAll(",", "."));
            } catch (Exception ex) {
                message += " * Valor de Compra Inválido \n";
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

        cboCaixas = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        txtValor = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Novo Período de Caixa");

        cboCaixas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboCaixasItemStateChanged(evt);
            }
        });
        cboCaixas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboCaixasActionPerformed(evt);
            }
        });
        cboCaixas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cboCaixasKeyPressed(evt);
            }
        });

        jLabel2.setText("VALOR");
        jLabel2.setToolTipText("");

        jLabel3.setText("CAIXA");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cboCaixas, 0, 367, Short.MAX_VALUE)
                            .addComponent(txtValor))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboCaixas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboCaixasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboCaixasActionPerformed

    }//GEN-LAST:event_cboCaixasActionPerformed

    private void cboCaixasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cboCaixasKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            cboCaixas.setSelectedItem(null);
        }
    }//GEN-LAST:event_cboCaixasKeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            if (formValidation()) {
                fin_caixa = (Fin_caixa) cboCaixas.getSelectedItem();
                if (daoAf_caixa.verifyInclude(fin_caixa.getCai_codigo())) {
                    fin_afcaixa = new Fin_afcaixa();
                    fin_afcaixa.setAfc_dataabertura(new Date());
                    fin_afcaixa.setAfc_valorabertura(Double.parseDouble(txtValor.getText()));
                    fin_afcaixa.setCai_codigo((Fin_caixa) cboCaixas.getSelectedItem());
                    daoAf_caixa.insert(fin_afcaixa);
                    JOptionPane.showMessageDialog(null, "Operação realizada com sucesso!", "Informação", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Já existe um período de caixa aberto para o caixa selecionado!", "Informação", JOptionPane.WARNING_MESSAGE);
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro, o registro não foi salvo!", "Alerta", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cboCaixasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboCaixasItemStateChanged
        if (cboCaixas.getSelectedIndex() > -1) {
            Fin_caixa _caixa = (Fin_caixa) cboCaixas.getSelectedItem();
            refreshValues(_caixa.getCai_codigo());
        }
    }//GEN-LAST:event_cboCaixasItemStateChanged

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
            java.util.logging.Logger.getLogger(frmMAf_caixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMAf_caixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMAf_caixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMAf_caixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMAf_caixa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cboCaixas;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JFormattedTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
