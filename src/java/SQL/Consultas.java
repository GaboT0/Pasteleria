/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import logic.Carrito;
import logic.Direccion;
import logic.Pastel;
import logic.Usuario;
import logic.Historial;

/**
 *
 * @author chino
 */
public class Consultas extends connect{
    public static void main(String[] args) {
        //Consultas cons = new Consultas();
        //System.out.println(cons.getPastelById(5).getNombre());
    }
    public Usuario autenticacion(String user,String pass){
        PreparedStatement pst = null;
        ResultSet rs = null;
        try{
            String consulta = "SELECT * FROM usuario where (nombre = ? OR email = ?) AND contrasena = ?";
            pst = getConexion().prepareStatement(consulta);
            pst.setString(1, user);
            pst.setString(2, user);
            pst.setString(3, pass);
            rs = pst.executeQuery();

            if(rs.absolute(1)){
                Usuario usuario = new Usuario();
                usuario.setId_user(rs.getInt("id_user"));  
                usuario.setNombre(rs.getString("nombre"));
                System.out.println("AUTENTICACION EXITOSA");
                return usuario;
            }

        }catch(Exception e){
            System.out.println("ERROR: "+ e);
        }finally{
            try{
                if(getConexion() != null){
                    getConexion().close();
                }
                if(pst != null){
                    pst.close();
                }
                if(rs != null){
                    rs.close();
                }
            }catch(Exception e){
                System.out.println("ERROR:CONEXION: ");
            }
        }



        return null;
    }

    public boolean registrarUser(String user, String email, String pass){
        PreparedStatement pst = null;
         try{
                    String consulta = "INSERT INTO USUARIO (nombre, email, contrasena) VALUES (?,?,?);";
                    pst = getConexion().prepareStatement(consulta);
                    pst.setString(1, user);
                    pst.setString(2, email);
                    pst.setString(3, pass);

                    if(pst.executeUpdate() == 1){
                        System.out.println("REGISTRO EXITOSO");
                        return true;
                    }

                }catch(Exception e){
                    System.out.println("ERROR: "+e);
                }finally{
                    try{
                        if(getConexion() != null){
                            getConexion().close();
                        }
                        if(pst != null){
                            pst.close();
                        }
                    }catch(Exception e){
                        System.out.println("ERROR:CONEXION: ");
                    }
                }
        return false;
    }

    public List<Pastel> getAllPasteles(){
        List<Pastel> pasteles = new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try{
            String consulta = "SELECT * FROM pasteles";
            pst = getConexion().prepareStatement(consulta);
            rs = pst.executeQuery();
           while(rs.next()){
                Pastel p = new Pastel();
                p.setId_pastel(rs.getInt("id_pastel"));
                p.setNombre(rs.getString("nombre"));
                p.setStock(rs.getInt("stock"));
                pasteles.add(p);
            }
            return pasteles;

        }catch(Exception e){
            System.out.println("ERROR: "+ e);
        }finally{
            try{
                if(getConexion() != null){
                    getConexion().close();
                }
                if(pst != null){
                    pst.close();
                }
                if(rs != null){
                    rs.close();
                }
            }catch(Exception e){
                System.out.println("ERROR:CONEXION: ");
            }
        }

        return null;
    }
    public Pastel getPastelById(int idPastel){
        Pastel p = new Pastel();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try{
            String consulta = "SELECT * FROM pasteles WHERE id_pastel = ?";
            pst = getConexion().prepareStatement(consulta);
            pst.setInt(1, idPastel);
            
            rs = pst.executeQuery();

            if(rs.absolute(1)){
                p.setId_pastel(rs.getInt("id_pastel"));
                p.setNombre(rs.getString("nombre")); 
                p.setStock(rs.getInt("stock")); 
                return p;
            }else{
                return null;
            }

        }catch(Exception e){
            System.out.println("ERROR: "+ e);
        }finally{
            try{
                if(getConexion() != null){
                    getConexion().close();
                }
                if(pst != null){
                    pst.close();
                }
                if(rs != null){
                    rs.close();
                }
            }catch(Exception e){
                System.out.println("ERROR:CONEXION: ");
            }
        }
        return null;
    }

