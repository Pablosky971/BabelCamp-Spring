<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<form action="ModificarPrecio" method="POST">
			Nombre:<input type="text" name="nombre"><br>
			Nuevo precio:<input type="text" name="precio"><br>
			<input type="submit" value="Modificar">
		</form>
		<br>
		<a href="inicio.jsp">Volver</a>
	</center>
</body>
</html>