package controller.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import model.Emprestimo;
import model.TipoEquipamento;
import model.Unidade;
import view.TelaCadastroEmprestimo;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Nome;


public class CadastroEmprestimoHelper 
{
    
    private final TelaCadastroEmprestimo view;
    
    //metodo construtor
    public CadastroEmprestimoHelper(TelaCadastroEmprestimo view) 
    {
        this.view = view;
    }        
    
    //metodo obter modelo sem id apenas para a inserção dos campos mais importantes
    public Emprestimo obterModeloSemID()
    {
        
       Unidade unidade = (Unidade) view.getTxtUnidade().getSelectedItem();//Unidade unidade recebe passado para unidade a view gettextunidade e pegue o texto
       TipoEquipamento tipoequip = (TipoEquipamento) view.getTxtTipoEquip().getSelectedItem();//TipoEquipamento tipoequipamento recebe passado para unidade a view getTxtTipoEquip e pegue o texto
       String modelo = view.getTxtModelo().getSelectedItem().toString();//String modelo recebe view pegue o getTextModelo e pegue o texto
       Unidade destino = (Unidade) view.getTxtDestino().getSelectedItem();//Unidade unidade recebe passado para unidade a view getTxtDestino e pegue o texto
       Nome nome = (Nome) view.getTxtNome().getSelectedItem();//Nome nome recebe passado para nome a view getTxtNome e pegue o texto
       Date dataSaida = (Date) view.getTxtDataSaida().getDate();//Date dataSaida recebe passado para Date a view getTxtDataSaida e pegue o texto
       Date dataDevolucao = (Date) view.getTxtDataDevolucao().getDate();//Date dataDevolucao recebe passado para Date a view getTxtDataDevolucao e pegue o texto
       String status = view.getTxtStatus().getSelectedItem().toString();//String status recebe view pegue o getselecteditem para string
       String tipo = view.getTxtTipo().getSelectedItem().toString();//String tipo recebe view pegue o getselecteditem para string
       String observacao = view.getTxtObservacao().getText();//String observacao recebe view pegue o getTextObservacao e pegue o texto
       String tombo = view.getTxtTombo().getSelectedItem().toString();//String tombo recebe view pegue o getTextTombo e pegue o texto
       String serie = view.getTxtSerie().getSelectedItem().toString();//String serie recebe view pegue o getTextSerie e pegue o texto
       
       if(view.getTxtObservacao().getText() == null)
       {
           
           observacao = "NULL";
           
       } 
       else
       {
           
           observacao = view.getTxtObservacao().getText();//String observacao recebe view pegue o getTextObservacao e pegue o texto   
           
       }           
       
       //construir objeto do tipo emprestimo
       Emprestimo emprestimo = new Emprestimo(unidade,tipoequip,modelo,destino,nome,dataSaida,dataDevolucao,status,tipo,observacao,tombo,serie);      

       return emprestimo;        
        
    }    
    

    //metodo obter modelo com todos os campos
    public Emprestimo obterModelo()
    {
       Integer id = Integer.parseInt(view.getTxtId().getText());
       Unidade unidade = (Unidade) view.getTxtUnidade().getSelectedItem();//Unidade unidade recebe passado para unidade a view gettextunidade e pegue o texto
       TipoEquipamento tipoequip = (TipoEquipamento) view.getTxtTipoEquip().getSelectedItem();//TipoEquipamento tipoequipamento recebe passado para unidade a view getTxtTipoEquip e pegue o texto
       String modelo = view.getTxtModelo().getSelectedItem().toString();//String modelo recebe view pegue o getTextModelo e pegue o texto
       Unidade destino = (Unidade) view.getTxtDestino().getSelectedItem();//Unidade unidade recebe passado para unidade a view getTxtDestino e pegue o texto
       Nome nome = (Nome) view.getTxtNome().getSelectedItem();//Nome nome recebe passado para nome a view getTxtNome e pegue o texto
       Date dataSaida = (Date) view.getTxtDataSaida().getDate();//Date dataSaida recebe passado para Date a view getTxtDataSaida e pegue o texto
       Date dataDevolucao = (Date) view.getTxtDataDevolucao().getDate();//Date dataDevolucao recebe passado para Date a view getTxtDataDevolucao e pegue o texto
       String status = view.getTxtStatus().getSelectedItem().toString();//String status recebe view pegue o getselecteditem para string
       String tipo = view.getTxtTipo().getSelectedItem().toString();//String tipo recebe view pegue o getselecteditem para string
       String observacao = view.getTxtObservacao().getText();//String observacao recebe view pegue o getTextObservacao e pegue o texto
       String tombo = view.getTxtTombo().getSelectedItem().toString();//String tombo recebe view pegue o getTextTombo e pegue o texto
       String serie = view.getTxtSerie().getSelectedItem().toString();//String serie recebe view pegue o getTextSerie e pegue o texto 
      
       if(view.getTxtObservacao().getText() == null)
       {
           
           observacao = "NULL";
           
       } 
       else
       {
           
           observacao = view.getTxtObservacao().getText();//String observacao recebe view pegue o getTextObservacao e pegue o texto   
           
       }           
       
       //construir objeto do tipo emprestimo
       Emprestimo emprestimo = new Emprestimo(id,unidade,tipoequip,modelo,destino,nome,dataSaida,dataDevolucao,status,tipo,observacao,tombo,serie);      

       return emprestimo;   
        
    }

