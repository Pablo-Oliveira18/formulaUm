package br.com.grandePremio.service;

import br.com.grandePremio.dao.CorridaDao;
import br.com.grandePremio.domain.Corrida;
import java.util.List;


public class CorridaService {
    
        private CorridaDao corridaDao = new CorridaDao();

    public List<Corrida> listar() {
        return corridaDao.listar();
    }

    public Corrida consultar(Integer id) {
        return corridaDao.consulta(id);
    }

    public boolean inserir(Corrida corrida) {
        return corridaDao.inserir(corrida);
    }

    public boolean alterar(Corrida corrida) {
        return corridaDao.alterar(corrida);
    }

    public boolean excluir(Corrida corrida) {
        return corridaDao.excluir(corrida);
    }
    
}
