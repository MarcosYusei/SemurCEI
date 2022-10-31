package model;

public class Fornecedor
{
    
    int id;
    String fornecedornome;
    
    //metodo construtor
    public Fornecedor(int id, String fornecedornome) 
    {
        this.id = id;
        this.fornecedornome = fornecedornome;
    }
    
    //metodo construtor sem id
    public Fornecedor(String fornecedornome)
    {
        
        this.fornecedornome = fornecedornome;
        
    }       
    
    //metodo construtor vazio
    public Fornecedor() 
    {
        
        
        
    }  
    
    //metodos getters e setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFornecedornome() {
        return fornecedornome;
    }

    public void setFornecedornome(String fornecedornome) {
        this.fornecedornome = fornecedornome;
    }

    @Override
    public String toString()
    {
        
        return getFornecedornome();
        
    }  
    
}
