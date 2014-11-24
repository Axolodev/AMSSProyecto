package controles;
import entidades.Suscriptor;

public class ControlRenovarSuscripcion {
	Suscripcion s1;

	public ControlRenovarSuscripcion(){
		s1 = new Suscriptor(); //Asume que la instancia persiste durante la sesion
	}

//NO SABEMOS SI OCUPAMOS UN ID DEL CLIENTE PARA SABER DE QUIEN ES LA SUSCRIPCION

	public void renovarSuscripcion(int m, int idS){
		s1.renovarSuscripcion(m,idS);

	}


}