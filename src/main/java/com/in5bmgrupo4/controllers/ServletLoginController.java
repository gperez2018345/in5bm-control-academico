package com.in5bmgrupo4.controllers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import com.in5bmgrupo4.models.dao.LoginDaoImpl;
import com.in5bmgrupo4.models.domain.Login;

/**
 *
 * @author Diego Oswaldo Flores Rivas <dflores-2020010@kinal.edu.gt>
 * @date 15/09/2021
 * @time 12:49:09 PM
 */
@WebServlet("/ServletLoginController")
public class ServletLoginController extends HttpServlet {

    private static final String JSP_INICIO = "inicio.jsp";
    private static final String JSP_LOGIN="login.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        String accion = request.getParameter("accion");
        System.out.println("entrando a do get");

    }

    private void confirmarLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean entrar;
        System.out.println("entrando a confirmar login");
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        Login login = new Login(user, pass);
        entrar = new LoginDaoImpl().login(login);
        if (entrar) {
            response.sendRedirect(JSP_INICIO);

        } else {
            response.sendRedirect(JSP_LOGIN);
            
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        String accion = request.getParameter("accion");
        System.out.println("entrando a do post");
        if (accion != null) {
            switch (accion) {
                case "login":
                    confirmarLogin(request, response);
                    break;
            }
        }
    }
}
