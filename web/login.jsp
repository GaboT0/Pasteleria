
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
        <title>Reposteria delicias</title>
    </head>
    
    <body>
        <header class="header">
            <a>
                <img class="header__logo" src=" img/logo.png" alt="Logotipo" width="400" height="400">
            </a>
            
        </header>
        <main class="contenedor">
            <div id="contacto" class="contacto">
            <h1>¡Bienvenid@!</h1>
            <form class="formulariolog" action="SvLogin" method="GET">
                <div class="contenedor-campos">
                    <div class="campo w-100">
                        <label>Usuario / Correo</label>

                        <input type="text" name="user" placeholder="Usuario" required>
                    </div>
                    <div class="campo w-100">
                        <label>Contraseña</label>

                        <input type="text" name="password" placeholder="Contraseña" required>
                    </div>
                </div><!--.contenedor-campos-->
                <div class="enviar" style="gap:1rem">
                    <input class="boton" type="submit" value="Iniciar sesión"/>
                    <a href="signup.jsp" class="botonsec">Registrarse</a>
                </div>
                
            </form>
            
        </div>
        </main>
        
    </body>
</html>
