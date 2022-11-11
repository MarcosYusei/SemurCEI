package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Equipamento;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Fabricante;
import model.Fornecedor;
import model.TipoEquipamento;
import model.Unidade;

public class EquipamentoDAO 
{
    
    private final Connection conexao;
    
    //metodo construtor
    public EquipamentoDAO(Connection conexao)
    {
        
        this.conexao = conexao;
        
    }        
    //função para inserir(insert)
    public void inserir(Equipamento equipamento) throws SQLException
    {
        
        //string sql
        String sql = "insert into equipamento(unidade,tipoequip,tombo,serie,fornecedor,fabricante,modelo,status,equipamento,observacao)values (?,UPPER(?),UPPER(?),UPPER(?),UPPER(?),UPPER(?),UPPER(?),UPPER(?),UPPER(?),UPPER(?))";
        
        //criamos um statement para executar a query sql
        PreparedStatement pstm = conexao.prepareStatement(sql);
        
        try
        {
            
            //antes de executar pstm setString
            pstm.setInt(1, equipamento.getUnidade().getId());
            pstm.setInt(2, equipamento.getTipoequip().getId());
            pstm.setString(3, equipamento.getTombo());      
            pstm.setString(4, equipamento.getSerie());
            pstm.setInt(5, equipamento.getFornecedor().getId());   
            pstm.setInt(6, equipamento.getFabricante().getId());   
            pstm.setString(7, equipamento.getModelo());
            pstm.setString(8, equipamento.getStatus());
            pstm.setString(9, equipamento.getEquipamento());     
            pstm.setString(10, equipamento.getObservacao());
            //execute o pstm
            pstm.execute();            
            
        }
        catch(SQLException ex)
        {
            
            JOptionPane.showMessageDialog(null, "Error ao inserir equipamento no banco de dados!" + ex,"Error!", JOptionPane.INFORMATION_MESSAGE);         
            
        }
        finally
        {
               
        //feche a conexao e o pstm    
        conexao.close();    
        pstm.close();                
            
        }                
            
    }        
    //função para atualizar(update)
    public void atualizar(Equipamento equipamento) throws SQLException
    {  
        
        String sql = "update equipamento set unidade = ?, tipoequip = ?, tombo = ?, serie = ?, fornecedor = ?,"
                + "fabricante = ?, modelo = ?, status = ?, equipamento = ?, observacao = ? where id = ?";
        
        //criamos um statement para executar a query sql
        PreparedStatement pstm = conexao.prepareStatement(sql);
        
            try
            {
                
            //antes de executar pstm setString
            pstm.setInt(1, equipamento.getUnidade().getId());
            pstm.setInt(2, equipamento.getTipoequip().getId());
            pstm.setString(3, equipamento.getTombo());      
            pstm.setString(4, equipamento.getSerie());
            pstm.setInt(5, equipamento.getFornecedor().getId());   
            pstm.setInt(6, equipamento.getFabricante().getId());   
            pstm.setString(7, equipamento.getModelo());
            pstm.setString(8, equipamento.getStatus());
            pstm.setString(9, equipamento.getEquipamento());      
            pstm.setString(10, equipamento.getObservacao());     
            pstm.setInt(11, equipamento.getId());
                
                pstm.execute();
                
            }
            catch (SQLException ex)
            {
                
                JOptionPane.showMessageDialog(null, "Error ao atualizar equipamento no banco de dados!" + ex,"Error!", JOptionPane.INFORMATION_MESSAGE);
                
            }
            finally
            {
                
                //feche a conexao e o pstm 
                conexao.close();
                pstm.close();                 
                
            }       
        
    }
    
    
    //função deletar
    public void deletar(Equipamento equipamento) throws SQLException
    {
        
        //String sql
        String sql = "delete from equipamento where id = ?";
        
            //criamos um statement para executar a query sql
            PreparedStatement pstm = conexao.prepareStatement(sql);

            try
            {
                
                //antes de executar pstm setString
                pstm.setInt(1, equipamento.getId());  
            
                pstm.execute();                
                
            }
            catch(SQLException ex)
            {
                
                JOptionPane.showMessageDialog(null, "Error ao deletar equipamento no banco de dados!" + ex,"Error!", JOptionPane.INFORMATION_MESSAGE);
                
            }
            finally
            {
                
                //feche a conexao e o pstm
                conexao.close();
                pstm.close();                
                
            }    
        
    }
    
//metodo para trazer todos equipamentos do banco de dados   
 public ArrayList<Equipamento> selecioneAllEquipamento() throws SQLException {
   ArrayList equipamentos = new ArrayList();
    //Faz a instância da classe equipamento 
   String sql = "select * from equipamento as e inner join unidade u on e.unidade = u.id inner join tipoequipamento as tp on e.tipoequip = tp.id inner join\n" +
   "fornecedor as f on e.fornecedor = f.id inner join fabricante as fab on e.fabricante = fab.id";
   //Instrução SQL para seleção de registro específico da tabela equipamento;
    try {
        PreparedStatement pstm = conexao.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        while(rs.next()){
            Equipamento equipamento = new Equipamento();
            //Laço de repetição para preencher com os dados do banco o objeto equipamento;
            equipamento.setId(rs.getInt("id"));
            
            Unidade unidade = new Unidade();
            unidade.setId(rs.getInt("id"));
            unidade.setUnidadenome(rs.getString("unidadenome"));
            
            equipamento.setUnidade(unidade);
            
            TipoEquipamento tipoequipamento = new TipoEquipamento();
            tipoequipamento.setId(rs.getInt("id"));
            tipoequipamento.setTipoequipamento(rs.getString("tipoequipamentonome"));
            
            equipamento.setTipoequip(tipoequipamento);
            
            equipamento.setTombo(rs.getString("tombo"));
            equipamento.setSerie(rs.getString("serie"));
            
            Fornecedor fornecedor = new Fornecedor();
            fornecedor.setId(rs.getInt("id"));
            fornecedor.setFornecedornome(rs.getString("fornecedornome"));
            
            equipamento.setFornecedor(fornecedor);
            
            Fabricante fabricante = new Fabricante();
            fabricante.setId(rs.getInt("id"));
            fabricante.setFabricantenome(rs.getString("fabricantenome"));
            
            equipamento.setFabricante(fabricante);

            equipamento.setModelo(rs.getString("modelo"));
            
            equipamento.setStatus(rs.getString("status"));
            equipamento.setEquipamento(rs.getString("equipamento"));
            equipamento.setObservacao(rs.getString("observacao"));
            //"seta" os atributos da classe Equipamento com os dados dos campos do banco - pega os dados do banco para pesquisa no formulário;
            equipamentos.add(equipamento);
        }
    } catch (SQLException ex) 
    {

        JOptionPane.showMessageDialog(null, "Error ao pesquisar todos equipamentos no banco de dados!" +ex,"Error!", JOptionPane.INFORMATION_MESSAGE);
        
    }
    finally
    {
            //feche a conexao
            conexao.close();   
        
    }    
  //retorne o array equipamentos  
  return equipamentos;
 } 
 
