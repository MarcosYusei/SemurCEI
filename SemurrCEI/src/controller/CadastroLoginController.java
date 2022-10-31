package controller;

import controller.helper.CadastroLoginHelper;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.DAO.LoginDAO;
import model.Login;
import view.TelaCadastroLogin;
import view.TelaLogin;
import view.TelaPrincipal;

public class CadastroLoginController 
{
    //cria arraylist do tipo login chamado logins   
    ArrayList<Login> logins = new ArrayList<Login>();
    
       //cria variavel tipo telacadastrologin e cadastrologinhelper e chamando-as de view e helper
       private TelaCadastroLogin view;
       private CadastroLoginHelper helper;
       
       //cria variavel tipo login chamada tela login
       public TelaLogin TelaLogin;
       
       //cria variavel tipo TelaPrincipal chamada telaprincipal
       public TelaPrincipal TelaPrincipal;
       
    //metodo construtor    
    public CadastroLoginController(TelaCadastroLogin view) {
        this.view = view;
        this.helper = new CadastroLoginHelper(view);
    }
     
    //metodo construtor para tela login
    public CadastroLoginController(TelaLogin telalogin)
    {
        
        this.TelaLogin = telalogin;
        
    }      

    //metodo construtor tela principal
    public CadastroLoginController(TelaPrincipal viewprincipal) {
        this.TelaPrincipal  = viewprincipal;
    }
    
    //metodo salvar usuario
    public void salvarUsuario()
    {
        
        //comparações logicas
        if(view.getTxtLogin().getText().trim().isEmpty() && view.getTxtNome().getText().trim().isEmpty() && view.getTxtSenha().getText().trim().isEmpty()
        && view.getTxtEmail().getText().trim().isEmpty() && view.getTxtData().getDate() == null)
        {

            JOptionPane.showMessageDialog(null, "Campos vazios, preencha-os!!","ATENÇÃO", JOptionPane.WARNING_MESSAGE);

        }
        else if(view.getTxtLogin().getText().trim().isEmpty())
        {

            JOptionPane.showMessageDialog(null, "Campo login vazio preencha-o!","ATENÇÃO", JOptionPane.WARNING_MESSAGE);

        }
        else if(view.getTxtNome().getText().trim().isEmpty())
        {

            JOptionPane.showMessageDialog(null, "Campo nome esta vazio preencha-o!","ATENÇÃO", JOptionPane.WARNING_MESSAGE);

        } 
        else if(view.getTxtSenha().getText().trim().isEmpty())
        {
            
            JOptionPane.showMessageDialog(null, "Campo senha esta vazio preencha-o!","ATENÇÃO", JOptionPane.WARNING_MESSAGE);            
            
        }    
        else if(view.getTxtEmail().getText().trim().isEmpty())
        {
            
            JOptionPane.showMessageDialog(null, "Campo email esta vazio preencha-o!","ATENÇÃO", JOptionPane.WARNING_MESSAGE);            
            
        }          
        else if(view.getTxtData().getDate() == null)
        {
            
            JOptionPane.showMessageDialog(null, "Campo data esta vazio preencha-o!","ATENÇÃO", JOptionPane.WARNING_MESSAGE);            
            
        }                
        
        
            //pega um usuario da view
            Login login = helper.obterModeloSemID();
        
        try {
            //cria objeto do tipo connection conexao passando novo Conexao(conexao.java) chamando metodo conectar
            Connection conexao = new Conexao().Conectar();
            //cria objeto do tipo LoginDAO chamado loginDAO passando novo LoginDAO recebendo conexao
            LoginDAO loginDAO = new LoginDAO(conexao);
            //objeto loginDAO chama metodo inserir e passa login como parametro para inserir
            loginDAO.inserir(login);         
            
            //helper chama o metodo bloquear campos
            helper.bloquearCampos();            
            
            //helper chama metodo limpar tela(Campos)
            helper.limparTela();    
            
            //chama tabela logins;
            tabelaLogins();               
            
            JOptionPane.showMessageDialog(null, "Login inserido com sucesso!");
            
          //pegue exceção sql  
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Error ao inserir login no banco de dados! /nError:"+ex);
        
        }
                             
    }
    
