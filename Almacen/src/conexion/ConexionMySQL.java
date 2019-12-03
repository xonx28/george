
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexionMySQL {
    
//Incorporamos la libreria MySQL
    private static String driver = "com.mysql.jdbc.Driver";
//Nombre de la base de datos
    private static String database = "almacen";
//Servidor
    private static String hostname = "127.0.0.1";
//Puerto
    private static String port = "3306";
//Usuario
    private static String username = "root";
    
    private static String password = "12345678";
    
//URL de ConexionMySQL a la Base de datos
    private static String conectionURL;
//Conector
    public static Connection conn;

    
    
    
    public ConexionMySQL()  {
    ConexionMySQL.conectionURL = "jdbc:mysql://"; 
    ConexionMySQL.conectionURL += hostname + ":" + port + "/" + database;
    ConexionMySQL.conectionURL +="? autoReconnect=true&useSSL=false";
    ConexionMySQL.getconnection();
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
