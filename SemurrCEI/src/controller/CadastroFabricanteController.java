package controller;

import controller.helper.CadastroFabricanteHelper;
import model.DAO.FabricanteDAO;
import model.Fabricante;
import view.TelaCadastroFabricante;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import view.TelaPrincipal;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;


public class CadastroFabricanteController 
{
    
    //cria arraylist do tipo Fabricante chamado fabricantes
    ArrayList<Fabricante> fabricantes = new ArrayList<Fabricante>(); 
    
    //cria variavel do tipo telacadastrofabricante e CadastroFabricanteHelper e chamando-as de view e helper
    private TelaCadastroFabricante view;
    private CadastroFabricanteHelper helper;
    
    //cria variavel tipo TelaPrincipal chamada telaprincipal
    public TelaPrincipal TelaPrincipal;  
    
    //metodo construtor
    public CadastroFabricanteController(TelaCadastroFabricante view) {
        this.view = view;
        this.helper = new CadastroFabricanteHelper(view);
    } 

    //metodo construtor tela principal
    public CadastroFabricanteController(TelaPrincipal viewprincipal) {
        this.TelaPrincipal  = viewprincipal;
    }     
    
    //metodo salvar fabricante
    public void salvarFabricante()
    {
        
        //comparações logicas
        if(view.getTxtFabricante().getText().trim().isEmpty())
        {
            
            JOptionPane.showMessageDialog(null, "Campos obrigatorios vazios, preencha-os!!","ATENÇÃO", JOptionPane.WARNING_MESSAGE);
            
        }    

            //pega uma fabricante da view
            Fabricante fabricante = helper.obterModeloSemID();
            
                try
                {
                    //cria objeto do tipo connection conexao passando novo Conexao(conexao.java) chamando metodo conectar
                    Connection conexao = new Conexao().Conectar();
                    //cria objeto do tipo FabricanteDAO chamado fabricanteDAO passando novo FabricanteDAO recebendo conexao
                    FabricanteDAO fabricanteDAO = new FabricanteDAO(conexao);
                    //objeto do tipo unidade chamado fabricante recebe fabricanteDAO.inserir
                    fabricanteDAO.inserir(fabricante);   
                    
                    //helper chama o metodo bloquear campos
                    helper.bloquearCampos();            
            
                    //helper chama metodo limpar tela(Campos)
                    helper.limparTela();    
            
                    //chama tabela fabricantes;
                    tabelaFabricantes();               
            
                    JOptionPane.showMessageDialog(null, "Fabricante inserido com sucesso!");
            
                    //pegue exceção sql  
                }
                catch (SQLException ex)
                {
            
                    JOptionPane.showMessageDialog(null, "Error ao inserir fabricante no banco de dados! /nError:"+ex);
        
                }                 

    }   
    
    //metodo atualizar fabricante
    public void updateFabricante()
    {
        
        //comparações logicas
        if(view.getTxtFabricante().getText().trim().isEmpty())
        {
            
            JOptionPane.showMessageDialog(null, "Campos obrigatorios vazios, preencha-os!!","ATENÇÃO", JOptionPane.WARNING_MESSAGE);
            
        }  

            //pega uma fabricante da view
            Fabricante fabricante = new Fabricante();
            
            //chama helper metodo obterModelo passando unidade como parametro
            fabricante = helper.obterModelo();         
            
                try {
                    //cria objeto do tipo connection conexao passando novo Conexao(conexao.java) chamando metodo conectar
                    Connection conexao = new Conexao().Conectar();
                    //cria objeto do tipo FabricanteDAO chamado fabricanteDAO passando novo FabricanteDAO recebendo conexao
                    FabricanteDAO fabricanteDAO = new FabricanteDAO(conexao);
                    //objeto do tipo fabricante chamado fabricantes recebe fabricanteDAO.atualizar
                    fabricanteDAO.atualizar(fabricante);   
                    
                    //helper chama o metodo bloquear campos
                    helper.bloquearCampos();            
            
                    //helper chama metodo limpar tela(Campos)
                    helper.limparTela();    
            
                    //chama tabelaFabricantes;
                    tabelaFabricantes();               
            
                    JOptionPane.showMessageDialog(null, "Fabricante atualizado com sucesso!");
            
                    //pegue exceção sql  
                } catch (SQLException ex) 
                {
            
                    JOptionPane.showMessageDialog(null, "Error ao atualizar fabricante no banco de dados! /nError:"+ex);
        
                }          
                
    }
    
