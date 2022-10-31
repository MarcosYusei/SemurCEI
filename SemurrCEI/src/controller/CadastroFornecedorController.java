package controller;

import controller.helper.CadastroFornecedorHelper;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.DAO.FornecedorDAO;
import model.Fornecedor;
import view.TelaCadastroFornecedor;
import view.TelaPrincipal;
import java.sql.SQLException;
import java.sql.Connection;

public class CadastroFornecedorController 
{
    
    //cria arraylist do tipo Fornecedor chamado fornecedores
    ArrayList<Fornecedor> fornecedores = new ArrayList<Fornecedor>();    
    
    //cria variavel do tipo TelaCadastroFornecedor e CadastroFornecedorHelper e chamando-as de view e helper
    private TelaCadastroFornecedor view;
    private CadastroFornecedorHelper helper;
    
    //cria variavel tipo TelaPrincipal chamada telaprincipal
    public TelaPrincipal TelaPrincipal;

    //metodo construtor    
    public CadastroFornecedorController(TelaCadastroFornecedor view) {
        this.view = view;
        this.helper = new CadastroFornecedorHelper(view);
    }  

    //metodo construtor tela principal
    public CadastroFornecedorController(TelaPrincipal viewprincipal) {
        this.TelaPrincipal  = viewprincipal;
    }  
    
    //metodo salvar fornedor
    public void salvarFornecedor()
    {
        
        //comparações logicas
        if(view.getTxtFornecedor().getText().trim().isEmpty())
        {
            
            JOptionPane.showMessageDialog(null, "Campos obrigatorios vazios, preencha-os!!","ATENÇÃO", JOptionPane.WARNING_MESSAGE);
            
        }     
        
        //pega um fornecedor da view
        Fornecedor fornecedor = helper.obterModeloSemID();
        
        try
        {
            //cria objeto do tipo connection conexao passando novo Conexao(conexao.java) chamando metodo conectar
            Connection conexao = new Conexao().Conectar();
            //cria objeto do tipo FornecedorDAO chamado fornecedorDAO passando novo FornecedorDAO recebendo conexao
            FornecedorDAO fornecedorDAO = new FornecedorDAO(conexao);
            //objeto do tipo FornecedorDAO chamado fornecedorDAO recebe FornecedorDAO.inserir
            fornecedorDAO.inserir(fornecedor);    
            
            //helper chama o metodo bloquear campos
            helper.bloquearCampos();            
            
            //helper chama metodo limpar tela(Campos)
            helper.limparTela();    
            
            //chama tabela tabelaFornecedor;
            tabelaFornecedor();               
            
                    JOptionPane.showMessageDialog(null, "Fornecedor inserido com sucesso!");
            
                    //pegue exceção sql              
            
        }
        catch(SQLException ex)
        {
            
            JOptionPane.showMessageDialog(null, "Error ao inserir fornecedor no banco de dados! /nError:"+ex);
            
        }        
        
    }  
    
    //metodo atualizar fornecedor
    public void updateFornecedor()
    {
        
        //comparações logicas
        if(view.getTxtFornecedor().getText().trim().isEmpty())
        {
            
            JOptionPane.showMessageDialog(null, "Campos obrigatorios vazios, preencha-os!!","ATENÇÃO", JOptionPane.WARNING_MESSAGE);
            
        }   
        
        //pega um fornecedor da view
        Fornecedor fornecedor = new Fornecedor();
        
        //chama helper metodo obterModeloComId passando unidade como parametro
        fornecedor = helper.obterModelo();      
        
        try
        {
            
            //cria objeto do tipo connection conexao passando novo Conexao(conexao.java) chamando metodo conectar
            Connection conexao = new Conexao().Conectar();
            //cria objeto do tipo FornecedorDAO chamado fornecedorDAO passando novo FornecedorDAO recebendo conexao
            FornecedorDAO fornecedorDAO = new FornecedorDAO(conexao);
            //objeto do tipo FornecedorDAO chamado fornecedorDAO recebe FornecedorDAO.atualizar
            fornecedorDAO.atualizar(fornecedor);               
            
            //helper chama o metodo bloquear campos
            helper.bloquearCampos();            
            
            //helper chama metodo limpar tela(Campos)
            helper.limparTela();    
            
            //chama tabela tabelaFornecedor;
            tabelaFornecedor();             
            
            JOptionPane.showMessageDialog(null, "Fornecedor atualizado com sucesso!");
            
            //pegue exceção sql              
        }
        catch(SQLException ex)
        {
            
            JOptionPane.showMessageDialog(null, "Error ao atualizar fornecedor no banco de dados! /nError:"+ex);
            
        }    
        
    }

