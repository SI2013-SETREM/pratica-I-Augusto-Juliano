/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.Fin_categoriamovimentacaoDAO;
import dao.Fin_receitadespesaDAO;
import dao.Pub_pessoaDAO;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Fin_categoriamovimentacao;
import model.Fin_receitadespesa;
import model.Pub_pessoa;

/**
 *
 * @author juliano
 */
public class frmMReceitaDespesa extends javax.swing.JFrame {

    private Fin_receitadespesa fin_receitadespesa = new Fin_receitadespesa();
    private Fin_receitadespesaDAO daoReceitaDespesa = new Fin_receitadespesaDAO();
    private Pub_pessoaDAO daoPessoas = new Pub_pessoaDAO();
    private Fin_categoriamovimentacaoDAO daoCategorias = new Fin_categoriamovimentacaoDAO();
    private int rcd_codigo = 0;

    public frmMReceitaDespesa(Integer _rcd_codigo) {
        rcd_codigo = _rcd_codigo;
        initComponents();
        refreshCombos();
        refreshForm();
        setLocationRelativeTo(null);
    }

    private void refreshCombos() {
        List<Pub_pessoa> lsPessoas = daoPessoas.findAllCFG();
        List<Fin_categoriamovimentacao> lsCategorias = daoCategorias.findAll();
        DefaultComboBoxModel cboP = new DefaultComboBoxModel(new Vector(lsPessoas));
        DefaultComboBoxModel cboC = new DefaultComboBoxModel(new Vector(lsCategorias));
        cboPessoa.setModel(cboP);
        cboCatMovimentacao.setModel(cboC);
    }

    private void refreshForm() {
        if (rcd_codigo > 0) {
            txtNumNota.setText(fin_receitadespesa.getRcd_numeronota());
            txtValorBruto.setText(String.valueOf(fin_receitadespesa.getRcd_valorbruto()));
            txtDesconto.setText(String.valueOf(fin_receitadespesa.getRcd_desconto()));
            txtValorLiquido.setText(String.valueOf(fin_receitadespesa.getRcd_valorliquido()));
            txtObservacao.setText(fin_receitadespesa.getRcd_observacao());
            cboPessoa.getModel().setSelectedItem(fin_receitadespesa.getPes_codigo());
            cboCatMovimentacao.getModel().setSelectedItem(fin_receitadespesa.getCtm_codigo());
            DefaultTableModel dados = (DefaultTableModel) gridParcelas.getModel();
            dados.setNumRows(0);
            for (int i = 0; i < fin_receitadespesa.getPar_codigo().size(); i++) {
                dados.addRow(new String[]{
                    "" + fin_receitadespesa.getPar_codigo().get(i).getPar_codigo(),
                    "" + fin_receitadespesa.getPar_codigo().get(i).getRcd_codigo().getRcd_codigo(),
                    "0",
                    "" + fin_receitadespesa.getPar_codigo().get(i).getAfc_codigo().getAfc_codigo(),
                    "" + fin_receitadespesa.getPar_codigo().get(i).getPar_datavencimento(),
                    "" + fin_receitadespesa.getPar_codigo().get(i).getPar_valortotal(),
                    "" + fin_receitadespesa.getPar_codigo().get(i).getPar_numerodocumento()
                });
            }
        } else {
            cboPessoa.setSelectedItem(null);
            cboCatMovimentacao.setSelectedItem(null);
        }
    }

