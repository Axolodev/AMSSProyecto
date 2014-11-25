package interfaces;
import controles.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
//import controles.ControlExtraccion;

public class InterfazEvaluarJuez extends HttpServlet {
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
    out.println("<h3>Evaluar Jueces</h3>");
    
    String operacion = request.getParameter("operacion");
    if(operacion == null){ // El menu nos envia un parametro para indicar el inicio de una transaccion
      iniciarEvaluacion();  
    }else if(operacion.equals("evaluacion")){
       evaluarJuez();
    } 
  }
  
  public void iniciarEvaluacion(){  
    out.println("<p>Indique el numero ID del juez</p>");
    out.println("<form method=\"GET\" action=\"Evaluar\">");
    out.println("<input type=\"hidden\" name=\"operacion\" value=\"evaluacion\"/>");
    out.println("<p> IDJuez  <input type=\"text\" name=\"idJ\" size=\"15\"></p>");
    out.println("<p> Calificacion  <input type=\"text\" name=\"calificacion\" size=\"15\"></p>");
    out.println("<p><input type=\"submit\" value=\"Enviar\"name=\"B1\"></p>");
    out.println("</form>");
 
    out.println("<form method=\"GET\" action=\"menu.html\">");
    out.println("<p><input type=\"submit\" value=\"Cancelar\"name=\"B2\"></p>");
    out.println("</form>");

    out.println("</BODY>");
    out.println("</HTML>");    
  }
  
  

  public void evaluarJuez(){  
    int idJuez = Integer.parseInt(thisRequest.getParameter("idJ").trim());
    int cali = Integer.parseInt(thisRequest.getParameter("calificacion").trim());
    
     ce.evaluarJuez(idJ,cali);

   
      float saldo = ce.consultaSaldo(cuenta); 
      out.println("<p>Tu calificacion ha sido registrada</p>");
      out.println("<p>Gracias por haber evaluado al juez</p>");
      out.println("<p>Presione el boton para terminar.</p>");
      out.println("<form method=\"GET\" action=\"index.html\">");
      out.println("<p><input type=\"submit\" value=\"Terminar\"name=\"B1\"></p>");
      out.println("</form>");
      out.println("</BODY>");
      out.println("</HTML>");
    
  } 
}