 //metodo para trazer todos os equipamentos do banco de dados por unidade, e tipoequip
 public ArrayList<Equipamento> atualizaEquipamentoUnidadeTipoEquip(String unidade, String tipoequip) throws SQLException 
 {
        
     ArrayList equipamentos = new ArrayList();
     //Faz a instancia da classe Equipamento
     String sql = "select * from equipamento as e inner join unidade u on e.unidade = u.id inner join tipoequipamento as tp on e.tipoequip = tp.id inner join\n" +
    "fornecedor as f on e.fornecedor = f.id inner join fabricante as fab on e.fabricante = fab.id where u.unidadenome = ? and tp.tipoequipamentonome = ?";
     //Instrução SQL para seleção de registro específico da tabela Equipamento;         
   
     try
     {
         
        PreparedStatement pstm = conexao.prepareStatement(sql);
        
        pstm.setString(1, unidade);
        pstm.setString(2, tipoequip);
        
        ResultSet rs = pstm.executeQuery();     
            while(rs.next())
            {
                
            Equipamento equipamento = new Equipamento();
 
            equipamento.setModelo(rs.getString("modelo"));
            
            equipamentos.add(equipamento);                    
                
            }    
            
        }
        catch(SQLException ex)
        {
            
            JOptionPane.showMessageDialog(null, "Error ao pesquisar todos equipamentos por unidade e tipoequip no banco de dados!" + ex,"Error!", JOptionPane.INFORMATION_MESSAGE);            
            
        }
        finally
        {
            
            //feche a conexao
            conexao.close();              
            
        }    
        
      //retorne o array equipamentos  
      return equipamentos;                  
        
    }
 
 //metodo para trazer todos equipamentos do banco de dados por unidadenome
 public ArrayList<Equipamento> selecionarAllEquipPorUnidade(String unidadenome) throws SQLException
 {
     
     ArrayList equipamentos = new ArrayList();
     //Faz a instancia da classe Equipamento
     String sql = "select * from equipamento as e inner join unidade u on e.unidade = u.id inner join tipoequipamento as tp on e.tipoequip = tp.id inner join\n" +
    "fornecedor as f on e.fornecedor = f.id inner join fabricante as fab on e.fabricante = fab.id where u.unidadenome = ?";
     //Instrução SQL para seleção de registro específico da tabela Equipamento; 
     
     try
     {
         
        PreparedStatement pstm = conexao.prepareStatement(sql);
        
        pstm.setString(1, unidadenome);
        
        ResultSet rs = pstm.executeQuery();     
        while (rs.next())
        {
            
            Equipamento equipamento = new Equipamento();
            //Laço de repetição para preencher com os dados do banco o objeto equipamento;
            equipamento.setId(rs.getInt("id"));
            
            Unidade unidade1 = new Unidade();
            unidade1.setId(rs.getInt("id"));
            unidade1.setUnidadenome(rs.getString("unidadenome"));
            
            equipamento.setUnidade(unidade1);
            
            TipoEquipamento tipoequipamento = new TipoEquipamento();
            tipoequipamento.setId(rs.getInt("id"));
            tipoequipamento.setTipoequipamento(rs.getString("tipoequipamentonome"));
            
            equipamento.setTipoequip(tipoequipamento);
            
            equipamento.setTombo(rs.getString("tombo"));
            equipamento.setSerie(rs.getString("serie"));
            
            Fornecedor fornecedor = new Fornecedor();
            fornecedor.setId(rs.getInt("id"));
            fornecedor.setFornecedornome(rs.getString("fornecedornome"));
            
            equipamento.setFornecedor(fornecedor);
            
            Fabricante fabricante = new Fabricante();
            fabricante.setId(rs.getInt("id"));
            fabricante.setFabricantenome(rs.getString("fabricantenome"));
            
            equipamento.setFabricante(fabricante);

            equipamento.setModelo(rs.getString("modelo"));
            equipamento.setStatus(rs.getString("status"));
            equipamento.setEquipamento(rs.getString("equipamento"));
            
            equipamentos.add(equipamento);            
            
        }    
        
         
     }    
     catch(SQLException ex)
     {
            
        JOptionPane.showMessageDialog(null, "Error ao pesquisar todos equipamentos por unidade no banco de dados!" + ex,"Error!", JOptionPane.INFORMATION_MESSAGE);
            
     }
     finally
     {
            
        //feche a conexao
        conexao.close();            
            
     }  
        
      //retorne o array equipamentos  
      return equipamentos;          
 }
 
