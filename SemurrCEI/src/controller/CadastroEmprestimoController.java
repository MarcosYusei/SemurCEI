package controller;

import controller.helper.CadastroEmprestimoHelper;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.DAO.EmprestimoDAO;
import model.DAO.EquipamentoDAO;
import model.DAO.NomeDAO;
import model.DAO.TipoEquipamentoDAO;
import model.DAO.UnidadeDAO;
import model.Emprestimo;
import model.Equipamento;
import model.Nome;
import model.TipoEquipamento;
import model.Unidade;
import view.TelaCadastroEmprestimo;
import view.TelaPrincipal;


public class CadastroEmprestimoController
{
    
    //cria arraylist do tipo Emprestimo chamado emprestimos   
    ArrayList<Emprestimo> emprestimos = new ArrayList<Emprestimo>();    
    
    //cria variavel do tipo telacadastroemprestimo e CadastroEmprestimoHelper e chamando-as de view e helper
    private TelaCadastroEmprestimo view;
    private CadastroEmprestimoHelper helper;    
    
    //cria variavel tipo TelaPrincipal chamada telaprincipal
    public TelaPrincipal TelaPrincipal;  

    //metodo construtor    
    public CadastroEmprestimoController(TelaCadastroEmprestimo view) 
    {
        this.view = view;
        this.helper = new CadastroEmprestimoHelper(view);
    }  
    
    //metodo construtor vazio
    public CadastroEmprestimoController() 
    {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }    
    
