/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

/**
 *
 * @author chino
 */
public class Carrito {
    private int id_carrito;
    private int id_pastel;
    private int id_user;
    private int cantidad;
    private int precio;
    private String tamanio;
    private int subtotal;
    private String nombrePastel;
      
    public Carrito() {
    }

    public int getId_carrito() {
        return id_carrito;
    }

    public void setId_carrito(int id_carrito) {
        this.id_carrito = id_carrito;
    }

    public int getId_pastel() {
        return id_pastel;
    }

    public void setId_pastel(int id_pastel) {
        this.id_pastel = id_pastel;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getTamanio() {
        return tamanio;
    }

    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }

    public int getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }
    public String getNombrePastel() {
        return nombrePastel;
    }

    public void setNombrePastel(String nombrePastel) {
        this.nombrePastel = nombrePastel;
    }

}
