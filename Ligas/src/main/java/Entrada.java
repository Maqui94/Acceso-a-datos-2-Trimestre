import controller.LigaController;
import model.Entrenador;
import model.Jugador;
import model.Liga;

public class Entrada {
    public static void main(String[] args) {

        LigaController ligaController=new LigaController();
        //ligaController.agregarEntrenador(new Entrenador("BorjaEntrenador",0,11));
       // ligaController.contratarEntrenador(1,1);
      /* ligaController.darAltaLiga(new Liga("Mexicana"));
        ligaController.darAltaLiga(new Liga("Argentina"));
        ligaController.darAltaLiga(new Liga("Brasileña"));
        ligaController.darAltaLiga(new Liga("2º division española"));*/

       // ligaController.inscribirseLiga(1,1);
       //  ligaController.crearJugador(new Jugador("Julian",10000,"Española"),4);
       // ligaController.contratarJugador(1,1);
        // ligaController.analizarPlantilla(1);
       // ligaController.getEquiposCompeticion(2);
     // ligaController.obtenerLigas();
        ligaController.buscarPorNacionalidad();
    }
}
