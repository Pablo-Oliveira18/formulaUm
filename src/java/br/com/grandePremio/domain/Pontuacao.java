package br.com.grandePremio.domain;


public enum Pontuacao {    
    PRIMEIRO(25,"Primeiro lugar"), SEGUNDO(18,"Segundo lugar"), TERCEIRO(15,"Terceiro lugar"), QUARTO(12,"Quarto lugar"),
    QUINTO(10,"Quinto lugar") , SEXTO(8,"Sexto lugar") , SETIMO (6,"Sétimo lugar") , OITAVO(4,"Oitavo lugar"), NONO(2,"Nono lugar"), DECIMO(1,"Décimo lugar");
     
    private  int valor;
    private  String descricao;
    
    Pontuacao(int valorOpcao,String descricao){
        valor = valorOpcao;
        this.descricao = descricao;
    }
    public int getValor(){
        return valor;
    }

    public String getDescricao() {
        return descricao;
    }
    
}
