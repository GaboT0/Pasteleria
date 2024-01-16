<%-- 
    Document   : index
    Created on : 20/12/2023, 01:34:35 PM
    Author     : chino
--%>

<%@page import="java.util.Date"%>
<%@page import="logic.Pastel"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="CSS/normalize.css">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=DotGothic16&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="CSS/styles.css">

    <title>Reposteria delicias</title>
</head>

<body>
    <%@include file="header.jsp" %>

    <main class="contenedor">
        <div class="headimg">
        </div>
        <h1>Nuestras delicias</h1>
        
        <div class="grid">
             <% 
            List<Pastel> pasteles = (List) request.getSession().getAttribute("pasteles");
            
            if(pasteles == null){
                response.sendRedirect("index.jsp");
}
             %>
            <%
                if(request.getParameter("stock") != null){
                    String stock = (String) request.getParameter("stock");
                    if(Integer.parseInt(stock) == 1){
                    
            %>
            <script> alert("STOCK AGOTADO PARA ESTE PASTEL"); </script>
            <% } } %>
        <%
            for(Pastel us : pasteles){

        %>
       
        <a href="SvPasteles?id=<%=us.getId_pastel() %>">
            <div class="producto">
                
                    <img class="producto__img" src="img/<%=us.getId_pastel() %>.jpg" alt="imagen-pastel">
                    <div class="producto__info">
                        <p class="producto__nombre"><%=us.getNombre() %></p>
                    </div>
                    <!--CLASE producto_info-->
            </div>
        </a>
             <%
            }
        %>
            <!--
            <div class="producto">
                <a href="producto.jsp">
                    <img class="producto__img" src="img/2.jpg" alt="imagen-camisa">
                    <div class="producto__info">
                        <p class="producto__nombre">Pastel de chocolate 2</p>
                        <p class="producto__precio">$25</p>
                    </div>
                    
                </a>
            </div>
           
            <div class="producto">
                <a href="producto.jsp">
                    <img class="producto__img" src="img/3.jpg" alt="imagen-camisa">
                    <div class="producto__info">
                        <p class="producto__nombre">Pastel con hojuelas</p>
                        <p class="producto__precio">$25</p>

                    </div>
                  
                </a>
            </div>
           
            <div class="producto">
                <a href="producto.jsp">
                    <img class="producto__img" src="img/4.jpg" alt="imagen-camisa">
                    <div class="producto__info">
                        <p class="producto__nombre">Pastel de chocolate 3</p>
                        <p class="producto__precio">$25</p>

                    </div>
                  
                </a>
            </div>
            
            <div class="producto">
                <a href="producto.jsp">
                    <img class="producto__img" src="img/5.jpg" alt="imagen-camisa">
                    <div class="producto__info">
                        <p class="producto__nombre">Pastel frutos rojos c/n galletas</p>
                        <p class="producto__precio">$25</p>

                    </div>
                    
                </a>
            </div>
           
            <div class="producto">
                <a href="producto.jsp">
                    <img class="producto__img" src="img/6.jpg" alt="imagen-camisa">
                    <div class="producto__info">
                        <p class="producto__nombre">Pastel frutos rojos</p>
                        <p class="producto__precio">$25</p>

                    </div>
                   
                </a>
            </div>
            
            <div class="producto">
                <a href="producto.jsp">
                    <img class="producto__img" src="img/7.jpg" alt="imagen-camisa">
                    <div class="producto__info">
                        <p class="producto__nombre">Pastel elegante fresa</p>
                        <p class="producto__precio">$25</p>

                    </div>
                   
                </a>
            </div>
           
            <div class="producto">
                <a href="producto.jsp">
                    <img class="producto__img" src="img/8.jpg" alt="imagen-camisa">
                    <div class="producto__info">
                        <p class="producto__nombre">Pastel fresa cumpleaños</p>
                        <p class="producto__precio">$25</p>

                    </div>
                    
                </a>
            </div>
            
            <div class="producto">
                <a href="producto.jsp">
                    <img class="producto__img" src="img/9.jpg" alt="imagen-camisa">
                    <div class="producto__info">
                        <p class="producto__nombre">Pastel de chocolate 4</p>
                        <p class="producto__precio">$25</p>

                    </div>
                    
                </a>
            </div>
            -->

            

        </div>

    </main>

   <%@include file="foot.html" %>

</body>

</html>
