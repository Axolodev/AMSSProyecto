package interfaces;
import controles.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
//import controles.ControlExtraccion;

public class InterfazSeleccionarJuez extends HttpServlet {
  HttpServletResponse thisResponse;
  HttpServletRequest thisRequest;
  PrintWriter out;
  ControlSeleccionarJuez ce;
  
  //Es importante observar que todos los metodos definen la operacion GET para
  //que el metodo doGet sea el que se ejecuta al presionar el boton "Enviar". 
  public void doGet(HttpServletRequest request,
        HttpServletResponse response)
        throws IOException {

          ce = new ControlSeleccionarJuez();
    thisResponse = response;
    thisRequest = request;
    thisResponse.setContentType("text/html");
    out = thisResponse.getWriter();
    //Preparar el encabezado de la pagina Web de respuesta
    out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">");
    out.println("<HTML>");
    out.println("<HEAD>");
    out.println("<link rel='stylesheet' type='text/css' href='myStyle.css'/>");
    out.println("<META http-equiv=Content-Type content=\"text/html\">");
    out.println("</HEAD>");
    out.println("<BODY>");
    out.println("<TITLE>Editorial </TITLE>");
    out.println("<h2>Jueces</h2>");
    out.println("<h3>Seleccionar Jueces</h3>");
    
    String operacion = request.getParameter("operacion");
    if(operacion == null){ // El menu nos envia un parametro para indicar el inicio de una transaccion
      iniciarSeleccion();  
    }else if(operacion.equals("seleccionar")){
       seleccionarJuez();
    } 
  }
  
  public void iniciarSeleccion(){  
    out.println("<p>Indique el numero ID del autor</p>");
    out.println("<form method=\"GET\" action=\"Seleccionar\">");
    out.println("<input type=\"hidden\" name=\"operacion\" value=\"seleccionar\"/>");
    out.println("<p> ID Autor:  <input type=\"text\" name=\"idA\" size=\"15\"></p>");
    out.println("<p><input type=\"submit\" value=\"Enviar\"name=\"B1\"></p>");
    out.println("</form>");
 
    out.println("<form method=\"GET\" action=\"menu.html\">");
    out.println("<p><input type=\"submit\" value=\"Cancelar\"name=\"B2\"></p>");
    out.println("</form>");

    out.println("</BODY>");
    out.println("</HTML>");    
  }
  
  

  public void seleccionarJuez(){  
    int idAutor = Integer.parseInt(thisRequest.getParameter("idA").trim());
    
     ce.seleccionarJuez(idAutor, "N/A");      
      out.println("<p>Se ha agregado un nuevo juez correctamente.</p>");
      out.println("<p>Presione el boton para terminar.</p>");
      out.println("<form method=\"GET\" action=\"index.html\">");
      out.println("<p><input type=\"submit\" value=\"Terminar\"name=\"B1\"></p>");
      out.println("</form>");
      out.println("</BODY>");
      out.println("</HTML>");
    
  } 
}