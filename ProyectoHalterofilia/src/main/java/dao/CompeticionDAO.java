package dao;

import database.HibernateUtil;
import model.Atleta;
import model.Competicion;
import org.hibernate.Session;

public class CompeticionDAO {
    private Session session;
    public void agregarCompeticion(Competicion competicion){

        session=new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.persist(competicion);
        session.getTransaction().commit();
        session.close();
    }
    public Competicion obtenerCompeticion(int id) {
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Competicion competicion = session.get(Competicion.class, id);
        session.getTransaction().commit();
        session.close();
        return competicion;
    }

}
