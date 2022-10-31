package controller.helper;
import model.Equipamento;
import model.Fabricante;
import model.Fornecedor;
import model.TipoEquipamento;
import model.Unidade;
import view.TelaCadastroEquipamento;


public class CadastroEquipamentoHelper 
{
    
    private final TelaCadastroEquipamento view;
    
    //metodo construtor
    public CadastroEquipamentoHelper(TelaCadastroEquipamento view) {
        this.view = view;
    } 
    
    //metodo obter modelo sem id apenas para a inserção dos campos mais importantes
    public Equipamento obterModeloSemID()
    {
        

       Unidade unidade = (Unidade) view.getTxtUnidade().getSelectedItem();//Unidade unidade recebe passado para unidade a view gettextunidade e pegue o texto
       TipoEquipamento tipoequip = (TipoEquipamento) view.getTxtTipoEquip().getSelectedItem();//TipoEquipamento tipoequipamento recebe passado para unidade a view getTxtTipoEquip e pegue o texto
       String tombo = view.getTxtTombo().getText();//String tombo recebe view pegue o getTxtTombo e pegue o texto
       String serie = view.getTxtSerie().getText();//String serie recebe view pegue o getTxtSerie e pegue o texto
       Fornecedor fornecedor = (Fornecedor) view.getTxtFornecedor().getSelectedItem();//Fornecedor fornecedor recebe passado para fornecedor a view getTxtFornecedor e pegue o texto
       Fabricante fabricante = (Fabricante) view.getTxtFabricante().getSelectedItem();//String fabricante recebe view pegue o get TxtFabricante e pegue o texto
       String modelo = view.getTxtModelo().getText();//String modelo recebe view pegue o getTxtmodelo e pegue o texto
       String status = view.getTxtStatus().getSelectedItem().toString();//String status recebe view pegue o getselecteditem para string
       String equipamentouni = view.getTxtEquipamento().getSelectedItem().toString();//String equipamentouni recebe view pegue o getselected item para string
       String observacao = view.getTxtObservacao().getText();//String observacao recebe view pegue o getTextObservacao e pegue o texto
       
        //construir objeto do tipo equipamento
        Equipamento equipamento = new Equipamento(unidade,tipoequip,tombo,serie,fornecedor, fabricante,modelo,status,equipamentouni,observacao);      

        return equipamento;        
        
    } 
    
    //metodo obter modelo com todos os campos
    public Equipamento obterModelo()
    {
       Integer id = Integer.parseInt(view.getTxtId().getText());
       Unidade unidade = (Unidade) view.getTxtUnidade().getSelectedItem();//Unidade unidade recebe passado para unidade a view gettextunidade e pegue o texto
       TipoEquipamento tipoequip = (TipoEquipamento) view.getTxtTipoEquip().getSelectedItem();//TipoEquipamento tipoequipamento recebe passado para unidade a view getTxtTipoEquip e pegue o texto
       String tombo = view.getTxtTombo().getText();//String tombo recebe view pegue o getTxtTombo e pegue o texto
       String serie = view.getTxtSerie().getText();//String serie recebe view pegue o getTxtSerie e pegue o texto
       Fornecedor fornecedor = (Fornecedor) view.getTxtFornecedor().getSelectedItem();//Fornecedor fornecedor recebe passado para fornecedor a view getTxtFornecedor e pegue o texto
       Fabricante fabricante = (Fabricante) view.getTxtFabricante().getSelectedItem();//String fabricante recebe view pegue o get TxtFabricante e pegue o texto
       String modelo = view.getTxtModelo().getText();//String modelo recebe view pegue o getTxtmodelo e pegue o texto
       String status = view.getTxtStatus().getSelectedItem().toString();//String status recebe view pegue o getselecteditem para string
       String equipamentouni = view.getTxtEquipamento().getSelectedItem().toString();//String equipamentouni recebe view pegue o getselected item para string
       String observacao;   
       
       if(view.getTxtObservacao().getText() == null)
       {
           
           observacao = "NULL";
           
       } 
       else
       {
           
           observacao = view.getTxtObservacao().getText();//String observacao recebe view pegue o getTextObservacao e pegue o texto   
           
       }    
       
       //construir objeto do tipo equipamento
       Equipamento equipamento = new Equipamento(id,unidade,tipoequip,tombo,serie,fornecedor, fabricante,modelo,status,equipamentouni,observacao);      

        return equipamento;   
        
    }

