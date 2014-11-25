package entidades;
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


	public void revisarArticulo(int idArticulo, boolean aprovado) {
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