    //metodo para efetuar emprestimo
    public void EmprestarEquipamento()
    {
        
        //comparações logicas
        if(view.getTxtUnidade().getSelectedIndex() != 0 && view.getTxtTipoEquip().getSelectedIndex() != 0 && view.getTxtModelo().getSelectedIndex() != 0 && view.getTxtDestino().getSelectedIndex() != 0
        && view.getTxtNome().getSelectedIndex() != 0 && view.getTxtDataSaida().getDate()==null && view.getTxtDataDevolucao().getDate()==null && view.getTxtStatus().getSelectedIndex() != 0 && view.getTxtObservacao().getText().trim().isEmpty()
        && view.getTxtTombo().getSelectedIndex() != 0 && view.getTxtSerie().getSelectedIndex() != 0)
        {
            
            JOptionPane.showMessageDialog(null, "Campos obrigatorios vazios, selecione-os!!","ATENÇÃO", JOptionPane.WARNING_MESSAGE);
            
        }   
        if(view.getTxtUnidade().getSelectedIndex() != 0 && view.getTxtTipoEquip().getSelectedIndex() != 0)
        {    
        
            JOptionPane.showMessageDialog(null, "Campos unidade e/ou tipo equipamento vazio/s, selecione-os","ATENÇÃO", JOptionPane.WARNING_MESSAGE);
            
        }
        if(view.getTxtDestino().getSelectedIndex() != 0 && view.getTxtModelo().getSelectedIndex() != 0)
        {    
        
            JOptionPane.showMessageDialog(null, "Campos destino e/ou modelo vazio/s, selecione-os","ATENÇÃO", JOptionPane.WARNING_MESSAGE);
            
        }       
        if(view.getTxtDataSaida().getDate()==null && view.getTxtDataDevolucao().getDate()==null)
        {    
        
            JOptionPane.showMessageDialog(null, "Campos data saida e/ou data devolucão vazio/s, selecione-os","ATENÇÃO", JOptionPane.WARNING_MESSAGE);
            
        }     
        if(view.getTxtStatus().getSelectedIndex() == 0)
        {    
        
            JOptionPane.showMessageDialog(null, "Campo status vazio, selecione-os","ATENÇÃO", JOptionPane.WARNING_MESSAGE);
            
        }    
        if(view.getTxtTipo().getSelectedIndex() != 0)
        {    
        
            JOptionPane.showMessageDialog(null, "Campo tipo vazio, selecione-os","ATENÇÃO", JOptionPane.WARNING_MESSAGE);
            
        }       
        if(view.getTxtTombo().getSelectedIndex() != 0 && view.getTxtSerie().getSelectedIndex() != 0)
        {    
        
            JOptionPane.showMessageDialog(null, "Campo tombo e/serie vazios, selecione-os","ATENÇÃO", JOptionPane.WARNING_MESSAGE);
            
        }
        
            //compara se todos os campos foram preenchidos
            if(view.getTxtUnidade().getSelectedItem() != null && view.getTxtTipoEquip().getSelectedItem() != null && view.getTxtModelo().getSelectedItem() != null
            && view.getTxtDestino().getSelectedItem() != null && view.getTxtNome().getSelectedItem() != null && view.getTxtDataSaida().getDate() != null && view.getTxtDataDevolucao().getDate() != null
            && view.getTxtStatus().getSelectedItem() != null && view.getTxtTipo().getSelectedItem() != null && view.getTxtTombo().getSelectedItem() != null & view.getTxtSerie().getSelectedItem() != null)
            {
                    
                    //pega um emprestimo da view Emprestimo
                    Emprestimo emprestimo = helper.obterModeloSemID();
                    
                    try
                    {
                        
                        String equipamentoU = emprestimo.modelo;
                        
                        //verifica se existe no banco de dados
                        //cria objeto do tipo connection conexao passando novo Conexao(conexao.java) chamando metodo conectar
                        Connection conexao = new Conexao().Conectar();
                        //cria objeto do tipo EquipamentoDAO chamado equipamentoDAO passando novo EquipamentoDAO recebendo conexao   
                        EquipamentoDAO equipamentoDAO = new EquipamentoDAO(conexao);

                        //valor booleano chamado existe recebe equipamentoDAO.selecionarFuncionalDisponivel
                        //existe Equipamento disponivel ou funcional no banco de dados?
                        boolean existe = equipamentoDAO.selecionarFuncionalDisponivel(equipamentoU);
                        
                        //se existir equipamento disponivel e funcional
                        if(existe)
                        {
                            
                            equipamentoU = emprestimo.modelo;
                            
                            //verifica se existe no banco de dados
                            //cria objeto do tipo connection conexao passando novo Conexao(conexao.java) chamando metodo conectar
                            Connection conexaoEmprestimo = new Conexao().Conectar();
                            //cria objeto do tipo EmprestimoDAO chamado emprestimoDAO passando novo EmprestimoDAO recebendo conexao   
                            EmprestimoDAO emprestimoDAO = new EmprestimoDAO(conexaoEmprestimo);                            
                            
                            //valor booleano chamado nExisteEmprestimo recebe emprestimoDAO.selecionaEquipEmprestimo
                            //existe Emprestimo com equipamento que não esteja emprestado?
                            boolean nExisteEmprestimo = emprestimoDAO.selecionaEquipEmprestimo(equipamentoU);                            
                            
                            //se existir emprestimo com equipamento emprestado
                            if(nExisteEmprestimo)
                            {
                                
                                JOptionPane.showMessageDialog(null, "Equipamento já emprestado!","ATENÇÃO", JOptionPane.WARNING_MESSAGE);
                                
                            }
                            else if(!nExisteEmprestimo)
                            {
                                
                                //cria objeto do tipo connection conexao passando novo Conexao(conexao.java) chamando metodo conectar
                                Connection conexao3 = new Conexao().Conectar();
                                //cria objeto do tipo EmprestimoDAO chamado emprestimoDAO passando novo EmprestimoDAO recebendo conexao    
                                EmprestimoDAO emprestimoDAO2 = new EmprestimoDAO(conexao3);
                                //arraylist do tipo emprestimo chamado emprestimos recebe emprestimoDAO.inserir
                                emprestimoDAO2.inserir(emprestimo);
                        
                                //helper chama o metodo bloquear campos
                                helper.bloquearCampos();
                        
                                //chama tabela equipamentos;
                                tabelaEmprestimo();
                        
                                JOptionPane.showMessageDialog(null, "Equipamento emprestado com sucesso!");                                 
                                
                                
                            }    
                            
                            
                        }
                        else//senão
                        {
                            
                            JOptionPane.showMessageDialog(null, "Equipamento manutenção ou inservivel","ATENÇÃO", JOptionPane.WARNING_MESSAGE);
                            
                        }           
                        
                    }
                    catch(SQLException ex)
                    {
                        
                        JOptionPane.showMessageDialog(null, "Error ao emprestar equipamento no banco de dados! /nError:"+ex);
                        
                    }    
                    
                }    
        
    }            
    
