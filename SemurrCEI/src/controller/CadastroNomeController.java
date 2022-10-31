package controller;

import controller.helper.CadastroNomeHelper;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Nome;
import view.TelaCadastroPessoa;
import view.TelaPrincipal;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import model.DAO.NomeDAO;


public class CadastroNomeController 
{
    
    //cria arraylist do tipo Nome chamado nomes   
    ArrayList<Nome> nomes = new ArrayList<Nome>();    
    
    //cria variavel do tipo TelaCadastroPessoa e CadastroNomeHelper e chamando-as de view e helper
    private TelaCadastroPessoa view;
    private CadastroNomeHelper helper;
    
    //cria variavel tipo TelaPrincipal chamada telaprincipal
    public TelaPrincipal TelaPrincipal;  
    
    //metodo construtor    
    public CadastroNomeController(TelaCadastroPessoa view) {
        this.view = view;
        this.helper = new CadastroNomeHelper(view);
    }  

    //metodo construtor tela principal
    public CadastroNomeController(TelaPrincipal viewprincipal) {
        this.TelaPrincipal  = viewprincipal;
    }      
    
    //metodo salvar unidade
    public void salvarNome()
    {
        
        //comparações logicas
        if(view.getTxtNomepessoa().getText().trim().isEmpty())
        {
            
            JOptionPane.showMessageDialog(null, "Campos obrigatorios vazios, preencha-os!!","ATENÇÃO", JOptionPane.WARNING_MESSAGE);
            
        }    

            //pega um nome da view
            Nome nome = helper.obterModeloSemID();
            
                try
                {
                    //cria objeto do tipo connection conexao passando novo Conexao(conexao.java) chamando metodo conectar
                    Connection conexao = new Conexao().Conectar();
                    //cria objeto do tipo NomeDAO chamado nomeDAO passando novo NomeDAO recebendo conexao
                    NomeDAO nomeDAO = new NomeDAO(conexao);
                    //objeto do tipo nome chamado nomes recebe nomeDAO.inserir
                    nomeDAO.inserir(nome);   
                    
                    //helper chama o metodo bloquear campos
                    helper.bloquearCampos();            
            
                    //helper chama metodo limpar tela(Campos)
                    helper.limparTela();    
            
                    //chama tabela nomes;
                    tabelaNomes();               
            
                    JOptionPane.showMessageDialog(null, "Nome inserido com sucesso!");
            
                    //pegue exceção sql  
                }
                catch (SQLException ex)
                {
            
                    JOptionPane.showMessageDialog(null, "Error ao inserir nome no banco de dados! /nError:"+ex);
        
                }                         
        
    }        
    
    //metodo atualizar nome
    public void updateNome()
    {
        
        //comparações logicas
        if(view.getTxtNomepessoa().getText().trim().isEmpty())
        {
            
            JOptionPane.showMessageDialog(null, "Campos obrigatorios vazios, preencha-os!!","ATENÇÃO", JOptionPane.WARNING_MESSAGE);
            
        }  

            //pega um nome da view
            Nome nome = new Nome();
            
            //chama helper metodo obterModeloComId passando nome como parametro
            nome = helper.obterModelo();      
            
                try {
                    //cria objeto do tipo connection conexao passando novo Conexao(conexao.java) chamando metodo conectar
                    Connection conexao = new Conexao().Conectar();
                    //cria objeto do tipo NomeDAO chamado nomeDAO passando novo NomeDAO recebendo conexao
                    NomeDAO nomeDAO = new NomeDAO(conexao);
                    //objeto do tipo nome chamado nomes recebe nomeDAO.atualizar
                    nomeDAO.atualizar(nome);   
                    
                    //helper chama o metodo bloquear campos
                    helper.bloquearCampos();            
            
                    //helper chama metodo limpar tela(Campos)
                    helper.limparTela();    
            
                    //chama tabela nomes;
                    tabelaNomes();                
            
                    JOptionPane.showMessageDialog(null, "Nome atualizado com sucesso!");
            
                    //pegue exceção sql  
                } catch (SQLException ex) 
                {
            
                    JOptionPane.showMessageDialog(null, "Error ao atualizar nome no banco de dados! /nError:"+ex);
        
                }                             
        
    } 
    
