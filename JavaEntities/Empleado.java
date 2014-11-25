package entidades;
import java.sql.*;
import java.io.*;

public class Empleado extends Persona {
	Connection conn;
	Statement stmt;

	public Empleado() {
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

	public String getCargo(int idEmpleado) {
		String cargo = ""; 
		try {
			stmt.executeQuery ("SELECT cargo FROM empleado WHERE idEmpleado = " + idEmpleado);
			ResultSet rs = stmt.getResultSet();
         rs.next(); //Va al registro ya validado
         cargo = rs.getString("cargo");
         rs.close();
         return(cargo);
     } catch (SQLException e) {System.out.println ("Cannot getCargo()" + e);
 }
 return cargo;
}

public void setCargo(String cargo, int idEmpleado) {
	try {
		String s = "UPDATE empleado SET cargo = " + cargo + " WHERE idEmpleado = " + idEmpleado;
		stmt.executeUpdate(s);
	} catch (SQLException e) {
		System.out.println ("Cannot execute setCargo()" + e);
	}
}

}
