<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Cajero</title>
<link rel="stylesheet" href="css/formularioLogin.css">
</head>
<body>

	<h1>¡Bienvenido al cajero!</h1>
	
	<h3>Por favor, introduzca su número de cuenta para poder operar con el sistema.</h3>
	<main>
    <form action="Login" method="POST">
        
        <fieldset><legend>Login</legend>
            
            <label for="numeroCuenta">Número de cuenta: </label>
            
            <input id="numeroCuenta" type="text" name="numeroCuenta" placeholder="20220225" required autofocus/>
            <br>
            <br>
           
            <input class="submit" type="submit" value="Acceder" />
            
            <input class="reset" type="reset" value="Borrar campo introducido en el formulario" />
        </fieldset>
    </form>
</main>

</body>
</html>