package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class Cerrarrequerimientos_jsp extends org.apache.jasper.runtime.HttpJspBase
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

String query1=(String) request.getAttribute("query1");
String vacio=(String) request.getAttribute("vacio");

      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title class=\"p\">CERRAR REQUERIMIENTOS</title>\n");
      out.write("        <link href=\"css/estiloCerrarRq.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\n");
      out.write("        <script>\n");
      out.write("            //$(document).ready(function() permite cargar la página antes de comenzar las funciones.\n");
      out.write("\t    $(document).ready(function(){\n");
      out.write("                \n");
      out.write("            //jquery change funtionc se ejecutara cuando exista un cambio en la lista de gerente.\n");
      out.write("            $('#listag').change(function(){\n");
      out.write("                \n");
      out.write("            //jquery dentro de change que permite eliminar opciones de departamentos, mientras se realicen cambios en la lista gerentes\n");
      out.write("            $(\"#listad\").empty();\n");
      out.write("            \n");
      out.write("            recargarlista();\n");
      out.write("            });\n");
      out.write("            });\n");
      out.write("            \n");
      out.write("            //Está variable permite que se guarden los gerentes existentes\n");
      out.write("            var gerentes=[];\n");
      out.write("            \n");
      out.write("            //se solicita conexion a la base de datos\n");
      out.write("            ");
