/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.in5bmgrupo4.controllers;

import com.in5bmgrupo4.models.dao.CarreraTecnicaDaoImpl;
import com.in5bmgrupo4.models.domain.CarreraTecnica;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;

/**
 *
 * @author Gerardo Andree Pérez Cabrera
 * @date 28/08/2021
 * @time 04:38:49 PM
 */
@WebServlet("/ServletCarreraTecnicaController")
public class ServletCarreraTecnicaController extends HttpServlet {

    private final String JSP_EDITAR_CARRERA = "carrera-tecnica/editar-carrera-tecnica.jsp";
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
      request.setCharacterEncoding("UTF-8");
        
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    insertarCarrerasTecnicas(request, response);
                    break;
                case "actualizar":    
                    actualizarCarrerasTecnicas(request, response);
                    break;
            }
        }
    }

////////////////////////////////////////////////////////////////////////////////
    
    private void insertarCarrerasTecnicas(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String codigoCarrera = request.getParameter("codigoCarrera");
        String nombre = request.getParameter("nombre");

        CarreraTecnica carrera = new CarreraTecnica(codigoCarrera, nombre);
        int registrosAgregados = new CarreraTecnicaDaoImpl().insertar(carrera);

        listarCarrerasTecnicas(request, response);
    }
    
////////    
        
    private void actualizarCarrerasTecnicas(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String codigo = request.getParameter("codigoCarrera");
        String nombre = request.getParameter("nombre");
        
        CarreraTecnica carreraTecnica = new CarreraTecnica(codigo, nombre);
        int registrosActualizados = new CarreraTecnicaDaoImpl().actualizar(carreraTecnica);
        listarCarrerasTecnicas(request, response);
    }
    
//////////////////////////////////////////////////////////////////////////////////////////////    
//////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        request.setCharacterEncoding("UTF-8");
        String accion = request.getParameter("accion");

        if (accion != null) {
            switch (accion) {
                case "listar":
                    listarCarrerasTecnicas(request, response);
                    break;
                case "editar":
                    encontrarCarrerasTecnicas(request, response);
                    break;
                case "eliminar":
                    eliminarCarrerasTecnicas(request, response);
                    break;
            }
        }
    }
////////////////////////////////////////////////////////////////////////////////    

    private void listarCarrerasTecnicas(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<CarreraTecnica> listaCarreras = new CarreraTecnicaDaoImpl().listar();

        HttpSession sesion = request.getSession();
        sesion.setAttribute("listadoCarreraTecnica", listaCarreras);

        response.sendRedirect("carrera-tecnica/carrera-tecnica.jsp");
    }
    
////////
    
    private void eliminarCarrerasTecnicas(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String codigo = request.getParameter("codigoCarrera");
        CarreraTecnica carreraTecnica = new CarreraTecnica(codigo);
        int registrosEliminados = new CarreraTecnicaDaoImpl().eliminar(carreraTecnica);
        listarCarrerasTecnicas(request, response);
    }
    
////////   
    
    private void encontrarCarrerasTecnicas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
       System.out.println("entrando a encontrar una carrera:"); 
        String codigo = request.getParameter("codigoCarrera");
        CarreraTecnica carreraTecnica = new CarreraTecnicaDaoImpl().encontrar(new CarreraTecnica(codigo));
        request.setAttribute("carreraTecnica", carreraTecnica);
        request.getRequestDispatcher(JSP_EDITAR_CARRERA).forward(request, response);
        System.out.println("hay datos?" + carreraTecnica);
    }
    
////////////////////////////////////////////////////////////////////////////////
}
