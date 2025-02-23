import dao.ClienteDAO;
import dao.HabitacionDAO;
import dao.TrabajadorDAO;
import database.HibernateUtil;
import model.Cliente;
import model.Direccion;
import model.Habitacion;
import model.Trabajador;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.exception.spi.ViolatedConstraintNameExtractor;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Scanner;

public class Entrada {
    public static void main(String[] args) {
      /*  //insercion
        Scanner scanner=new Scanner(System.in);
        SessionFactory sessionFactory= new HibernateUtil().getSessionFactory();
        Session session=sessionFactory.getCurrentSession();
        session.beginTransaction();
      //  System.out.println("Introduce datos trabajador, nombre, apellido, direccion,telefono");
      //  session.persist(new Trabajador(scanner.next(), scanner.next(), scanner.next(),scanner.nextInt()));
      //  Trabajador t = session.get(Trabajador.class,3);
      //  Trabajador trabajador=new Trabajador(3);
       // session.delete(trabajador);
       // Trabajador trabajador=session.get(Trabajador.class,3);
      //  trabajador.setDireccion("San Sebastian");
      //  session.merge(trabajador);
        //___________
        //Seleccion avanzada
        //Select *From Empleados
        Query<Trabajador> query=session.createQuery("SELECT t FROM Trabajador t", Trabajador.class);
        List<Trabajador> listaTrabajadores=query.list();
        for (Trabajador trabajador:listaTrabajadores){
            System.out.println(trabajador);
        }
        session.getTransaction().commit();
//System.out.println(t);
        session.close();*/
     /*   try {
            TrabajadorDAO trabajadorDAO=new TrabajadorDAO();
            trabajadorDAO.insertarUsuario(new Trabajador("Esther", "Red", new Direccion("Madrid","Madrid"),new Direccion("Barcelona","Barcelona"),999778855));
        }catch (ConstraintViolationException e){
            System.out.println("Error porque coinciden dos telefonos iguales");
        }*/
        TrabajadorDAO trabajadorDAO = new TrabajadorDAO();
        // trabajadorDAO.seleccionarTodosByLocalidad("Barcelona");
        // trabajadorDAO.seleccionarTodosByProvincia("Madrid");
        //  trabajadorDAO.actualizarNombre("Adrian2");
        HabitacionDAO habitacionDAO = new HabitacionDAO();
        // habitacionDAO.crearHabitacion(new Habitacion(2,20,4));
       /* trabajadorDAO.insertarTrabajador(new Trabajador("Marcos","Garcia",
                new Direccion("Pamplona","Navarra"),
                new Direccion("Madrid","Madrid"),1223),1);*/
      /*  trabajadorDAO.insertarTrabajador2(new Trabajador("Chus","Garcia",
                new Direccion("Pamplona","Navarra"),
                new Direccion("Madrid","Madrid"),1226),new Habitacion(5,500,2));*/
        //trabajadorDAO.seleccionHabitacionTrabajador(9);
        // habitacionDAO.getTrabajadorHabitacion(4);
        ClienteDAO clienteDAO = new ClienteDAO();
        // clienteDAO.crearCliente(new Cliente("Porta"),3);
        //    habitacionDAO.getAllCliente(3);
/*
        Session session=new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Cliente cliente=session.get(Cliente.class,2);
        //Ver que trabajadores han hecho la reserva a cliente
        for(Trabajador trabajador:cliente.getListaTrabajadores()){
            System.out.println(trabajador.getNombre());
        }
        session.getTransaction().commit();
        session.close();
   / *

 */

      /*  Session session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        //Sacar los clientes que tiene un empleado.
        Trabajador trabajador = session.get(Trabajador.class, 1);
        for (Cliente cliente : trabajador.getListaClientes()) {
            System.out.println(cliente.getNombre());
        }
        session.getTransaction().commit();
        session.close();*/

        Session session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        //Agregar reserva
        Cliente cliente=session.get(Cliente.class,1);
        Trabajador trabajador = session.get(Trabajador.class, 1);
        cliente.getListaTrabajadores().add(trabajador);
        trabajador.getListaClientes().add(cliente);
        session.persist(cliente);
        session.persist(trabajador);
        session.getTransaction().commit();
        session.close();
    }
}
