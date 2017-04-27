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
            //coneccion de postgresql.driver (base de datos) 
            Class.forName("org.postgresql.Driver");
            System.out.println("Carga exitosa");
            String url= "jdbc:postgresql://localhost/paciente?user=ivette&password=bakatotesto";
            //jdbc:postgresql://localhost/test?user=frend&password=secret
            Connection conn = DriverManager.getConnection(url);
            System.out.println("Conexion realizada");
            
            //consulta tipo INSERT
            Statement st = conn.createStatement();
            st.execute("insert into " + 
                  " alumnos (nombre,apellido,edad)" + 
                  " values ('Jose Luis','Acosta',15)");
            st.execute("insert into " + 
                  " alumnos (nombre,apellido,edad)" + 
                  " values ('Norma','Vazquez',19)");
            st.execute("insert into " + 
                  " alumnos (nombre,apellido,edad)" + 
                  " values ('Luis','Felix',15)");
            //Consulta tipo DELETE
                // borra un usuario en concreto dentro de la tabla
                //st.execute("DELETE FROM users WHERE idUser='101'");

                // borra todos los usuarios de la tabla
                //st.execute("DELETE FROM users");

               st.execute("delete from ALUMNOS where ID='3'");
              
               
               String sql =
                       "SELECT nombre, apellido FROM alumnos ORDER BY apellido";
                ResultSet resultado = st.executeQuery(sql);
                
                 while(resultado.next()) {
                      String n = resultado.getString("nombre");
                      String a = resultado.getString("apellido");
                      System.out.println(n + " " + a);
                  }
                 
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
