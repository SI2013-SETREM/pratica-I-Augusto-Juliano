/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.Pub_tipocontatoDAO;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import model.Pub_pessoacontatos;
import model.Pub_tipocontato;

/**
 *
 * @author juliano
 */
public class frmMPessoaContatos extends javax.swing.JDialog {

    private Pub_tipocontato _tpc_codigo = new Pub_tipocontato();
    private Pub_tipocontatoDAO daoTipoContato = new Pub_tipocontatoDAO();
    public Pub_pessoacontatos _psc_codigo;

    public frmMPessoaContatos(java.awt.Frame parent, boolean modal, Pub_pessoacontatos _psc) {
        super(parent, modal);
        initComponents();
        refreshCombo();
        _psc_codigo = _psc;
        refreshForm();
        setLocationRelativeTo(null);
    }

    private void refreshCombo() {
        List<Pub_tipocontato> lsTipoContato = daoTipoContato.findAllActived();
        DefaultComboBoxModel cboM = new DefaultComboBoxModel(new Vector(lsTipoContato));
        cboTipoContato.setModel(cboM);
    }

    private void refreshForm() {
        if (_psc_codigo != null) {
            txtContato.setText(_psc_codigo.getPsc_contato());
            Integer indx = 0;
            for (int i = 0; i < cboTipoContato.getItemCount(); i++) {
                Pub_tipocontato haha = (Pub_tipocontato) cboTipoContato.getItemAt(i);
                if (haha.getTpc_codigo() == _psc_codigo.getTpc_codigo().getTpc_codigo()) {
                    indx = i;
                }
            }
            cboTipoContato.setSelectedIndex(indx);
            cboTipoContato.setSelectedItem(_psc_codigo.getTpc_codigo());
        } else {
            cboTipoContato.setSelectedItem(null);
            txtContato.setText("");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cboTipoContato = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtContato = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Manutenção de Contatos");

        cboTipoContato.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboTipoContatoItemStateChanged(evt);
            }
        });

        jLabel4.setText("TIPO DE CONTATO");

        jLabel3.setText("CONTATO");

        txtContato.setToolTipText("");
        txtContato.setName("txtDesc"); // NOI18N
        txtContato.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtContatoFocusLost(evt);
            }
        });
        txtContato.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtContatoKeyPressed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon("C:\\Users\\juliano\\Documents\\NetBeansProjects\\pratica-I-Augusto-Juliano\\trunk\\pratica-I-Augusto-Juliano\\src\\image\\save.png")); // NOI18N
        jButton2.setText("SALVAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\juliano\\Documents\\NetBeansProjects\\pratica-I-Augusto-Juliano\\trunk\\pratica-I-Augusto-Juliano\\src\\image\\cancel.png")); // NOI18N
        jButton1.setText("CANCELAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 234, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addGap(6, 6, 6))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtContato)
                            .addComponent(cboTipoContato, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboTipoContato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtContato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(0, 10, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboTipoContatoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboTipoContatoItemStateChanged

    }//GEN-LAST:event_cboTipoContatoItemStateChanged

    private void txtContatoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtContatoFocusLost

    }//GEN-LAST:event_txtContatoFocusLost

    private void txtContatoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContatoKeyPressed

    }//GEN-LAST:event_txtContatoKeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        _psc_codigo = new Pub_pessoacontatos();
        _psc_codigo.setPes_codigo(null);
        _psc_codigo.setPsc_codigo(0);
        _psc_codigo.setPsc_contato(txtContato.getText());
        _psc_codigo.setTpc_codigo((Pub_tipocontato) cboTipoContato.getSelectedItem());
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        _psc_codigo = null;
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
            java.util.logging.Logger.getLogger(frmMPessoaContatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMPessoaContatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMPessoaContatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMPessoaContatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMPessoaContatos(null, false, null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cboTipoContato;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtContato;
    // End of variables declaration//GEN-END:variables
}