    //metodo deletar
    public void deletar()
    {
        
        //comparações logicas
        if(view.getTxtNomepessoa().getText().trim().isEmpty())
        {
            
            JOptionPane.showMessageDialog(null, "Campos obrigatorios vazios, preencha-os!!","ATENÇÃO", JOptionPane.WARNING_MESSAGE);
            
        }  
        
        //pega uma nome da view
        Nome nome = new Nome();
            
        //chama helper metodo obtermodelo com id passando nome como parametro
        nome = helper.obterModelo();          

            try
            {
                
                //cria objeto do tipo connection conexao passando novo Conexao(conexao.java) chamando metodo conectar
                Connection conexao = new Conexao().Conectar();
                //cria objeto do tipo NomeDAO chamado nomeDAO passando novo NomeDAO recebendo conexao
                NomeDAO nomeDAO = new NomeDAO(conexao);
                //objeto do tipo nome chamado nomes recebe nomeDAO.deletar
                nomeDAO.deletar(nome);   
                
            
                //helper chama o metodo bloquear campos
                helper.bloquearCampos();            
            
                //helper chama metodo limpar tela(Campos)
                helper.limparTela();    
            
                    //chama tabela nomes;
                    tabelaNomes();            
            
                JOptionPane.showMessageDialog(null, "Nome deletado com sucesso!");                
                
            }
            catch(SQLException ex)
            {
                
                JOptionPane.showMessageDialog(null, "Error ao deletar nome no banco de dados! /nError:"+ex);
                
            }                       
        
    }
    
    //metodo para selecionar todos Nomes
    public void selecionarAllNomes()
    {
        
        try
        {
            
                //cria objeto do tipo connection conexao passando novo Conexao(conexao.java) chamando metodo conectar
                Connection conexao = new Conexao().Conectar();
                //cria objeto do tipo NomeDAO chamado nomeDAO passando novo NomeDAO recebendo conexao
                NomeDAO nomeDAO = new NomeDAO(conexao);
                
                //arraylist nomes recebe nomeDAO chamando metodo selecioneAllNome
                ArrayList nomes = nomeDAO.selecioneAllNome();
            
                //helper chama o metodo bloquear campos
                helper.bloquearCampos();            
            
                //helper chama metodo limpar tela(Campos)
                helper.limparTela();    
            
                //chama tabela nomes;
                tabelaNomes();                          
            
        }
        catch(SQLException ex)
        {
            
            JOptionPane.showMessageDialog(null, "Error ao pesquisar todos nomes!" + ex);
            
        }    
        
    }        
    
    //metodo tabelaNomes
    public void tabelaNomes()
    {
        
        //se a view a tabela for diferente de nulo
        if(view.jTabelaCadNome != null)
        {
            
            //modelo do tipo defaultablemodel recebe convertendo para defaulttablemodel a view passando a tabela e pegando seu modelo
            DefaultTableModel modelo = (DefaultTableModel) view.jTabelaCadNome.getModel();
            
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
                //cria objeto do tipo NomeDAO chamado nomeDAO passando novo NomeDAO recebendo conexao
                NomeDAO nomeDAO = new NomeDAO(conexao);
                
                //arraylist nomes recebe nomeDAO chamando metodo selecioneAllNome
                ArrayList<Nome> nomes = nomeDAO.selecioneAllNome();
                
                //para cada nome no arraylist unidades
                for(Nome nome : nomes)
                {
                    
                    //quantidade de linhas que o objeto vai ter
                    Object[] linha = new Object[2];
                    
                    //pegue as respectivas linhas de cada nome e as sete
                    linha[0] = nome.getId();
                    linha[1] = nome.getNomepessoa();
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
