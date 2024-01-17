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
                if(request.getParameter("idPastel") != null && request.getParameter("tamanio")!= null && request.getParameter("cantidad") != null){
                    Object us = misesion.getAttribute("idUser");
                    Pastel past = (Pastel) misesion.getAttribute("pastel");
                    System.out.println(Integer.parseInt(us.toString()));
                    int idPastel = Integer.parseInt(request.getParameter("idPastel"));
                    System.out.println("idPastel:" + idPastel);
                    int tamanio = Integer.parseInt(request.getParameter("tamanio"));
                    System.out.println("tamanio" + tamanio);
                    String tamString = "null";
                    Pastel p = cons.getPastelById(idPastel);
                    cons = new Consultas();
                    if(p.getStock() != 0){
                        int cantidad = Integer.parseInt(request.getParameter("cantidad"));
                        int stk = p.getStock()- cantidad;
                        System.out.println("STOCK:" +stk);
                        if(stk >= 0){
                            if(tamanio == 300)
                                tamString = "Chico";
                            if(tamanio == 500)
                                tamString = "Mediano";
                            if(tamanio == 800)
                                tamString = "Grande";
                            System.out.println(tamString);

                            int subtotal = tamanio * cantidad;
                            System.out.println(""+tamanio+" "+cantidad +" "+subtotal);
                            Carrito compra = new Carrito();
                            compra.setId_pastel(idPastel);
                            compra.setId_user(Integer.parseInt(us.toString()));
                            compra.setCantidad(cantidad);
                            compra.setPrecio(tamanio);
                            compra.setTamanio(tamString);
                            compra.setSubtotal(subtotal);
                            compra.setNombrePastel(past.getNombre());
                            List<Carrito> carritos = new ArrayList<>();
                            if(misesion.getAttribute("carrito") != null){
                                carritos = (List<Carrito>) misesion.getAttribute("carrito"); 
                                carritos.add(compra);
                                misesion.setAttribute("carrito", carritos);
                                boolean edit = cons.modStock(idPastel, stk);
                                System.out.println("STOCK MOD? " + edit);
                                response.sendRedirect("carrito.jsp");
                            }else{
                                carritos.add(compra);
                                misesion.setAttribute("carrito", carritos);
                                boolean edit = cons.modStock(idPastel, stk);
                                System.out.println("STOCK MOD? " + edit);
                                response.sendRedirect("carrito.jsp");
                            }
                        }else{
                            response.sendRedirect("menu.jsp?stock=1");
                        }   
                    }else{
                        response.sendRedirect("menu.jsp?stock=1");
                    }
                }else{
                    response.sendRedirect("menu.jsp?stock=2");
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
                    int idPa = Integer.parseInt(request.getParameter("idPastel"));
                    int cant = Integer.parseInt(request.getParameter("cant"));
                    Pastel pquitar = cons.getPastelById(idPa);
                    int devolver = pquitar.getStock() + cant;
                    cons = new Consultas();
                    System.out.println("Index " + index);
                    carritos.remove(index);
                    misesion.setAttribute("carrito", carritos);
                    System.out.println(cons.modStock(idPa, devolver));
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
                    misesion.setAttribute("indexEditar",index); 
                    misesion.setAttribute("compra",compra);   
                    response.sendRedirect("editarProducto.jsp");
                }
            break;
            case "editarCarrito":
                if(request.getSession().getAttribute("compra") != null){
                    Carrito pastelAnterior = (Carrito) misesion.getAttribute("compra");
                    int cantidadAnterior = pastelAnterior.getCantidad();
                    int idPastel = Integer.parseInt(request.getParameter("idPastel"));
                    int indx = Integer.parseInt(request.getParameter("index"));
                    Pastel peditar = cons.getPastelById(idPastel);
                    misesion.setAttribute("pastelEdit", peditar);
                    cons = new Consultas();
                    int stockActual = peditar.getStock();
                    int tamanio = Integer.parseInt(request.getParameter("tamanio"));
                    int cantidad = Integer.parseInt(request.getParameter("cantidad"));
                    int diferencia = 0;
                    int newStock = 0;
                    if(cantidadAnterior < cantidad){//Si la cantidad anterior es menor se resta la diferencia a la BD
                        diferencia = cantidad - cantidadAnterior;
                        newStock = stockActual - diferencia;
                    }
                    if(cantidadAnterior > cantidad){//Si la cantidad anterior es mayor se añade la diferencia a la BD
                        diferencia = cantidad - cantidadAnterior;
                        newStock = stockActual - diferencia;
                    }
                    if(cantidadAnterior == cantidad){//Si es igual, no hay se hacen cambios en la BD
                        diferencia = 0;
                        newStock = stockActual;
                    }
                    if(newStock >= 0){
                        String tamString = "";
                        if(tamanio == 300)
                            tamString = "Chico";
                        if(tamanio == 500)
                            tamString = "Mediano";
                        if(tamanio == 800)
                            tamString = "Grande";
                        int subtotal = cantidad * tamanio;
                        Object us = misesion.getAttribute("idUser");
                        List<Carrito> carritos = new ArrayList<>();
                        carritos = (List<Carrito>) misesion.getAttribute("carrito");
                        carritos.remove(indx);
                        Carrito pastelNuevo = new Carrito();
                        pastelNuevo.setId_pastel(idPastel);
                        pastelNuevo.setId_user(Integer.parseInt(us.toString()));
                        pastelNuevo.setCantidad(cantidad);
                        pastelNuevo.setNombrePastel(peditar.getNombre());
                        pastelNuevo.setPrecio(tamanio);
                        pastelNuevo.setSubtotal(subtotal);
                        pastelNuevo.setTamanio(tamString);

                        carritos.add(pastelNuevo);
                        misesion.setAttribute("carrito", carritos);
                        System.out.println(cons.modStock(idPastel, newStock));
                        response.sendRedirect("SvPasteles?id=irCarrito");
                    }else{
                        response.sendRedirect("carrito.jsp?stock=1");
                    }
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
        
        processRequest(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
