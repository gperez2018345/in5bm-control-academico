<%-- 
    Document   : Horario
    Created on : 28/08/2021, 12:29:57 PM
    Author     : gerar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                  <link rel="stylesheet" href="../assets/css/bootstrap.css">
        <title>Horario</title>
    </head>
    <body>
        <h1>Listado de Horarios</h1>
              
        <table  class="table table-striped table-bordered">
            <thead class ="table-dark"> 
                <tr>
                    <th>ID</th>
                    <th>Horario final</th>
                    <th>Horario Inicio</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="horario" items="${listadoHorario}">
                    <tr>
                        <td>${horario.horarioId}</td>
                        <td>${horario.horarioFinal} </td>
                        <td>${horario.horarioInicio}</td>
                        <td>
                            <a  class="btn btn-danger"href="${pageContext.request.contextPath}/ServletHorarioController?accion=eliminar&horarioId=${horario.horarioId}">Eliminar</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
