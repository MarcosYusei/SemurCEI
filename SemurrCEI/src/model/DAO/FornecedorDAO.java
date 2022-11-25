package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Fornecedor;

public class FornecedorDAO
{
    
    private final Connection conexao;

    //metodo construtor
    public FornecedorDAO(Connection conexao) {

        this.conexao = conexao;

    }       
    
    //função para inserir(insert)
    public void inserir(Fornecedor fornecedor) throws SQLException
    {
        
        String sql = "insert into fornecedor(fornecedornome) values (UPPER(?))";
        
        //criamos um statement para executar a query sql
        PreparedStatement pstm = conexao.prepareStatement(sql);

        try
        {
            
            //antes de executar pstm setString
            pstm.setString(1, fornecedor.getFornecedornome());
            //execute o pstm
            pstm.execute();          
            
        }
        catch(SQLException ex)
        {
            
            JOptionPane.showMessageDialog(null, "Error ao inserir fornecedor no banco de dados!" + ex,"Error!", JOptionPane.INFORMATION_MESSAGE);
            
        }    
        finally
        {
            
            //feche a conexao e o pstm 
            conexao.close();
            pstm.close();            
            
        }    
    }

    //função para atualizar(update)
    public void atualizar(Fornecedor fornecedor) throws SQLException 
    {
        
        String sql = "update fornecedor set fornecedornome = ? where id = ?";
        
        //criamos um statement para executar a query sql
        PreparedStatement pstm = conexao.prepareStatement(sql);

        try
        {
            
            //antes de executar pstm setString
            pstm.setString(1, fornecedor.getFornecedornome());
            pstm.setInt(2, fornecedor.getId());

            pstm.execute();              
            
        }
        catch(SQLException ex)
        {
            
            JOptionPane.showMessageDialog(null, "Error ao atualizar fornecedor no banco de dados!" + ex,"Error!", JOptionPane.INFORMATION_MESSAGE);
            
        } 
        finally
        {
            
            //feche a conexao e o pstm 
            conexao.close();
            pstm.close();            
            
        }    
        
    } 
    
    //função para deletar(delete)
    public void deletar(Fornecedor fornecedor) throws SQLException
    {
        
        String sql = "delete from fornecedor where id = ?";
        
        //criamos um statement para executar a query sql
        PreparedStatement pstm = conexao.prepareStatement(sql);

        try
        {
            
            //antes de executar pstm setInt
            pstm.setInt(1, fornecedor.getId());
            pstm.execute();             
            
        }
        catch(SQLException ex)
        {
            
            JOptionPane.showMessageDialog(null, "Error ao deletar fornecedor no banco de dados!" + ex,"Error!", JOptionPane.INFORMATION_MESSAGE);         
            
        }
        finally
        {
            
            //feche a conexao e o pstm 
            conexao.close();
            pstm.close();            
            
        }    
        
    }

    //metodo para trazer todos fornecedores do banco de dados   
    public ArrayList<Fornecedor> selecioneAllFornecedor() throws SQLException
    {
        
        ArrayList fornecedores = new ArrayList();
        //Faz a instância da classe fornecedor 
        String sql = "select * from fornecedor";
        //Instrução SQL para seleção de registro específico da tabela fornecedor;    
        
        try
        {
            
            PreparedStatement pstm = conexao.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Fornecedor fornecedor = new Fornecedor();
                //Laço de repetição para preencher com os dados do banco o objeto fornecedor;
                fornecedor.setId(rs.getInt("id"));
                fornecedor.setFornecedornome(rs.getString("fornecedornome"));
                //"seta" os atributos da classe Fornecedor com os dados dos campos do banco - pega os dados do banco para pesquisa no formulário;
                fornecedores.add(fornecedor);
            }            
            
        }
        catch(SQLException ex)
        {
            
            JOptionPane.showMessageDialog(null, "Error ao pesquisar todos fornecedores no banco de dados!" + ex,"Error!", JOptionPane.INFORMATION_MESSAGE);
            
        }
        finally
        {
            
            //feche a conexao
            conexao.close();            
            
        }  
        
        //retorne o array fornecedores  
        return fornecedores;        
        
    }   

}
