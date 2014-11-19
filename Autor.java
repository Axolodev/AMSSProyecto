public class Autor extends Persona {
	private int id_autor;
	private String generoTema;

	public String getGeneroTema() {
		return generoTema;
	}

	public void setGeneroTema(String generoTema) {
		this.generoTema = generoTema;
	}

	public int getId_autor() {
		return id_autor;
	}

	public Autor(int id_autor) {
		super();
		this.id_autor = id_autor;
	}

	public void registrarArticulo(){
		// generar nuevo articulo
	}
	
}
