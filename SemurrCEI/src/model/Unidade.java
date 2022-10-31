package model;

public class Unidade
{
    
    int id;
    String unidadenome;

    //metodo construtor
    public Unidade(int id, String unidadenome) 
    {
        this.id = id;
        this.unidadenome = unidadenome;
    }
    
    //metodo construtor sem id
    public Unidade(String unidadenome)
    {
        
        this.unidadenome = unidadenome;
        
    }        
    
    //metodo construtor vazio
    public Unidade() 
    {
        
        
        
    }
    
    //getters e setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUnidadenome() {
        return unidadenome;
    }

    public void setUnidadenome(String unidadenome) {
        this.unidadenome = unidadenome;
    }

    @Override
    public String toString()
    {
        
        return getUnidadenome();
        
    }         
       
}