 //metodo para trazer todos equipamentos por tipo equipamento
 public ArrayList<Equipamento> selecionarAllEquipPorTipoEquip(String tipoequipamentonome) throws SQLException
 {
     
     ArrayList equipamentos = new ArrayList();
     //Faz a instancia da classe Equipamento
     String sql = " select * from equipamento as e inner join unidade u on e.unidade = u.id inner join tipoequipamento as tp on e.tipoequip = tp.id inner join fornecedor as f on e.fornecedor = f.id inner join fabricante as fab on e.fabricante = fab.id where tp.tipoequipamentonome = ?";
     //Instrução SQL para seleção de registro específico da tabela Equipamento; 
     
     try
     {
         
        PreparedStatement pstm = conexao.prepareStatement(sql);
        
        pstm.setString(1, tipoequipamentonome);
        
        ResultSet rs = pstm.executeQuery();     
        while (rs.next())
        {
            
            Equipamento equipamento = new Equipamento();
            //Laço de repetição para preencher com os dados do banco o objeto equipamento;
            equipamento.setId(rs.getInt("id"));
            
            Unidade unidade1 = new Unidade();
            unidade1.setId(rs.getInt("id"));
            unidade1.setUnidadenome(rs.getString("unidadenome"));
            
            equipamento.setUnidade(unidade1);
            
            TipoEquipamento tipoequipamento = new TipoEquipamento();
            tipoequipamento.setId(rs.getInt("id"));
            tipoequipamento.setTipoequipamento(rs.getString("tipoequipamentonome"));
            
            equipamento.setTipoequip(tipoequipamento);
            
            equipamento.setTombo(rs.getString("tombo"));
            equipamento.setSerie(rs.getString("serie"));
            
            Fornecedor fornecedor = new Fornecedor();
            fornecedor.setId(rs.getInt("id"));
            fornecedor.setFornecedornome(rs.getString("fornecedornome"));
            
            equipamento.setFornecedor(fornecedor);
            
            Fabricante fabricante = new Fabricante();
            fabricante.setId(rs.getInt("id"));
            fabricante.setFabricantenome(rs.getString("fabricantenome"));
            
            equipamento.setFabricante(fabricante);

            equipamento.setModelo(rs.getString("modelo"));
            equipamento.setStatus(rs.getString("status"));
            equipamento.setEquipamento(rs.getString("equipamento"));
            
            equipamentos.add(equipamento);            
            
        }    
        
         
     }    
     catch(SQLException ex)
     {
            
        JOptionPane.showMessageDialog(null, "Error ao pesquisar todos equipamentos por tipo equipamento no banco de dados!" + ex,"Error!", JOptionPane.INFORMATION_MESSAGE);
            
     }
     finally
     {
            
        //feche a conexao
        conexao.close();            
            
     }  
        
      //retorne o array equipamentos  
      return equipamentos;               
     
 }       
 
 public ArrayList<Equipamento> selecionarAllModeloPorTipoEquip(String tipoequipamentonome) throws SQLException
 {
     
     ArrayList equipamentos = new ArrayList();
     //Faz a instancia da classe Equipamento
     String sql = "select *,e.modelo from equipamento as e inner join unidade u on e.unidade = u.id inner join tipoequipamento as tp on e.tipoequip = tp.id inner join fornecedor as f on e.fornecedor = f.id inner join fabricante as fab on e.fabricante = fab.id where tp.tipoequipamentonome = ? and status = 'FUNCIONAL'";
     //Instrução SQL para seleção de registro específico da tabela Equipamento; 
     
     try
     {
         
        PreparedStatement pstm = conexao.prepareStatement(sql);
        
        pstm.setString(1, tipoequipamentonome);
        ResultSet rs = pstm.executeQuery();     
        while (rs.next())
        {
            
            Equipamento equipamento = new Equipamento();
            //Laço de repetição para preencher com os dados do banco o objeto equipamento;
            equipamento.setId(rs.getInt("id"));
            
            Unidade unidade1 = new Unidade();
            unidade1.setId(rs.getInt("id"));
            unidade1.setUnidadenome(rs.getString("unidadenome"));
            
            equipamento.setUnidade(unidade1);
            
            TipoEquipamento tipoequipamento = new TipoEquipamento();
            tipoequipamento.setId(rs.getInt("id"));
            tipoequipamento.setTipoequipamento(rs.getString("tipoequipamentonome"));
            
            equipamento.setTipoequip(tipoequipamento);
            
            equipamento.setTombo(rs.getString("tombo"));
            equipamento.setSerie(rs.getString("serie"));
            
            Fornecedor fornecedor = new Fornecedor();
            fornecedor.setId(rs.getInt("id"));
            fornecedor.setFornecedornome(rs.getString("fornecedornome"));
            
            equipamento.setFornecedor(fornecedor);
            
            Fabricante fabricante = new Fabricante();
            fabricante.setId(rs.getInt("id"));
            fabricante.setFabricantenome(rs.getString("fabricantenome"));
            
            equipamento.setFabricante(fabricante);

            equipamento.setModelo(rs.getString("modelo"));
            equipamento.setStatus(rs.getString("status"));
            equipamento.setEquipamento(rs.getString("equipamento"));
            
            equipamentos.add(equipamento);            
            
        }    
        
         
     }    
     catch(SQLException ex)
     {
            
        JOptionPane.showMessageDialog(null, "Error ao pesquisar todos modelos de equipamento por tipo equipamento no banco de dados!" + ex,"Error!", JOptionPane.INFORMATION_MESSAGE);
            
     }
     finally
     {
            
        //feche a conexao
        conexao.close();            
            
     }  
        
      //retorne o array equipamentos  
      return equipamentos;               
     
 }  
 
