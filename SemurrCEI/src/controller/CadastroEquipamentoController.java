package controller;

import controller.helper.CadastroEquipamentoHelper;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Equipamento;
import view.TelaCadastroEquipamento;
import view.TelaPrincipal;
import java.sql.Connection;
import model.DAO.EquipamentoDAO;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import model.DAO.FabricanteDAO;
import model.DAO.FornecedorDAO;
import model.DAO.TipoEquipamentoDAO;
import model.DAO.UnidadeDAO;
import model.Fabricante;
import model.Fornecedor;
import model.TipoEquipamento;
import model.Unidade;

public class CadastroEquipamentoController 
{
    
    //cria arraylist do tipo Equipamento chamado equipamentos   
    ArrayList<Equipamento> equipamentos = new ArrayList<Equipamento>();    
    
    //cria variavel do tipo telacadastroequipamento e CadastroEquipamentoHelper e chamando-as de view e helper
    private TelaCadastroEquipamento view;
    private CadastroEquipamentoHelper helper;
    
    //cria variavel tipo TelaPrincipal chamada telaprincipal
    public TelaPrincipal TelaPrincipal;  
    
    //metodo construtor    
    public CadastroEquipamentoController(TelaCadastroEquipamento view) {
        this.view = view;
        this.helper = new CadastroEquipamentoHelper(view);
    }  

    //metodo construtor tela principal
    public CadastroEquipamentoController(TelaPrincipal viewprincipal) {
        this.TelaPrincipal  = viewprincipal;
    }    

    //metodo construtor vazio
    public CadastroEquipamentoController() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
       
    //metodo salvar equipamento
    public void salvarEquipamento()
    {
        
        //comparações logicas
        if(view.getTxtUnidade().getSelectedIndex() == 0 && view.getTxtTipoEquip().getSelectedIndex() == 0 && view.getTxtTombo().getText().trim().isEmpty()
        && view.getTxtSerie().getText().trim().isEmpty() && view.getTxtFornecedor().getSelectedIndex() == 0 && view.getTxtFabricante().getSelectedIndex() == 0 &&
        view.getTxtModelo().getText().trim().isEmpty() && view.getTxtStatus().getSelectedIndex() == 0 && view.getTxtEquipamento().getSelectedIndex() == 0)
        {

            JOptionPane.showMessageDialog(null, "Campos obrigatorios vazios, preencha-os!!","ATENÇÃO", JOptionPane.WARNING_MESSAGE);

        }
        else if(view.getTxtUnidade().getSelectedIndex() == 0 && view.getTxtTombo().getText().trim().isEmpty() && view.getTxtSerie().getText().trim().isEmpty())
        {

            JOptionPane.showMessageDialog(null, "Combobox unidade, campos tombo e serie vazios preencha-os!","ATENÇÃO", JOptionPane.WARNING_MESSAGE);

        }
        else if(view.getTxtTipoEquip().getSelectedIndex() != 0)
        {

            JOptionPane.showMessageDialog(null, "Combobox tipo equip esta vazio preencha-o!","ATENÇÃO", JOptionPane.WARNING_MESSAGE);

        } 
        else if(view.getTxtFornecedor().getSelectedIndex() != 0)
        {
            
            JOptionPane.showMessageDialog(null, "Campo fornecedor esta vazio preencha-o!","ATENÇÃO", JOptionPane.WARNING_MESSAGE);            
            
        }    
        else if(view.getTxtFabricante().getSelectedIndex() != 0)
        {
            
            JOptionPane.showMessageDialog(null, "Combobox fabricante esta vazio preencha-o!","ATENÇÃO", JOptionPane.WARNING_MESSAGE);            
            
        }          
        else if(view.getTxtModelo().getText().trim().isEmpty())
        {
            
            JOptionPane.showMessageDialog(null, "Campo modelo esta vazio preencha-o!","ATENÇÃO", JOptionPane.WARNING_MESSAGE);            
            
        }  
        else if(view.getTxtStatus().getSelectedIndex() == 0)
        {
            
            JOptionPane.showMessageDialog(null, "Combobox status esta vazio preencha-o!","ATENÇÃO", JOptionPane.WARNING_MESSAGE);            
            
        } 
        else if(view.getTxtEquipamento().getSelectedIndex() == 0)
        {
            
            JOptionPane.showMessageDialog(null, "Campo equipamento esta vazio preencha-o!","ATENÇÃO", JOptionPane.WARNING_MESSAGE);            
            
        }              
        
            //compara se todos os campos foram preenchidos
            if(view.getTxtUnidade().getSelectedItem() != null && view.getTxtTipoEquip().getSelectedItem() != null && view.getTxtTombo().getText().length() > 0
            &&view.getTxtSerie().getText().length() > 0 && view.getTxtFornecedor().getSelectedItem() != null && view.getTxtFabricante().getSelectedItem() != null &&
            view.getTxtModelo().getText().length() > 0 &&view.getTxtStatus().getSelectedItem() != null && view.getTxtEquipamento().getSelectedItem() != null
            && view.getTxtObservacao().getText().trim().isEmpty() || !view.getTxtObservacao().getText().trim().isEmpty())
            {
                //pega um equipamento da view
                Equipamento equipamento = helper.obterModeloSemID();
                
                try {
                    //cria objeto do tipo connection conexao passando novo Conexao(conexao.java) chamando metodo conectar
                    Connection conexao = new Conexao().Conectar();
                    //cria objeto do tipo EquipamentoDAO chamado equipamentoDAO passando novo EquipamentoDAO recebendo conexao
                    EquipamentoDAO equipamentoDAO = new EquipamentoDAO(conexao);
                    //arraylist do tipo equipamento chamado equipamentos recebe equipamentoDAO.inserir
                    equipamentoDAO.inserir(equipamento);   
                    
                    //helper chama o metodo bloquear campos
                    helper.bloquearCampos();            
            
                    //helper chama metodo limpar tela(Campos)
                    helper.limparTela();    
            
                    //chama tabela equipamentos;
                    tabelaEquipamentos();               
            
                    JOptionPane.showMessageDialog(null, "Equipamento inserido com sucesso!");
            
                    //pegue exceção sql  
                } catch (SQLException ex) {
            
                    JOptionPane.showMessageDialog(null, "Error ao inserir equipamento no banco de dados! /nError:"+ex);
        
                }     
                
            }
            else if(view.getTxtUnidade().getSelectedItem() != null && view.getTxtTipoEquip().getSelectedItem() != null && view.getTxtTombo().getText().length() > 0
            &&view.getTxtSerie().getText().length() > 0 && view.getTxtFornecedor().getSelectedItem() != null && view.getTxtFabricante().getSelectedItem() != null &&
            view.getTxtModelo().getText().length() > 0 &&view.getTxtStatus().getSelectedItem() != null && view.getTxtEquipamento().getSelectedItem() != null
            && !view.getTxtObservacao().getText().trim().isEmpty())
            {
                
               //pega um equipamento da view
                Equipamento equipamento = helper.obterModelo();
                
                try {
                    //cria objeto do tipo connection conexao passando novo Conexao(conexao.java) chamando metodo conectar
                    Connection conexao = new Conexao().Conectar();
                    //cria objeto do tipo EquipamentoDAO chamado equipamentoDAO passando novo EquipamentoDAO recebendo conexao
                    EquipamentoDAO equipamentoDAO = new EquipamentoDAO(conexao);
                    //arraylist do tipo equipamento chamado equipamentos recebe equipamentoDAO.inserir
                    equipamentoDAO.inserir(equipamento);   
                    
                    //helper chama o metodo bloquear campos
                    helper.bloquearCampos();            
            
                    //helper chama metodo limpar tela(Campos)
                    helper.limparTela();    
            
                    //chama tabela equipamentos;
                    tabelaEquipamentos();               
            
                    JOptionPane.showMessageDialog(null, "Equipamento inserido com sucesso!");
            
                    //pegue exceção sql  
                } catch (SQLException ex) {
            
                    JOptionPane.showMessageDialog(null, "Error ao inserir equipamento no banco de dados! /nError:"+ex);
        
                }                     
                
            }    
                
    }
    
