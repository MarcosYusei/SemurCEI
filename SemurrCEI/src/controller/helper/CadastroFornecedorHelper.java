package controller.helper;

import model.Fornecedor;
import view.TelaCadastroFornecedor;


public class CadastroFornecedorHelper 
{
    
    private final TelaCadastroFornecedor view;
    
    //metodo construtor
    public CadastroFornecedorHelper(TelaCadastroFornecedor view) {
        this.view = view;
    }      
    
    //metodo obter modelo sem id apenas para a inserção dos campos mais importantes
    public Fornecedor obterModeloSemID()
    {
       
       String fornecedornome = view.getTxtFornecedor().getText();//String fornecedornome recebe view pegue o texto
       
        //construir objeto do tipo fornecedor
        Fornecedor fornecedor = new Fornecedor(fornecedornome);      

        return fornecedor;        
        
    }    
    
    //metodo obter modelo com id
    public Fornecedor obterModelo()
    {
        
        Integer id = Integer.parseInt(view.getTxtId().getText());//Integer id recebe convert para int view gettxtid pegue o texto
        String fornecedornome = view.getTxtFornecedor().getText();//String fornecedornome recebe view pegue o texto
       
        //construir objeto do tipo fornecedor
        Fornecedor fornecedor = new Fornecedor(fornecedornome);      

        return fornecedor;                 
        
    }   
    
    //metodo para setar modelo
    public void setModelo()
    {
        
        int setar = view.jTabelaFornecedor.getSelectedRow();
        
        view.txtId.setText(view.jTabelaFornecedor.getModel().getValueAt(setar, 0).toString());
        view.txtFornecedor.setText(view.jTabelaFornecedor.getModel().getValueAt(setar, 1).toString());
 
    }       
    
    //metodo para limpar os campos
    public void limparTela()
    {
        
        view.getTxtFornecedor().setText("");
        
    }    
    
    //metodo para bloquear os campos
    public void bloquearCampos()
    {
        view.getTxtFornecedor().setEnabled(false);   
        
        view.btnEditar.setEnabled(false);
        view.btnSalvar.setEnabled(false);
        view.btnExcluir.setEnabled(true);
        view.btnPesquisar.setEnabled(false);          
    }
    
    //metodo para desbloquear campos
    public void desbloquearCampos()
    {
        
        view.getTxtFornecedor().setEnabled(true);
        
        view.btnEditar.setEnabled(true);
        view.btnExcluir.setEnabled(true);
        view.btnSalvar.setEnabled(true);
        view.btnPesquisar.setEnabled(true);            
        
    }                  
    
}
