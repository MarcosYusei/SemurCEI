package view;

import com.toedter.calendar.JDateChooser;
import controller.CadastroLoginController;
import controller.helper.CadastroLoginHelper;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;

public class TelaCadastroLogin extends javax.swing.JFrame {
    
    //criando campo controller
    private final CadastroLoginController controller;
    
    //criando campo helper
    private final CadastroLoginHelper helper;

    public TelaCadastroLogin() {
        initComponents();
        
        this.setLocationRelativeTo(null);
        btnExcluir.setEnabled(true);
        
        //controller esta passando view como parametro
        controller = new CadastroLoginController(this);
        
        //helper esta passando view como parametro
        helper = new CadastroLoginHelper(this);        
        
        //chama o metodo iniciar
        this.iniciar();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnExcluir = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        btnVoltar1 = new javax.swing.JButton();
        btnPesquisar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        jPanelDados = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableLogins = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        lblLogin = new javax.swing.JLabel();
        lblData = new javax.swing.JLabel();
        lblPesquisarNome = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtPesquisarNome = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        lblNome = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        txtTipo = new javax.swing.JComboBox<>();
        lblSenha = new javax.swing.JLabel();
        txtData = new com.toedter.calendar.JDateChooser();
        txtSenha = new javax.swing.JPasswordField();
        lblTipo = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        lblFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnExcluir.setBackground(new java.awt.Color(30, 129, 176));
        btnExcluir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnExcluir.setForeground(new java.awt.Color(255, 255, 255));
        btnExcluir.setText("EXCLUIR");
        btnExcluir.setEnabled(false);
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(btnExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 230, 110, 40));