    //metodo atualizar
    public void updateEquipamento()
    {
        
        //comparações logicas
        if(view.getTxtUnidade().getSelectedItem() == null && view.getTxtTipoEquip().getSelectedItem() == null && view.getTxtTombo().getText().trim().isEmpty()
        &&view.getTxtSerie().getText().trim().isEmpty() && view.getTxtFornecedor().getSelectedItem() == null && view.getTxtFabricante().getSelectedItem() == null &&
        view.getTxtModelo().getText().trim().isEmpty() &&view.getTxtStatus().getSelectedIndex()== 0 && view.getTxtEquipamento().getSelectedIndex()== 0
        && view.getTxtObservacao().getText().trim().isEmpty())
        {

            JOptionPane.showMessageDialog(null, "Campos obrigatorios vazios, preencha-os!!","ATENÇÃO", JOptionPane.WARNING_MESSAGE);

        }
        else if(view.getTxtUnidade().getSelectedIndex()== 0 && view.getTxtTombo().getText().trim().isEmpty() && view.getTxtSerie().getText().trim().isEmpty())
        {

            JOptionPane.showMessageDialog(null, "Combobox unidade, campos tombo e serie vazios preencha-os!","ATENÇÃO", JOptionPane.WARNING_MESSAGE);

        }
        else if(view.getTxtTipoEquip().getSelectedItem() == null)
        {

            JOptionPane.showMessageDialog(null, "Combobox tipo equip esta vazio preencha-o!","ATENÇÃO", JOptionPane.WARNING_MESSAGE);

        } 
        else if(view.getTxtFornecedor().getSelectedItem() == null)
        {
            
            JOptionPane.showMessageDialog(null, "Campo fornecedor esta vazio preencha-o!","ATENÇÃO", JOptionPane.WARNING_MESSAGE);            
            
        }    
        else if(view.getTxtFabricante().getSelectedItem() == null)
        {
            
            JOptionPane.showMessageDialog(null, "Combobox fabricante esta vazio preencha-o!","ATENÇÃO", JOptionPane.WARNING_MESSAGE);            
            
        }          
        else if(view.getTxtModelo().getText().trim().isEmpty())
        {
            
            JOptionPane.showMessageDialog(null, "Campo modelo esta vazio preencha-o!","ATENÇÃO", JOptionPane.WARNING_MESSAGE);            
            
        }  
        else if(view.getTxtStatus().getSelectedIndex() == 0)
        {
            
            JOptionPane.showMessageDialog(null, "Combobox status esta vazio preencha-o!","ATENÇÃO", JOptionPane.WARNING_MESSAGE);            
            
        } 
        else if(view.getTxtEquipamento().getSelectedIndex() == 0)
        {
            
            JOptionPane.showMessageDialog(null, "Campo equipamento esta vazio preencha-o!","ATENÇÃO", JOptionPane.WARNING_MESSAGE);            
            
        }           

                //pega um equipamento da view com todos dados
                Equipamento equipamento = helper.obterModelo();                
                
                try {
                    //cria objeto do tipo connection conexao passando novo Conexao(conexao.java) chamando metodo conectar
                    Connection conexao = new Conexao().Conectar();
                    //cria objeto do tipo EquipamentoDAO chamado equipamentoDAO passando novo EquipamentoDAO recebendo conexao
                    EquipamentoDAO equipamentoDAO = new EquipamentoDAO(conexao);
                    //equipamentoDAO chama metodo atualizar passando equipamento
                    equipamentoDAO.atualizar(equipamento);     
            
                    //helper chama o metodo bloquear campos
                    helper.bloquearCampos();            
            
                    //helper chama metodo limpar tela(Campos)
                    helper.limparTela();    
            
                    //chama tabela equipamentos;
                    tabelaEquipamentos();               
            
                    JOptionPane.showMessageDialog(null, "Equipamento atualizado com sucesso!");
            
                    //pegue exceção sql  
                } catch (SQLException ex) {
            
                    JOptionPane.showMessageDialog(null, "Error ao atualizar equipamento no banco de dados! /nError:"+ex);
        
                }                            
         
}
    //metodo deletar
    public void deletarEquipamento()
    {
        
        //comparações logicas
        if(view.getTxtUnidade().getSelectedItem() == null && view.getTxtTipoEquip().getSelectedItem() == null && view.getTxtTombo().getText().length() > 0
        &&view.getTxtSerie().getText().length() > 0 && view.getTxtFornecedor().getSelectedItem() == null && view.getTxtFabricante().getSelectedItem() == null &&
        view.getTxtModelo().getText().length() > 0
        &&view.getTxtStatus().getSelectedIndex()== 0 && view.getTxtEquipamento().getSelectedIndex()== 0)
        {

            JOptionPane.showMessageDialog(null, "Campos obrigatorios vazios, preencha-os!!","ATENÇÃO", JOptionPane.WARNING_MESSAGE);

        }
        else if(view.getTxtUnidade().getSelectedItem() == null && view.getTxtTombo().getText().trim().isEmpty() && view.getTxtSerie().getText().trim().isEmpty())
        {

            JOptionPane.showMessageDialog(null, "Combobox unidade, campos tombo e serie vazios preencha-os!","ATENÇÃO", JOptionPane.WARNING_MESSAGE);

        }
        else if(view.getTxtTipoEquip().getSelectedItem() == null)
        {

            JOptionPane.showMessageDialog(null, "Combobox tipo equip esta vazio preencha-o!","ATENÇÃO", JOptionPane.WARNING_MESSAGE);

        } 
        else if(view.getTxtFornecedor().getSelectedItem() == null)
        {
            
            JOptionPane.showMessageDialog(null, "Campo fornecedor esta vazio preencha-o!","ATENÇÃO", JOptionPane.WARNING_MESSAGE);            
            
        }    
        else if(view.getTxtFabricante().getSelectedItem() == null)
        {
            
            JOptionPane.showMessageDialog(null, "Combobox fabricante esta vazio preencha-o!","ATENÇÃO", JOptionPane.WARNING_MESSAGE);            
            
        }         
        else if(view.getTxtModelo().getText().trim().isEmpty())
        {
            
            JOptionPane.showMessageDialog(null, "Campo modelo esta vazio preencha-o!","ATENÇÃO", JOptionPane.WARNING_MESSAGE);            
            
        }  
        else if(view.getTxtStatus().getSelectedIndex() == 0)
        {
            
            JOptionPane.showMessageDialog(null, "Combobox status esta vazio preencha-o!","ATENÇÃO", JOptionPane.WARNING_MESSAGE);            
            
        } 
        else if(view.getTxtEquipamento().getSelectedIndex() == 0)
        {
            
            JOptionPane.showMessageDialog(null, "Campo equipamento esta vazio preencha-o!","ATENÇÃO", JOptionPane.WARNING_MESSAGE);            
            
        }  
        
            //pega um equipamento da view
            Equipamento equipamento = new Equipamento();
            
            //chama helper metodo obterModelo passando equipamento como parametro
            equipamento = helper.obterModelo();
                
            try
            {
                
                //cria objeto do tipo connection conexao passando novo Conexao(conexao.java) chamando metodo conectar
                Connection conexao = new Conexao().Conectar();
                //cria objeto do tipo EquipamentoDAO chamado equipamentoDAO passando novo EquipamentoDAO recebendo conexao
                EquipamentoDAO equipamentoDAO = new EquipamentoDAO(conexao);
                //equipamentoDAO chama metodo deletar passando equipamento
                equipamentoDAO.deletar(equipamento);  
            
                //helper chama o metodo bloquear campos
                helper.bloquearCampos();            
            
                //helper chama metodo limpar tela(Campos)
                helper.limparTela();    
            
                //chama tabelaEquipamentos;
                tabelaEquipamentos();             
            
                JOptionPane.showMessageDialog(null, "Equipamento deletado com sucesso!");                
                
            }
            catch(SQLException ex)
            {
                
                JOptionPane.showMessageDialog(null, "Error ao deletar equipamento no banco de dados! /nError:"+ex);
                
            }               
        
    }
    
