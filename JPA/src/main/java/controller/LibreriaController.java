package controller;

import dao.AutorDAO;
import dao.EditorialDAO;
import dao.LibreriaDAO;
import dao.LibroDAO;
import database.HibernateUtil;
import model.Autor;
import model.Editorial;
import model.Libreria;
import model.Libro;
import org.hibernate.Session;

import java.util.List;

public class LibreriaController {
    private LibroDAO libroDAO;
    private AutorDAO autorDAO;
    private LibreriaDAO libreriaDAO;
    private EditorialDAO editorialDAO;

    public LibreriaController(){

        libroDAO= new LibroDAO();
        autorDAO=new AutorDAO();
        editorialDAO=new EditorialDAO();
        libreriaDAO=new LibreriaDAO();

    }

    public void altaAutor(Autor autor){
        autorDAO.agregartAutor(autor);
    }
    public void altaEditorial(Editorial editorial){
        editorialDAO.agregarEditorial(editorial);
    }
    public void altaLibro(Libro libro, int idAutor, int idEditorial){
        Session session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Autor autor = session.get(Autor.class, idAutor);
        Editorial editorial = session.get(Editorial.class, idEditorial);
        session.getTransaction().commit();
        session.close();
        libroDAO.agregartLibro(libro,autor,editorial);
    }
    public void obtenerLibros(){
        for (Libro item:libroDAO.getAllLibros()) {
            System.out.println("El nombre del libro es: "+ item.getTitulo());
            System.out.println(("El autor es ")+item.getAutor().getNombre()+" "+item.getAutor().getApellidos());
            System.out.println(("La editorial es ")+item.getEditorial().getNombre());
            System.out.println("-----------------");
        }
    }
    public void obtenerAutores(){
        for (Autor item:autorDAO.getAllAutores()) {
            System.out.println("El nombre del autor es: "+ item.getNombre()+" "+ item.getApellidos());
            System.out.println("Sus libros son ");
            for (Libro libro: item.getLibros()) {
                System.out.println("\t"+libro.getTitulo());
            }

        }
    }
    public void obtenerTodosLosLibros(){
        List<Libro> libros = libroDAO.obtenerTodosLosLibros();
        for (Libro libro :libros){
            System.out.println("Libro: "+ libro.getTitulo());
            if (libro.getLibrerias() == null || libro.getLibrerias().isEmpty()) {
                System.out.println("No disponible en las librerías");
            } else {
                for (Libreria libreria : libro.getLibrerias()) {
                    System.out.println("Disponible en la librería: " + libreria.getNombre());
                }
            }
            System.out.println("--------------------------");
        }
    }
    public void obtenerAllLiberias(){

        List<Libreria> librerias = libreriaDAO.obtenerTodasLasLibrerias();

        for (Libreria libreria : librerias) {
            System.out.println("Librería: " + libreria.getNombre());
            for (Libro libro : libreria.getLibros()) {
                System.out.println("\tLibro: " + libro.getTitulo());
            }
        }
    }


}
