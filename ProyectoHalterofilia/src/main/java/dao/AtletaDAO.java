package dao;

import database.HibernateUtil;
import model.Atleta;
import org.hibernate.Session;

import java.util.List;

public class AtletaDAO {
    private Session session;

    public void agregarAtleta(Atleta atleta){

        session=new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.persist(atleta);
        session.getTransaction().commit();
        session.close();
    }
    public Atleta obtenerAtleta(int id){
        session= new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Atleta atleta=session.get(Atleta.class,id);
        session.getTransaction().commit();
        session.close();
        return atleta;
    }
    public void actualizarAtleta(Atleta atleta){
        session= new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.merge(atleta);
        session.getTransaction().commit();
        session.close();
    }
    public List<Atleta> buscarAtletasPorRM(double pesoMinimoCleanJerk, String sexo) {
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Atleta> atletas = session.createQuery(
                        "FROM Atleta WHERE sexo = :sexo AND rm_clean_jerk > :pesoMin", Atleta.class)
                .setParameter("sexo", sexo)
                .setParameter("pesoMin", pesoMinimoCleanJerk)
                .getResultList();
        session.getTransaction().commit();
        session.close();
        return atletas;
    }

}
