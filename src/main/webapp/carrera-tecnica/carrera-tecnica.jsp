<%-- 
    Document   : CarreraTecnica.jsp
    Created on : 28/08/2021, 12:35:28 PM
    Author     : gerar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="../assets/css/styleIdentidad.css">
        <link rel="stylesheet" href="../assets/css/bootstrap.css">
        <link rel="stylesheet" href="../assets/css/style.css">
        <script src="https://kit.fontawesome.com/611b0a953c.js" crossorigin="anonymous"></script>

        <title>Carrera Técnica</title>

    </head>
    <body>

        <!-- CABECERA -->
        <jsp:include page="/WEB-INF/paginas/comunes/header.jsp" />


        <div id="main-header" class="py-2 bg-light text-light bg-black ">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <h2 class="text-center text-light">
                            Carreras Técnicas  <i class="fas fa-user-graduate"></i>
                        </h2>
                    </div>
                </div>
            </div>
        </div>

        <main>

            <!-- Boton para Agregar --->

            <section id="actions" class="py-4 mb-4">
                <div class="container">
                    <div class="row">
                        <div class="col-12 col-md-3">
                            <a href="#" class="btn btn-primary btn-block" data-bs-toggle="modal" data-bs-target="#agregarmodal">
                                <i class="fas fa-plus"></i>
                                Agregar Carrera Técnica
                            </a>
                        </div>                        
                    </div>
                </div>                
            </section>

            <!--- Modal (formulario para agregar) --->
            <div class="modal fade" id="agregarmodal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">

                        <div class="modal-header bg-dark text-white">
                            <h5 class="modal-title" id="exampleModalLabel">Agregar Carrera</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>

                        <form method="POST" action="${pageContext.request.contextPath}/ServletCarreraTecnicaController" class="was-validated">
                            <div class="modal-body">

                                <div class="mb-3">
                                    <label for="codigoCarrera">Codigo Carrera</label>
                                    <input type="text" class="form-control" name="codigoCarrera" id="codigoCarrera" required>
                                </div>
                                
                                <div class="mb-3">
                                    <label for="nombre">Nombre</label>
                                    <input type="text" class="form-control" name="nombre" id="nombre" required>
                                </div>

                                <input type="hidden" name="accion" value="insertar">

                            </div>

                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                                <button type="submit" class="btn btn-success">Guardar </button>
                            </div>
                        </form>

                    </div>
                </div>
            </div>

            <section id="alumno">
                <div class="container">
                    <div class="row">
                        <div class="col-12 col-md-12 mb-5 pb-5">
                            <div class="card">
                                <div class="card-header bg-black text-light">
                                    <h4 class="text-center">Listado Carrera Tecnica</h4>
                                </div>
                            </div>
                            <table class="table table-dark table-hover text-xl-center table-bordered">
                                <thead class ="table bg-black text-light">

                                    <tr>
                                        <th>Codigo de Carrera</th>
                                        <th>Nombre</th>
                                        <th>Editar</th>
                                        <th>Elimnar</th>
                                    </tr>

                                </thead>
                                <tbody id="texto">
                                    <c:forEach var="carreraTecnica" items="${listadoCarreraTecnica}">
                                        <tr>
                                            <td>${carreraTecnica.codigoCarrera}</td>
                                            <td>${carreraTecnica.nombre}</td>

                                            <td> <!---Editar--->
                                                <a class="btn btn-secondary text-light" href="${pageContext.request.contextPath}/ServletCarreraTecnicaController?accion=editar&codigoCarrera=${carreraTecnica.codigoCarrera}">
                                                    <i class="fas fa-edit"></i>Editar
                                                </a>
                                            </td>
                                            <td><!---Eliminar--->
                                                <a  class="btn btn-danger" href="${pageContext.request.contextPath}/ServletCarreraTecnicaController?accion=eliminar&codigoCarrera=${carreraTecnica.codigoCarrera}">
                                                    <i class="fas fa-trash"></i>Eliminar
                                                </a>
                                            </td>

                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>  
                    </div>
                </div>
            </section>
        </main>

        <!-- Javascript -->
        <jsp:include page="/WEB-INF/paginas/comunes/footer.jsp" />
        <script src="../assets/js/jquery-3.6.0.js"></script>
        <script src="../assets/js/bootstrap.bundle.js"></script> 

    </body>
</html>
