
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<header class="header">
        <!--BLOQUE-->
        <a href="index.jsp">
            <img class="header__logo" src=" img/logo.png" alt="Logotipo" width="400" height="400">
        </a>
</header>
        <% 
            String nombreUser = (String) request.getSession().getAttribute("nombreUser");

        %>
<nav class="navegacion">
    <!--BLOQUE-->
    <a class="navegacion__link navegacion__link--activo" href="index.jsp">Tienda</a>
    <a class="navegacion__link" href="nosotros.jsp">Nosotros</a>
    <a class="navegacion__link" href=""><%=nombreUser%></a>
     
</nav>
