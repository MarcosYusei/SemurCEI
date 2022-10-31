package controller.helper;

import model.TipoEquipamento;
import view.TelaCadastroTipoEquipamento;


public class CadastroTipoEquipamentoHelper 
{
    
    private final TelaCadastroTipoEquipamento view;
    
    //metodo construtor
    public CadastroTipoEquipamentoHelper(TelaCadastroTipoEquipamento view) {
        this.view = view;
    }   
    
    //metodo obter modelo sem id apenas para a inserção dos campos mais importantes
    public TipoEquipamento obterModeloSemID()
    {
       
       String tipoequipamentonome = view.getTxtTipoEquipamento().getText();//String tipoequipamento recebe view pegue o texto
       
        //construir objeto do tipo tipoequipamento
        TipoEquipamento tipoequipamento = new TipoEquipamento(tipoequipamentonome);      

        return tipoequipamento;        
        
    }   
    
    //metodo obter modelo com id
    public TipoEquipamento obterModelo()
    {
        
        Integer id = Integer.parseInt(view.getTxtId().getText());//Integer id recebe convert para int view gettxtid pegue o texto
       String tipoequipamentonome = view.getTxtTipoEquipamento().getText();//String tipoequipamento recebe view pegue o texto
       
        //construir objeto do tipo tipoequipamento
        TipoEquipamento tipoequipamento = new TipoEquipamento(id,tipoequipamentonome);  

        return tipoequipamento;           
        
    }   
    
    //metodo para setar modelo
    public void setModelo()
    {
        
        int setar = view.jTabelaTipoEquipamento.getSelectedRow();
        
        view.txtId.setText(view.jTabelaTipoEquipamento.getModel().getValueAt(setar, 0).toString());
        view.txtTipoEquipamento.setText(view.jTabelaTipoEquipamento.getModel().getValueAt(setar, 1).toString());
 
    }        
    
    //metodo para limpar os campos
    public void limparTela()
    {
        
        view.getTxtTipoEquipamento().setText("");
        
    }    
    
    //metodo para bloquear os campos
    public void bloquearCampos()
    {
        view.getTxtTipoEquipamento().setEnabled(false);   
        
        view.btnEditar.setEnabled(false);
        view.btnSalvar.setEnabled(false);
        view.btnExcluir.setEnabled(true);
        view.btnPesquisar.setEnabled(false);          
    }
    
    //metodo para desbloquear campos
    public void desbloquearCampos()
    {
        
        view.getTxtTipoEquipamento().setEnabled(true);
        
        view.btnEditar.setEnabled(true);
        view.btnExcluir.setEnabled(true);
        view.btnSalvar.setEnabled(true);
        view.btnPesquisar.setEnabled(true);            
        
    }              
    
}
