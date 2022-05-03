<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Formacion</title>
<link rel="stylesheet" href="css/formularioLogin.css">
</head>
<body>

	<h1>¡Bienvenido a nuestra página!</h1>
	
	<h3>Puede introducir sus credenciales para acceder aquí.</h3>
	<main>
    <form action="Login" method="POST">
        
        <fieldset><legend>Login</legend>
            
            <label for="nombre">Nombre: </label>
            
            <input id="usuario" type="text" name="usuario" placeholder="Pablo" required autofocus/>
            <br>
            <br>
            
            <label for="password"> Contraseña: </label>
            <input id="password" type="password" name="password" required/>
            <br>
            <br>
            <input class="submit" type="submit" value="Acceder" />
            
            <input class="reset" type="reset" value="Borrar campos introducidos en el formulario" />
        </fieldset>
    </form>
</main>

</body>
</html>