    //metodo deletar
    public void deletar()
    {
        
        //comparações logicas
        if(view.getTxtFornecedor().getText().trim().isEmpty())
        {
            
            JOptionPane.showMessageDialog(null, "Campos obrigatorios vazios, preencha-os!!","ATENÇÃO", JOptionPane.WARNING_MESSAGE);
            
        }          
        
        //pega um fornecedor da view
        Fornecedor fornecedor = new Fornecedor();
            
        //chama helper metodo obtermodelo com id passando tipoequipamento como parametro
        fornecedor = helper.obterModelo();         
        
        try
        {
            
            //cria objeto do tipo connection conexao passando novo Conexao(conexao.java) chamando metodo conectar
            Connection conexao = new Conexao().Conectar();
            //cria objeto do tipo FornecedorDAO chamado fornecedorDAO passando novo FornecedorDAO recebendo conexao
            FornecedorDAO fornecedorDAO = new FornecedorDAO(conexao);
            //objeto do tipo FornecedorDAO chamado fornecedorDAO recebe FornecedorDAO.deletar          
            fornecedorDAO.deletar(fornecedor);    
            
            //helper chama o metodo bloquear campos
            helper.bloquearCampos();            
            
            //helper chama metodo limpar tela(Campos)
            helper.limparTela();    
            
            //chama tabela tabelaFornecedor;
            tabelaFornecedor();             
            
            JOptionPane.showMessageDialog(null, "Fornecedor atualizado com sucesso!");               
            
        }
        catch(SQLException ex)
        {
            
            JOptionPane.showMessageDialog(null, "Error ao deletar fornecedor no banco de dados! /nError:"+ex);            
            
        }    
        
    }

    //metodo para selecionar todos tipo equipamento
    public void selecionarAllTipoEquipamentos()
    {
        
        try
        {
            
            //cria objeto do tipo connection conexao passando novo Conexao(conexao.java) chamando metodo conectar
            Connection conexao = new Conexao().Conectar();
            //cria objeto do tipo FornecedorDAO chamado fornecedorDAO passando novo FornecedorDAO recebendo conexao
            FornecedorDAO fornecedorDAO = new FornecedorDAO(conexao);
            //objeto do tipo FornecedorDAO chamado fornecedorDAO recebe FornecedorDAO.selecioneallfornecedor  
            ArrayList fornecedores = fornecedorDAO.selecioneAllFornecedor();            
            
            //helper chama o metodo bloquear campos
            helper.bloquearCampos();            
            
            //helper chama metodo limpar tela(Campos)
            helper.limparTela();    
            
            //chama tabela tabelaFornecedor;
            tabelaFornecedor();             
            
        }
        catch(SQLException ex)
        {
            
            JOptionPane.showMessageDialog(null, "Error ao pesquisar todos fornecedores!" + ex);
            
        }    
        
    } 
    
    //metodo tabelaFornecedor
    public void tabelaFornecedor()
    {
        
        //se a view a tabela for diferente de nulo
        if(view.jTabelaFornecedor != null)
        {
            
            //modelo do tipo defaultablemodel recebe convertendo para defaulttablemodel a view passando a tabela e pegando seu modelo
            DefaultTableModel modelo = (DefaultTableModel) view.jTabelaFornecedor.getModel();
            
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
            //cria objeto do tipo FornecedorDAO chamado fornecedorDAO passando novo FornecedorDAO recebendo conexao
            FornecedorDAO fornecedorDAO = new FornecedorDAO(conexao);
            //objeto do tipo FornecedorDAO chamado fornecedorDAO recebe FornecedorDAO.selecioneallfornecedor  
            ArrayList<Fornecedor>fornecedores = fornecedorDAO.selecioneAllFornecedor();     
                
                //para cada fornecedor no arraylist fornecedores
                for(Fornecedor fornecedor : fornecedores)
                {
                    
                    //quantidade de linhas que o objeto vai ter
                    Object[] linha = new Object[2];
                    
                    //pegue as respectivas linhas de cada fornecedor e as sete
                    linha[0] = fornecedor.getId();
                    linha[1] = fornecedor.getFornecedornome();
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
