package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.TipoEquipamento;

public class TipoEquipamentoDAO 
{
    
    private final Connection conexao;

    //metodo construtor
    public TipoEquipamentoDAO(Connection conexao) {

        this.conexao = conexao;

    }    
    
    //função para inserir(insert)
    public void inserir(TipoEquipamento tipoequipamento) throws SQLException
    {
        
        String sql = "insert into tipoequipamento(tipoequipamentonome) values (UPPER(?))";
        
        //criamos um statement para executar a query sql
        PreparedStatement pstm = conexao.prepareStatement(sql);

        try
        {
            
            //antes de executar pstm setString
            pstm.setString(1, tipoequipamento.getTipoequipamento());
            //execute o pstm
            pstm.execute();            
            
        }
        catch(SQLException ex)
        {
            
            JOptionPane.showMessageDialog(null, "Error ao inserir tipo equipamento no banco de dados!" + ex,"Error!", JOptionPane.INFORMATION_MESSAGE);
            
        }    
        finally
        {
            
            //feche a conexao e o pstm 
            conexao.close();
            pstm.close();            
            
        }    
    }
    
    //função para atualizar(update)
    public void atualizar(TipoEquipamento tipoequipamento) throws SQLException 
    {
        
        String sql = "update tipoequipamento set tipoequipamento = ? where id = ?";
        
        //criamos um statement para executar a query sql
        PreparedStatement pstm = conexao.prepareStatement(sql);

        try
        {
            
            //antes de executar pstm setString
            pstm.setString(1, tipoequipamento.getTipoequipamento());
            pstm.setInt(2, tipoequipamento.getId());

            pstm.execute();            
            
        }
        catch(SQLException ex)
        {
            
            JOptionPane.showMessageDialog(null, "Error ao atualizar tipo equipamento no banco de dados!" + ex,"Error!", JOptionPane.INFORMATION_MESSAGE);
            
        } 
        finally
        {
            
            //feche a conexao e o pstm 
            conexao.close();
            pstm.close();            
            
        }    
        
    }
    
    //função para deletar(delete)
    public void deletar(TipoEquipamento tipoequipamento) throws SQLException
    {
        
        String sql = "delete from tipoequipamento where id = ?";
        
        //criamos um statement para executar a query sql
        PreparedStatement pstm = conexao.prepareStatement(sql);

        try
        {
            
            //antes de executar pstm setString
            pstm.setInt(1, tipoequipamento.getId());
            pstm.execute();            
            
        }
        catch(SQLException ex)
        {
            
            JOptionPane.showMessageDialog(null, "Error ao deletar tipo equipamento no banco de dados!" + ex,"Error!", JOptionPane.INFORMATION_MESSAGE);      
            
        }
        finally
        {
            
            //feche a conexao e o pstm 
            conexao.close();
            pstm.close();            
            
        }    
        
    }
    
    //metodo para trazer todos tipoequipamento do banco de dados   
    public ArrayList<TipoEquipamento> selecioneAllTipoEquipamento() throws SQLException
    {
        
        ArrayList tipoequipamentos = new ArrayList();
        //Faz a instância da classe tipoequipamento 
        String sql = "select * from tipoequipamento";
        //Instrução SQL para seleção de registro específico da tabela tipoequipamento;    
        
        try
        {
            
            PreparedStatement pstm = conexao.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                TipoEquipamento tipoequipamento = new TipoEquipamento();
                //Laço de repetição para preencher com os dados do banco o objeto tipoequipamento;
                tipoequipamento.setId(rs.getInt("id"));
                tipoequipamento.setTipoequipamento(rs.getString("tipoequipamentonome"));
                //"seta" os atributos da classe TipoEquipamento com os dados dos campos do banco - pega os dados do banco para pesquisa no formulário;
                tipoequipamentos.add(tipoequipamento);
            }            
            
        }
        catch(SQLException ex)
        {
            
            JOptionPane.showMessageDialog(null, "Error ao pesquisar todos tipos equipamentos no banco de dados!" + ex,"Error!", JOptionPane.INFORMATION_MESSAGE);
            
        }
        finally
        {
            
            //feche a conexao
            conexao.close();            
            
        }  
        
        //retorne o array tipoequipamentos  
        return tipoequipamentos;        
        
    }   
}
