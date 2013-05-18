package gt.dvdyzag.db.objetos;

import gt.dvdyzag.db.PostgreSQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 * 
 * @author David
 */
public class Tabla {
    /*nombre de una tabla dentro de una BD**/
    private String nombre;
    /**objeto de la conexión con Sist. BD**/
    private PostgreSQL psql;
    /**Consulta de las columnas dentro de tabla especificado**/
    private ResultSet rs;
    /**
     * @param nombre
     * @param psql
     */
    public Tabla(String nombre, PostgreSQL psql) throws SQLException{
        this.nombre = nombre;
        this.psql = psql;
        rs = this.psql.runQuery(String.format(PostgreSQL.consultaColumnas, this.nombre));
    }

    /**
     * @return ResultSet
     */
    public ResultSet getRs() {
        return rs;
    }
    

    @Override
    public String toString() {
        return nombre;
    }
    
}
