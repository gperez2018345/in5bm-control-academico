<%-- 
    Document   : folder.jsp
    Created on : 7/09/2021, 03:52:49 PM
    Author     : melga
--%>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark ">
    <div class="container-fluid">
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath}/index.jsp">Inicio <i class="fas fa-user-check"></i></a>
                </li>
                <li class="nav-item">

                    <a class="nav-link" href="${pageContext.request.contextPath}/ServletAlumnoController?accion=listar">Alumno  <i class="fas fa-walking"></i> </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/ServletAsignacionAlumnoController?accion=listar">Asignacion Alumno  <i class="fas fa-feather-alt"></i></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/ServletCarreraTecnicaController?accion=listar">Carrera Tecnica  <i class="fas fa-graduation-cap"></i></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/ServletCursoController?accion=listar">Curso  <i class="fas fa-chalkboard-teacher"></i></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/ServletHorarioController?accion=listar">Horario <i class="fas fa-calendar-alt"></i> </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/ServletInstructorController?accion=listar">Instructor <i class="fas fa-address-card"></i></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/ServletSalonController?accion=listar">Salon   <i class="fas fa-school"></i></a>
                </li>
            </ul>
        </div>
    </div>
</nav>