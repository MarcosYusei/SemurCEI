package controller.helper;

import model.Unidade;
import view.TelaCadastroUnidade;


public class CadastroUnidadeHelper 
{
    
    private final TelaCadastroUnidade view;
    
    //metodo construtor
    public CadastroUnidadeHelper(TelaCadastroUnidade view) {
        this.view = view;
    } 
    
    //metodo obter modelo sem id apenas para a inserção dos campos mais importantes
    public Unidade obterModeloSemID()
    {
       
       String unidadenome = view.getTxtUnidade().getText();//String unidadenome recebe view pegue o texto
       
        //construir objeto do tipo unidade
        Unidade unidade = new Unidade(unidadenome);      

        return unidade;        
        
    } 
    
    //metodo obter modelo com id
    public Unidade obterModelo()
    {
        
        Integer id = Integer.parseInt(view.getTxtId().getText());//Integer id recebe convert para int view gettxtid pegue o texto
       String unidadenome = view.getTxtUnidade().getText();//String unidadenome recebe view pegue o texto
       
        //construir objeto do tipo unidade
        Unidade unidade = new Unidade(id,unidadenome);      

        return unidade;           
        
    }        

    //metodo para setar modelo
    public void setModelo()
    {
        
        int setar = view.jTabelaCadUnidade.getSelectedRow();
        
        view.txtId.setText(view.jTabelaCadUnidade.getModel().getValueAt(setar, 0).toString());
        view.txtUnidade.setText(view.jTabelaCadUnidade.getModel().getValueAt(setar, 1).toString());
 
    }        
    
    //metodo para limpar os campos
    public void limparTela()
    {
        
        view.getTxtUnidade().setText("");
        
    }    
    
    //metodo para bloquear os campos
    public void bloquearCampos()
    {
        view.getTxtUnidade().setEnabled(false);   
        
        view.btnEditar.setEnabled(false);
        view.btnSalvar.setEnabled(false);
        view.btnExcluir.setEnabled(true);
        view.btnPesquisar.setEnabled(false);          
    }
    
    //metodo para desbloquear campos
    public void desbloquearCampos()
    {
        
        view.getTxtUnidade().setEnabled(true);
        
        view.btnEditar.setEnabled(true);
        view.btnExcluir.setEnabled(true);
        view.btnSalvar.setEnabled(true);
        view.btnPesquisar.setEnabled(true);            
        
    }          
    
}
