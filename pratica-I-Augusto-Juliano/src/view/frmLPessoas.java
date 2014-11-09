/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.Pub_pessoaDAO;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Pub_pessoa;

/**
 *
 * @author juliano
 */
public class frmLPessoas extends javax.swing.JFrame {

    private Pub_pessoaDAO daoPessoas = new Pub_pessoaDAO();
    private Pub_pessoa pub_pessoa = new Pub_pessoa();
    private JScrollPane jScrollPane4;
    private JTable gridCReceber;

    public frmLPessoas() {
        initComponents();
        gridPessoas.setAutoResizeMode(gridPessoas.AUTO_RESIZE_OFF);
    }

    public void refreshGrid(String _pes_tipo) {
        daoPessoas = new Pub_pessoaDAO();
        DefaultTableModel dados = (DefaultTableModel) gridPessoas.getModel();
        dados.setNumRows(0);
        daoPessoas.findAllByCat(_pes_tipo).stream().forEach((t) -> {
            dados.addRow(new String[]{
                "" + t.getPes_codigo(),
                t.getPes_razaosocial(),
                t.getPes_nomefantasia(),
                t.getPes_cnpjcpf(),
                t.getPes_logradouro(),
                t.getPes_bairro(),
                t.getPes_complemento(),
                t.getCid_codigo().getCid_descricao(),
                t.getCid_codigo().getCid_cep(),
                t.getCid_codigo().getEst_codigo().getEst_sigla(),
                t.getPes_observacoes(),
                "" + t.getPes_datacadastro()
            });
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        panel1 = new java.awt.Panel();
        cboTppPessoa = new javax.swing.JComboBox();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDel = new javax.swing.JButton();
        cboTppFilter = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtFilter = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        gridCPagar = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        gridCPagar1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        gridPessoas = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btnAdd1 = new javax.swing.JButton();
        btnEdit1 = new javax.swing.JButton();
        btnDel1 = new javax.swing.JButton();

        jLabel4.setText("jLabel4");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Listagem de Pessoas");
        setExtendedState(MAXIMIZED_BOTH);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        cboTppPessoa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CLIENTE", "COLABORADOR", "FORNECEDOR", "GERAL", "TODOS" }));
        cboTppPessoa.setToolTipText("");

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        btnAdd.setText("Adicionar");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/editar.png"))); // NOI18N
        btnEdit.setText("Editar");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.png"))); // NOI18N
        btnDel.setText("Deletar");
        btnDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelActionPerformed(evt);
            }
        });

