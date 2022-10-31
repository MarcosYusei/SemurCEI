package view;

import controller.TelaLoginController;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class TelaLogin extends javax.swing.JFrame {

    //cria campo controller na view
    private final TelaLoginController controller;
    
    //cria variavel inter
    public static String inter = "";
    
    public TelaLogin() {
        initComponents();
        //inicie frame no meio
        this.setLocationRelativeTo(null);
        
        //controlador passa esta view como parametro
        controller = new TelaLoginController(this);
    }      

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblLogin = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        lblSenha = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        lblCadastre1 = new javax.swing.JLabel();
        lblEsqueci1 = new javax.swing.JLabel();
        btnSair = new javax.swing.JButton();
        btnEntrar = new javax.swing.JButton();
        lblFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login | SemurrCEI");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setName("Login"); // NOI18N
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblLogin.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblLogin.setForeground(new java.awt.Color(255, 255, 255));
        lblLogin.setText("LOGIN:");
        getContentPane().add(lblLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, -1, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("SEMURCEI");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, -1, -1));

        txtLogin.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        txtLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLoginActionPerformed(evt);
            }
        });
        getContentPane().add(txtLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 150, 200, -1));

        lblSenha.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblSenha.setForeground(new java.awt.Color(255, 255, 255));
        lblSenha.setText("SENHA:");
        getContentPane().add(lblSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, -1, 30));

        txtSenha.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        getContentPane().add(txtSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 190, 200, -1));

        lblCadastre1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblCadastre1.setForeground(new java.awt.Color(255, 255, 255));
        lblCadastre1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCadastre1.setText("conectar com o banco de dados");
        lblCadastre1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCadastre1MouseClicked(evt);
            }
        });
        getContentPane().add(lblCadastre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 370, 300, -1));

        lblEsqueci1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblEsqueci1.setForeground(new java.awt.Color(255, 255, 255));
        lblEsqueci1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEsqueci1.setText("esqueci minha senha");
        lblEsqueci1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEsqueci1MouseClicked(evt);
            }
        });
        getContentPane().add(lblEsqueci1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, 300, -1));

        btnSair.setBackground(new java.awt.Color(46, 96, 96));
        btnSair.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSair.setForeground(new java.awt.Color(255, 255, 255));
        btnSair.setText("SAIR");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });
        getContentPane().add(btnSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 230, 90, 30));

        btnEntrar.setBackground(new java.awt.Color(46, 96, 96));
        btnEntrar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnEntrar.setForeground(new java.awt.Color(255, 255, 255));
        btnEntrar.setText("ENTRAR");
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });
        btnEntrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnEntrarKeyPressed(evt);
            }
        });
        getContentPane().add(btnEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 230, 90, 30));

        lblFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/gotasazul.png"))); // NOI18N
        getContentPane().add(lblFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblEsqueci1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEsqueci1MouseClicked
        //Tela esqueci senha
        TelaEsqueciSenha frame = new TelaEsqueciSenha();
        frame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblEsqueci1MouseClicked

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        //Sair do sistema
        System.exit(0);
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed

        //tente entrar
        try {
            
            //controller chama função autenticar
            controller.autenticar();
            this.dispose();
        } catch (SQLException ex) {
            
            
            
        }
        
    }//GEN-LAST:event_btnEntrarActionPerformed

    private void txtLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLoginActionPerformed

    }//GEN-LAST:event_txtLoginActionPerformed

    private void btnEntrarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnEntrarKeyPressed
    if (evt.getKeyCode()==KeyEvent.VK_ENTER){

        //tente entrar
        try {
            
            //controller chama função autenticar
            controller.autenticar();
            this.dispose();
        } catch (SQLException ex) {
            

            
        }
        
    }
    }//GEN-LAST:event_btnEntrarKeyPressed

    private void lblCadastre1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCadastre1MouseClicked
        //Tela conexao
        Conexao frame = new Conexao();
        frame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblCadastre1MouseClicked

    
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
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });
    }

    //getters e setters da view    
    public JTextField getTxtLogin() {
        return txtLogin;
    }       

    public void setTxtLogin(JTextField txtLogin) {
        this.txtLogin = txtLogin;
    }

    public JPasswordField getTxtSenha() {
        return txtSenha;
    }

    public void setTxtSenha(JPasswordField txtSenha) {
        this.txtSenha = txtSenha;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEntrar;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblCadastre1;
    private javax.swing.JLabel lblEsqueci1;
    private javax.swing.JLabel lblFundo;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblSenha;
    public javax.swing.JTextField txtLogin;
    public javax.swing.JPasswordField txtSenha;
    // End of variables declaration//GEN-END:variables
       
    
}
