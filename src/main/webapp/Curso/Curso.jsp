<%-- 
    Document   : Curso
    Created on : 28/08/2021, 12:36:18 PM
    Author     : gerar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../assets/css/bootstrap.css">
        <title>Curso</title>
    </head>
    <body>
        <h1>Listado de Cursos</h1>

        <table class="table table-striped table-bordered">
            <thead class ="table-dark">
                <tr>
                    <th>ID</th>
                    <th>Ciclo</th>
                    <th>Cupo Maximo</th>
                    <th>Cupo Minimo</th>
                    <th>Descripcion</th>
                    <th>Codigo Carrera</th>
                    <th>ID Horario</th>
                    <th>ID Instructor</th>
                    <th>ID Salon</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="curso" items="${listadoCurso}">
                <tr>
                    <td>${curso.cursoId}</td>
                    <td>${curso.ciclo}</td>
                    <td>${curso.cupoMaximo}</td>
                    <td>${curso.cupoMinimo}</td>
                    <td>${curso.descripcion}</td>
                    <td>${curso.codigoCarrera}</td>
                    <td>${curso.horarioId}</td>
                    <td>${curso.instructorId}</td>
                    <td>${curso.salonId}</td>
                    <td>
                        <a class="btn btn-danger" href="${pageContext.request.contextPath}/ServletCursoController?accion=eliminar&cursoId=${curso.cursoId}">Eliminar</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</body>
</html>
