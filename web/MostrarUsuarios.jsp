<%-- 
    Document   : MostrarUsuarios
    Created on : 21/12/2023, 01:21:10 PM
    Author     : chino
--%>

<%@page import="logic.Usuario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mostrar Usuarios</title>
    </head>
    <body>
        <h1>Lista de usuarios</h1>
        
        <% 
            List<Usuario> listaUsers = (List) request.getSession().getAttribute("listaUsers");
            int cont = 1;
            for(Usuario us : listaUsers){

        %>
        
        <p>Cliente n° <%=cont%></p>
        <p>
            usuario: <%=us.getNombre()%>
        </p>
        <p>
            email:<%=us.getEmail()%>
        </p>
        <p>
            password:<%=us.getContrasena()%>
        </p>
        <p>--------------------------------------------------------------------------</p>
        <% cont += 1;%>
        <%
            }
        %>
    </body>
</html>
