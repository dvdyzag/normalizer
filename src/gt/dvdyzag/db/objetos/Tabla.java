package gt.dvdyzag.db.objetos;

/**
 * 
 * @author David
 */
public class Tabla {
    private String nombre;
    public Tabla(String nombre){
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
}
