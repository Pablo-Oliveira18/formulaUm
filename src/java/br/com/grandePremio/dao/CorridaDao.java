package br.com.grandePremio.dao;

import br.com.grandePremio.domain.Corrida;
import br.com.grandePremio.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;


public class CorridaDao {
    public List<Corrida> listar() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try {
            List<Corrida> corridas = session.createQuery("from Corrida").list();
            session.getTransaction().commit();
            return corridas;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }
    }

    public Corrida consulta(Integer id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try {
            Corrida corrida = (Corrida) session.createQuery("from Corrida where id = " + id).uniqueResult(); // uniqueResult retorna apenas 1 resultado
            session.getTransaction().commit();
            return corrida;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }
    }

    public boolean inserir(Corrida corrida) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try {
            session.save(corrida);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }

    }

    public boolean excluir(Corrida corrida) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try {
            session.delete(corrida);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }

    }

    public boolean alterar(Corrida corrida) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try {
            session.update(corrida);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }

    }
    
}
