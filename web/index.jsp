<%-- 
    Document   : index
    Created on : 20/12/2023, 01:34:35 PM
    Author     : chino
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="CSS/normalize.css">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=DotGothic16&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="CSS/styles.css">

    <meta http-equiv="Expires" content="0">
    <meta http-equiv="Last-Modified" content="0">
    <meta http-equiv="Cache-Control" content="no-cache, mustrevalidate">
    <meta http-equiv="Pragma" content="no-cache">
    
    <title>Reposteria Delicias</title>
</head>

<body>
    <%@include file="header.jsp" %>
    
    <main class="contenedor">
        <div class="headimg">
        </div>
        <p class="">¡Bienvenid@ <%=nombreUser%> a la Resposteria Delicias! En nuestra pastelería, cada delicia está hecha para despertar tus sentidos y endulzar tu día. Sumérgete en un mundo de sabores exquisitos y texturas irresistibles, donde cada bocado es una experiencia única!</p>
        
        <div class="grid">
            <div class="producto">
                <a href="producto.jsp">
                    <img class="producto__img" src="img/1.jpg" alt="imagen-camisa">
                    <div class="producto__info">
                        <p class="producto__nombre">Pastel</p>
                        <p class="producto__precio">$25</p>

                    </div>
                    <!--CLASE producto_info-->
                </a>
            </div>
            <!--CLASE producto-->
            <div class="producto">
                <a href="producto.jsp">
                    <img class="producto__img" src="img/2.jpg" alt="imagen-camisa">
                    <div class="producto__info">
                        <p class="producto__nombre">Pastel</p>
                        <p class="producto__precio">$25</p>

                    </div>
                    <!--CLASE producto_info-->
                </a>
            </div>
            <!--CLASE producto-->
            <!--CLASE grid-->
            <div class="producto">
                <a href="producto.jsp">
                    <img class="producto__img" src="img/3.jpg" alt="imagen-camisa">
                    <div class="producto__info">
                        <p class="producto__nombre">Pastel</p>
                        <p class="producto__precio">$25</p>

                    </div>
                    <!--CLASE producto_info-->
                </a>
            </div>
            
            <div class="centrarg">
                <a href="menu.jsp" class="boton">Ver más</a>
            </div>
        </div>
       
    </main>
<%@include file="foot.html" %>
    

</body>

</html>