    //metodo atualizar
    public void updateUsuario()
    {
        
        //comparações logicas
        if(view.getTxtLogin().getText().trim().isEmpty() && view.getTxtNome().getText().trim().isEmpty() && view.getTxtSenha().getText().trim().isEmpty()
        && view.getTxtEmail().getText().trim().isEmpty() && view.getTxtData().getDate() == null)
        {

            JOptionPane.showMessageDialog(null, "Campos vazios, preencha-os!!","ATENÇÃO", JOptionPane.WARNING_MESSAGE);

        }
        else if(view.getTxtLogin().getText().trim().isEmpty())
        {

            JOptionPane.showMessageDialog(null, "Campo login vazio preencha-o!","ATENÇÃO", JOptionPane.WARNING_MESSAGE);

        }
        else if(view.getTxtNome().getText().trim().isEmpty())
        {

            JOptionPane.showMessageDialog(null, "Campo nome esta vazio preencha-o!","ATENÇÃO", JOptionPane.WARNING_MESSAGE);

        } 
        else if(view.getTxtSenha().getText().trim().isEmpty())
        {
            
            JOptionPane.showMessageDialog(null, "Campo senha esta vazio preencha-o!","ATENÇÃO", JOptionPane.WARNING_MESSAGE);            
            
        }    
        else if(view.getTxtEmail().getText().trim().isEmpty())
        {
            
            JOptionPane.showMessageDialog(null, "Campo email esta vazio preencha-o!","ATENÇÃO", JOptionPane.WARNING_MESSAGE);            
            
        }          
        else if(view.getTxtData().getDate() == null)
        {
            
            JOptionPane.showMessageDialog(null, "Campo data esta vazio preencha-o!","ATENÇÃO", JOptionPane.WARNING_MESSAGE);            
            
        }                
        if(view.getTxtLogin().getText() != null && view.getTxtNome().getText() != null && view.getTxtSenha().getText() != null
        && view.getTxtEmail().getText() != null  && view.getTxtData().getDate() != null)
        {
            
            //pega um usuario da view
            Login login = new Login();
            
            //chama helper metodo obtermodelo passando login como parametro
            login = helper.obterModelo();
        
         
        try {
            //cria objeto do tipo connection conexao passando novo Conexao(conexao.java) chamando metodo conectar
            Connection conexao = new Conexao().Conectar();
            //cria objeto do tipo LoginDAO chamado loginDAO passando novo LoginDAO recebendo conexao
            LoginDAO loginDAO = new LoginDAO(conexao);
            //objeto loginDAO chama metodo atualizar e passa login como parametro para atualizar
            loginDAO.atualizar(login);
            
            //helper chama o metodo bloquear campos
            helper.bloquearCampos();            
            
            //helper chama metodo limpar tela(Campos)
            helper.limparTela();    
            
            //chama tabela logins;
            tabelaLogins();            
            
            JOptionPane.showMessageDialog(null, "Login atualizado com sucesso!");
            
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Error ao atualizar login no banco de dados! /nError:"+ex);
        
        }            
            
        }    
        
                             
    }    
           
    //fazer validação de campo para deletar o usuario informado
    public void deletarUsuario()
    {
        
        //comparações logicas
        if(view.getTxtLogin().getText().trim().isEmpty() && view.getTxtNome().getText().trim().isEmpty() && view.getTxtSenha().getText().trim().isEmpty()
        && view.getTxtEmail().getText().trim().isEmpty() && view.getTxtData().getDate() == null)
        {

            JOptionPane.showMessageDialog(null, "Campos vazios, preencha-os!!","ATENÇÃO", JOptionPane.WARNING_MESSAGE);

        }
        else if(view.getTxtLogin().getText().trim().isEmpty())
        {

            JOptionPane.showMessageDialog(null, "Campo login vazio preencha-o!","ATENÇÃO", JOptionPane.WARNING_MESSAGE);

        }
        else if(view.getTxtNome().getText().trim().isEmpty())
        {

            JOptionPane.showMessageDialog(null, "Campo nome esta vazio preencha-o!","ATENÇÃO", JOptionPane.WARNING_MESSAGE);

        } 
        else if(view.getTxtSenha().getText().trim().isEmpty())
        {
            
            JOptionPane.showMessageDialog(null, "Campo senha esta vazio preencha-o!","ATENÇÃO", JOptionPane.WARNING_MESSAGE);            
            
        }    
        else if(view.getTxtEmail().getText().trim().isEmpty())
        {
            
            JOptionPane.showMessageDialog(null, "Campo email esta vazio preencha-o!","ATENÇÃO", JOptionPane.WARNING_MESSAGE);            
            
        }          
        else if(view.getTxtData().getDate() == null)
        {
            
            JOptionPane.showMessageDialog(null, "Campo data esta vazio preencha-o!","ATENÇÃO", JOptionPane.WARNING_MESSAGE);            
            
        }                
        if(view.getTxtLogin().getText() != null && view.getTxtNome().getText() != null && view.getTxtSenha().getText() != null
        && view.getTxtEmail().getText() != null  && view.getTxtData().getDate() != null)
        {
            
            //pega um usuario da view
            Login login = new Login();
            
            //chama helper metodo obtermodelo passando login como parametro
            login = helper.obterModelo();
        
         
        try {
            //cria objeto do tipo connection conexao passando novo Conexao(conexao.java) chamando metodo conectar
            Connection conexao = new Conexao().Conectar();
            //cria objeto do tipo LoginDAO chamado loginDAO passando novo LoginDAO recebendo conexao
            LoginDAO loginDAO = new LoginDAO(conexao);
            //objeto loginDAO chama metodo deletar e passa login como parametro para deletar
            loginDAO.deletar(login);
            
            //helper chama o metodo bloquear campos
            helper.bloquearCampos();            
            
            //helper chama metodo limpar tela(Campos)
            helper.limparTela();    
            
            //chama tabela logins;
            tabelaLogins();            
            
            JOptionPane.showMessageDialog(null, "Login deletado com sucesso!");
            
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Error ao deletar login no banco de dados! /nError:"+ex);
        
        }            
            
        }                      
        
    }
    
