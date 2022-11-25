package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Fabricante;


public class FabricanteDAO 
{
    
    private final Connection conexao;
    
    //metodo construtor
    public FabricanteDAO(Connection conexao) {

        this.conexao = conexao;

    }    
    
    //função para inserir(insert)
    public void inserir(Fabricante fabricante) throws SQLException 
    {
        
        String sql = "insert into fabricante(fabricantenome) values (UPPER(?))";
        
        //criamos um statement para executar a query sql
        PreparedStatement pstm = conexao.prepareStatement(sql);
        
        try
        {
            
            //antes de executar pstm setString
            pstm.setString(1, fabricante.getFabricantenome());
            //execute o pstm
            pstm.execute();    
            
        }
        catch(SQLException ex)
        {
            
            JOptionPane.showMessageDialog(null, "Error ao inserir fabricante no banco de dados!" + ex,"Error!", JOptionPane.INFORMATION_MESSAGE);
            
        }
        finally
        {
            
            //feche a conexao e o pstm 
            conexao.close();
            pstm.close();            
            
        }    
        
        
    }
    
    //função para atualizar(update)
    public void atualizar(Fabricante fabricante) throws SQLException 
    {
    
        String sql = "update fabricante set fabricantenome = ? where id = ?";
        
        //criamos um statement para executar a query sql
        PreparedStatement pstm = conexao.prepareStatement(sql);
        
        try
        {
            
            //antes de executar pstm setString
            pstm.setString(1, fabricante.getFabricantenome());
            pstm.setInt(2, fabricante.getId());
            
            pstm.execute();    
            
        }
        catch(SQLException ex)
        {
            
            JOptionPane.showMessageDialog(null, "Error ao atualizar fabricante no banco de dados!" + ex,"Error!", JOptionPane.INFORMATION_MESSAGE);
            
        }
        finally
        {
            
            //feche a conexao e o pstm 
            conexao.close();
            pstm.close();            
            
        }    
        
    } 
    
    //função para deletar(delete)
    public void deletar(Fabricante fabricante) throws SQLException 
    {
        
        String sql = "delete from fabricante where id = ?";
        
        //criamos um statement para executar a query sql
        PreparedStatement pstm = conexao.prepareStatement(sql);
        
        try
        {
            
            //antes de executar pstm setString
            pstm.setInt(1, fabricante.getId());
            pstm.execute();    
            
        }
        catch(SQLException ex)
        {
            
            JOptionPane.showMessageDialog(null, "Error ao deletar fabricante no banco de dados!" + ex,"Error!", JOptionPane.INFORMATION_MESSAGE);
            
        }
        finally
        {
            
            //feche a conexao e o pstm 
            conexao.close();
            pstm.close();            
            
        }    
        
    }
    
    //metodo para trazer todos fabricantes do banco de dados   
    public ArrayList<Fabricante> selecioneAllFabricante() throws SQLException 
    {
        
        ArrayList fabricantes = new ArrayList();
        //Faz a instância da classe fabricante
        String sql = "select * from fabricante";
        //Instrução SQL para seleção de registro específico da tabela equipamento;
        
        try
        {
            
            PreparedStatement pstm = conexao.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            
            while (rs.next())
            {
                
                Fabricante fabricante = new Fabricante();
                //Laço de repetição para preencher com os dados do banco o objeto fabricante;
                fabricante.setId(rs.getInt("id"));
                fabricante.setFabricantenome(rs.getString("fabricantenome"));
                //"seta" os atributos da classe Fabricante com os dados dos campos do banco - pega os dados do banco para pesquisa no formulário;
                fabricantes.add(fabricante);
                
            }    
            
        }
        catch(SQLException ex)
        {
            
            JOptionPane.showMessageDialog(null, "Error ao pesquisar todos fabricantes no banco de dados!" + ex,"Error!", JOptionPane.INFORMATION_MESSAGE);
            
        }
        finally
        {
            
            //feche a conexao
            conexao.close();            
            
        }    
        
        //retorne o array fabricantes  
        return fabricantes;
    }

}
