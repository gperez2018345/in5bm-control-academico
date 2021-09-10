<%-- 
    Document   : Curso
    Created on : 28/08/2021, 12:36:18 PM
    Author     : gerar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

        <title>Curso</title>
    </head>
    <body>
        <jsp:include page="/WEB-INF/paginas/comunes/header.jsp" />
        <div id="main-header" class="py-2 bg-light text-light bg-black ">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <h2 class="text-center text-light">Control Cursos <i class="fas fa-clipboard-list"> </i></h2>
                    </div>
                </div>
            </div>
        </div>

        <main>

            <section id="actions" class="py-4 mb-4">
                <div class="container">
                    <div class="row">
                        <div class="col-12 col-md-3">
                            <a href="#" class="btn btn-primary btn-block" data-bs-toggle="modal" data-bs-target="#agregarmodal">

                                <i class="fas fa-plus"></i>
                                Agregar Curso
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
                            <h5 class="modal-title" id="exampleModalLabel">Agregar Curso</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <form method="POST" action="${pageContext.request.contextPath}/ServletCursoController" class="was-validated">
                            <div class="modal-body">

                                <div class="form-group">
                                    <label for="ciclo">Ciclo</label>
                                    <input type="number" class="form-control" name="ciclo" id="ciclo" required>
                                </div>
                                <div class="form-group">
                                    <label for="cupoMaximo">Cupo Maximo</label>
                                    <input type="number" class="form-control" name="cupoMaximo" id="cupoMaximo" required>
                                </div>
                                <div class="form-group">
                                    <label for="cupoMinimo">Cupo Minimo</label>
                                    <input type="number" class="form-control" name="cupoMinimo" id="cupoMinimo" required>
                                </div>
                                <div class="form-group">
                                    <label for="descripcion">Descripcion</label>
                                    <input type="text" class="form-control" name="descripcion" id="descripcion" required>
                                </div>
                                <div class="form-group">
                                    <label for="codigoCarrera">Codigo Carrera</label>
                                    <input type="number" class="form-control" name="codigoCarrera" id="codigoCarrera" required>
                                </div>
                                <div class="form-group">
                                    <label for="horarioId">Id Horario</label>
                                    <input type="number" class="form-control" name="horarioId" id="horarioId" required>
                                </div>
                                <div class="form-group">
                                    <label for="instructorId">Id Instructor</label>
                                    <input type="number" class="form-control" name="instructorId" id="instructorId" required>
                                </div>
                                <div class="form-group">
                                    <label for="salonId">Id salon</label>
                                    <input type="number" class="form-control" name="salonId" id="salonId" required>
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

            <section id="curso">
                <div class="container">
                    <div class="row">
                        <div class="col-12 col-md-12 mb-5 pb-5">
                            <div class="card">
                                <div class="card-header bg-black text-light">
                                    <h4 class="text-center">Listado de Cursos</h4>
                                </div>
                            </div>
                            <table class="table table-dark table-hover text-xl-center table-bordered">
                                <thead class ="table bg-black text-light">
                                    <tr>
                                        <th>ID</th>
                                        <th>Ciclo</th>
                                        <th>Cupo Maximo</th>
                                        <th>Cupo Minimo</th>
                                        <th>Descripcion</th>
                                        <th>Codigo Carrera</th>
                                        <th>ID Horario</th>
                                        <th>ID Instructor</th>
                                        <th>ID Salon</th>
                                        <th>Editar</th>
                                        <th>Eliminar</th>
                                    </tr>
                                </thead>
                                <tbody id="texto">
                                    <c:forEach var="curso" items="${listadoCurso}">
                                        <tr>
                                            <td>${curso.cursoId}</td>
                                            <td>${curso.ciclo}</td>
                                            <td>${curso.cupoMaximo}</td>
                                            <td>${curso.cupoMinimo}</td>
                                            <td>${curso.descripcion}</td>
                                            <td>${curso.codigoCarrera}</td>
                                            <td>${curso.horarioId}</td>
                                            <td>${curso.instructorId}</td>
                                            <td>${curso.salonId}</td>
                                            <td>
                                                <a class="btn btn-secondary text-light" href="${pageContext.request.contextPath}/ServletAlumnoController?accion=editar&cursoId=${curso.cursoId}">
                                                    <i class="far fa-edit"></i> Editar
                                                </a>
                                            </td>
                                            <td>
                                                <a class="btn btn-danger" href="${pageContext.request.contextPath}/ServletCursoController?accion=eliminar&cursoId=${curso.cursoId}">
                                                    <i class="far fa-trash-alt"></i>Eliminar
                                                </a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
            </section>
        </main>
        <jsp:include page="/WEB-INF/paginas/comunes/footer.jsp" />
        <script src="../assets/js/jquery-3.6.0.js"></script>
        <script src="../assets/js/bootstrap.bundle.js"></script> 
    </body>
</html>