    //metodo para selecionar todos logins
    public void selecioneAllLogin()
    {
        
        try
        {
            //cria objeto do tipo connection conexao passando novo Conexao(conexao.java) chamando metodo conectar
            Connection conexao = new Conexao().Conectar();
            //cria objeto do tipo LoginDAO chamado loginDAO passando novo LoginDAO recebendo conexao
            LoginDAO loginDAO = new LoginDAO(conexao);

            //arraylist logins recebe loginDAO chamando metodo selecione todos logins
            ArrayList logins = loginDAO.selecioneAllLogin();
            
            //helper chama o metodo bloquear campos
            helper.bloquearCampos();            
            
            //helper chama metodo limpar tela(Campos)
            helper.limparTela();    
            
            //chama tabela logins;
            tabelaLogins();            
            
        }
        catch(SQLException ex)
        {
            
            JOptionPane.showMessageDialog(null, "Error ao pesquisar todos logins!" + ex);
            
        }    
        
    }
    
    //metodo selecioneloginspornome
    public void selecioneLoginsporNome()
    {
        
        if(view.txtPesquisarNome.equals(""))
        {
            
            JOptionPane.showMessageDialog(null, "Campo de pesquisa está vazio!");
            
        }
        //se a view tabela for diferente de nulo
        else if(view.jTableLogins != null)
        {
            
            DefaultTableModel modelo = (DefaultTableModel) view.jTableLogins.getModel();
            
            //se as linhas do modelo for maior que 0
            if(modelo.getRowCount() > 0)
            {
                
                //sete as linhas como 0
                modelo.setRowCount(0);
            }
            
            try
            {
                
                //cria objeto do tipo connection conexao passando novo Conexao(conexao.java) chamando metodo conectar
                Connection conexao = new Conexao().Conectar();
                
                String nome = view.txtPesquisarNome.getText();
                
                //cria objeto do tipo LoginDAO chamado loginDAO passando novo LoginDAO recebendo conexao
                LoginDAO loginDAO = new LoginDAO(conexao);
                
                //arraylist logins recebe loginDAO chamando metodo selecione todos logins
                ArrayList<Login> logins = loginDAO.selecioneAllLogin();   
                
                for(Login login : logins)
                {
                    
                    Object[] objeto = new Object[]
                    {
                        
                        login.getId(),
                        login.getUsuario(),
                        login.getNome(),
                        login.getSenha(),
                        login.getEmail(),
                        login.getTipo(),
                        login.getData()
                        
                    };        
                modelo.addRow(objeto);    
                }    
                
            }
            catch(SQLException ex)
            {
                
                JOptionPane.showMessageDialog(null, "Erro ao efetuar pesquisa por nome!" +ex);
                
            }    
            
        }    
        
    }        
    
    //metodo tabela logins
    public void tabelaLogins()
    {
        //se a view a tabela for diferente de nulo
        if(view.jTableLogins != null)
        {
            //modelo do tipo defaultablemodel recebe convertendo para defaulttablemodel a view passando a tabela e pegando seu modelo
            DefaultTableModel modelo = (DefaultTableModel) view.jTableLogins.getModel();
            
            //se as linhas do modelo for maior que zero
            if(modelo.getRowCount() > 0)
            {
                //sete as linhas como 0
                modelo.setRowCount(0);
                
            }
            
            try
            {
                //cria objeto do tipo connection conexao passando novo Conexao(conexao.java) chamando metodo conectar
                Connection conexao = new Conexao().Conectar();
                //cria objeto do tipo LoginDAO chamado loginDAO passando novo LoginDAO recebendo conexao
                LoginDAO loginDAO = new LoginDAO(conexao);
            
                //logins do tipo arraylist do tipo Login recebe loginDAO chamando metodo selecione todos logins
                ArrayList<Login> logins = loginDAO.selecioneAllLogin();    
                
                //para cada login no arraylist logins
                for(Login login : logins)
                {
                    //quantidade de linhas que o objeto vai ter
                    Object[] linha = new Object[7];
                    
                    //pegue as respectivas linhas de cada login e as sete
                    linha[0] = login.getId();
                    linha[1] = login.getUsuario();
                    linha[2] = login.getNome();
                    linha[3] = login.getSenha();
                    linha[4] = login.getEmail();
                    linha[5] = login.getTipo();
                    linha[6] = login.getData();
                    
                    //adicione as linhas ao modelo
                    modelo.addRow(linha);
                    
                }    
                
            }
            catch(SQLException ex)
            {
                
                JOptionPane.showMessageDialog(null, "Error ao preencher tabela!" + ex);
                
            }    
            
        }    
        
    }        
}