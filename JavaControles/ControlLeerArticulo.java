package controles;
import java.util.*;
import java.io.*;
import entidades.Articulo;

public class ControlLeerArticulo{
	private Articulo articulo;
	private List<String> list;

	public ControlLeerArticulo(){
		articulo = new Articulo();
		list = new ArrayList<String>();
	}

	public String tomaTitulo(int idArticulo){
		return articulo.getNombre(idArticulo);
	}

	public String[] recibeTexto(int idArticulo){
		String []texto = articulo.getTexto(idArticulo).split("\n");
		return texto;
	}


}