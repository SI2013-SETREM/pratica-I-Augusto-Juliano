/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.Pub_cidadeDAO;
import dao.Pub_estadoDAO;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import model.Pub_cidade;
import model.Pub_estado;

/**
 *
 * @author juliano
 */
public class frmMCidades extends javax.swing.JFrame {

    private Pub_cidadeDAO daoCidades = new Pub_cidadeDAO();
    private Pub_estadoDAO daoEstados = new Pub_estadoDAO();
    private Pub_cidade pub_cidade = new Pub_cidade();
    private int cid_codigo = 0;

    public frmMCidades(Integer _cid_codigo) {
        cid_codigo = _cid_codigo;
        initComponents();
        refreshCombo();
        refreshForm();
        setLocationRelativeTo(null);
        if (_cid_codigo > 0) {
            chckContinue.setVisible(false);
        }
    }

    private void refreshCombo() {
        List<Pub_estado> lsEstados = daoEstados.findAll();
        DefaultComboBoxModel cbox = new DefaultComboBoxModel(new Vector(lsEstados));
        cboEstado.setModel(cbox);
    }

    private void refreshForm() {
        if (cid_codigo > 0) {
            pub_cidade = daoCidades.findById(cid_codigo);
            txtDesc.setText(pub_cidade.getCid_descricao());
            txtCep.setText(pub_cidade.getCid_cep());
            cboEstado.setSelectedItem(pub_cidade.getEst_codigo());
        } else {
            cboEstado.setSelectedItem(null);
        }
    }

    public String formataCEP(String _cep) {
        if (_cep.length() < 8) {
            return "";
        } else if (_cep.length() == 8) {
            if (_cep.contains("-")) {
                return "";
            } else {
                String cep_inicio = _cep.substring(0, 5) + "-";
                String cep_fim = _cep.substring(5, 8);
                return cep_inicio + cep_fim;
            }
        } else if (_cep.length() == 9) {
            if (_cep.replace("-", "").length() == 8) {
                return _cep;
            } else {
                return "";
            }
        } else {
            return "";
        }
    }

    private Boolean formValidation() {
        String finalMessage = "Preencha corretamente os campos: \n";
        String message = "";
        if (txtDesc.getText().isEmpty()) {
            message += " * Descrição \n";
        }
        if (txtCep.getText().isEmpty()) {
            message += " * CEP \n";
        } else {
            String cep_validator = formataCEP(txtCep.getText());
            if (cep_validator.isEmpty()) {
                message += " * CEP Inválido \n";
            }
        }
        if (cboEstado.getSelectedIndex() == -1) {
            message += " * Estado \n";
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

        chckContinue = new java.awt.Checkbox();
        jLabel2 = new javax.swing.JLabel();
        txtCep = new javax.swing.JTextField();
        txtDesc = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        cboEstado = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Manutenção de Cidades");

        chckContinue.setLabel("Continuar Adicionando");

        jLabel2.setText("CEP");

        txtCep.setToolTipText("");
        txtCep.setName("txtDesc"); // NOI18N
        txtCep.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCepKeyPressed(evt);
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

        jLabel3.setText("ESTADO");

        cboEstado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cboEstadoKeyPressed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDesc, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
                            .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(chckContinue, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2)
                        .addComponent(jButton1))
                    .addComponent(chckContinue, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCepKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCepKeyPressed

    }//GEN-LAST:event_txtCepKeyPressed

    private void txtDescKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescKeyPressed
        txtDesc.setText(txtDesc.getText().toUpperCase());
    }//GEN-LAST:event_txtDescKeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            if (formValidation()) {

                if (cid_codigo == 0) { //inserção
                    pub_cidade = new Pub_cidade();
                    pub_cidade.setCid_descricao(txtDesc.getText().toUpperCase());
                    pub_cidade.setCid_cep(formataCEP(txtCep.getText()));
                    pub_cidade.setEst_codigo((Pub_estado) cboEstado.getSelectedItem());
                    daoCidades.insert(pub_cidade);
                } else { //edição
                    pub_cidade.setCid_descricao(txtDesc.getText().toUpperCase());
                    pub_cidade.setCid_cep(formataCEP(txtCep.getText()));
                    pub_cidade.setEst_codigo((Pub_estado) cboEstado.getSelectedItem());
                    daoCidades.update(pub_cidade);
                }
                JOptionPane.showMessageDialog(null, "Operação realizada com sucesso!", "Informação", JOptionPane.INFORMATION_MESSAGE);
                if (!chckContinue.getState()) {
                    this.dispose();
                } else {
                    txtDesc.setText("");
                    txtCep.setText("");
                    cboEstado.setSelectedItem(null);
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro, o registro não foi salvo!", "Alerta", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cboEstadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cboEstadoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            cboEstado.setSelectedItem(null);
        }
    }//GEN-LAST:event_cboEstadoKeyPressed

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
            java.util.logging.Logger.getLogger(frmMCidades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMCidades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMCidades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMCidades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMCidades(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cboEstado;
    private java.awt.Checkbox chckContinue;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtCep;
    private javax.swing.JTextField txtDesc;
    // End of variables declaration//GEN-END:variables
}
