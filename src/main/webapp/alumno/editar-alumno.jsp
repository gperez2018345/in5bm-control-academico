<%-- 
    Document   : editar-alumno
    Created on : 13/09/2021, 03:38:01 PM
    Author     : Diego Oswaldo Flores Rivas <dflores-2020010@kinal.edu.gt>
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
        <title>Editar Alumnos</title>
    </head>

    <body>
        <!--Cabecera-->
        <jsp:include page="../WEB-INF/paginas/comunes/header.jsp"/>
        <main>
            <div class="container">
                <div class="row">
                    <div class="col-12 col-md-12">
                        <div class="card mt-5">
                            <div class="card-header bg-black text-light">
                                <h4 class="text-center">Editar Alumnos</h4>
                            </div>
                            <div class="card-body bg-dark">
                                <form method="POST" action="${pageContext.request.contextPath}/ServletAlumnoController" class="was-validated">
                                    <div class="mb-3 mt-3">
                                        <label for="carne" class="form-label text-light">Carne</label>
                                        <input type="text" class="form-control" name="carne" id="carne" readonly value="${alumno.carne}">
                                    </div>

                                    <div class="mb-3">
                                        <label for="apellidos" class="form-label text-light">Nombre</label>
                                        <input type="text" class="form-control" name="apellidos" id="apellidos" required value="${alumno.apellidos}">
                                    </div>
                                    <div class="mb-3">
                                        <label for="nombres" class="form-label text-light">Apellido</label>
                                        <input type="text" class="form-control" name="nombres" id="nombres" required value="${alumno.nombres}">
                                    </div>
                                    <div class="mb-5">
                                        <label for="email" class="form-label text-light">Email</label>
                                        <input type="email" class="form-control" name="email" id="email" required value="${alumno.email}">
                                    </div>

                                    <input type="hidden" name="accion" value="actualizar">

                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal" onclick="location.href = '${pageContext.request.contextPath}/ServletAlumnoController?accion=listar'">
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
