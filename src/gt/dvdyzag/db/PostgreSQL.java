package gt.dvdyzag.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase se encarga de manejar la conexion con la base de datos
 * @author David Y. Gonzalez <a href="mailto:dvdyzag@gmail.com">dvdyzag@gmail.com</a>
 */
public class PostgreSQL {
    private static String variableConnString;
    /**Url de la ubicacion servidor PostgreSQL**/
    private String url;
    /**Numero de puerto. Suele ser 5432**/
    private Integer port;
    /**Nombre de la base de datos**/
    private String dbName;
    /**Nombre de usuario**/
    private String username;
    /**Contraseña del usuario**/
    private String password;
    
    /**Guarda la sesion de conexion**/
    private static Connection conexion;
    private static Connection conn;
    static {
        variableConnString = "jdbc:postgresql://%s:%d/%s";
    }

    public PostgreSQL(String url, Integer port, String dbName, String username, String password) {
        this.url = url;
        this.port = port;
        this.dbName = dbName;
        this.username = username;
        this.password = password;
    }
    
    public void connDB() throws SQLException{
        try {
            Class.forName("org.postgresql.Driver");
            String validUrl = String.format(variableConnString, this.url, this.port, this.dbName);
            if (!conn.isClosed()){
                cerrar();
            }
            conn = DriverManager.getConnection(validUrl, this.username, this.password);
            System.out.println("Conexion exitosa!");
        } catch (ClassNotFoundException e) {
            //driver no encontrado
        }
    }
    public void cerrar(){
        try {
            conn.close();
        } catch (Exception e) {
        }
    }
    public static void conexionDB(PostgreSQL pBean) throws SQLException{
        try {
            Class.forName("org.postgresql.Driver");
            String fullUrl = String.format(variableConnString, pBean.url, pBean.port, pBean.dbName);
            conexion = DriverManager.getConnection(fullUrl, pBean.username, pBean.password);
            if (conexion != null){
                System.out.println("Conexion exitosa!");
            }
            
        } catch (ClassNotFoundException e) {
        }
    }
}
