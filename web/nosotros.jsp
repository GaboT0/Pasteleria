<%-- 
    Document   : nosotros
    Created on : 20/12/2023, 01:44:51 PM
    Author     : chino
--%>

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

    <title>Front Store</title>
</head>

<body>
    <%@include file="header.jsp" %>
    <main class="contenedor">
        <h1>Nosotros</h1>

        <div class="nosotros">
            <div class="nosotros__contenido">
                <p>
                    Desde suaves pasteles hasta tentadores cupcakes, nuestra selección está cuidadosamente elaborada con ingredientes de la más alta calidad para ofrecerte un festín de placer para el paladar. Nos enorgullece compartir contigo no solo productos deliciosos, sino también la pasión y dedicación que ponemos en cada creación.

Explora nuestro menú virtual y descubre una variedad de opciones que harán las delicias de tu gusto. Ya sea para celebrar ocasiones especiales o simplemente para satisfacer tus antojos diarios, estamos aquí para hacer de cada momento un deleite inolvidable.

Gracias por elegirnos. ¡Esperamos que disfrutes de tu visita y que nuestros dulces te brinden momentos de felicidad y indulgencia! ¡Bienvenido a nuestra pastelería virtual, donde los sueños dulces se hacen realidad!
                </p>
            </div>
            <img src="img/nosotros.jpg" alt="nosotros" class="nosotros__imagen">
        </div>

        <section class="contenedor comprar">
            <h2 class="comprar__titulo">¿Porque comprar con nosotros?</h2>
            <div class="bloques">
                <div class="bloque">
                    <img class="bloque__imagen" src="img/icono_1.png" alt="icono1">
                    <h3 class="bloque__titulo">El mejor precio</h3>
                    

                </div>
                <!--BLOQUE-->
                <div class="bloque">
                    <img class="bloque__imagen" src="img/icono_3.png" alt="icono3">
                    <h3 class="bloque__titulo">Envio gratis</h3>
                    

                </div>
                <!--BLOQUE-->
                <div class="bloque">
                    <img class="bloque__imagen" src="img/icono_4.png" alt="icono4">
                    <h3 class="bloque__titulo">Excelente calidad</h3>
                    

                </div>
                <!--BLOQUE-->
            </div>
            <!--BLOQUES-->
        </section>
    </main>

   <%@include file="foot.html" %>

</body>

</html>
