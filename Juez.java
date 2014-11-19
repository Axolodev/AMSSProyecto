public class Juez extends Persona {
	private int idJuez;
	private String fechaInicio;

	public Juez(int id_juez, String fecha_inicio) {
		super();
		this.idJuez = id_juez;
		this.fechaInicio = "";
	}

	protected String getFecha_inicio() {
		return fechaInicio;
	}

	protected void setFecha_inicio(String fecha_inicio) {
		this.fechaInicio = fecha_inicio;
	}

	protected int getId_juez() {
		return idJuez;
	}

	public String toString() {
		return "Juez [id_juez=" + idJuez + ", nombre=" + nombre + "]";
	}

	public Articulo revisarArticulo(Articulo art, boolean aprovado) {
		art.setEstadoArticulo(aprovado);
		return art;
	}

	public void sugerirTemas(String tema){
		// Agregar temas a los sugeridos 
	}
}
