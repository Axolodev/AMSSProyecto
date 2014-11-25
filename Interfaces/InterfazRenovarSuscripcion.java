package interfaces;
import controles.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
//import controles.ControlExtraccion;

public class InterfazCrearSuscripcion extends HttpServlet {
  HttpServletResponse thisResponse;
  HttpServletRequest thisRequest;
  PrintWriter out;
  ControlEvluarJuez ce;
  
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
    out.println("<TITLE>Editorial </TITLE>");
    out.println("<h2>Jueces</h2>");
    out.println("<h3>Renovar Suscripcion</h3>");
    
    String operacion = request.getParameter("operacion");
    if(operacion == null){ // El menu nos envia un parametro para indicar el inicio de una transaccion
      iniciarSuscripcion();  
    }else if(operacion.equals("renovar")){
       renovarSuscripcion();
    } 
  }
  
  public void iniciarSuscripcion(){  
    out.println("<p>Indique su numero de suscriptor</p>");
    out.println("<form method=\"GET\" action=\"Renovar\">");
    out.println("<input type=\"hidden\" name=\"operacion\" value=\"renovacion\"/>");
    out.println("<p> ID Suscriptor  <input type=\"text\" name=\"idS\" size=\"15\"></p>");
    out.println("<p> Meses a renovar <input type=\"text\" name=\"mes\" size=\"15\"></p>");
    out.println("<p><input type=\"submit\" value=\"Enviar\"name=\"B1\"></p>");
    out.println("</form>");
 
    out.println("<form method=\"GET\" action=\"menu.html\">");
    out.println("<p><input type=\"submit\" value=\"Cancelar\"name=\"B2\"></p>");
    out.println("</form>");

    out.println("</BODY>");
    out.println("</HTML>");    
  }
  
  

  public void crearSuscripcion(){  
    int idSuscriptor = Integer.parseInt(thisRequest.getParameter("idS").trim());

  int m = Integer.parseInt(thisRequest.getParameter("mes").trim());

    ce.renovarSuscripcion(m,idSuscriptor);
      out.println("<p>Tu renovacion ha sido realizada con éxito</p>");
      out.println("<p>Gracias por registrarte nuevamente</p>");
      out.println("<p>Te esperamos pronto, sigue leyendo!.</p>");
      out.println("<form method=\"GET\" action=\"index.html\">");
      out.println("<p><input type=\"submit\" value=\"Terminar\"name=\"B1\"></p>");
      out.println("</form>");
      out.println("</BODY>");
      out.println("</HTML>");
    
  } 
}
