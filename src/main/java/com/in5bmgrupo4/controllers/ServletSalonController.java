/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.in5bmgrupo4.controllers;

import com.in5bmgrupo4.models.dao.SalonDaoImpl;
import com.in5bmgrupo4.models.domain.Salon;
import java.io.IOException;
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
 * @time 04:41:28 PM
 */
@WebServlet("/ServletSalonController")
public class ServletSalonController extends HttpServlet {

    private final String JSP_EDITAR_SALON = "salon/editar-salon.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("entrando a do get");
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "listar":
                    listarSalon(request, response);
                    break;
                case "editar":
                    encontrarSalon(request, response);
                    break;
                case "eliminar":
                    eliminarSalon(request, response);
                    break;
            }
        }
    }

    private void listarSalon(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Salon> listaSalon = new SalonDaoImpl().listar();
        HttpSession sesion = request.getSession();
        sesion.setAttribute("listadoSalon", listaSalon);
        response.sendRedirect("salon/salon.jsp");
    }

    private void eliminarSalon(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int salonId = Integer.parseInt(request.getParameter("salonId"));
        Salon salones = new Salon(salonId);
        int registrosEliminados = new SalonDaoImpl().eliminar(salones);
        System.out.println("Cantidad de registros eliminados:" + registrosEliminados);
        listarSalon(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("entrando a do Post");
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    insertarSalones(request, response);
                    break;
                case "actualizar":
                    actualizarAlumnos(request, response);
                    break;
            }
        }
    }

    private void insertarSalones(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("entrando a insertar salon");
        String nombreSalon = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");
        String capacidadStr = request.getParameter("capacidad");
        int capacidad = 0;
        if ((capacidadStr != null) && (!capacidadStr.equals(""))) {
            capacidad = Integer.parseInt(request.getParameter("capacidad"));
        }
        Salon salon = new Salon(capacidad, descripcion, nombreSalon);
        System.out.println(salon);
        int registrosAgregados = new SalonDaoImpl().insertar(salon);
        System.out.println("Cantidad de registros agregados: " + registrosAgregados);
        listarSalon(request, response);
    }

    private void encontrarSalon(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Entrando a encontrar salon");
        int salonId = Integer.parseInt(request.getParameter("salonId"));
        Salon salon = new SalonDaoImpl().encontrar(new Salon(salonId));
        request.setAttribute("salon", salon);
        request.getRequestDispatcher(JSP_EDITAR_SALON).forward(request, response);
        System.out.println(salon);

    }

    private void actualizarAlumnos(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("entrando a actualizar salon");
        int salonId = Integer.parseInt(request.getParameter("salonId"));
        int capacidad = Integer.parseInt(request.getParameter("capacidad"));
        String descripcion = request.getParameter("descripcion");
        String nombreSalon = request.getParameter("nombreSalon");
        Salon salon = new Salon(salonId, capacidad, descripcion, nombreSalon);
        System.out.println(salon);
        int registrosActualizados = new SalonDaoImpl().actualizar(salon);
        System.out.println("Cantidad de registros modificados" + registrosActualizados);
        listarSalon(request, response);
    }
}
