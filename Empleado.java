import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Empleado extends Persona {
	private int idEmpleado;
	private String cargo;

	public Empleado(int idEmpleado, String cargo) {
		super();
		this.idEmpleado = idEmpleado;
		this.cargo = cargo;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public int getIdEmpleado() {
		return idEmpleado;
	}

	public void generarNuevoSitio(Articulo articulo) {
		try {
			PrintWriter out = new PrintWriter(new FileWriter("Articulos\\art"
					+ articulo.getIdArticulo() + ".html"));
			out.println("<html><head><title>" + articulo.getNombre()
					+ "</title> </head><body>");

			BufferedReader br;
			br = new BufferedReader(new FileReader("Articulos\\Art"
					+ articulo.getIdArticulo() + ".html"));
			String line = null;

			while ((line = br.readLine()) != null) {
				out.println(line);
			}

			br.close();
			out.println("</body> </html>");
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
