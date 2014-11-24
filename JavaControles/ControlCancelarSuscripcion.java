package controles;
import entidades.Suscripcion;

public class ControlRenovarSuscripcion {
   Suscripcion s1;

   public ControlRenovarSuscripcion(){
     s1 = new Suscripcion(); //Asume que la instancia persiste durante la sesion
   }
   
  //NO SABEMOS SI OCUPAMOS UN ID DEL CLIENTE PARA SABER DE QUIEN ES LA SUSCRIPCION
  
   public void cancelarSuscripcion(int idSuscriptor){
       s1.cancelarSuscripcion(idSuscriptor);

   }
   
  
}
