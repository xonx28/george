
package clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class conexion {
    
//Incorporamos la libreria MySQL
    private static String driver = "com.mysql.jdbc.Driver";
//Nombre de la base de datos
    private static String database = "trasefor";
//Servidor
    private static String hostname = "localhost";
//Puerto
    private static String port = "3306";
//Usuario
    private static String username = "root";
    
    private static String password = "12345678";
    
//URL de conexion a la Base de datos
    private static String conectionURL;
//Conector
    public static Connection conn;

    
    
    
    public conexion()  {
    conexion.conectionURL = "jdbc:mysql://"; 
    conexion.conectionURL += hostname + ":" + port + "/" + database;
    conexion.conectionURL +="? autoReconnect=true&useSSL=false";
    conexion.getconnection();
    }
    
    
    
    public static Connection getconnection() {
        try {
            Class.forName(driver);
            try {
                 conn = DriverManager.getConnection(conectionURL,username,password);
            } catch(SQLException ex){
                 System.out.println("Error al crear con conector: " + ex.getMessage());
            } 
        }catch(ClassNotFoundException ex){

        }
        return conn;
    }
 }
