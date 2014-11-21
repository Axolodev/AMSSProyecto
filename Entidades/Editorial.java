import java.sql.*;
import java.io.*;
public class Editorial {
//	private int idEditorial;
//	private String nombre;
//	private String direccion;
//	private String encargado;

	Connection conn;
    Statement stmt;
    
    public Editorial(){
        try {
        String userName = "root";
        String password = "";
        String url = "jdbc:mysql://localhost/SengBytes";
        Class.forName ("com.mysql.jdbc.Driver").newInstance();
        conn = DriverManager.getConnection (url, userName, password);
        stmt = conn.createStatement();
      }catch (Exception e) { System.out.println ("Cannot connect to database server"); }
    }

	protected String getNombre(int idEditorial) {
		String nombre = ""; 
      try {
         stmt.executeQuery ("SELECT saldo FROM Editorial WHERE idEditorial = " + idEditorial);
         ResultSet rs = stmt.getResultSet();
         rs.next(); //Va al registro ya validado
         nombre = rs.getString("nombre");
         rs.close();
         return(nombre);
      } catch (SQLException e) {System.out.println ("Cannot getNombre()" + e);}
      return nombre;
	}

	protected void setNombre(int idEditorial, String nombre) {
		try {
         String s = "UPDATE cuenta SET nombre = " + nombre + " WHERE idEditorial = " + idEditorial;
         stmt.executeUpdate(s);
      } catch (SQLException e) {System.out.println ("Cannot execute disposicion()" + e);}
	}

	protected String getDireccion() {
		return direccion;
	}

	protected void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	protected String getEncargado() {
		return encargado;
	}

	protected void setEncargado(int encargado) {
		this.encargado = encargado;
	}	
}
