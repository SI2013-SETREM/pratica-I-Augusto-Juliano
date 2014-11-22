/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.Fin_caixaDAO;
import dao.Fin_parcelaDAO;
import dao.Pub_pessoaDAO;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Fin_caixa;
import model.Fin_parcela;
import model.Pub_pessoa;
import org.exolab.castor.types.Date;

/**
 *
 * @author juliano
 */
public class frmLParcelas extends javax.swing.JFrame {

    Fin_parcela finParcela = new Fin_parcela();
    Fin_parcelaDAO daoParcela = new Fin_parcelaDAO();
    Pub_pessoa pubPessoa = new Pub_pessoa();
    Pub_pessoaDAO daoPessoa = new Pub_pessoaDAO();
    Fin_caixa finCaixa = new Fin_caixa();
    Fin_caixaDAO daoCaixa = new Fin_caixaDAO();

    public frmLParcelas() {
        initComponents();
        refreshCombo();
    }

    private void refreshGrid() {
        daoParcela = new Fin_parcelaDAO();
        DefaultTableModel dados = (DefaultTableModel) grid.getModel();
        dados.setNumRows(0);
        daoParcela.findAll().stream().forEach((t) -> {
            String situacao = "";
            if (t.getPar_valorpago() > 0) {
                situacao = "PAGA";
            } else {
                if (t.getPar_datavencimento().after(new Date(System.currentTimeMillis()).toDate())) {
                    situacao = "ATRASADA";
                } else {
                    situacao = "EM ABERTO";
                }
            }
            dados.addRow(new String[]{
                "" + t.getPar_codigo(),
                "" + t.getAfc_codigo().getCai_codigo().getCai_descricao(),
                "" + t.getRcd_codigo().getPes_codigo().getPes_razaosocial(),
                "" + t.getPar_numerodocumento(),
                new SimpleDateFormat("dd-MM-yy").format(t.getPar_datavencimento()),
                DecimalFormat.getCurrencyInstance().format(t.getPar_valortotal()),
                t.getPar_datapagamento() != null ? new SimpleDateFormat("dd-MM-yy").format(t.getPar_datapagamento()) : null,
                new SimpleDateFormat("dd-MM-yy").format(t.getPar_datacadastro()),
                situacao
            });
        }
        );
        String dataInicio = "01/";
        String dataFim = "01/";
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
    }

    private String returnDateStr(String _data) {
        if (!_data.isEmpty()) {
            String[] ute = _data.split("/");
            return ute[0] + "/" + ute[1] + "/00" + ute[2];
        } else {
            return "";
        }
    }

