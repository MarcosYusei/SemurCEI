package controller;

import com.mysql.cj.protocol.Resultset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Conexao //Possibilita instancias
{
    
    public Connection conexao;
    public Resultset rs;
    PreparedStatement pstm;
    public static String url="";
    public static String usr="";
    public static String pass="";
    
    public Connection Conectar() throws SQLException
    {
        
            controller.ReadFiles.ler();
        
            Connection conexao = DriverManager.getConnection(url,usr,pass);
        
            return conexao;                
 
    }      
    
}