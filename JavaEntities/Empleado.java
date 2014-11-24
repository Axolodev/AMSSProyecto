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

public void generarNuevoSitio(int idArticulo) {
	Articulo articulo = new Articulo();
	try {
		PrintWriter out = new PrintWriter(new FileWriter("Articulos\\art"
			+ idArticulo + ".html"));
		out.println("<html><head><title>" + articulo.getNombre(idArticulo)
			+ "</title> </head><body>");
		out.println("<p>");
		if(articulo.getEstadoArticulo(idArticulo)){
			


			BufferedReader br;
			br = new BufferedReader(new FileReader("ArticulosListos\\Art"
				+ idArticulo + ".html"));
			String line = null;
			
			while ((line = br.readLine()) != null) {
				out.println(line);
			}
			

			br.close();
			
			

		} else {
			out.println("Articulo en construccion");
		}
		out.println("<\\p>");
		out.println("</body> </html>");
		out.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
}

}
