<%-- 
    Document   : Instructor
    Created on : 28/08/2021, 12:36:06 PM
    Author     : gerar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>  
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../assets/css/bootstrap.css">
        <title>Instructor</title>
    </head>
    <body>
        <h1>Listado de Instructores</h1>
                
        <table  class="table table-striped table-bordered">
            <thead class ="table-dark"> 
                <tr>
                    <th>ID</th>
                    <th>Apellidos</th>
                    <th>Nombres</th>
                    <th>Direccion</th>
                    <th>Telefono</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="instructor" items="${listadoInstructor}">
                    <tr>
                        <td>${instructor.instructorId}</td>
                        <td>${instructor.apellidos} </td>
                        <td>${instructor.nombres}</td>
                        <td>${instructor.direccion}</td>
                        <td>${instructor.telefono}</td>
                        <td>
                            <a  class="btn btn-danger"href="${pageContext.request.contextPath}/ServletInstructorController?accion=eliminar&instructorId=${instructor.instructorId}">Eliminar</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
