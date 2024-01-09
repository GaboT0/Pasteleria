/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import SQL.Consultas;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author chino
 */
public class SvLogin extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();   
                        //out.println("<!DOCTYPE html>");
           


    }

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String user = request.getParameter("user");
        String pass = request.getParameter("password");  
        Consultas cons = new Consultas();
        String userResp = cons.autenticacion(user, pass);
        if(userResp != null){
            response.sendRedirect("index.jsp"); 
                HttpSession misesion = request.getSession();
                misesion.setAttribute("nombreUser",userResp); 
        }else{
            response.sendRedirect("login.jsp");
        }
 

        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String user = request.getParameter("user");
        String email = request.getParameter("email");
        String pass = request.getParameter("password");

        Consultas cons = new Consultas();
        
        if(cons.registrarUser(user, email, pass)){
            response.sendRedirect("login.jsp");
        }else{
            response.sendRedirect("signup.jsp");
        }

        processRequest(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
