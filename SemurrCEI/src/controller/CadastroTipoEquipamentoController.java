package controller;

import controller.helper.CadastroTipoEquipamentoHelper;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.DAO.TipoEquipamentoDAO;
import model.TipoEquipamento;
import view.TelaCadastroTipoEquipamento;
import view.TelaPrincipal;
import java.sql.SQLException;
import java.sql.Connection;
import javax.swing.table.DefaultTableModel;


public class CadastroTipoEquipamentoController 
{

    //cria arraylist do tipo TipoEquipamento chamado tipoequipamentos
    ArrayList<TipoEquipamento> tipoequipamentos = new ArrayList<TipoEquipamento>();    
    
    //cria variavel do tipo TelaCadastroTipoEquipamento e CadastroTipoEquipamentoHelper e chamando-as de view e helper
    private TelaCadastroTipoEquipamento view;
    private CadastroTipoEquipamentoHelper helper;
    
    //cria variavel tipo TelaPrincipal chamada telaprincipal
    public TelaPrincipal TelaPrincipal;

    //metodo construtor    
    public CadastroTipoEquipamentoController(TelaCadastroTipoEquipamento view) {
        this.view = view;
        this.helper = new CadastroTipoEquipamentoHelper(view);
    }  

    //metodo construtor tela principal
    public CadastroTipoEquipamentoController(TelaPrincipal viewprincipal) {
        this.TelaPrincipal  = viewprincipal;
    }      
    
    //metodo salvar tipoequipamento
    public void salvarTipoEquipamento()
    {
        
        //comparações logicas
        if(view.getTxtTipoEquipamento().getText().trim().isEmpty())
        {
            
            JOptionPane.showMessageDialog(null, "Campos obrigatorios vazios, preencha-os!!","ATENÇÃO", JOptionPane.WARNING_MESSAGE);
            
        }     
        
        //pega um tipoequipamento da view
        TipoEquipamento tipoequipamento = helper.obterModeloSemID();
        
        try
        {
            //cria objeto do tipo connection conexao passando novo Conexao(conexao.java) chamando metodo conectar
            Connection conexao = new Conexao().Conectar();
            //cria objeto do tipo TipoEquipamentoDAO chamado tipoequipamentoDAO passando novo TipoEquipamentoDAO recebendo conexao
            TipoEquipamentoDAO tipoequipamentoDAO = new TipoEquipamentoDAO(conexao);
            //objeto do tipo TipoEquipamentoDAO chamado tipoequipamentoDAO recebe tipoequipamentoDAO.inserir
            tipoequipamentoDAO.inserir(tipoequipamento);    
            
            //helper chama o metodo bloquear campos
            helper.bloquearCampos();            
            
            //helper chama metodo limpar tela(Campos)
            helper.limparTela();    
            
            //chama tabela tipoequipamento;
            tabelaTipoEquipamento();               
            
                    JOptionPane.showMessageDialog(null, "Tipo equipamento inserido com sucesso!");
            
                    //pegue exceção sql              
            
        }
        catch(SQLException ex)
        {
            
            JOptionPane.showMessageDialog(null, "Error ao inserir tipo equipamento no banco de dados! /nError:"+ex);
            
        }
 
    }
    
    //metodo atualizar tipoequipamento
    public void updateTipoEquipamento()
    {
        
        //comparações logicas
        if(view.getTxtTipoEquipamento().getText().trim().isEmpty())
        {
            
            JOptionPane.showMessageDialog(null, "Campos obrigatorios vazios, preencha-os!!","ATENÇÃO", JOptionPane.WARNING_MESSAGE);
            
        }   
        
        //pega um tipoequipamento da view
        TipoEquipamento tipoequipamento = new TipoEquipamento();
        
        //chama helper metodo obterModeloComId passando unidade como parametro
        tipoequipamento = helper.obterModelo();      
        
        try
        {
            
            //cria objeto do tipo connection conexao passando novo Conexao(conexao.java) chamando metodo conectar
            Connection conexao = new Conexao().Conectar();
            //cria objeto do tipo TipoEquipamentoDAO chamado tipoequipamentoDAO passando novo TipoEquipamentoDAO recebendo conexao
            TipoEquipamentoDAO tipoequipamentoDAO = new TipoEquipamentoDAO(conexao);
            //objeto do tipo TipoEquipamentoDAO chamado tipoequipamentoDAO recebe tipoequipamentoDAO.atualizar
            tipoequipamentoDAO.atualizar(tipoequipamento);               
            
            //helper chama o metodo bloquear campos
            helper.bloquearCampos();            
            
            //helper chama metodo limpar tela(Campos)
            helper.limparTela();    
            
            //chama tabela tipoequipamento;
            tabelaTipoEquipamento();              
            
            JOptionPane.showMessageDialog(null, "Tipo equipamento atualizado com sucesso!");
            
            //pegue exceção sql              
        }
        catch(SQLException ex)
        {
            
            JOptionPane.showMessageDialog(null, "Error ao atualizar tipo equipamento no banco de dados! /nError:"+ex);
            
        }    
        
    }
    
