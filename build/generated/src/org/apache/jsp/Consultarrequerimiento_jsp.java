package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import ena.java.proyecto.objetos.Requerimiento;
import java.util.List;

public final class Consultarrequerimiento_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("  \n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Ena.java</title>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"CSS/Estilos.css\"/>\n");
      out.write("    </head>\n");
      out.write("    <body class=\"fondo\">\n");
      out.write("        <h2 class=\"p\">Consultar Requerimientos</h2>\n");
      out.write("        <form action=\"mostrar\" method=\"post\">\n");
      out.write("        <table cellspacing=\"3\" cellpadding=\"3\" border=\"0\">\n");
      out.write("            <tr>\n");
      out.write("                <td class=\"p\">Gerencia:</td>\n");
      out.write("                <td>\n");
      out.write("                <select class=\"select-css\" name=\"geren\">\n");
      out.write("                    <option selected>Abastecimiento</option>\n");
      out.write("                    <option>TI</option>\n");
      out.write("                </select> <br>  \n");
      out.write("                </td>\n");
      out.write("                <td></td>\n");
      out.write("            </tr>\n");
      out.write("            \n");
      out.write("            <tr>\n");
      out.write("                <td class=\"p\">Depto:</td>\n");
      out.write("                <td>\n");
      out.write("                <select class=\"select-css\" name=\"depto\">\n");
      out.write("                    <option selected>Abastecimiento</option>\n");
      out.write("                    <option>TI</option> \n");
      out.write("                </select> <br>  \n");
      out.write("                </td>\n");
      out.write("                <td></td>\n");
      out.write("            </tr>\n");
      out.write("            \n");
      out.write("            <tr>\n");
      out.write("                <td class=\"p\">Asignado a:</td>\n");
      out.write("                <td>\n");
      out.write("                <select class=\"select-css\" name=\"Asig\">\n");
      out.write("                    <option selected>Tecnico</option>\n");
      out.write("                    <option>Ingeniero</option>\n");
      out.write("                    \n");
      out.write("                </select> <br>  \n");
      out.write("                </td>\n");
      out.write("                <td><input class=\"btn\"  type=\"submit\" value=\"Buscar\"></td>\n");
      out.write("            </tr>\n");
      out.write("        </table>\n");
      out.write("            \n");
      out.write("            \n");
      out.write("        <table border=\"1\">\n");
      out.write("            <tr> \n");
      out.write("            <th class=\"p\">Gerencia</th>\n");
      out.write("            <th class=\"p\">Depto.</th>\n");
      out.write("            <th class=\"p\">Asignado a</th>\n");
      out.write("            <th class=\"p\">Requerimiento</th>\n");
      out.write("            </tr>\n");
      out.write("             \n");
      out.write("             ");

                List<Requerimiento> listaRequerimiento = (List<Requerimiento>) request.getAttribute("resultados");
                
                if (listaRequerimiento!=null){
                for (Requerimiento requerimiento : listaRequerimiento) {
             
      out.write("\n");
      out.write("                <tr class=\"datos\">\n");
      out.write("                <td class=\"p\">");
      out.print(requerimiento.getGerencia());
      out.write("</td>\n");
      out.write("                <td class=\"p\">");
      out.print(requerimiento.getDepto());
      out.write("</td>\n");
      out.write("                <td class=\"p\">");
      out.print(requerimiento.getAsignar());
      out.write("</td>\n");
      out.write("                <td class=\"p\">");
      out.print(requerimiento.getRequerimiento());
      out.write("</td>\n");
      out.write("                </tr>\n");
      out.write("                ");
}     
                }                 
            
      out.write("\n");
      out.write("            \n");
      out.write("            </table>\n");
      out.write("            </form>\n");
      out.write("            <br>\n");
      out.write("             <form action=\"Menuprincipal.jsp\" method=\"post\">\n");
      out.write("                <input class=\"btn\"  type=\"submit\" value=\"Volver al menú\"></form>\n");
      out.write("        \n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
