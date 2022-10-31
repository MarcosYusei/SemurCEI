package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Unidade;

public class UnidadeDAO {

    private final Connection conexao;

    //metodo construtor
    public UnidadeDAO(Connection conexao) {

        this.conexao = conexao;

    }

    //função para inserir(insert)
    public void inserir(Unidade unidade) throws SQLException {

        String sql = "insert into unidade(unidadenome) values (UPPER(?))";

        //criamos um statement para executar a query sql
        PreparedStatement pstm = conexao.prepareStatement(sql);

        try {

            //antes de executar pstm setString
            pstm.setString(1, unidade.getUnidadenome());
            //execute o pstm
            pstm.execute();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Error ao inserir unidade no banco de dados!" + ex,"Error!", JOptionPane.INFORMATION_MESSAGE);

        } finally {

            //feche a conexao e o pstm 
            conexao.close();
            pstm.close();

        }

    }

    //função para atualizar(update)
    public void atualizar(Unidade unidade) throws SQLException {

        String sql = "update unidade set unidadenome = ? where id = ?";

        //criamos um statement para executar a query sql
        PreparedStatement pstm = conexao.prepareStatement(sql);

        try {

            //antes de executar pstm setString
            pstm.setString(1, unidade.getUnidadenome());
            pstm.setInt(2, unidade.getId());

            pstm.execute();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Error ao atualizar unidade no banco de dados!" + ex,"Error!", JOptionPane.INFORMATION_MESSAGE);

        } finally {

            //feche a conexao e o pstm 
            conexao.close();
            pstm.close();

        }

    }

    //função para deletar(delete)
    public void deletar(Unidade unidade) throws SQLException {

        String sql = "delete from unidade where id = ?";
        
        //criamos um statement para executar a query sql
        PreparedStatement pstm = conexao.prepareStatement(sql);

        try {

            //antes de executar pstm setString
            pstm.setInt(1, unidade.getId());
            pstm.execute();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Error ao deletar unidade no banco de dados!" + ex,"Error!", JOptionPane.INFORMATION_MESSAGE);

        } finally {

            //feche a conexao e o pstm 
            conexao.close();
            pstm.close();

        }

    }

    //metodo para trazer todas unidades do banco de dados   
    public ArrayList<Unidade> selecioneAllUnidade() throws SQLException 
    {
        ArrayList unidades = new ArrayList();
        //Faz a instância da classe equipamento 
        String sql = "select * from unidade";
        //Instrução SQL para seleção de registro específico da tabela equipamento;

        try {
            PreparedStatement pstm = conexao.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Unidade unidade = new Unidade();
                //Laço de repetição para preencher com os dados do banco o objeto unidade;
                unidade.setId(rs.getInt("id"));
                unidade.setUnidadenome(rs.getString("unidadenome"));
                //"seta" os atributos da classe Unidade com os dados dos campos do banco - pega os dados do banco para pesquisa no formulário;
                unidades.add(unidade);
            }
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Error ao pesquisar todas unidades no banco de dados!" + ex,"Error!", JOptionPane.INFORMATION_MESSAGE);

        } finally {
            //feche a conexao
            conexao.close();

        }
        //retorne o array unidades  
        return unidades;

    }
    
    

}
