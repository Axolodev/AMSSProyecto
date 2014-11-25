package controles;
import entidades.Articulo;

public class ControlRevisarArticulo {
   Articulo articulo;

   public ControlRevisarArticulo(){
     articulo = new Articulo(); //Asume que la instancia persiste durante la sesion
   }
 
  
   public void revisarArticulo(int idArt, String respuesta){
   	boolean res = respuesta.equals("Revisado");

    articulo.setEstadoArticulo(idArt,res);

   }
   
  
}