    private Boolean formValidation() {
        String finalMessage = "Preencha corretamente os campos: \n";
        String message = "";
        if (txtValorBruto.getText().isEmpty()) {
            message += " * Valor Bruto \n";
        } else {
            try {
                Double bruto = Double.parseDouble(txtValorBruto.getText());
            } catch (Exception ex) {
                message += " * Valor Bruto Inválido! \n";
            }
        }
        if (gridParcelas.getRowCount() == 0) {
            message += " * Parcelas \n";
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

        cboCatMovimentacao = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cboPessoa = new javax.swing.JComboBox();
        txtNumNota = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtValorBruto = new javax.swing.JTextField();
        txtDesconto = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtValorLiquido = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtObservacao = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        tabProPar = new javax.swing.JTabbedPane();
        panelParcelas = new javax.swing.JPanel();
        btnAddPar = new javax.swing.JButton();
        btnEditPar = new javax.swing.JButton();
        btnDelPar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        gridParcelas = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Manutenção de Entradas e Saídas");

        cboCatMovimentacao.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboCatMovimentacaoItemStateChanged(evt);
            }
        });
        cboCatMovimentacao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cboCatMovimentacaoKeyPressed(evt);
            }
        });

        jLabel4.setText("CATEGORIA MOV.");

        jLabel5.setText("PESSOA");
        jLabel5.setToolTipText("");

        cboPessoa.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboPessoaItemStateChanged(evt);
            }
        });
        cboPessoa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cboPessoaKeyPressed(evt);
            }
        });

        txtNumNota.setToolTipText("");
        txtNumNota.setName("txtDesc"); // NOI18N
        txtNumNota.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNumNotaFocusLost(evt);
            }
        });
        txtNumNota.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNumNotaKeyPressed(evt);
            }
        });

        jLabel3.setText("Nº NOTA");

        jLabel7.setText("VALOR BRUTO");

        txtValorBruto.setToolTipText("");
        txtValorBruto.setName("txtDesc"); // NOI18N
        txtValorBruto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtValorBrutoFocusLost(evt);
            }
        });
        txtValorBruto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtValorBrutoKeyPressed(evt);
            }
        });

        txtDesconto.setToolTipText("");
        txtDesconto.setName("txtDesc"); // NOI18N
        txtDesconto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDescontoFocusLost(evt);
            }
        });
        txtDesconto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDescontoKeyPressed(evt);
            }
        });

        jLabel8.setText("DESCONTO");

        jLabel9.setText("VALOR LIQ.");

        txtValorLiquido.setToolTipText("");
        txtValorLiquido.setEnabled(false);
        txtValorLiquido.setName("txtDesc"); // NOI18N
        txtValorLiquido.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtValorLiquidoFocusLost(evt);
            }
        });
        txtValorLiquido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtValorLiquidoKeyPressed(evt);
            }
        });

        txtObservacao.setColumns(20);
        txtObservacao.setRows(5);
        jScrollPane1.setViewportView(txtObservacao);

        jLabel6.setText("OBSERVAÇÃO");

        btnAddPar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        btnAddPar.setText("Adicionar");
        btnAddPar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddParActionPerformed(evt);
            }
        });

        btnEditPar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/editar.png"))); // NOI18N
        btnEditPar.setText("Editar");
        btnEditPar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditParActionPerformed(evt);
            }
        });

        btnDelPar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.png"))); // NOI18N
        btnDelPar.setText("Deletar");
        btnDelPar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelParActionPerformed(evt);
            }
        });

        gridParcelas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "par_Codigo", "rcd_codigo", "par_pai", "afc_codigo", "Vencimento", "Valor Total", "Número Documento"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        gridParcelas.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        gridParcelas.setName("jTableDados"); // NOI18N
        gridParcelas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gridParcelasMouseClicked(evt);
            }
        });
        gridParcelas.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                gridParcelasPropertyChange(evt);
            }
        });
        gridParcelas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                gridParcelasKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(gridParcelas);
        if (gridParcelas.getColumnModel().getColumnCount() > 0) {
            gridParcelas.getColumnModel().getColumn(0).setMinWidth(0);
            gridParcelas.getColumnModel().getColumn(0).setPreferredWidth(0);
            gridParcelas.getColumnModel().getColumn(0).setMaxWidth(0);
            gridParcelas.getColumnModel().getColumn(1).setMinWidth(0);
            gridParcelas.getColumnModel().getColumn(1).setPreferredWidth(0);
            gridParcelas.getColumnModel().getColumn(1).setMaxWidth(0);
            gridParcelas.getColumnModel().getColumn(2).setMinWidth(0);
            gridParcelas.getColumnModel().getColumn(2).setPreferredWidth(0);
            gridParcelas.getColumnModel().getColumn(2).setMaxWidth(0);
            gridParcelas.getColumnModel().getColumn(3).setMinWidth(0);
            gridParcelas.getColumnModel().getColumn(3).setPreferredWidth(0);
            gridParcelas.getColumnModel().getColumn(3).setMaxWidth(0);
        }

        javax.swing.GroupLayout panelParcelasLayout = new javax.swing.GroupLayout(panelParcelas);
        panelParcelas.setLayout(panelParcelasLayout);
        panelParcelasLayout.setHorizontalGroup(
            panelParcelasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelParcelasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAddPar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditPar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 261, Short.MAX_VALUE)
                .addComponent(btnDelPar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(panelParcelasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelParcelasLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        panelParcelasLayout.setVerticalGroup(
            panelParcelasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelParcelasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelParcelasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelParcelasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnEditPar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDelPar))
                    .addComponent(btnAddPar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(161, Short.MAX_VALUE))
            .addGroup(panelParcelasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelParcelasLayout.createSequentialGroup()
                    .addContainerGap(42, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        tabProPar.addTab("Parcelas", panelParcelas);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tabProPar)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboPessoa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboCatMovimentacao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNumNota)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtValorBruto, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtValorLiquido, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboCatMovimentacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNumNota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtValorBruto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtValorLiquido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabProPar, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboCatMovimentacaoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboCatMovimentacaoItemStateChanged

    }//GEN-LAST:event_cboCatMovimentacaoItemStateChanged

    private void cboCatMovimentacaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cboCatMovimentacaoKeyPressed

    }//GEN-LAST:event_cboCatMovimentacaoKeyPressed

    private void cboPessoaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboPessoaItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cboPessoaItemStateChanged

    private void cboPessoaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cboPessoaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboPessoaKeyPressed

    private void txtNumNotaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNumNotaFocusLost

    }//GEN-LAST:event_txtNumNotaFocusLost

    private void txtNumNotaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumNotaKeyPressed

    }//GEN-LAST:event_txtNumNotaKeyPressed

    private void txtValorBrutoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtValorBrutoFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorBrutoFocusLost

    private void txtValorBrutoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorBrutoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorBrutoKeyPressed

    private void txtDescontoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDescontoFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescontoFocusLost

    private void txtDescontoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescontoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescontoKeyPressed

    private void txtValorLiquidoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtValorLiquidoFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorLiquidoFocusLost

    private void txtValorLiquidoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorLiquidoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorLiquidoKeyPressed

    private void btnAddParActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddParActionPerformed

    }//GEN-LAST:event_btnAddParActionPerformed

    private void btnEditParActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditParActionPerformed

    }//GEN-LAST:event_btnEditParActionPerformed

    private void btnDelParActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelParActionPerformed

    }//GEN-LAST:event_btnDelParActionPerformed

    private void gridParcelasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gridParcelasMouseClicked

    }//GEN-LAST:event_gridParcelasMouseClicked

    private void gridParcelasPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_gridParcelasPropertyChange

    }//GEN-LAST:event_gridParcelasPropertyChange

    private void gridParcelasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gridParcelasKeyPressed

    }//GEN-LAST:event_gridParcelasKeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
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
            java.util.logging.Logger.getLogger(frmMReceitaDespesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMReceitaDespesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMReceitaDespesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMReceitaDespesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMReceitaDespesa(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddPar;
    private javax.swing.JButton btnDelPar;
    private javax.swing.JButton btnEditPar;
    private javax.swing.JComboBox cboCatMovimentacao;
    private javax.swing.JComboBox cboPessoa;
    private javax.swing.JTable gridParcelas;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panelParcelas;
    private javax.swing.JTabbedPane tabProPar;
    private javax.swing.JTextField txtDesconto;
    private javax.swing.JTextField txtNumNota;
    private javax.swing.JTextArea txtObservacao;
    private javax.swing.JTextField txtValorBruto;
    private javax.swing.JTextField txtValorLiquido;
    // End of variables declaration//GEN-END:variables
}
