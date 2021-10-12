
package beans;

public class Usuario {
    
    private int id_usuario;
    private String nombres_usuario;
    private String apellidos_usuario;
    private String correo_usuario;
    private int telefono_usuario;
    private String codigo_usuario;
    private String contra_usuario;
    private int tipo_usuario;
    private int estado_usuario;

    public Usuario() {
    }

    public Usuario(String nombres_usuario, String apellidos_usuario, String correo_usuario, int telefono_usuario, String codigo_usuario, String contra_usuario, int tipo_usuario, int estado_usuario) {
        this.nombres_usuario = nombres_usuario;
        this.apellidos_usuario = apellidos_usuario;
        this.correo_usuario = correo_usuario;
        this.telefono_usuario = telefono_usuario;
        this.codigo_usuario = codigo_usuario;
        this.contra_usuario = contra_usuario;
        this.tipo_usuario = tipo_usuario;
        this.estado_usuario = estado_usuario;
    }

    public Usuario(int id_usuario, String nombres_usuario, String apellidos_usuario, String correo_usuario, int telefono_usuario, String codigo_usuario, String contra_usuario, int tipo_usuario, int estado_usuario) {
        this.id_usuario = id_usuario;
        this.nombres_usuario = nombres_usuario;
        this.apellidos_usuario = apellidos_usuario;
        this.correo_usuario = correo_usuario;
        this.telefono_usuario = telefono_usuario;
        this.codigo_usuario = codigo_usuario;
        this.contra_usuario = contra_usuario;
        this.tipo_usuario = tipo_usuario;
        this.estado_usuario = estado_usuario;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombres_usuario() {
        return nombres_usuario;
    }

    public void setNombres_usuario(String nombres_usuario) {
        this.nombres_usuario = nombres_usuario;
    }

    public String getApellidos_usuario() {
        return apellidos_usuario;
    }

    public void setApellidos_usuario(String apellidos_usuario) {
        this.apellidos_usuario = apellidos_usuario;
    }

    public String getCorreo_usuario() {
        return correo_usuario;
    }

    public void setCorreo_usuario(String correo_usuario) {
        this.correo_usuario = correo_usuario;
    }

    public int getTelefono_usuario() {
        return telefono_usuario;
    }

    public void setTelefono_usuario(int telefono_usuario) {
        this.telefono_usuario = telefono_usuario;
    }

    public String getCodigo_usuario() {
        return codigo_usuario;
    }

    public void setCodigo_usuario(String codigo_usuario) {
        this.codigo_usuario = codigo_usuario;
    }

    public String getContra_usuario() {
        return contra_usuario;
    }

    public void setContra_usuario(String contra_usuario) {
        this.contra_usuario = contra_usuario;
    }

    public int getTipo_usuario() {
        return tipo_usuario;
    }

    public void setTipo_usuario(int tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }

    public int getEstado_usuario() {
        return estado_usuario;
    }

    public void setEstado_usuario(int estado_usuario) {
        this.estado_usuario = estado_usuario;
    }
    
}
