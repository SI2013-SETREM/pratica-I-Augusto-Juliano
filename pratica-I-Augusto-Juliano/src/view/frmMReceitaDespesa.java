/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.Fin_afcaixaDAO;
import dao.Fin_categoriamovimentacaoDAO;
import dao.Fin_receitadespesaDAO;
import dao.Pub_pessoaDAO;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Fin_afcaixa;
import model.Fin_categoriamovimentacao;
import model.Fin_parcela;
import model.Fin_receitadespesa;
import model.Pub_pessoa;
import org.exolab.castor.types.Date;

/**
 *
 * @author juliano
 */
public class frmMReceitaDespesa extends javax.swing.JFrame {

    private Fin_receitadespesa fin_receitadespesa = new Fin_receitadespesa();
    private Fin_receitadespesaDAO daoReceitaDespesa = new Fin_receitadespesaDAO();
    private Pub_pessoaDAO daoPessoas = new Pub_pessoaDAO();
    private Fin_categoriamovimentacaoDAO daoCategorias = new Fin_categoriamovimentacaoDAO();
    private Fin_afcaixaDAO daoAFCaixa = new Fin_afcaixaDAO();
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
                Fin_parcela par = fin_receitadespesa.getPar_codigo().get(i);
                String pago;
                if (par.getPar_valorpago() > 0) {
                    pago = "SIM";
                } else {
                    pago = "NÃO";
                }
                dados.addRow(new String[]{
                    "" + par.getPar_codigo(),
                    "" + par.getRcd_codigo().getRcd_codigo(),
                    "0",
                    "" + par.getAfc_codigo().getAfc_codigo(),
                    new SimpleDateFormat("MM-dd-yy").format(par.getPar_datavencimento()),
                    "" + par.getPar_valortotal(),
                    "" + par.getPar_numerodocumento(),
                    pago,
                    "SIM".equals(pago) ? new SimpleDateFormat("MM-dd-yy").format(par.getPar_datapagamento()) : null,}
                );
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

    private void refreshValores() {
        try {
            Double valorTotal = 0.00;
            DefaultTableModel dados = (DefaultTableModel) gridParcelas.getModel();
            for (int i = 0; i < dados.getRowCount(); i++) {
                valorTotal += Double.parseDouble(dados.getValueAt(i, 5).toString());
            }
            txtValorLiquido.setText(String.valueOf(valorTotal));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "O recalculo de valores da nota falhou!", "Alerta", JOptionPane.WARNING_MESSAGE);
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
                "par_Codigo", "rcd_codigo", "par_pai", "afc_codigo", "Vencimento", "Valor Total", "Número Documento", "Efetivada", "Data Pagamento", "data cadastro"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        gridParcelas.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        gridParcelas.setColumnSelectionAllowed(true);
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
        gridParcelas.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
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
            gridParcelas.getColumnModel().getColumn(9).setMinWidth(0);
            gridParcelas.getColumnModel().getColumn(9).setPreferredWidth(0);
            gridParcelas.getColumnModel().getColumn(9).setMaxWidth(0);
        }

        javax.swing.GroupLayout panelParcelasLayout = new javax.swing.GroupLayout(panelParcelas);
        panelParcelas.setLayout(panelParcelasLayout);
        panelParcelasLayout.setHorizontalGroup(
            panelParcelasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelParcelasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAddPar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 368, Short.MAX_VALUE)
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
                    .addComponent(btnDelPar)
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

    private Date getDate(String data) {
        String[] lsData = data.split("-");
        Date dataF = new Date();
        dataF.setDay(Short.parseShort(lsData[1]));
        dataF.setMonth(Short.parseShort(lsData[0]));
        dataF.setYear(Short.parseShort(lsData[2]));
        return dataF;
    }

