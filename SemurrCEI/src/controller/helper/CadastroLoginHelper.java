package controller.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Login;
import view.TelaCadastroLogin;


public class CadastroLoginHelper 
{
    
    private final TelaCadastroLogin view;

    //metodo construtor
    public CadastroLoginHelper(TelaCadastroLogin view) {
        this.view = view;
    }
        

    //metodo obter modelo sem id apenas para a inserção
    public Login obterModeloSemID()
    {
        
       String usuario = view.getTxtLogin().getText();//string usuario recebe view pegue gettxtlogin e pegue o texto
       String nome = view.getTxtNome().getText();//string nome recebe view pegue getttxtnome e pegue o texto
       String senha =  view.getTxtSenha().getText();//string senha recebe view pegue gettxtsenha e pegue o texto
       String email = view.getTxtEmail().getText();//string email recebe view pegue gettxtemail e pegue o texto
       String tipo = ((String) view.getTxtTipo().getSelectedItem());//string tipo recebe view pegue gettxttipo e pegue o item selecionado
       Date data= new java.sql.Date(view.getTxtData().getDate().getTime());
       
        //construir objeto do tipo login
        Login login = new Login(usuario,nome,senha,email,tipo, data);      

        return login;        
        
    }        
    
    //metodo obter modelo
    public Login obterModelo()
    {
       Integer id = Integer.parseInt(view.getTxtID().getText());
       String usuario = view.getTxtLogin().getText();//string usuario recebe view pegue gettxtlogin e pegue o texto
       String nome = view.getTxtNome().getText();//string nome recebe view pegue getttxtnome e pegue o texto
       String senha =  view.getTxtSenha().getText();//string senha recebe view pegue gettxtsenha e pegue o texto
       String email = view.getTxtEmail().getText();//string email recebe view pegue gettxtemail e pegue o texto
       String tipo = ((String) view.getTxtTipo().getSelectedItem());//string tipo recebe view pegue gettxttipo e pegue o item selecionado
       Date data= new java.sql.Date(view.getTxtData().getDate().getTime());
       
        //construir objeto do tipo login
        Login login = new Login(id,usuario,nome,senha,email,tipo, data);      

        return login;
        
    }
    
    //metodo para setar o modelo
    public void setModelo()
    {

            int setar = view.jTableLogins.getSelectedRow();
            
            view.txtID.setText(view.jTableLogins.getModel().getValueAt(setar, 0).toString());
            view.txtLogin.setText(view.jTableLogins.getModel().getValueAt(setar, 1).toString());
            view.txtNome.setText(view.jTableLogins.getModel().getValueAt(setar, 2).toString());
            view.txtSenha.setText(view.jTableLogins.getModel().getValueAt(setar, 3).toString());
            view.txtEmail.setText(view.jTableLogins.getModel().getValueAt(setar, 4).toString());
            view.txtTipo.setSelectedItem(view.jTableLogins.getModel().getValueAt(setar, 5).toString());
            try
            {
            Date data = new SimpleDateFormat("yyyy-MM-dd", Locale.UK).parse((String)view.jTableLogins.getModel().getValueAt(setar, 6).toString());
            
            view.txtData.setDate(data);
            }
            catch (ParseException ex)
            {
                
            Logger.getLogger(CadastroLoginHelper.class.getName()).log(Level.SEVERE, null, ex);
        
            }
      
        
    }        
    
    //metodo para limpar os campos
    public void limparTela()
    {
        
        view.getTxtLogin().setText("");
        view.getTxtNome().setText("");
        view.getTxtSenha().setText("");
        view.getTxtEmail().setText("");
        view.getTxtTipo().setEnabled(false);
        view.getTxtData().setCalendar(null);
        view.getjTableLogins().clearSelection();
        
    }    
    
    //metodo para bloquear os campos
    public void bloquearCampos()
    {
        view.getTxtLogin().setEnabled(false);
        view.getTxtNome().setEnabled(false);
        view.getTxtSenha().setEnabled(false);
        view.getTxtEmail().setEnabled(false);
        view.getTxtTipo().setEnabled(false);
        view.getTxtData().setEnabled(false);
        view.getTxtPesquisarNome().setEnabled(false);
        
        view.btnEditar.setEnabled(false);
        view.btnSalvar.setEnabled(false);
        view.btnExcluir.setEnabled(false);
        view.btnPesquisar.setEnabled(false);
    }
    
    //metodo para desbloquear campos
    public void desbloquearCampos()
    {
        
        view.getTxtLogin().setEnabled(true);
        view.getTxtNome().setEnabled(true);
        view.getTxtSenha().setEnabled(true);
        view.getTxtEmail().setEnabled(true);
        view.getTxtTipo().setEnabled(true);
        view.getTxtData().setEnabled(true);
        view.getTxtPesquisarNome().setEnabled(true);
        
        view.btnEditar.setEnabled(true);
        view.btnSalvar.setEnabled(true);
        view.btnExcluir.setEnabled(true);
        view.btnPesquisar.setEnabled(true);        
        
    }              
         
}
