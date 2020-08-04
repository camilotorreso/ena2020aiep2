package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.concurrent.ExecutionException;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");

    String formato=(String) request.getAttribute("vacio"); 

      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Ena 2020</title>\n");
      out.write("        <link href=\"css/Estilo.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <!Página de ingreso: deberá llenar los cmapos usuario y contraseña>\n");
      out.write("        <div id=\"cuadro\">\n");
      out.write("        \n");
      out.write("        <form action=\"controlador\" method=\"post\">\n");
      out.write("            <h1 class=\"p\" align=\"center\">Autentificacion</h1><br>\n");
      out.write("            <center>\n");
      out.write("         <table>\n");
      out.write("                <tr><td class=\"p\">Usuario  :</td><td><input type='text' name=\"usuario\"  size='12'></td></tr>\n");
      out.write("                \n");
      out.write("                <tr><td><br></td><td></td></tr>\n");
      out.write("                \n");
      out.write("                <tr><td class=\"p\">Password :</td><td><input type='password' name='clave'  size='12'></td></tr>\n");
      out.write("                \n");
      out.write("                <tr><td><br></td><td></td></tr>\n");
      out.write("            \n");
      out.write("                <tr><td><input class=\"p\" align=\"center\" type=\"checkbox\" name=\"recordar\" value=\"ON\" /><label>recordar</label></td><td></td></tr>\n");
      out.write("                \n");
      out.write("                <tr><td><br></td><td></td></tr>\n");
      out.write("                \n");
      out.write("                <tr><td><input class=\"btn\" align=\"center\" type=\"submit\" value=\"Ingresar\" name=\"ingresar\"/></td><td></td></tr>\n");
      out.write("                \n");
      out.write("                </table>\n");
      out.write("            <!indentificador de pagina>\n");
      out.write("            <input type='hidden' name='acto' value=\"1\" >\n");
      out.write("            <br><br>\n");
      out.write("        </form>\n");
      out.write("            \n");
      out.write("        <!En el caso de no cohincidir o faltar algun dato, se mostrara en pantalla la advertencia>\n");
      out.write("            \n");
      out.write("        ");
if(formato!=null){
      out.write("\n");
      out.write("            <h2>");
      out.print(formato);
      out.write("</h2>\n");
      out.write("        ");
}
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
