package dao;

import database.HibernateUtil;
import model.Autor;
import model.Editorial;
import model.Libro;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class AutorDAO {
    private Session session;
    public void agregartAutor(Autor autor){
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.persist(autor);
        session.getTransaction().commit();
        session.close();
    }
    public Autor obtenerAutor(int id){

        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Autor autor = session.get(Autor.class,1);
        session.getTransaction().commit();
        session.close();
        return autor;
    }
    public List<Autor> getAllAutores() {
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query<Autor> query = session.createQuery("FROM Autor", Autor.class);
        List<Autor> listasAutor = query.list();
        session.getTransaction().commit();
        session.close();
        return listasAutor;
    }
}
