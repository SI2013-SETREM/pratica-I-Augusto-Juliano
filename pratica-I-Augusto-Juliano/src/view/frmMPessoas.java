/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.Pub_cidadeDAO;
import dao.Pub_estadoDAO;
import dao.Pub_pessoaDAO;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import model.Pub_cidade;
import model.Pub_estado;
import model.Pub_pessoa;
import model.Pub_pessoacontatos;
import model.Pub_tipocontato;

/**
 *
 * @author juliano
 */
public class frmMPessoas extends javax.swing.JFrame {

    private Pub_cidadeDAO daoCidade = new Pub_cidadeDAO();
    private Pub_pessoaDAO daoPessoa = new Pub_pessoaDAO();
    private Pub_pessoa pub_pessoa = new Pub_pessoa();
    private int pes_codigo = 0;

    public frmMPessoas(Integer _pes_codigo) {
        initComponents();
        refreshCombos();
        setLocationRelativeTo(null);
    }

    private String format(String _formato, Object objeto) {
        MaskFormatter mask;
        try {
            mask = new MaskFormatter(_formato);
            mask.setValueContainsLiteralCharacters(false);
            return mask.valueToString(objeto);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível realizar a conversão!", "Alerta", JOptionPane.WARNING_MESSAGE);
            return null;
        }
    }

