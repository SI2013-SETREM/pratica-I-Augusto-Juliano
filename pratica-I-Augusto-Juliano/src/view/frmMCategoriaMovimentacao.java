/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.Fin_categoriamovimentacaoDAO;
import javax.swing.JOptionPane;
import model.Fin_categoriamovimentacao;

/**
 *
 * @author juliano
 */
public class frmMCategoriaMovimentacao extends javax.swing.JFrame {

    private Fin_categoriamovimentacaoDAO daoCategoria = new Fin_categoriamovimentacaoDAO();
    private Fin_categoriamovimentacao fin_categoriamovimentacao = new Fin_categoriamovimentacao();
    private int ctm_codigo = 0;

    public frmMCategoriaMovimentacao(Integer _ctm_codigo) {
        ctm_codigo = _ctm_codigo;
        initComponents();
        refreshForm();
        setLocationRelativeTo(null);
    }

    private Boolean formValidation() {
        String finalMessage = "Preencha corretamente os campos obrigatórios: \n";
        String message = "";
        if (txtDesc.getText().isEmpty()) {
            message += " * Descrição \n";
        }
        if (!radEntrada.isSelected() && !radSaida.isSelected()) {
            message += " * Entrada/Saída \n";
        }
        if (!"".equals(message)) {
            finalMessage += message;
            JOptionPane.showMessageDialog(null, finalMessage, "Alerta", JOptionPane.WARNING_MESSAGE);
            return false;
        } else {
            return true;
        }
    }

    private void refreshForm() {
        if (ctm_codigo > 0) {
            fin_categoriamovimentacao = daoCategoria.findById(ctm_codigo);
            txtDesc.setText(fin_categoriamovimentacao.getCtm_descricao());
            if ("E".equals(fin_categoriamovimentacao.getCtm_entradasaida())) {
                radEntrada.setSelected(true);
                radSaida.setSelected(false);
            } else {
                radEntrada.setSelected(false);
                radSaida.setSelected(true);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        txtDesc = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        radEntrada = new javax.swing.JRadioButton();
        radSaida = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Manutenção de Categoria de Movimentações");

        txtDesc.setToolTipText("");
        txtDesc.setName("txtDesc"); // NOI18N
        txtDesc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDescKeyPressed(evt);
            }
        });

        jLabel1.setText("DESCRIÇÃO");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/save.png"))); // NOI18N
        jButton2.setText("SALVAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/cancel.png"))); // NOI18N
        jButton1.setText("CANCELAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        radEntrada.setText("Entrada em Caixa");
        radEntrada.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                radEntradaItemStateChanged(evt);
            }
        });

        radSaida.setText("Saída do Caixa");
        radSaida.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                radSaidaItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(263, 263, 263)
                        .addComponent(jButton2)
                        .addGap(6, 6, 6)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(radEntrada)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(radSaida)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtDesc))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel1))
                    .addComponent(txtDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radEntrada)
                    .addComponent(radSaida))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDescKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescKeyPressed
        txtDesc.setText(txtDesc.getText().toUpperCase());
    }//GEN-LAST:event_txtDescKeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            if (formValidation()) {
                if (ctm_codigo == 0) { //inserção
                    fin_categoriamovimentacao = new Fin_categoriamovimentacao();
                    fin_categoriamovimentacao.setCtm_descricao(txtDesc.getText().toUpperCase());
                    if (radEntrada.isSelected()) {
                        fin_categoriamovimentacao.setCtm_entradasaida("E");
                    } else {
                        fin_categoriamovimentacao.setCtm_entradasaida("S");
                    }
                    daoCategoria.insert(fin_categoriamovimentacao);
                } else { //edição
                    fin_categoriamovimentacao.setCtm_descricao(txtDesc.getText().toUpperCase());
                    if (radEntrada.isSelected()) {
                        fin_categoriamovimentacao.setCtm_entradasaida("E");
                    } else {
                        fin_categoriamovimentacao.setCtm_entradasaida("S");
                    }
                    daoCategoria.update(fin_categoriamovimentacao);
                }
                JOptionPane.showMessageDialog(null, "Operação realizada com sucesso!", "Informação", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro, o registro não foi salvo!", "Alerta", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void radEntradaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_radEntradaItemStateChanged
        if (radEntrada.isSelected()) {
            radSaida.setSelected(false);
        }
    }//GEN-LAST:event_radEntradaItemStateChanged

    private void radSaidaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_radSaidaItemStateChanged
        if (radSaida.isSelected()) {
            radEntrada.setSelected(false);
        }
    }//GEN-LAST:event_radSaidaItemStateChanged

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
            java.util.logging.Logger.getLogger(frmMCategoriaMovimentacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMCategoriaMovimentacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMCategoriaMovimentacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMCategoriaMovimentacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMCategoriaMovimentacao(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton radEntrada;
    private javax.swing.JRadioButton radSaida;
    private javax.swing.JTextField txtDesc;
    // End of variables declaration//GEN-END:variables
}
