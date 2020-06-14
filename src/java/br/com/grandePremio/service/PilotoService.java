package br.com.grandePremio.service;

import br.com.grandePremio.dao.PilotoDao;
import br.com.grandePremio.domain.Gp;
import br.com.grandePremio.domain.Piloto;
import java.util.List;


public class PilotoService {
    
    private PilotoDao pilotoDao = new PilotoDao();

    public List<Piloto> listar() {
        return pilotoDao.listar();
    }
    
    public List<Piloto> listarInner() {
        return pilotoDao.listarInner();
    }

    public Piloto consultar(Integer id) {
        return pilotoDao.consulta(id);
    }

    public boolean inserir(Piloto piloto) {
        return pilotoDao.inserir(piloto);
    }

    public boolean alterar(Piloto piloto) {
        return pilotoDao.alterar(piloto);
    }

    public boolean excluir(Piloto piloto) {
        return pilotoDao.excluir(piloto);
    }
    
    
    public void lancaGp(List<Gp> lista) {
        Integer pt = 0;
        Piloto piloto = null;
        for (Gp gp : lista) {
            piloto = pilotoDao.consulta(gp.getPiloto().getId());
            if (piloto != null) {
                gp.getPiloto().setPontos(gp.getPontuacao() + piloto.getPontos());
            }

            pilotoDao.alterar(gp.getPiloto());
        }
    }
    
}