    private void refreshCombos() {
        List<Pub_cidade> lsCidades = daoCidade.findAll();
        DefaultComboBoxModel cboC = new DefaultComboBoxModel(new Vector(lsCidades));
        cboCidade.setModel(cboC);
        cboCidade.setSelectedItem(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        txtRazaoSocial = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNomeFantasia = new javax.swing.JTextField();
        lblCNPJCPF = new javax.swing.JLabel();
        txtCNPJCPF = new javax.swing.JTextField();
        cboTipoPessoa = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        cboCategoriaPessoa = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        radInativo = new javax.swing.JRadioButton();
        radAtivo = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        cboCidade = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        txtBairro = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtLogradouro = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        txtComplemento = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        gridContatos = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Manutenção de Pessoas");

        txtRazaoSocial.setToolTipText("");
        txtRazaoSocial.setName("txtRazaoSocial"); // NOI18N
        txtRazaoSocial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtRazaoSocialKeyPressed(evt);
            }
        });

        jLabel1.setText("RAZÃO SOCIAL");

        jLabel2.setText("NOME FANTASIA");

        txtNomeFantasia.setToolTipText("");
        txtNomeFantasia.setName("txtDesc"); // NOI18N
        txtNomeFantasia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNomeFantasiaKeyPressed(evt);
            }
        });

        lblCNPJCPF.setText("CPF");

        txtCNPJCPF.setToolTipText("");
        txtCNPJCPF.setName("txtDesc"); // NOI18N
        txtCNPJCPF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCNPJCPFFocusLost(evt);
            }
        });
        txtCNPJCPF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCNPJCPFKeyPressed(evt);
            }
        });

        cboTipoPessoa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "PESSOA FÍSICA", "PESSOA JURÍDICA" }));
        cboTipoPessoa.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboTipoPessoaItemStateChanged(evt);
            }
        });

        jLabel4.setText("TIPO DE PESSOA");

        cboCategoriaPessoa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CLIENTE", "COLABORADOR", "FORNECEDOR", "GERAL", "TRANSPORTADORA" }));

        jLabel5.setText("CATEGORIA DE PESSOAS");
        jLabel5.setToolTipText("");

        radInativo.setText("INATIVO");
        radInativo.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                radInativoStateChanged(evt);
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

        jLabel7.setText("STATUS");

        cboCidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cboCidadeKeyPressed(evt);
            }
        });

        jLabel8.setText("CIDADE");
        jLabel8.setToolTipText("");

        txtBairro.setToolTipText("");
        txtBairro.setName("txtDesc"); // NOI18N
        txtBairro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBairroKeyPressed(evt);
            }
        });

        jLabel6.setText("BAIRRO");

        jLabel9.setText("LOGRADOURO");

        txtLogradouro.setToolTipText("");
        txtLogradouro.setName("txtDesc"); // NOI18N
        txtLogradouro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtLogradouroKeyPressed(evt);
            }
        });

        jLabel10.setText("NÚMERO");

        txtNumero.setToolTipText("");
        txtNumero.setName("txtDesc"); // NOI18N
        txtNumero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNumeroKeyPressed(evt);
            }
        });

        txtComplemento.setToolTipText("");
        txtComplemento.setName("txtDesc"); // NOI18N
        txtComplemento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtComplementoKeyPressed(evt);
            }
        });

        jLabel11.setText("COMPLEMENTO");

        gridContatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "psc_codigo", "tpc_codigo", "Tipo Contato", "Contato", "tpc_status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        gridContatos.setName("jTableDados"); // NOI18N
        jScrollPane1.setViewportView(gridContatos);
        if (gridContatos.getColumnModel().getColumnCount() > 0) {
            gridContatos.getColumnModel().getColumn(0).setMinWidth(0);
            gridContatos.getColumnModel().getColumn(0).setPreferredWidth(0);
            gridContatos.getColumnModel().getColumn(0).setMaxWidth(0);
            gridContatos.getColumnModel().getColumn(1).setMinWidth(0);
            gridContatos.getColumnModel().getColumn(1).setPreferredWidth(0);
            gridContatos.getColumnModel().getColumn(1).setMaxWidth(0);
            gridContatos.getColumnModel().getColumn(4).setMinWidth(0);
            gridContatos.getColumnModel().getColumn(4).setPreferredWidth(0);
            gridContatos.getColumnModel().getColumn(4).setMaxWidth(0);
        }

        jLabel12.setText("CONTATOS DA PESSOA");

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

        btnAdd.setText("Adicionar");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnEdit.setText("Editar");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDel.setText("Deletar");
        btnDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtComplemento))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 979, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(40, 40, 40)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lblCNPJCPF)
                                            .addComponent(jLabel2)))
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtRazaoSocial)
                                    .addComponent(txtNomeFantasia)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cboCidade, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cboCategoriaPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(radAtivo)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(radInativo)))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(txtBairro)
                                    .addComponent(txtLogradouro)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnDel, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(41, 41, 41)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cboTipoPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtCNPJCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtRazaoSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNomeFantasia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboTipoPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCNPJCPF)
                    .addComponent(txtCNPJCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboCategoriaPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(radAtivo)
                    .addComponent(radInativo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txtComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEdit)
                    .addComponent(btnDel)
                    .addComponent(btnAdd))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addGap(11, 11, 11))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtRazaoSocialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRazaoSocialKeyPressed
        txtRazaoSocial.setText(txtRazaoSocial.getText().toUpperCase());
    }//GEN-LAST:event_txtRazaoSocialKeyPressed

    private void txtNomeFantasiaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeFantasiaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeFantasiaKeyPressed

    private void txtCNPJCPFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCNPJCPFKeyPressed

    }//GEN-LAST:event_txtCNPJCPFKeyPressed

    private void radInativoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_radInativoStateChanged
        if (radInativo.isSelected()) {
            radAtivo.setSelected(false);
        }
    }//GEN-LAST:event_radInativoStateChanged

    private void radAtivoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_radAtivoStateChanged
        if (radAtivo.isSelected()) {
            radInativo.setSelected(false);
        }
    }//GEN-LAST:event_radAtivoStateChanged

    private void radAtivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radAtivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radAtivoActionPerformed

    private void txtBairroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBairroKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBairroKeyPressed

    private void txtLogradouroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLogradouroKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLogradouroKeyPressed

    private void txtNumeroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumeroKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroKeyPressed

    private void txtComplementoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtComplementoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtComplementoKeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            if (formValidation()) {
                if (pes_codigo == 0) { //inserção
                    pub_pessoa = new Pub_pessoa();
                    pub_pessoa.setPes_razaosocial(txtRazaoSocial.getText().toUpperCase());
                    pub_pessoa.setPes_nomefantasia(txtNomeFantasia.getText().toUpperCase());
                    pub_pessoa.setPes_tipopessoa(cboTipoPessoa.getSelectedItem().toString().substring(0, 1).toUpperCase());
                    pub_pessoa.setPes_cnpjcpf(txtCNPJCPF.getText().toUpperCase());
                    pub_pessoa.setPes_tipo(cboCategoriaPessoa.getSelectedItem().toString().substring(0, 1).toUpperCase());
                    if (radAtivo.isSelected()) {
                        pub_pessoa.setPes_status(true);
                    } else {
                        pub_pessoa.setPes_status(false);
                    }
                    pub_pessoa.setCid_codigo((Pub_cidade) cboCidade.getSelectedItem());
                    pub_pessoa.setPes_bairro(txtBairro.getText().toUpperCase());
                    pub_pessoa.setPes_logradouro(txtLogradouro.getText().toUpperCase());
                    pub_pessoa.setPes_numero(Integer.parseInt(txtNumero.getText()));
                    pub_pessoa.setPes_complemento(txtComplemento.getText().toUpperCase());

                    pub_pessoa.setPsc_codigo(new ArrayList<Pub_pessoacontatos>());
                    for (int i = 0; i < gridContatos.getRowCount(); i++) {
                        Pub_pessoacontatos pub_pessoacontatos = new Pub_pessoacontatos();
                        Pub_tipocontato pub_tipocontato = new Pub_tipocontato();

                        pub_tipocontato.setTpc_codigo(Integer.parseInt(gridContatos.getValueAt(i, 1).toString()));
                        pub_pessoacontatos.setTpc_codigo(pub_tipocontato);
                        pub_pessoacontatos.setPsc_contato("" + gridContatos.getValueAt(i, 3));
                        pub_pessoacontatos.setPsc_codigo(Integer.parseInt(gridContatos.getValueAt(i, 0).toString()));
                        pub_pessoacontatos.setPes_codigo(pub_pessoa);

                        pub_pessoa.getPsc_codigo().add(pub_pessoacontatos);
                    }


                    daoPessoa.insert(pub_pessoa);
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

    private void cboTipoPessoaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboTipoPessoaItemStateChanged
        txtCNPJCPF.setText("");
        if (cboTipoPessoa.getSelectedIndex() == 0) {
            lblCNPJCPF.setText("CPF");
        } else {
            lblCNPJCPF.setText("CNPJ");
        }
    }//GEN-LAST:event_cboTipoPessoaItemStateChanged

    private void txtCNPJCPFFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCNPJCPFFocusLost
        if (!txtCNPJCPF.getText().isEmpty()) {
            if (txtCNPJCPF.getText().length() == 11 && cboTipoPessoa.getSelectedIndex() == 0) {
                txtCNPJCPF.setText(format("###.###.###-##", txtCNPJCPF.getText()));
            } else if (txtCNPJCPF.getText().length() == 14 && cboTipoPessoa.getSelectedIndex() == 1) {
                txtCNPJCPF.setText(format("##.###.###/####-##", txtCNPJCPF.getText()));
            } else {
                JOptionPane.showMessageDialog(null, "CPF/CNPJ informado é inválido!", "Alerta", JOptionPane.WARNING_MESSAGE);
                txtCNPJCPF.setText("");
                txtCNPJCPF.requestFocus();
            }
        }
    }//GEN-LAST:event_txtCNPJCPFFocusLost

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        frmMPessoaContatos frm = new frmMPessoaContatos(this, true, null);
        frm.setVisible(true);
        Pub_pessoacontatos psc_codigo = frm._psc_codigo;

        DefaultTableModel dados = (DefaultTableModel) gridContatos.getModel();
        dados.addRow(new String[]{
            "" + psc_codigo.getPsc_codigo(),
            "" + psc_codigo.getTpc_codigo().getTpc_codigo(),
            "" + psc_codigo.getTpc_codigo().getTpc_descricao(),
            "" + psc_codigo.getPsc_contato(),
            "" + psc_codigo.getTpc_codigo().getTpc_status()});
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        int _linha = gridContatos.getSelectedRow();
        if (_linha > -1) {
            int _psc_codigo = Integer.parseInt((String) gridContatos.getValueAt(_linha, 0));
            Pub_pessoacontatos psc_contato = new Pub_pessoacontatos();
            psc_contato.setPsc_contato((String) gridContatos.getValueAt(_linha, 3));
            Pub_tipocontato _tpp_codigo = new Pub_tipocontato();
            _tpp_codigo.setTpc_codigo(Integer.parseInt((String) gridContatos.getValueAt(_linha, 1)));
            _tpp_codigo.setTpc_descricao((String) gridContatos.getValueAt(_linha, 2));
            _tpp_codigo.setTpc_status(true);
            psc_contato.setTpc_codigo(_tpp_codigo);
            frmMPessoaContatos frm = new frmMPessoaContatos(this, true, psc_contato);
            frm.setVisible(true);
            DefaultTableModel dados = (DefaultTableModel) gridContatos.getModel();
            dados.removeRow(_linha);
            Pub_pessoacontatos psc_codigo = frm._psc_codigo;
            dados.addRow(new String[]{
                "" + psc_codigo.getPsc_codigo(),
                "" + psc_codigo.getTpc_codigo().getTpc_codigo(),
                "" + psc_codigo.getTpc_codigo().getTpc_descricao(),
                "" + psc_codigo.getPsc_contato(),
                "" + psc_codigo.getTpc_codigo().getTpc_status()});
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um registro!", "Alerta", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelActionPerformed
        int _linha = gridContatos.getSelectedRow();
        if (_linha > -1) {
            Integer operacao = JOptionPane.showConfirmDialog(null, "Deseja Excluir ?", "Excluir", JOptionPane.YES_NO_OPTION);
            if (operacao == JOptionPane.YES_OPTION) {
                ((DefaultTableModel) gridContatos.getModel()).removeRow(_linha);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um registro!", "Alerta", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnDelActionPerformed

    private void cboCidadeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cboCidadeKeyPressed
         if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            cboCidade.setSelectedItem(null);
        }
    }//GEN-LAST:event_cboCidadeKeyPressed

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
            java.util.logging.Logger.getLogger(frmMPessoas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMPessoas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMPessoas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMPessoas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMPessoas(null).setVisible(true);
            }
        });
    }

    private Boolean formValidation() {
        String finalMessage = "Preencha corretamente os campos obrigatórios: \n";
        String message = "";
        if (txtRazaoSocial.getText().isEmpty()) {
            message += " * Razão Social \n";
        }
        if (message != "") {
            finalMessage += message;
            JOptionPane.showMessageDialog(null, finalMessage, "Alerta", JOptionPane.WARNING_MESSAGE);
            return false;
        } else {
            return true;
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDel;
    private javax.swing.JButton btnEdit;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JComboBox cboCategoriaPessoa;
    private javax.swing.JComboBox cboCidade;
    private javax.swing.JComboBox cboTipoPessoa;
    private javax.swing.JTable gridContatos;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCNPJCPF;
    private javax.swing.JRadioButton radAtivo;
    private javax.swing.JRadioButton radInativo;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JTextField txtCNPJCPF;
    private javax.swing.JTextField txtComplemento;
    private javax.swing.JTextField txtLogradouro;
    private javax.swing.JTextField txtNomeFantasia;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtRazaoSocial;
    // End of variables declaration//GEN-END:variables
}
