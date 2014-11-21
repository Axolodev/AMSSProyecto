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

	public String getNombre(int idEditorial) {
		String nombre = ""; 
      try {
         stmt.executeQuery ("SELECT nombre FROM Editorial WHERE idEditorial = " + idEditorial);
         ResultSet rs = stmt.getResultSet();
         rs.next(); //Va al registro ya validado
         nombre = rs.getString("nombre");
         rs.close();
         return(nombre);
      } catch (SQLException e) {System.out.println ("Cannot getNombre()" + e);}
      return nombre;
	}

	public void setNombre(int idEditorial, String nombre) {
		try {
         String s = "UPDATE Editorial SET nombre = " + nombre + " WHERE idEditorial = " + idEditorial;
         stmt.executeUpdate(s);
      } catch (SQLException e) {System.out.println ("Cannot execute disposicion()" + e);}
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEncargado() {
		return encargado;
	}

	public void setEncargado(int encargado) {
		this.encargado = encargado;
	}	
}
