import java.io.BufferedReader;
import java.io.FileReader;

public class Suscriptor extends Persona {

	private int idSuscriptor;
	private String fechaInicioSuscripcion;
	private String fechaVencimientoSuscripcion;

	public Suscriptor(int id_suscriptor, String fecha_inicio_suscripcion,
			String fecha_vencimiento_suscripcion) {
		super();
		this.idSuscriptor = id_suscriptor;
		this.fechaInicioSuscripcion = fecha_inicio_suscripcion;
		this.fechaVencimientoSuscripcion = fecha_vencimiento_suscripcion;
	}

	protected String getFecha_inicio_suscripcion() {
		return fechaInicioSuscripcion;
	}

	protected void setFecha_inicio_suscripcion(String fecha_inicio_suscripcion) {
		this.fechaInicioSuscripcion = fecha_inicio_suscripcion;
	}

	protected String getFecha_vencimiento_suscripcion() {
		return fechaVencimientoSuscripcion;
	}

	protected void setFecha_vencimiento_suscripcion(
			String fecha_vencimiento_suscripcion) {
		this.fechaVencimientoSuscripcion = fecha_vencimiento_suscripcion;
	}

	protected int getId_suscriptor() {
		return idSuscriptor;
	}

	public void cancelarSuscripcion() {
		fechaInicioSuscripcion = "";
		fechaVencimientoSuscripcion = "";
	}

	public void renovarSuscripcion(int meses) {

		if (fechaInicioSuscripcion.compareTo("") != 0) {
			String[] parts = fechaVencimientoSuscripcion.split("-");
			int month = Integer.parseInt(parts[1]);
			int year = Integer.parseInt(parts[2]);
			month = month + meses;
			while (month - 12 > 12) {
				month -= 12;
				year++;
			}
			fechaVencimientoSuscripcion = parts[0] + "-" + month + "-" + year;
		} else {
			/**
			 * @Todo Asignar fecha deseada a fecha de inicio.
			 * @Todo Asignar fecha de vencimiento a fecha de inicio + meses
			 */

		}

	}

	public void generarPedido(int[] numeros) {
		for (int i = 0; i < numeros.length; i++) {
			System.out.println("Agregado numero " + numeros[i] + " al pedido.");
		}
	}

	public boolean login(int id) {
		return this.idSuscriptor == id;
	}

	public void leerArticulo(Articulo articulo) {
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader("Articulos\\Art"
					+ articulo.getIdArticulo() + ".html"));
			String line = null;

			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
