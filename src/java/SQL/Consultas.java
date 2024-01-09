/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author chino
 */
public class Consultas extends connect{
    public static void main(String[] args) {
        Consultas cons = new Consultas();
        System.out.println(cons.registrarUser("Gab123","gab123@gmail.com", "1234"));
    }
    public String autenticacion(String user,String pass){
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
                String nombre = rs.getString("nombre");
                System.out.println("AUTENTICACION EXITOSA");
                return nombre;
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

}

