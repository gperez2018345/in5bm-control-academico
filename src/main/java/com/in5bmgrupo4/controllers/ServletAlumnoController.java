/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.in5bmgrupo4.controllers;

import com.in5bmgrupo4.models.dao.AlumnoDaoImpl;
import com.in5bmgrupo4.models.domain.Alumno;
import java.io.IOException;
import java.util.List;
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
 * @time 04:36:31 PM
 */
@WebServlet("/ServletAlumnoController")
public class ServletAlumnoController extends HttpServlet {
    
    private final String JSP_ALUMNO="alumno/alumno.jsp";
    private final String JSP_EDITAR_ALUMNO="alumno/editar-alumno.jsp";

   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
       request.setCharacterEncoding("UTF-8");
       String accion=request.getParameter("accion");
       System.out.println("entrando a do get");
        
        if(accion!=null){
            switch(accion){
                case "listar":
                    listarAlumnos(request, response);
                    break;
                    
                case "editar":
                    encontrarAlumnos(request, response);
                    break;
        
                case "eliminar":
                    eliminarAlumnos(request, response);
                    break;
            }
        }
   }
   
   private void listarAlumnos(HttpServletRequest request, HttpServletResponse response) throws IOException{
       List<Alumno> listaAlumnos= new AlumnoDaoImpl().listar();
       
       HttpSession sesion=request.getSession();
       sesion.setAttribute("listadoAlumno", listaAlumnos );
       response.sendRedirect(JSP_ALUMNO);
   }
   
   private void eliminarAlumnos(HttpServletRequest request, HttpServletResponse response) throws IOException{
       String carne=request.getParameter("carne");
       Alumno alumno=new Alumno(carne);
       int registrosEliminados=new AlumnoDaoImpl().eliminar(alumno);
       System.out.println("Cantidad de registros eliminados: "+registrosEliminados);
       listarAlumnos(request, response);
   }
   
   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
       request.setCharacterEncoding("UTF-8");
       System.out.println("entrando a do Post");
       String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    insertarAlumnos(request, response);
                    break;
                    
                case "actualizar":
                    actualizarAlumnos(request, response);
                    break;
            }
        }
   }
   
    private void insertarAlumnos(HttpServletRequest request, HttpServletResponse response)throws IOException{
        System.out.println("entrando a insertar alumno");
        String carne=request.getParameter("carne");
        String apellidos=request.getParameter("apellidos");
        String nombres=request.getParameter("nombres");
        String email=request.getParameter("email");
        Alumno alumno=new Alumno(carne, apellidos, nombres, email);
        System.out.println(alumno);
        int registrosAgregados=new AlumnoDaoImpl().insertar(alumno);
        System.out.println("Cantidad de registros agregados: " + registrosAgregados);
        listarAlumnos(request, response);
    }
    
    private void encontrarAlumnos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        System.out.println("entrando a encontrar alumno");
        String carne=request.getParameter("carne");
        Alumno alumno=new AlumnoDaoImpl().encontrar(new Alumno(carne));
        request.setAttribute("alumno", alumno);
        request.getRequestDispatcher(JSP_EDITAR_ALUMNO).forward(request, response);
        System.out.println(alumno);
    }
    
    private void actualizarAlumnos(HttpServletRequest request, HttpServletResponse response) throws IOException{
        System.out.println("entrando a actualizar alumno");
        String carne=request.getParameter("carne");
        String apellidos=request.getParameter("apellidos");
        String nombres=request.getParameter("nombres");
        String email=request.getParameter("email");
        Alumno alumno=new Alumno(carne, apellidos, nombres, email);
        System.out.println(alumno);
        int registrosActualizados=new AlumnoDaoImpl().actualizar(alumno);
        System.out.println("Cantidad de registros actualizados: " + registrosActualizados);
        listarAlumnos(request, response);
    }
   
}