    //metodo para trazer todos equipamentos por fornecedor
    public ArrayList selecionarAllEquipPorFornecedor(String fornecedor) throws SQLException
    {
        
        ArrayList equipamentos = new ArrayList();
        //Faz a instancia da classe Equipamento              
        
        String sql = "select * from equipamento as e inner join unidade u on e.unidade = u.id inner join tipoequipamento as tp on e.tipoequip = tp.id inner join fornecedor as f on e.fornecedor = f.id inner join fabricante as fab on e.fabricante = fab.id where f.fornecedornome = ?";
        
        try
        {
            
            PreparedStatement pstm = conexao.prepareStatement(sql);
            
            pstm.setString(1, fornecedor);
            
            ResultSet rs = pstm.executeQuery();        
            
            while(rs.next())
            {
                
            Equipamento equipamento = new Equipamento();
            //Laço de repetição para preencher com os dados do banco o objeto equipamento;
            equipamento.setId(rs.getInt("id"));
            
            Unidade unidade1 = new Unidade();
            unidade1.setId(rs.getInt("id"));
            unidade1.setUnidadenome(rs.getString("unidadenome"));
            
            equipamento.setUnidade(unidade1);
            
            TipoEquipamento tipoequipamento = new TipoEquipamento();
            tipoequipamento.setId(rs.getInt("id"));
            tipoequipamento.setTipoequipamento(rs.getString("tipoequipamentonome"));
            
            equipamento.setTipoequip(tipoequipamento);
            
            equipamento.setTombo(rs.getString("tombo"));
            equipamento.setSerie(rs.getString("serie"));
            
            Fornecedor fornecedor1 = new Fornecedor();
            fornecedor1.setId(rs.getInt("id"));
            fornecedor1.setFornecedornome(rs.getString("fornecedornome"));
            
            equipamento.setFornecedor(fornecedor1);
            
            Fabricante fabricante = new Fabricante();
            fabricante.setId(rs.getInt("id"));
            fabricante.setFabricantenome(rs.getString("fabricantenome"));
            
            equipamento.setFabricante(fabricante);

            equipamento.setModelo(rs.getString("modelo"));
            equipamento.setStatus(rs.getString("status"));
            equipamento.setEquipamento(rs.getString("equipamento"));
            
            equipamentos.add(equipamento);                           
                
            }              
            
        }
        catch(SQLException ex)
        {
            
            JOptionPane.showMessageDialog(null, "Error ao pesquisar todos equipamentos por fornecedor no banco de dados!" + ex,"Error!", JOptionPane.INFORMATION_MESSAGE);
            
        }    
        finally
        {
            
            //feche a conexao
            conexao.close();              
            
        }    
        
      //retorne o array equipamentos  
      return equipamentos;   
      
    } 
 
 //metodo para trazer todos equipamentos por status
 public ArrayList<Equipamento> selecionarAllEquipPorStatus(String status) throws SQLException
 {
     
     ArrayList equipamentos = new ArrayList();
     //Faz a instancia da classe Equipamento
     String sql = " select * from equipamento as e inner join unidade u on e.unidade = u.id inner join tipoequipamento as tp on e.tipoequip = tp.id inner join fornecedor as f on e.fornecedor = f.id inner join fabricante as fab on e.fabricante = fab.id where e.status = ?";
     //Instrução SQL para seleção de registro específico da tabela Equipamento; 
     
     try
     {
         
        PreparedStatement pstm = conexao.prepareStatement(sql);
        
        pstm.setString(1, status);
        
        ResultSet rs = pstm.executeQuery();     
        while (rs.next())
        {
            
            Equipamento equipamento = new Equipamento();
            //Laço de repetição para preencher com os dados do banco o objeto equipamento;
            equipamento.setId(rs.getInt("id"));
            
            Unidade unidade1 = new Unidade();
            unidade1.setId(rs.getInt("id"));
            unidade1.setUnidadenome(rs.getString("unidadenome"));
            
            equipamento.setUnidade(unidade1);
            
            TipoEquipamento tipoequipamento = new TipoEquipamento();
            tipoequipamento.setId(rs.getInt("id"));
            tipoequipamento.setTipoequipamento(rs.getString("tipoequipamentonome"));
            
            equipamento.setTipoequip(tipoequipamento);
            
            equipamento.setTombo(rs.getString("tombo"));
            equipamento.setSerie(rs.getString("serie"));
            
            Fornecedor fornecedor = new Fornecedor();
            fornecedor.setId(rs.getInt("id"));
            fornecedor.setFornecedornome(rs.getString("fornecedornome"));
            
            equipamento.setFornecedor(fornecedor);
            
            Fabricante fabricante = new Fabricante();
            fabricante.setId(rs.getInt("id"));
            fabricante.setFabricantenome(rs.getString("fabricantenome"));
            
            equipamento.setFabricante(fabricante);

            equipamento.setModelo(rs.getString("modelo"));
            equipamento.setStatus(rs.getString("status"));
            equipamento.setEquipamento(rs.getString("equipamento"));
            
            equipamentos.add(equipamento);            
            
        }    
        
         
     }    
     catch(SQLException ex)
     {
            
        JOptionPane.showMessageDialog(null, "Error ao pesquisar todos equipamentos por status no banco de dados!" + ex,"Error!", JOptionPane.INFORMATION_MESSAGE);
            
     }
     finally
     {
            
        //feche a conexao
        conexao.close();            
            
     }  
        
      //retorne o array equipamentos  
      return equipamentos;               
     
 }  

