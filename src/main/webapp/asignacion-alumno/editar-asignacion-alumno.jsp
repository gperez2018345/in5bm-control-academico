<%-- 
    Document   : editar-asignacion-alumno
    Created on : 14/09/2021, 03:27:45 PM
    Author     : Derek Steve Chajón Hernández 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="es_GT"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="./assets/css/styleIdentidad.css">
        <link rel="stylesheet" href="./assets/css/bootstrap.css">
        <link rel="stylesheet" href="./assets/css/style.css">
        <script src="https://kit.fontawesome.com/b54b4661b2.js" crossorigin="anonymous"></script>
        <title>Editar AsignacionAlumno</title>
    </head>
    <body>
        <jsp:include page="../WEB-INF/paginas/comunes/header.jsp"/>

        <main>
            <div class="container">
                <div class="row">
                    <div class="col-12 col-md-12">
                        <div class="card mt-5">
                            <div class="card-header bg-black text-light">
                                <h4 class="text-center">Editar AsignacionAlumno</h4>
                            </div>
                            <div class="card-body bg-dark">
                                <form method="POST" action="${pageContext.request.contextPath}/ServletAsignacionAlumnoController" class="was-validated">

                                    <div class="mb-3">
                                        <label for="asignacionId">ID Asignación</label>
                                        <input type="text" class="form-control" name="asignacionId" id="asignacionId" readonly value="${asignacionAlumno.asignacionId}">
                                    </div>

                                    <div class="mb-3">
                                        <label for="carne">Carne</label>
                                        <input type="text" class="form-control" name="carne" id="carne" required value="${asignacionAlumno.carne}">
                                    </div>

                                    <div class="mb-3">
                                        <label for="cursoId" class="form-label">ID Curso </label>
                                        <input type="number" class="form-control" name="cursoId" id="cursoId" required value="${asignacionAlumno.cursoId}">
                                    </div>

                                    <div class="mb-3">
                                        <label for="fechaAsignacion" class="form-label">Fecha de Asignación </label>
                                        <input type="date" class="form-control" name="fechaAsignacion" id="fechaAsignacion" required value="${asignacionAlumno.fechaAsignacion}">
                                    </div>


                                    <input type="hidden" name="idAsignacion" value="${asignacionAlumno.asignacionId}">
                                    <input type="hidden" name="accion" value="actualizar">

                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal" onclick="location.href = '${pageContext.request.contextPath}/ServletAsignacionAlumnoController?accion=listar'">
                                        Cancelar
                                    </button>
                                    <button type="submit" class="btn btn-success">Guardar</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </main>


        <!--Pie de pagina-->
        <jsp:include page="../WEB-INF/paginas/comunes/footer.jsp"/>
        <!--JavaScript-->
        <script src="../assets/js/jquery-3.6.0.js"></script>
        <script src="../assets/js/bootstrap.bundle.js"></script>
    </body>
</html>
