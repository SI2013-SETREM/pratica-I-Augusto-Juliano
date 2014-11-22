/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.Fin_parcelaDAO;
import dao.Pub_pessoaDAO;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Fin_parcela;
import model.Pub_pessoa;
import org.exolab.castor.types.Date;

/**
 *
 * @author juliano
 */
public class frmLPessoas extends javax.swing.JFrame {

    private Pub_pessoaDAO daoPessoas = new Pub_pessoaDAO();
    private Fin_parcelaDAO daoParcelas = new Fin_parcelaDAO();
    private Pub_pessoa pub_pessoa = new Pub_pessoa();
    private Fin_parcela fin_parcela = new Fin_parcela();
    private JScrollPane jScrollPane4;

    public frmLPessoas() {
        initComponents();
    }

    public void filterPeoples(String _param, Integer _index) {
        daoPessoas = new Pub_pessoaDAO();
        DefaultTableModel dados = (DefaultTableModel) gridPessoas.getModel();
        dados.setNumRows(0);
        daoPessoas.filterParam(_param, _index).stream().forEach((t) -> {
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

    public void refreshIconImage() {
        URL url = this.getClass().getResource("../images/logo.png");
        Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);
        ImageIcon icon = new ImageIcon(imagemTitulo);
        if (gridCReceber.getRowCount() > 0) {
            gridCReceber.setValueAt(icon, 0, 8);
        }
    }

    public void refreshGridCPagar(Integer _pes_codigo) {
        daoParcelas = new Fin_parcelaDAO();
        DefaultTableModel dados = (DefaultTableModel) gridCPagar.getModel();
        dados.setNumRows(0);
        daoParcelas.findCPagarByPes(_pes_codigo).stream().forEach((t) -> {
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
                "" + t.getPar_numerodocumento(),
                new SimpleDateFormat("dd-MM-yy").format(t.getPar_datavencimento()),
                DecimalFormat.getCurrencyInstance().format(t.getPar_valortotal()),
                DecimalFormat.getCurrencyInstance().format(t.getPar_valorpago()),
                t.getPar_datapagamento() != null ? new SimpleDateFormat("dd-MM-yy").format(t.getPar_datapagamento()) : null,
                new SimpleDateFormat("dd-MM-yy").format(t.getPar_datacadastro()),
                situacao});
        });
    }