 //metodo para trazer todos equipamentos por alugado
 public ArrayList selecionarAllEquipPorAlugado(String alugado) throws SQLException
 {
        
     ArrayList equipamentos = new ArrayList();
     //Faz a instancia da classe Equipamento
     String sql = "select * from equipamento as e inner join unidade u on e.unidade = u.id inner join tipoequipamento as tp on e.tipoequip = tp.id inner join fornecedor as f on e.fornecedor = f.id inner join fabricante as fab on e.fabricante = fab.id where e.equipamento = ?";
     //Instrução SQL para seleção de registro específico da tabela Equipamento; 
     
     try
     {
         
        PreparedStatement pstm = conexao.prepareStatement(sql);
        
        pstm.setString(1, alugado);
        
        ResultSet rs = pstm.executeQuery();     
        while (rs.next())
        {
            
            Equipamento equipamento = new Equipamento();
            //Laço de repetição para preencher com os dados do banco o objeto equipamento;
            equipamento.setId(rs.getInt("id"));
            
            Unidade unidade1 = new Unidade();
            unidade1.setId(rs.getInt("id"));
            unidade1.setUnidadenome(rs.getString("unidadenome"));
            
            equipamento.setUnidade(unidade1);
            
            TipoEquipamento tipoequipamento = new TipoEquipamento();
            tipoequipamento.setId(rs.getInt("id"));
            tipoequipamento.setTipoequipamento(rs.getString("tipoequipamentonome"));
            
            equipamento.setTipoequip(tipoequipamento);
            
            equipamento.setTombo(rs.getString("tombo"));
            equipamento.setSerie(rs.getString("serie"));
            
            Fornecedor fornecedor = new Fornecedor();
            fornecedor.setId(rs.getInt("id"));
            fornecedor.setFornecedornome(rs.getString("fornecedornome"));
            
            equipamento.setFornecedor(fornecedor);
            
            Fabricante fabricante = new Fabricante();
            fabricante.setId(rs.getInt("id"));
            fabricante.setFabricantenome(rs.getString("fabricantenome"));
            
            equipamento.setFabricante(fabricante);

            equipamento.setModelo(rs.getString("modelo"));
            equipamento.setStatus(rs.getString("status"));
            equipamento.setEquipamento(rs.getString("equipamento"));
            
            equipamentos.add(equipamento);            
            
        }    
        
         
     }    
     catch(SQLException ex)
     {
            
        JOptionPane.showMessageDialog(null, "Error ao pesquisar todos equipamentos por alugado no banco de dados!" + ex,"Error!", JOptionPane.INFORMATION_MESSAGE);
            
     }
     finally
     {
            
        //feche a conexao
        conexao.close();            
            
     }  
        
      //retorne o array equipamentos  
      return equipamentos;                    
        
  }