    private void refreshGridPar() {
        try {
            daoParcela = new Fin_parcelaDAO();
            DefaultTableModel dados = (DefaultTableModel) grid.getModel();
            dados.setNumRows(0);
            Integer _pub_pes = 0;
            Integer _fin_cai = 0;
            String tpp_cod = "";
            pubPessoa = (Pub_pessoa) cboPessoa.getSelectedItem();
            if (pubPessoa != null) {
                _pub_pes = pubPessoa.getPes_codigo();
            }
            finCaixa = (Fin_caixa) cboCaixa.getSelectedItem();
            if (finCaixa != null) {
                _fin_cai = finCaixa.getCai_codigo();
            }
            if (cboTppPessoa.getSelectedIndex() == 0) {
                tpp_cod = "C";
            } else if (cboTppPessoa.getSelectedIndex() == 1) {
                tpp_cod = "L";
            } else if (cboTppPessoa.getSelectedIndex() == 2) {
                tpp_cod = "F";
            } else if (cboTppPessoa.getSelectedIndex() == 3) {
                tpp_cod = "G";
            } else if (cboTppPessoa.getSelectedIndex() == 4) {
                tpp_cod = "T";
            }
            daoParcela.findFiltered(_pub_pes, _fin_cai, returnDateStr(txtInicio.getText()), returnDateStr(txtFim.getText()), checkEfetivadas.isSelected(), tpp_cod).stream().forEach((t) -> {
                String situacao = "";
                if (t.getPar_valorpago() > 0) {
                    situacao = "PAGA";
                } else {
                    if (t.getPar_datavencimento().after(new Date(System.currentTimeMillis()).toDate())) {
                        situacao = "ATRASADA";
                    } else {
                        situacao = "EM ABERTO";
                    }
                }
                if (checkAtrasadas.isSelected()) {
                    if (t.getPar_valorpago() == 0) {
                        if (t.getPar_datavencimento().after(new Date(System.currentTimeMillis()).toDate())) {
                            dados.addRow(new String[]{
                                "" + t.getPar_codigo(),
                                "" + t.getAfc_codigo().getCai_codigo().getCai_descricao(),
                                "" + t.getRcd_codigo().getPes_codigo().getPes_razaosocial(),
                                "" + t.getPar_numerodocumento(),
                                new SimpleDateFormat("dd-MM-yy").format(t.getPar_datavencimento()),
                                DecimalFormat.getCurrencyInstance().format(t.getPar_valortotal()),
                                t.getPar_datapagamento() != null ? new SimpleDateFormat("dd-MM-yy").format(t.getPar_datapagamento()) : null,
                                new SimpleDateFormat("dd-MM-yy").format(t.getPar_datacadastro()),
                                situacao
                            });
                        }
                    }
                } else {
                    dados.addRow(new String[]{
                        "" + t.getPar_codigo(),
                        "" + t.getAfc_codigo().getCai_codigo().getCai_descricao(),
                        "" + t.getRcd_codigo().getPes_codigo().getPes_razaosocial(),
                        "" + t.getPar_numerodocumento(),
                        new SimpleDateFormat("dd-MM-yy").format(t.getPar_datavencimento()),
                        DecimalFormat.getCurrencyInstance().format(t.getPar_valortotal()),
                        t.getPar_datapagamento() != null ? new SimpleDateFormat("dd-MM-yy").format(t.getPar_datapagamento()) : null,
                        new SimpleDateFormat("dd-MM-yy").format(t.getPar_datacadastro()),
                        situacao
                    });
                }
            }
            );
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro e não possível aplicar o filtro!", "Alerta", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void refreshCombo() {
        List<Pub_pessoa> lsTipoContato = daoPessoa.findAllCFG();
        DefaultComboBoxModel cboM = new DefaultComboBoxModel(new Vector(lsTipoContato));
        cboPessoa.setModel(cboM);

        List<Fin_caixa> lsCaixas = daoCaixa.findAll();
        DefaultComboBoxModel cboa = new DefaultComboBoxModel(new Vector(lsCaixas));
        cboCaixa.setModel(cboa);
        reset();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        grid = new javax.swing.JTable();
        checkEfetivadas = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        btnPay = new javax.swing.JButton();
        btnPay1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        txtInicio = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cboPessoa = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        txtFim = new javax.swing.JFormattedTextField();
        cboCaixa = new javax.swing.JComboBox();
        cboTppPessoa = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        checkAtrasadas = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consultas de Parcelas");
        setExtendedState(MAXIMIZED_BOTH);

        grid.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "par_codigo", "Caixa", "Pessoa", "Número Documento", "Data Vencimento", "Valor (R$)", "Data Pagamento", "Data Cadastro", "Situação"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        grid.setName("jTableDados"); // NOI18N
        grid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                gridFocusGained(evt);
            }
        });
        jScrollPane3.setViewportView(grid);
        if (grid.getColumnModel().getColumnCount() > 0) {
            grid.getColumnModel().getColumn(0).setMinWidth(0);
            grid.getColumnModel().getColumn(0).setPreferredWidth(0);
            grid.getColumnModel().getColumn(0).setMaxWidth(0);
        }

        checkEfetivadas.setText("Efetivadas?");
        checkEfetivadas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                checkEfetivadasItemStateChanged(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/filter.png"))); // NOI18N
        jButton1.setText("Filtrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnPay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        btnPay.setText("Liquidar Parcela");
        btnPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPayActionPerformed(evt);
            }
        });

        btnPay1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cancel.png"))); // NOI18N
        btnPay1.setText("Resetar");
        btnPay1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPay1ActionPerformed(evt);
            }
        });

        txtInicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));

        jLabel4.setText("DATA INICIO");

        jLabel2.setText("PESSOA");

        cboPessoa.setToolTipText("");
        cboPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboPessoaActionPerformed(evt);
            }
        });

        jLabel5.setText("DATA FIM");

        txtFim.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));

        cboCaixa.setToolTipText("");
        cboCaixa.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cboCaixaPropertyChange(evt);
            }
        });

        cboTppPessoa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CLIENTE", "COLABORADOR", "FORNECEDOR", "GERAL", "TODOS" }));
        cboTppPessoa.setToolTipText("");
        cboTppPessoa.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cboTppPessoaPropertyChange(evt);
            }
        });

        jLabel1.setText("TIPO DE PESSOA");

        jLabel3.setText("CAIXA");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cboTppPessoa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFim, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 75, Short.MAX_VALUE))
                    .addComponent(cboPessoa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cboTppPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cboCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        checkAtrasadas.setText("Atrasadas?");
        checkAtrasadas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                checkAtrasadasItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnPay, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(checkAtrasadas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(checkEfetivadas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPay1)))
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPay1)
                    .addComponent(jButton1)
                    .addComponent(btnPay)
                    .addComponent(checkEfetivadas)
                    .addComponent(checkAtrasadas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void gridFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_gridFocusGained

    }//GEN-LAST:event_gridFocusGained

    private void cboTppPessoaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cboTppPessoaPropertyChange

    }//GEN-LAST:event_cboTppPessoaPropertyChange

    private void cboPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboPessoaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboPessoaActionPerformed

    private void cboCaixaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cboCaixaPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_cboCaixaPropertyChange

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        refreshGridPar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPayActionPerformed

    }//GEN-LAST:event_btnPayActionPerformed

    private void reset() {
        cboTppPessoa.setSelectedIndex(4);
        cboCaixa.getModel().setSelectedItem(null);
        cboPessoa.getModel().setSelectedItem(null);
        checkEfetivadas.setSelected(false);
        txtInicio.setText("");
        txtFim.setText("");
        refreshGrid();
    }

    private void btnPay1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPay1ActionPerformed
        reset();
    }//GEN-LAST:event_btnPay1ActionPerformed

    private void checkAtrasadasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_checkAtrasadasItemStateChanged
        if (checkAtrasadas.isSelected()) {
            checkEfetivadas.setSelected(false);
        }
    }//GEN-LAST:event_checkAtrasadasItemStateChanged

    private void checkEfetivadasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_checkEfetivadasItemStateChanged
        if (checkEfetivadas.isSelected()) {
            checkAtrasadas.setSelected(false);
        }
    }//GEN-LAST:event_checkEfetivadasItemStateChanged

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
            java.util.logging.Logger.getLogger(frmLParcelas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmLParcelas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmLParcelas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmLParcelas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmLParcelas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPay;
    private javax.swing.JButton btnPay1;
    private javax.swing.JComboBox cboCaixa;
    private javax.swing.JComboBox cboPessoa;
    private javax.swing.JComboBox cboTppPessoa;
    private javax.swing.JCheckBox checkAtrasadas;
    private javax.swing.JCheckBox checkEfetivadas;
    private javax.swing.JTable grid;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JFormattedTextField txtFim;
    private javax.swing.JFormattedTextField txtInicio;
    // End of variables declaration//GEN-END:variables
}
