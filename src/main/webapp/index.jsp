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
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>FUNDACION KINAL</title>
        <link rel="stylesheet" href="assets/css/style.css">
        <link rel="stylesheet" href="./assets/css/bootstrap.css">
        <script src="https://kit.fontawesome.com/a091fe25d9.js" crossorigin="anonymous"></script>
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
            
            <jsp:include page="/WEB-INF/paginas/comunes/header.jsp" />
            <main>
                <section>
                    <img id="kinal-img-principal" src="assets/images/fotofondo.png" alt="Fundacion Kinal">
                </section>
            </main>
            <jsp:include page="/WEB-INF/paginas/comunes/footer.jsp" />
            <script src="assets/js/jquery-3.6.0.js"></script>
            <script src="assets/js/bootstrap.bundle.js"></script>

    </body>
</html>
