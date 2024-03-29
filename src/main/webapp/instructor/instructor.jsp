<%-- 
    Document   : Instructor
    Created on : 28/08/2021, 12:36:06 PM
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
        <script src="https://kit.fontawesome.com/a2549c21b3.js" crossorigin="anonymous"></script>

        <title>Instructor</title>
    </head>
    <body>
        <!-- CABECERA -->
        <jsp:include page="/WEB-INF/paginas/comunes/header.jsp" />

        <div id="main-header" class="py-2 bg-light text-light bg-black ">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <h2 class="text-center text-light">
                            Control Instructores  <i class="fas fa-clipboard-list"> </i>
                        </h2>


                    </div>
                </div>
            </div>
        </div>

        <main>
            <!-- Boton Agregar -->

            <section id="actions" class="py-4 mb-4">
                <div class="container">
                    <div class="row">
                        <div class="col-12 col-md-3">
                            <a href="#" class="btn btn-primary btn-block" data-bs-toggle="modal" data-bs-target="#agregarmodal">

                                <i class="fas fa-plus"></i>
                                Agregar Instructor
                            </a>
                        </div>                        
                    </div>
                </div>                
            </section>

            <!-- Modal -->
            <div class="modal fade" id="agregarmodal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">

                        <div class="modal-header bg-dark text-white">
                            <h5 class="modal-title" id="exampleModalLabel">Agregar Instructor</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <form method="POST" action="${pageContext.request.contextPath}/ServletInstructorController" class="was-validated">
                            <div class="modal-body">

                                <div class="form-group">
                                </div>
                                <div class="form-group">
                                    <label for="apellidos">Apellido</label>
                                    <input type="text" class="form-control" name="apellidos" id="apellidos">
                                </div>
                                <div class="form-group">
                                    <label for="nombre">Nombre</label>
                                    <input type="text" class="form-control" name="nombre" id="nombre">
                                </div>
                                <div class="form-group">
                                    <label for="direccion">Direccion</label>
                                    <input type="direccion" class="form-control" name="direccion" id="direccion">
                                </div>
                                <div class="form-group">
                                    <label for="telefono">Telefono</label>
                                    <input type="telefono" class="form-control" name="telefono" id="telefono">
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

            <section id="instructor">
                <div class="container">
                    <div class="row">
                        <div class="col-12 col-md-12 mb-5 pb-5">
                            <div class="card">
                                <div class="card-header bg-black text-light">
                                    <h4 class="text-center">Listado de Instructores</h4>
                                </div>
                            </div>
                            <table class="table table-dark table-hover text-xl-center table-bordered">
                                <thead class ="table bg-black text-light">

                                    <tr>
                                        <th>ID</th>
                                        <th>Apellidos</th>
                                        <th>Nombre</th>
                                        <th>Direccion</th>
                                        <th>Telefono</th>
                                        <th>Editar</th>
                                        <th>Eliminar</th>

                                    </tr>
                                </thead>
                                <tbody id="texto">
                                    <c:forEach var="instructor" items="${listadoInstructor}">
                                        <tr>
                                            <td>${instructor.instructorId}</td>
                                            <td>${instructor.apellidos} </td>
                                            <td>${instructor.nombre}</td>
                                            <td>${instructor.direccion}</td>
                                            <td>${instructor.telefono}</td>
                                            <!-- editar -->
                                            <td>
                                                <a class="btn btn-secondary text-light" href="${pageContext.request.contextPath}/ServletInstructorController?accion=editar&instructorId=${instructor.instructorId}">

                                                    <i class="far fa-edit"></i> Editar
                                                </a>
                                            </td>

                                            <!-- eliminar -->
                                            <td> 
                                                <a  class="btn btn-danger"href="${pageContext.request.contextPath}/ServletInstructorController?accion=eliminar&instructorId=${instructor.instructorId}">
                                                    <i class="far fa-trash-alt"></i>Eliminar

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
        <jsp:include page="/WEB-INF/paginas/comunes/footer.jsp" />
        <script src="../assets/js/jquery-3.6.0.js"></script>
        <script src="../assets/js/bootstrap.bundle.js"></script> 
    </body>
</html>
