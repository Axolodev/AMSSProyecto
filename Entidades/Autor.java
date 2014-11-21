import java.sql.*;
import java.io.*;

public class Autor extends Persona {
	Connection conn;
	Statement stmt;

	public String getGeneroTema(int idAutor) {
String generoTema = "";
		try {
			stmt.executeQuery ("SELECT generoTema FROM Autor WHERE idAutor = " + idAutor);
			ResultSet rs = stmt.getResultSet();
         rs.next(); //Va al registro ya validado
         generoTema = rs.getString("generoTema");
         rs.close();
         return(generoTema);
     } catch (SQLException e) {System.out.println ("Cannot getGeneroTema()" + e);
 }
 return generoTema;
}

public void setGeneroTema(String generoTema, int idAutor) {
	try {
		String s = "UPDATE Autor SET generoTema = " + generoTema + " WHERE idAutor = " + idAutor;
		stmt.executeUpdate(s);
	} catch (SQLException e) {
		System.out.println ("Cannot execute setGeneroTema()" + e);
	}
}

public Autor() {
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

public void registrarArticulo(int idAutor){
		// generar nuevo articulo
}

}
