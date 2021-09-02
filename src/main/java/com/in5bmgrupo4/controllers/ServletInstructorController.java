/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.in5bmgrupo4.controllers;

import com.in5bmgrupo4.models.dao.InstructorDaoImpl;
import com.in5bmgrupo4.models.domain.Instructor;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Gerardo Andree Pérez Cabrera
 * @date 28/08/2021
 * @time 04:40:12 PM
 */
@WebServlet("/ServletInstructorController")

public class ServletInstructorController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String accion = request.getParameter("accion");

        if (accion != null) {
            switch (accion) {
                case "listar":
                    listarInstructores(request, response);
                    break;

                case "encontrar":
                    break;

                case "insertar":
                    break;

                case "actualizar":
                    break;

                case "eliminar":
                    eliminarInstructor(request, response);
                    break;
            }
        }
    }

    private void listarInstructores(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Instructor> listaInstructor = new InstructorDaoImpl().listar();

        HttpSession sesion = request.getSession();
        sesion.setAttribute("listadoInstructor", listaInstructor);
        response.sendRedirect("Instructor/Instructor.jsp");
    }

    private void eliminarInstructor(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int instructorId = Integer.parseInt(request.getParameter("instructorId"));
        Instructor instructor = new Instructor(instructorId);
        int registrosEliminados = new InstructorDaoImpl().eliminar(instructor);
        System.out.println("Cantidad de registros eliminados:" + registrosEliminados);
        listarInstructores(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

    }

}
