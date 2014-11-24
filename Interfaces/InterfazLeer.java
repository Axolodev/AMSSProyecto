package interfaces;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import controles.ControlTransferencia;

public class InterfazTransferencia extends HttpServlet {
  HttpServletResponse thisResponse;
  HttpServletRequest thisRequest;
  PrintWriter out;

  ControlLeerArticulo ctrl;

  
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
    out.println("<h2>Seng n Bits</h2>");
    out.println("<h3>Lectura de artículos</h3>");


    String operacion = request.getParameter("operacion");
    if(operacion == null){
        listarArticulos()();        
    } 
  }


  public void listarArticulos(){

    String[] list = ctrl.listarArticulos();
    out.print(
            "<p>Lista de articulos listos para lectura</p>"+
            "<br/>"
        );

    for(int i = 0 ; i < list.length; i++)
    {
        out.println(
            "<a href='ArticulosListos\\" + list[i] + ">" + list[i] + "</a>"
            );
    }

    out.print("</div></div>"+
            "</body>"+
            "</html>");
  }


}
