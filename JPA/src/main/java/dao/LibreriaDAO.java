package dao;

import database.HibernateUtil;
import model.Libreria;
import model.Libro;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class LibreriaDAO {
    private Session session;
    public void agregarLibreria(Libreria libreria){
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.persist(libreria);
        session.getTransaction().commit();
        session.close();
    }
    public List<Libreria> obtenerTodasLasLibrerias() {
        Session session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query<Libreria> query = session.createQuery("FROM Libreria", Libreria.class);
        List<Libreria> librerias = query.list();
        session.getTransaction().commit();
        session.close();
        return librerias;
    }


}
