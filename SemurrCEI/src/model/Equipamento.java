package model;

public class Equipamento
{
    
    int id;
    
    Unidade unidade = new Unidade();
    
    TipoEquipamento tipoequip = new TipoEquipamento();
    String tombo;//SE HOUVER
    String serie;//OBRIGATORIO
    Fornecedor fornecedor = new Fornecedor();
    Fabricante fabricante = new Fabricante();
    String modelo;//OBRIGATORIO
    String status; //Boolean, ou string?
    String equipamento;//OBRIGATORIO
    String observacao;//NAO
    
    //metodo construtor passando todos campos como obrigatorios
    public Equipamento(int id, Unidade unidade,TipoEquipamento tipoequip,String tombo, String serie, Fornecedor fornecedor, Fabricante fabricante, String modelo, 
                      String status, String equipamento, String observacao)
    {
        
        this.id = id;
        this.unidade = unidade;
        this.tipoequip = tipoequip;
        this.tombo = tombo;
        this.serie = serie;
        this.fornecedor =  fornecedor;
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.status = status;
        this.equipamento = equipamento;
        this.observacao = observacao;
        
    }       
    
    //metodo construtor passando apenas os campos obrigatorios sem o id
    public Equipamento(Unidade unidade,TipoEquipamento tipoequip,String tombo, String serie, Fornecedor fornecedor, Fabricante fabricante, String modelo, 
                      String status, String equipamento, String observacao)
    {
        
        this.unidade = unidade;
        this.tipoequip = tipoequip;
        this.tombo = tombo;
        this.serie = serie;
        this.fornecedor =  fornecedor;
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.status = status;
        this.equipamento = equipamento;       
        this.observacao = observacao;
        
    }            
    
    //metodo construtor vazio(NÃO APAGUE)
    public Equipamento() 
    {
        
    }
    
    //getters e setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }    

    public TipoEquipamento getTipoequip() {
        return tipoequip;
    }

    public void setTipoequip(TipoEquipamento tipoequip) {
        this.tipoequip = tipoequip;
    }

    public String getTombo() {
        return tombo;
    }

    public void setTombo(String tombo) {
        this.tombo = tombo;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(String equipamento) {
        this.equipamento = equipamento;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }          
    
    public String ModelotoString()
    {
        
        return getModelo();
        
    }        
    
    public String StatustoString()
    {
        
        return getStatus();
        
    }        
    
    public String EquiptoString()
    {
        
        return getModelo();
        
    }   
    
    public String TombotoString()
    {
        
        return getTombo();
        
    }        
    
    public String SerietoString()
    {
        
        return getSerie();
        
    }            
          
}
