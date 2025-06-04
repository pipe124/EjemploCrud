<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Agregar Administrador</title>
</head>
<body>
    <h2>Agregar Administrador</h2>
    <form action="AdministradorServlet" method="post">
        <label>Nombre:</label><br>
        <input type="text" name="nombre" required><br><br>

        <label>Correo:</label><br>
        <input type="email" name="correo" required><br><br>

        <label>Contraseña:</label><br>
        <input type="password" name="contraseña" required><br><br>

        <input type="submit" value="Agregar">
    </form>
    <br>
    <a href="AdministradorServlet">Ver Lista de Administradores</a>
</body>
</html>