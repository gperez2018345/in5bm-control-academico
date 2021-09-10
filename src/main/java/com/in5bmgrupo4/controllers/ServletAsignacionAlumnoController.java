/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.in5bmgrupo4.controllers;

import com.in5bmgrupo4.models.dao.AsignacionAlumnoDaoImpl;
import com.in5bmgrupo4.models.domain.AsignacionAlumno;
import java.io.IOException;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Gerardo Andree Pérez Cabrera
 * @date 28/08/2021
 * @time 04:37:00 PM
 */
@WebServlet("/ServletAsignacionAlumnoController")
public class ServletAsignacionAlumnoController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String accion = request.getParameter("accion");

        if (accion != null) {
            switch (accion) {
                case "listar":
                    listarAsignacionAlumno(request, response);
                    break;

                case "encontrar":
                    break;

                case "insertar":
                    break;

                case "actualizar":
                    break;

                case "eliminar":
                    eliminarAsignacionAlumno(request, response);
                    break;
            }
        }
    }

    private void listarAsignacionAlumno(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<AsignacionAlumno> listarAsignacionAlumno = new AsignacionAlumnoDaoImpl().listar();
        HttpSession sesion = request.getSession();
        sesion.setAttribute("listadoAsignacionAlumno", listarAsignacionAlumno);
        response.sendRedirect("AsignacionAlumno/AsignacionAlumno.jsp");
    }

    private void eliminarAsignacionAlumno(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String asignacionId = request.getParameter("asignacionId");
        AsignacionAlumno asignacionAlumno = new AsignacionAlumno(asignacionId);
        int registrosEliminados = new AsignacionAlumnoDaoImpl().eliminar(asignacionAlumno);
        System.out.println("Cantidad de registros eliminados: " + registrosEliminados);
        listarAsignacionAlumno(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

    }
    
}
