/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import logic.Pastel;
import logic.Usuario;

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

}

