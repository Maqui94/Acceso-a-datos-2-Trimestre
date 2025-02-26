package dao;

import database.HibernateUtil;
import model.Editorial;
import org.hibernate.Session;

public class EditorialDAO {
    private Session session;

    public void agregarEditorial(Editorial editorial){
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.persist(editorial);
        session.getTransaction().commit();
        session.close();
    }
    public Editorial obtenerEditorial(int id){

        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Editorial Editorial = session.get(Editorial.class,1);
        session.getTransaction().commit();
        session.close();
        return Editorial;
    }
}