try{ 
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/requerimientos?zeroDateTimeBehavior=convertToNull","root","");
            
            //Esta consulta a la Base de datos permite mostrar todos los gerentes registrados 
            String query="select distinct gerente from gerencia";
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(query);
            
            
            int i=0;
            
            // Este While permitira que se guarden los registros asociados al campo gerente, 
            // él cual se guarda en la variable mencionada.
            
            while(rs.next()){
      out.write("\n");
      out.write("            gerentes[gerentes.length]=\"");
      out.print(rs.getString("gerente"));
      out.write("\";\n");
      out.write("            var departamento");
      out.print(i);
      out.write("=[];\n");
      out.write("            \n");
      out.write("            ");
i=i+1;}
            
            
            //Ejecutamos la consulta que muestra datos del gerente y su departamento 
            //y asi conocer si cumple las condiciones para asignar los valores.

            query="select depgerente, gerente from gerencia";
            rs=st.executeQuery(query);
            
            //En el siguiente while se realiza la funcion para asignar valor a la variable departamento
            // A través del for que permitira guardar los valores del campo departamento e ingresarlos a la variable
            // De esa manera los datos ingresados serán guardados en la BD.
            while(rs.next()){

            for(int e=0;e<i;e++){
      out.write("\n");
      out.write("                if(gerentes[");
      out.print(e);
      out.write("]===\"");
      out.print(rs.getString("gerente"));
      out.write("\"){\n");
      out.write("                departamento");
      out.print(e);
      out.write("[departamento");
      out.print(e);
      out.write(".length]=\"");
      out.print(rs.getString("depgerente"));
      out.write("\";\n");
      out.write("            \n");
      out.write("            }\n");
      out.write("            ");
}}
      out.write("\n");
      out.write("            //Esta funcion permite cargar la lista con los valores asignados mediante un bucle que identificara los diferentes \n");
      out.write("            // gerentes que se han ingresados, de esa forma se podra ubicar al gerente que seleccionemos y hara la diferencia \n");
      out.write("            // entre departamento y gerentes para asi encontrar al solicitado.\n");
      out.write("            \n");
      out.write("            function recargarlista(){\n");
      out.write("                $(\"#listad\").append(\"<option value=\\\"1\\\" label=\\\"Todos\\\"></option>\");            \n");
      out.write("            ");
for(int e=0;e<i;e++){
      out.write("\n");
      out.write("            \n");
      out.write("            if(gerentes[");
      out.print(e);
      out.write("]===$(\"#listag\").val()){                          \n");
      out.write("        \n");
      out.write("            for(i=0;i<departamento");
      out.print(e);
      out.write(".length;i++){\n");
      out.write("            $(\"#listad\").append(\"<option value='\"+departamento");
      out.print(e);
      out.write("[i]+\"'>\"+departamento");
      out.print(e);
      out.write("[i]+\"</option>\");\n");
      out.write("            };};\n");
      out.write("            ");
}
      out.write("\n");
      out.write("            }\n");
      out.write("            ");
}catch(Exception e){}
      out.write("\n");
      out.write("            \n");
      out.write("            </script>\n");
      out.write("\n");
      out.write("   </head>\n");
      out.write("   <body class=\"fondo\">\n");
      out.write("       <!Menú que permite cerrar requerimientos especificos>\n");
      out.write("       <div id=\"cuadro\">\n");
      out.write("           <h1 class=\"p\">CERRAR REQUERIMIENTOS</h1>\n");
      out.write("           <br>\n");
      out.write("        <form action=\"controlador\">\n");
      out.write("             <table>\n");
      out.write("                <!Select que carga a traves de la BD los gerentes ingresados>\n");
      out.write("               <tr>\n");
      out.write("                    <td class=\"p\">Gerencia</td><td><select class=\"btn\" id=\"listag\" name=\"gerencia\" style=\"width:200px\" >\n");
      out.write("                    <option value=\"1\" label=\"Escoge una opcion\"></option>\n");
      out.write("                    ");

                    try{
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/requerimientos?zeroDateTimeBehavior=convertToNull","root","");
                    String query="select distinct gerente from gerencia ";
                    Statement st=conn.createStatement();
                    ResultSet rs=st.executeQuery(query);
                    while(rs.next()){
      out.write("\n");
      out.write("                    \n");
      out.write("                    <option value=\"");
      out.print(rs.getString("gerente"));
      out.write("\" label=\"");
      out.print(rs.getString("gerente"));
      out.write("\"></option>\n");
      out.write("                    ");
}
                    }catch(Exception e){}
      out.write("\n");
      out.write("                    </select></td>\n");
      out.write("                    </tr>\n");
      out.write("                \n");
      out.write("                    <tr>\n");
      out.write("                    <td><br></td><td></td>\n");
      out.write("                    </tr>\n");
      out.write("                    \n");
      out.write("                    <!Select conectado con el anterior, ya que deben estar conectados entre si para mostrar la información indicada>\n");
      out.write("                    <tr>\n");
      out.write("                    <td class=\"p\">Departamento</td><td><select class=\"btn\" id=\"listad\" name=\"departamentog\" style=\"width:200px\" >\n");
      out.write("                    <option value=\"1\" label=\"Escoge una opcion\"></option>\n");
      out.write("                    </select></td>\n");
      out.write("                    </tr>\n");
      out.write("                \n");
      out.write("                    <tr>\n");
      out.write("                    <td><br></td><td></td>\n");
      out.write("                    </tr>\n");
      out.write("                    \n");
      out.write("                    <!Select que mostrara el area asignada dependiendo de su departamento>\n");
      out.write("                    <tr>\n");
      out.write("                    <td class=\"p\">Asignado a</td><td><select class=\"btn\" style=\"width:200px\" name=\"departamentosm\">\n");
      out.write("                    <option value=\"1\" label=\"Escoge una opcion\"></option>\n");
      out.write("                    ");

                    try{
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/requerimientos?zeroDateTimeBehavior=convertToNull","root","");
                    String query="select departamento from depa ";
                    Statement st=conn.createStatement();
                    ResultSet rs=st.executeQuery(query);
                    while(rs.next()){
      out.write("\n");
      out.write("                    \n");
      out.write("                    <option value=\"");
      out.print(rs.getString("departamento"));
      out.write("\" label=\"");
      out.print(rs.getString("departamento"));
      out.write("\"></option>\n");
      out.write("                            \n");
      out.write("                    ");
}
                    }catch(Exception e){}
                    
      out.write("\n");
      out.write("                    </select></td>\n");
      out.write("                    </tr> \n");
      out.write("                    \n");
      out.write("                    <tr>\n");
      out.write("                    <td><br></td><td></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <!Boton que permite buscar los datos solicitados por el usuario>\n");
      out.write("                    <tr><td><input class=\"btn\" type='submit' value=\"Buscar\" name=\"Buscar\"></td><td></td></tr>\n");
      out.write("                    <tr><td><input type='hidden' name=\"acto\" value=\"4\"></td><td></td>\n");
      out.write("                    </tr>\n");
      out.write("            </table>\n");
      out.write("            <!mensaje para verificar que los campos esten completos>\n");
      out.write("            ");
