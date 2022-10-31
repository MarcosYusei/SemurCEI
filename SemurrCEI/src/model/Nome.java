package model;

public class Nome
{
    
    int id;
    String nomepessoa;
    
    //metodo construtor com todos atributos
    public Nome(int id, String nomepessoa) 
    {
        this.id = id;
        this.nomepessoa = nomepessoa;
    }
    
    //metodo construtor sem o id
    public Nome(String nomepessoa) 
    {
        this.nomepessoa = nomepessoa;
    }
    
    //metodo construtor vazio
    public Nome()
    {
        
        
        
    }
    
    //getters e setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomepessoa() {
        return nomepessoa;
    }

    public void setNomepessoa(String nomepessoa) {
        this.nomepessoa = nomepessoa;
    }
    
    @Override
    public String toString()
    {
        
        return getNomepessoa();
        
    }        
}
