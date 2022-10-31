package model;

public class TipoEquipamento
{
    
    int id;
    String tipoequipamento;
    
    //metodo construtor
    public TipoEquipamento(int id, String tipoequipamento)
    {
        
        this.id = id;
        this.tipoequipamento = tipoequipamento;
        
    }    
    
    //metodo construtor sem o id
    public TipoEquipamento(String tipoequipamento)
    {
        
        this.tipoequipamento = tipoequipamento;
        
    }    
    
    //metodo construtor vazio
    public TipoEquipamento() 
    {
        
        
        
    }   
    
    //getters e setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoequipamento() {
        return tipoequipamento;
    }

    public void setTipoequipamento(String tipoequipamento) {
        this.tipoequipamento = tipoequipamento;
    }

    @Override
    public String toString()
    {
        
        return getTipoequipamento();
        
    }      
    
}
