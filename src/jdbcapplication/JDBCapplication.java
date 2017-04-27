/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcapplication;
import java.sql.*;
/**
 *
 * @author ivette
 */
public class JDBCapplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            Class.forName("org.postgresql.Driver");
            System.out.println("Carga exitosa");
            String url= "jdbc:postgresql://localhost/paciente?user=ivette&password=bakatotesto";
            //jdbc:postgresql://localhost/test?user=frend&password=secret
            Connection conn = DriverManager.getConnection(url);
            System.out.println("Conexion realizada");
            Statement st = conn.createStatement();
            st.execute("insert into " + 
                    " alumnos (nombre,apellido,edad)" + 
                    " values ('Ileana','Acosta',15)");
            conn.close();
        } catch (ClassNotFoundException ex){
            System.out.println("Error: controlador!");
            ex.printStackTrace();
            System.exit(1);
        }catch (SQLException ex){
            System.out.println("Error:coneccion");
            ex.printStackTrace();
        }
    }
    
}
