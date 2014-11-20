/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.Pro_produtoDAO;
import dao.Pub_tipocontatoDAO;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import model.Fin_movimentacaoprodutos;
import model.Fin_receitadespesa;
import model.Pro_produto;
import model.Pub_pessoacontatos;
import model.Pub_tipocontato;

/**
 *
 * @author juliano
 */
public class frmMProdutosNotaFiscal extends javax.swing.JDialog {

    private Double _vlr_bruto = 0.00;
    private final Pro_produto _pro_codigo = new Pro_produto();
    private final Pro_produtoDAO daoProd = new Pro_produtoDAO();
    public Fin_movimentacaoprodutos _fin_movimentacaoprodutos;

    public frmMProdutosNotaFiscal(java.awt.Frame parent, boolean modal, Fin_movimentacaoprodutos _fin) {
        super(parent, modal);
        initComponents();
        refreshCombo();
        _fin_movimentacaoprodutos = _fin;
        refreshForm();
        setLocationRelativeTo(null);
    }

    private void refreshCombo() {
        List<Pro_produto> lsProdutos = daoProd.findAll();
        DefaultComboBoxModel cboP = new DefaultComboBoxModel(new Vector(lsProdutos));
        cboProduto.setModel(cboP);
    }

    private void refreshForm() {
        if (_fin_movimentacaoprodutos != null) {
            cboProduto.getModel().setSelectedItem(_fin_movimentacaoprodutos.getPro_codigo());
            txtDesc.setText(String.valueOf(_fin_movimentacaoprodutos.getPro_desconto()));
            txtQuant.setText(String.valueOf(_fin_movimentacaoprodutos.getPro_quantidade()));
            txtValorUnit.setText(String.valueOf(_fin_movimentacaoprodutos.getPro_valorunitario()));
            txtValorTotal.setText(String.valueOf(_fin_movimentacaoprodutos.getPro_valorliquido()));

        } else {
            txtQuant.setText("");
            txtDesc.setText("");
            txtValorTotal.setText("");
            txtValorUnit.setText("");
        }
    }

