package model;

public class Fabricante
{
    
    int id;
    String fabricantenome;
    
    //metodo construtor
    public Fabricante(int id, String fabricantenome)
    {
        
        this.id = id;
        this.fabricantenome = fabricantenome;
        
    }
    
    //metodo construtor sem o id
    public Fabricante(String fabricantenome)
    {
        
        this.fabricantenome = fabricantenome;
        
    }
    
    //metodo construtor vazio
    public Fabricante() 
    {
        
        
        
    }    
    
    //getters e setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFabricantenome() {
        return fabricantenome;
    }

    public void setFabricantenome(String fabricantenome) {
        this.fabricantenome = fabricantenome;
    }

    @Override
    public String toString()
    {
        
        return getFabricantenome();
        
    }  
    
}