if(vacio!=null){
      out.write("\n");
      out.write("            <h2>");
      out.print(vacio);
      out.write("</h2>\n");
      out.write("            ");
}
      out.write("\n");
      out.write("            </form>\n");
      out.write("            <!Tabla que muestra los requerimientos buscados>\n");
      out.write("            <table border=\"5\" class=\"ancho\">\n");
      out.write("                <tr>\n");
      out.write("                    <th>Gerencia</th>\n");
      out.write("                    <th>Departamento</th>\n");
      out.write("                    <th>Asignado a</th>\n");
      out.write("                    <th>Encargado</th>\n");
      out.write("                    <th>Requerimiento</th>\n");
      out.write("                    <th>Estado</th>\n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("               <!Este Try permitira la conexión con la BD para mostrar los resultados de la busqueda>\n");
      out.write("            ");
  
            try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/requerimientos?zeroDateTimeBehavior=convertToNull","root","");
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(query1);
            while(rs.next()){
      out.write("\n");
      out.write("                \n");
      out.write("            <!A través de este formulario se mostrara los datos solicitados de acuerdo a cada campo>\n");
      out.write("            <form action=\"controlador\" method=\"get\">\n");
      out.write("            <table border=\"5\" class=\"ancho2\">    \n");
      out.write("            <tr>\n");
      out.write("                <td>");
      out.print(rs.getString("gerencia"));
      out.write("</td>\n");
      out.write("                <td>");
      out.print(rs.getString("departamento"));
      out.write("</td>\n");
      out.write("                <td>");
      out.print(rs.getString("departamentom"));
      out.write("</td>\n");
      out.write("                <td>");
      out.print(rs.getString("encargado"));
      out.write("</td>\n");
      out.write("                <td>");
      out.print(rs.getString("requerimiento"));
      out.write("</td>\n");
      out.write("                <td>");
      out.print(rs.getString("estado"));
      out.write("</td>\n");
      out.write("                <!Este if permitira consultar el estado de cada requerimiento para identificar si se encuentra abierto o cerrado por el usuario>\n");
      out.write("                ");
if("Abierto".equals(rs.getString("estado"))){
      out.write("\n");
      out.write("                <td><input class=\"ancho3\" type=\"submit\" value=\"Cerrar\">\n");
      out.write("                    <input type=\"hidden\" value=\"");
      out.print(rs.getString("codigo"));
      out.write("\" name=\"codigo\">\n");
      out.write("                    <input type=\"hidden\" value=\"5\" name=\"acto\"></td>\n");
      out.write("                ");
}
      out.write("\n");
      out.write("            </tr>\n");
      out.write("            </table>\n");
      out.write("            </form>\n");
      out.write("            ");
}}catch(Exception e){}
      out.write("\n");
      out.write("            <br><br><br>\n");
      out.write("            <!Accion que permite volver al menu principal>\n");
      out.write("            <form action=\"Menuprincipal.jsp\">\n");
      out.write("            <input class=\"btn\" type='submit' value=\"Volver al menu principal\"  size='12'>\n");
      out.write("            </form>\n");
      out.write("            \n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
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
