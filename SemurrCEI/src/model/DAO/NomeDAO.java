package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Nome;

public class NomeDAO
{
    
    private final Connection conexao;

    //metodo construtor
    public NomeDAO(Connection conexao) 
    {

        this.conexao = conexao;

    }     
    
   //função para inserir(insert)
    public void inserir(Nome nome) throws SQLException
    {
        
        String sql = "insert into Nome(nomepessoa) values (UPPER(?))";
        
        //criamos um statement para executar a query sql
        PreparedStatement pstm = conexao.prepareStatement(sql);

        try
        {
            
            //antes de executar pstm setString
            pstm.setString(1, nome.getNomepessoa());
            //execute o pstm
            pstm.execute();             
            
        }
        catch(SQLException ex)
        {
            
            JOptionPane.showMessageDialog(null, "Error ao inserir pessoa no banco de dados!" + ex,"Error!", JOptionPane.INFORMATION_MESSAGE);
            
        }    
        finally
        {
            
            //feche a conexao e o pstm 
            conexao.close();
            pstm.close();            
            
        }    
    } 
    
    //função para atualizar(update)
    public void atualizar(Nome nome) throws SQLException 
    {
        
        String sql = "update nome set nomepessoa = ? where id = ?";
        
        //criamos um statement para executar a query sql
        PreparedStatement pstm = conexao.prepareStatement(sql);

        try
        {
            
            //antes de executar pstm setString
            pstm.setString(1, nome.getNomepessoa());
            pstm.setInt(2, nome.getId());

            pstm.execute();          
            
        }
        catch(SQLException ex)
        {
            
            JOptionPane.showMessageDialog(null, "Error ao atualizar pessoa no banco de dados!" + ex,"Error!", JOptionPane.INFORMATION_MESSAGE);
            
        } 
        finally
        {
            
            //feche a conexao e o pstm 
            conexao.close();
            pstm.close();            
            
        }    
        
    }

    //função para deletar(delete)
    public void deletar(Nome nome) throws SQLException
    {
        
        String sql = "delete from nome where id = ?";
        
        //criamos um statement para executar a query sql
        PreparedStatement pstm = conexao.prepareStatement(sql);

        try
        {
            
            //antes de executar pstm setString
            pstm.setInt(1, nome.getId());
            pstm.execute();           
            
        }
        catch(SQLException ex)
        {
            
            JOptionPane.showMessageDialog(null, "Error ao deletar pessoa no banco de dados!" + ex,"Error!", JOptionPane.INFORMATION_MESSAGE);      
            
        }
        finally
        {
            
            //feche a conexao e o pstm 
            conexao.close();
            pstm.close();            
            
        }    
        
    }

    //metodo para trazer todos nomes do banco de dados   
    public ArrayList<Nome> selecioneAllNome() throws SQLException
    {
        
        ArrayList nomes = new ArrayList();
        //Faz a instância da classe tipoequipamento 
        String sql = "select * from nome";
        //Instrução SQL para seleção de registro específico da tabela nome;    
        
        try
        {
            
            PreparedStatement pstm = conexao.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Nome nome = new Nome();
                //Laço de repetição para preencher com os dados do banco o objeto Nome;
                nome.setId(rs.getInt("id"));
                nome.setNomepessoa(rs.getString("nomepessoa"));
                //"seta" os atributos da classe Nome com os dados dos campos do banco - pega os dados do banco para pesquisa no formulário;
                nomes.add(nome);
            }            
            
        }
        catch(SQLException ex)
        {
            
            JOptionPane.showMessageDialog(null, "Error ao pesquisar todas pessoas no banco de dados!" + ex,"Error!", JOptionPane.INFORMATION_MESSAGE);
            
        }
        finally
        {
            
            //feche a conexao
            conexao.close();            
            
        }  
        
        //retorne o array nomes  
        return nomes;        
        
    }   
    
    
}
