abstract class Persona {
	protected String nombre;
	protected String direccion;
	protected String nacimiento;
	protected int edad;
	protected String nacionalidad;
	protected String genero;

	protected Persona() {
		nombre = "";
		direccion = "";
		nacimiento = "31/12/1990";
		edad = 1;
		nacionalidad = "";
		genero = "";
	}

	protected String getNombre() {
		return nombre;
	}

	protected String getGenero() {
		return genero;
	}

	protected void setGenero(String genero) {
		this.genero = genero;
	}

	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}

	protected String getDireccion() {
		return direccion;
	}

	protected void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	protected String getNacimiento() {
		return nacimiento;
	}

	protected void setNacimiento(String nacimiento) {
		this.nacimiento = nacimiento;
	}

	protected int getEdad() {
		return edad;
	}

	protected void setEdad(int edad) {
		this.edad = edad;
	}

	protected String getNacionalidad() {
		return nacionalidad;
	}

	protected void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

}
