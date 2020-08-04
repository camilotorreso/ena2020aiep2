package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class consultarequerimiento_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");

String query1=(String) request.getAttribute("query1");

      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Consultar Requerimiento</title>\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\n");
      out.write("        <script>\n");
      out.write("            //$(document).ready(function() permite que cargue la pagina antes de usar las funciones\n");
      out.write("\t    $(document).ready(function(){\n");
      out.write("                \n");
      out.write("            //jquery change funtionc es para cuando cambie la lista de gerentes\n");
      out.write("            $('#listag').change(function(){\n");
      out.write("                \n");
      out.write("            //jquery dentro del change que borra las opciones de departamentos al hacer un cambio en la lista de gerentes\n");
      out.write("            $(\"#listad\").empty();\n");
      out.write("            \n");
      out.write("            //llama la funcion java script recargar lista, se explicara mas adelante\n");
      out.write("            recargarlista();\n");
      out.write("            });\n");
      out.write("            });\n");
      out.write("            \n");
      out.write("            //se crea la variable gerentes que guardara los gerentes existentes\n");
      out.write("            var gerentes=[];\n");
      out.write("            \n");
      out.write("            //se llama a la conexion con la base de datos\n");
      out.write("            ");
try{ 
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/requerimientos?zeroDateTimeBehavior=convertToNull","root","");
            
            //en la base de datos el gerente y el departamento del gerente
            //se encuentran juntos en la tabla gerencia, se ejecuta la consulta para mostrar todos los gerentes
            String query="select distinct gerente from gerencia";
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(query);
            
            //la variable i sera importante ya que en javascript aun no aprendo a trabajar matrices se explicara mas adelante
            int i=0;
            
            //en este while se crea se comienzan a guardar todos los registros de gerente en la variable java script
            //gerentes[gerentes.length] que guarda el dato en el ultimo registro del array como no tiene registros 
            //lo guarda en el indice 0
            //se crea la variable javascript var departamento"numero de la variable i"=[] la cual se crean en base a la cantidad de registros de gerentes
            //que mas adelante guardara los departamentos (son variables distintas ya que cambia su nombre con cada bucle)
            while(rs.next()){
      out.write("\n");
      out.write("            gerentes[gerentes.length]=\"");
      out.print(rs.getString("gerente"));
      out.write("\";\n");
      out.write("            var departamento");
      out.print(i);
      out.write("=[];\n");
      out.write("            \n");
      out.write("            //la variable i va suamndo cada registro que guarda, osea es la cantidad de variables departamento(i)=[] y\n");
      out.write("            // es la que cambia su nombre, a su ves es el mismisimo indice para identificar y llamar las variables mas adelante\n");
      out.write("            ");
i=i+1;}
            
            //se ejecuta la consulta que entrega el gerente y su departamento ya que se necesitara el gerente para la condicion
            //y el departamento para asignar los valores
            query="select depgerente, gerente from gerencia";
            rs=st.executeQuery(query);

            //el siguiente while realizara la funcion de asignar los valores a las variables departamento(i)=[]
            while(rs.next()){

            //el siguiente for dentro del while realizara la funcion que recorrera las variables departamento(i)
            //la condicion JAVASCRIPT sera si el gerente guardado en LA VARIABLE gerentes indice 0
            //corresponde a la del registro que entrega la consulta del campo gerente
            //sino corresponde seguira el bucle preguntando si el siguiente encargado corresponde al registro
            //si corresponde se guardara en la variable encargados con su propio indice ejemplo:
            // gerentes[0] corresponde al indice de departamento[0]=[] en la variable departamento se guardaran
            //todos los departamentos a los que pertenesca el gerente guardado en el indice gerentes[0]
            //estonces el bucle for con la variable i es la que sabe el numero de gerentes guardados en gerentes[]
            //estonces el bucle no puede exederce ya que es todo preciso y sin errores pensado para que si se
            //ingresan mas gerentes en la bdd los guarde y realize su respectiva asignacion, cada gerente tendra su variable departamento
            //con su propio indice tambien se podran asignar mas de un departamento a un gerente y se guardara correctamente
            //puede ser engorroso pero es la manera mas ultil y propia que encontre para que carge datos segun los registros
            //de la base de datos
            for(int e=0;e<i;e++){
      out.write("\n");
      out.write("            \n");
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
      out.write("            //se crea la funcion recargar lista que es llamada en la funcion change\n");
      out.write("            // ya que en la funcion jquery change al hacer un cambio en el select de gerentes se ejecuta\n");
      out.write("            //con la funcion empty de jquery se vacio la lista opciones de departamentos \n");
      out.write("            // append agrega a la listad(departamentos)que es la id, agrega la opcion 1 que es la por defecto\n");
      out.write("            function recargarlista(){\n");
      out.write("                $(\"#listad\").append(\"<option value=\\\"1\\\" label=\\\"Todos\\\"></option>\");\n");
      out.write("                \n");
      out.write("            //aqui se crea un bucle que preguntara por todos los gerentes guardados en la variable gerentes\n");
      out.write("            //nuevamente se ocupa la variable i que tiene el numero de gerentes guardados\n");
      out.write("            //con lo cual se ejecuta hasta encontrar el gerente que que se busca en la condicion\n");
      out.write("            ");
for(int e=0;e<i;e++){
      out.write("\n");
      out.write("                    \n");
      out.write("            //condicion javascript que recorre los registros guardados el cual mediante el for compara si el valor de\n");
      out.write("            //la lista de gerentes (listag) que es su id, .val que obtiene el valor del select de gerente\n");
      out.write("            //la variable e como recorre los registros es puesta en el indice de gerentes que a su ves es comparada con el\n");
      out.write("            //valor del select de gerentes si es correcto se implementara ese mismo indice e en la variable departamento ya que en el ejemplo \n");
      out.write("            //anterior se dijo que la variable gerentes el gerente guardado en el indice corresponde al nombre de la variable \n");
      out.write("            //departamento(mas el numero que esta ingresado en el nombre de la variable este numero\n");
      out.write("            //es el indice de la variable gerentes) esto se puede comprobar en configuraciones\n");
      out.write("            //del navegador herramientas de desarrollador ponga la pestaña consola y al seleccionar un gerente en las opciones\n");
      out.write("            //coloque en la consola departamento le sadran distintos nombres ejemplo departamento0,departamento1,departamento2\n");
      out.write("            //seleccione cualquiera y mostrara los departamentos que a su ves el ultimo numero de la variable departamento\"aqui\"\n");
      out.write("            //que selecciono corresponde al indice de la variable gerentes[\"aqui\"] que tambien puede ver en consola escribiendo\n");
      out.write("            //gerentes\n");
      out.write("                       if(gerentes[");
      out.print(e);
      out.write("]===$(\"#listag\").val()){\n");
      out.write("                           \n");
      out.write("            //for javascript que segun el indice de gerentes[\"este\"] del if se coloca en el nombre de departamento\"aqui\"\n");
      out.write("            //y se cuenta la cantidad de indices con el metodo length y repetir segun departamentos del gerente\n");
      out.write("            // realiza el blucle para agregar las opciones al select de listad que es el id de departamento\n");
      out.write("            //se cuentan los indices dentro de la variable departamento\"e\"[e] y se imprimen con el append uno a uno\n");
      out.write("                           for(i=0;i<departamento");
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
      out.write("    </head>\n");
      out.write("    <body class=\"fondo\">\n");
      out.write("        <div id=\"cuadro\">\n");
      out.write("        <h1>Consultar Requerimientos</h1>\n");
      out.write("        <hr>\n");
      out.write("        <!formulario que envia los datos a conrolador para luego traer la consulta correspondiente para requerimientos>\n");
      out.write("        <form action=\"controlador\" method=\"post\">\n");
      out.write("            \n");
      out.write("            <table>\n");
      out.write("                <!select que carga con la respectiva consulta los gerentes>\n");
      out.write("               <tr>\n");
      out.write("                    <td>Gerencia</td><td><select id=\"listag\" name=\"gerencia\" style=\"width:200px\" >\n");
      out.write("                    <option value=\"1\" label=\"Todos\"></option>\n");
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
      out.write("                    <!este select tiene el valor por defecto ya que al cambiar gerente cambiara esta>\n");
      out.write("                    <tr>\n");
      out.write("                    <td>Departamento</td><td><select id=\"listad\" name=\"departamentog\" style=\"width:200px\" >\n");
      out.write("                    <option value=\"1\" label=\"Todos\"></option>\n");
      out.write("                    </select></td>\n");
      out.write("                    </tr>\n");
      out.write("                \n");
      out.write("                    <tr>\n");
      out.write("                    <td><br></td><td></td>\n");
      out.write("                    </tr>\n");
      out.write("                    \n");
      out.write("                    <!select de asignado a que con su respectiva consulta muestra los departamentos de mantencion>\n");
      out.write("                    <tr>\n");
      out.write("                    <td>Asignado a</td><td><select style=\"width:200px\" name=\"departamentosm\">\n");
      out.write("                    <option value=\"1\" label=\"Todos\"></option>\n");
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
      out.write("                    <!boton y un valor oculto para identificar los formularios>\n");
      out.write("                    <tr><td><input type='submit' value=\"Buscar\" name=\"Buscar\"></td><td></td></tr>\n");
      out.write("                    <tr><td><input type='hidden' name=\"acto\" value=\"3\"></td><td></td>\n");
      out.write("                    </tr>\n");
      out.write("                    \n");
      out.write("            </table>\n");
      out.write("            <br><br><br>\n");
      out.write("            <!se crea la tabla que mostrara los requerimientos\n");
      out.write("            &nbsp; estp crea un espacio para que no esten tan juntas las columnas>\n");
      out.write("            <table border=\"4\" class=\"ancho\">\n");
      out.write("                <tr>\n");
      out.write("                    <th>Gerencia</th>\n");
      out.write("                    <th>Departamento</th>\n");
      out.write("                    <th>Asignado a</th>\n");
      out.write("                    <th>Encargado</th>\n");
      out.write("                    <th>Requerimiento</th>\n");
      out.write("                    <th>Estado</th>\n");
      out.write("                </tr>\n");
      out.write("                \n");
      out.write("                <!aqui agregara una fila si eligieron los parametros anteriores y se apreto el boton buscar el cual traera la \n");
      out.write("                variable query1 que es la consulta que se ejecutara abajo y mostrara todos los requerimientos en base a la busqueda>\n");
      out.write("                ");
  
                try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/requerimientos?zeroDateTimeBehavior=convertToNull","root","");
                Statement st=conn.createStatement();
                ResultSet rs=st.executeQuery(query1);
                while(rs.next()){
      out.write("\n");
      out.write("                \n");
      out.write("                <tr>\n");
      out.write("                    <td>");
      out.print(rs.getString("gerencia"));
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(rs.getString("departamento"));
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(rs.getString("departamentom"));
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(rs.getString("encargado"));
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(rs.getString("requerimiento"));
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(rs.getString("estado"));
      out.write("</td>\n");
      out.write("                </tr>\n");
      out.write("                \n");
      out.write("                ");
}}catch(Exception e){}
      out.write("\n");
      out.write("                \n");
      out.write("            </table>   \n");
      out.write("        </form>\n");
      out.write("        <br><br><br>\n");
      out.write("        <!form para volver al menu principal>\n");
      out.write("        <form action=\"Menuprincipal.jsp\">\n");
      out.write("        <input type='submit' value=\"Volver al menu principal\"  size='12'>\n");
      out.write("        </form>\n");
      out.write("        </div>\n");
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
