<%-- 
    Document   : editar-horario
    Created on : 13/09/2021, 07:33:42 PM
    Author     : Pablo Emmanuel Mich Mux // Codigo Técnico: IN5BM
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
        <title>Editar Horarios</title>
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
                                <h4 class="text-center">Editar Horarios</h4>
                            </div>
                            <div class="card-body bg-dark">
                                <form method="POST" action="${pageContext.request.contextPath}/ServletHorarioController" class="was-validated">
                                    <div class="mb-3 mt-3">
                                        <label for="horarioId" class="form-label text-light">ID</label>
                                        <input type="text" class="form-control" name="horarioId" id="horarioId" readonly value="${horario.horarioId}">
                                    </div>

                                    <div class="mb-3">
                                        <label for="horarioIncio" class="form-label text-light">Hora de Inicio</label>
                                        <input type="time" class="form-control" name="horarioInicio" id="horarioInicio" required value='<fmt:formatDate value="${horario.horarioInicio}" pattern="HH:mm"/>'>
                                    </div>
                                    <div class="mb-5">
                                        <label for="horarioFinal" class="form-label text-light">Hora Final</label>
                                        <input type="time" class="form-control" name="horarioFinal" id="horarioFinal" required value='<fmt:formatDate value="${horario.horarioFinal}" pattern="HH:mm"/>'>
                                    </div>

                                    <input type="hidden" name="accion" value="actualizar">

                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal" onclick="location.href = '${pageContext.request.contextPath}/ServletHorarioController?accion=listar'">
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
