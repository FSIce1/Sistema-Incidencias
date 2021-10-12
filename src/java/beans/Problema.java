
package beans;

public class Problema {
    
    private int id_problema;
    private String codigo_problema;
    private int prioridad_problema;
    private String descripcion_problema;

    public Problema() {
    }

    public Problema(int id_problema, String codigo_problema, int prioridad_problema, String descripcion_problema) {
        this.id_problema = id_problema;
        this.codigo_problema = codigo_problema;
        this.prioridad_problema = prioridad_problema;
        this.descripcion_problema = descripcion_problema;
    }
    
    public int getId_problema() {
        return id_problema;
    }

    public void setId_problema(int id_problema) {
        this.id_problema = id_problema;
    }

    public String getCodigo_problema() {
        return codigo_problema;
    }

    public void setCodigo_problema(String codigo_problema) {
        this.codigo_problema = codigo_problema;
    }

    public String getDescripcion_problema() {
        return descripcion_problema;
    }

    public void setDescripcion_problema(String descripcion_problema) {
        this.descripcion_problema = descripcion_problema;
    }

    public int getPrioridad_problema() {
        return prioridad_problema;
    }

    public void setPrioridad_problema(int prioridad_problema) {
        this.prioridad_problema = prioridad_problema;
    }
 
}
