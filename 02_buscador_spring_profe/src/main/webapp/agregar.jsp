<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="Agregar" method="POST">
Direccion: <input type="text" name="direccion">
Tematica: <input type="text" name="tematica">
Descripcion: <input type="text" name="descripcion">

<input type="submit" value="Agregar">
</form>
</body>
</html>