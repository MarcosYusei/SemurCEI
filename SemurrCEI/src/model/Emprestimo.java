package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Emprestimo
{
    
    public Integer id;
    public Unidade unidade = new Unidade();
    public TipoEquipamento tipoequip = new TipoEquipamento();
    public String modelo;
    public Unidade destino = new Unidade();
    public Nome nome;
    public Date dataSaida;
    public Date dataDevolucao;
    public String status;
    public String tipo;
    public String observacao;
    public String tombo;
    public String serie;    
    
    //Metodo construtor passando todos campos como obrigatorios
    public Emprestimo(Integer id,Unidade unidade, TipoEquipamento tipoequip,String modelo,Unidade destino, Nome nome, Date dataSaida, Date dataDevolucao, String status, String tipo, String observacao, String tombo, String serie) {
        this.id = id;
        this.unidade = unidade;
        this.tipoequip = tipoequip;
        this.modelo = modelo;
        this.destino = destino;        
        this.nome = nome;
        try
        {
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.UK);
            
            String dataParastring = sdf.format(dataSaida);
            Date dateDeString = sdf.parse(dataParastring);
            
            this.dataSaida = dateDeString;
            
        }
        catch (ParseException ex)
        {
            
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            
        }
        
        try
        {
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.UK);
            
            String dataParastring = sdf.format(dataDevolucao);
            Date dateDeString = sdf.parse(dataParastring);
            
            this.dataDevolucao = dateDeString;
            
        } catch (ParseException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }  
        
        this.status = status;
        this.tipo = tipo;
        this.observacao = observacao;
        this.tombo = tombo;
        this.serie = serie;
    }
    
    //metodo construtor sem o id
    public Emprestimo(Unidade unidade, TipoEquipamento tipoequip,String modelo,Unidade destino, Nome nome, Date dataSaida, Date dataDevolucao, String status, String tipo, String observacao, String tombo, String serie) {
        this.unidade = unidade;
        this.tipoequip = tipoequip;
        this.modelo = modelo;
        this.destino = destino;        
        this.nome = nome;        
        this.nome = nome;
        try
        {
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.UK);
            
            String dataParastring = sdf.format(dataSaida);
            Date dateDeString = sdf.parse(dataParastring);
            
            this.dataSaida = dateDeString;
            
        }
        catch (ParseException ex)
        {
            
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            
        }
        
        try
        {
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.UK);
            
            String dataParastring = sdf.format(dataDevolucao);
            Date dateDeString = sdf.parse(dataParastring);
            
            this.dataDevolucao = dateDeString;
            
        } catch (ParseException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }  
        
        this.status = status;
        this.tipo = tipo;
        this.observacao = observacao;
        this.tombo = tombo;
        this.serie = serie;
    }
    
    //Metodo construtor vazio(NÃO APAGUE)
    public Emprestimo()
    {
        
        
    }

    //Getters e setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Unidade getDestino() {
        return destino;
    }

    public void setDestino(Unidade destino) {
        this.destino = destino;
    }

    public Nome getNome() {
        return nome;
    }

    public void setNome(Nome nome) {
        this.nome = nome;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
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
    
    public String StatustoString()
    {
        
        return getStatus();
        
    }        
    
}