    //metodo para trazer todos equipamentos por patrimonio
    public ArrayList selecionarAllEquipPorPatrimonio(String patrimonio) throws SQLException
    {
        
     ArrayList equipamentos = new ArrayList();
     //Faz a instancia da classe Equipamento
     String sql = "select * from equipamento as e inner join unidade u on e.unidade = u.id inner join tipoequipamento as tp on e.tipoequip = tp.id inner join fornecedor as f on e.fornecedor = f.id inner join fabricante as fab on e.fabricante = fab.id where e.equipamento = ?";
     //Instrução SQL para seleção de registro específico da tabela Equipamento; 
     
     try
     {
         
        PreparedStatement pstm = conexao.prepareStatement(sql);
        
        pstm.setString(1, patrimonio);
        
        ResultSet rs = pstm.executeQuery();     
        while (rs.next())
        {
            
            Equipamento equipamento = new Equipamento();
            //Laço de repetição para preencher com os dados do banco o objeto equipamento;
            equipamento.setId(rs.getInt("id"));
            
            Unidade unidade1 = new Unidade();
            unidade1.setId(rs.getInt("id"));
            unidade1.setUnidadenome(rs.getString("unidadenome"));
            
            equipamento.setUnidade(unidade1);
            
            TipoEquipamento tipoequipamento = new TipoEquipamento();
            tipoequipamento.setId(rs.getInt("id"));
            tipoequipamento.setTipoequipamento(rs.getString("tipoequipamentonome"));
            
            equipamento.setTipoequip(tipoequipamento);
            
            equipamento.setTombo(rs.getString("tombo"));
            equipamento.setSerie(rs.getString("serie"));
            
            Fornecedor fornecedor = new Fornecedor();
            fornecedor.setId(rs.getInt("id"));
            fornecedor.setFornecedornome(rs.getString("fornecedornome"));
            
            equipamento.setFornecedor(fornecedor);
            
            Fabricante fabricante = new Fabricante();
            fabricante.setId(rs.getInt("id"));
            fabricante.setFabricantenome(rs.getString("fabricantenome"));
            
            equipamento.setFabricante(fabricante);

            equipamento.setModelo(rs.getString("modelo"));
            equipamento.setStatus(rs.getString("status"));
            equipamento.setEquipamento(rs.getString("equipamento"));
            
            equipamentos.add(equipamento);            
            
        }    
        
         
     }    
     catch(SQLException ex)
     {
            
        JOptionPane.showMessageDialog(null, "Error ao pesquisar todos equipamentos por patrimonio no banco de dados!" + ex,"Error!", JOptionPane.INFORMATION_MESSAGE);
            
     }
     finally
     {
            
        //feche a conexao
        conexao.close();            
            
     }  
        
      //retorne o array equipamentos  
      return equipamentos;                            
        
    }
 
    public ArrayList selecionarAllEquipPorConvenio(String convenio) throws SQLException
    {
        
     ArrayList equipamentos = new ArrayList();
     //Faz a instancia da classe Equipamento
     String sql = "select * from equipamento as e inner join unidade u on e.unidade = u.id inner join tipoequipamento as tp on e.tipoequip = tp.id inner join fornecedor as f on e.fornecedor = f.id inner join fabricante as fab on e.fabricante = fab.id where e.equipamento = ?";
     //Instrução SQL para seleção de registro específico da tabela Equipamento; 
     
     try
     {
         
        PreparedStatement pstm = conexao.prepareStatement(sql);
        
        pstm.setString(1, convenio);
        
        ResultSet rs = pstm.executeQuery();     
        while (rs.next())
        {
            
            Equipamento equipamento = new Equipamento();
            //Laço de repetição para preencher com os dados do banco o objeto equipamento;
            equipamento.setId(rs.getInt("id"));
            
            Unidade unidade1 = new Unidade();
            unidade1.setId(rs.getInt("id"));
            unidade1.setUnidadenome(rs.getString("unidadenome"));
            
            equipamento.setUnidade(unidade1);
            
            TipoEquipamento tipoequipamento = new TipoEquipamento();
            tipoequipamento.setId(rs.getInt("id"));
            tipoequipamento.setTipoequipamento(rs.getString("tipoequipamentonome"));
            
            equipamento.setTipoequip(tipoequipamento);
            
            equipamento.setTombo(rs.getString("tombo"));
            equipamento.setSerie(rs.getString("serie"));
            
            Fornecedor fornecedor = new Fornecedor();
            fornecedor.setId(rs.getInt("id"));
            fornecedor.setFornecedornome(rs.getString("fornecedornome"));
            
            equipamento.setFornecedor(fornecedor);
            
            Fabricante fabricante = new Fabricante();
            fabricante.setId(rs.getInt("id"));
            fabricante.setFabricantenome(rs.getString("fabricantenome"));
            
            equipamento.setFabricante(fabricante);

            equipamento.setModelo(rs.getString("modelo"));
            equipamento.setStatus(rs.getString("status"));
            equipamento.setEquipamento(rs.getString("equipamento"));
            
            equipamentos.add(equipamento);            
            
        }    
        
         
     }    
     catch(SQLException ex)
     {
            
        JOptionPane.showMessageDialog(null, "Error ao pesquisar todos equipamentos por convenio no banco de dados!" + ex,"Error!", JOptionPane.INFORMATION_MESSAGE);
            
     }
     finally
     {
            
        //feche a conexao
        conexao.close();            
            
     }  
        
      //retorne o array equipamentos  
      return equipamentos;                              
        
    }    
    
    //metodo para trazer todos status do banco de dados   
    public ArrayList<Equipamento> selecioneStatus() throws SQLException
    {
        
        ArrayList equipamentos = new ArrayList();
        //Faz a instância da classe Equipamento 
        String sql = "select distinct status from equipamento";
        //Instrução SQL para seleção de registro específico da tabela Equipamento; 
        
        try
        {
            
            PreparedStatement pstm = conexao.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Equipamento equipamento = new Equipamento();
                //Laço de repetição para preencher com os dados do banco o objeto Equipamento;
                equipamento.setStatus(rs.getString("status"));
                //"seta" os atributos da classe Equipamento com os dados dos campos do banco - pega os dados do banco para pesquisa no formulário;
                equipamentos.add(equipamento);
            }            
            
        }
        catch(SQLException ex)
        {
            
            JOptionPane.showMessageDialog(null, "Error ao pesquisar todos status no banco de dados!" + ex,"Error!", JOptionPane.INFORMATION_MESSAGE);
            
        }
        finally
        {
            
            //feche a conexao
            conexao.close();            
            
        }  
        
