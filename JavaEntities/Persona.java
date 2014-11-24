import java.sql.*;
import java.io.*;

abstract class Persona {
	Connection conn;
	Statement stmt;

	public Persona() {
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

	public String getNombre(int idPersona) {
		String nombre = ""; 
		try {
			stmt.executeQuery ("SELECT nombre FROM persona WHERE idPersona = " + idPersona);
			ResultSet rs = stmt.getResultSet();
         rs.next(); //Va al registro ya validado
         nombre = rs.getString("nombre");
         rs.close();
         return(nombre);
     } catch (SQLException e) {System.out.println ("Cannot getNombre()" + e);
 }
 return nombre;
}

public String getGenero(int idPersona) {
	String genero = ""; 
	try {
		stmt.executeQuery ("SELECT genero FROM persona WHERE idPersona = " + idPersona);
		ResultSet rs = stmt.getResultSet();
         rs.next(); //Va al registro ya validado
         genero = rs.getString("genero");
         rs.close();
         return(genero);
     } catch (SQLException e) {System.out.println ("Cannot getGenero()" + e);
 }
 return genero;
}

public void setGenero(String genero, int idPersona) {
try {
		String s = "UPDATE persona SET genero = " + genero + " WHERE idPersona = " + idPersona;
		stmt.executeUpdate(s);
	} catch (SQLException e) {
		System.out.println ("Cannot execute setGenero()" + e);
	}
}

public void setNombre(String nombre, int idPersona) {
	try {
		String s = "UPDATE persona SET nombre = " + nombre + " WHERE idPersona = " + idPersona;
		stmt.executeUpdate(s);
	} catch (SQLException e) {
		System.out.println ("Cannot execute setNombre()" + e);
	}
}

public String getDireccion(int idPersona) {
	String direccion = ""; 
	try {
		stmt.executeQuery ("SELECT direccion FROM persona WHERE idPersona = " + idPersona);
		ResultSet rs = stmt.getResultSet();
         rs.next(); //Va al registro ya validado
         direccion = rs.getString("direccion");
         rs.close();
         return(direccion);
     } catch (SQLException e) {System.out.println ("Cannot getDireccion()" + e);
 }
 return direccion;
}

public void setDireccion(String direccion, int idPersona) {
	try {
		String s = "UPDATE persona SET direccion = " + direccion + " WHERE idPersona = " + idPersona;
		stmt.executeUpdate(s);
	} catch (SQLException e) {
		System.out.println ("Cannot execute setDireccion()" + e);
	}
}

public String getNacimiento(int idPersona) {
	String Nacimiento = ""; 
	try {
		stmt.executeQuery ("SELECT Nacimiento FROM persona WHERE idPersona = " + idPersona);
		ResultSet rs = stmt.getResultSet();
         rs.next(); //Va al registro ya validado
         Nacimiento = rs.getString("Nacimiento");
         rs.close();
         return(Nacimiento);
     } catch (SQLException e) {System.out.println ("Cannot getNacimiento()" + e);
 }
 return Nacimiento;
}

public void setNacimiento(String nacimiento, int idPersona) {
	try {
		String s = "UPDATE persona SET nacimiento = " + nacimiento + " WHERE idPersona = " + idPersona;
		stmt.executeUpdate(s);
	} catch (SQLException e) {
		System.out.println ("Cannot execute setNacimiento()" + e);
	}
}

public int getEdad(int idPersona) {
	int edad = 0; 
	try {
		stmt.executeQuery ("SELECT edad FROM persona WHERE idPersona = " + idPersona);
		ResultSet rs = stmt.getResultSet();
         rs.next(); //Va al registro ya validado
         edad = rs.getInt("edad");
         rs.close();
         return(edad);
     } catch (SQLException e) {System.out.println ("Cannot getEdad()" + e);
 }
 return edad;
}

public void setEdad(int edad, int idPersona) {
	try {
		String s = "UPDATE persona SET edad = " + edad + " WHERE idPersona = " + idPersona;
		stmt.executeUpdate(s);
	} catch (SQLException e) {
		System.out.println ("Cannot execute setEdad()" + e);
	}
}

public String getNacionalidad(int idPersona) {
	String nacionalidad = ""; 
	try {
		stmt.executeQuery ("SELECT nacionalidad FROM persona WHERE idPersona = " + idPersona);
		ResultSet rs = stmt.getResultSet();
         rs.next(); //Va al registro ya validado
         nacionalidad = rs.getString("nacionalidad");
         rs.close();
         return(nacionalidad);
     } catch (SQLException e) {System.out.println ("Cannot getNacionalidad()" + e);
 }
 return nacionalidad;
}

public void setNacionalidad(String nacionalidad, int idPersona) {
	try {
		String s = "UPDATE persona SET nacionalidad = " + nacionalidad + " WHERE idPersona = " + idPersona;
		stmt.executeUpdate(s);
	} catch (SQLException e) {
		System.out.println ("Cannot execute setNacionalidad()" + e);
	}
}

}