    public void refreshGridCReceber(Integer _pes_codigo) {
        daoParcelas = new Fin_parcelaDAO();
        DefaultTableModel dados = (DefaultTableModel) gridCReceber.getModel();
        dados.setNumRows(0);
        daoParcelas.findCReceberByPes(_pes_codigo).stream().forEach((t) -> {
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
                "" + t.getPar_numerodocumento(),
                new SimpleDateFormat("dd-MM-yy").format(t.getPar_datavencimento()),
                DecimalFormat.getCurrencyInstance().format(t.getPar_valortotal()),
                DecimalFormat.getCurrencyInstance().format(t.getPar_valorpago()),
                t.getPar_datapagamento() != null ? new SimpleDateFormat("dd-MM-yy").format(t.getPar_datapagamento()) : null,
                new SimpleDateFormat("dd-MM-yy").format(t.getPar_datacadastro()),
                situacao
            });
        }
        );
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        cboTppPessoa = new javax.swing.JComboBox();
        cboTppFilter = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        btnPay = new javax.swing.JButton();
        btnDel1 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        gridCReceber = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        gridCPagar = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtFilter = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        btnDel = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        gridPessoas = new javax.swing.JTable();
        btnEdit = new javax.swing.JButton();

        jLabel4.setText("jLabel4");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Listagem de Pessoas");
        setExtendedState(MAXIMIZED_BOTH);
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

        cboTppPessoa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CLIENTE", "COLABORADOR", "FORNECEDOR", "GERAL", "TODOS" }));
        cboTppPessoa.setToolTipText("");
        cboTppPessoa.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cboTppPessoaPropertyChange(evt);
            }
        });

        cboTppFilter.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "RAZÃO SOCIAL", "NOME FANTASIA", "CNPJ/CPF", "LOGRADOURO", "BAIRRO", "CIDADE" }));
        cboTppFilter.setToolTipText("");
        cboTppFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTppFilterActionPerformed(evt);
            }
        });

        btnPay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        btnPay.setText("Receber");
        btnPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPayActionPerformed(evt);
            }
        });

        btnDel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.png"))); // NOI18N
        btnDel1.setText("Deletar");
        btnDel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDel1ActionPerformed(evt);
            }
        });

        gridCReceber.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "par_codigo", "Caixa", "Número Documento", "Data Vencimento", "Valor Total (R$)", "Valor Pago (R$)", "Data Pagamento", "Data Cadastro", "Situação"
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
        gridCReceber.setName("jTableDados"); // NOI18N
        gridCReceber.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                gridCReceberFocusGained(evt);
            }
        });
        jScrollPane5.setViewportView(gridCReceber);
        if (gridCReceber.getColumnModel().getColumnCount() > 0) {
            gridCReceber.getColumnModel().getColumn(0).setMinWidth(0);
            gridCReceber.getColumnModel().getColumn(0).setPreferredWidth(0);
            gridCReceber.getColumnModel().getColumn(0).setMaxWidth(0);
            gridCReceber.getColumnModel().getColumn(8).setResizable(false);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 944, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Contas a Receber", jPanel2);

        gridCPagar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "par_codigo", "Caixa", "Número Documento", "Data Vencimento", "Valor Total (R$)", "Valor Pago (R$)", "Data Pagamento", "Data Cadastro", "Situação"
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
        gridCPagar.setName("jTableDados"); // NOI18N
        gridCPagar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                gridCPagarFocusGained(evt);
            }
        });
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
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Contas a Pagar", jPanel1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnPay, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDel1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTabbedPane1))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPay)
                    .addComponent(btnDel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1))
        );

        jLabel1.setText("Selecione o tipo de pessoa");

        jLabel2.setText("Selecione o tipo de filtro");

        jLabel3.setText("-->");

        txtFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFilterActionPerformed(evt);
            }
        });
        txtFilter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFilterKeyReleased(evt);
            }
        });

        btnDel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.png"))); // NOI18N
        btnDel.setText("Deletar");
        btnDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelActionPerformed(evt);
            }
        });

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        btnAdd.setText("Adicionar");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/question.png"))); // NOI18N
        jButton1.setPreferredSize(new java.awt.Dimension(22, 22));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

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
        gridPessoas.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        gridPessoas.setName("jTableDados"); // NOI18N
        gridPessoas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gridPessoasMouseClicked(evt);
            }
        });
        gridPessoas.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                gridPessoasPropertyChange(evt);
            }
        });
        gridPessoas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                gridPessoasKeyPressed(evt);
            }
        });
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

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/editar.png"))); // NOI18N
        btnEdit.setText("Editar");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDel, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAdd)
                        .addComponent(btnEdit))
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboTppPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cboTppFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFilter))))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboTppPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboTppFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        refreshGrid("C");
    }//GEN-LAST:event_formWindowOpened

    private void btnPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPayActionPerformed
        int _linha = 0;
        String message = "";
        int _par_codigo = 0;
        if (btnPay.getText() == "Receber") {
            _linha = gridCReceber.getSelectedRow();
            _par_codigo = Integer.parseInt((String) gridCReceber.getValueAt(_linha, 0));
            message = "Deseja Efetuar o Recebimento ?";
        } else {
            _linha = gridCPagar.getSelectedRow();
            _par_codigo = Integer.parseInt((String) gridCPagar.getValueAt(_linha, 0));
            message = "Deseja Efetuar o Pagamento ?";
        }
        if (_linha > -1) {
            Integer operacao = JOptionPane.showConfirmDialog(null, message, "Alerta", JOptionPane.YES_NO_OPTION);
            if (operacao == JOptionPane.YES_OPTION) {
                frmPagamentoParcela frm = new frmPagamentoParcela(this, true, _par_codigo);
                frm.setVisible(true);
                refreshGridCPagar(frm._par_codigo.getRcd_codigo().getPes_codigo().getPes_codigo());
                refreshGridCReceber(frm._par_codigo.getRcd_codigo().getPes_codigo().getPes_codigo());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um registro!", "Alerta", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnPayActionPerformed

    private void btnDel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDel1ActionPerformed
    }//GEN-LAST:event_btnDel1ActionPerformed

    private void gridPessoasPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_gridPessoasPropertyChange
    }//GEN-LAST:event_gridPessoasPropertyChange

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//        JOptionPane.showMessageDialog(null, " Amarelo --> Parcelas Atrasadas \n Preto --> Parcelas em Prazo \n Verde --> Parcelas Pagas", "Informação", JOptionPane.INFORMATION_MESSAGE);
        refreshIconImage();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        frmMPessoas frm = new frmMPessoas(0);
        frm.setVisible(true);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        int _linha = gridPessoas.getSelectedRow();
        if (_linha > -1) {
            int _pes_codigo = Integer.parseInt((String) gridPessoas.getValueAt(_linha, 0));
            frmMPessoas frm = new frmMPessoas(_pes_codigo);
            frm.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um registro!", "Alerta", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelActionPerformed
        int _linha = gridPessoas.getSelectedRow();
        if (_linha > -1) {
            try {
                Integer operacao = JOptionPane.showConfirmDialog(null, "Deseja Excluir ?", "Excluir", JOptionPane.YES_NO_OPTION);
                if (operacao == JOptionPane.YES_OPTION) {
                    int _pes_codigo = Integer.parseInt((String) gridPessoas.getValueAt(_linha, 0));
                    pub_pessoa = daoPessoas.findById(_pes_codigo);
                    daoPessoas.delete(pub_pessoa);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Desculpe, este registro não pode ser removido!", "Alerta", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um registro!", "Alerta", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnDelActionPerformed

    private void cboTppPessoaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cboTppPessoaPropertyChange
        if (cboTppPessoa.getSelectedIndex() == 0) {
            refreshGrid("C");
        } else if (cboTppPessoa.getSelectedIndex() == 1) {
            refreshGrid("L");
        } else if (cboTppPessoa.getSelectedIndex() == 2) {
            refreshGrid("F");
        } else if (cboTppPessoa.getSelectedIndex() == 3) {
            refreshGrid("G");
        } else if (cboTppPessoa.getSelectedIndex() == 4) {
            refreshGrid("T");
        } else {
            DefaultTableModel dados = (DefaultTableModel) gridPessoas.getModel();
            dados.setNumRows(0);
        }
    }//GEN-LAST:event_cboTppPessoaPropertyChange

    private void refreshGridContas() {
        try {
            int _linha = gridPessoas.getSelectedRow();
            if (_linha > -1) {
                int _pes_codigo = Integer.parseInt((String) gridPessoas.getValueAt(_linha, 0));
                refreshGridCPagar(_pes_codigo);
                refreshGridCReceber(_pes_codigo);
            } else {
                DefaultTableModel dadosP = (DefaultTableModel) gridCPagar.getModel();
                dadosP.setNumRows(0);
                DefaultTableModel dadosR = (DefaultTableModel) gridCReceber.getModel();
                dadosR.setNumRows(0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro, parcelas não foram carregadas corretamente!", "Alerta", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void gridPessoasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gridPessoasMouseClicked
        refreshGridContas();
    }//GEN-LAST:event_gridPessoasMouseClicked

    private void gridPessoasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gridPessoasKeyPressed

    }//GEN-LAST:event_gridPessoasKeyPressed

    private void cboTppFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTppFilterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboTppFilterActionPerformed

    private void txtFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFilterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFilterActionPerformed

    private void txtFilterKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFilterKeyReleased
        filterPeoples(txtFilter.getText().toUpperCase(), cboTppFilter.getSelectedIndex());
    }//GEN-LAST:event_txtFilterKeyReleased

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        cboTppPessoa.setSelectedIndex(0);
        refreshGrid("C");
    }//GEN-LAST:event_formWindowGainedFocus

    private void gridCPagarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_gridCPagarFocusGained
        btnPay.setText("Pagar");        // TODO add your handling code here:
    }//GEN-LAST:event_gridCPagarFocusGained

    private void gridCReceberFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_gridCReceberFocusGained
        btnPay.setText("Receber");        // TODO add your handling code here:
    }//GEN-LAST:event_gridCReceberFocusGained

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmLPessoas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmLPessoas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmLPessoas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmLPessoas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JButton btnDel;
    private javax.swing.JButton btnDel1;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnPay;
    private javax.swing.JComboBox cboTppFilter;
    private javax.swing.JComboBox cboTppPessoa;
    private javax.swing.JTable gridCPagar;
    private javax.swing.JTable gridCReceber;
    private javax.swing.JTable gridPessoas;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField txtFilter;
    // End of variables declaration//GEN-END:variables
}
