package entidades;
import java.sql.*;
import java.io.*;
 
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Suscriptor extends Persona {
	Connection conn;
	Statement stmt;
	public Suscriptor() {
		try {
			String userName = "root";
			String password = "";
			String url = "jdbc:mysql://localhost/SengBytes";
			Class.forName ("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection (url, userName, password);
			stmt = conn.createStatement();
		}catch (Exception e) { 
			System.out.println ("Cannot connect to database server"); 
		}
	}

	public String getFechaInicioSuscripcion(int idSuscriptor) {
		String fechaInicioSuscripcion = ""; 
		try {
			stmt.executeQuery ("SELECT fechaInicioSuscripcion FROM Suscriptor WHERE idSuscriptor = " + idSuscriptor);
			ResultSet rs = stmt.getResultSet();
         rs.next(); //Va al registro ya validado
         fechaInicioSuscripcion = rs.getString("fechaInicioSuscripcion");
         rs.close();
         return(fechaInicioSuscripcion);
     } catch (SQLException e) {System.out.println ("Cannot getFechaInicioSuscripcion()" + e);
 }
 return fechaInicioSuscripcion;
}

public void setFechaVencimientoSuscripcion(String fechaVencimientoSuscripcion, int idSuscriptor) {
	try {
		String s = "UPDATE Suscriptor SET fechaVencimientoSuscripcion = " + fechaVencimientoSuscripcion + " WHERE idSuscriptor = " + idSuscriptor;
		stmt.executeUpdate(s);
	} catch (SQLException e) {
		System.out.println ("Cannot execute setFechaVencimientoSuscripcion()" + e);
	}
}

public String getFechaVencimientoSuscripcion(int idSuscriptor) {
	String fechaVencimientoSuscripcion = ""; 
	try {
		stmt.executeQuery ("SELECT fechaVencimientoSuscripcion FROM Suscriptor WHERE idSuscriptor = " + idSuscriptor);
		ResultSet rs = stmt.getResultSet();
         rs.next(); //Va al registro ya validado
         fechaVencimientoSuscripcion = rs.getString("fechaVencimientoSuscripcion");
         rs.close();
         return(fechaVencimientoSuscripcion);
     } catch (SQLException e) {System.out.println ("Cannot getFechaInicioSuscripcion()" + e);
 }
 return fechaVencimientoSuscripcion;
}

public void setFechaInicioSuscripcion(
	String fechaInicioSuscripcion, int idSuscriptor) {
	try {
		String s = "UPDATE Suscriptor SET fechaInicioSuscripcion = " + fechaInicioSuscripcion + " WHERE idSuscriptor = " + idSuscriptor;
		stmt.executeUpdate(s);
	} catch (SQLException e) {
		System.out.println ("Cannot execute setFechaInicioSuscripcion()" + e);
	}
}


public void cancelarSuscripcion(int idSuscriptor) {
	String fechaInicioSuscripcion = "";
	String fechaVencimientoSuscripcion = "";
	try {
		String s = "UPDATE Suscriptor SET fechaVencimientoSuscripcion = '" + fechaVencimientoSuscripcion + "' WHERE idSuscriptor = " + idSuscriptor;
		stmt.executeUpdate(s);
		s = "UPDATE Suscriptor SET fechaInicioSuscripcion = '" + fechaInicioSuscripcion + "' WHERE idSuscriptor = " + idSuscriptor;
		stmt.executeUpdate(s);
	} catch (SQLException e) {
		System.out.println ("Cannot execute setFechaVencimientoSuscripcion()" + e);
	}
}

public void renovarSuscripcion(int meses, int idSuscriptor) {
String fechaVencimientoSuscripcion = this.getFechaVencimientoSuscripcion(idSuscriptor);
String fechaInicioSuscripcion = this.getFechaInicioSuscripcion(idSuscriptor);
String[] parts;

	if (!fechaInicioSuscripcion.equals("")) {
		parts = fechaVencimientoSuscripcion.split("-");
		
	} else {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date date = new Date();
		fechaInicioSuscripcion= dateFormat.format(date);
		parts = fechaInicioSuscripcion.split("-");
		}

		int month = Integer.parseInt(parts[1]);
		int year = Integer.parseInt(parts[2]);
		month = month + meses;
		while (month - 12 > 12) {
			month -= 12;
			year++;
		}
		fechaVencimientoSuscripcion = parts[0] + "-" + month + "-" + year;

		this.setFechaInicioSuscripcion(fechaInicioSuscripcion, idSuscriptor);
		this.setFechaVencimientoSuscripcion(fechaVencimientoSuscripcion, idSuscriptor);
	}

public void crearSuscripcion(int idSuscriptor) {
String fechaVencimientoSuscripcion = this.getFechaVencimientoSuscripcion(idSuscriptor);
String fechaInicioSuscripcion = this.getFechaInicioSuscripcion(idSuscriptor);
String[] parts;

	if (!fechaInicioSuscripcion.equals("")) {
		parts = fechaVencimientoSuscripcion.split("-");
		
	} else {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date date = new Date();
		fechaInicioSuscripcion= dateFormat.format(date);
		parts = fechaInicioSuscripcion.split("-");
		}

		int month = Integer.parseInt(parts[1]);
		int year = Integer.parseInt(parts[2]);
		year++;
		
		fechaVencimientoSuscripcion = parts[0] + "-" + month + "-" + year;

		this.setFechaInicioSuscripcion(fechaInicioSuscripcion, idSuscriptor);
		this.setFechaVencimientoSuscripcion(fechaVencimientoSuscripcion, idSuscriptor);
	}

	public void generarPedido(int[] numeros) {
		for (int i = 0; i < numeros.length; i++) {
			System.out.println("Agregado numero " + numeros[i] + " al pedido.");
		}
	}

	public boolean login(int id) {
		// return this.idSuscriptor == id;
		return true;
	}

	public void leerArticulo(int idArticulo) {
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader("Articulos\\Art"
				+ idArticulo + ".html"));
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
