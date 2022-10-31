package controller.helper;

import model.Fabricante;
import view.TelaCadastroFabricante;



public class CadastroFabricanteHelper 
{
    
    private final TelaCadastroFabricante view;
    
    //metodo construtor
    public CadastroFabricanteHelper(TelaCadastroFabricante view) {
        this.view = view;
    }     
    
    //metodo obter modelo sem id apenas para a inserção dos campos mais importantes
    public Fabricante obterModeloSemID()
    {
       
       String fabricantenome = view.getTxtFabricante().getText();//String fabricantenome recebe view pegue o texto
       
        //construir objeto do tipo fabricante
        Fabricante fabricante = new Fabricante(fabricantenome);      

        return fabricante;        
        
    }   
    
    //metodo obter modelo com id
    public Fabricante obterModelo()
    {
        
       Integer id = Integer.parseInt(view.getTxtId().getText());//Integer id recebe convert para int view gettxtid pegue o texto
       String fabricantenome = view.getTxtFabricante().getText();//String fabricantenome recebe view pegue o texto
       
        //construir objeto do tipo fabricante
        Fabricante fabricante = new Fabricante(fabricantenome);      

        return fabricante;            
        
    }       
    
    //metodo para setar modelo
    public void setModelo()
    {
        
        int setar = view.jTabelaFabricante.getSelectedRow();
        
        view.txtId.setText(view.jTabelaFabricante.getModel().getValueAt(setar, 0).toString());
        view.txtFabricante.setText(view.jTabelaFabricante.getModel().getValueAt(setar, 1).toString());
 
    }         
    
    //metodo para limpar os campos
    public void limparTela()
    {
        
        view.getTxtFabricante().setText("");
        
    }    
    
    //metodo para bloquear os campos
    public void bloquearCampos()
    {
        view.getTxtFabricante().setEnabled(false);   
        
        view.btnEditar.setEnabled(false);
        view.btnSalvar.setEnabled(false);
        view.btnExcluir.setEnabled(true);
        view.btnPesquisar.setEnabled(false);          
    }
    
    //metodo para desbloquear campos
    public void desbloquearCampos()
    {
        
        view.getTxtFabricante().setEnabled(true);
        
        view.btnEditar.setEnabled(true);
        view.btnExcluir.setEnabled(true);
        view.btnSalvar.setEnabled(true);
        view.btnPesquisar.setEnabled(true);            
        
    }              
}