        //retorne o array equipamentos  
        return equipamentos;          
        
    }

    //metodo para trazer todos status do banco de dados   
    public ArrayList<Equipamento> selecioneEquipamento() throws SQLException
    {
        
        ArrayList equipamentos = new ArrayList();
        //Faz a instância da classe Equipamento 
        String sql = "select distinct equipamento from equipamento";
        //Instrução SQL para seleção de registro específico da tabela Equipamento; 
        
        try
        {
            
            PreparedStatement pstm = conexao.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Equipamento equipamento = new Equipamento();
                //Laço de repetição para preencher com os dados do banco o objeto Equipamento;
                equipamento.setEquipamento(rs.getString("equipamento"));
                //"seta" os atributos da classe Equipamento com os dados dos campos do banco - pega os dados do banco para pesquisa no formulário;
                equipamentos.add(equipamento);
            }            
            
        }
        catch(SQLException ex)
        {
            
            JOptionPane.showMessageDialog(null, "Error ao todos equipamentos no banco de dados!" + ex,"Error!", JOptionPane.INFORMATION_MESSAGE);
            
        }
        finally
        {
            
            //feche a conexao
            conexao.close();            
            
        }  
        
        //retorne o array equipamentos  
        return equipamentos;          
        
    }

    //metodo para trazer todos equipamentos por unidade e tipo equipamento
    public ArrayList<Equipamento> selecioneAllEquipamento(String unidade, String tipoequip) throws SQLException
    {
        
        ArrayList equipamentos = new ArrayList();
        //Faz a instancia da classe Equipamento        
        
        String sql = "select * from equipamento as e inner join unidade u on e.unidade = u.id inner join tipoequipamento as tp on e.tipoequip = tp.id inner join fornecedor as f on e.fornecedor = f.id inner join fabricante as fab on e.fabricante = fab.id where where u.unidadenome = ? and tp.tipoequipamentonome = ?";
        
        try
        {
            
            PreparedStatement pstm = conexao.prepareStatement(sql);
            
            pstm.setString(1, unidade);
            pstm.setString(2, tipoequip);
            
            ResultSet rs = pstm.executeQuery();        
            
            while(rs.next())
            {
                
            Equipamento equipamento = new Equipamento();
 
            equipamento.setModelo(rs.getString("modelo"));
            
            equipamentos.add(equipamento);                    
                
            }    
            
        }
        catch(SQLException ex)
        {
            
            JOptionPane.showMessageDialog(null, "Error ao pesquisar todos equipamentos por unidade e tipoequip no banco de dados!" + ex,"Error!", JOptionPane.INFORMATION_MESSAGE);            
            
        }
        finally
        {
            
            //feche a conexao
            conexao.close();              
            
        }    
        
      //retorne o array equipamentos  
      return equipamentos;                  
        
    }

    //metodo para trazer todos os tombos por equipamento
    public ArrayList selecioneAllEquipamentoTombo() throws SQLException
    {
     
        ArrayList equipamentos = new ArrayList();
        //Faz a instancia da classe Equipamento  
        
        String sql = "select e.tombo from equipamento as e inner join unidade u on e.unidade = u.id inner join tipoequipamento as tp on e.tipoequip = tp.id inner join fornecedor as f on e.fornecedor = f.id inner join fabricante as fab on e.fabricante";
        
        try
        {
            
            PreparedStatement pstm = conexao.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            
            while(rs.next())
            {
                
                Equipamento equipamento = new Equipamento();
                
                equipamento.setTombo(rs.getString("tombo"));
                
                equipamentos.add(equipamento);
                
            }    
            
        }
        catch(SQLException ex)
        {
            
            JOptionPane.showMessageDialog(null, "Error ao pesquisar todos tombos por equipamentos!" + ex,"Error!", JOptionPane.INFORMATION_MESSAGE);                        
            
        }
        finally
        {
            
            //feche a conexao
            conexao.close();   
            
        }
        
        //retorne o array equipamentos
        
        return equipamentos;
    }  
    
    //metodo para trazer todos os tombos por equipamento passando equip
    public ArrayList selecioneAllEquipamentoTomboStringEquip(String equip) throws SQLException
    {
     
        ArrayList equipamentos = new ArrayList();
        //Faz a instancia da classe Equipamento  
        
        String sql = "select e.tombo from equipamento as e inner join unidade u on e.unidade = u.id inner join tipoequipamento as tp on e.tipoequip = tp.id inner join fornecedor as f on e.fornecedor = f.id inner join fabricante as fab on e.fabricante where e.modelo = ?";
        
        try
        {
            
            PreparedStatement pstm = conexao.prepareStatement(sql);
            
            pstm.setString(1, equip);
            
            ResultSet rs = pstm.executeQuery();
            
            while(rs.next())
            {
                
                Equipamento equipamento = new Equipamento();
                
                equipamento.setTombo(rs.getString("tombo"));
                
                equipamentos.add(equipamento);
                
            }    
            
        }
        catch(SQLException ex)
        {
            
            JOptionPane.showMessageDialog(null, "Error ao pesquisar todos tombos por equipamentos!" + ex,"Error!", JOptionPane.INFORMATION_MESSAGE);                        
            
        }
        finally
        {
            
            //feche a conexao
            conexao.close();   
            
        }
        
        //retorne o array equipamentos
        
        return equipamentos;
    }      
    
    //metodo para trazer todas as series por equipamento
    public ArrayList selecioneAllEquipamentoSerie() throws SQLException
    {
        
        ArrayList equipamentos = new ArrayList();
        //Faz a instancia da classe Equipamento  

        String sql = "select e.serie from equipamento as e inner join unidade u on e.unidade = u.id inner join tipoequipamento as tp on e.tipoequip = tp.id inner join fornecedor as f on e.fornecedor = f.id inner join fabricante as fab on e.fabricante";        
        
        try
        {
            
            PreparedStatement pstm = conexao.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            
            while(rs.next())
            {
                
                Equipamento equipamento = new Equipamento();
                
                equipamento.setSerie(rs.getString("serie"));
                
                equipamentos.add(equipamento);
                
            }              
            
        }
        catch(SQLException ex)
        {
            
            JOptionPane.showMessageDialog(null, "Error ao pesquisar todas series por equipamentos!" + ex,"Error!", JOptionPane.INFORMATION_MESSAGE);                        
            
        }
        finally
        {
            
            //fecha a conexao
            conexao.close();
            
        }
        
        //retorne o array equipamentos
        
        return equipamentos;
    }        
    
    //metodo para trazer todas as series por equipamento passando equip
    public ArrayList<Equipamento> selecioneAllEquipamentoSerieStringEquip(String equip) throws SQLException
    {
        
        ArrayList equipamentos = new ArrayList();
        //Faz a instancia da classe Equipamento  
        
        String sql = "select e.serie from equipamento as e inner join unidade u on e.unidade = u.id inner join tipoequipamento as tp on e.tipoequip = tp.id inner join fornecedor as f on e.fornecedor = f.id inner join fabricante as fab on e.fabricante where e.modelo = ?";
        
        try
        {
            
            PreparedStatement pstm = conexao.prepareStatement(sql);
            
            pstm.setString(1, equip);
            
            ResultSet rs = pstm.executeQuery();
            
            while(rs.next())
            {
                
                Equipamento equipamento = new Equipamento();
                
                equipamento.setSerie(rs.getString("serie"));
                
                equipamentos.add(equipamento);
                
            }    
            
        }
        catch(SQLException ex)
        {
            
            JOptionPane.showMessageDialog(null, "Error ao pesquisar todas series por equipamentos!" + ex,"Error!", JOptionPane.INFORMATION_MESSAGE);                        
            
        }
        finally
        {
            
            //feche a conexao
            conexao.close();   
            
        }
        
        //retorne o array equipamentos
        
        return equipamentos;        
    }           

    public boolean selecionarFuncionalDisponivel(String equipamentoU) throws SQLException {

        ArrayList equipamentos = new ArrayList();
        //Faz a instância da classe equipamento 
        String sql = "select * from equipamento as e inner join unidade u on e.unidade = u.id inner join tipoequipamento as tp on e.tipoequip = tp.id inner join\n"
                + "fornecedor as f on e.fornecedor = f.id inner join fabricante as fab on e.fabricante = fab.id where status = 'FUNCIONAL' OR status = 'DISPONIVEL' and e.modelo = ?";
        //Instrução SQL para seleção de registro específico da tabela equipamento;
        try {
            PreparedStatement pstm = conexao.prepareStatement(sql);

            pstm.setString(1, equipamentoU);

            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Equipamento equipamento = new Equipamento();
                //Laço de repetição para preencher com os dados do banco o objeto equipamento;
                equipamento.setId(rs.getInt("id"));

                Unidade unidade = new Unidade();
                unidade.setId(rs.getInt("id"));
                unidade.setUnidadenome(rs.getString("unidadenome"));

                equipamento.setUnidade(unidade);

                TipoEquipamento tipoequipamento = new TipoEquipamento();
                tipoequipamento.setId(rs.getInt("id"));
                tipoequipamento.setTipoequipamento(rs.getString("tipoequipamentonome"));

                equipamento.setTipoequip(tipoequipamento);

                equipamento.setTombo(rs.getString("tombo"));
                equipamento.setSerie(rs.getString("serie"));

                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setId(rs.getInt("id"));
                fornecedor.setFornecedornome(rs.getString("fornecedornome"));

                equipamento.setFornecedor(fornecedor);

                Fabricante fabricante = new Fabricante();
                fabricante.setId(rs.getInt("id"));
                fabricante.setFabricantenome(rs.getString("fabricantenome"));

                equipamento.setFabricante(fabricante);

                equipamento.setModelo(rs.getString("modelo"));

                String Stats = rs.getString("status");

                equipamento.setStatus(rs.getString("status"));
                equipamento.setEquipamento(rs.getString("equipamento"));
                equipamento.setObservacao(rs.getString("observacao"));
                //"seta" os atributos da classe Equipamento com os dados dos campos do banco - pega os dados do banco para pesquisa no formulário;
                equipamentos.add(equipamento);

                if (Stats.equalsIgnoreCase("FUNCIONAL") || Stats.equalsIgnoreCase("DISPONIVEL")) {

                    return true;

                } else {

                    JOptionPane.showMessageDialog(null, "Equipamento não disponivel!", "Error!", JOptionPane.INFORMATION_MESSAGE);

                    return false;

                }

            }
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Error ao pesquisar todos equipamentos no banco de dados!" + ex, "Error!", JOptionPane.INFORMATION_MESSAGE);

        } finally {
            //feche a conexao
            conexao.close();

        }

        return false;
    }
}