    //metodo deletar
    public void deletar()
    {
        
        //comparações logicas
        if(view.getTxtFabricante().getText().trim().isEmpty())
        {
            
            JOptionPane.showMessageDialog(null, "Campos obrigatorios vazios, preencha-os!!","ATENÇÃO", JOptionPane.WARNING_MESSAGE);
            
        }  
        
        //pega uma fabricante da view
        Fabricante fabricante = new Fabricante();
            
        //chama helper metodo obtermodelo com id passando fabricante como parametro
        fabricante = helper.obterModelo();         

            try
            {
                
                //cria objeto do tipo connection conexao passando novo Conexao(conexao.java) chamando metodo conectar
                Connection conexao = new Conexao().Conectar();
                //cria objeto do tipo FabricanteDAO chamado fabricanteDAO passando novo FabricanteDAO recebendo conexao
                FabricanteDAO fabricanteDAO = new FabricanteDAO(conexao);
                //objeto do tipo fabricante chamado fabricantes recebe fabricanteDAO.deletar
                fabricanteDAO.deletar(fabricante);   
                
            
                //helper chama o metodo bloquear campos
                helper.bloquearCampos();            
            
                //helper chama metodo limpar tela(Campos)
                helper.limparTela();    
            
                //chama tabelaFabricantes;
                tabelaFabricantes();                
            
                JOptionPane.showMessageDialog(null, "fabricante deletado com sucesso!");                
                
            }
            catch(SQLException ex)
            {
                
                JOptionPane.showMessageDialog(null, "Error ao deletar fabricante no banco de dados! /nError:"+ex);
                
            }                       
        
    }
    
    //metodo para selecionar todos fabricantes
    public void selecionarAllUnidades()
    {
        
        try
        {
            
                //cria objeto do tipo connection conexao passando novo Conexao(conexao.java) chamando metodo conectar
                Connection conexao = new Conexao().Conectar();
                //cria objeto do tipo FabricanteDAO chamado fabricanteDAO passando novo FabricanteDAO recebendo conexao
                FabricanteDAO fabricanteDAO = new FabricanteDAO(conexao);
                
                //arraylist fabricantes recebe fabricanteDAO chamando metodo selecioneAllfabricante
                ArrayList fabricantes = fabricanteDAO.selecioneAllFabricante();
            
                //helper chama o metodo bloquear campos
                helper.bloquearCampos();            
            
                //helper chama metodo limpar tela(Campos)
                helper.limparTela();    
            
                //chama tabelaFabricantes;
                tabelaFabricantes();                   
                
        }
        catch(SQLException ex)
        {
            
            JOptionPane.showMessageDialog(null, "Error ao pesquisar todos fabricantes!" + ex);
            
        }    
        
    }
    
    //metodo tabelaFabricantes
    public void tabelaFabricantes()
    {
        
        //se a view a tabela for diferente de nulo
        if(view.jTabelaFabricante != null)
        {
            
            //modelo do tipo defaultablemodel recebe convertendo para defaulttablemodel a view passando a tabela e pegando seu modelo
            DefaultTableModel modelo = (DefaultTableModel) view.jTabelaFabricante.getModel();
            
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
                //cria objeto do tipo FabricanteDAO chamado fabricanteDAO passando novo FabricanteDAO recebendo conexao
                FabricanteDAO fabricanteDAO = new FabricanteDAO(conexao);
                
                //arraylist fabricantes recebe fabricanteDAO chamando metodo selecioneAllFabricante
                ArrayList<Fabricante> fabricantes = fabricanteDAO.selecioneAllFabricante();
                
                //para cada fabricante no arraylist fabricantes
                for(Fabricante fabricante : fabricantes)
                {
                    
                    //quantidade de linhas que o objeto vai ter
                    Object[] linha = new Object[2];
                    
                    //pegue as respectivas linhas de cada fabricante e as sete
                    linha[0] = fabricante.getId();
                    linha[1] = fabricante.getFabricantenome();
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
