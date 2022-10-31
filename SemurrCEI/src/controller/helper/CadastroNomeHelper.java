package controller.helper;

import model.Nome;
import view.TelaCadastroPessoa;

public class CadastroNomeHelper
{

    private final TelaCadastroPessoa view;
    
    //metodo construtor
    public CadastroNomeHelper(TelaCadastroPessoa view) {
        this.view = view;
    } 
    
    //metodo obter modelo sem id apenas para a inserção dos campos mais importantes
    public Nome obterModeloSemID()
    {
       
       String nomepessoa = view.getTxtNomepessoa().getText();//String nomepessoa recebe view pegue o texto
       
        //construir objeto do tipo Nome
        Nome nome = new Nome(nomepessoa);      

        return nome;        
        
    } 
    
    //metodo obter modelo com id
    public Nome obterModelo()
    {
        
        Integer id = Integer.parseInt(view.getTxtId().getText());//Integer id recebe convert para int view gettxtid pegue o texto
       String unidadenome = view.getTxtNomepessoa().getText();//String nomepessoa recebe view pegue o texto
       
        //construir objeto do tipo nome
        Nome nome = new Nome(id,unidadenome);      

        return nome;           
        
    }        

    //metodo para setar modelo
    public void setModelo()
    {
        
        int setar = view.jTabelaCadNome.getSelectedRow();
        
        view.txtId.setText(view.jTabelaCadNome.getModel().getValueAt(setar, 0).toString());
        view.txtNomepessoa.setText(view.jTabelaCadNome.getModel().getValueAt(setar, 1).toString());
 
    }        
    
    //metodo para limpar os campos
    public void limparTela()
    {
        

        
    }    
    
    //metodo para bloquear os campos
    public void bloquearCampos()
    {
        view.getTxtNomepessoa().setEnabled(false);   
        
        view.btnEditar.setEnabled(false);
        view.btnSalvar.setEnabled(false);
        view.btnExcluir.setEnabled(true);
        view.btnPesquisar.setEnabled(false);          
    }
    
    //metodo para desbloquear campos
    public void desbloquearCampos()
    {
        
        view.getTxtNomepessoa().setEnabled(true);
        
        view.btnEditar.setEnabled(true);
        view.btnExcluir.setEnabled(true);
        view.btnSalvar.setEnabled(true);
        view.btnPesquisar.setEnabled(true);            
        
    }              
    
}