    //metodo para atualizar emprestimo
    public void UpdateEmprestimo()
    {
        
        //comparações logicas
        if(view.getTxtUnidade().getSelectedIndex() != 0 && view.getTxtTipoEquip().getSelectedIndex() != 0 && view.getTxtModelo().getSelectedIndex() != 0 && view.getTxtDestino().getSelectedIndex() != 0
        && view.getTxtNome().getSelectedIndex() != 0 && view.getTxtDataSaida().getDate()==null && view.getTxtDataDevolucao().getDate()==null && view.getTxtStatus().getSelectedIndex() != 0 && view.getTxtObservacao().getText().trim().isEmpty()
        && view.getTxtTombo().getSelectedIndex() != 0 && view.getTxtSerie().getSelectedIndex() != 0)
        {
            
            JOptionPane.showMessageDialog(null, "Campos obrigatorios vazios, selecione-os!!","ATENÇÃO", JOptionPane.WARNING_MESSAGE);
            
        }   
        if(view.getTxtUnidade().getSelectedIndex() != 0 && view.getTxtTipoEquip().getSelectedIndex() != 0)
        {    
        
            JOptionPane.showMessageDialog(null, "Campos unidade e/ou tipo equipamento vazio/s, selecione-os","ATENÇÃO", JOptionPane.WARNING_MESSAGE);
            
        }
        if(view.getTxtDestino().getSelectedIndex() != 0 && view.getTxtModelo().getSelectedIndex() != 0)
        {    
        
            JOptionPane.showMessageDialog(null, "Campos destino e/ou modelo vazio/s, selecione-os","ATENÇÃO", JOptionPane.WARNING_MESSAGE);
            
        }       
        if(view.getTxtDataSaida().getDate()==null && view.getTxtDataDevolucao().getDate()==null)
        {    
        
            JOptionPane.showMessageDialog(null, "Campos data saida e/ou data devolucão vazio/s, selecione-os","ATENÇÃO", JOptionPane.WARNING_MESSAGE);
            
        }     
        if(view.getTxtStatus().getSelectedIndex() == 0)
        {    
        
            JOptionPane.showMessageDialog(null, "Campo status vazio, selecione-os","ATENÇÃO", JOptionPane.WARNING_MESSAGE);
            
        }    
        if(view.getTxtTipo().getSelectedIndex() != 0)
        {    
        
            JOptionPane.showMessageDialog(null, "Campo tipo vazio, selecione-os","ATENÇÃO", JOptionPane.WARNING_MESSAGE);
            
        }       
        if(view.getTxtTombo().getSelectedIndex() != 0 && view.getTxtSerie().getSelectedIndex() != 0)
        {    
        
            JOptionPane.showMessageDialog(null, "Campo tombo e/serie vazios, selecione-os","ATENÇÃO", JOptionPane.WARNING_MESSAGE);
            
        }
        
            //compara se todos os campos foram preenchidos
            if(view.getTxtUnidade().getSelectedItem() != null && view.getTxtTipoEquip().getSelectedItem() != null && view.getTxtModelo().getSelectedItem() != null
            && view.getTxtDestino().getSelectedItem() != null && view.getTxtNome().getSelectedItem() != null && view.getTxtDataSaida().getDate() != null && view.getTxtDataDevolucao().getDate() != null
            && view.getTxtStatus().getSelectedItem() != null && view.getTxtTipo().getSelectedItem() != null && view.getTxtTombo().getSelectedItem() != null & view.getTxtSerie().getSelectedItem() != null)
            {
                
                    //pega um emprestimo da view Emprestimo
                    Emprestimo emprestimo = helper.obterModeloSemID();
                    
                    try
                    {
                    //cria objeto do tipo connection conexao passando novo Conexao(conexao.java) chamando metodo conectar
                    Connection conexao = new Conexao().Conectar();
                    //cria objeto do tipo EmprestimoDAO chamado emprestimoDAO passando novo EmprestimoDAO recebendo conexao
                    EmprestimoDAO emprestimoDAO = new EmprestimoDAO(conexao);
                    //emprestimoDAO chama metodo atualizar passando emprestimo
                    emprestimoDAO.atualizar(emprestimo);     
            
                    //helper chama o metodo bloquear campos
                    helper.bloquearCampos();            
            
                    //helper chama metodo limpar tela(Campos)
                    helper.limparTela();    
            
                    //chama tabela emprestimo;
                    tabelaEmprestimo();               
            
                    JOptionPane.showMessageDialog(null, "Equipamento atualizado com sucesso!");
                    }
                    //pegue exceção sql  
                    catch(SQLException ex)
                    {
                        
                        JOptionPane.showMessageDialog(null, "Error ao atualizar emprestimo no banco de dados! /nError:"+ex);
                        
                    }    
                
            }        
        
    }        
    
