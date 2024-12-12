package src.futbolhibernate;

import org.hibernate.Session;
import src.futbolhibernate.model.Divisions;

public class CRUD_Divisions implements DAO<Divisions, String> {

    private final Session session;

    public CRUD_Divisions(Session session) {
        this.session = session;
    }

    @Override
    public String  insertar(Divisions divisions) {
        session.beginTransaction();
        session.persist(divisions);
        session.getTransaction().commit();
        return divisions.getDivision();
    }

    @Override
    public String actualizar(Divisions divisions) {
        session.beginTransaction();
        session.merge(divisions);
        session.getTransaction().commit();
        return divisions.getDivision();
    }

    @Override
    public String eliminar(Divisions divisions) {
        session.beginTransaction();
        session.remove(divisions);
        session.getTransaction().commit();
        return divisions.getDivision();
    }

    @Override
    public Divisions buscar(String id) {
        session.beginTransaction();
        Divisions divisions = session.get(Divisions.class, id);
        session.getTransaction().commit();
        return divisions;
    }
}
