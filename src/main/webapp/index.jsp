    <%-- 
    Document   : index
    Created on : 28/08/2021, 12:30:54 PM
    Author     : gerar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <header><ul>
                <h1>Control Academico</h1>
                <li><a href="${pageContext.request.contextPath}/ServletAlumnoController?accion=listar">Alumno</a></li>
                <li><a href="AsignacionAlumno/AsignacionAlumno.jsp">Asignacion Alumno</a></li>
                <li><a href="${pageContext.request.contextPath}/ServletCarreraTecnicaController?accion=listar">Carrera Tecnica</a></li>
                <li><a href="Curso/Curso.jsp">Curso</a></li>
                <li><a href="${pageContext.request.contextPath}/ServletHorarioController?accion=listar">Horario</a></li>
                <li><a href="Instructor/Instructor.jsp">Instructor</a></li>
                <li><a href="${pageContext.request.contextPath}/ServletSalonController?accion=listar">Salon</a></li>
            </ul></header>
    </body>
</html>
