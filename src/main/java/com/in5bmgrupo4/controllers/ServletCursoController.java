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

/**
 *
 * @author Gerardo Andree Pérez Cabrera
 * @date 28/08/2021
 * @time 04:39:30 PM
 */
@WebServlet("/ServletCursoController")
public class ServletCursoController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String accion = request.getParameter("accion");

        if (accion != null) {
            switch (accion) {
                case "listar":
                    listarCurso(request, response);
                    break;

                case "encontrar":
                    break;

                case "insertar":
                    break;

                case "actualizar":
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
        response.sendRedirect("curso/curso.jsp");
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
        
        }
    }
    


