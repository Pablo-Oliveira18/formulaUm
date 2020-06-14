package br.com.grandePremio.controller;

import br.com.grandePremio.domain.Gp;
import br.com.grandePremio.domain.Piloto;
import br.com.grandePremio.domain.Pontuacao;
import br.com.grandePremio.service.PilotoService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean(name="pontuacaoMB")
@SessionScoped
public class PontuacaoControler implements Serializable{
    
    private Integer qtd;
    private Piloto piloto;
    private List<Piloto> listaPiloto;
    private PilotoService pilotoService = new PilotoService();
    private List<Gp> listaGp = new ArrayList<Gp>();
    private Boolean classificacao = Boolean.FALSE;
    private String result;
    private Pontuacao pontuacaoEnum;


    public PontuacaoControler() {
        this.piloto = new Piloto();
        this.listaPiloto = pilotoService.listar();
        this.classificacao();
    }
    
    
    public String lancar(){
        this.listaPiloto = pilotoService.listar();
        System.out.println("Dados de: " + piloto.getNome() + " id " + piloto.getId());
        this.listaGp.add(new Gp(piloto, qtd));
        
        for (int i = 0; i < listaGp.size(); i++) {
            System.out.println(listaGp.get(i).getPiloto().getNome());
        }
        this.piloto = new Piloto();
        this.qtd = 0;
        return "lancarPontos.xhtml?faces-redirect=true";
    }
    
    public String fecharGp(){
        
        pilotoService.lancaGp(listaGp);
        classificacao = Boolean.TRUE;
        this.listaGp.removeAll(listaGp);
        this.classificacao();
        
        return "tabela.xhtml?faces-redirect=true";
    }
    
    public void classificacao(){
        StringBuilder stringBuilder = new StringBuilder();

        this.listaPiloto = pilotoService.listar();
        
        this.listaPiloto.sort(Comparator.comparing(Piloto::getPontos).reversed());
        
        stringBuilder.append("<table id=\"customers\" border=\"1\"><thead><tr><th>Posição</th>");
        int cont = 1;
        for (Piloto piloto1 : listaPiloto) {
            stringBuilder.append("<th>").append(cont).append("</th>");
            cont++;
        }
        cont=1;
        stringBuilder.append("</tr></thead><tbody><tr><th>Pontuação</th>");
         for (Piloto piloto1 : listaPiloto) {
            stringBuilder.append("<td>").append(piloto1.getPontos()).append("|").append(piloto1.getNome()).append("</td>");
            cont++;
        }
        stringBuilder.append("</tr></tbody></table>");
        result = stringBuilder.toString();
    }
    
    public Integer getQtd() {
        return qtd;
    }

    public void setQtd(Integer qtd) {
        this.qtd = qtd;
    }

    public Piloto getPiloto() {
        return piloto;
    }

    public void setPiloto(Piloto piloto) {
        this.piloto = piloto;
    }

    public List<Piloto> getListaPiloto() {
        return listaPiloto;
    }

    public void setListaPiloto(List<Piloto> listaPiloto) {
        this.listaPiloto = listaPiloto;
    }

    public List<Gp> getListaGp() {
        return listaGp;
    }

    public void setListaGp(List<Gp> listaGp) {
        this.listaGp = listaGp;
    }

    public Boolean getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(Boolean classificacao) {
        this.classificacao = classificacao;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public PilotoService getPilotoService() {
        return pilotoService;
    }

    public void setPilotoService(PilotoService pilotoService) {
        this.pilotoService = pilotoService;
    }

    public Pontuacao getPontuacaoEnum() {
        return pontuacaoEnum;
    }

    public void setPontuacaoEnum(Pontuacao pontuacaoEnum) {
        this.pontuacaoEnum = pontuacaoEnum;
    }
    
    public Pontuacao[] getPontuacao() {
        return pontuacaoEnum.values();
    }

    

}
