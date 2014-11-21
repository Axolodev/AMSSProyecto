import java.sql.*;
import java.io.*;

public class Productor extends Persona {

	Connection conn;
	Statement stmt;
	public Productor () {
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
	/**
	 * 
	 * @param art
	 * @return
	 */
	public Articulo revisarArticulo(Articulo idArticulo, boolean aprovado) {
		try {
		String s = "UPDATE articulo SET estadoArticulo = " + aprovado + " WHERE idArticulo = " + idArticulo;
		stmt.executeUpdate(s);
	} catch (SQLException e) {
		System.out.println ("Cannot execute revisarArticulo()" + e);
	}
	}
}
