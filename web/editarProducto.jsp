
<%@page import="logic.Carrito"%>
<%@page import="logic.Pastel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
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
<% 
            
            Carrito pastel = (Carrito) request.getSession().getAttribute("compra");
            int index = Integer.parseInt(request.getSession().getAttribute("indexEditar").toString());
            if(pastel == null){
                response.sendRedirect("index.jsp");
            }
           
        %>
    
    <main class="contenedor">
        <h1>Editar <%=pastel.getNombrePastel()%></h1>
        <div class="camisa">
            <img class="camisa__imagen" src="img/<%=pastel.getId_pastel()%>.jpg" alt="img_producto">
            <div class="camisa__contenido">
                

                <form class="formulario" action="SvPasteles?id=editarCarrito&idPastel=<%=pastel.getId_pastel()%>&index=<%=index%>" method="POST">
                    <select onchange="listenTam()" class="formulario__campo" name="tamanio" id="tamanio">
                        <option value="300">Chico - $300</option>
                        <option value="500">Mediano - $500</option>
                        <option value="800">Grande - $800</option>
                    </select>
                    <input onchange="listenTam()" class="formulario__campo" id="cantidad" name="cantidad" type="number" placeholder="Cantidad" value="<%=pastel.getCantidad()%>" min="1" max="20">
                    <input class="formulario__campo" id="total" name="total" disabled  value="<%=pastel.getSubtotal()%>" placeholder="Total">
                    
                    <input class="formulario__submit" type="submit" value="Agregar al carrito">
                </form>
            </div>
        </div>
    </main>
           
    <%@include file="foot.html" %>
    <script src="js/editarProducto.js"></script>
    <script>
        selectValueTam('<%=pastel.getPrecio()%>');
    </script>
    </body>
</html>
