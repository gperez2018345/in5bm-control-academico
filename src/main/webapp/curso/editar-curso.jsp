<%-- 
    Document   : editar-curso
    Created on : 14/09/2021, 07:41:56 PM
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
        <title>Editar Curso</title>
    </head>

    <body>
        <!--Cabecera-->
        <jsp:include page="../WEB-INF/paginas/comunes/header.jsp"/>
        <main>
            <div class="container">
                <div class="row">
                    <div class="col-12 col-md-12">
                        <div class="card mt-5 mb-5">
                            <div class="card-header bg-black text-light">
                                <h4 class="text-center">Editar Curso</h4>
                            </div>
                            <div class="card-body bg-dark">
                                <form method="POST" action="${pageContext.request.contextPath}/ServletCursoController" class="was-validated">
                                    <div class="mb-3 mt-3">
                                        <label for="cursoId" class="form-label text-light">ID</label>
                                        <input type="number" class="form-control" name="cursoId" id="carne" readonly value="${curso.cursoId}">
                                    </div>

                                    <div class="mb-3">
                                        <label for="ciclo" class="form-label text-light">Ciclo</label>
                                        <input type="number" class="form-control" name="ciclo" id="ciclo" required value="${curso.ciclo}">
                                    </div>
                                    <div class="mb-3">
                                        <label for="cupoMaximo" class="form-label text-light">Cupo Máximo</label>
                                        <input type="number" class="form-control" name="cupoMaximo" id="cupoMaximo" required value="${curso.cupoMaximo}">
                                    </div>
                                    <div class="mb-3">
                                        <label for="cupoMinimo" class="form-label text-light">Cupo Minimo</label>
                                        <input type="number" class="form-control" name="cupoMinimo" id="cupoMinimo" required value="${curso.cupoMinimo}">
                                    </div>

                                    <div class="mb-3">
                                        <label for="descripcion" class="form-label text-light">Descripción</label>
                                        <input type="text" class="form-control" name="descripcion" id="descripcion" required value="${curso.descripcion}">
                                    </div>

                                    <div class="mb-3">
                                        <label for="codigoCarrera" class="form-label text-light">Codigo Carrera</label>
                                        <input type="text" class="form-control" name="codigoCarrera" id="codigoCarrera" required value="${curso.codigoCarrera}">
                                    </div>

                                    <div class="mb-3">
                                        <label for="horarioId" class="form-label text-light">Id Horario</label>
                                        <input type="number" class="form-control" name="horarioId" id="horarioId" required value="${curso.horarioId}">
                                    </div>
                                    <div class="mb-3">
                                        <label for="instructorId" class="form-label text-light">Id Instructor</label>
                                        <input type="number" class="form-control" name="instructorId" id="instructorId" required value="${curso.instructorId}">
                                    </div>
                                    <div class="mb-5">
                                        <label for="salonId" class="form-label text-light">Id salon</label>
                                        <input type="number" class="form-control" name="salonId" id="salonId" required value="${curso.salonId}">
                                    </div>

                                    <input type="hidden" name="accion" value="actualizar">

                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal" onclick="location.href = '${pageContext.request.contextPath}/ServletCursoController?accion=listar'">
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