/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;


public class Pastel {
    private int id_pastel;
    private String nombre;
    private int stock;

    public Pastel(int id_pastel, String nombre, int stock) {
        this.id_pastel = id_pastel;
        this.nombre = nombre;
        this.stock = stock;
    }
    public Pastel() {
        
    }

    public int getId_pastel() {
        return id_pastel;
    }

    public void setId_pastel(int id_pastel) {
        this.id_pastel = id_pastel;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

   

   


}
