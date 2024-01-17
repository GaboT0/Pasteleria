
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
        <title>Direccion</title>
    </head>
    <body>
        <%@include file="header.jsp" %>
        
        
        
        <h1>Datos de la dirección de envio</h1>
        <form class="formulariolog" action="SvPasteles?id=comprar" method="post">
                <div class="contenedor-campos">
                    <div class="campo w-100">
                        <label>Nombre</label>
                        <input type="text" name="nombre" placeholder="Nombre" required>
                    </div>
                    <div class="campo w-100">
                        <label>Calle</label>

                        <input type="text" name="calle" placeholder="Calle" required>
                    </div>
                    <div class="campo w-100">
                        <label>Número exterior</label>

                        <input type="number" name="numExt" placeholder="Numero exterior" required>
                    </div>
                    <div class="campo w-100">
                        <label>Número interior</label>

                        <input type="number" name="numInt" placeholder="Numero interior">
                    </div>
                    <div class="campo w-100">
                        <label>Colonia</label>

                        <input type="text" name="colonia" placeholder="Colonia" required>
                    </div>
                    <div class="campo w-100">
                        <label>Delegación</label>

                        <input type="text" name="deleg" placeholder="Delegación" required>
                    </div>
                    <div class="campo w-100">
                        <label>Código postal</label>

                        <input type="number" name="cp" placeholder="Código postal" required>
                    </div>
                    <select class="formulario__campo" name="metodopago" id="" required>
                        <option selected disabled value="">--Selecciona un metodo de pago</option>
                        <option value="Tarjeta">Tarjeta de Crédito/Debito</option>
                        <option value="Efectivo">Efectivo</option>
                    </select>
                </div><!--.contenedor-campos-->
                <div class="enviar" style="gap:1rem">
                    <input class="boton" type="submit" value="Realizar pedido"/>
                </div>
            </form>
         <%@include file="foot.html" %>
    </body>
</html>