    //metodo para selecionar todos equipamentos
    public void selecionarAllEquipamentos()
    {
        
        try
        {
            
                //cria objeto do tipo connection conexao passando novo Conexao(conexao.java) chamando metodo conectar
                Connection conexao = new Conexao().Conectar();
                
                //cria objeto do tipo EquipamentoDAO chamado equipamentoDAO passando novo EquipamentoDAO recebendo conexao
                EquipamentoDAO equipamentoDAO = new EquipamentoDAO(conexao);

                //arraylist equipamentos recebe equipamentoDAO chamando metodo selecioneAllEquipamento
                ArrayList equipamentos = equipamentoDAO.selecioneAllEquipamento();
            
                //helper chama o metodo bloquear campos
                helper.bloquearCampos();            
            
                //helper chama metodo limpar tela(Campos)
                helper.limparTela();    
            
                //chama tabelaEquipamentos;
                tabelaEquipamentos();                           
            
        }
        catch(SQLException ex)
        {
            
            JOptionPane.showMessageDialog(null, "Error ao pesquisar todos equipamentos!" + ex);
            
        }    
        
    }    
    
    //metodo para selecionar todos tombos de equipamentos
    public void selecionarAllEquipTombos()
    {
        
        try
        {
            
                //cria objeto do tipo connection conexao passando novo Conexao(conexao.java) chamando metodo conectar
                Connection conexao = new Conexao().Conectar();
                
                //cria objeto do tipo EquipamentoDAO chamado equipamentoDAO passando novo EquipamentoDAO recebendo conexao
                EquipamentoDAO equipamentoDAO = new EquipamentoDAO(conexao);

                //arraylist equipamentos recebe equipamentoDAO chamando metodo selecioneAllEquipamentoTombo
                ArrayList equipamentos = equipamentoDAO.selecioneAllEquipamentoTombo();
            
                //helper chama o metodo bloquear campos
                helper.bloquearCampos();            
            
                //helper chama metodo limpar tela(Campos)
                helper.limparTela();    
            
                //chama tabelaEquipamentosTombo;
                //tabelaEquipamentosTombo();                           
            
        }
        catch(SQLException ex)
        {
            
            JOptionPane.showMessageDialog(null, "Error ao pesquisar todos tombos por equipamentos!" + ex);
            
        }      
        
    }        

    //metodo para selecionar todos equipamentos por Unidade
    public void selecionarAllEquipPorUnidade(String unidadenome)
    {
        
        try
        {
            
            //cria objeto do tipo connection conexao passando novo Conexao(conexao.java) chamando metodo conectar
            Connection conexao = new Conexao().Conectar();
            
            //cria objeto do tipo EquipamentoDAO chama equipamentoDAO passando novo EquipamentoDAO recebendo conexao
            EquipamentoDAO equipamentoDAO = new EquipamentoDAO(conexao);
            
            //arraylist equipamentos recebe equipamentoDAO chamando metodo selecionarAllEquipPorUnidade passando unidadenome
            ArrayList equipamentos = equipamentoDAO.selecionarAllEquipPorUnidade(unidadenome);
            
            //helper chama o metodo bloquear campos
            helper.bloquearCampos();            
            
            //helper chama metodo limpar tela(Campos)
            helper.limparTela();    
            
            //chama tabelaEquipamentosporUnidade;
            tabelaEquipamentosporUnidade(unidadenome);                
            
        }
        catch(SQLException ex)
        {
            
            JOptionPane.showMessageDialog(null, "Error ao pesquisar todos equipamentos por unidade!" + ex);
            
        }    
        
    }   
    
    //metodo para selecionar todos equipamentos por tipoEquipamento
    public void selecionarAllEquipPorTipoEquipamento(String tipoequipamentonome)
    {
        
        try
        {
            
            //cria objeto do tipo connection conexao passando novo Conexao(conexao.java) chamando metodo conectar
            Connection conexao = new Conexao().Conectar();
            
            //cria objeto do tipo EquipamentoDAO chama equipamentoDAO passando novo EquipamentoDAO recebendo conexao
            EquipamentoDAO equipamentoDAO = new EquipamentoDAO(conexao);
            
            //arraylist equipamentos recebe equipamentoDAO chamando metodo selecionarAllEquipPorTipoEquip passando tipoequipamentonome
            ArrayList equipamentos = equipamentoDAO.selecionarAllEquipPorTipoEquip(tipoequipamentonome);
            
            //helper chama o metodo bloquear campos
            helper.bloquearCampos();            
            
            //helper chama metodo limpar tela(Campos)
            helper.limparTela();    
            
            //chama tabelaEquipamentosporTipoEquip;
            tabelaEquipamentosporTipoEquip(tipoequipamentonome);                
            
        }
        catch(SQLException ex)
        {
            
            JOptionPane.showMessageDialog(null, "Error ao pesquisar todos equipamentos por tipo equipamento!" + ex);
            
        }    
        
    }       
    
