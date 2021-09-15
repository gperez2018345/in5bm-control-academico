<%-- 
    Document   : editar-salon
    Created on : 14/09/2021, 05:44:24 PM
    Author     : melga
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
        <title>Editar Salon</title>
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
                                <h4 class="text-center">Editar Salon</h4>
                            </div>
                            <div class="card-body bg-dark">
                                <form method="POST" action="${pageContext.request.contextPath}/ServletSalonController" class="was-validated">
                                    <div class="mb-3 mt-3">
                                        <label for="salonId" class="form-label text-light">ID</label>
                                        <input type="text" class="form-control" name="salonId" id="salonId" readonly value="${salon.salonId}">
                                    </div>

                                    <div class="mb-3">
                                        <label for="capacidad" class="form-label text-light">Capacidad</label>
                                        <input type="number" class="form-control" name="capacidad" id="capacidad" required value="${salon.capacidad}">
                                    </div>
                                    <div class="mb-3">
                                        <label for="descripcion" class="form-label text-light">Descripcion</label>
                                        <input type="text" class="form-control" name="descripcion" id="descripcion" required value="${salon.descripcion}">
                                    </div>
                                    <div class="mb-3">
                                        <label for="nombreSalon" class="form-label text-light">Nombre Salon</label>
                                        <input type="text" class="form-control" name="nombreSalon" id="nombreSalon" required value="${salon.nombreSalon}">
                                    </div>
                                    <input type="hidden" name="accion" value="actualizar">

                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal" onclick="location.href = '${pageContext.request.contextPath}/ServletSalonController?accion=listar'">
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
