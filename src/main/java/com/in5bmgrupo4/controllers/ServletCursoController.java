/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.in5bmgrupo4.controllers;

import com.in5bmgrupo4.models.dao.CursoDaoImpl;
import com.in5bmgrupo4.models.domain.Curso;
import java.io.IOException;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;

/**
 *
 * @author Gerardo Andree Pérez Cabrera
 * @date 28/08/2021
 * @time 04:39:30 PM
 */
@WebServlet("/ServletCursoController")
public class ServletCursoController extends HttpServlet {

    private final String JSP_CURSO = "curso/curso.jsp";
    private final String JSP_EDITAR_CURSO = "curso/editar-curso.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String accion = request.getParameter("accion");

        if (accion != null) {
            switch (accion) {
                case "listar":
                    listarCurso(request, response);
                    break;

                case "editar":
                    encontrarCurso(request, response);
                    break;

                case "eliminar":
                    eliminarCurso(request, response);
                    break;
            }
        }
    }

    private void listarCurso(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Curso> listarCurso = new CursoDaoImpl().listar();
        HttpSession sesion = request.getSession();
        sesion.setAttribute("listadoCurso", listarCurso);
        response.sendRedirect(JSP_CURSO);
    }

    private void eliminarCurso(HttpServletRequest request, HttpServletResponse response) throws IOException {

        int cursoId = Integer.parseInt(request.getParameter("cursoId"));
        Curso curso = new Curso(cursoId);
        int registrosEliminados = new CursoDaoImpl().eliminar(curso);
        System.out.println("Cantidad de registros eliminados: " + registrosEliminados);
        listarCurso(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        System.out.println("entrando a do Post");
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    insertarCurso(request, response);
                    break;

                case "actualizar":
                    actualizarAlumnos(request, response);
                    break;
            }
        }
    }

    private void insertarCurso(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("entrando a insertar curso");
        int ciclo = Integer.parseInt(request.getParameter("ciclo"));
        int cupoMaximo = Integer.parseInt(request.getParameter("cupoMaximo"));
        int cupoMinimo = Integer.parseInt(request.getParameter("cupoMinimo"));
        String descripcion = request.getParameter("descripcion");
        String codigoCarrera = request.getParameter("codigoCarrera");
        int horarioId = Integer.parseInt(request.getParameter("horarioId"));
        int instructorId = Integer.parseInt(request.getParameter("instructorId"));
        int salonId = Integer.parseInt(request.getParameter("salonId"));

        Curso curso = new Curso(ciclo, cupoMaximo, cupoMinimo, descripcion, codigoCarrera, horarioId, instructorId, salonId);
        System.out.println(curso);
        int registrosAgregados = new CursoDaoImpl().insertar(curso);
        System.out.println("Cantidad de registros agregados: " + registrosAgregados);
        listarCurso(request, response);
    }

    private void encontrarCurso(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("entrando a encontrar curso");
        int cursoId = Integer.parseInt(request.getParameter("cursoId"));
        Curso curso = new CursoDaoImpl().encontrar(new Curso(cursoId));
        request.setAttribute("curso", curso);
        request.getRequestDispatcher(JSP_EDITAR_CURSO).forward(request, response);
        System.out.println(curso);
    }

    private void actualizarAlumnos(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("entrando a actualizar curso");
        int cursoId = Integer.parseInt(request.getParameter("cursoId"));
        int ciclo = Integer.parseInt(request.getParameter("ciclo"));
        int cupoMaximo = Integer.parseInt(request.getParameter("cupoMaximo"));
        int cupoMinimo = Integer.parseInt(request.getParameter("cupoMinimo"));
        String descripcion = request.getParameter("descripcion");
        String codigoCarrera = request.getParameter("codigoCarrera");
        int horarioId = Integer.parseInt(request.getParameter("horarioId"));
        int instructorId = Integer.parseInt(request.getParameter("instructorId"));
        int salonId = Integer.parseInt(request.getParameter("salonId"));

        Curso curso = new Curso(cursoId, ciclo, cupoMaximo, cupoMinimo, descripcion, codigoCarrera, horarioId, instructorId, salonId);
        System.out.println(curso);
        int registrosActualizados = new CursoDaoImpl().actualizar(curso);
        System.out.println("Cantidad de registros actualizados: " + registrosActualizados);
        listarCurso(request, response);
    }

}