    //metodo para selecionar todos equipamentos por fornecedor
    public void selecionarAllEquipPorFornecedor(String fornecedor)
    {
        
        try
        {
            
            //cria objeto do tipo connection conexao passando novo Conexao(conexao.java) chamando metodo conectar
            Connection conexao = new Conexao().Conectar();
            
            //cria objeto do tipo EquipamentoDAO chama equipamentoDAO passando novo EquipamentoDAO recebendo conexao
            EquipamentoDAO equipamentoDAO = new EquipamentoDAO(conexao);
            
            //arraylist equipamentos recebe equipamentoDAO chamando metodo selecionarAllEquipPorFornecedor passando fornecedor
            ArrayList equipamentos = equipamentoDAO.selecionarAllEquipPorFornecedor(fornecedor);
            
            //helper chama o metodo bloquear campos
            helper.bloquearCampos();            
            
            //helper chama metodo limpar tela(Campos)
            helper.limparTela();    
            
            //chama tabelaEquipamentosporFornecedor;
            tabelaEquipamentosporFornecedor(fornecedor);                
            
        }
        catch(SQLException ex)
        {
            
            JOptionPane.showMessageDialog(null, "Error ao pesquisar todos equipamentos por fornecedor!" + ex);
            
        }    
        
    }     
    
    //metodo para selecionar todos equipamentos por status
    public void selecionarAllEquipPorStatus(String status)
    {
        
        try
        {
            
            //cria objeto do tipo connection conexao passando novo Conexao(conexao.java) chamando metodo conectar
            Connection conexao = new Conexao().Conectar();
            
            //cria objeto do tipo EquipamentoDAO chama equipamentoDAO passando novo EquipamentoDAO recebendo conexao
            EquipamentoDAO equipamentoDAO = new EquipamentoDAO(conexao);
            
            //arraylist equipamentos recebe equipamentoDAO chamando metodo selecionarAllEquipPorStatus passando status
            ArrayList equipamentos = equipamentoDAO.selecionarAllEquipPorStatus(status);
            
            //helper chama o metodo bloquear campos
            helper.bloquearCampos();            
            
            //helper chama metodo limpar tela(Campos)
            helper.limparTela();    
            
            //chama tabelaEquipamentoporStatus;
            tabelaEquipamentosporStatus(status);                
            
        }
        catch(SQLException ex)
        {
            
            JOptionPane.showMessageDialog(null, "Error ao pesquisar todos equipamentos por status!" + ex);
            
        }    
        
    }           
    
    //metodo para selecionar todos equipamentos por alugado
    public void selecionarAllEquipPorAlugado(String alugado) 
    {
        
        try
        {
            
            //cria objeto do tipo connection conexao passando novo Conexao(conexao.java) chamando metodo conectar
            Connection conexao = new Conexao().Conectar();
            
            //cria objeto do tipo EquipamentoDAO chama equipamentoDAO passando novo EquipamentoDAO recebendo conexao
            EquipamentoDAO equipamentoDAO = new EquipamentoDAO(conexao);
            
            //arraylist equipamentos recebe equipamentoDAO chamando metodo selecionarAllEquipPorAlugado passando alugado
            ArrayList equipamentos = equipamentoDAO.selecionarAllEquipPorAlugado(alugado);
            
            //helper chama o metodo bloquear campos
            helper.bloquearCampos();            
            
            //helper chama metodo limpar tela(Campos)
            helper.limparTela();               
            
            //chama tabelaEquipamentosporEquipamento;
            tabelaEquipamentosporAlugado(alugado);           
            
        }
        catch(SQLException ex)
        {
            
            JOptionPane.showMessageDialog(null, "Error ao pesquisar todos equipamentos por alugado!" + ex);
            
        }    
        
    }    
    
    //metodo para selecionar todos equipamentos por patrimonio
    public void selecionarAllEquipPorPatrimonio(String patrimonio) 
    {
        
        try
        {
            
            //cria objeto do tipo connection conexao passando novo Conexao(conexao.java) chamando metodo conectar
            Connection conexao = new Conexao().Conectar();
            
            //cria objeto do tipo EquipamentoDAO chama equipamentoDAO passando novo EquipamentoDAO recebendo conexao
            EquipamentoDAO equipamentoDAO = new EquipamentoDAO(conexao);
            
            //arraylist equipamentos recebe equipamentoDAO chamando metodo selecionarAllEquipPorPatrimonio passando patrimonio
            ArrayList equipamentos = equipamentoDAO.selecionarAllEquipPorPatrimonio(patrimonio);
            
            //helper chama o metodo bloquear campos
            helper.bloquearCampos();            
            
            //helper chama metodo limpar tela(Campos)
            helper.limparTela();               
            
            //chama tabelaEquipamentosporPatrimonio;
            tabelaEquipamentosporPatrimonio(patrimonio);           
            
        }
        catch(SQLException ex)
        {
            
            JOptionPane.showMessageDialog(null, "Error ao pesquisar todos equipamentos por patrimonio!" + ex);
            
        }         
        
    }    

    //metodo para selecionar todos equipamentos por conveinio
    public void selecionarAllEquipPorConvenio(String convenio)
    {
        
        try
        {
            
            //cria objeto do tipo connection conexao passando novo Conexao(conexao.java) chamando metodo conectar
            Connection conexao = new Conexao().Conectar();
            
            //cria objeto do tipo EquipamentoDAO chama equipamentoDAO passando novo EquipamentoDAO recebendo conexao
            EquipamentoDAO equipamentoDAO = new EquipamentoDAO(conexao);
            
            //arraylist equipamentos recebe equipamentoDAO chamando metodo selecionarAllEquipPorConvenio passando convenio
            ArrayList equipamentos = equipamentoDAO.selecionarAllEquipPorConvenio(convenio);
            
            //helper chama o metodo bloquear campos
            helper.bloquearCampos();            
            
            //helper chama metodo limpar tela(Campos)
            helper.limparTela();               
            
            //chama tabelaEquipamentosporConvenio
            tabelaEquipamentosporConvenio(convenio);           
            
        }
        catch(SQLException ex)
        {
            
            JOptionPane.showMessageDialog(null, "Error ao pesquisar todos equipamentos por convenio!" + ex);
            
        }                 
        
    }    
    
