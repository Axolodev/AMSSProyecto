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

	protected String getNombre(int idPedido) {
		String nombre = ""; 
      try {
         stmt.executeQuery ("SELECT saldo FROM pedido WHERE idPedido = " + idPedido);
         ResultSet rs = stmt.getResultSet();
         rs.next(); //Va al registro ya validado
         nombre = rs.getString("nombre");
         rs.close();
         return(nombre);
      } catch (SQLException e) {System.out.println ("Cannot getNombre()" + e);}
      return nombre;
	}

	protected void setNombre(int idPedido, String nombre) {
		try {
         String s = "UPDATE cuenta SET nombre = " + nombre + " WHERE idPedido = " + idPedido;
         stmt.executeUpdate(s);
      } catch (SQLException e) {System.out.println ("Cannot execute disposicion()" + e);}
	}

    protected String getFechaPedido() {
		return fechaPedido;
	}

	protected void setFechaPedido(String fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

}
