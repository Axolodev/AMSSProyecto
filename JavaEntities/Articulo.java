package entidades;
import java.sql.*;
import java.io.*;


public class Articulo {
	Connection conn;
	Statement stmt;

	public Articulo(){
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

	public String getNombre(int idArticulo) {
		String nombre = ""; 
		try {
			stmt.executeQuery ("SELECT nombre FROM articulo WHERE idArticulo = " + idArticulo);
			ResultSet rs = stmt.getResultSet();
         rs.next(); //Va al registro ya validado
         nombre = rs.getString("nombre");
         rs.close();
         return(nombre);
     } catch (SQLException e) {System.out.println ("Cannot getNombre()" + e);
 }
 return nombre;
}

public void setNombre(int idArticulo, String nombre) {
	try {
		String s = "UPDATE articulo SET nombre = " + nombre + " WHERE idArticulo = " + idArticulo;
		stmt.executeUpdate(s);
	} catch (SQLException e) {
		System.out.println ("Cannot execute setNombre()" + e);
	}
}

public String getFechaRevision(int idArticulo) {
	String fechaRevision = ""; 
	try {
		stmt.executeQuery ("SELECT fechaRevision FROM articulo WHERE idArticulo = " + idArticulo);
		ResultSet rs = stmt.getResultSet();
         rs.next(); //Va al registro ya validado
         fechaRevision = rs.getString("fechaRevision");
         rs.close();
         return(fechaRevision);
     } catch (SQLException e) {
     	System.out.println ("Cannot getFechaRevision()" + e);
     }
     return fechaRevision;
 }

 public void setFechaRevision(int idArticulo, String fechaRevision) {
 	try {
		String s = "UPDATE articulo SET fechaRevision = " + fechaRevision + " WHERE idArticulo = " + idArticulo;
		stmt.executeUpdate(s);
	} catch (SQLException e) {
		System.out.println ("Cannot execute setFechaRevision()" + e);
	}
 }

 public String getFechaPublicacion(int idArticulo) {
 	String fechaPublicacion = ""; 
 	try {
 		stmt.executeQuery ("SELECT fechaPublicacion FROM articulo WHERE idArticulo = " + idArticulo);
 		ResultSet rs = stmt.getResultSet();
         rs.next(); //Va al registro ya validado
         fechaPublicacion = rs.getString("fechaPublicacion");
         rs.close();
         return(fechaPublicacion);
     } catch (SQLException e) {
     	System.out.println ("Cannot getFechaPublicacion()" + e);
     }
     return fechaPublicacion;
 }

 public void setFechaPublicacion(int idArticulo, String fechaPublicacion) {
 	try {
		String s = "UPDATE articulo SET fechaPublicacion = " + fechaPublicacion + " WHERE idArticulo = " + idArticulo;
		stmt.executeUpdate(s);
	} catch (SQLException e) {
		System.out.println ("Cannot execute setFechaPublicacion()" + e);
	}
 }

 public boolean getEstadoArticulo(int idArticulo) {
 	boolean estadoArticulo = false;
 	try {
 		stmt.executeQuery ("SELECT estadoArticulo FROM articulo WHERE idArticulo = " + idArticulo);
 		ResultSet rs = stmt.getResultSet();
         rs.next(); //Va al registro ya validado
         estadoArticulo = rs.getBoolean("estadoArticulo");
         rs.close();
         return(estadoArticulo);
     } catch (SQLException e) {
     	System.out.println ("Cannot getNombre()" + e);
     }
     return estadoArticulo;
 }

 public void setEstadoArticulo(int idArticulo, boolean estadoArticulo) {
 	try {
		String s = "UPDATE articulo SET estadoArticulo = " + estadoArticulo + " WHERE idArticulo = " + idArticulo;
		stmt.executeUpdate(s);
	} catch (SQLException e) {
		System.out.println ("Cannot execute setEstadoArticulo()" + e);
	}
 }

public String[] listaArticulos(){
	File folder = new File("ArticulosListos");
	return folder.list();
} 

}
