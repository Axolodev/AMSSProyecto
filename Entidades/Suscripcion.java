import java.sql.*;
import java.io.*;
public class Suscripcion {
  	Connection conn;
    Statement stmt;
    
    public Suscripcion(){
        try {
        String userName = "root";
        String password = "";
        String url = "jdbc:mysql://localhost/SengBytes";
        Class.forName ("com.mysql.jdbc.Driver").newInstance();
        conn = DriverManager.getConnection (url, userName, password);
        stmt = conn.createStatement();
      }catch (Exception e) { System.out.println ("Cannot connect to database server"); }
    }

    protected String getNombre(int idSuscripcion) {
		String nombre = ""; 
      try {
         stmt.executeQuery ("SELECT saldo FROM Suscripcion WHERE idSuscripcion = " + idSuscripcion);
         ResultSet rs = stmt.getResultSet();
         rs.next(); //Va al registro ya validado
         nombre = rs.getString("nombre");
         rs.close();
         return(nombre);
      } catch (SQLException e) {System.out.println ("Cannot getNombre()" + e);}
      return nombre;
	}
    
	protected void setNombre(int idSuscripcion, String nombre) {
		try {
         String s = "UPDATE cuenta SET nombre = " + nombre + " WHERE idSuscripcion = " + idSuscripcion;
         stmt.executeUpdate(s);
      } catch (SQLException e) {System.out.println ("Cannot execute disposicion()" + e);}
	}
    
    
//	private int idSuscripcion;
//	private String fechaSuscripcion;
//	private String direccion;
//	private String encargado;
	
	protected String getFechaSuscripcion() {
		return fechaSuscripcion;
	}

	protected void setFechaSuscripcion(String fechaSuscripcion) {
		this.fechaSuscripcion = fechaSuscripcion;
	}

}
