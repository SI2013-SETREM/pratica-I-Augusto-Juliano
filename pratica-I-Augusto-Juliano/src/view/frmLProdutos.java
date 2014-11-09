/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.Pro_produtoDAO;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Pro_produto;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author juliano
 */
public class frmLProdutos extends javax.swing.JFrame {

    /**
     * Creates new form frmLProdutos
     */
    public frmLProdutos() {
        initComponents();
    }

    private int operation = 0;
    private Pro_produtoDAO daoProdutos = new Pro_produtoDAO();
    private Pro_produto pro_produto = new Pro_produto();
    private int pro_codigo;

    public void filterGrid(String _filtro) {
        DecimalFormat df = new DecimalFormat("#,###.00");
        daoProdutos = new Pro_produtoDAO();
        DefaultTableModel dados = (DefaultTableModel) jTable1.getModel();
        dados.setNumRows(0);
        if (jListFilter.getSelectedIndex() == 0) {
            daoProdutos.findDesc(_filtro).stream().forEach((t) -> {
                dados.addRow(new String[]{
                    "" + t.getPro_codigo(),
                    "" + t.getPro_descricao(),
                    "" + t.getPro_valorcompra(),
                    "" + t.getPro_valorvenda(),
                    "" + df.format(t.getPro_valorvenda() - t.getPro_valorcompra()),
                    "" + t.getMar_codigo().getMar_descricao(),
                    "" + t.getCat_codigo().getCat_descricao(),
                    "" + t.getTpp_codigo().getTpp_descricao(),
                    "" + t.getPro_datacadastro()});
            });
        } else if (jListFilter.getSelectedIndex() == 1) {
            daoProdutos.findValorCompra(_filtro).stream().forEach((t) -> {
                dados.addRow(new String[]{
                    "" + t.getPro_codigo(),
                    "" + t.getPro_descricao(),
                    "" + t.getPro_valorcompra(),
                    "" + t.getPro_valorvenda(),
                    "" + df.format(t.getPro_valorvenda() - t.getPro_valorcompra()),
                    "" + t.getMar_codigo().getMar_descricao(),
                    "" + t.getCat_codigo().getCat_descricao(),
                    "" + t.getTpp_codigo().getTpp_descricao(),
                    "" + t.getPro_datacadastro()});
            });
        } else if (jListFilter.getSelectedIndex() == 2) {
            daoProdutos.findValorVenda(_filtro).stream().forEach((t) -> {
                dados.addRow(new String[]{
                    "" + t.getPro_codigo(),
                    "" + t.getPro_descricao(),
                    "" + t.getPro_valorcompra(),
                    "" + t.getPro_valorvenda(),
                    "" + df.format(t.getPro_valorvenda() - t.getPro_valorcompra()),
                    "" + t.getMar_codigo().getMar_descricao(),
                    "" + t.getCat_codigo().getCat_descricao(),
                    "" + t.getTpp_codigo().getTpp_descricao(),
                    "" + t.getPro_datacadastro()});
            });
        } else if (jListFilter.getSelectedIndex() == 3) {
            daoProdutos.findMarca(_filtro).stream().forEach((t) -> {
                dados.addRow(new String[]{
                    "" + t.getPro_codigo(),
                    "" + t.getPro_descricao(),
                    "" + t.getPro_valorcompra(),
                    "" + t.getPro_valorvenda(),
                    "" + df.format(t.getPro_valorvenda() - t.getPro_valorcompra()),
                    "" + t.getMar_codigo().getMar_descricao(),
                    "" + t.getCat_codigo().getCat_descricao(),
                    "" + t.getTpp_codigo().getTpp_descricao(),
                    "" + t.getPro_datacadastro()});
            });
        } else if (jListFilter.getSelectedIndex() == 4) {
            daoProdutos.findCategoria(_filtro).stream().forEach((t) -> {
                dados.addRow(new String[]{
                    "" + t.getPro_codigo(),
                    "" + t.getPro_descricao(),
                    "" + t.getPro_valorcompra(),
                    "" + t.getPro_valorvenda(),
                    "" + df.format(t.getPro_valorvenda() - t.getPro_valorcompra()),
                    "" + t.getMar_codigo().getMar_descricao(),
                    "" + t.getCat_codigo().getCat_descricao(),
                    "" + t.getTpp_codigo().getTpp_descricao(),
                    "" + t.getPro_datacadastro()});
            });
        } else if (jListFilter.getSelectedIndex() == 5) {
            daoProdutos.findTipoProduto(_filtro).stream().forEach((t) -> {
                dados.addRow(new String[]{
                    "" + t.getPro_codigo(),
                    "" + t.getPro_descricao(),
                    "" + t.getPro_valorcompra(),
                    "" + t.getPro_valorvenda(),
                    "" + df.format(t.getPro_valorvenda() - t.getPro_valorcompra()),
                    "" + t.getMar_codigo().getMar_descricao(),
                    "" + t.getCat_codigo().getCat_descricao(),
                    "" + t.getTpp_codigo().getTpp_descricao(),
                    "" + t.getPro_datacadastro()});
            });
        } else if (jListFilter.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Informe o tipo de filtro a ser feito!", "Alerta", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void refreshGrid() {
        daoProdutos = new Pro_produtoDAO();
        DefaultTableModel dados = (DefaultTableModel) jTable1.getModel();
        dados.setNumRows(0);

        daoProdutos.findAll().stream().forEach((t) -> {
            DecimalFormat df = new DecimalFormat("#,###.00");
            dados.addRow(new String[]{
                "" + t.getPro_codigo(),
                "" + t.getPro_descricao(),
                "" + t.getPro_valorcompra(),
                "" + t.getPro_valorvenda(),
                "" + df.format(t.getPro_valorvenda() - t.getPro_valorcompra()),
                "" + t.getMar_codigo().getMar_descricao(),
                "" + t.getCat_codigo().getCat_descricao(),
                "" + t.getTpp_codigo().getTpp_descricao(),
                "" + t.getPro_datacadastro()});
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        buttonGroup6 = new javax.swing.ButtonGroup();
        panel1 = new java.awt.Panel();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDel = new javax.swing.JButton();
        txtPesquisa = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListFilter = new javax.swing.JList();
        btnPrint = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Listagem de Produtos");
        setExtendedState(MAXIMIZED_BOTH);
        addWindowStateListener(new java.awt.event.WindowStateListener() {
            public void windowStateChanged(java.awt.event.WindowEvent evt) {
                formWindowStateChanged(evt);
            }
        });
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

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

        txtPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesquisaActionPerformed(evt);
            }
        });
        txtPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPesquisaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPesquisaKeyTyped(evt);
            }
        });

        jLabel1.setText("Selecione o Tipo de Filtro");

        jListFilter.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Descrição", "Valor Compra", "Valor Venda", "Marca", "Categoria", "Tipo Produto" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jListFilter);

        btnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/imprimir2.png"))); // NOI18N
        btnPrint.setText("Imprimir");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 270, Short.MAX_VALUE)
                        .addComponent(btnDel, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtPesquisa))
                .addContainerGap())
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdd)
                            .addComponent(btnEdit)
                            .addComponent(btnDel)
                            .addComponent(btnPrint))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "pro_codigo", "Descrição", "Valor Compra", "Valor Venda", "Lucro Unid.", "Marca", "Categoria", "Tipo de Produto", "Cadastrado em"
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
        jTable1.setName("jTableDados"); // NOI18N
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(0);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(0);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(0);
            jTable1.getColumnModel().getColumn(2).setMinWidth(130);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(130);
            jTable1.getColumnModel().getColumn(2).setMaxWidth(130);
            jTable1.getColumnModel().getColumn(3).setMinWidth(130);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(130);
            jTable1.getColumnModel().getColumn(3).setMaxWidth(130);
            jTable1.getColumnModel().getColumn(4).setMinWidth(130);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(130);
            jTable1.getColumnModel().getColumn(4).setMaxWidth(130);
            jTable1.getColumnModel().getColumn(8).setMinWidth(105);
            jTable1.getColumnModel().getColumn(8).setPreferredWidth(105);
            jTable1.getColumnModel().getColumn(8).setMaxWidth(105);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        frmMProdutos frm = new frmMProdutos(0);
        frm.setVisible(true);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        int _linha = jTable1.getSelectedRow();
        if (_linha > -1) {
            int _pro_codigo = Integer.parseInt((String) jTable1.getValueAt(_linha, 0));
            frmMProdutos frm = new frmMProdutos(_pro_codigo);
            frm.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um registro!", "Alerta", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelActionPerformed
        int _linha = jTable1.getSelectedRow();
        if (_linha > -1) {
            Integer operacao = JOptionPane.showConfirmDialog(null, "Deseja Excluir ?", "Excluir", JOptionPane.YES_NO_OPTION);
            if (operacao == JOptionPane.YES_OPTION) {
                int _pro_codigo = Integer.parseInt((String) jTable1.getValueAt(_linha, 0));
                pro_produto = daoProdutos.findById(_pro_codigo);
                daoProdutos.delete(pro_produto);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um registro!", "Alerta", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnDelActionPerformed

    private void txtPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesquisaActionPerformed

    }//GEN-LAST:event_txtPesquisaActionPerformed

    private void txtPesquisaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaKeyPressed
        /*if (txtPesquisa.getText().length() > 0) {
            filterGrid(txtPesquisa.getText().toUpperCase());
        } else {
            refreshGrid();
        }*/
    }//GEN-LAST:event_txtPesquisaKeyPressed

    private void formWindowStateChanged(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowStateChanged

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        jListFilter.setSelectedIndex(0);
        refreshGrid();
    }//GEN-LAST:event_formWindowOpened

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        jListFilter.setSelectedIndex(0);
        refreshGrid();
    }//GEN-LAST:event_formWindowGainedFocus

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        String _filtro = txtPesquisa.getText().toUpperCase();
        List<Pro_produto> lstPro_produto = new ArrayList<Pro_produto>();
        switch (jListFilter.getSelectedIndex()) {
            case 0:
                lstPro_produto = daoProdutos.findDesc(_filtro);
                break;
            case 1:
                lstPro_produto = daoProdutos.findValorCompra(_filtro);
                break;
            case 2:
                lstPro_produto = daoProdutos.findValorVenda(_filtro);
                break;
            case 3:
                lstPro_produto = daoProdutos.findMarca(_filtro);
                break;
            case 4:
                lstPro_produto = daoProdutos.findCategoria(_filtro);
                break;
            case 5:
                lstPro_produto = daoProdutos.findTipoProduto(_filtro);
                break;
            default: {
                JOptionPane.showMessageDialog(null, "Informe o tipo de filtro a ser feito!", "Alerta", JOptionPane.WARNING_MESSAGE);
            }
        }
        
        JRBeanCollectionDataSource dsourse = new JRBeanCollectionDataSource(lstPro_produto);
        Map parametros = new HashMap();

        try {
            JasperPrint jpr = JasperFillManager.fillReport("reports/rptProdutos.jasper", parametros, dsourse);
            JasperViewer.viewReport(jpr, false);

        } catch (JRException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnPrintActionPerformed

    private void txtPesquisaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaKeyTyped
        if (txtPesquisa.getText().length() > 0) {
            filterGrid(txtPesquisa.getText().toUpperCase());
        } else {
            refreshGrid();
        }
    }//GEN-LAST:event_txtPesquisaKeyTyped

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
            java.util.logging.Logger.getLogger(frmLProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmLProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmLProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmLProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmLProdutos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDel;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnPrint;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.ButtonGroup buttonGroup6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList jListFilter;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private java.awt.Panel panel1;
    private javax.swing.JTextField txtPesquisa;
    // End of variables declaration//GEN-END:variables
}
