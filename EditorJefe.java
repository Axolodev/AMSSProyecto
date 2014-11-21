import java.sql.*;
import java.io.*;

public class EditorJefe extends Persona {
	Connection conn;
	Statement stmt;

	public EditorJefe() {
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


	public String evaluarJuez(Juez idJuez, String evaluacion) {
		return "El " + juez.toString() + " ha sido evaluado " + evaluacion;
	}

	public void revisarArticulo(Articulo idArticulo, boolean aprovado) {
	try {
		String s = "UPDATE articulo SET estadoArticulo = " + aprovado + " WHERE idArticulo = " + idArticulo;
		stmt.executeUpdate(s);
	} catch (SQLException e) {
		System.out.println ("Cannot execute revisarArticulo()" + e);
	}
	}

	public void seleccionarJuez(Autor idAutor){
		//Generar nuevo juez con el autor ingresado
	}
}
