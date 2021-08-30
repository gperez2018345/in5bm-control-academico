<%-- 
    Document   : Salon
    Created on : 28/08/2021, 12:32:02 PM
    Author     : gerar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado Salon</title>
    </head>
    <body>
        <h1>Lista Salon</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>#</th>
                    <th>capacidad</th>
                    <th>descripcion</th>
                    <th>nombre Salon</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="salon" items="${listadoSalon}">
                <tr>
                    <td>${salon.salonId}</td>
                    <td>${salon.capacidad}</td>
                    <td>${salon.descripcion}</td>
                    <td>${salon.nombreSalon}</td>
                    <td> 
                        <a href="${pageContext.request.contextPath}/ServletSalonController?accion=eliminar&salonId=${salon.salonId}">Eliminar</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