    //metodo para devolver emprestimo
    public void DevolverEmprestimo()
    {
        
        
        
    }        
    
    //metodo tabelaEmprestimo
    public void tabelaEmprestimo()
    {
        
        //se a view a tabela for diferente de nulo
        if(view.jTabelaCadEmprestimo != null)
        {
            
            //modelo do tipo defaultablemodel recebe convertendo para defaulttablemodel a view passando a tabela e pegando seu modelo
            DefaultTableModel modelo = (DefaultTableModel) view.jTabelaCadEmprestimo.getModel();
            
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
                //cria objeto do tipo EmprestimoDAO chamado emprestimoDAO passando novo EmprestimoDAO recebendo conexao
                EmprestimoDAO emprestimoDAO = new EmprestimoDAO(conexao);
                
                //emprestimos do tipo arraylist do tipo Emprestimo recebe emprestimoDAO chamando metodo selecione todos emprestimos
                ArrayList<Emprestimo> emprestimos = emprestimoDAO.selecioneAllEmprestimos();
                
                //para cada emprestimo no arraylist emprestimos
                for(Emprestimo emprestimo : emprestimos)
                {
                    
                    //quantidade de linhas que o objeto vai ter
                    Object[] linha = new Object[13];
                    
                    //pegue as respectivas linhas de cada emprestimo e as sete
                    linha[0] = emprestimo.getId();
                    linha[1] = emprestimo.getUnidade().getUnidadenome();
                    linha[2] = emprestimo.getTipoequip().getTipoequipamento();
                    linha[3] = emprestimo.getModelo();
                    linha[4] = emprestimo.getDestino().getUnidadenome();
                    linha[5] = emprestimo.getNome();
                    
                    String dataSaida = new SimpleDateFormat("dd-MM-yyyy").format((Date)emprestimo.getDataSaida());
                    String dataDevolucao = new SimpleDateFormat("dd-MM-yyyy").format((Date)emprestimo.getDataDevolucao());
                    
                    
                    linha[6] = dataSaida;
                    linha[7] = dataDevolucao;
                    linha[8] = emprestimo.getStatus();
                    linha[9] = emprestimo.getTipo();
                    linha[10] = emprestimo.getObservacao();
                    linha[11] = emprestimo.getTombo();
                    linha[12] = emprestimo.getSerie();
                    
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
    
    //metodo para atualizar combobox unidade
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
    
    //metodo para atualizar combobox tipoequipamento
    public void atualizarTipoEquip()
    {
        
        try
        {
            
            //busca equipamento no banco de dados
            
            //cria objeto do tipo connection conexao passando novo Conexao(conexao.java) chamado conectar
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
            
            JOptionPane.showMessageDialog(null, "Error ao preencher o combobox:" +ex);
            
        }                          
        
    }        

    //metodo para atualizar combobox modelo
   public void atualizarModelo() 
    {
        
        try
        {
            
            //cria objeto do tipo connection conexao passando novo Conexao(conexao.java) chamando metodo conectar
            Connection conexao = new Conexao().Conectar();
            
            //cria objeto do tipo EquipamentoDAO equipamentoDAO passando EquipamentoDAO recebendo conexao
            EquipamentoDAO equipamentoDAO = new EquipamentoDAO(conexao);
            
            //cria arraylist de equipamento chamado equipamentos passando o objeto equipamentoDAO do tipo Equipamento chamando o metodo selecioneAllEquipamento
            ArrayList<Equipamento> equipamentos = equipamentoDAO.selecioneAllEquipamento();
            
            DefaultComboBoxModel combomodel = (DefaultComboBoxModel) view.getTxtModelo().getModel();
            
            combomodel.removeAllElements();
            
            for(Equipamento equipamento : equipamentos)
            {
                
                combomodel.addElement(equipamento.EquiptoString());
                
            }             
            
        }
        catch(SQLException ex)
        {
            
            JOptionPane.showMessageDialog(null, "Error ao preencher combobox equipamento!" + ex);
            
        }    
 
    }
   
    //metodo para atualizar combobox destino
    public void atualizardestino() 
    {
       
     try
     {
         
         //buscar destino no banco de dados
         
            //cria objeto do tipo connection conexao passando novo Conexao(conexao.java) chamando metodo conectar
            Connection conexao = new Conexao().Conectar();  
            
            //cria objeto do tipo UnidadeDAO unidadedao passando UnidadeDAO recebendo conexao
            UnidadeDAO unidadedao = new UnidadeDAO(conexao);
            
            //cria arraylist de unidade chamado unidades passando o objeto unidadedao do tipo Unidade chamando o metodo selecioneAllUnidade
            ArrayList<Unidade> unidades2 = unidadedao.selecioneAllUnidade();
         
            DefaultComboBoxModel combomodel2 = (DefaultComboBoxModel) view.getTxtDestino().getModel();
            
            combomodel2.removeAllElements();
            
            for(Unidade unidade2 : unidades2)
            {
                
                combomodel2.addElement(unidade2);
                
            }    
     }
     catch(SQLException ex)
     {
         
         JOptionPane.showMessageDialog(null,"Error a preencher combobox destino:" +ex);
         
     }            
    
    }   
    
    //metodo para atualizar combobox nome
    public void atualizaNome()
    {
        
        try
        {
            
            //cria objeto do tipo connection conexao passando novo Conexao(conexao.java) chamando metodo conectar
            Connection conexao = new Conexao().Conectar();
            
            //cria objeto do tipo NomeDAO nomeDAO passando NomeDAO recebendo conexao
            NomeDAO nomeDAO = new NomeDAO(conexao);
            
            //cria arraylist de nome chamado nomes passando o objeto nomeDAO do tipo Nome chamando o metodo selecioneAllNomes
            ArrayList<Nome> nomes = nomeDAO.selecioneAllNome();
            
            DefaultComboBoxModel combomodel = (DefaultComboBoxModel) view.getTxtNome().getModel();
            
            combomodel.removeAllElements();
            
            for(Nome nome : nomes)
            {
                
                combomodel.addElement(nome);
                
            }             
            
        }
        catch(SQLException ex)
        {
            
            JOptionPane.showMessageDialog(null, "Error ao preencher combobox nome!" + ex);
            
        }         
        
    }        
    
    //metodo para atualizar combobox tombo
    public void atualizaTombo() 
    {
        
        try
        {
            
            //cria objeto do tipo connection conexao passando novo Conexao(conexao.java) chamando metodo conectar
            Connection conexao = new Conexao().Conectar();
            
            //cria objeto do tipo EquipamentoDAO equipamentoDAO passando EquipamentoDAO recebendo conexao
            EquipamentoDAO equipamentoDAO = new EquipamentoDAO(conexao);
            
            //cria arraylist de equipamento chamado equipamentos passando o objeto equipamentoDAO do tipo Equipamento chamando o metodo selecioneAllEquipamentoTombo
            ArrayList<Equipamento> equipamentos = equipamentoDAO.selecioneAllEquipamentoTombo();
            
            DefaultComboBoxModel combomodel = (DefaultComboBoxModel) view.getTxtTombo().getModel();
            
            combomodel.removeAllElements();
            
            for(Equipamento equipamento : equipamentos)
            {
                
                combomodel.addElement(equipamento.TombotoString());
                
            }             
            
        }
        catch(SQLException ex)
        {
            
            JOptionPane.showMessageDialog(null, "Error ao preencher combobox tombo por equipamento!" + ex);
            
        } 
 
    }    
    
    //metodo para atualizar combobox equipamento passando tipoequipamentonome
    public void atualizaEquipamentoModelo(String tipoequipamentonome) 
    {
        
        try
        {
            //cria objeto do tipo connection conexao passando novo Conexao(conexao.java) chamando metodo conectar
            Connection conexao = new Conexao().Conectar();
            
            //cria objeto do tipo EquipamentoDAO equipamentoDAO passando EquipamentoDAO recebendo conexao
            EquipamentoDAO equipamentoDAO = new EquipamentoDAO(conexao);
            
            //cria arraylist de equipamento chamado equipamentos passando o objeto equipamentoDAO do tipo Equipamento chamando o metodo selecionarAllModeloPorTipoEquip passando tipoequipamentonome
            ArrayList<Equipamento> equipamentos = equipamentoDAO.selecionarAllModeloPorTipoEquip(tipoequipamentonome);
            
            DefaultComboBoxModel combomodel = (DefaultComboBoxModel) view.getTxtModelo().getModel();
            
            combomodel.removeAllElements();
            
            for(Equipamento equipamento : equipamentos)
            {
                
                combomodel.addElement(equipamento.EquiptoString());
                
            }             
            
        }
        catch(SQLException ex)
        {
            
            JOptionPane.showMessageDialog(null, "Error ao preencher combobox equipamento por tipo equipamento!" + ex);
            
        }          
        
    }         
    
    //metodo para atualizar combobox tombo passando equip
    public void atualizaComboTombo(String equip)
    {
        
        try
        {
            
            //cria objeto do tipo connection conexao passando novo Conexao(conexao.java) chamando metodo conectar
            Connection conexao = new Conexao().Conectar();
            
            //cria objeto do tipo EquipamentoDAO equipamentoDAO passando EquipamentoDAO recebendo conexao
            EquipamentoDAO equipamentoDAO = new EquipamentoDAO(conexao);
            
            //cria arraylist de equipamento chamado equipamentos passando o objeto equipamentoDAO do tipo Equipamento chamando o metodo selecioneAllEquipamentoTomboStringEquip passando equip passando equip
            ArrayList<Equipamento> equipamentos = equipamentoDAO.selecioneAllEquipamentoTomboStringEquip(equip);
            
            DefaultComboBoxModel combomodel = (DefaultComboBoxModel) view.getTxtTombo().getModel();
            
            combomodel.removeAllElements();
            
            for(Equipamento equipamento : equipamentos)
            {
                
                combomodel.addElement(equipamento.TombotoString());
                
            }             
            
        }
        catch(SQLException ex)
        {
            
            JOptionPane.showMessageDialog(null, "Error ao preencher combobox tombo por equipamento!" + ex);
            
        }         
        
    }        
    
    //metodo para atualizar combo serie passando equip
    public void atualizaComboSerie(String equip) 
    {
        
        try
        {
            
            //cria objeto do tipo connection conexao passando novo Conexao(conexao.java) chamando metodo conectar
            Connection conexao = new Conexao().Conectar();
            
            //cria objeto do tipo EquipamentoDAO equipamentoDAO passando EquipamentoDAO recebendo conexao
            EquipamentoDAO equipamentoDAO = new EquipamentoDAO(conexao);
            
            //cria arraylist de equipamento chamado equipamentos passando o objeto equipamentoDAO do tipo Equipamento chamando o metodo selecioneAllEquipamentoSerieStringEquip passando equip passando equip
            ArrayList<Equipamento> equipamentos = equipamentoDAO.selecioneAllEquipamentoSerieStringEquip(equip);
            
            DefaultComboBoxModel combomodel = (DefaultComboBoxModel) view.getTxtSerie().getModel();
            
            combomodel.removeAllElements();
            
            for(Equipamento equipamento : equipamentos)
            {
                
                combomodel.addElement(equipamento.SerietoString());
                
            }             
            
        }
        catch(SQLException ex)
        {
            
            JOptionPane.showMessageDialog(null, "Error ao preencher combobox serie por equipamento!" + ex);
            
        }         
        
    }    
    
    //metodo para atualizar combobox serie
    public void atualizaSerie()
    {
        
        try
        {
            
            //cria objeto do tipo connection conexao passando novo Conexao(conexao.java) chamando metodo conectar
            Connection conexao = new Conexao().Conectar();

            //cria objeto do tipo EquipamentoDAO equipamentoDAO passando EquipamentoDAO recebendo conexao
            EquipamentoDAO equipamentoDAO = new EquipamentoDAO(conexao);

            //cria arraylist de equipamento chamado equipamentos passando o objeto equipamentoDAO do tipo Equipamento chamando o metodo selecioneAllEquipamentoSerie
            ArrayList<Equipamento> equipamentos = equipamentoDAO.selecioneAllEquipamentoSerie();            
            
            DefaultComboBoxModel combomodel = (DefaultComboBoxModel) view.getTxtSerie().getModel();
            
            combomodel.removeAllElements();
            
            for(Equipamento equipamento : equipamentos)
            {
                
                combomodel.addElement(equipamento.SerietoString());
                
            }             
            
        }
        catch(SQLException ex)
        {
            
            JOptionPane.showMessageDialog(null, "Error ao preencher combobox serie por equipamento!" + ex);
            
        } 
    
    }                
}
