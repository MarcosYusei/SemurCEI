package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Login
{
    int id;
    String usuario;
    String nome;
    String senha;
    String email;
    String tipo;
    Date data;
    
    //metodo construtor com todos atributos
    public Login(int id, String usuario, String nome, String senha, String email, String tipo, Date data) {
        this.id = id;
        this.usuario = usuario;
        this.nome = nome;
        this.senha = senha;
        this.email = email;
        this.tipo = tipo;
        try
        {
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.UK);
            
            String dataParastring = sdf.format(data);
            
            Date dateDeString = sdf.parse(dataParastring);
            
            this.data = dateDeString;
            
        } catch (ParseException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }    
 
    }
    
    //metodo construtor com o id passado pelo banco de dados
    public Login(String usuario, String nome, String senha, String email, String tipo, Date data) {
        this.usuario = usuario;
        this.nome = nome;
        this.senha = senha;
        this.email = email;
        this.tipo = tipo;
        try
        {
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.UK);
            
            String dataParastring = sdf.format(data);
            
            Date dateDeString = sdf.parse(dataParastring);
            
            this.data = dateDeString;
            
        } catch (ParseException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    //metodo construtor apenas com usuario e senha para autenticacao
    public Login(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }

    //metodo construtor vazio
    public Login() 
    {
        
    }
    
    //getters e setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }    
    
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }    

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }      
    
}