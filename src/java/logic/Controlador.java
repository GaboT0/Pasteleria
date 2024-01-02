/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import java.util.List;
import persistencia.ControladorPersistencia;

/**
 *
 * @author chino
 */
public class Controlador {
    ControladorPersistencia controlPers = new ControladorPersistencia();

    public void crearUsuario (Usuario usu){
        controlPers.crearUsuario(usu);
    }

    public List<Usuario> trearUsuarios(){
        return controlPers.traerUsuario();
    }
}
