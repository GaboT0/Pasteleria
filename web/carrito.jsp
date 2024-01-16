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
            List<Carrito> compras = (List<Carrito>) request.getSession().getAttribute("carrito");
            int index = 0;
//            if(compras == null){
//                response.sendRedirect("index.jsp");
//            }
           
        %>
        
        <h1>Carrito de compras</h1>
        <%
            for(Carrito comp : compras){
                //System.out.println(comp.getTamanio());
        %>
        <div class="camisa">
            <img class="camisa__imagen" src="img/<%=comp.getId_pastel()%>.jpg" alt="img_producto">
            <div class="camisa__contenido">
                <div class="formulario">
                 <!-- <form class="formulario">-->
                    <input class="formulario__campo" id="tamanio" name="tamanio" value="<%=comp.getTamanio()%>" disabled>
                    <input class="formulario__campo" id="cantidad" name="cantidad" value="<%="Cantidad: "+comp.getCantidad()%>" disabled>
                    <input class="formulario__campo" id="total" name="total" disabled  value="<%="Subtotal: $"+comp.getSubtotal()%>" >
                    
                    
                    <a href="SvPasteles?id=quitarCarrito&index=<%=index%>"><input class="formulario__submit" type="submit" value="Quitar del carrito"></a>
                    <a href="SvPasteles?id=irEditar&index=<%=index%>"><input class="formulario__submit" type="submit" value="Editar"></a>
                </div>
                <!--</form>-->
            </div>
        </div>
                    <%
                        index +=1;
            }
        %>
        
        
        
        
        
      
        
        
        <%@include file="foot.html" %>
    </body>
</html>