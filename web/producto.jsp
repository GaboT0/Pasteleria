<%-- 
    Document   : producto
    Created on : 20/12/2023, 01:44:32 PM
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
    <%@include file="header.html" %>

    <main class="contenedor">
        <h1>React JS</h1>
        <div class="camisa">
            <img class="camisa__imagen" src="img/1.jpg" alt="img_producto">
            <div class="camisa__contenido">
                <p>латыни из колледжа Hampden-Sydney, штат Вирджиния, взял одно из самых странных слов в Lorem Ipsum,
                    "consectetur", и</p>

                <form class="formulario">
                    <select class="formulario__campo" name="" id="">
                        <option selected disabled>--Selecionar talla</option>
                        <option value="">Chica</option>
                        <option value="">Mediana</option>
                        <option value="">Grande</option>
                    </select>
                    <input class="formulario__campo" type="number" placeholder="cantidad" min="1" max="200">
                    <input class="formulario__submit" type="submit" value="Agregar al carrito">
                </form>
            </div>
        </div>
    </main>

    <%@include file="foot.html" %>

</body>

</html>
