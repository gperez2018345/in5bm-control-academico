<%-- 
    Document   : login
    Created on : 15/09/2021, 03:42:25 PM
    Author     : Diego Oswaldo Flores Rivas <dflores-2020010@kinal.edu.gt>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="./assets/css/bootstrap.css">
        <link rel="stylesheet" href="./assets/css/styleIdentidad.css">
        <link rel="stylesheet" href="./assets/css/style.css"> 
        <script src="https://kit.fontawesome.com/b54b4661b2.js" crossorigin="anonymous"></script>
        <title>FUNDACION KINAL</title>
    </head>
    <body>
        <header id="encabezado">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <h1 class="text-center text-light">Control Academico</h1>
                    </div>
                </div>
            </div>
        </header>
        <main>  
            <section>
                <div class="container mt-5">
                    <div class="row d-flex justify-content-center">
                        <div class="col-12 col-md-6">
                            <div class="card bg-black mt-5">
                                <div class="card-header bg-black text-light">
                                    <h4 class="text-center">Inicio de sesion</h4>
                                </div>
                                <div class="card-body bg-dark">
                                    <div class="text-light text-center">
                                        <i style="font-size: 100px;" class="fa fa-users" aria-hidden="true"></i>
                                    </div>
                                    <form method="POST" action="${pageContext.request.contextPath}/ServletLoginController" class="was-validated">
                                        <div class="mb-3 mt-3">
                                            <label for="user" class="form-label text-light">Usuario <i class='fa fa-user' aria-hidden='true'></i></label>
                                            <input type="text" class="form-control" name="user" id="user" required placeholder="Ingresa tu usuario">
                                        </div>

                                        <div class="mb-5">
                                            <label for="pass" class="form-label text-light">Contraseña <i class="fa fa-unlock-alt" aria-hidden="true"></i></label>
                                            <input type="password" class="form-control" name="pass" id="pass" required placeholder="Ingresa tu contraseña">
                                        </div>

                                        <input type="hidden" name="accion" value="login">

                                        <div class="col-12">
                                            <div class="d-flex justify-content-center">
                                                <button type="submit" class="btn btn-success">Iniciar Sesion <i class="fa fa-sign-in" aria-hidden="true"></i></button>
                                                
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div> 
                        </div>
                    </div>
                </div>
            </section>
        </main>
        <!--Pie de pagina-->
        <jsp:include page="./WEB-INF/paginas/comunes/footer.jsp"/>
        <!--JavaScript-->
        <script src="./assets/js/jquery-3.6.0.js"></script>
        <script src="./assets/js/bootstrap.bundle.js"></script>
    </body>
</html>
