package gt.dvdyzag.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Clase se encarga de manejar la conexion con la base de datos
 * @author David Y. Gonzalez <a href="mailto:dvdyzag@gmail.com">dvdyzag@gmail.com</a>
 */
public class PostgreSQL {
    private static final String variableConnString;
    public static final String consultaTablas;
    public static final String consultaColumnas;
    static {
        variableConnString = "jdbc:postgresql://%s:%d/%s";
        consultaTablas = "SELECT table_name FROM information_schema.tables WHERE table_schema = 'public';";
        // SELECT column_name FROM information_schema.columns WHERE table_name ='table';
        consultaColumnas = 
                "SELECT column_name, data_type, is_nullable, character_maximum_length as max_length, numeric_precision as precision FROM information_schema.columns WHERE table_name ='%s';";
    }
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
    private static Connection conn;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public PostgreSQL(String url, Integer port, String dbName, String username, String password) {
        this.url = url;
        this.port = port;
        this.dbName = dbName;
        this.username = username;
        this.password = password;
    }
    /**
     * Abre la conexion
     **/
    public void connDB() throws SQLException, ClassNotFoundException{
        Class.forName("org.postgresql.Driver");
        String validUrl = getConnString();
        if (conn != null && !conn.isClosed()) {
            cerrar();
        }
        conn = DriverManager.getConnection(validUrl, this.username, this.password);
    }
    /**
     * Ejecuta sentencias SQL
     * @param query Sentencia SQL
     **/
    public ResultSet runQuery(String query) throws SQLException{
        PreparedStatement ps = conn.prepareStatement(query);
        return ps.executeQuery();
    }
    /**
     * Cierra la conexion
     **/
    public void cerrar(){
        try {
            conn.close();
        } catch (Exception e) {
        }
    }
    /**
     * Devuelve la cadena de conexion, segun los atributos de la clase
     * @return String
     **/
    public String getConnString(){
        return String.format(variableConnString, this.url, this.port, this.dbName);
    }
}
