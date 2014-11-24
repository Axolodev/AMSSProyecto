import java.sql.*;
import java.io.*;
public class Pedido {
//	private int idPedido;
//	private String fechaPedido;

	Connection conn;
    Statement stmt;
    
    public Pedido(){
        try {
        String userName = "root";
        String password = "";
        String url = "jdbc:mysql://localhost/SengBytes";
        Class.forName ("com.mysql.jdbc.Driver").newInstance();
        conn = DriverManager.getConnection (url, userName, password);
        stmt = conn.createStatement();
      }catch (Exception e) { System.out.println ("Cannot connect to database server"); }
    }

	public String getNombre(int idPedido) {
		String nombre = ""; 
      try {
         stmt.executeQuery ("SELECT nombre FROM pedido WHERE idPedido = " + idPedido);
         ResultSet rs = stmt.getResultSet();
         rs.next(); //Va al registro ya validado
         nombre = rs.getString("nombre");
         rs.close();
         return(nombre);
      } catch (SQLException e) {System.out.println ("Cannot getNombre()" + e);}
      return nombre;
	}

	public void setNombre(int idPedido, String nombre) {
		try {
         String s = "UPDATE Pedido SET nombre = " + nombre + " WHERE idPedido = " + idPedido;
         stmt.executeUpdate(s);
      } catch (SQLException e) {System.out.println ("Cannot execute disposicion()" + e);}
	}

    public String getFechaPedido() {
		return fechaPedido;
	}

	public void setFechaPedido(String fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

}
