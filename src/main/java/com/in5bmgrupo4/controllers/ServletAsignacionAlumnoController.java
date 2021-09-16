/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.in5bmgrupo4.controllers;

import com.in5bmgrupo4.models.dao.AsignacionAlumnoDaoImpl;
import com.in5bmgrupo4.models.domain.AsignacionAlumno;
import java.io.IOException;
import java.sql.Date;
import java.util.List;
import javax.servlet.ServletException;
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
public class ServletAsignacionAlumnoController extends HttpServlet {

    private final String JSP_ASIGNACIONALUMNO = "asignacion-alumno/asignacion-alumno.jsp";
    private final String JSP_EDITAR_ASIGNACIONALUMNO = "asignacion-alumno/editar-asignacion-alumno.jsp";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        System.out.println("entrando a do Post");
        String accion = request.getParameter("accion");

        if (accion != null) {
            switch (accion) {
                case "insertar":
                    insertarAsignacionAlumno(request, response);
                    break;

                case "actualizar":
                    actualizarAsignacionAlumno(request, response);
                    break;
            }
        }
    }

    private void insertarAsignacionAlumno(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String asignacionId = request.getParameter("asignacionId");
        String carne = request.getParameter("carne");
        int cursoId = Integer.parseInt(request.getParameter("cursoId"));
        Date fechaAsignacion = Date.valueOf(request.getParameter("fechaAsignacion"));

        AsignacionAlumno asignacionAlumno = new AsignacionAlumno(asignacionId, carne, cursoId, fechaAsignacion);

        int registrosInsertados = new AsignacionAlumnoDaoImpl().insertar(asignacionAlumno);
        System.out.println("Registros insertados: " + registrosInsertados);

        listarAsignacionAlumno(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        request.setCharacterEncoding("UTF-8");
        String accion = request.getParameter("accion");
        System.out.println("entrando a do get");

        if (accion != null) {
            switch (accion) {
                case "listar":
                    listarAsignacionAlumno(request, response);
                    break;

                case "editar":
                    encontrarAsignacionAlumno(request, response);
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
        response.sendRedirect(JSP_ASIGNACIONALUMNO);
    }

    private void eliminarAsignacionAlumno(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String asignacionId = request.getParameter("asignacionId");
        AsignacionAlumno asignacionAlumno = new AsignacionAlumno(asignacionId);
        int registrosEliminados = new AsignacionAlumnoDaoImpl().eliminar(asignacionAlumno);
        System.out.println("Cantidad de registros eliminados: " + registrosEliminados);
        listarAsignacionAlumno(request, response);

    }
    
    private void encontrarAsignacionAlumno(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        System.out.println("entrando a encontrar asignacionAlumno");
        String asignacionId = request.getParameter("asignacionId");
        AsignacionAlumno asignacionAlumno = new AsignacionAlumnoDaoImpl().encontrar(new AsignacionAlumno(asignacionId));
        request.setAttribute("asignacionAlumno", asignacionAlumno);
        request.getRequestDispatcher(JSP_EDITAR_ASIGNACIONALUMNO).forward(request, response);
        System.out.println(asignacionAlumno);
    }
    
    private void actualizarAsignacionAlumno(HttpServletRequest request, HttpServletResponse response) throws IOException{
        System.out.println("entrando a actualizar asignacionAlumno");
        String asignacionId = request.getParameter("asignacionId");
        String carne = request.getParameter("carne");
        int cursoId = Integer.parseInt(request.getParameter("cursoId"));
        Date fechaAsignacion = Date.valueOf(request.getParameter("fechaAsignacion"));
        AsignacionAlumno asignacionAlumno=new AsignacionAlumno(asignacionId, carne, cursoId, fechaAsignacion);
        System.out.println(asignacionAlumno);
        int registrosActualizados=new AsignacionAlumnoDaoImpl().actualizar(asignacionAlumno);
        System.out.println("Cantidad de registros actualizados: " + registrosActualizados);
        listarAsignacionAlumno(request, response);
    }
    
}
