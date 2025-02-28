package dao;

import database.HibernateUtil;
import model.Atleta;
import model.Club;
import model.Coach;
import org.hibernate.Session;

import java.util.List;

public class ClubDAO {
    Session session;
    public void agregarClub(Club club){

        session=new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.persist(club);
        session.getTransaction().commit();
        session.close();
    }
    public Club getClub(int id){
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Club club = session.get(Club.class,id);
        session.getTransaction().commit();
        session.close();
        return club;
    }
    public void actualizarClub(Club club){
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.merge(club);
        session.getTransaction().commit();
        session.close();
    }
    public List<Atleta> obtenerAtletasClub(int id){
        session=new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Club club=session.get(Club.class,id);
        session.getTransaction();
        session.close();
        return club.getAtletas();
    }
}
