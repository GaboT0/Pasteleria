/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logic.Controlador;
import logic.Usuario;

@WebServlet(name = "SvUsuarios", urlPatterns = {"/SvUsuarios"})
public class SvUsuarios extends HttpServlet {
    Controlador control = new Controlador();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                List<Usuario> listaUsers = new ArrayList<>();
                listaUsers = control.trearUsuarios();

                HttpSession misesion = request.getSession();
                misesion.setAttribute("listaUsers",listaUsers);

                response.sendRedirect("MostrarUsuarios.jsp");
        processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                String nombre = request.getParameter("user");
                String email = request.getParameter("email");
                String contrasena = request.getParameter("password");

                Usuario usu = new Usuario();
                usu.setNombre(nombre);
                usu.setEmail(email);
                usu.setContrasena(contrasena);
                control.crearUsuario(usu);
    
                response.sendRedirect("signup.jsp");   



        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
