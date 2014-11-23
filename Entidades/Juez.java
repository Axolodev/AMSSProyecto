import java.sql.*;
import java.io.*;

public class Juez extends Persona {
	Connection conn;
	Statement stmt;

	public Juez() {
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

	protected String getFechaInicio(int idJuez) {
		String fechaInicio = ""; 
		try {
			stmt.executeQuery ("SELECT fechaInicio FROM juez WHERE idJuez = " + idJuez);
			ResultSet rs = stmt.getResultSet();
         rs.next(); //Va al registro ya validado
         fechaInicio = rs.getString("fechaInicio");
         rs.close();
         return(fechaInicio);
     } catch (SQLException e) {
     	System.out.println ("Cannot getFechaInicio()" + e);
     }
     return fechaInicio;
 }

 protected void setFechaInicio(String fechaInicio, int idJuez) {
 	try {
 		String s = "UPDATE juez SET fechaInicio = " + fechaInicio + " WHERE idJuez = " + idJuez;
 		stmt.executeUpdate(s);
 	} catch (SQLException e) {
 		System.out.println ("Cannot execute setFechaInicio()" + e);
 	}
 }

	public int getCalificacion(int idJuez) {
		int fechaInicio = 0; 
		try {
			stmt.executeQuery ("SELECT calificacion FROM juez WHERE idJuez = " + idJuez);
			ResultSet rs = stmt.getResultSet();
         rs.next(); //Va al registro ya validado
         calificacion = rs.getString("calificacion");
         rs.close();
         return(calificacion);
     } catch (SQLException e) {
     	System.out.println ("Cannot getCalificacion()" + e);
     }
     return calificacion;
 }

 public void setCalificacion(String calificacion, int idJuez) {
 	try {
 		String s = "UPDATE juez SET calificacion = " + calificacion + " WHERE idJuez = " + idJuez;
 		stmt.executeUpdate(s);
 	} catch (SQLException e) {
 		System.out.println ("Cannot execute setCalificacion()" + e);
 	}
 }

 public void revisarArticulo(int idArticulo, boolean aprovado) {
 	try {
 		String s = "UPDATE articulo SET estadoArticulo = " + aprovado + " WHERE idArticulo = " + idArticulo;
 		stmt.executeUpdate(s);
 	} catch (SQLException e) {
 		System.out.println ("Cannot execute revisarArticulo()" + e);
 	}
 }

 public void sugerirTemas(String tema){
		// Agregar temas a los sugeridos 
 }
}
