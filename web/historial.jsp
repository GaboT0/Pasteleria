<%@page import="logic.Historial"%>
<%@page import="logic.Pastel"%>
<%@page import="java.util.List"%>
<%@page import="logic.Carrito"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
            List<Historial> historial = (List<Historial>) request.getSession().getAttribute("historial");
            
%>
        <h1>Historial</h1>
        <%
            for(Historial h : historial){
               
        %>
        <h1><%=h.getNombrePastel()%></h1>
        <div class="camisa">
            <img class="camisa__imagen" src="img/<%=h.getId_pastel()%>.jpg" alt="img_producto">
            <div class="camisa__contenido">
                <div class="formulario">
                 <!-- <form class="formulario">-->
                    <input class="formulario__campo" id="tamanio" name="tamanio" value="<%=h.getTamanio()%>" disabled>
                    <input class="formulario__campo" id="precio" name="precio" value="<%="Precio: "+h.getPrecio()%>" disabled>
                    <input class="formulario__campo" id="cantidad" name="cantidad" value="<%="Cantidad: "+h.getCantidad()%>" disabled>
                    <input class="formulario__campo" id="total" name="subtotal" disabled  value="<%="Subtotal: $"+h.getSubtotal()%>" >
                    <input class="formulario__campo" id="total" name="total" disabled  value="<%="TOTAL: $"+h.getTotal()%>" >
                    <input class="formulario__campo" id="total" name="nombre" disabled  value="<%="Nombre: "+h.getNombre()%>" >
                    <input class="formulario__campo" id="total" name="calle" disabled  value="<%="Calle: "+h.getCalle()%>" >
                    <input class="formulario__campo" id="total" name="numExt" disabled  value="<%="NumExt.: "+h.getNumExt()%>" >
                    <input class="formulario__campo" id="total" name="numInt" disabled  value="<%="NumInt.: "+h.getNumInt()%>" >
                    <input class="formulario__campo" id="total" name="colonia" disabled  value="<%="Colonia: "+h.getColonia()%>" >
                    <input class="formulario__campo" id="total" name="delegacion" disabled  value="<%="Delegacion: "+h.getDelegacion()%>" >
                    <input class="formulario__campo" id="total" name="cp" disabled  value="<%="Cod.Post.: "+h.getCp()%>" >
                    <input class="formulario__campo" id="total" name="metodoPago" disabled  value="<%="Metodo de Pago: "+h.getMetodo_pago()%>" >
                </div>
                <!--</form>-->
            </div>
        </div>
                    <%
            }

        %>
        
        
        <%@include file="foot.html" %>
    </body>
</html>
