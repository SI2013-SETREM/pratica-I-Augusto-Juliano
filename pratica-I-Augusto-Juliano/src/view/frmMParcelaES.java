/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.Fin_afcaixaDAO;
import dao.Fin_caixaDAO;
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
public class frmMParcelaES extends javax.swing.JDialog {

    public Fin_parcela _par_codigo;
    private Fin_caixaDAO daoCaixa = new Fin_caixaDAO();
    private Fin_afcaixaDAO daoAf_caixa = new Fin_afcaixaDAO();

    public frmMParcelaES(java.awt.Frame parent, boolean modal, Fin_parcela _par) {
        super(parent, modal);
        initComponents();
        refreshCombo();
        _par_codigo = _par;
        refreshForm();
        setLocationRelativeTo(null);
    }

    private void refreshCombo() {
        List<Fin_caixa> lsFin_caixas = daoCaixa.findAll();
        DefaultComboBoxModel cboM = new DefaultComboBoxModel(new Vector(lsFin_caixas));
        cboCaixa.setModel(cboM);
    }

    private void refreshForm() {
        if (_par_codigo != null) {
            txtDataVencimento.setText(String.valueOf(_par_codigo.getPar_datavencimento()));
            txtNumeroDoc.setText(_par_codigo.getPar_numerodocumento());
            txtValor.setText(String.valueOf(_par_codigo.getPar_valortotal()));
            if (!String.valueOf(_par_codigo.getPar_valorpago()).isEmpty()) {
                txtDataPagamento.setText(String.valueOf(_par_codigo.getPar_datapagamento()));
            }
        } else {
            txtDataPagamento.setText("");
            txtDataVencimento.setText("");
            txtNumeroDoc.setText("");
            txtValor.setText("");
        }
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
        if (cboCaixa.getSelectedItem() == null) {
            message += " * Caixa \n";
        } else {
            Fin_caixa caixa = (Fin_caixa) cboCaixa.getSelectedItem();
            Boolean check = daoAf_caixa.verifyInclude(caixa.getCai_codigo());
            if (check) {
                message += " * O caixa selecionado não está aberto \n";
            }
        }
        if ("".equals(txtDataVencimento.getText())) {
            message += " * Data de Vencimento \n";
        } else {
            try {
                Date hue = getDate(txtDataVencimento.getText());
            } catch (Exception ex) {
                message += " * Data de Vencimento Inválida \n";
            }
        }
        if ("".equals(txtNumeroDoc.getText())) {
            message += " * Numero do Documento \n";
        }
        if ("".equals(txtValor.getText())) {
            message += " * Valor da Parcela \n";
        } else {
            try {
                Double hue = Double.parseDouble(txtValor.getText().replaceAll(",", "."));
            } catch (Exception ex) {
                message += " * Valor da Parcela Inválida \n";
            }
        }
        if (checkEfetivada.isSelected()) {
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
        }
        if (!"".equals(message)) {
            finalMessage += message;
            JOptionPane.showMessageDialog(null, finalMessage, "Alerta", JOptionPane.WARNING_MESSAGE);
            return false;
        } else {
            return true;
        }
    }

    private Fin_afcaixa getAfc_codigo() {
        Fin_caixa caixa = (Fin_caixa) cboCaixa.getSelectedItem();
        return daoAf_caixa.getOpendedCai_codigo(caixa.getCai_codigo());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        txtDataVencimento = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        txtValor = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        checkEfetivada = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        txtDataPagamento = new javax.swing.JFormattedTextField();
        cboCaixa = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        txtNumeroDoc = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Manutenção de Parcelas");

        jLabel3.setText("DATA VENCIMENTO");

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

        txtDataVencimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));

        jLabel4.setText("Nº DO DOCUMENTO");

        txtValor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        jLabel5.setText("VALOR PARCELA");

        checkEfetivada.setText("Efetivada?");
        checkEfetivada.setToolTipText("Marque a caixa se a parcela já foi paga!");
        checkEfetivada.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                checkEfetivadaItemStateChanged(evt);
            }
        });

        jLabel6.setText("DATA PAGAMENTO");

        txtDataPagamento.setEditable(false);
        txtDataPagamento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));

        cboCaixa.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboCaixaItemStateChanged(evt);
            }
        });
        cboCaixa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cboCaixaKeyPressed(evt);
            }
        });

        jLabel7.setText("CAIXA");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(checkEfetivada)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDataVencimento)
                                    .addComponent(txtNumeroDoc))
                                .addContainerGap())))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton2)
                                .addGap(8, 8, 8)
                                .addComponent(jButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtDataPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboCaixa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDataVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNumeroDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkEfetivada))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtDataPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (formValidation()) {
            try {
                Double valor = Double.parseDouble(txtValor.getText().replace(",", "."));
                if (_par_codigo == null || _par_codigo.getPar_codigo() == 0) {
                    _par_codigo = new Fin_parcela();
                    _par_codigo.setRcd_codigo(new Fin_receitadespesa());
                }
                _par_codigo.setAfc_codigo(getAfc_codigo());
                if (_par_codigo.getPar_codigo() == 0) {
                    _par_codigo.setPar_datacadastro(new Date(System.currentTimeMillis()).toDate());
                }
                if (checkEfetivada.isSelected()) {
                    Date data = getDate(txtDataPagamento.getText());
                    _par_codigo.setPar_datapagamento(data.toDate());
                    _par_codigo.setPar_valorpago(valor);
                } else {
                    _par_codigo.setPar_valorpago(0);
                }
                Date data = getDate(txtDataVencimento.getText());
                _par_codigo.setPar_datavencimento(data.toDate());
                _par_codigo.setPar_numerodocumento(txtNumeroDoc.getText());
                _par_codigo.setPar_pai(null);
                _par_codigo.setPar_status(checkEfetivada.isSelected());
                _par_codigo.setPar_valortotal(valor);
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

    private void cboCaixaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboCaixaItemStateChanged

    }//GEN-LAST:event_cboCaixaItemStateChanged

    private void cboCaixaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cboCaixaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            cboCaixa.setSelectedItem(null);
        }
    }//GEN-LAST:event_cboCaixaKeyPressed

    private void checkEfetivadaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_checkEfetivadaItemStateChanged
        if (checkEfetivada.isSelected()) {
            txtDataPagamento.setEditable(true);
        } else {
            txtDataPagamento.setEditable(false);
            txtDataPagamento.setText("");
        }
    }//GEN-LAST:event_checkEfetivadaItemStateChanged

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
            java.util.logging.Logger.getLogger(frmMParcelaES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMParcelaES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMParcelaES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMParcelaES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMParcelaES(null, false, null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cboCaixa;
    private javax.swing.JCheckBox checkEfetivada;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JFormattedTextField txtDataPagamento;
    private javax.swing.JFormattedTextField txtDataVencimento;
    private javax.swing.JTextField txtNumeroDoc;
    private javax.swing.JFormattedTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
