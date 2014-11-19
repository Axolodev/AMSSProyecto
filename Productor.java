public class Productor extends Persona {

	private int idProductor;

	protected int getIdProductor() {
		return idProductor;
	}

	/**
	 * 
	 * @param art
	 * @return
	 */
	public Articulo revisarArticulo(Articulo art, boolean aprovado) {
		art.setEstadoArticulo(aprovado);
		return art;
	}
}
