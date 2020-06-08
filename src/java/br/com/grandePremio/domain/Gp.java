
package br.com.grandePremio.domain;

public class Gp {
    private Piloto piloto; 
    private Integer pontuacao;
    private Integer posicao;
    
    public Gp(Piloto piloto,Integer pontuacao){
        this.piloto = piloto;
        this.pontuacao = pontuacao;
    }

    public Piloto getPiloto() {
        return piloto;
    }

    public void setPiloto(Piloto piloto) {
        this.piloto = piloto;
    }

    public Integer getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(Integer pontuacao) {
        this.pontuacao = pontuacao;
    }

    public Integer getPosicao() {
        return posicao;
    }

    public void setPosicao(Integer posicao) {
        this.posicao = posicao;
    }
    
    
}
