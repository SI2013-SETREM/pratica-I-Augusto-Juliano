/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.Pro_tipoprodutoDAO;
import javax.swing.JOptionPane;
import model.Pro_tipoproduto;

/**
 *
 * @author juliano
 */
public class frmMTipoproduto extends javax.swing.JFrame {

    private Pro_tipoprodutoDAO daoTipoproduto = new Pro_tipoprodutoDAO();
    private Pro_tipoproduto pro_tipoproduto = new Pro_tipoproduto();
    private int tpp_codigo = 0;

    public frmMTipoproduto(Integer _tpp_codigo) {
        tpp_codigo = _tpp_codigo;
        initComponents();
        refreshForm();
        setLocationRelativeTo(null);
        if (_tpp_codigo > 0) {
            chckContinue.setVisible(false);
        }
    }

    private void refreshForm() {
        if (tpp_codigo > 0) {
            pro_tipoproduto = daoTipoproduto.findById(tpp_codigo);
            txtDesc.setText(pro_tipoproduto.getTpp_descricao());
        }
    }

    private Boolean formValidation() {
        String finalMessage = "Preencha os campos obrigatórios: \n";
        String message = "";
        if (txtDesc.getText().isEmpty()) {
            message += " * Descrição \n";
        }
        if (message != "") {
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
        txtDesc = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        chckContinue = new java.awt.Checkbox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Manutenção de Tipos de Produto");

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

        txtDesc.setToolTipText("");
        txtDesc.setName("txtDesc"); // NOI18N
        txtDesc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDescKeyPressed(evt);
            }
        });

        jLabel1.setText("DESCRIÇÃO");

        chckContinue.setLabel("Continuar Adicionando");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(10, 10, 10)
                        .addComponent(txtDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(chckContinue, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(6, 6, 6)
                        .addComponent(jButton1)))
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
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addComponent(jButton1)
                    .addComponent(chckContinue, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            if (formValidation()) {
                if (tpp_codigo == 0) { //inserção
                    pro_tipoproduto = new Pro_tipoproduto();
                    pro_tipoproduto.setTpp_descricao(txtDesc.getText().toUpperCase());
                    daoTipoproduto.insert(pro_tipoproduto);
                } else { //edição
                    pro_tipoproduto.setTpp_descricao(txtDesc.getText().toUpperCase());
                    daoTipoproduto.update(pro_tipoproduto);
                }
                JOptionPane.showMessageDialog(null, "Operação realizada com sucesso!", "Informação", JOptionPane.INFORMATION_MESSAGE);
                if (!chckContinue.getState()) {
                    this.dispose();
                } else {
                    txtDesc.setText("");
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro, o registro não foi salvo!", "Alerta", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtDescKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescKeyPressed
        txtDesc.setText(txtDesc.getText().toUpperCase());
    }//GEN-LAST:event_txtDescKeyPressed

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
            java.util.logging.Logger.getLogger(frmMTipoproduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMTipoproduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMTipoproduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMTipoproduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMTipoproduto(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Checkbox chckContinue;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtDesc;
    // End of variables declaration//GEN-END:variables
}
