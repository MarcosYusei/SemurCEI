package controller.helper;

import model.Login;
import view.TelaLogin;



public class TelaLoginHelper 
{

    private final TelaLogin view;

    //metodo construtor
    public TelaLoginHelper(TelaLogin view) {
        this.view = view;
    }    

    //metodo obter modelo
    public Login obterModelo()
    {
        
        String usuario = view.getTxtLogin().getText();//string usuario recebe view pegue gettxtlogin e pegue o texto
        String senha = view.getTxtSenha().getText();//string senha recebe view pegue gettxtsenha e pegue o texto
        //construir objeto do tipo login
        Login login = new Login(usuario,senha);  
        
        return login;
        
    }  
    
    //public Login setarModelo()
    //{
        
        
        
    //}        
    
    //metodo para limpar os campos
    public void limparTela()
    {
        
        view.getTxtLogin().setText("");
        view.getTxtSenha().setText("");
        
    }        
    
}
