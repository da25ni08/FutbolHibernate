package src.futbolhibernate;

import org.hibernate.Session;
import src.futbolhibernate.model.Matchs;

public class CRUD_Matchs implements DAO<Matchs, Integer> {

    private Session session;

    public CRUD_Matchs(Session session) {
        this.session = session;
    }

    @Override
    public Integer insertar(Matchs matchs) {
        session.beginTransaction();
        session.persist(matchs);
        session.getTransaction().commit();
        return matchs.getId_match();
    }

    @Override
    public Integer actualizar(Matchs matchs) {
        session.beginTransaction();
        session.merge(matchs);
        session.getTransaction().commit();
        return matchs.getId_match();
    }

    @Override
    public Integer eliminar(Matchs matchs) {
        session.beginTransaction();
        session.remove(matchs);
        session.getTransaction().commit();
        return matchs.getId_match();
    }

    @Override
    public Matchs buscar(Integer id) {
        session.beginTransaction();
        Matchs matchs = session.get(Matchs.class, id);
        session.getTransaction().commit();
        return matchs;
    }
}
