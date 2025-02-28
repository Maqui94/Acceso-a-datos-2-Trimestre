package dao;

import database.HibernateUtil;
import model.Atleta;
import model.Coach;
import org.hibernate.Session;

public class CoachDAO {
    private Session session;
    public void agregarCoach(Coach coach){

        session=new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.persist(coach);
        session.getTransaction().commit();
        session.close();
    }
    public Coach obtenerCoach(int id){
        session= new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Coach coach=session.get(Coach.class,id);
        session.getTransaction().commit();
        session.close();
        return coach;
    }
}
