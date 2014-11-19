public class Articulo {
	private int idArticulo;
	private String nombre;
	private String fechaRevision;
	private String fechaPublicacion;
	private boolean estadoArticulo;

	protected String getNombre() {
		return nombre;
	}

	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}

	protected String getFechaRevision() {
		return fechaRevision;
	}

	protected void setFechaRevision(String fechaRevision) {
		this.fechaRevision = fechaRevision;
	}

	protected String getFechaPublicacion() {
		return fechaPublicacion;
	}

	protected void setFechaPublicacion(String fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	protected boolean isEstadoArticulo() {
		return estadoArticulo;
	}

	protected void setEstadoArticulo(boolean estadoArticulo) {
		this.estadoArticulo = estadoArticulo;
	}

	protected int getIdArticulo() {
		return idArticulo;
	}
}
