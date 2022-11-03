package view;

import Relatorios.RelatorioEquipamentoAlugado;
import Relatorios.RelatorioEquipamentoConvenio;
import Relatorios.RelatorioEquipamentoPatrimonio;
import Relatorios.RelatorioFornecedor;
import Relatorios.RelatorioGeral;
import Relatorios.RelatorioStatus;
import Relatorios.RelatorioTipoEquip;
import Relatorios.RelatorioTipoEquipFornecedorEquip;
import Relatorios.RelatorioUnidade;
import controller.CadastroEquipamentoController;
import controller.helper.CadastroEquipamentoHelper;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TelaCadastroEquipamento extends javax.swing.JFrame {

    //criando campo controller
    private final CadastroEquipamentoController controller;
    
    //criando campo helper
    private final CadastroEquipamentoHelper helper;    
    
    public TelaCadastroEquipamento() {
        initComponents();
        
        this.setResizable(false);
        
        //controller esta passando view como parametro
        controller = new CadastroEquipamentoController(this);
        
        //helper esta passando view como parametro
        helper = new CadastroEquipamentoHelper(this);          
        
        //inicia essa tela no centro
        this.setLocationRelativeTo(null);
        
        //chama o metodo iniciar
        this.iniciar();        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonUnidade = new javax.swing.JButton();
        lblColuna = new javax.swing.JLabel();
        txtColuna = new javax.swing.JComboBox();
        txtUnidade = new javax.swing.JComboBox();
        txtEquipamento = new javax.swing.JComboBox<>();
        txtStatus = new javax.swing.JComboBox<>();
        lblUnidade = new javax.swing.JLabel();
        lblTipoEquip = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jButtonTipoEquip = new javax.swing.JButton();
        txtTipoEquip = new javax.swing.JComboBox();
        lblTipo = new javax.swing.JLabel();
        txtTombo = new javax.swing.JTextField();
        lblSerie = new javax.swing.JLabel();
        txtSerie = new javax.swing.JTextField();
        lblCtrldeterc = new javax.swing.JLabel();
        lblFabMod = new javax.swing.JLabel();
        txtModelo = new javax.swing.JTextField();
        txtFornecedor = new javax.swing.JComboBox();
        JButtonFabricante = new javax.swing.JButton();
        txtFabricante = new javax.swing.JComboBox<>();
        lblCampo = new javax.swing.JLabel();
        txtCampo = new javax.swing.JComboBox();
        lblStatus = new javax.swing.JLabel();
        lblEmpresa = new javax.swing.JLabel();
        lblEmpresa1 = new javax.swing.JLabel();
        lblModelo1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtObservacao = new javax.swing.JTextArea();
        JButtonFornecedor = new javax.swing.JButton();
        btnPesquisar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnVoltar1 = new javax.swing.JButton();
        btnPDF = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabelaCadEquip = new javax.swing.JTable();
        lblfundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonUnidade.setBackground(new java.awt.Color(30, 129, 176));
        jButtonUnidade.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jButtonUnidade.setForeground(new java.awt.Color(255, 255, 255));
        jButtonUnidade.setText("+");
        jButtonUnidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUnidadeActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonUnidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 90, 50, 30));

        lblColuna.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblColuna.setForeground(new java.awt.Color(255, 255, 255));
        lblColuna.setText("COLUNA:");
        getContentPane().add(lblColuna, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 290, -1, 30));

        txtColuna.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        txtColuna.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECIONE UMA COLUNA", "UNIDADE", "TIPOEQUIP", "FORNECEDOR", "STATUS", "EQUIPAMENTO", "GERAL" }));
        txtColuna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtColunaActionPerformed(evt);
            }
        });
        getContentPane().add(txtColuna, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 290, 300, 30));

        txtUnidade.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        txtUnidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUnidadeActionPerformed(evt);
            }
        });
        getContentPane().add(txtUnidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 200, 30));

        txtEquipamento.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        txtEquipamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECIONE UM EQUIPAMENTO", "ALUGADO", "PATRIMONIO", "CONVENIO" }));
        getContentPane().add(txtEquipamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 130, 290, 30));

        txtStatus.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        txtStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECIONE UM STATUS", "FUNCIONAL", "MANUTENCAO", "INSERVIVEL" }));
        getContentPane().add(txtStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 90, 280, 30));

        lblUnidade.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblUnidade.setForeground(new java.awt.Color(255, 255, 255));
        lblUnidade.setText("UNIDADE:");
        getContentPane().add(lblUnidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, -1, 30));

        lblTipoEquip.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTipoEquip.setForeground(new java.awt.Color(255, 255, 255));
        lblTipoEquip.setText("TIPOEQUIP:");
        getContentPane().add(lblTipoEquip, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, -1, 30));

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("CADASTRO DE EQUIPAMENTO");
        getContentPane().add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 0, 460, -1));

        lblID.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblID.setForeground(new java.awt.Color(255, 255, 255));
        lblID.setText("ID:");
        getContentPane().add(lblID, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, -1, 30));

        txtId.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        txtId.setEnabled(false);
        getContentPane().add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 100, -1));

        jButtonTipoEquip.setBackground(new java.awt.Color(30, 129, 176));
        jButtonTipoEquip.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jButtonTipoEquip.setForeground(new java.awt.Color(255, 255, 255));
        jButtonTipoEquip.setText("+");
        jButtonTipoEquip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTipoEquipActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonTipoEquip, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 130, 50, 30));

        txtTipoEquip.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        getContentPane().add(txtTipoEquip, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 180, 30));

        lblTipo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTipo.setForeground(new java.awt.Color(255, 255, 255));
        lblTipo.setText("TOMBO:");
        getContentPane().add(lblTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, -1, 30));

        txtTombo.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        getContentPane().add(txtTombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 180, -1));

        lblSerie.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblSerie.setForeground(new java.awt.Color(255, 255, 255));
        lblSerie.setText("SERIE:");
        getContentPane().add(lblSerie, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, -1, 30));

        txtSerie.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        txtSerie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSerieActionPerformed(evt);
            }
        });
        getContentPane().add(txtSerie, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, 180, -1));

        lblCtrldeterc.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblCtrldeterc.setForeground(new java.awt.Color(255, 255, 255));
        lblCtrldeterc.setText("FORNECEDOR:");
        getContentPane().add(lblCtrldeterc, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, -1, 30));

        lblFabMod.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblFabMod.setForeground(new java.awt.Color(255, 255, 255));
        lblFabMod.setText("FABRICANTE:");
        getContentPane().add(lblFabMod, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, -1, 30));

        txtModelo.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        getContentPane().add(txtModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 50, 180, -1));

        txtFornecedor.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        txtFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFornecedorActionPerformed(evt);
            }
        });
        getContentPane().add(txtFornecedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 250, 150, 30));

        JButtonFabricante.setBackground(new java.awt.Color(30, 129, 176));
        JButtonFabricante.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        JButtonFabricante.setForeground(new java.awt.Color(255, 255, 255));
        JButtonFabricante.setText("+");
        JButtonFabricante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButtonFabricanteActionPerformed(evt);
            }
        });
        getContentPane().add(JButtonFabricante, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 290, 50, 30));

        txtFabricante.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        getContentPane().add(txtFabricante, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 290, 160, 30));

        lblCampo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblCampo.setForeground(new java.awt.Color(255, 255, 255));
        lblCampo.setText("CAMPO:");
        getContentPane().add(lblCampo, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 290, 140, 30));

        txtCampo.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        getContentPane().add(txtCampo, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 290, 250, 30));

        lblStatus.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblStatus.setForeground(new java.awt.Color(255, 255, 255));
        lblStatus.setText("STATUS:");
        getContentPane().add(lblStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 90, -1, 30));

        lblEmpresa.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblEmpresa.setForeground(new java.awt.Color(255, 255, 255));
        lblEmpresa.setText("OBSERVAÇÃO:");
        getContentPane().add(lblEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 170, -1, 30));

        lblEmpresa1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblEmpresa1.setForeground(new java.awt.Color(255, 255, 255));
        lblEmpresa1.setText("EQUIPAMENTO:");
        getContentPane().add(lblEmpresa1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 130, -1, 30));

        lblModelo1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblModelo1.setForeground(new java.awt.Color(255, 255, 255));
        lblModelo1.setText("MODELO:");
        getContentPane().add(lblModelo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 50, -1, 30));

        txtObservacao.setColumns(20);
        txtObservacao.setRows(5);
        jScrollPane2.setViewportView(txtObservacao);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 200, 500, 80));

        JButtonFornecedor.setBackground(new java.awt.Color(30, 129, 176));
        JButtonFornecedor.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        JButtonFornecedor.setForeground(new java.awt.Color(255, 255, 255));
        JButtonFornecedor.setText("+");
        JButtonFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButtonFornecedorActionPerformed(evt);
            }
        });
        getContentPane().add(JButtonFornecedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 250, 50, 30));

        btnPesquisar.setBackground(new java.awt.Color(30, 129, 176));
        btnPesquisar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnPesquisar.setForeground(new java.awt.Color(255, 255, 255));
        btnPesquisar.setText("PESQUISAR");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });
        getContentPane().add(btnPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 180, 110, 40));

        btnEditar.setBackground(new java.awt.Color(30, 129, 176));
        btnEditar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(255, 255, 255));
        btnEditar.setText("EDITAR");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 180, 110, 40));

        btnNovo.setBackground(new java.awt.Color(30, 129, 176));
        btnNovo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnNovo.setForeground(new java.awt.Color(255, 255, 255));
        btnNovo.setText("NOVO");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });
        getContentPane().add(btnNovo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 180, 110, 40));

        btnSalvar.setBackground(new java.awt.Color(30, 129, 176));
        btnSalvar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSalvar.setForeground(new java.awt.Color(255, 255, 255));
        btnSalvar.setText("SALVAR");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 240, 110, 40));

        btnVoltar1.setBackground(new java.awt.Color(30, 129, 176));
        btnVoltar1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnVoltar1.setForeground(new java.awt.Color(255, 255, 255));
        btnVoltar1.setText("VOLTAR");
        btnVoltar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltar1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnVoltar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 240, 110, 40));

        btnPDF.setBackground(new java.awt.Color(30, 129, 176));
        btnPDF.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnPDF.setForeground(new java.awt.Color(255, 255, 255));
        btnPDF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/pdficone.png"))); // NOI18N
        btnPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPDFActionPerformed(evt);
            }
        });
        getContentPane().add(btnPDF, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 290, 70, 50));

        btnExcluir.setBackground(new java.awt.Color(30, 129, 176));
        btnExcluir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnExcluir.setForeground(new java.awt.Color(255, 255, 255));
        btnExcluir.setText("EXCLUIR");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(btnExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 240, 110, 40));

        jTabelaCadEquip.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTabelaCadEquip.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "unidade", "tipoequip", "tombo", "serie", "fornecedor", "fabricante", "modelo", "status", "equipamento", "observacao"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTabelaCadEquip.setAutoscrolls(false);
        jTabelaCadEquip.setFocusable(false);
        jTabelaCadEquip.setRequestFocusEnabled(false);
        jTabelaCadEquip.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTabelaCadEquip.getTableHeader().setReorderingAllowed(false);
        jTabelaCadEquip.setUpdateSelectionOnSort(false);
        jTabelaCadEquip.setVerifyInputWhenFocusTarget(false);
        jTabelaCadEquip.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaCadEquipMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTabelaCadEquip);
        if (jTabelaCadEquip.getColumnModel().getColumnCount() > 0) {
            jTabelaCadEquip.getColumnModel().getColumn(0).setResizable(false);
            jTabelaCadEquip.getColumnModel().getColumn(1).setResizable(false);
            jTabelaCadEquip.getColumnModel().getColumn(2).setResizable(false);
            jTabelaCadEquip.getColumnModel().getColumn(3).setResizable(false);
            jTabelaCadEquip.getColumnModel().getColumn(4).setResizable(false);
            jTabelaCadEquip.getColumnModel().getColumn(5).setResizable(false);
            jTabelaCadEquip.getColumnModel().getColumn(6).setResizable(false);
            jTabelaCadEquip.getColumnModel().getColumn(7).setResizable(false);
            jTabelaCadEquip.getColumnModel().getColumn(8).setResizable(false);
            jTabelaCadEquip.getColumnModel().getColumn(9).setResizable(false);
            jTabelaCadEquip.getColumnModel().getColumn(10).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 1250, 310));

        lblfundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/PARTE INTERNA2.png"))); // NOI18N
        getContentPane().add(lblfundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, 650));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed

        if(txtColuna.getSelectedItem().equals("UNIDADE"))
        {
            //Captura valor string selecionado do combbobox
            String unidadenome = txtCampo.getSelectedItem().toString();
            
            //chama este metodo do controller
            controller.selecionarAllEquipPorUnidade(unidadenome);
            
            txtCampo.removeAllItems();
            
        }
        else if(txtColuna.getSelectedItem().equals("TIPOEQUIP"))
        {
            
            //Captura valor string selecionado do combbobox
            String tipoequipamentonome = txtCampo.getSelectedItem().toString();
            
            //chama este metodo do controller
            controller.selecionarAllEquipPorTipoEquipamento(tipoequipamentonome);
            
            txtCampo.removeAllItems();            
            
        } 
        else if(txtColuna.getSelectedItem().equals("FORNECEDOR"))
        {
            
            //Captura valor string selecionado do combbobox
            String fornecedor = txtCampo.getSelectedItem().toString();
            
            //chama este metodo do controller
            controller.selecionarAllEquipPorFornecedor(fornecedor);
            
            txtCampo.removeAllItems();            
            
        }            
        else if(txtColuna.getSelectedItem().equals("STATUS"))
        {
            
            //Captura valor string selecionado do combbobox
            String status = txtCampo.getSelectedItem().toString();
            
            //chama este metodo do controller
            controller.selecionarAllEquipPorStatus(status);
            
            txtCampo.removeAllItems();            
            
        }   
        else if(txtColuna.getSelectedItem().equals("EQUIPAMENTO"))
        {
            
            String alugado = "ALUGADO";
            String patrimonio = "PATRIMONIO";
            String convenio = "CONVENIO";
            
            //adciona os itens para o combobox campo
            txtCampo.addItem(alugado);
            txtCampo.addItem(patrimonio);
            txtCampo.addItem(convenio);
            
            if(txtCampo.getSelectedItem().equals("ALUGADO"))
            {
                
                //Captura valor string selecionado do combbobox
                alugado = txtCampo.getSelectedItem().toString();
                
                //chama este metodo do controller
                controller.selecionarAllEquipPorAlugado(alugado);  
                
                txtCampo.removeAllItems();

            }
            else if(txtCampo.getSelectedItem().equals("PATRIMONIO"))
            {
                
                //Captura valor string selecionado do combbobox
                patrimonio = txtCampo.getSelectedItem().toString();    
                
                //chama este metodo do controller
                controller.selecionarAllEquipPorPatrimonio(patrimonio);
                
                txtCampo.removeAllItems();                
                
            }
            else if(txtCampo.getSelectedItem().equals("CONVENIO"))
            {
                
                //Captura valor string selecionado do combbobox
                convenio = txtCampo.getSelectedItem().toString();   
                
                //chame este metodo do controller
                controller.selecionarAllEquipPorConvenio(convenio);
                
                txtCampo.removeAllItems();                
                
            }    
            
        }   
        else if(txtColuna.getSelectedItem().equals("GERAL"))
        {
            
            //chama este metodo do controller
            controller.selecionarAllEquipamentos();
            
        }         
        
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed

        //controller chama metodo update equipamento
        controller.updateEquipamento();
        
        iniciar();
        
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed

        //ao clickar chama o helper em novo seta todos os campos como true
        helper.desbloquearCampos();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed

        //controller chama metodo salvar Equipamento
        controller.salvarEquipamento();    
        
        iniciar();

    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnVoltar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltar1ActionPerformed
        //tente chamar a tela principal
        try
        {
            

            this.dispose();        
            
            TelaPrincipal telaprincip = new TelaPrincipal();
            telaprincip.setVisible(true);
            
        }
        //se não conseguir pegue a excesão e mostre a mensagem na tela junto com a excesão
        catch(Exception ex)
        {
            
            JOptionPane.showMessageDialog(null, "Error ao chamar a tela principal!" + ex);
            
        }  
        
    }//GEN-LAST:event_btnVoltar1ActionPerformed

    private void jTabelaCadEquipMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaCadEquipMouseClicked
        helper.setModelo();
    }//GEN-LAST:event_jTabelaCadEquipMouseClicked

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed

        //controller chama metodo deletar equipamento
        controller.deletarEquipamento();

        iniciar();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void jButtonUnidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUnidadeActionPerformed
        //Chama tela cadastro unidade 
        this.dispose();
        
        TelaCadastroUnidade telacadunidade = new TelaCadastroUnidade();
        telacadunidade.setVisible(true);  
    }//GEN-LAST:event_jButtonUnidadeActionPerformed

    private void JButtonFabricanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonFabricanteActionPerformed
        //Chama tela cadastro fabricante 
        this.dispose();
        
        TelaCadastroFabricante telacadfabricante = new TelaCadastroFabricante();
        telacadfabricante.setVisible(true);  
    }//GEN-LAST:event_JButtonFabricanteActionPerformed

    private void jButtonTipoEquipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTipoEquipActionPerformed
        //Chama tela cadastro tipoequipamento 
        this.dispose();
        
        TelaCadastroTipoEquipamento telacadtipoequip = new TelaCadastroTipoEquipamento();
        telacadtipoequip.setVisible(true);  
    }//GEN-LAST:event_jButtonTipoEquipActionPerformed

    private void txtSerieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSerieActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSerieActionPerformed

    private void txtUnidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUnidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUnidadeActionPerformed

    private void JButtonFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonFornecedorActionPerformed
        //Chama tela cadastro fornecedor 
        this.dispose();
        
        TelaCadastroFornecedor telacadfornecedor = new TelaCadastroFornecedor();
        telacadfornecedor.setVisible(true);  
    }//GEN-LAST:event_JButtonFornecedorActionPerformed

    private void txtColunaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtColunaActionPerformed

        if(txtColuna.getSelectedItem().equals("UNIDADE"))
        {
            
            //chama este metodo do controller
            controller.atualizaCampoUnidade();    
            
        }
        else if(txtColuna.getSelectedItem().equals("TIPOEQUIP"))
        {
            
            //chama este metodo do controller
            controller.atualizarCampoTipoEquip();
            
        } 
        else if(txtColuna.getSelectedItem().equals("FORNECEDOR"))
        {
            
            //chama este metodo do controller
            controller.atualizaFornecedorPesquisa();
            
        }    
        else if(txtColuna.getSelectedItem().equals("STATUS"))
        {
            
            //chama este metodo do controller
            controller.atualizarCampoStatus();
            
        } 
        else if(txtColuna.getSelectedItem().equals("EQUIPAMENTO"))
        {
            
            txtCampo.removeAllItems();
            
            String alugado = "ALUGADO";
            String patrimonio = "PATRIMONIO";
            String convenio = "CONVENIO";
            
            //adciona os itens para o combobox campo
            txtCampo.addItem(alugado);
            txtCampo.addItem(patrimonio);
            txtCampo.addItem(convenio);
            
            if(txtCampo.getSelectedItem().equals("ALUGADO"))
            {
                
                //Captura valor string selecionado do combbobox
                alugado = txtCampo.getSelectedItem().toString();
                
            }
            else if(txtCampo.getSelectedItem().equals("PATRIMONIO"))
            {
                
                //Captura valor string selecionado do combbobox
                patrimonio = txtCampo.getSelectedItem().toString();                
                
            }
            else if(txtCampo.getSelectedItem().equals("CONVENIO"))
            {
                
                //Captura valor string selecionado do combbobox
                convenio = txtCampo.getSelectedItem().toString();                    
                
            }    
            
        }   
        else if(txtColuna.getSelectedItem().equals("GERAL"))
        {
            //deixa txtCampo vazio
            txtCampo.removeAllItems();  
            
        }       
    }//GEN-LAST:event_txtColunaActionPerformed

    private void btnPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPDFActionPerformed
        
        String tipoequip = txtTipoEquip.getSelectedItem().toString();

        if(!txtTipoEquip.getSelectedItem().equals(tipoequip))
        {
            
            String fornecedor = txtFornecedor.getSelectedItem().toString();
            
            if(!txtFornecedor.getSelectedItem().equals(fornecedor))
            {
                
                
                
                if(txtColuna.getSelectedItem().equals("EQUIPAMENTO"))
                {
                    
                    String alugado = "ALUGADO";
                    String patrimonio = "PATRIMONIO";
                    String convenio = "CONVENIO";
            
                    //adciona os itens para o combobox campo
                    txtCampo.addItem(alugado);
                    txtCampo.addItem(patrimonio);
                    txtCampo.addItem(convenio);
            
                    if(txtCampo.getSelectedItem().equals("ALUGADO"))
                    {
                
                        //Captura valor string selecionado do combbobox
                        alugado = txtCampo.getSelectedItem().toString();
                
                        RelatorioTipoEquipFornecedorEquip rellatipoequipfornecequip = new RelatorioTipoEquipFornecedorEquip();
                        
                        rellatipoequipfornecequip.gerarPDF(tipoequip, fornecedor, alugado);
                
                        txtCampo.removeAllItems();

                    }
                    else if(txtCampo.getSelectedItem().equals("PATRIMONIO"))
                    {
                
                        //Captura valor string selecionado do combbobox
                        patrimonio = txtCampo.getSelectedItem().toString();
                
                        RelatorioTipoEquipFornecedorEquip rellatipoequipfornecequip = new RelatorioTipoEquipFornecedorEquip();
                        
                        rellatipoequipfornecequip.gerarPDF(tipoequip, fornecedor, patrimonio);
                
                        txtCampo.removeAllItems();            
                
                    }
                    else if(txtCampo.getSelectedItem().equals("CONVENIO"))
                    {
                
                        //Captura valor string selecionado do combbobox
                        convenio = txtCampo.getSelectedItem().toString();
                
                        RelatorioTipoEquipFornecedorEquip rellatipoequipfornecequip = new RelatorioTipoEquipFornecedorEquip();
                        
                        rellatipoequipfornecequip.gerarPDF(tipoequip, fornecedor, convenio);
                
                        txtCampo.removeAllItems();                 
                
                    }                        
                }    
            }    
        }            
        
        if(txtColuna.getSelectedItem().equals("UNIDADE"))
        {
            
            String unidadenome = txtCampo.getSelectedItem().toString();
            
            RelatorioUnidade relatoriounidade =new RelatorioUnidade();
            
            //chama o metodo gerarPDF
            relatoriounidade.gerarPDF(unidadenome);
            
        }    

        else if(txtColuna.getSelectedItem().equals("TIPOEQUIP"))
        {
            
            String tipoequipamentonome = txtCampo.getSelectedItem().toString();
            
            RelatorioTipoEquip relattipoequip = new RelatorioTipoEquip();
            
            //chama o metodo gerarPDF
            relattipoequip.gerarPDF(tipoequipamentonome);     
            
        }    
        
        else if(txtColuna.getSelectedItem().equals("FORNECEDOR"))
        {
            
            String fornecedor = txtCampo.getSelectedItem().toString();
            
            RelatorioFornecedor relatfornecedor = new RelatorioFornecedor();
            
            //chama metodo gerarPDF
            relatfornecedor.gerarPDF(fornecedor);
           
            
        }    
        else if(txtColuna.getSelectedItem().equals("STATUS"))
        {
            
            String status = txtCampo.getSelectedItem().toString();
            
            RelatorioStatus relattipoequip = new RelatorioStatus();
            
            //chama o metodo gerarPDF
            relattipoequip.gerarPDF(status);
            
        }   
         else if(txtColuna.getSelectedItem().equals("EQUIPAMENTO"))
        {
            
            String alugado = "ALUGADO";
            String patrimonio = "PATRIMONIO";
            String convenio = "CONVENIO";
            
            //adciona os itens para o combobox campo
            txtCampo.addItem(alugado);
            txtCampo.addItem(patrimonio);
            txtCampo.addItem(convenio);
            
            if(txtCampo.getSelectedItem().equals("ALUGADO"))
            {
                
                //Captura valor string selecionado do combbobox
                alugado = txtCampo.getSelectedItem().toString();
                
                RelatorioEquipamentoAlugado relatalugado = new RelatorioEquipamentoAlugado();
                
                //chama metodo gerarPDF
                relatalugado.gerarPDF(alugado);
                
            }
            else if(txtCampo.getSelectedItem().equals("PATRIMONIO"))
            {
                
                //Captura valor string selecionado do combbobox
                patrimonio = txtCampo.getSelectedItem().toString(); 
                
                RelatorioEquipamentoPatrimonio relatpatri = new RelatorioEquipamentoPatrimonio();
                
                //chama metodo gerarPDF
                relatpatri.gerarPDF(patrimonio);
                
            }
            else if(txtCampo.getSelectedItem().equals("CONVENIO"))
            {
                
                //Captura valor string selecionado do combbobox
                convenio = txtCampo.getSelectedItem().toString();      
                
                RelatorioEquipamentoConvenio relatconvenio  = new RelatorioEquipamentoConvenio();
                
                //chama metodo gerarPDF
                relatconvenio.gerarPDF(convenio);
                
            }     
            
        }   
        else if(txtColuna.getSelectedItem().equals("GERAL"))
        {
            
            RelatorioGeral relatoriogeral = new RelatorioGeral();
        
            //chama o metodo gerarPDF
            relatoriogeral.gerarPDF();            
            
        }         
    }//GEN-LAST:event_btnPDFActionPerformed

    private void txtFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFornecedorActionPerformed
            
    }//GEN-LAST:event_txtFornecedorActionPerformed

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
            java.util.logging.Logger.getLogger(TelaCadastroEquipamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroEquipamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroEquipamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroEquipamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastroEquipamento().setVisible(true);
            }
        });
    }

    //getters e setters campos

    public static JButton getJButtonFabricante() {
        return JButtonFabricante;
    }

    public static void setJButtonFabricante(JButton JButtonFabricante) {
        TelaCadastroEquipamento.JButtonFabricante = JButtonFabricante;
    }

    public static JButton getJButtonFornecedor() {
        return JButtonFornecedor;
    }

    public static void setJButtonFornecedor(JButton JButtonFornecedor) {
        TelaCadastroEquipamento.JButtonFornecedor = JButtonFornecedor;
    }

    public static JButton getjButtonTipoEquip() {
        return jButtonTipoEquip;
    }

    public static void setjButtonTipoEquip(JButton jButtonTipoEquip) {
        TelaCadastroEquipamento.jButtonTipoEquip = jButtonTipoEquip;
    }

    public static JButton getjButtonUnidade() {
        return jButtonUnidade;
    }

    public static void setjButtonUnidade(JButton jButtonUnidade) {
        TelaCadastroEquipamento.jButtonUnidade = jButtonUnidade;
    }
    
    public JComboBox<String> getTxtFornecedor() {
        return txtFornecedor;
    }

    public void getTxtFornecedor(JComboBox<String> txtFornecedor) {
        this.txtFornecedor = txtFornecedor;
    }
    
    public JComboBox<String> getTxtEquipamento()
    {
        
        return txtEquipamento;
        
    }    

    public void setTxtEquipamento(JComboBox<String> txtEquipamento)
    {
        
        this.txtEquipamento = txtEquipamento;
        
    }        

    public JComboBox<String> getTxtFabricante() {
        return txtFabricante;
    }

    public void setTxtFabricante(JComboBox<String> txtFabricante) {
        this.txtFabricante = txtFabricante;
    }

    public JTextField getTxtId() {
        return txtId;
    }

    public void setTxtId(JTextField txtId) {
        this.txtId = txtId;
    }

    public JTextField getTxtModelo() {
        return txtModelo;
    }

    public void setTxtModelo(JTextField txtModelo) {
        this.txtModelo = txtModelo;
    }

    public JTextField getTxtSerie() {
        return txtSerie;
    }

    public void setTxtSerie(JTextField txtSerie) {
        this.txtSerie = txtSerie;
    }
    
    public JComboBox<String> getTxtStatus()
    {
        
        return txtStatus;
        
    }        
    
    public void setTxtStatus(JComboBox<String> txtStatus)
    {
        
        this.txtStatus = txtStatus;
        
    }        
    
    public JComboBox<String> getTxtTipoEquip() {
        return txtTipoEquip;
    }

    public void setTxtTipoEquip(JComboBox<String> txtTipoEquip) {
        this.txtTipoEquip = txtTipoEquip;
    }

    public JTextField getTxtTombo() {
        return txtTombo;
    }

    public void setTxtTombo(JTextField txtTombo) {
        this.txtTombo = txtTombo;
    }

    public JComboBox<String> getTxtUnidade() {
        return txtUnidade;
    }

    public void setTxtUnidade(JComboBox<String> txtUnidade) {
        this.txtUnidade = txtUnidade;
    }

    public JTextArea getTxtObservacao() {
        return txtObservacao;
    }

    public void setTxtObservacao(JTextArea txtObservacao) {
        this.txtObservacao = txtObservacao;
    }

    //getters e setters dos botoes    
    public static JButton getBtnEditar() {
        return btnEditar;
    }

    public static void setBtnEditar(JButton btnEditar) {
        TelaCadastroEquipamento.btnEditar = btnEditar;
    }

    public static JButton getBtnPesquisar() {
        return btnPesquisar;
    }

    public static void setBtnPesquisar(JButton btnPesquisar) {
        TelaCadastroEquipamento.btnPesquisar = btnPesquisar;
    }

    public static JButton getBtnSalvar() {
        return btnSalvar;
    }

    public static void setBtnSalvar(JButton btnSalvar) {
        TelaCadastroEquipamento.btnSalvar = btnSalvar;
    } 
    
    //getters e setters botões
    public static JButton getBtnExcluir() {
        return btnExcluir;
    }

    public static void setBtnExcluir(JButton btnExcluir) {
        TelaCadastroEquipamento.btnExcluir = btnExcluir;
    }

    public static JButton getBtnNovo() {
        return btnNovo;
    }

    public static void setBtnNovo(JButton btnNovo) {
        TelaCadastroEquipamento.btnNovo = btnNovo;
    }

    public static JButton getBtnVoltar1() {
        return btnVoltar1;
    }

    public static void setBtnVoltar1(JButton btnVoltar1) {
        TelaCadastroEquipamento.btnVoltar1 = btnVoltar1;
    }
    
    
    //getters e setters tabela
    public static JTable getjTabelaCadEquip() {
        return jTabelaCadEquip;
    }

    public static void setjTabelaCadEquip(JTable jTabelaCadEquip) {
        TelaCadastroEquipamento.jTabelaCadEquip = jTabelaCadEquip;
    }

    public static JComboBox getTxtColuna() {
        return txtColuna;
    }

    public static void setTxtColuna(JComboBox txtColuna) {
        TelaCadastroEquipamento.txtColuna = txtColuna;
    }    
    
    public static JComboBox getTxtCampo() {
        return txtCampo;
    }

    public static void setTxtCampo(JComboBox txtCampo) {
        TelaCadastroEquipamento.txtCampo = txtCampo;
    }
    
    
    
    public void iniciar()
    {
            //impede o usuario de mover as colunas para reoodena-las
            jTabelaCadEquip.getTableHeader().setReorderingAllowed(false);
            
            //chama este metodo do controller
            controller.atualizaUnidade();
            
            //chava este metodo do controller
            controller.atualizaFornecedor();
            
            //chama este metodo do controller
            controller.atualizarFabricante();
            
            //chama este metodo do controller
            controller.atualizaTipoEquipamento();
            
            //chama este metodo do controller
            controller.tabelaEquipamentos();
       
            jTabelaCadEquip.setRowSelectionAllowed(true);
            
            //impessa o jtable de se auto redimensionar
            jTabelaCadEquip.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            
            
            //as linhas abaixo define o tamanho das colunas da tabela
            //tabela pegue o modelo de coluna, pegue a coluna zero e sete a largura
            jTabelaCadEquip.getColumnModel().getColumn(0).setPreferredWidth(74);
            jTabelaCadEquip.getColumnModel().getColumn(1).setPreferredWidth(155);
            jTabelaCadEquip.getColumnModel().getColumn(2).setPreferredWidth(100);
            jTabelaCadEquip.getColumnModel().getColumn(3).setPreferredWidth(95);
            jTabelaCadEquip.getColumnModel().getColumn(4).setPreferredWidth(95);
            jTabelaCadEquip.getColumnModel().getColumn(5).setPreferredWidth(162);
            jTabelaCadEquip.getColumnModel().getColumn(6).setPreferredWidth(90);
            jTabelaCadEquip.getColumnModel().getColumn(7).setPreferredWidth(90);
            jTabelaCadEquip.getColumnModel().getColumn(8).setPreferredWidth(96);
            jTabelaCadEquip.getColumnModel().getColumn(9).setPreferredWidth(95);
            jTabelaCadEquip.getColumnModel().getColumn(10).setPreferredWidth(175);      
    }      
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton JButtonFabricante;
    public static javax.swing.JButton JButtonFornecedor;
    public static javax.swing.JButton btnEditar;
    public static javax.swing.JButton btnExcluir;
    public static javax.swing.JButton btnNovo;
    public static javax.swing.JButton btnPDF;
    public static javax.swing.JButton btnPesquisar;
    public static javax.swing.JButton btnSalvar;
    public static javax.swing.JButton btnVoltar1;
    public static javax.swing.JButton jButtonTipoEquip;
    public static javax.swing.JButton jButtonUnidade;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTable jTabelaCadEquip;
    private javax.swing.JLabel lblCampo;
    private javax.swing.JLabel lblColuna;
    private javax.swing.JLabel lblCtrldeterc;
    private javax.swing.JLabel lblEmpresa;
    private javax.swing.JLabel lblEmpresa1;
    private javax.swing.JLabel lblFabMod;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblModelo1;
    private javax.swing.JLabel lblSerie;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JLabel lblTipoEquip;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUnidade;
    private javax.swing.JLabel lblfundo;
    public static javax.swing.JComboBox txtCampo;
    public static javax.swing.JComboBox txtColuna;
    public static javax.swing.JComboBox<String> txtEquipamento;
    public static javax.swing.JComboBox<String> txtFabricante;
    public static javax.swing.JComboBox txtFornecedor;
    public static javax.swing.JTextField txtId;
    public static javax.swing.JTextField txtModelo;
    public static javax.swing.JTextArea txtObservacao;
    public static javax.swing.JTextField txtSerie;
    public static javax.swing.JComboBox<String> txtStatus;
    public static javax.swing.JComboBox txtTipoEquip;
    public static javax.swing.JTextField txtTombo;
    public static javax.swing.JComboBox txtUnidade;
    // End of variables declaration//GEN-END:variables

}