    //metodo tabelaEquipamentos
    public void tabelaEquipamentos()
    {
        
        //se a view a tabela for diferente de nulo
        if(view.jTabelaCadEquip != null)
        {
            
            //modelo do tipo defaultablemodel recebe convertendo para defaulttablemodel a view passando a tabela e pegando seu modelo
            DefaultTableModel modelo = (DefaultTableModel) view.jTabelaCadEquip.getModel();
            
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
                //cria objeto do tipo EquipamentoDAO chamado equipamentoDAO passando novo EquipamentoDAO recebendo conexao
                EquipamentoDAO equipamentoDAO = new EquipamentoDAO(conexao);
                
                //equipamentos do tipo arraylist do tipo Equipamento recebe equipamentoDAO chamando metodo selecione todos equipamentos
                ArrayList<Equipamento> equipamentos = equipamentoDAO.selecioneAllEquipamento();
                
                //para cada equipamento no arraylist equipamentos
                for(Equipamento equipamento : equipamentos)
                {
                    
                    //quantidade de linhas que o objeto vai ter
                    Object[] linha = new Object[11];
                    
                    //pegue as respectivas linhas de cada equipamento e as sete
                    linha[0] = equipamento.getId();
                    linha[1] = equipamento.getUnidade().getUnidadenome();
                    linha[2] = equipamento.getTipoequip().getTipoequipamento();
                    linha[3] = equipamento.getTombo();
                    linha[4] = equipamento.getSerie();
                    linha[5] = equipamento.getFornecedor().getFornecedornome();
                    linha[6] = equipamento.getFabricante().getFabricantenome();
                    linha[7] = equipamento.getModelo();
                    linha[8] = equipamento.getStatus();
                    linha[9] = equipamento.getEquipamento();
                    linha[10] = equipamento.getObservacao();
                    
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
    
    //metodo tabelaEquipamentos por unidade
    public void tabelaEquipamentosporUnidade(String unidadenome)
    {
        
        //se a view a tabela for diferente de nulo
        if(view.jTabelaCadEquip != null)
        {
            
            //modelo do tipo defaultablemodel recebe convertendo para defaulttablemodel a view passando a tabela e pegando seu modelo
            DefaultTableModel modelo = (DefaultTableModel) view.jTabelaCadEquip.getModel();
            
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
                //cria objeto do tipo EquipamentoDAO chamado equipamentoDAO passando novo EquipamentoDAO recebendo conexao
                EquipamentoDAO equipamentoDAO = new EquipamentoDAO(conexao);
                
                //arraylist equipamentos recebe equipamentoDAO chamando metodo selecionarAllEquipPorUnidade passando unidadenome
                ArrayList<Equipamento> equipamentos = equipamentoDAO.selecionarAllEquipPorUnidade(unidadenome);
                
                //para cada equipamento no arraylist equipamentos
                for(Equipamento equipamento : equipamentos)
                {
                    
                    //quantidade de linhas que o objeto vai ter
                    Object[] linha = new Object[11];
                    
                    //pegue as respectivas linhas de cada equipamento e as sete
                    linha[0] = equipamento.getId();
                    linha[1] = equipamento.getUnidade().getUnidadenome();
                    linha[2] = equipamento.getTipoequip().getTipoequipamento();
                    linha[3] = equipamento.getTombo();
                    linha[4] = equipamento.getSerie();
                    linha[5] = equipamento.getFornecedor().getFornecedornome();
                    linha[6] = equipamento.getFabricante().getFabricantenome();
                    linha[7] = equipamento.getModelo();
                    linha[8] = equipamento.getStatus();
                    linha[9] = equipamento.getEquipamento();
                    linha[10] = equipamento.getObservacao();
                    
                    //adicione as linhas ao modelo
                    modelo.addRow(linha);                                        
                    
                }    
                
            }    
           
            catch(SQLException ex)
            {
                
                JOptionPane.showMessageDialog(null, "Error ao preencher tabela por unidade!" + ex);
                
            }               
            
        }    
        
    }    
    
    //metodo tabelaEquipamentos por tipoequipamento
    public void tabelaEquipamentosporTipoEquip(String tipoequipamentonome)
    {
        
        //se a view a tabela for diferente de nulo
        if(view.jTabelaCadEquip != null)
        {
            
            //modelo do tipo defaultablemodel recebe convertendo para defaulttablemodel a view passando a tabela e pegando seu modelo
            DefaultTableModel modelo = (DefaultTableModel) view.jTabelaCadEquip.getModel();
            
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
                //cria objeto do tipo EquipamentoDAO chamado equipamentoDAO passando novo EquipamentoDAO recebendo conexao
                EquipamentoDAO equipamentoDAO = new EquipamentoDAO(conexao);
                
                //arraylist equipamentos recebe equipamentoDAO chamando metodo .selecionarAllEquipPorTipoEquip passando tipoequipamentonome;
                ArrayList<Equipamento> equipamentos = equipamentoDAO.selecionarAllEquipPorTipoEquip(tipoequipamentonome);
                
                //para cada equipamento no arraylist equipamentos
                for(Equipamento equipamento : equipamentos)
                {
                    
                    //quantidade de linhas que o objeto vai ter
                    Object[] linha = new Object[11];
                    
                    //pegue as respectivas linhas de cada equipamento e as sete
                    linha[0] = equipamento.getId();
                    linha[1] = equipamento.getUnidade().getUnidadenome();
                    linha[2] = equipamento.getTipoequip().getTipoequipamento();
                    linha[3] = equipamento.getTombo();
                    linha[4] = equipamento.getSerie();
                    linha[5] = equipamento.getFornecedor().getFornecedornome();
                    linha[6] = equipamento.getFabricante().getFabricantenome();
                    linha[7] = equipamento.getModelo();
                    linha[8] = equipamento.getStatus();
                    linha[9] = equipamento.getEquipamento();
                    linha[10] = equipamento.getObservacao();
                    
                    //adicione as linhas ao modelo
                    modelo.addRow(linha);                                        
                    
                }    
                
            }    
           
            catch(SQLException ex)
            {
                
                JOptionPane.showMessageDialog(null, "Error ao preencher tabela por tipo equipamento!" + ex);
                
            }               
            
        }    
        
    }            

    private void tabelaEquipamentosporFornecedor(String fornecedor)
    {
        
        //se a view a tabela for diferente de nulo
        if(view.jTabelaCadEquip != null)
        {
            
            //modelo do tipo defaultablemodel recebe convertendo para defaulttablemodel a view passando a tabela e pegando seu modelo
            DefaultTableModel modelo = (DefaultTableModel) view.jTabelaCadEquip.getModel();
            
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
                //cria objeto do tipo EquipamentoDAO chamado equipamentoDAO passando novo EquipamentoDAO recebendo conexao
                EquipamentoDAO equipamentoDAO = new EquipamentoDAO(conexao);
                
                //arraylist equipamentos recebe equipamentoDAO chamando metodo .selecionarAllEquipPorFornecedor passando fornecedor;
                ArrayList<Equipamento> equipamentos = equipamentoDAO.selecionarAllEquipPorFornecedor(fornecedor);
                
                //para cada equipamento no arraylist equipamentos
                for(Equipamento equipamento : equipamentos)
                {
                    
                    //quantidade de linhas que o objeto vai ter
                    Object[] linha = new Object[11];
                    
                    //pegue as respectivas linhas de cada equipamento e as sete
                    linha[0] = equipamento.getId();
                    linha[1] = equipamento.getUnidade().getUnidadenome();
                    linha[2] = equipamento.getTipoequip().getTipoequipamento();
                    linha[3] = equipamento.getTombo();
                    linha[4] = equipamento.getSerie();
                    linha[5] = equipamento.getFornecedor().getFornecedornome();
                    linha[6] = equipamento.getFabricante().getFabricantenome();
                    linha[7] = equipamento.getModelo();
                    linha[8] = equipamento.getStatus();
                    linha[9] = equipamento.getEquipamento();
                    linha[10] = equipamento.getObservacao();
                    
                    //adicione as linhas ao modelo
                    modelo.addRow(linha);                                        
                    
                }    
                
            }    
           
            catch(SQLException ex)
            {
                
                JOptionPane.showMessageDialog(null, "Error ao preencher tabela por fornecedor!" + ex);
                
            }               
            
        }            
        
    }    
    
