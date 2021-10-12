
package beans;

public class Solucion {
    
    private int id_solucion;
    private String codigo_solucion;
    private String descripcion_solucion;

    public Solucion() {
    }

    public Solucion(int id_problema, String codigo_problema, String descripcion_problema) {
        this.id_solucion = id_problema;
        this.codigo_solucion = codigo_problema;
        this.descripcion_solucion = descripcion_problema;
    }

    public int getId_solucion() {
        return id_solucion;
    }

    public void setId_solucion(int id_solucion) {
        this.id_solucion = id_solucion;
    }

    public String getCodigo_solucion() {
        return codigo_solucion;
    }

    public void setCodigo_solucion(String codigo_solucion) {
        this.codigo_solucion = codigo_solucion;
    }

    public String getDescripcion_solucion() {
        return descripcion_solucion;
    }

    public void setDescripcion_solucion(String descripcion_solucion) {
        this.descripcion_solucion = descripcion_solucion;
    }
 
}
