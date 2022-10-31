package controller.helper;

import view.TelaPrincipal;


public class TelaPrincipalHelper 
{

    private final TelaPrincipal view;

    //metodo construtor
    public TelaPrincipalHelper(TelaPrincipal view) {
        this.view = view;
    }

    
    //metodo para bloquear os campos
    public void bloquearCampos()
    {
        
        view.getjConexao().setEnabled(false);
        
    }
    
    //metodo para desbloquear campos
    public void desbloquearCampos()
    {
        
        view.getjConexao().setEnabled(true);
        
    }
    
}
