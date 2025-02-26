package dao;

import database.HibernateUtil;
import model.Autor;
import model.Editorial;
import model.Libro;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class LibroDAO {
    private Session session;

    public void agregartLibro(Libro libro, Autor autor, Editorial editorial) {
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        libro.setAutor(autor);
        libro.setEditorial(editorial);
        session.merge(libro);
        session.getTransaction().commit();
        session.close();
    }

    public Libro obtenerAutor(int id) {

        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Libro libro = session.get(Libro.class, 1);
        session.getTransaction().commit();
        session.close();
        return libro;
    }

    public List<Libro> getAllLibros() {
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query<Libro> query = session.createQuery("FROM Libro", Libro.class);
        List<Libro> listaLibros = query.list();
        session.getTransaction().commit();
        session.close();
        return listaLibros;
    }


    public List<Libro> obtenerTodosLosLibros() {
        Session session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query<Libro> query = session.createQuery("FROM Libro", Libro.class);
        List<Libro> libros = query.list();
        session.getTransaction().commit();
        session.close();
        return libros;
    }

}