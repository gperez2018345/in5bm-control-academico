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
import javax.persistence.Id;
import javax.servlet.ServletException;
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
    
    private final String JSP_INSTRUCTOR="instructor/instructor.jsp";
    private final String JSP_EDITAR_INSTRUCTOR="instructor/editar-instructor.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        request.setCharacterEncoding("UTF-8");
        System.out.println("entrando a do get");
        String accion = request.getParameter("accion");

        if (accion != null) {
            switch (accion) {
                case "listar":
                    listarInstructores(request, response);
                    break;
                case "editar":
                    encontrarInstructor(request, response);
                    break;
                case "eliminar":
                    eliminarInstructor(request, response);
                    break;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        System.out.println("entrando a do Post");
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    insertarInstructores(request, response);
                    break;
                case "actualizar":
                    actualizarInstructor(request, response);
                    break;
            }
        }
    }
    
    private void listarInstructores(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Instructor> listaInstructor = new InstructorDaoImpl().listar();

        HttpSession sesion = request.getSession();
        sesion.setAttribute("listadoInstructor", listaInstructor);
        response.sendRedirect(JSP_INSTRUCTOR);
    }

    private void eliminarInstructor(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int instructorId = Integer.parseInt(request.getParameter("instructorId"));
        Instructor instructor = new Instructor(instructorId);
        int registrosEliminados = new InstructorDaoImpl().eliminar(instructor);
        System.out.println("Cantidad de registros eliminados:" + registrosEliminados);
        listarInstructores(request, response);
    }

    

    private void insertarInstructores(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("entrando a insertar a instructores");
        String apellidos = request.getParameter("apellidos");
        String nombre = request.getParameter("nombre");
        String direccion = request.getParameter("direccion");
        String telefono = request.getParameter("telefono");
        Instructor instructor = new Instructor(apellidos, nombre, direccion, telefono);
        System.out.println(instructor);
        int registrosAgregados = new InstructorDaoImpl().insertar(instructor);
        System.out.println("Cantidad de registros agregados: " + registrosAgregados);
        listarInstructores(request, response);
    }
    
    private void encontrarInstructor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        System.out.println("entrando a encontrar instructor");
        int instructorId=Integer.parseInt(request.getParameter("instructorId"));
        Instructor instructor=new InstructorDaoImpl().encontrar(new Instructor(instructorId));
        request.setAttribute("instructor", instructor);
        request.getRequestDispatcher(JSP_EDITAR_INSTRUCTOR).forward(request, response);
        System.out.println(instructor);
    }
        
    private void actualizarInstructor(HttpServletRequest request, HttpServletResponse response) throws IOException{
        System.out.println("entrando a actualizar instructor");
        int instructorId=Integer.parseInt(request.getParameter("instructorId"));
        String apellidos=request.getParameter("apellidos");
        String nombre=request.getParameter("nombre");
        String direccion=request.getParameter("direccion");
        String telefono=request.getParameter("telefono");
        Instructor instructor=new Instructor(instructorId, apellidos, nombre, direccion, telefono);
        System.out.println(instructor);
        int registrosActualizados=new InstructorDaoImpl().actualizar(instructor);
        System.out.println("Cantidad de registros actualizados: " + registrosActualizados);
        listarInstructores(request, response);
    }

}
