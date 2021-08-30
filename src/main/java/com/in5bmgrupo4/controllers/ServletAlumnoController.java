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

   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
       String accion=request.getParameter("accion");
        
        if(accion!=null){
            switch(accion){
                case "listar":
                    listarAlumnos(request, response);
                    break;
                    
                case "encontrar":
                    break;
                    
                case "insertar":
                    break;
                
                case "actualizar":
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
       response.sendRedirect("Alumno.jsp");
   }
   
   private void eliminarAlumnos(HttpServletRequest request, HttpServletResponse response) throws IOException{
       String carne=request.getParameter("carne");
       Alumno alumno=new Alumno(carne);
       int registrosEliminados=new AlumnoDaoImpl().eliminar(alumno);
       System.out.println("Cantidad de registros eliminados: "+registrosEliminados);
       listarAlumnos(request, response);
   }
   
   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response){
       
   }
}
