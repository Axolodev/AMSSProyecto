public class EditorJefe extends Persona {

	private int id_editor;

	public EditorJefe(int id_editor) {
		this.id_editor = id_editor;
	}

	public int getId_editor() {
		return id_editor;
	}

	public String evaluarJuez(Juez juez, String evaluacion) {
		return "El " + juez.toString() + " ha sido evaluado " + evaluacion;
	}

	public Articulo revisarArticulo(Articulo art, boolean aprovado) {
		art.setEstadoArticulo(aprovado);
		return art;
	}
	public void seleccionarJuez(Autor autor){
		//Generar nuevo juez con el autor ingresado
	}
}