    private void btnAddParActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddParActionPerformed
        Fin_parcela par = new Fin_parcela();
        par.setRcd_codigo(new Fin_receitadespesa());
        frmMParcelaES frm = new frmMParcelaES(this, true, null);
        frm.setVisible(true);
        par = frm._par_codigo;
        DefaultTableModel dados = (DefaultTableModel) gridParcelas.getModel();
        String pago;
        if (par.getPar_valorpago() > 0) {
            pago = "SIM";
        } else {
            pago = "NÃO";
        }
        dados.addRow(new String[]{
            "" + par.getPar_codigo(),
            "" + par.getRcd_codigo().getRcd_codigo(),
            "0",
            "" + par.getAfc_codigo().getAfc_codigo(),
            new SimpleDateFormat("MM-dd-yy").format(par.getPar_datavencimento()),
            "" + par.getPar_valortotal(),
            "" + par.getPar_numerodocumento(),
            pago,
            "SIM".equals(pago) ? new SimpleDateFormat("MM-dd-yy").format(par.getPar_datapagamento()) : null,
            new SimpleDateFormat("MM-dd-yy").format(par.getPar_datacadastro())
        }
        );
        refreshValores();
    }//GEN-LAST:event_btnAddParActionPerformed

    private void btnDelParActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelParActionPerformed
        int _linha = gridParcelas.getSelectedRow();
        if (_linha > -1) {
            try {
                Integer operacao = JOptionPane.showConfirmDialog(null, "Deseja Excluir ?", "Excluir", JOptionPane.YES_NO_OPTION);
                if (operacao == JOptionPane.YES_OPTION) {
                    DefaultTableModel dados = (DefaultTableModel) gridParcelas.getModel();
                    dados.removeRow(_linha);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Desculpe, este registro não pode ser removido!", "Alerta", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um registro!", "Alerta", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnDelParActionPerformed

    private void gridParcelasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gridParcelasMouseClicked

    }//GEN-LAST:event_gridParcelasMouseClicked

    private void gridParcelasPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_gridParcelasPropertyChange

    }//GEN-LAST:event_gridParcelasPropertyChange

    private void gridParcelasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gridParcelasKeyPressed

    }//GEN-LAST:event_gridParcelasKeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            if (formValidation()) {
                if (rcd_codigo == 0) { //inserção
                    fin_receitadespesa = new Fin_receitadespesa();
                    fin_receitadespesa.setCtm_codigo((Fin_categoriamovimentacao) cboCatMovimentacao.getSelectedItem());
                    fin_receitadespesa.setPes_codigo((Pub_pessoa) cboPessoa.getSelectedItem());
                    fin_receitadespesa.setRcd_codigo(0);
                    fin_receitadespesa.setRcd_datacadastro(new Date(System.currentTimeMillis()).toDate());
                    fin_receitadespesa.setRcd_desconto(Double.parseDouble(txtDesconto.getText()));
                    fin_receitadespesa.setRcd_numeronota(txtNumNota.getText());
                    fin_receitadespesa.setRcd_observacao(txtObservacao.getText());
                    fin_receitadespesa.setRcd_fixa(false);
                    fin_receitadespesa.setRcd_valorbruto(Double.parseDouble(txtValorBruto.getText()));
                    fin_receitadespesa.setRcd_valorliquido(Double.parseDouble(txtValorLiquido.getText()));
                    fin_receitadespesa.setPar_codigo(new ArrayList<Fin_parcela>());
                    for (int i = 0; i < gridParcelas.getRowCount(); i++) {
                        Fin_parcela fin_parcela = new Fin_parcela();
                        fin_parcela.setAfc_codigo(daoAFCaixa.findById(Integer.parseInt((String) gridParcelas.getValueAt(i, 3))));
                        fin_parcela.setPar_codigo(Integer.parseInt((String) gridParcelas.getValueAt(i, 0)));
                        fin_parcela.setPar_datacadastro(getDate((String) gridParcelas.getValueAt(i, 9)).toDate());
                        if (!String.valueOf(gridParcelas.getValueAt(i, 8)).isEmpty() && gridParcelas.getValueAt(i, 8) != null ) {
                            fin_parcela.setPar_datapagamento(getDate((String) gridParcelas.getValueAt(i, 8)).toDate());
                            fin_parcela.setPar_valorpago(Double.parseDouble((String) gridParcelas.getValueAt(i, 5)));
                            fin_parcela.setPar_status(true);
                        } else {
                            fin_parcela.setPar_datapagamento(null);
                            fin_parcela.setPar_valorpago(0.00);
                            fin_parcela.setPar_status(false);
                        }
                        fin_parcela.setPar_datavencimento(getDate((String) gridParcelas.getValueAt(i, 4)).toDate());
                        fin_parcela.setPar_numerodocumento((String) gridParcelas.getValueAt(i, 6));
                        fin_parcela.setPar_pai(null);
                        fin_parcela.setPar_valortotal(Double.parseDouble((String) gridParcelas.getValueAt(i, 5)));
                        fin_parcela.setRcd_codigo(fin_receitadespesa);
                        fin_receitadespesa.getPar_codigo().add(fin_parcela);
                    }
                    daoReceitaDespesa.insert(fin_receitadespesa);
                } else { //edição
                    /*pub_estado.setEst_descricao(txtDesc.getText().toUpperCase());
                     pub_estado.setEst_sigla(txtSigla.getText().toUpperCase().substring(0, 2));
                     daoEstados.update(pub_estado);*/
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
            java.util.logging.Logger.getLogger(frmMReceitaDespesa.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMReceitaDespesa.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMReceitaDespesa.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMReceitaDespesa.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
