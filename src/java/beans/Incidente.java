
package beans;

import java.util.Date;

public class Incidente {
    
    private int id_incidente;
    private String codigo_incidente;
    private String descripcion_incidente;
    private Date fecha_incidente;
    private int estado_incidente;
    private int calificacion_incidente;
    private int id_usuario_fk;
    private Usuario oUsuario;
    
    

    public Incidente() {
    }

    public Incidente(int id_incidente, String codigo_incidente, int estado_incidente, int calificacion_incidente, int id_usuario_fk) {
        this.id_incidente = id_incidente;
        this.codigo_incidente = codigo_incidente;
        this.estado_incidente = estado_incidente;
        this.calificacion_incidente = calificacion_incidente;
        this.id_usuario_fk = id_usuario_fk;
    }

    public Incidente(String codigo_incidente, int estado_incidente, int calificacion_incidente, int id_usuario_fk) {
        
        this.codigo_incidente = codigo_incidente;
        this.estado_incidente = estado_incidente;
        this.calificacion_incidente = calificacion_incidente;
        this.id_usuario_fk = id_usuario_fk;
    }
    
    public Incidente(int id_incidente, String codigo_incidente, Date fecha_incidente, int estado_incidente, int calificacion_incidente, int id_usuario_fk) {
        this.id_incidente = id_incidente;
        this.codigo_incidente = codigo_incidente;
        this.fecha_incidente = fecha_incidente;
        this.estado_incidente = estado_incidente;
        this.calificacion_incidente = calificacion_incidente;
        this.id_usuario_fk = id_usuario_fk;
    }

    public Incidente(int id_incidente, String codigo_incidente, Date fecha_incidente, int estado_incidente, int calificacion_incidente, Usuario oUsuario) {
        this.id_incidente = id_incidente;
        this.codigo_incidente = codigo_incidente;
        this.fecha_incidente = fecha_incidente;
        this.estado_incidente = estado_incidente;
        this.calificacion_incidente = calificacion_incidente;
        this.oUsuario = oUsuario;
    }

    public String getDescripcion_incidente() {
        return descripcion_incidente;
    }

    public void setDescripcion_incidente(String descripcion_incidente) {
        this.descripcion_incidente = descripcion_incidente;
    }

    public int getId_incidente() {
        return id_incidente;
    }

    public void setId_incidente(int id_incidente) {
        this.id_incidente = id_incidente;
    }

    public String getCodigo_incidente() {
        return codigo_incidente;
    }

    public void setCodigo_incidente(String codigo_incidente) {
        this.codigo_incidente = codigo_incidente;
    }

    public Date getFecha_incidente() {
        return fecha_incidente;
    }

    public void setFecha_incidente(Date fecha_incidente) {
        this.fecha_incidente = fecha_incidente;
    }

    public int getEstado_incidente() {
        return estado_incidente;
    }

    public void setEstado_incidente(int estado_incidente) {
        this.estado_incidente = estado_incidente;
    }

    

    public int getCalificacion_incidente() {
        return calificacion_incidente;
    }

    public void setCalificacion_incidente(int calificacion_incidente) {
        this.calificacion_incidente = calificacion_incidente;
    }

    public int getId_usuario_fk() {
        return id_usuario_fk;
    }

    public void setId_usuario_fk(int id_usuario_fk) {
        this.id_usuario_fk = id_usuario_fk;
    }

    public Usuario getoUsuario() {
        return oUsuario;
    }

    public void setoUsuario(Usuario oUsuario) {
        this.oUsuario = oUsuario;
    }
    
}