    public boolean modStock(int idPastel,int newStock){
        PreparedStatement pst = null;
         try{
                    String consulta = "UPDATE pasteles SET stock = ? WHERE id_pastel = ?";
                    pst = getConexion().prepareStatement(consulta);
                    pst.setInt(1, newStock);
                    pst.setInt(2, idPastel);
                    

                    if(pst.executeUpdate() == 1){
                        System.out.println("REGISTRO EXITOSO");
                        return true;
                    }

                }catch(Exception e){
                    System.out.println("ERROR: "+e);
                }finally{
                    try{
                        if(getConexion() != null){
                            getConexion().close();
                        }
                        if(pst != null){
                            pst.close();
                        }
                    }catch(Exception e){
                        System.out.println("ERROR:CONEXION: ");
                    }
                }
        return false;
    }

    public boolean realizarCompra(List<Carrito> carrito, Direccion dir,int total){
        PreparedStatement pst = null;
         try{
                    String consulta = "INSERT INTO carrito (id_pastel,id_user,cantidad,precio,tamanio,subtotal,total,nombre,calle,numExt,numInt,colonia,delegacion,cp,metodo_pago) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

                    for(Carrito carr : carrito){
                        pst = getConexion().prepareStatement(consulta);
                        pst.setInt(1, carr.getId_pastel());
                        pst.setInt(2, carr.getId_user());
                        pst.setInt(3, carr.getCantidad());
                        pst.setInt(4, carr.getPrecio());
                        pst.setString(5, carr.getTamanio());
                        pst.setInt(6, carr.getSubtotal());
                        pst.setInt(7, total);
                        pst.setString(8, dir.getNombre());
                        pst.setString(9, dir.getCalle());
                        pst.setInt(10, dir.getNumExt());
                        pst.setInt(11, dir.getNumInt());
                        pst.setString(12, dir.getColonia());
                        pst.setString(13, dir.getDelegacion());
                        pst.setInt(14, dir.getCp());
                        pst.setString(15, dir.getMetodo_pago());


                        if(pst.executeUpdate() == 1){
                            System.out.println("REGISTRO EXITOSO");

                        }
                        pst = null;
                    }
                    return true;
                }catch(Exception e){
                    System.out.println("ERROR: "+e);
                }finally{
                    try{
                        if(getConexion() != null){
                            getConexion().close();
                        }
                        if(pst != null){
                            pst.close();
                        }
                    }catch(Exception e){
                        System.out.println("ERROR:CONEXION: ");
                    }
                }
        return false;
    }

    public List<Historial> getHistorial(int idUser){
        List<Historial> historial = new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try{
            String consulta = "SELECT c.id_pastel,p.nombre AS nombre_pastel,c.cantidad,c.precio,c.tamanio,c.subtotal,c.total,c.nombre,c.calle,c.numExt,c.numInt,c.colonia,c.delegacion,c.cp,c.metodo_pago FROM carrito c JOIN pasteles p ON (c.id_pastel = p.id_pastel) where c.id_user = ?";
            pst = getConexion().prepareStatement(consulta);
            pst.setInt(1, idUser);
            rs = pst.executeQuery();

           while(rs.next()){
                Historial h = new Historial();
                h.setId_pastel(rs.getInt("id_pastel"));
                h.setNombrePastel(rs.getString("nombre_pastel"));
                h.setCantidad(rs.getInt("cantidad"));
                h.setPrecio(rs.getInt("precio"));
                h.setTamanio(rs.getString("tamanio"));
                h.setSubtotal(rs.getInt("subtotal"));
                h.setTotal(rs.getInt("total"));
                h.setNombre(rs.getString("nombre"));
                h.setCalle(rs.getString("calle"));
                h.setNumExt(rs.getInt("numExt"));
                h.setNumInt(rs.getInt("numInt"));
                h.setColonia(rs.getString("colonia"));
                h.setDelegacion(rs.getString("delegacion"));
                h.setCp(rs.getInt("cp"));
                h.setMetodo_pago(rs.getString("metodo_pago"));
                
                historial.add(h);
            }
            return historial;

        }catch(Exception e){
            System.out.println("ERROR: "+ e);
        }finally{
            try{
                if(getConexion() != null){
                    getConexion().close();
                }
                if(pst != null){
                    pst.close();
                }
                if(rs != null){
                    rs.close();
                }
            }catch(Exception e){
                System.out.println("ERROR:CONEXION: ");
            }
        }

        return null;
    }
}