        btnNovo.setBackground(new java.awt.Color(30, 129, 176));
        btnNovo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnNovo.setForeground(new java.awt.Color(255, 255, 255));
        btnNovo.setText("NOVO");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });
        getContentPane().add(btnNovo, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 170, 110, 40));

        btnVoltar1.setBackground(new java.awt.Color(30, 129, 176));
        btnVoltar1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnVoltar1.setForeground(new java.awt.Color(255, 255, 255));
        btnVoltar1.setText("VOLTAR");
        btnVoltar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltar1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnVoltar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 230, 110, 40));

        btnPesquisar.setBackground(new java.awt.Color(30, 129, 176));
        btnPesquisar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnPesquisar.setForeground(new java.awt.Color(255, 255, 255));
        btnPesquisar.setText("PESQUISAR");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });
        getContentPane().add(btnPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 170, 110, 40));

        btnEditar.setBackground(new java.awt.Color(30, 129, 176));
        btnEditar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(255, 255, 255));
        btnEditar.setText("EDITAR");
        btnEditar.setEnabled(false);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 170, 110, 40));

        btnSalvar.setBackground(new java.awt.Color(30, 129, 176));
        btnSalvar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSalvar.setForeground(new java.awt.Color(255, 255, 255));
        btnSalvar.setText("SALVAR");
        btnSalvar.setEnabled(false);
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 230, 110, 40));

        jPanelDados.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTableLogins.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTableLogins.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Usuario", "Nome", "Senha", "Email", "Tipo", "Data"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableLogins.setAutoscrolls(false);
        jTableLogins.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTableLogins.setFocusable(false);
        jTableLogins.setRequestFocusEnabled(false);
        jTableLogins.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableLogins.getTableHeader().setReorderingAllowed(false);
        jTableLogins.setUpdateSelectionOnSort(false);
        jTableLogins.setVerifyInputWhenFocusTarget(false);
        jTableLogins.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableLoginsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableLogins);
        if (jTableLogins.getColumnModel().getColumnCount() > 0) {
            jTableLogins.getColumnModel().getColumn(0).setResizable(false);
            jTableLogins.getColumnModel().getColumn(1).setResizable(false);
            jTableLogins.getColumnModel().getColumn(2).setResizable(false);
            jTableLogins.getColumnModel().getColumn(3).setResizable(false);
            jTableLogins.getColumnModel().getColumn(4).setResizable(false);
            jTableLogins.getColumnModel().getColumn(5).setResizable(false);
            jTableLogins.getColumnModel().getColumn(6).setResizable(false);
        }

        jPanelDados.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 5, 1050, 250));

        jLabel1.setText("jLabel1");
        jPanelDados.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 140, -1, -1));

        getContentPane().add(jPanelDados, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 1060, 260));

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("CADASTRO DE LOGIN");
        getContentPane().add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, 330, -1));

        lblLogin.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblLogin.setForeground(new java.awt.Color(255, 255, 255));
        lblLogin.setText("LOGIN:");
        getContentPane().add(lblLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, 30));

        lblData.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblData.setForeground(new java.awt.Color(255, 255, 255));
        lblData.setText("DATA:");
        getContentPane().add(lblData, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 90, -1, 30));

        lblPesquisarNome.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblPesquisarNome.setForeground(new java.awt.Color(255, 255, 255));
        lblPesquisarNome.setText("PESQUISAR POR NOME:");
        getContentPane().add(lblPesquisarNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 200, -1, 30));

        lblID.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblID.setForeground(new java.awt.Color(255, 255, 255));
        lblID.setText("ID:");
        getContentPane().add(lblID, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, -1, 30));

        txtID.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        txtID.setEnabled(false);
        getContentPane().add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 100, -1));

        txtPesquisarNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisarNomeKeyReleased(evt);
            }
        });
        getContentPane().add(txtPesquisarNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 240, 320, 30));

        txtNome.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        txtNome.setEnabled(false);
        getContentPane().add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 230, -1));

        lblNome.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblNome.setForeground(new java.awt.Color(255, 255, 255));
        lblNome.setText("NOME:");
        getContentPane().add(lblNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, 30));

        txtLogin.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        txtLogin.setEnabled(false);
        getContentPane().add(txtLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 230, -1));

        txtTipo.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        txtTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione um perfil", "Admin", "Usuario" }));
        txtTipo.setEnabled(false);
        txtTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTipoActionPerformed(evt);
            }
        });
        getContentPane().add(txtTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 240, 230, -1));

        lblSenha.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblSenha.setForeground(new java.awt.Color(255, 255, 255));
        lblSenha.setText("SENHA:");
        getContentPane().add(lblSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, 30));
        getContentPane().add(txtData, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 90, 330, 30));

        txtSenha.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        txtSenha.setEnabled(false);
        getContentPane().add(txtSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 230, -1));

        lblTipo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTipo.setForeground(new java.awt.Color(255, 255, 255));
        lblTipo.setText("TIPO:");
        getContentPane().add(lblTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, 30));

        txtEmail.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        txtEmail.setEnabled(false);
        getContentPane().add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, 230, -1));

        lblEmail.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(255, 255, 255));
        lblEmail.setText("EMAIL:");
        getContentPane().add(lblEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, 30));

        lblFundo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/PARTE INTERNA.png"))); // NOI18N
        getContentPane().add(lblFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed

        controller.deletarUsuario();
        
        iniciar();
        
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed

            //controller chama metodo salvar usuario
            controller.salvarUsuario();
            
            iniciar();
                          
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        
        //ao clickar chama o helper em novo seta todos os campos como true
        helper.desbloquearCampos();
        
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnVoltar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltar1ActionPerformed

        try
        {
            

            this.dispose();    
            
            TelaPrincipal telaprincipal = new TelaPrincipal();
            telaprincipal.setVisible(true);             
            
        }
        catch(Exception ex)
        {
            
            JOptionPane.showMessageDialog(null, "Error ao chamar a tela principal!" + ex);
            
        }    
    }//GEN-LAST:event_btnVoltar1ActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
            
            //controller chama metoto salvar usuario
            controller.updateUsuario();
            
            iniciar();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
            
            controller.selecioneAllLogin();
            
            iniciar();
        
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void txtTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTipoActionPerformed

    }//GEN-LAST:event_txtTipoActionPerformed

    private void txtPesquisarNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisarNomeKeyReleased
     controller.selecioneLoginsporNome();
        
    }//GEN-LAST:event_txtPesquisarNomeKeyReleased

    private void jTableLoginsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableLoginsMouseClicked
        helper.setModelo();
    }//GEN-LAST:event_jTableLoginsMouseClicked

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
            java.util.logging.Logger.getLogger(TelaCadastroLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastroLogin().setVisible(true);
            }
        });
    }

    //getters e setters do campo desta view
    public JLabel getLblID() {
        return lblID;
    }

    public void setLblID(JLabel lblID) {
        this.lblID = lblID;
    }

    public JTextField getTxtID() {
        return txtID;
    }

    public void setTxtID(JTextField txtID) {
        this.txtID = txtID;
    }
    
    
    public JTextField getTxtPesquisarNome() {
        return txtPesquisarNome;
    }

    public void setTxtPesquisarNome(JTextField txtPesquisarNome) {
        this.txtPesquisarNome = txtPesquisarNome;
    }

    public JTextField getTxtEmail() {
        return txtEmail;
    }

    public void setTxtEmail(JTextField txtEmail) {
        this.txtEmail = txtEmail;
    }

    public JTextField getTxtLogin() {
        return txtLogin;
    }

    public void setTxtLogin(JTextField txtLogin) {
        this.txtLogin = txtLogin;
    }

    public JTextField getTxtNome() {
        return txtNome;
    }

    public void setTxtNome(JTextField txtNome) {
        this.txtNome = txtNome;
    }    

    public JPasswordField getTxtSenha() {
        return txtSenha;
    }

    public void setTxtSenha(JPasswordField txtSenha) {
        this.txtSenha = txtSenha;
    }

    public JComboBox<String> getTxtTipo() {
        return txtTipo;
    }

    public void setTxtTipo(JComboBox<String> txtTipo) {
        this.txtTipo = txtTipo;
    }    

    public static JDateChooser getTxtData() {
        return txtData;
    }

    public static void setTxtData(JDateChooser txtData) {
        TelaCadastroLogin.txtData = txtData;
    }  
    
    //getter e setter botoes
    public JButton getBtnSalvar() {
        return btnSalvar;
    }

    public void setBtnSalvar(JButton btnSalvar) {
        this.btnSalvar = btnSalvar;
    }
    
    public JButton getBtnPesquisar() {
        return btnPesquisar;
    }

    public void setBtnPesquisar(JButton btnPesquisar) {
        this.btnPesquisar = btnPesquisar;
    }

    public static JButton getBtnEditar() {
        return btnEditar;
    }

    public static void setBtnEditar(JButton btnEditar) {
        TelaCadastroLogin.btnEditar = btnEditar;
    }    
    
    
    public void iniciar()
    {
            //as linhas abaixo substituem o textfield pela data atual do sistema
            //converter data para string
            Date data = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            
                 
            //impede o usuario de mover as colunas para reoodena-las
            jTableLogins.getTableHeader().setReorderingAllowed(false);
            
            controller.tabelaLogins();
       
            jTableLogins.setRowSelectionAllowed(true);
            
            //impessa o jtable de se auto redimensionar
            jTableLogins.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            
            
            //as linhas abaixo define o tamanho das colunas da tabela
            //tabela pegue o modelo de coluna, pegue a coluna zero e sete a largura
            jTableLogins.getColumnModel().getColumn(0).setPreferredWidth(59);
            jTableLogins.getColumnModel().getColumn(1).setPreferredWidth(94);
            jTableLogins.getColumnModel().getColumn(2).setPreferredWidth(210);
            jTableLogins.getColumnModel().getColumn(3).setPreferredWidth(168);
            jTableLogins.getColumnModel().getColumn(4).setPreferredWidth(206);
            jTableLogins.getColumnModel().getColumn(5).setPreferredWidth(60);
            jTableLogins.getColumnModel().getColumn(6).setPreferredWidth(247);
    }  
    
    //getter e setter da tabela    
    public JTable getjTableLogins() {
        return jTableLogins;
    }

    public void setjTableLogins(JTable jTableLogins) {
        this.jTableLogins = jTableLogins;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnEditar;
    public static javax.swing.JButton btnExcluir;
    public static javax.swing.JButton btnNovo;
    public static javax.swing.JButton btnPesquisar;
    public static javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnVoltar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanelDados;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTableLogins;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblFundo;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblPesquisarNome;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JLabel lblTitulo;
    public static com.toedter.calendar.JDateChooser txtData;
    public javax.swing.JTextField txtEmail;
    public javax.swing.JTextField txtID;
    public javax.swing.JTextField txtLogin;
    public javax.swing.JTextField txtNome;
    public javax.swing.JTextField txtPesquisarNome;
    public javax.swing.JPasswordField txtSenha;
    public javax.swing.JComboBox<String> txtTipo;
    // End of variables declaration//GEN-END:variables

}
