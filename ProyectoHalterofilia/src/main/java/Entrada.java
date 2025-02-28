import controller.HalteroController;
import model.Atleta;
import model.Club;
import model.Coach;
import model.Competicion;

import java.time.LocalDate;

public class Entrada {
    public static void main(String[] args) {

        //RELACION UNO A UNO COACH--CLUB
        //RELACION MUCHOS A UNO O UNO A MUCHOS, ATLETA--CLUB
        //RELACION MUCHOS A MUCHOS, COMPETICION--ATLETAS
        
        HalteroController halteroController= new HalteroController();

      // halteroController.introducirCoach(new Coach("Adrian Ocra",2,"Clean"));
      //  halteroController.introducirCoachConExperiencia(new Coach("Rodrigo Tena",1,"CJ"));
        //  halteroController.introducirAtleta(new Atleta("Carlota Theram",67.4,"mujer",45,52));
       // halteroController.introducirClub(new Club("Anaitasuna","Pamplona", LocalDate.of(1946,05,05)));
      /*  halteroController.introducirClub(new Club("Queiron","Pamplona",LocalDate.of(2012,05,29),
                new Coach("Emilio Guaji",5,"Clean and Jerk")));*/
    //halteroController.introducirCompeticion(new Competicion("Navidad", LocalDate.of(2025,05,05),"Pamplona"));
  //  halteroController.ficharClub(1,1);
      //  halteroController.analizarClub(1);
   // halteroController.analizarCompeticion(1);
//halteroController.estructuraCompeticion(2);
//halteroController.buscarAtletasHombresPorRM(50);
//halteroController.buscarAtletasMujeresPorRM(81);
    }

}
