<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Lista de Administradores</title>
</head>
<body>
    <h2>Lista de administradores</h2>
    <table border="1">
        <tr>
            <th>ID_administrador</th>
            <th>nombre</th>
            <th>correo</th>
            <th>contraseña</th>
        </tr>
        <c:forEach var="administrador" items="${listaadministrador}">
            <tr>
                <td>${administrador.ID_administrador}</td>
                <td>${administrador.nombre}</td>
                <td>${administrador.correo}</td>
                <td>${administrador.contraseña}</td>
            </tr>
        </c:forEach>
    </table>

    <h3>Agregar nuevo Administrador</h3>
    <form action="AdministradorServlet" method="post">
        Nombre: <input type="text" name="nombre" required><br>
        Correo: <input type="email" name="correo" required><br>
        Contraseña: <input type="password" name="contraseña" required><br>
        <input type="submit" value="Agregar Administrador">
    </form>
</body>
</html>
