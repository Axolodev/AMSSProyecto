import java.sql.*;
import java.io.*;
public class Revista {
    Connection conn;
    Statement stmt;
    
//	private int idRevista;
//	private String nombre;
    
    public Revista(){
        try{
        String userName = "root";
        String password = "";
        String url = "jdbc:mysql://localhost/SengBytes";
        Class.forName ("com.mysql.jdbc.Driver").newInstance();
        conn = DriverManager.getConnection (url, userName, password);
        stmt = conn.createStatement();            
        }catch (Exception e) { System.out.println ("Cannot connect to database server"); }
    }
	
	public String getNombre(int idRevista) {
        String nombre = ""; 
        try {
            stmt.executeQuery ("SELECT nombre FROM revista WHERE idRevista = " + idRevista);
            ResultSet rs = stmt.getResultSet();
            rs.next(); //Va al registro ya validado
            nombre = rs.getString("nombre");
            rs.close();
            return(nombre);
        } catch (SQLException e) {System.out.println ("Cannot getNombre()" + e);}
        return nombre;
    }

	public void setNombre(int idArticulo, String nombre) {
		try {
         String s = "UPDATE Revista SET nombre = " + nombre + " WHERE idRevista = " + idRevista;
         stmt.executeUpdate(s);
      } catch (SQLException e) {System.out.println ("Cannot execute disposicion()" + e);}
	}
}