    //metodo deletar
    public void deletar()
    {
        
        //comparações logicas
        if(view.getTxtTipoEquipamento().getText().trim().isEmpty())
        {
            
            JOptionPane.showMessageDialog(null, "Campos obrigatorios vazios, preencha-os!!","ATENÇÃO", JOptionPane.WARNING_MESSAGE);
            
        }          
        
        //pega um tipoequipamento da view
        TipoEquipamento tipoequipamento = new TipoEquipamento();
            
        //chama helper metodo obtermodelo com id passando tipoequipamento como parametro
        tipoequipamento = helper.obterModelo();         
        
        try
        {
            
            //cria objeto do tipo connection conexao passando novo Conexao(conexao.java) chamando metodo conectar
            Connection conexao = new Conexao().Conectar();
            //cria objeto do tipo TipoEquipamentoDAO chamado tipoequipamentoDAO passando novo TipoEquipamentoDAO recebendo conexao
            TipoEquipamentoDAO tipoequipamentoDAO = new TipoEquipamentoDAO(conexao);
            //objeto do tipo TipoEquipamentoDAO chamado tipoequipamentoDAO recebe tipoequipamentoDAO.deletar            
            tipoequipamentoDAO.deletar(tipoequipamento);    
            
            //helper chama o metodo bloquear campos
            helper.bloquearCampos();            
            
            //helper chama metodo limpar tela(Campos)
            helper.limparTela();    
            
            //chama tabela tipoequipamento;
            tabelaTipoEquipamento();              
            
            JOptionPane.showMessageDialog(null, "Tipo equipamento deletado com sucesso!");                  
            
        }
        catch(SQLException ex)
        {
            
            JOptionPane.showMessageDialog(null, "Error ao deletar tipo equipamento no banco de dados! /nError:"+ex);            
            
        }    
        
    }
    
    //metodo para selecionar todos tipo equipamento
    public void selecionarAllTipoEquipamentos()
    {
        
        try
        {
            
            //cria objeto do tipo connection conexao passando novo Conexao(conexao.java) chamando metodo conectar
            Connection conexao = new Conexao().Conectar();
            //cria objeto do tipo TipoEquipamentoDAO chamado tipoequipamentoDAO passando novo TipoEquipamentoDAO recebendo conexao
            TipoEquipamentoDAO tipoequipamentoDAO = new TipoEquipamentoDAO(conexao);
            //arraylist tipoequipamentos recebe tipoEquipamentoDAO chamando metodo selecioneAllTipoequipamento
            ArrayList tipoequipamentos = tipoequipamentoDAO.selecioneAllTipoEquipamento();            
            
            //helper chama o metodo bloquear campos
            helper.bloquearCampos();            
            
            //helper chama metodo limpar tela(Campos)
            helper.limparTela();    
            
            //chama tabela tipoequipamento;
            tabelaTipoEquipamento();              
            
        }
        catch(SQLException ex)
        {
            
            JOptionPane.showMessageDialog(null, "Error ao pesquisar todos equipamentos!" + ex);
            
        }    
        
    } 
    
    //metodo tabelaTipoEquipamento
    public void tabelaTipoEquipamento()
    {
        
        //se a view a tabela for diferente de nulo
        if(view.jTabelaTipoEquipamento != null)
        {
            
            //modelo do tipo defaultablemodel recebe convertendo para defaulttablemodel a view passando a tabela e pegando seu modelo
            DefaultTableModel modelo = (DefaultTableModel) view.jTabelaTipoEquipamento.getModel();
            
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
                //cria objeto do tipo TipoEquipamentoDAO chamado tipoequipamentoDAO passando novo TipoEquipamentoDAO recebendo conexao
                TipoEquipamentoDAO tipoequipamentoDAO = new TipoEquipamentoDAO(conexao);
                //arraylist tipoequipamentos recebe tipoEquipamentoDAO chamando metodo selecioneAllTipoequipamento
                ArrayList<TipoEquipamento>tipoequipamentos = tipoequipamentoDAO.selecioneAllTipoEquipamento();     
                
                //para cada tipoequipamento no arraylist tipoequipamentos
                for(TipoEquipamento tipoequipamento : tipoequipamentos)
                {
                    
                    //quantidade de linhas que o objeto vai ter
                    Object[] linha = new Object[2];
                    
                    //pegue as respectivas linhas de cada tipoequipamento e as sete
                    linha[0] = tipoequipamento.getId();
                    linha[1] = tipoequipamento.getTipoequipamento();
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
