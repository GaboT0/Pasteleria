/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import SQL.Consultas;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logic.Carrito;
import logic.Pastel;

public class SvPasteles extends HttpServlet {

 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        Consultas cons = new Consultas();
        System.out.println(request.getParameter("id"));
        HttpSession misesion = request.getSession();
        List<Pastel> pasteles = new ArrayList<>();
        
        switch (request.getParameter("id")){
            case "menu":
                pasteles = cons.getAllPasteles();
                misesion.setAttribute("pasteles",pasteles);
                response.sendRedirect("menu.jsp");
            break;

            case "anadirCarro":
                Object us = misesion.getAttribute("idUser");
                Pastel past = (Pastel) misesion.getAttribute("pastel");
                System.out.println(Integer.parseInt(us.toString()));
                int idPastel = Integer.parseInt(request.getParameter("idPastel"));
                System.out.println("idPastel:" + idPastel);
                int tamanio = Integer.parseInt(request.getParameter("tamanio"));
                System.out.println("tamanio" + tamanio);
                String tamString = "null";
                Pastel p = cons.getPastelById(idPastel);
                if(p.getStock() != 0){
                    if(tamanio == 300)
                        tamString = "Chico";
                    if(tamanio == 500)
                        tamString = "Mediano";
                    if(tamanio == 800)
                        tamString = "Grande";
                    System.out.println(tamString);
                    String cantidad = request.getParameter("cantidad");
                    int subtotal = tamanio * Integer.parseInt(cantidad);
                    System.out.println(""+tamanio+" "+cantidad +" "+subtotal);
                    Carrito compra = new Carrito();
                    compra.setId_pastel(idPastel);
                    compra.setId_user(Integer.parseInt(us.toString()));
                    compra.setCantidad(Integer.parseInt(cantidad));
                    compra.setPrecio(tamanio);
                    compra.setTamanio(tamString);
                    compra.setSubtotal(subtotal);
                    compra.setNombrePastel(past.getNombre());
                    List<Carrito> carritos = new ArrayList<>();
                    if(misesion.getAttribute("carrito") != null){
                        carritos = (List<Carrito>) misesion.getAttribute("carrito"); 
                        carritos.add(compra);
                        misesion.setAttribute("carrito", carritos);
                        response.sendRedirect("carrito.jsp");
                    }else{
                        carritos.add(compra);
                        misesion.setAttribute("carrito", carritos);
                        response.sendRedirect("carrito.jsp");
                    }
                    
                }else{
                    response.sendRedirect("menu.jsp?stock=1");
                }
                
            break;
            case "irCarrito": 
                    if(misesion.getAttribute("carrito") != null){
                        List<Carrito> carritos = new ArrayList<>();
                        carritos = (List<Carrito>) misesion.getAttribute("carrito"); 
                        misesion.setAttribute("carrito", carritos);
                        response.sendRedirect("carrito.jsp");
                    }else{
                        List<Carrito> carritos = new ArrayList<>();
                        misesion.setAttribute("carrito", carritos);
                        response.sendRedirect("carrito.jsp");
                    }
            break;
            case "quitarCarrito":
                if(misesion.getAttribute("carrito") != null){
                    Carrito compra = new Carrito();
                    List<Carrito> carritos = new ArrayList<>();
                    carritos = (List<Carrito>) misesion.getAttribute("carrito");
                    int index = Integer.parseInt(request.getParameter("index"));
                    System.out.println("Index " + index);
                    carritos.remove(index);
                    misesion.setAttribute("carrito", carritos);
                    response.sendRedirect("carrito.jsp");
                }
            break;
            case "irEditar":
                if(misesion.getAttribute("carrito") != null){
                    Carrito compra = new Carrito();
                    List<Carrito> carritos = new ArrayList<>();
                    carritos = (List<Carrito>) misesion.getAttribute("carrito");
                    int index = Integer.parseInt(request.getParameter("index"));
                    System.out.println("Index " + index);
                    compra = carritos.get(index);
                    
                    misesion.setAttribute("compra",compra);   
                    response.sendRedirect("editarProducto.jsp");
                }
            break;
            default:
                int id = Integer.parseInt(request.getParameter("id"));
                Pastel pastel = new Pastel();
                pastel = cons.getPastelById(id);
                misesion.setAttribute("pastel",pastel);   
                response.sendRedirect("producto.jsp");
                
            break;

        }
        
    }

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 



        processRequest(request, response);
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        Consultas cons = new Consultas();
//        String tamanio = request.getParameter("tamanio");
//        String cantidad = request.getParameter("cantidad"); 
//        String subtotal = request.getParameter("total"); 
//        System.out.println(""+tamanio+" "+cantidad +" "+subtotal);
        
        processRequest(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
