<%-- 
    Document   : CarreraTecnica.jsp
    Created on : 28/08/2021, 12:35:28 PM
    Author     : gerar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Carrera Tecnica</title>
    </head>
    <body>
        <h1>Lista de Carreras Tecnicas</h1>
        
        <table border="2">
            <thead> 
                <tr>
                    <th>Codigo Carrera</th>
                    <th>Nombre</th>
                    <th> </th>
                </tr>
            </thead> 
            <tbody>
                
                <c:forEach var="carreraTecnica" items="${listadoCarreraTecnica}">
                    <tr>
                        <td>${carreraTecnica.codigoCarrera}</td>
                        <td>${carreraTecnica.nombre}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/ServletCarreraTecnicaController?accion=eliminar&codigoCarrera=${carreraTecnica.codigoCarrera}">Eliminar</a>
                        </td>
                    </tr>
                </c:forEach>
                
            </tbody>
        </table>
        
    </body>
</html>
