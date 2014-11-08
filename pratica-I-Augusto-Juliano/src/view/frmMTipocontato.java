/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.Pub_tipocontatoDAO;
import javax.swing.JOptionPane;
import model.Pub_tipocontato;

/**
 *
 * @author juliano
 */
public class frmMTipocontato extends javax.swing.JFrame {

    private Pub_tipocontatoDAO daoTipocontato = new Pub_tipocontatoDAO();
    private Pub_tipocontato pub_tipocontato = new Pub_tipocontato();
    private int tpc_codigo = 0;

    public frmMTipocontato(Integer _tpc_codigo) {
        tpc_codigo = _tpc_codigo;
        initComponents();
        refreshForm();
        setLocationRelativeTo(null);
        if (_tpc_codigo > 0) {
            chckContinue.setVisible(false);
        } else {
            radAtivo.setSelected(true);
            radInativo.setSelected(false);
        }
    }

    private void refreshForm() {
        if (tpc_codigo > 0) {
            pub_tipocontato = daoTipocontato.findById(tpc_codigo);
            txtDesc.setText(pub_tipocontato.getTpc_descricao());
            Boolean status = pub_tipocontato.getTpc_status();
            if (status) {
                radAtivo.setSelected(true);
            } else {
                radInativo.setSelected(true);
            }
        }
    }

    private Boolean formValidation() {
        String finalMessage = "Preencha os campos obrigatórios: \n";
        String message = "";
        if (txtDesc.getText().isEmpty()) {
            message += " * Descrição \n";
        }
        if (!radAtivo.isSelected() && !radInativo.isSelected()) {
            message += " * Status";
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

        txtDesc = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        chckContinue = new java.awt.Checkbox();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        radAtivo = new javax.swing.JRadioButton();
        radInativo = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Manutenção de Tipos de Contato");

        txtDesc.setToolTipText("");
        txtDesc.setName("txtDesc"); // NOI18N
        txtDesc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDescKeyPressed(evt);
            }
        });

        jLabel1.setText("DESCRIÇÃO");

        jLabel2.setText("STATUS");

        chckContinue.setLabel("Continuar Adicionando");

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

        radAtivo.setText("ATIVO");
        radAtivo.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                radAtivoStateChanged(evt);
            }
        });
        radAtivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radAtivoActionPerformed(evt);
            }
        });

        radInativo.setText("INATIVO");
        radInativo.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                radInativoStateChanged(evt);
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
                        .addComponent(chckContinue, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(radAtivo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(radInativo))
                            .addComponent(txtDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                    .addComponent(jLabel2)
                    .addComponent(radAtivo)
                    .addComponent(radInativo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2)
                        .addComponent(jButton1))
                    .addComponent(chckContinue, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                if (tpc_codigo == 0) { //inserção
                    pub_tipocontato = new Pub_tipocontato();
                    pub_tipocontato.setTpc_descricao(txtDesc.getText().toUpperCase());
                    pub_tipocontato.setTpc_status(radAtivo.isSelected());
                    daoTipocontato.insert(pub_tipocontato);
                } else { //edição
                    pub_tipocontato.setTpc_descricao(txtDesc.getText().toUpperCase());
                    pub_tipocontato.setTpc_status(radAtivo.isSelected());
                    daoTipocontato.insert(pub_tipocontato);
                }
                JOptionPane.showMessageDialog(null, "Operação realizada com sucesso!", "Informação", JOptionPane.INFORMATION_MESSAGE);
                if (!chckContinue.getState()) {
                    this.dispose();
                } else {
                    txtDesc.setText("");
                    radAtivo.setSelected(true);
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro, o registro não foi salvo!", "Alerta", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void radAtivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radAtivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radAtivoActionPerformed

    private void radAtivoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_radAtivoStateChanged
        if (radAtivo.isSelected()) {
            radInativo.setSelected(false);
        }
    }//GEN-LAST:event_radAtivoStateChanged

    private void radInativoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_radInativoStateChanged
        if (radInativo.isSelected()) {
            radAtivo.setSelected(false);
        }
    }//GEN-LAST:event_radInativoStateChanged

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
            java.util.logging.Logger.getLogger(frmMTipocontato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMTipocontato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMTipocontato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMTipocontato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMTipocontato(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Checkbox chckContinue;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JRadioButton radAtivo;
    private javax.swing.JRadioButton radInativo;
    private javax.swing.JTextField txtDesc;
    // End of variables declaration//GEN-END:variables
}
