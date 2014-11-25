package interfaces;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import controles.ControlLeerArticulo;

public class InterfazLeer extends HttpServlet {
  HttpServletResponse thisResponse;
  HttpServletRequest thisRequest;
  PrintWriter out;

    public ControlLeerArticulo ctrl;
  
   public void doGet(HttpServletRequest request,
        HttpServletResponse response)
        throws IOException {

    
    thisResponse = response;
    thisRequest = request;
    thisResponse.setContentType("text/html");
    out = thisResponse.getWriter();
    //Pagina Web de respuesta
    out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">");
    out.println("<HTML>");
    out.println("<HEAD>");
    out.println("<link rel='stylesheet' type='text/css' href='myStyle.css'/>");
    out.println("<META http-equiv=Content-Type content=\"text/html\">");
    out.println("</HEAD>");
    out.println("<BODY>");
    out.println("<div id='align'>"+
    "<div id='divSquare'>");
    out.println("<TITLE>Lectura de articulos</TITLE>");
    out.println("<h2>Seng n Bytes</h2>");
    out.println("<h3>Lectura de articulos</h3>");


    String operacion = request.getParameter("operacion");
    if(operacion == null){
        listarArticulos();   
    } else if (operacion.equals("Leer")){
        validarCuenta();
    }
  }


  public void listarArticulos(){
    out.print(
        "<p>Articulos listos para lectura</p>"+
        "<br/>"
        );
    
    out.print(
        "<form method='GET' action='Leer'>"+
        "<input type='hidden' name='operacion' value=\"Leer\"/>"+
        "<p>Indique el numero del articulo que quiere leer <input type='text' name='idArticulo' size='15'/></p>"+
        " <p><input type='submit' value='Enviar' name='B1'/> </p>"+
        "<br />"+
        "</form>"
        );
    out.print("</body>"+
        "</html>");
}


public void validarCuenta(){
    ctrl = new ControlLeerArticulo();
    
    out.println("<hr/>");

    int idArticulo = Integer.parseInt(thisRequest.getParameter("idArticulo").trim());

    String tituloArticulo = ctrl.tomaTitulo(idArticulo);

    String []textoArticulo = ctrl.recibeTexto(idArticulo);

    out.println("<br/><hr/> <h2>" + tituloArticulo + "</h2><br/><br/><p>");

    for(int i = 0; i < textoArticulo.length; i++)
    {
        out.println(textoArticulo[i] + "<br/>");
    }

    out.println("</p> </body> </html>");
  }


}
