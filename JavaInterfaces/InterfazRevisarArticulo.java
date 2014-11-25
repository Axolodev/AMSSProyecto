package interfaces;
import controles.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
//import controles.ControlExtraccion;

public class InterfazRevisarArticulo extends HttpServlet {
  HttpServletResponse thisResponse;
  HttpServletRequest thisRequest;
  PrintWriter out;
  ControlCancelarSuscripcion ce;
  
  //Es importante observar que todos los metodos definen la operacion GET para
  //que el metodo doGet sea el que se ejecuta al presionar el boton "Enviar". 
  public void doGet(HttpServletRequest request,
        HttpServletResponse response)
        throws IOException {
    thisResponse = response;
    thisRequest = request;
    thisResponse.setContentType("text/html");
    out = thisResponse.getWriter();
    //Preparar el encabezado de la pagina Web de respuesta
    out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">");
    out.println("<HTML>");
    out.println("<HEAD>");
    out.println("<META http-equiv=Content-Type content=\"text/html\">");
    out.println("</HEAD>");
    out.println("<BODY>");
    out.println("<TITLE>/Revisar Articulo </TITLE>");
    out.println("<h2>Seng n Bits</h2>");
    out.println("<h3>Revisar Articulo</h3>");
    
    String operacion = request.getParameter("operacion");
    if(operacion == null){ // El menu nos envia un parametro para indicar el inicio de una transaccion
      iniciarRevision();  
    }else if(operacion.equals("revisar")){
       this.revisarArticulo();
    } 
  }
  
  public void iniciarRevision(){  
    //out.println("<p>Indique su numero de suscriptor</p>");
    out.println("<form method=\"GET\" action=\"Renovar\">");
    out.println("<input type=\"hidden\" name=\"operacion\" value=\"revisar\"/>");
    out.println("<p> ID Articulo  <input type=\"text\" name=\"idA\" size=\"15\"></p>");
    out.println("<p><input type=\"submit\" value=\"Enviar\" name=\"B1\"></p>");
    out.println("</form>");
 
    out.println("<form method=\"GET\" action=\"menu.html\">");
    out.println("<p><input type=\"submit\" value=\"Revisar\" name=\"B2\"></p>");
    out.println("</form>");

    out.println("</BODY>");
    out.println("</HTML>");    
  }
  
  

  public void revisarArticulo(){  
    int idArticulo = Integer.parseInt(thisRequest.getParameter("idA").trim());
    
     ce.revisarArticulo(idArticulo);   
      out.println("<p>Se ha revisado el articulo con éxito</p>");
      out.println("<p>Vuelve pronto</p>");
      out.println("<form method=\"GET\" action=\"index.html\">");
      out.println("<p><input type=\"submit\" value=\"Terminar\" name=\"B1\"></p>");
      out.println("</form>");
      out.println("</BODY>");
      out.println("</HTML>");
    
  } 
}