    //metodo para setar modelo
    public void setModelo()
    {
        
        int setar = view.jTabelaCadEmprestimo.getSelectedRow();     
        
        view.txtId.setText(view.jTabelaCadEmprestimo.getModel().getValueAt(setar, 0).toString());
        view.txtUnidade.setSelectedItem(view.jTabelaCadEmprestimo.getModel().getValueAt(setar, 1).toString());   
        view.txtTipoEquip.setSelectedItem(view.jTabelaCadEmprestimo.getModel().getValueAt(setar, 2).toString());   
        view.txtModelo.setSelectedItem(view.jTabelaCadEmprestimo.getModel().getValueAt(setar, 3).toString());   
        view.txtDestino.setSelectedItem(view.jTabelaCadEmprestimo.getModel().getValueAt(setar, 4).toString());
        view.txtNome.setSelectedItem(view.jTabelaCadEmprestimo.getModel().getValueAt(setar, 5).toString());   

        try 
        {
            Date data = new SimpleDateFormat("dd/MM/yyyy").parse((String)view.jTabelaCadEmprestimo.getModel().getValueAt(setar, 6));
            
            view.txtDataSaida.setDate(data);
        } catch (ParseException ex) 
        {
            Logger.getLogger(CadastroEmprestimoHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try 
        {
            Date data = new SimpleDateFormat("dd/MM/yyyy").parse((String)view.jTabelaCadEmprestimo.getModel().getValueAt(setar, 7));
            
            view.txtDataDevolucao.setDate(data);
        } catch (ParseException ex) 
        {
            Logger.getLogger(CadastroEmprestimoHelper.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
        view.txtStatus.setSelectedItem(view.jTabelaCadEmprestimo.getModel().getValueAt(setar, 8).toString());     

        view.txtTipo.setSelectedItem(view.jTabelaCadEmprestimo.getModel().getValueAt(setar, 9).toString());
        
         if(view.jTabelaCadEmprestimo.getModel().getValueAt(setar, 10).toString() != null)
         {
             
             view.txtObservacao.setText(view.jTabelaCadEmprestimo.getModel().getValueAt(setar, 10).toString());   
             
         }
         else
         {
             
             view.txtObservacao.setText("NULO");   
             
         }  
         
        view.txtTombo.setSelectedItem(view.jTabelaCadEmprestimo.getModel().getValueAt(setar, 11).toString());   
        view.txtSerie.setSelectedItem(view.jTabelaCadEmprestimo.getModel().getValueAt(setar, 12).toString());                   
        
    }       
    
    //metodo para limpar os campos
    public void limparTela()
    {
        
        view.getTxtObservacao().setText("");
        view.getjTabelaCadEmprestimo().clearSelection();
        
    }   
    
    //metodo para bloquear os campos
    public void bloquearCampos()
    {
        view.getTxtUnidade().setEnabled(false);
        view.getTxtTipoEquip().setEnabled(false);
        view.getTxtModelo().setEnabled(false);
        view.getTxtDestino().setEnabled(false);
        view.getTxtNome().setEnabled(false);
        view.getTxtDataSaida().setEnabled(false);
        view.getTxtDataDevolucao().setEnabled(false);
        view.getTxtStatus().setEnabled(false);
        view.getTxtObservacao().setEnabled(false);
        view.getTxtTombo().setEnabled(false);
        view.getTxtSerie().setEnabled(false);        
        
        view.btnEditar.setEnabled(false);
        view.btnEmprestar.setEnabled(false);
        view.btnDevolver.setEnabled(true);
        view.btnPesquisar.setEnabled(false);        
    }
    
    //metodo para desbloquear campos
    public void desbloquearCampos()
    {
        
        view.getTxtUnidade().setEnabled(true);
        view.getTxtTipoEquip().setEnabled(true);
        view.getTxtModelo().setEnabled(true);
        view.getTxtDestino().setEnabled(true);
        view.getTxtNome().setEnabled(true);
        view.getTxtDataSaida().setEnabled(true);
        view.getTxtDataDevolucao().setEnabled(true);
        view.getTxtStatus().setEnabled(true);
        view.getTxtObservacao().setEnabled(true);
        view.getTxtTombo().setEnabled(true);
        view.getTxtSerie().setEnabled(true);        
        
        view.btnEditar.setEnabled(true);
        view.btnEmprestar.setEnabled(true);
        view.btnDevolver.setEnabled(true);
        view.btnPesquisar.setEnabled(true);           
        
    }                   
    
    
    
}