    //metodo tabelaEquipamentos por status
    public void tabelaEquipamentosporStatus(String status)
    {
        
        //se a view a tabela for diferente de nulo
        if(view.jTabelaCadEquip != null)
        {
            
            //modelo do tipo defaultablemodel recebe convertendo para defaulttablemodel a view passando a tabela e pegando seu modelo
            DefaultTableModel modelo = (DefaultTableModel) view.jTabelaCadEquip.getModel();
            
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
                //cria objeto do tipo EquipamentoDAO chamado equipamentoDAO passando novo EquipamentoDAO recebendo conexao
                EquipamentoDAO equipamentoDAO = new EquipamentoDAO(conexao);
                
                //arraylist equipamentos recebe equipamentoDAO chamando metodo .selecionarAllEquipPorStatus passando status;
                ArrayList<Equipamento> equipamentos = equipamentoDAO.selecionarAllEquipPorStatus(status);
                
                //para cada equipamento no arraylist equipamentos
                for(Equipamento equipamento : equipamentos)
                {
                    
                    //quantidade de linhas que o objeto vai ter
                    Object[] linha = new Object[11];
                    
                    //pegue as respectivas linhas de cada equipamento e as sete
                    linha[0] = equipamento.getId();
                    linha[1] = equipamento.getUnidade().getUnidadenome();
                    linha[2] = equipamento.getTipoequip().getTipoequipamento();
                    linha[3] = equipamento.getTombo();
                    linha[4] = equipamento.getSerie();
                    linha[5] = equipamento.getFornecedor().getFornecedornome();
                    linha[6] = equipamento.getFabricante().getFabricantenome();
                    linha[7] = equipamento.getModelo();
                    linha[8] = equipamento.getStatus();
                    linha[9] = equipamento.getEquipamento();
                    linha[10] = equipamento.getObservacao();
                    
                    //adicione as linhas ao modelo
                    modelo.addRow(linha);                                        
                    
                }    
                
            }    
           
            catch(SQLException ex)
            {
                
                JOptionPane.showMessageDialog(null, "Error ao preencher tabela por status!" + ex);
                
            }               
            
        }    
        
    }            

    //metodo tabelaEquipamentos por alugado
    public void tabelaEquipamentosporAlugado(String alugado)
    {
        
        //se a view a tabela for diferente de nulo
        if(view.jTabelaCadEquip != null)
        {
            
            //modelo do tipo defaultablemodel recebe convertendo para defaulttablemodel a view passando a tabela e pegando seu modelo
            DefaultTableModel modelo = (DefaultTableModel) view.jTabelaCadEquip.getModel();
            
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
                //cria objeto do tipo EquipamentoDAO chamado equipamentoDAO passando novo EquipamentoDAO recebendo conexao
                EquipamentoDAO equipamentoDAO = new EquipamentoDAO(conexao);
                
                //arraylist equipamentos recebe equipamentoDAO chamando metodo .selecionarAllEquipPorAlugado passando alugado;
                ArrayList<Equipamento> equipamentos = equipamentoDAO.selecionarAllEquipPorAlugado(alugado);
                
                //para cada equipamento no arraylist equipamentos
                for(Equipamento equipamento : equipamentos)
                {
                    
                    //quantidade de linhas que o objeto vai ter
                    Object[] linha = new Object[11];
                    
                    //pegue as respectivas linhas de cada equipamento e as sete
                    linha[0] = equipamento.getId();
                    linha[1] = equipamento.getUnidade().getUnidadenome();
                    linha[2] = equipamento.getTipoequip().getTipoequipamento();
                    linha[3] = equipamento.getTombo();
                    linha[4] = equipamento.getSerie();
                    linha[5] = equipamento.getFornecedor().getFornecedornome();
                    linha[6] = equipamento.getFabricante().getFabricantenome();
                    linha[7] = equipamento.getModelo();
                    linha[8] = equipamento.getStatus();
                    linha[9] = equipamento.getEquipamento();
                    linha[10] = equipamento.getObservacao();
                    
                    //adicione as linhas ao modelo
                    modelo.addRow(linha);                                        
                    
                }    
                
            }    
           
            catch(SQLException ex)
            {
                
                JOptionPane.showMessageDialog(null, "Error ao preencher tabela por equipamento alugado!" + ex);
                
            }               
            
        }    
        
    }         
    
    //metodo tabelaEquipamentos por patrimonio
    public void tabelaEquipamentosporPatrimonio(String patrimonio)
    {
        
        //se a view a tabela for diferente de nulo
        if(view.jTabelaCadEquip != null)
        {
            
            //modelo do tipo defaultablemodel recebe convertendo para defaulttablemodel a view passando a tabela e pegando seu modelo
            DefaultTableModel modelo = (DefaultTableModel) view.jTabelaCadEquip.getModel();
            
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
                //cria objeto do tipo EquipamentoDAO chamado equipamentoDAO passando novo EquipamentoDAO recebendo conexao
                EquipamentoDAO equipamentoDAO = new EquipamentoDAO(conexao);
                
                //arraylist equipamentos recebe equipamentoDAO chamando metodo .selecionarAllEquipPorPatrimonio passando patrimonio;
                ArrayList<Equipamento> equipamentos = equipamentoDAO.selecionarAllEquipPorPatrimonio(patrimonio);
                
                //para cada equipamento no arraylist equipamentos
                for(Equipamento equipamento : equipamentos)
                {
                    
                    //quantidade de linhas que o objeto vai ter
                    Object[] linha = new Object[11];
                    
                    //pegue as respectivas linhas de cada equipamento e as sete
                    linha[0] = equipamento.getId();
                    linha[1] = equipamento.getUnidade().getUnidadenome();
                    linha[2] = equipamento.getTipoequip().getTipoequipamento();
                    linha[3] = equipamento.getTombo();
                    linha[4] = equipamento.getSerie();
                    linha[5] = equipamento.getFornecedor().getFornecedornome();
                    linha[6] = equipamento.getFabricante().getFabricantenome();
                    linha[7] = equipamento.getModelo();
                    linha[8] = equipamento.getStatus();
                    linha[9] = equipamento.getEquipamento();
                    linha[10] = equipamento.getObservacao();
                    
                    //adicione as linhas ao modelo
                    modelo.addRow(linha);                                        
                    
                }    
                
            }    
           
            catch(SQLException ex)
            {
                
                JOptionPane.showMessageDialog(null, "Error ao preencher tabela por equipamento patrimonio!" + ex);
                
            }               
            
        }    
        
    }     
    
    //metodo tabelaEquipamentos por patrimonio
    private void tabelaEquipamentosporConvenio(String convenio)
    {
        
        //se a view a tabela for diferente de nulo
        if(view.jTabelaCadEquip != null)
        {
            
            //modelo do tipo defaultablemodel recebe convertendo para defaulttablemodel a view passando a tabela e pegando seu modelo
            DefaultTableModel modelo = (DefaultTableModel) view.jTabelaCadEquip.getModel();
            
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
                //cria objeto do tipo EquipamentoDAO chamado equipamentoDAO passando novo EquipamentoDAO recebendo conexao
                EquipamentoDAO equipamentoDAO = new EquipamentoDAO(conexao);
                
                //arraylist equipamentos recebe equipamentoDAO chamando metodo .selecionarAllEquipPorConvenio passando convenio;
                ArrayList<Equipamento> equipamentos = equipamentoDAO.selecionarAllEquipPorConvenio(convenio);
                
                //para cada equipamento no arraylist equipamentos
                for(Equipamento equipamento : equipamentos)
                {
                    
                    //quantidade de linhas que o objeto vai ter
                    Object[] linha = new Object[11];
                    
                    //pegue as respectivas linhas de cada equipamento e as sete
                    linha[0] = equipamento.getId();
                    linha[1] = equipamento.getUnidade().getUnidadenome();
                    linha[2] = equipamento.getTipoequip().getTipoequipamento();
                    linha[3] = equipamento.getTombo();
                    linha[4] = equipamento.getSerie();
                    linha[5] = equipamento.getFornecedor().getFornecedornome();
                    linha[6] = equipamento.getFabricante().getFabricantenome();
                    linha[7] = equipamento.getModelo();
                    linha[8] = equipamento.getStatus();
                    linha[9] = equipamento.getEquipamento();
                    linha[10] = equipamento.getObservacao();
                    
                    //adicione as linhas ao modelo
                    modelo.addRow(linha);                                        
                    
                }    
                
            }    
           
            catch(SQLException ex)
            {
                
                JOptionPane.showMessageDialog(null, "Error ao preencher tabela por equipamento convenio!" + ex);
                
            }               
            
        }            
        
    }    
    
 public void atualizaUnidade()
 {
     
     try
     {
         
         //buscar unidade no banco de dados
         
            //cria objeto do tipo connection conexao passando novo Conexao(conexao.java) chamando metodo conectar
            Connection conexao = new Conexao().Conectar();  
            
            //cria objeto do tipo UnidadeDAO unidadedao passando UnidadeDAO recebendo conexao
            UnidadeDAO unidadedao = new UnidadeDAO(conexao);
            
            //cria arraylist de unidade chamado unidades passando o objeto unidadedao do tipo Unidade chamando o metodo selecioneAllUnidade
            ArrayList<Unidade> unidades = unidadedao.selecioneAllUnidade();
         
            DefaultComboBoxModel combomodel = (DefaultComboBoxModel) view.getTxtUnidade().getModel();
            
            combomodel.removeAllElements();
            
            for(Unidade unidade : unidades)
            {
                
                combomodel.addElement(unidade);
                
            }    
     }
     catch(SQLException ex)
     {
         
         JOptionPane.showMessageDialog(null,"Error a preencher combobox unidade:" +ex);
         
     }    
     
 }    
 
 public void atualizaTipoEquipamento()
 {
     
     try
     {
         
         //buscar unidade no banco de dados
         
            //cria objeto do tipo connection conexao passando novo Conexao(conexao.java) chamando metodo conectar
            Connection conexao = new Conexao().Conectar();  
            
            //cria objeto do tipo TipoEquipamentoDAO tipoequipamentodao passando TipoEquipamentoDAO recebendo conexao
            TipoEquipamentoDAO tipoequipamentodao = new TipoEquipamentoDAO(conexao);
            
            //cria arraylist de tipoequipamento chamado tipoequipamentos passando o objeto tipoequipamentodao do tipo TipoEquipamento chamando o metodo selecioneAllTipoEquipamento
            ArrayList<TipoEquipamento> tipoequipamentos = tipoequipamentodao.selecioneAllTipoEquipamento();
         
            DefaultComboBoxModel combomodel = (DefaultComboBoxModel) view.getTxtTipoEquip().getModel();
            
            combomodel.removeAllElements();            
            
            for(TipoEquipamento tipoequipamento : tipoequipamentos)
            {
                
                combomodel.addElement(tipoequipamento);
                
            }    
     }
     catch(SQLException ex)
     {
         
         JOptionPane.showMessageDialog(null,"Error a preencher combobox tipo equipamento:" +ex);
         
     }    
     
 }  

  public void atualizaFornecedor()
 {
     
     try
     {
         
         //buscar fornecedor no banco de dados
         
            //cria objeto do tipo connection conexao passando novo Conexao(conexao.java) chamando metodo conectar
            Connection conexao = new Conexao().Conectar();  
            
            //cria objeto do tipo FornecedorDAO fornecedorDAO passando FornecedorDAO recebendo conexao
            FornecedorDAO fornecedorDAO = new FornecedorDAO(conexao);
            
            //cria arraylist de fornecedor chamado fornecedores passando o objeto fornecedorDAO do tipo Fornecedor chamando o metodo selecioneAllFornecedor
            ArrayList<Fornecedor> fornecedores = fornecedorDAO.selecioneAllFornecedor();
         
            DefaultComboBoxModel combomodel = (DefaultComboBoxModel) view.getTxtFornecedor().getModel();
            
            combomodel.removeAllElements();            
            
            for(Fornecedor fornecedor : fornecedores)
            {
                
                combomodel.addElement(fornecedor);
                
            }    
     }
     catch(SQLException ex)
     {
         
         JOptionPane.showMessageDialog(null,"Error a preencher combobox fornecedor:" +ex);
         
     }    
     
 }    
  
  public void atualizaFornecedorPesquisa()
 {
     
     try
     {
         
         //buscar fornecedor no banco de dados
         
            //cria objeto do tipo connection conexao passando novo Conexao(conexao.java) chamando metodo conectar
            Connection conexao = new Conexao().Conectar();  
            
            //cria objeto do tipo FornecedorDAO fornecedorDAO passando FornecedorDAO recebendo conexao
            FornecedorDAO fornecedorDAO = new FornecedorDAO(conexao);
            
            //cria arraylist de fornecedor chamado fornecedores passando o objeto fornecedorDAO do tipo Fornecedor chamando o metodo selecioneAllFornecedor
            ArrayList<Fornecedor> fornecedores = fornecedorDAO.selecioneAllFornecedor();
         
            DefaultComboBoxModel combomodel = (DefaultComboBoxModel) view.getTxtCampo().getModel();
            
            combomodel.removeAllElements();            
            
            for(Fornecedor fornecedor : fornecedores)
            {
                
                combomodel.addElement(fornecedor);
                
            }    
     }
     catch(SQLException ex)
     {
         
         JOptionPane.showMessageDialog(null,"Error a preencher combobox fornecedor:" +ex);
         
     }   
  
 }     
    public void atualizarFabricante() 
    {
     
     try
     {
         
         //buscar fabricante no banco de dados
         
            //cria objeto do tipo connection conexao passando novo Conexao(conexao.java) chamando metodo conectar
            Connection conexao = new Conexao().Conectar();  
            
            //cria objeto do tipo FabricanteDAO fabricantedao passando FabricanteDAO recebendo conexao
            FabricanteDAO fabricantedao = new FabricanteDAO(conexao);
            
            //cria arraylist de fabricante chamado fabricantes passando o objeto fabricantedao do tipo Fabricante chamando o metodo selecioneAllFabricante
            ArrayList<Fabricante> fabricantes = fabricantedao.selecioneAllFabricante();
         
            DefaultComboBoxModel combomodel = (DefaultComboBoxModel) view.getTxtFabricante().getModel();
            
            combomodel.removeAllElements();            
            
            for(Fabricante fabricante : fabricantes)
            {
                
                combomodel.addElement(fabricante);
                
            }    
     }
     catch(SQLException ex)
     {
         
         JOptionPane.showMessageDialog(null,"Error a preencher combobox fabricante:" +ex);
         
     }    
             
    }

    public void atualizaCampoUnidade() 
    {
        
     try
     {
            //buscar unidade no banco de dados
         
            //cria objeto do tipo connection conexao passando novo Conexao(conexao.java) chamando metodo conectar
            Connection conexao = new Conexao().Conectar();  
            
            //cria objeto do tipo UnidadeDAO unidadedao passando UnidadeDAO recebendo conexao
            UnidadeDAO unidadedao = new UnidadeDAO(conexao);
            
            //cria arraylist de unidade chamado unidades passando o objeto unidadedao do tipo Unidade chamando o metodo selecioneAllUnidade
            ArrayList<Unidade> unidades = unidadedao.selecioneAllUnidade();
         
            DefaultComboBoxModel combomodel = (DefaultComboBoxModel) view.getTxtCampo().getModel();
            
            combomodel.removeAllElements();
            
            for(Unidade unidade : unidades)
            {
                
                combomodel.addElement(unidade);
                
            }    
     }
     catch(SQLException ex)
     {
         
         JOptionPane.showMessageDialog(null,"Error a preencher combobox campo:" +ex);
         
     }    
     
    }

    public void atualizarCampoTipoEquip() 
    { 
        
     try
     {
         
            //buscar tipoequipamento no banco de dados
         
            //cria objeto do tipo connection conexao passando novo Conexao(conexao.java) chamando metodo conectar
            Connection conexao = new Conexao().Conectar();  
            
            //cria objeto do tipo TipoEquipamentoDAO tipoequipamentodao passando TipoEquipamentoDAO recebendo conexao
            TipoEquipamentoDAO tipoequipamentodao = new TipoEquipamentoDAO(conexao);
            
            //cria arraylist de tipoequipamento chamado tipoequipamentos passando o objeto tipoequipamentodao do tipo TipoEquipamento chamando o metodo selecioneAllTipoEquipamento
            ArrayList<TipoEquipamento> tipoequipamentos = tipoequipamentodao.selecioneAllTipoEquipamento();
         
            DefaultComboBoxModel combomodel = (DefaultComboBoxModel) view.getTxtCampo().getModel();
            
            combomodel.removeAllElements();            
            
            for(TipoEquipamento tipoequipamento : tipoequipamentos)
            {
                
                combomodel.addElement(tipoequipamento);
                
            }    
     }
     catch(SQLException ex)
     {
         
         JOptionPane.showMessageDialog(null,"Error a preencher combobox tipo equipamento campo:" +ex);
         
     }    
    }
    
    public void atualizarCampoStatus()
    {
        
        try
        {
            
            //cria objeto do tipo connection conexao passando novo Conexao(conexao.java) chamando metodo conectar
            Connection conexao = new Conexao().Conectar();
            
            //cria objeto do tipo EquipamentoDAO chamado equipamentoDAO passando novo EquipamentoDAO recebendo conexao
            EquipamentoDAO equipamentoDAO = new EquipamentoDAO(conexao);
            
            ArrayList<Equipamento> equipamentos  = equipamentoDAO.selecioneStatus();
            
            DefaultComboBoxModel combomodel = (DefaultComboBoxModel) view.getTxtCampo().getModel();
            
            combomodel.removeAllElements();   
            
            for(Equipamento equipamento : equipamentos)
            {
                
                combomodel.addElement(equipamento.StatustoString());
                
            }              
            
        }
        catch(SQLException ex)
        {
            
            JOptionPane.showMessageDialog(null,"Error a preencher combobox status:" +ex);
            
        }    
        
    }        

    public void atualizaCampoEquipamento()
    {
        
        try
        {
            
            //cria objeto do tipo connection conexao passando novo Conexao(conexao.java) chamando metodo conectar
            Connection conexao = new Conexao().Conectar();
            
            //cria objeto do tipo EquipamentoDAO chamado equipamentoDAO passando novo EquipamentoDAO recebendo conexao
            EquipamentoDAO equipamentoDAO = new EquipamentoDAO(conexao);
            
            ArrayList<Equipamento> equipamentos  = equipamentoDAO.selecioneEquipamento();
            
            DefaultComboBoxModel combomodel = (DefaultComboBoxModel) view.getTxtCampo().getModel();
            
            combomodel.removeAllElements();   
            
            for(Equipamento equipamento : equipamentos)
            {
                
                combomodel.addElement(equipamento.EquiptoString());
                
            }              
            
        }
        catch(SQLException ex)
        {
            
            JOptionPane.showMessageDialog(null,"Error a preencher combobox equipamento:" +ex);
            
        }    
        
    }        

}
