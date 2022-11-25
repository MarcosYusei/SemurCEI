package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Login;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import view.TelaCadastroEquipamento;
import view.TelaPrincipal;

public class LoginDAO 
{
    
    private final Connection conexao;
    
    //metodo construtor
    public LoginDAO(Connection conexao) {
        this.conexao = conexao;
    }
    
    //metodo inserir do dao
    public void inserir(Login login) throws SQLException
    {
            //string sql
            String sql = "insert into login (usuario,nome,senha,email,tipo, data) values (UPPER(?),UPPER(?),?,UPPER(?),UPPER(?),?)";
            //criamos um statement para executar a query sql
            PreparedStatement pstm = conexao.prepareStatement(sql);
        
            try
            {
                
                //antes de executar pstm setString
                pstm.setString(1, login.getUsuario());
                pstm.setString(2, login.getNome());
                pstm.setString(3, login.getSenha());      
                pstm.setString(4, login.getEmail());
                pstm.setString(5, login.getTipo());   
                pstm.setDate(6, new java.sql.Date(login.getData().getTime()));
                
                //execute o pstm
                pstm.execute();              
                
            }
            catch(SQLException ex)
            {
                
                JOptionPane.showMessageDialog(null, "Error ao inserir login no banco de dados!" + ex,"Error!", JOptionPane.INFORMATION_MESSAGE);
                
            }    
            finally
            {
                
                //feche a conexao e o pstm    
                conexao.close();    
                pstm.close();                  
                
            }    
              
    }
    
    //função atualizar(update)
    public void atualizar(Login login) throws SQLException
    {
            //string sql
            String sql = "update login set usuario = ?, nome = ?, senha = ?, email = ?, tipo = ?, data = ? where id = ?";

            //criamos um statement para executar a query sql
            PreparedStatement pstm = conexao.prepareStatement(sql);

            try
            {
                
                //antes de executar pstm setString
                pstm.setString(1, login.getUsuario());
                pstm.setString(2, login.getNome());
                pstm.setString(3, login.getSenha());            
                pstm.setString(4, login.getEmail());
                pstm.setString(5, login.getTipo()); 
                pstm.setDate(6, new java.sql.Date(login.getData().getTime()));
                pstm.setInt(7, login.getId());     
                
                pstm.execute();    
                
            }
            catch (SQLException ex)
            {
                
                JOptionPane.showMessageDialog(null, "Error ao atualizar login no banco de dados!" + ex,"Error!", JOptionPane.INFORMATION_MESSAGE);
                
            }
            finally
            {
                
                //feche a conexao e o pstm 
                conexao.close();
                pstm.close();                 
                
            }          
        
    }        
    
    //funcão deletar
    public void deletar(Login login) throws SQLException
    {
            //String sql
            String sql = "delete from login where id = ?";
            
            //criamos um statement para executar a query sql
            PreparedStatement pstm = conexao.prepareStatement(sql);

            try
            {
                
                //antes de executar pstm setString
                pstm.setInt(1, login.getId());    
            
                pstm.execute();              
                
            }
            catch(SQLException ex)
            {
                
                JOptionPane.showMessageDialog(null, "Error ao deletar login no banco de dados!" + ex,"Error!", JOptionPane.INFORMATION_MESSAGE);
                
            }
            finally
            {
                
                //feche a conexao e o pstm
                conexao.close();
                pstm.close();                
                
            }    
            
    }        

    //existe por usuario e senha? se sim retorne true ou false(boolean)
    public boolean pesquisarUsuarioSenha(Login login) throws SQLException
    {
        //String sql
        String sql = "select * from login where usuario = ? and senha = ?";
       
        //criamos um statement para executar a query sql 
        PreparedStatement pstm = conexao.prepareStatement(sql);
       
        //antes de executar pstm setString
        pstm.setString(1, login.getUsuario());
        pstm.setString(2, login.getSenha());
        
        //execute pstm
        pstm.execute();
        
        //apos executar dados no banco mostre os resultados
        
       ResultSet rs = pstm.getResultSet();//pegue o resultado que vir do banco de dados
       
        //enquanto existir uma proxima linha no resultset
        if(rs.next())
        {   
            //crie uma string tipo que vai receber do resultset a string na sexta posição
            String tipo = rs.getString(6);
            
            TelaPrincipal tela = new TelaPrincipal();
            
            TelaCadastroEquipamento telacad = new TelaCadastroEquipamento();
            
            //se o tipo for igual a admin ignorando letras maisculas ou minusculas
            if(tipo.equalsIgnoreCase("admin"))
            {
                
                tela.setVisible(true);
                
                tela.jConexao.setEnabled(true);
                tela.jMenuCadastro.setEnabled(true);
                tela.jMenuItemEquipamento.setEnabled(true);
                tela.JMenuItemLogin.setEnabled(true);
                
                
            }
            //se o tipo for igual a usuario ignorando letras maisculas ou minusculas
            else if(tipo.equalsIgnoreCase("usuario"))
            {
                
                tela.setVisible(true);                
                
                tela.jConexao.setEnabled(false);
                tela.jMenuCadastro.setEnabled(true);  
                tela.jMenuItemEquipamento.setEnabled(true);   
                tela.JMenuItemLogin.setEnabled(false);
                tela.jMenuUnidade.setEnabled(false);
                tela.jMenuTipoEquipamento.setEnabled(false);
                tela.jMenuFornecedor.setEnabled(false);
                tela.jMenuFabricante.setEnabled(false);
                
                telacad.JButtonFabricante.setEnabled(false);
                telacad.JButtonFornecedor.setEnabled(false);
                telacad.jButtonTipoEquip.setEnabled(false);
                telacad.jButtonUnidade.setEnabled(false);
                
            }    
            
            //retorne verdadeiro
            return true;//retorne verdadeiro para a função
            
        }
        //se não
        else
        {           
            //retorne falso
            return false;//retorne false se nao entra no while
            
        }     
        
    }

 //metodo para trazer todos logins do banco de dados   
 public ArrayList<Login> selecioneAllLogin() throws SQLException {
   ArrayList logins = new ArrayList();
    //Faz a instância da classe Login 
   String sql = "select * from login";
    //Instrução SQL para seleção de registro específico da tabela login;
    try {
        PreparedStatement pstm = conexao.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        while(rs.next()){
            Login login = new Login();
            //Laço de repetição para preencher com os dados do banco o objeto Login;
            login.setId(rs.getInt("id"));
            login.setUsuario(rs.getString("usuario"));
            login.setSenha(rs.getString("senha"));
            login.setNome(rs.getString("nome"));
            login.setEmail(rs.getString("email"));
            login.setTipo(rs.getString("tipo"));
            login.setData(rs.getDate("data"));
            
            
            //"seta" os atributos da classe Login com os dados dos campos do banco - pega os dados do banco para pesquisa no formulário;
            logins.add(login);
        }
    } catch (SQLException ex) 
    {

        JOptionPane.showMessageDialog(null, "Error ao pesquisar todos logins no banco de dados!" +ex,"Error!", JOptionPane.INFORMATION_MESSAGE);
        
    }
    finally
    {
            //feche a conexao
            conexao.close();    
        
    }    
  //retorne o array logins  
  return logins;
 } 
}
