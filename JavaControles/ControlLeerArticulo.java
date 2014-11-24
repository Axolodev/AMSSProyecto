package controles;
import entidades.Articulo;

public class ControlLeerArticulo{
	private Articulo articulo;

	ControlLeerArticulo(){
		articulo = new Articulo();
	}

	public String[] listaArticulos(){
		String[] lista = articulo.listaArticulos();
		return lista;
	}


}