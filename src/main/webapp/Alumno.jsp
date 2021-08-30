<%-- 
    Document   : Alumno.jsp
    Created on : 28/08/2021, 12:29:27 PM
    Author     : gerar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alumno</title>
    </head>
    <body>
        <h1>Listado de Alumnos</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Apellidos</th>
                    <th>Nombres</th>
                    <th>Email</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="alumno" items="${listadoAlumno}">
                    <tr>
                        <td>${alumno.carne}</td>
                        <td>${alumno.apellidos} </td>
                        <td>${alumno.nombres}</td>
                        <td>${alumno.email}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/ServletAlumnoController?accion=eliminar&carne=${alumno.carne}">Eliminar</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