    //metodo para setar modelo
    public void setModelo()
    {
        
        int setar = view.jTabelaCadEquip.getSelectedRow();     
        
        view.txtId.setText(view.jTabelaCadEquip.getModel().getValueAt(setar, 0).toString());
        view.txtUnidade.setSelectedItem(view.jTabelaCadEquip.getModel().getValueAt(setar, 1).toString());   
        view.txtTipoEquip.setSelectedItem(view.jTabelaCadEquip.getModel().getValueAt(setar, 2).toString());   
        view.txtTombo.setText(view.jTabelaCadEquip.getModel().getValueAt(setar, 3).toString());
        view.txtSerie.setText(view.jTabelaCadEquip.getModel().getValueAt(setar, 4).toString());
        view.txtFornecedor.setSelectedItem(view.jTabelaCadEquip.getModel().getValueAt(setar, 5).toString());   
        view.txtFabricante.setSelectedItem(view.jTabelaCadEquip.getModel().getValueAt(setar, 6).toString());   
        view.txtModelo.setText(view.jTabelaCadEquip.getModel().getValueAt(setar, 7).toString());     
        view.txtStatus.setSelectedItem(view.jTabelaCadEquip.getModel().getValueAt(setar, 8).toString());   
        view.txtEquipamento.setSelectedItem(view.jTabelaCadEquip.getModel().getValueAt(setar, 9).toString());   
        view.txtObservacao.setText(view.jTabelaCadEquip.getModel().getValueAt(setar, 10).toString());   

         if(view.jTabelaCadEquip.getModel().getValueAt(setar, 10).toString() != null)
         {
             
             view.txtObservacao.setText(view.jTabelaCadEquip.getModel().getValueAt(setar, 10).toString());   
             
         }
         else
         {
             
             view.txtObservacao.setText("NULO");   
             
         }    

    }        
    
    //metodo para limpar os campos
    public void limparTela()
    {
        
        view.getTxtTombo().setText("");
        view.getTxtSerie().setText("");
        view.getTxtModelo().setText("");
        view.getTxtObservacao().setText("");
        view.getjTabelaCadEquip().clearSelection();
        
    }    
    
    //metodo para bloquear os campos
    public void bloquearCampos()
    {
        view.getTxtUnidade().setEnabled(false);
        view.getTxtTipoEquip().setEnabled(false);
        view.getTxtTombo().setEnabled(false);
        view.getTxtSerie().setEnabled(false);
        view.getTxtFornecedor().setEnabled(false);
        view.getTxtFabricante().setEnabled(false);
        view.getTxtModelo().setEnabled(false);
        view.getTxtStatus().setEnabled(false);
        view.getTxtEquipamento().setEnabled(false);
        view.getTxtObservacao().setEnabled(false);
        
        view.btnEditar.setEnabled(false);
        view.btnSalvar.setEnabled(false);
        view.btnExcluir.setEnabled(true);
        view.btnPesquisar.setEnabled(false);        
    }
    
    //metodo para desbloquear campos
    public void desbloquearCampos()
    {
        
        view.getTxtUnidade().setEnabled(true);
        view.getTxtTipoEquip().setEnabled(true);
        view.getTxtTombo().setEnabled(true);
        view.getTxtSerie().setEnabled(true);
        view.getTxtFornecedor().setEnabled(true);
        view.getTxtFabricante().setEnabled(true);
        view.getTxtModelo().setEnabled(true);
        view.getTxtStatus().setEnabled(true);
        view.getTxtEquipamento().setEnabled(true);
        view.getTxtObservacao().setEnabled(true);     
        
        
        view.btnEditar.setEnabled(true);
        view.btnExcluir.setEnabled(true);
        view.btnSalvar.setEnabled(true);
        view.btnPesquisar.setEnabled(true);            
        
    }           
    
}
