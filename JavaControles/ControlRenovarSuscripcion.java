package controles;
import entidades.Suscriptor;

public class ControlRenovarSuscripcion {
	Suscriptor s1;

	public ControlRenovarSuscripcion(){
		s1 = new Suscriptor(); //Asume que la instancia persiste durante la sesion
	}

	public void renovarSuscripcion(int m, int idS){
		s1.renovarSuscripcion(m,idS);
	}


}