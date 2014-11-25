package controles;
import entidades.Suscriptor;

public class ControlCrearSuscripcion {
   Suscriptor s1;

   public ControlCrearSuscripcion(){
     s1 = new Suscriptor(); //Asume que la instancia persiste durante la sesion
   }
   
  //NO SABEMOS SI OCUPAMOS UN ID DEL CLIENTE PARA SABER DE QUIEN ES LA SUSCRIPCION
  
   public void crearSuscripcion(int idSuscriptor){
       s1.crearSuscripcion(idSuscriptor);

   }
   
  
}
