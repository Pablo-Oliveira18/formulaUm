package br.com.grandePremio.controller;

import br.com.grandePremio.domain.Corrida;
import br.com.grandePremio.service.CorridaService;
import br.com.grandePremio.util.UtilMensagens;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "corridaMB")
@SessionScoped

public class CorridaController implements Serializable {

    private Corrida corrida = new Corrida();
    private List<Corrida> corridas;
    private CorridaService corridaService = new CorridaService();

    public CorridaController() {
        listar();
    }

    public void listar() {
        corridas = corridaService.listar();
    }

    public String novo() {
        corrida = new Corrida();
        System.out.println(corrida.getId() + corrida.getNome());
        return "new.xhtml?faces-redirect=true";
    }

    public String cancelar() {
        return "list.xhtml?faces-redirect=true";
    }

    public String salvar() {
        System.out.println("AQ ESAT" + corrida.getNome());
        if (corridaService.inserir(corrida)) {
            UtilMensagens.mensagemSucesso("Sucesso", "Corrida salva com sucesso !");
            this.listar();
            return "list.xhtml?faces-redirect=true";
        }
        UtilMensagens.mensagemErro("Erro", "Ocorreu um erro ao salvar corrida");
        return null;
    }

    public String alterar() {
        if (corridaService.alterar(corrida)) {
            UtilMensagens.mensagemSucesso("Sucesso", "Corrida alterada com sucesso !");
            this.listar();
            return "list.xhtml?faces-redirect=true";
        }
        UtilMensagens.mensagemErro("Erro", "Ocorreu um erro ao alterar a corrida");
        return null;
    }

    public String excluir(Corrida corrida) {
        if (corridaService.excluir(corrida)) {
            UtilMensagens.mensagemSucesso("Sucesso", "Corrida excluida com sucesso !");
            this.listar();
            return "list.xhtml?faces-redirect=true";
        }
        UtilMensagens.mensagemErro("Erro", "Ocorreu um erro ao excluir a corrida");
        return null;

    }

    public String buscaDados(Corrida corrida) {
        this.corrida = corrida;
        return "alter.xhtml?faces-redirect=true";
    }

    public Corrida getCorrida() {
        return corrida;
    }

    public void setCorrida(Corrida corrida) {
        this.corrida = corrida;
    }

    public CorridaService getCorridaService() {
        return corridaService;
    }

    public void setCorridaService(CorridaService corridaService) {
        this.corridaService = corridaService;
    }

    public List<Corrida> getCorridas() {
        return corridas;
    }

    public void setCorridas(List<Corrida> corridas) {
        this.corridas = corridas;
    }

}
