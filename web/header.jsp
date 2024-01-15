
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<header class="header">
        <!--BLOQUE-->
        <a href="index.jsp">
            <img class="header__logo" src=" img/logo.png" alt="Logotipo" width="400" height="400">
        </a>
</header>
        <% 
            String nombreUser = (String) request.getSession().getAttribute("nombreUser");
if(nombreUser == null){
    response.sendRedirect("login.jsp");
}
        %>
<nav class="navegacion">
    <!--BLOQUE-->
    <a class="navegacion__link" href="index.jsp">Tienda</a>
    <a class="navegacion__link" href="nosotros.jsp">Nosotros</a>
    <a class="navegacion__link" href="SvPasteles">Menu</a>
    <a class="navegacion__account" href=""><%=nombreUser%></a>
    <a class="navegacion__close" href="SvLogout">Cerrar sesion</a>
</nav>
