<%-- 
    Document   : AsignacionAlumno
    Created on : 28/08/2021, 12:36:38 PM
    Author     : gerar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../assets/css/bootstrap.css">
        <title>Asignacion Alumno</title>
    </head>
    <body>
        <h1>Listado AsignacionAlumnos</h1>

        <table class="table table-striped table-bordered">
            <thead class ="table-dark">
                <tr>
                    <th>ID</th>
                    <th>Carne</th>
                    <th>ID Curso</th>
                    <th>Fecha de Asignación</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="asignacionAlumno" items="${listadoAsignacionAlumno}">
                <tr>
                    <td>${asignacionAlumno.asignacionId}</td>
                    <td>${asignacionAlumno.carne}</td>
                    <td>${asignacionAlumno.cursoId}</td>
                    <td>${asignacionAlumno.fechaAsignacion}</td>
                    <td>
                        <a class="btn btn-danger" href="${pageContext.request.contextPath}/ServletAsignacionAlumnoController?accion=eliminar&asignacionId=${asignacionAlumno.asignacionId}">Eliminar</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    </body>
</html>
