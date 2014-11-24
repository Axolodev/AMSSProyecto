package controles;
import entidades.Juez;

public class ControlEvaluarActividadJuez {
   Juez juez;

   public ControlEvaluarActividadJuez(){
     juez = new Juez(); //Asume que la instancia persiste durante la sesion
   }
   
  
   public void evaluarJuez(int idJ, String cal){
       juez.setCalificacion(cal,idJ)

   }
   
  
}