        cboTppFilter.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "RAZÃO SOCIAL", "NOME FANTASIA", "CNPJ/CPF", "LOGRADOURO", "BAIRRO", "CIDADE", "UF", "CEP" }));
        cboTppFilter.setToolTipText("");

        jLabel1.setText("Selecione o tipo de pessoa");

        jLabel2.setText("Selecione o tipo de filtro");

        jLabel3.setText("-->");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/question.png"))); // NOI18N
        jButton1.setPreferredSize(new java.awt.Dimension(22, 22));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(cboTppPessoa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel1))
                .addGap(6, 6, 6)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDel, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(cboTppFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFilter)))
                .addContainerGap())
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboTppPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboTppFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnDel)
                        .addComponent(btnEdit)
                        .addComponent(btnAdd))
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        gridCPagar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "par_codigo", "Caixa", "Número Documento", "Data Vencimento", "Valor Total (R$)", "Valor Pago (R$)", "Data Pagamento", "Data Cadastro"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        gridCPagar.setName("jTableDados"); // NOI18N
        jScrollPane3.setViewportView(gridCPagar);
        if (gridCPagar.getColumnModel().getColumnCount() > 0) {
            gridCPagar.getColumnModel().getColumn(0).setMinWidth(0);
            gridCPagar.getColumnModel().getColumn(0).setPreferredWidth(0);
            gridCPagar.getColumnModel().getColumn(0).setMaxWidth(0);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Contas a Pagar", jPanel1);

        gridCPagar1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "par_codigo", "Caixa", "Número Documento", "Data Vencimento", "Valor Total (R$)", "Valor Pago (R$)", "Data Pagamento", "Data Cadastro"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        gridCPagar1.setName("jTableDados"); // NOI18N
        jScrollPane5.setViewportView(gridCPagar1);
        if (gridCPagar1.getColumnModel().getColumnCount() > 0) {
            gridCPagar1.getColumnModel().getColumn(0).setMinWidth(0);
            gridCPagar1.getColumnModel().getColumn(0).setPreferredWidth(0);
            gridCPagar1.getColumnModel().getColumn(0).setMaxWidth(0);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 955, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Contas a Receber", jPanel2);

        gridPessoas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "pes_codigo", "Razão Social", "Nome Fantasia", "CNPJ/CPF", "Logradouro", "Bairro", "Complemento", "Cidade", "CEP", "Estado", "Observações", "Cadastrado em"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        gridPessoas.setName("jTableDados"); // NOI18N
        jScrollPane2.setViewportView(gridPessoas);
        if (gridPessoas.getColumnModel().getColumnCount() > 0) {
            gridPessoas.getColumnModel().getColumn(0).setMinWidth(0);
            gridPessoas.getColumnModel().getColumn(0).setPreferredWidth(0);
            gridPessoas.getColumnModel().getColumn(0).setMaxWidth(0);
            gridPessoas.getColumnModel().getColumn(1).setMinWidth(250);
            gridPessoas.getColumnModel().getColumn(1).setPreferredWidth(250);
            gridPessoas.getColumnModel().getColumn(1).setMaxWidth(250);
            gridPessoas.getColumnModel().getColumn(2).setMinWidth(230);
            gridPessoas.getColumnModel().getColumn(2).setPreferredWidth(230);
            gridPessoas.getColumnModel().getColumn(2).setMaxWidth(230);
            gridPessoas.getColumnModel().getColumn(3).setMinWidth(150);
            gridPessoas.getColumnModel().getColumn(3).setPreferredWidth(150);
            gridPessoas.getColumnModel().getColumn(3).setMaxWidth(150);
            gridPessoas.getColumnModel().getColumn(4).setMinWidth(220);
            gridPessoas.getColumnModel().getColumn(4).setPreferredWidth(220);
            gridPessoas.getColumnModel().getColumn(4).setMaxWidth(220);
            gridPessoas.getColumnModel().getColumn(5).setMinWidth(200);
            gridPessoas.getColumnModel().getColumn(5).setPreferredWidth(200);
            gridPessoas.getColumnModel().getColumn(5).setMaxWidth(200);
            gridPessoas.getColumnModel().getColumn(6).setMinWidth(200);
            gridPessoas.getColumnModel().getColumn(6).setPreferredWidth(200);
            gridPessoas.getColumnModel().getColumn(6).setMaxWidth(200);
            gridPessoas.getColumnModel().getColumn(7).setPreferredWidth(250);
            gridPessoas.getColumnModel().getColumn(8).setMinWidth(120);
            gridPessoas.getColumnModel().getColumn(8).setPreferredWidth(120);
            gridPessoas.getColumnModel().getColumn(8).setMaxWidth(120);
            gridPessoas.getColumnModel().getColumn(9).setMinWidth(110);
            gridPessoas.getColumnModel().getColumn(9).setPreferredWidth(110);
            gridPessoas.getColumnModel().getColumn(9).setMaxWidth(110);
            gridPessoas.getColumnModel().getColumn(10).setMinWidth(350);
            gridPessoas.getColumnModel().getColumn(10).setPreferredWidth(350);
            gridPessoas.getColumnModel().getColumn(10).setMaxWidth(350);
            gridPessoas.getColumnModel().getColumn(11).setMinWidth(110);
            gridPessoas.getColumnModel().getColumn(11).setPreferredWidth(110);
            gridPessoas.getColumnModel().getColumn(11).setMaxWidth(110);
        }

        btnAdd1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        btnAdd1.setText("Adicionar");
        btnAdd1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd1ActionPerformed(evt);
            }
        });

        btnEdit1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/editar.png"))); // NOI18N
        btnEdit1.setText("Editar");
        btnEdit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEdit1ActionPerformed(evt);
            }
        });

        btnDel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.png"))); // NOI18N
        btnDel1.setText("Deletar");
        btnDel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDel1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAdd1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEdit1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDel1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd1)
                    .addComponent(btnEdit1)
                    .addComponent(btnDel1)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jTabbedPane1)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

    }//GEN-LAST:event_btnAddActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed

    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelActionPerformed

    }//GEN-LAST:event_btnDelActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        refreshGrid("T");
    }//GEN-LAST:event_formWindowOpened

    private void btnAdd1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdd1ActionPerformed

    private void btnEdit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEdit1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEdit1ActionPerformed

    private void btnDel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDel1ActionPerformed

    }//GEN-LAST:event_btnDel1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JOptionPane.showMessageDialog(null, " Amarelo --> Parcelas Atrasadas \n Preto --> Parcelas em Prazo \n Verde --> Parcelas Pagas", "Informação", JOptionPane.INFORMATION_MESSAGE);
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
            java.util.logging.Logger.getLogger(frmLPessoas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmLPessoas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmLPessoas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmLPessoas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmLPessoas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAdd1;
    private javax.swing.JButton btnDel;
    private javax.swing.JButton btnDel1;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnEdit1;
    private javax.swing.JComboBox cboTppFilter;
    private javax.swing.JComboBox cboTppPessoa;
    private javax.swing.JTable gridCPagar;
    private javax.swing.JTable gridCPagar1;
    private javax.swing.JTable gridPessoas;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private java.awt.Panel panel1;
    private javax.swing.JTextField txtFilter;
    // End of variables declaration//GEN-END:variables
}
