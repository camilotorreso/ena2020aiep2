<%-- 

    Document   : Cerrarrequerimientos
    Created on : 30-jul-2020, 11:38:01
    Author     : loret
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<%
String query1=(String) request.getAttribute("query1");
String vacio=(String) request.getAttribute("vacio");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title class="p">CERRAR REQUERIMIENTOS</title>
        <link href="css/estiloCerrarRq.css" rel="stylesheet" type="text/css"/>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script>
            //$(document).ready(function() permite cargar la página antes de comenzar las funciones.
	    $(document).ready(function(){
                
            //jquery change funtionc se ejecutara cuando exista un cambio en la lista de gerente.
            $('#listag').change(function(){
                
            //jquery dentro de change que permite eliminar opciones de departamentos, mientras se realicen cambios en la lista gerentes
            $("#listad").empty();
            
            recargarlista();
            });
            });
            
            //Está variable permite que se guarden los gerentes existentes
            var gerentes=[];
            
            //se solicita conexion a la base de datos
            <%try{ 
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/requerimientos?zeroDateTimeBehavior=convertToNull","root","");
            
            //Esta consulta a la Base de datos permite mostrar todos los gerentes registrados 
            String query="select distinct gerente from gerencia";
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(query);
            
            
            int i=0;
            
            // Este While permitira que se guarden los registros asociados al campo gerente, 
            // él cual se guarda en la variable mencionada.
            
            while(rs.next()){%>
            gerentes[gerentes.length]="<%=rs.getString("gerente")%>";
            var departamento<%=i%>=[];
            
            <%i=i+1;}
            
            
            //Ejecutamos la consulta que muestra datos del gerente y su departamento 
            //y asi conocer si cumple las condiciones para asignar los valores.

            query="select depgerente, gerente from gerencia";
            rs=st.executeQuery(query);
            
            //En el siguiente while se realiza la funcion para asignar valor a la variable departamento
            // A través del for que permitira guardar los valores del campo departamento e ingresarlos a la variable
            // De esa manera los datos ingresados serán guardados en la BD.
            while(rs.next()){

            for(int e=0;e<i;e++){%>
                if(gerentes[<%=e%>]==="<%=rs.getString("gerente")%>"){
                departamento<%=e%>[departamento<%=e%>.length]="<%=rs.getString("depgerente")%>";
            
            }
            <%}}%>
            //Esta funcion permite cargar la lista con los valores asignados mediante un bucle que identificara los diferentes 
            // gerentes que se han ingresados, de esa forma se podra ubicar al gerente que seleccionemos y hara la diferencia 
            // entre departamento y gerentes para asi encontrar al solicitado.
            
            function recargarlista(){
                $("#listad").append("<option value=\"1\" label=\"Todos\"></option>");            
            <%for(int e=0;e<i;e++){%>
            
            if(gerentes[<%=e%>]===$("#listag").val()){                          
        
            for(i=0;i<departamento<%=e%>.length;i++){
            $("#listad").append("<option value='"+departamento<%=e%>[i]+"'>"+departamento<%=e%>[i]+"</option>");
            };};
            <%}%>
            }
            <%}catch(Exception e){}%>
            
            </script>

   </head>
   <body class="fondo">
       <!Menú que permite cerrar requerimientos especificos>
       <div id="cuadro">
           <h1 class="p">CERRAR REQUERIMIENTOS</h1>
           <br>
        <form action="controlador">
             <table>
                <!Select que carga a traves de la BD los gerentes ingresados>
               <tr>
                    <td class="p">Gerencia</td><td><select class="btn" id="listag" name="gerencia" style="width:200px" >
                    <option value="1" label="Escoge una opcion"></option>
                    <%
                    try{
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/requerimientos?zeroDateTimeBehavior=convertToNull","root","");
                    String query="select distinct gerente from gerencia ";
                    Statement st=conn.createStatement();
                    ResultSet rs=st.executeQuery(query);
                    while(rs.next()){%>
                    
                    <option value="<%=rs.getString("gerente")%>" label="<%=rs.getString("gerente")%>"></option>
                    <%}
                    }catch(Exception e){}%>
                    </select></td>
                    </tr>
                
                    <tr>
                    <td><br></td><td></td>
                    </tr>
                    
                    <!Select conectado con el anterior, ya que deben estar conectados entre si para mostrar la información indicada>
                    <tr>
                    <td class="p">Departamento</td><td><select class="btn" id="listad" name="departamentog" style="width:200px" >
                    <option value="1" label="Escoge una opcion"></option>
                    </select></td>
                    </tr>
                
                    <tr>
                    <td><br></td><td></td>
                    </tr>
                    
                    <!Select que mostrara el area asignada dependiendo de su departamento>
                    <tr>
                    <td class="p">Asignado a</td><td><select class="btn" style="width:200px" name="departamentosm">
                    <option value="1" label="Escoge una opcion"></option>
                    <%
                    try{
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/requerimientos?zeroDateTimeBehavior=convertToNull","root","");
                    String query="select departamento from depa ";
                    Statement st=conn.createStatement();
                    ResultSet rs=st.executeQuery(query);
                    while(rs.next()){%>
                    
                    <option value="<%=rs.getString("departamento")%>" label="<%=rs.getString("departamento")%>"></option>
                            
                    <%}
                    }catch(Exception e){}
                    %>
                    </select></td>
                    </tr> 
                    
                    <tr>
                    <td><br></td><td></td>
                    </tr>
                    <!Boton que permite buscar los datos solicitados por el usuario>
                    <tr><td><input class="btn" type='submit' value="Buscar" name="Buscar"></td><td></td></tr>
                    <tr><td><input type='hidden' name="acto" value="4"></td><td></td>
                    </tr>
            </table>
            <!mensaje para verificar que los campos esten completos>
            <%if(vacio!=null){%>
            <h2><%=vacio%></h2>
            <%}%>
            </form>
            <!Tabla que muestra los requerimientos buscados>
            <table border="5" class="ancho">
                <tr>
                    <th>Gerencia</th>
                    <th>Departamento</th>
                    <th>Asignado a</th>
                    <th>Encargado</th>
                    <th>Requerimiento</th>
                    <th>Estado</th>
                </tr>
            </table>
               <!Este Try permitira la conexión con la BD para mostrar los resultados de la busqueda>
            <%  
            try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/requerimientos?zeroDateTimeBehavior=convertToNull","root","");
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(query1);
            while(rs.next()){%>
                
            <!A través de este formulario se mostrara los datos solicitados de acuerdo a cada campo>
            <form action="controlador" method="get">
            <table border="5" class="ancho2">    
            <tr>
                <td><%=rs.getString("gerencia")%></td>
                <td><%=rs.getString("departamento")%></td>
                <td><%=rs.getString("departamentom")%></td>
                <td><%=rs.getString("encargado")%></td>
                <td><%=rs.getString("requerimiento")%></td>
                <td><%=rs.getString("estado")%></td>
                <!Este if permitira consultar el estado de cada requerimiento para identificar si se encuentra abierto o cerrado por el usuario>
                <%if("Abierto".equals(rs.getString("estado"))){%>
                <td><input class="ancho3" type="submit" value="Cerrar">
                    <input type="hidden" value="<%=rs.getString("codigo")%>" name="codigo">
                    <input type="hidden" value="5" name="acto"></td>
                <%}%>
            </tr>
            </table>
            </form>
            <%}}catch(Exception e){}%>
            <br><br><br>
            <!Accion que permite volver al menu principal>
            <form action="Menuprincipal.jsp">
            <input class="btn" type='submit' value="Volver al menu principal"  size='12'>
            </form>
            
    </body>
</html>

