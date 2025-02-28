package controller;

import dao.AtletaDAO;
import dao.ClubDAO;
import dao.CoachDAO;
import dao.CompeticionDAO;
import database.HibernateUtil;
import model.Atleta;
import model.Club;
import model.Coach;
import model.Competicion;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class HalteroController {
    public CoachDAO coachDAO;
    public ClubDAO clubDAO;
    public CompeticionDAO competicionDAO;
    public AtletaDAO atletaDAO;

    public HalteroController(){
        coachDAO=new CoachDAO();
        clubDAO= new ClubDAO();
        competicionDAO=new CompeticionDAO();
        atletaDAO=new AtletaDAO();
    }
    public void introducirCoach(Coach coach){
        coachDAO.agregarCoach(coach);
        System.out.println("Coach Incluido");
    }
    public void introducirCoachConExperiencia(Coach coach){
        if (coach.getExperiencia()<2){
            System.out.println("No vale para el puesto");
        }else{
            coachDAO.agregarCoach(coach);
            System.out.println("Coach Incluido");
        }
    }
    public void introducirClub(Club club){
        clubDAO.agregarClub(club);
        System.out.println("Club Incluido");
    }
    public void introducirAtleta(Atleta atleta){
        atletaDAO.agregarAtleta(atleta);
        System.out.println("Atleta Incluido");
    }
    public void introducirCompeticion(Competicion competicion){
        competicionDAO.agregarCompeticion(competicion);
        System.out.println("Competición Incluida");
    }

    public void ficharClub(int idAtleta, int idClub){
        Club club=clubDAO.getClub(idClub);
        Atleta atleta=atletaDAO.obtenerAtleta(idAtleta);
        //logica de contratacion
        atleta.setClub(club);
        atletaDAO.actualizarAtleta(atleta);
        System.out.println("Atleta modificado");
    }

    public void analizarClub(int id) {
        Club club = clubDAO.getClub(id);
        List<Atleta> atletas = clubDAO.obtenerAtletasClub(id);
        System.out.println("Club: " + club.getNombre());

        if (atletas.isEmpty()) {
            System.out.println("Este club no tiene atletas inscritos.");
        } else {
            System.out.println("Atletas inscritos:");
            for (Atleta atleta : atletas) {
                System.out.println("- " + atleta.getNombre());
            }
        }
    }
    public void analizarCompeticion(int idCompeticion) {
        Competicion competicion = competicionDAO.obtenerCompeticion(idCompeticion);
        List<Atleta> atletas = competicion.getAtletas();
        System.out.println("Competición: " + competicion.getNombre());
        if (atletas.isEmpty()) {
            System.out.println("No hay atletas inscritos en esta competición.");
            return;
        }
        List<Club> clubesMostrados = new ArrayList<>();
        for (Atleta atleta : atletas) {
            Club club = atleta.getClub();
            if (club != null && !clubesMostrados.contains(club)) {
                clubesMostrados.add(club);
            }
        }
        for (Club club : clubesMostrados) {
            System.out.println("\nClub: " + club.getNombre());

            for (Atleta atleta : atletas) {
                if (atleta.getClub() == club) {
                    System.out.println("- " + atleta.getNombre());
                }
            }
        }
    }


    public void inscribirAtletaACompeticion(int idAtleta, int idCompeticion) {
        Atleta atleta = atletaDAO.obtenerAtleta(idAtleta);
        Competicion competicion = competicionDAO.obtenerCompeticion(idCompeticion);
        atleta.getCompeticiones().add(competicion);
        competicion.getAtletas().add(atleta);
        atletaDAO.actualizarAtleta(atleta);

        System.out.println("El atleta " + atleta.getNombre() + " inscrito en la competición " + competicion.getNombre());
    }
    public void estructuraCompeticion(int idCompeticion) {
        Competicion competicion = competicionDAO.obtenerCompeticion(idCompeticion);
        List<Atleta> atletas = competicion.getAtletas();
        System.out.println("Estructura de la Competición: " + competicion.getNombre());

        if (atletas.isEmpty()) {
            System.out.println("No hay atletas inscritos en esta competición.");
            return;
        }

        String[] categoriasHombres = {"Menos de 61 kg", "61 kg - 67 kg", "67 kg - 73 kg", "73 kg - 81 kg", "81 kg - 89 kg", "89 kg - 96 kg", "96 kg - 102 kg", "Más de 102 kg"};
        String[] categoriasMujeres = {"Menos de 49 kg", "49 kg - 55 kg", "55 kg - 59 kg", "59 kg - 64 kg", "64 kg - 71 kg", "71 kg - 76 kg", "76 kg - 81 kg", "Más de 81 kg"};

        // Recorrer las categorías y mostrar los atletas
        System.out.println("\n🏋️ Categorías Masculinas:");
        for (String categoria : categoriasHombres) {
            System.out.println("\n" + categoria + ":");
            for (Atleta atleta : atletas) {
                if (atleta.getSexo().equalsIgnoreCase("Hombre") && competicion.perteneceCategoriaHombre(atleta.getPeso(), categoria))
                    System.out.println("- " + atleta.getNombre() + " (" + atleta.getPeso() + " kg)");
                }
            }


        System.out.println("\n🏋️‍♀️ Categorías Femeninas:");
        for (String categoria : categoriasMujeres) {
            System.out.println("\n" + categoria + ":");
            for (Atleta atleta : atletas) {
                if (atleta.getSexo().equalsIgnoreCase("Mujer") && competicion.perteneceCategoriaMujer(atleta.getPeso(), categoria)) {
                    System.out.println("- " + atleta.getNombre() + " (" + atleta.getPeso() + " kg)");
                }
            }
        }
    }
    public void buscarAtletasMujeresPorRM(double pesoMinimoSnacht) {
        System.out.println("Atletas femeninas con RM Snacht mayor a " + pesoMinimoSnacht + " kg...");
        List<Atleta> atletas = atletaDAO.buscarAtletasPorRM(pesoMinimoSnacht, "Mujer");
        if (atletas.isEmpty()) {
            System.out.println("No hay mujeres con RM Snacht mayor a "+ pesoMinimoSnacht +" kg.");
        } else {
            for (Atleta atleta : atletas) {
                System.out.println("- "+ atleta.getNombre() + " Peso: "+ atleta.getPeso() + " kg, RM Snacht: " + atleta.getRm_clean_jerk() + " kg");
            }
        }
    }
    public void buscarAtletasHombresPorRM(double pesoMinimoCleanJerk) {
        System.out.println("atletas masculinos con RM Clean & Jerk mayor a " + pesoMinimoCleanJerk + " kg...");
        List<Atleta> atletas = atletaDAO.buscarAtletasPorRM(pesoMinimoCleanJerk, "Hombre");
        if (atletas.isEmpty()) {
            System.out.println("No se encontraron hombres con RM Clean & Jerk mayor a " + pesoMinimoCleanJerk + " kg.");
        } else {
            for (Atleta atleta : atletas) {
                System.out.println("- " + atleta.getNombre() + " | Peso: " + atleta.getPeso() + " kg | RM C&J: " + atleta.getRm_clean_jerk() + " kg");
            }
        }
    }

}