    private void calcValores() {
        try {
            Double desc = 0.00;
            if (!txtDesc.getText().isEmpty()) {
                desc = Double.parseDouble(txtDesc.getText());
            }
            Double vlr_unt = Double.parseDouble(txtValorUnit.getText());
            Double quant = Double.parseDouble(txtQuant.getText());
            if (desc > 0) {
                Double vlr_total = 0.00;
                desc = desc * 0.01;
                vlr_total = (vlr_unt * quant) - (vlr_unt * quant * desc);
                txtValorTotal.setText(String.valueOf(vlr_total));
            } else {
                txtValorTotal.setText(String.valueOf(vlr_unt * quant));
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Valor Total dos Produtos não pode ser calculado, revise os dados informados!", "Alerta", JOptionPane.WARNING_MESSAGE);
        }
    }

    private Boolean formValidation() {
        String finalMessage = "Preencha corretamente os campos obrigatórios: \n";
        String message = "";
        if (cboProduto.getSelectedIndex() == -1) {
            message += " * Produto \n";
        }
        if (txtQuant.getText().isEmpty()) {
            message += " * Quantidade \n";
        } else {
            try {
                Double test = Double.parseDouble(txtQuant.getText());
            } catch (Exception ex) {
                message += " * Quantidade Inválida \n";
            }
        }
        if (txtValorUnit.getText().isEmpty()) {
            message += " * Valor Unitário \n";
        } else {
            try {
                Double test = Double.parseDouble(txtValorUnit.getText());
            } catch (Exception ex) {
                message += " * Valor Unitário Inválido \n";
            }
        }
        if (!txtDesc.getText().isEmpty()) {
            try {
                Double test = Double.parseDouble(txtDesc.getText());
            } catch (Exception ex) {
                message += " * Desconto Inválido \n";
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

        cboProduto = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtValorUnit = new javax.swing.JFormattedTextField();
        txtValorTotal = new javax.swing.JFormattedTextField();
        txtDesc = new javax.swing.JFormattedTextField();
        txtQuant = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Manutenção de Produtos");

        cboProduto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboProdutoItemStateChanged(evt);
            }
        });
        cboProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cboProdutoKeyPressed(evt);
            }
        });

        jLabel4.setText("PRODUTO");

        jLabel3.setText("QUANT.");

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

        jLabel5.setText("VALOR UNITARIO");

        jLabel6.setText("DESCONTO");

        jLabel7.setText("VALOR TOTAL");

        txtValorUnit.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("¤#,##0.00"))));
        txtValorUnit.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtValorUnitFocusLost(evt);
            }
        });

        txtValorTotal.setEditable(false);
        txtValorTotal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("¤#,##0.00"))));

        txtDesc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00%"))));
        txtDesc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDescFocusLost(evt);
            }
        });

        txtQuant.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        txtQuant.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtQuantFocusLost(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtDesc, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                            .addComponent(txtQuant))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtValorUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jButton2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton1))))))
                    .addComponent(cboProduto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(txtValorUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtQuant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(txtValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(0, 8, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboProdutoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboProdutoItemStateChanged
        Pro_produto produto = (Pro_produto) cboProduto.getSelectedItem();
        txtValorUnit.setText(String.valueOf(produto.getPro_valorcompra()));
    }//GEN-LAST:event_cboProdutoItemStateChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (formValidation()) {
            try {
                calcValores();
                _fin_movimentacaoprodutos = new Fin_movimentacaoprodutos();
                _fin_movimentacaoprodutos.setPro_codigo((Pro_produto) cboProduto.getSelectedItem());
                if (!txtDesc.getText().isEmpty()) {
                    _fin_movimentacaoprodutos.setPro_desconto(Double.parseDouble(txtDesc.getText()));
                    Double valor_desc = (Double.parseDouble(txtDesc.getText()) * 0.01) * _vlr_bruto;
                    _fin_movimentacaoprodutos.setPro_valorliquido(_vlr_bruto - valor_desc);
                } else {
                    _fin_movimentacaoprodutos.setPro_desconto(0.00);
                    _fin_movimentacaoprodutos.setPro_valorliquido(_vlr_bruto);
                }
                _fin_movimentacaoprodutos.setPro_quantidade(Double.parseDouble(txtQuant.getText()));
                _fin_movimentacaoprodutos.setPro_valorbruto(_vlr_bruto);

                _fin_movimentacaoprodutos.setPro_valorunitario(Double.parseDouble(txtValorUnit.getText()));
                _fin_movimentacaoprodutos.setRcd_codigo(new Fin_receitadespesa());
                _fin_movimentacaoprodutos.getRcd_codigo().setRcd_codigo(0);
                this.dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro e o regitro não foi salvo!", "Alerta", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        _fin_movimentacaoprodutos = null;
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cboProdutoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cboProdutoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            cboProduto.setSelectedItem(null);
        }
    }//GEN-LAST:event_cboProdutoKeyPressed

    private void txtQuantFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtQuantFocusLost
        try {
            if (!txtQuant.getText().isEmpty() && !txtValorUnit.getText().isEmpty()) {
                Double quant = Double.parseDouble(txtQuant.getText());
                Double unit = Double.parseDouble(txtValorUnit.getText());
                _vlr_bruto = quant * unit;
                calcValores();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "O Valor de Desconto informado é inválido!", "Alerta", JOptionPane.ERROR_MESSAGE);
            txtDesc.setText("");
        }
    }//GEN-LAST:event_txtQuantFocusLost

    private void txtValorUnitFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtValorUnitFocusLost
        try {
            if (!txtValorUnit.getText().isEmpty() && !txtQuant.getText().isEmpty()) {
                Double unit = Double.parseDouble(txtValorUnit.getText());
                Double quant = Double.parseDouble(txtQuant.getText());
                _vlr_bruto = quant * unit;
                calcValores();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "O Valor Unitário informado é inválido!", "Alerta", JOptionPane.ERROR_MESSAGE);
            txtValorUnit.setText("");
        }
    }//GEN-LAST:event_txtValorUnitFocusLost

    private void txtDescFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDescFocusLost
        if (!txtQuant.getText().isEmpty() && !txtValorUnit.getText().isEmpty()) {
            calcValores();
        }
    }//GEN-LAST:event_txtDescFocusLost

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
            java.util.logging.Logger.getLogger(frmMProdutosNotaFiscal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMProdutosNotaFiscal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMProdutosNotaFiscal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMProdutosNotaFiscal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMProdutosNotaFiscal(null, false, null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cboProduto;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JFormattedTextField txtDesc;
    private javax.swing.JFormattedTextField txtQuant;
    private javax.swing.JFormattedTextField txtValorTotal;
    private javax.swing.JFormattedTextField txtValorUnit;
    // End of variables declaration//GEN-END:variables
}
