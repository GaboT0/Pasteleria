package SQL;

import java.sql.Connection;
import java.sql.DriverManager;

public class connect {
    Connection conn = null;
    String driver = "com.mysql.jdbc.Driver";

    public connect(){
        try{
            Class.forName(driver);
            System.out.println("Driver cargado con exito");
            try{
                   conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pasteleria?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "1234");
                    if(conn!=null){
                        System.out.println("Conexion realizada con exito");
                    }
            }catch(Exception e){
                System.out.println("Error al intentar conectar la base de datos");
            } 
        }catch(Exception e){
            System.out.println("Ha ocurrido un error al cargar el driver" + e.getMessage());
        }  
    }

    public Connection getConexion(){
        return conn;
    }
}