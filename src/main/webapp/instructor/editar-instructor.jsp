<%-- 
    Document   : editar-instructor
    Created on : 15/09/2021, 08:14:03 PM
    Author     : gerar
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
        <title>Editar Intructores</title>
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
                                <h4 class="text-center">Editar Instructores</h4>
                            </div>
                            <div class="card-body bg-dark">
                                <form method="POST" action="${pageContext.request.contextPath}/ServletInstructorController" class="was-validated">
                                    <div class="mb-3 mt-3">
                                        <label for="instructorId" class="form-label text-light">ID</label>
                                        <input type="number" class="form-control" name="instructorId" id="instructorId" readonly value="${instructor.instructorId}">
                                    </div>

                                    <div class="mb-3">
                                        <label for="apellidos" class="form-label text-light">Apellidos</label>
                                        <input type="text" class="form-control" name="apellidos" id="apellidos" required value="${instructor.apellidos}">
                                    </div>
                                    <div class="mb-3">
                                        <label for="nombre" class="form-label text-light">Nombre</label>
                                        <input type="text" class="form-control" name="nombre" id="nombre" required value="${instructor.nombre}">
                                    </div>
                                    <div class="mb-3">
                                        <label for="direccion" class="form-label text-light">Dirección</label>
                                        <input type="direccion" class="form-control" name="direccion" id="direccion" required value="${instructor.direccion}">
                                    </div>
                                    <div class="mb-5">
                                        <label for="telefono" class="form-label text-light">Telefono</label>
                                        <input type="text" class="form-control" name="telefono" id="telefono" required value="${instructor.telefono}">
                                    </div>

                                    <input type="hidden" name="accion" value="actualizar">

                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal" onclick="location.href = '${pageContext.request.contextPath}/ServletInstructorController?accion=listar'">
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

